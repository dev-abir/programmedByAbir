package main

import "fmt"

const (
	CROSS  uint8 = 5
	CIRCLE uint8 = 6
	BLANK  uint8 = 7

	COMPUTER_SYMBOL uint8 = CROSS
	HUMAN_SYMBOL    uint8 = CIRCLE
)

type Player struct {
	playerName      string
	playerSymbol    uint8
	alternatePlayer *Player
}

var playerComputer Player = Player{"Computer", COMPUTER_SYMBOL, nil}
var playerHuman Player = Player{"Human", HUMAN_SYMBOL, &playerComputer}

type Board [9][9]uint8

type Coordinate struct {
	x uint8
	y uint8
}

type Turn struct {
	player            Player
	turnCoordinate    Coordinate
	currentBoardState *Board
	nextTurns         []Turn
}

var totalNumberOfTurnsPossible int = factorial(9)

var numberOfTurnComputationCompleted int = 0

func factorial(x int) int {
    if x == 1 {
        return 1
    } else {
        return x * factorial(x - 1)
    }
}

func createBlankBoard(x int, y int, turnPlayer Player) *Board {
	//TODO : Check if the third arguiment is not CROSS or CIRCLE

	var result Board

	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			result[i][j] = BLANK
			numberOfTurnComputationCompleted++
		}
	}

	result[x][y] = turnPlayer.playerSymbol

	return &result
}

func createInitialTurnsArray(turnsArray *[9 * 9]Turn) {

	var allPossibleTurnCoordinates []Coordinate = make([]Coordinate, (9 * 9))

	var x int = 0

	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			allPossibleTurnCoordinates[x] = Coordinate{uint8(i), uint8(j)}
			x++
		}
	}

	x = 0

	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			var currentBoardState *Board = createBlankBoard(i, j, playerComputer)
			(*turnsArray)[x] = Turn{playerComputer, Coordinate{uint8(i), uint8(j)}, currentBoardState, createTurns(playerComputer, currentBoardState, removeElementFromCoordinateSlice(allPossibleTurnCoordinates, x))}
			x++
		}
	}

	//x = 0

}

func createTurns(turnPlayer Player, currentBoardState *Board, allPossibleTurnCoordinates []Coordinate) []Turn {
    
    fmt.Println("Progress : ", float64((float64(numberOfTurnComputationCompleted) / float64(totalNumberOfTurnsPossible)) * float64(100.0)), "%")

	/*fmt.Println("Player is : ", turnPlayer.playerName)
	fmt.Println("All possible turn coordinates : ", allPossibleTurnCoordinates)*/

	if len(allPossibleTurnCoordinates) == 0 {
        numberOfTurnComputationCompleted++;
		return nil
	} else {
		var possibleTurns []Turn = make([]Turn, len(allPossibleTurnCoordinates))
		for i, coordinate := range allPossibleTurnCoordinates {
			fmt.Println("Working on coordinate : ", coordinate, "\tPlayer : ", turnPlayer.playerName)
			var currentBoard Board = *currentBoardState
			currentBoard[coordinate.x][coordinate.y] = turnPlayer.alternatePlayer.playerSymbol
			possibleTurns[i] = Turn{*turnPlayer.alternatePlayer, coordinate, &currentBoard, createTurns(*turnPlayer.alternatePlayer, &currentBoard, removeElementFromCoordinateSlice(allPossibleTurnCoordinates, i))}
		}
		/*fmt.Println(possibleTurns)
		fmt.Println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")*/
        numberOfTurnComputationCompleted++
		return possibleTurns
	}
}

func removeElementFromCoordinateSlice(slice []Coordinate, index int) []Coordinate {
	slice[index] = slice[len(slice)-1]
	return slice[:len(slice)-1]
}

func main() {
	playerComputer.alternatePlayer = &playerHuman

	var firstTurns [9 * 9]Turn

	createInitialTurnsArray(&firstTurns)

	fmt.Println(firstTurns, "\n\n\n")

	fmt.Println(firstTurns[3].currentBoardState)

	fmt.Println("\n\n\n")

	fmt.Println(len(firstTurns[3].nextTurns))

	fmt.Printf("%v", firstTurns)
}
