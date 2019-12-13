package sudoku_solver;

public class blankManager {

	String sudoku_board[][] = new String[9][9];
	int l = 9;

	blankManager(String the_sudoku_board[][]) {
		sudoku_board = the_sudoku_board;
	}

	int[] getUpArray(int row_position, int column_position) {

		int i, j;
		int total_number_of_elements_above = column_position - 1;
		int total_number_of_non_blank_elements_above = total_number_of_elements_above;

		for (i = 0; i < row_position; i++) {
			if (sudoku_board[i][column_position].equals("-")) {
				total_number_of_non_blank_elements_above = total_number_of_non_blank_elements_above - 1;
			}
		}

		int ar[] = new int[total_number_of_non_blank_elements_above];

		for (i = 0; i < row_position; i++) {
			if (!(sudoku_board[i][column_position].equals("-"))) {
				ar[i] = Integer.valueOf(sudoku_board[i][column_position]);
			}
		}
		return ar;
	}

	int[] getDownArray(int row_position, int column_position) {

		int i, j;
		int total_number_of_elements_below = l - (row_position + 1);
		int total_number_of_non_blank_elements_below = total_number_of_elements_below;

		for (i = (row_position + 1); i < l; i++) {
			if (sudoku_board[i][column_position].equals("-")) {
				total_number_of_non_blank_elements_below = total_number_of_non_blank_elements_below - 1;
			}
		}

		int ar[] = new int[total_number_of_non_blank_elements_below];

		for (i = (row_position + 1); i < l; i++) {
			if (!(sudoku_board[i][column_position].equals("-"))) {
				ar[i] = Integer.valueOf(sudoku_board[i][column_position]);
			}
		}
		return ar;
	}

	int[] getLeftArray(int row_position, int column_position) {

		int i, j;
		int total_number_of_elements_left = row_position - 1;
		int total_number_of_non_blank_elements_left = total_number_of_elements_left;

		for (i = 0; i < column_position; i++) {
			if (sudoku_board[row_position][i].equals("-")) {
				total_number_of_non_blank_elements_left = total_number_of_non_blank_elements_left - 1;
			}
		}

		int ar[] = new int[total_number_of_non_blank_elements_left];

		for (i = 0; i < column_position; i++) {
			if (!(sudoku_board[row_position][i].equals("-"))) {
				ar[i] = Integer.valueOf(sudoku_board[row_position][i]);
			}
		}
		return ar;
	}

	int[] getRightArray(int row_position, int column_position) {

		int i, j;
		int total_number_of_elements_right = l - (column_position + 1);
		int total_number_of_non_blank_elements_right = total_number_of_elements_right;

		for (i = (column_position + 1); i < l; i++) {
			if (sudoku_board[row_position][i].equals("-")) {
				total_number_of_non_blank_elements_right = total_number_of_non_blank_elements_right - 1;
			}
		}

		int ar[] = new int[total_number_of_non_blank_elements_right];

		for (i = (column_position + 1); i < l; i++) {
			if (!(sudoku_board[row_position][i].equals("-"))) {
				ar[i] = Integer.valueOf(sudoku_board[row_position][i]);
			}
		}
		return ar;
	}

	int[] getOwnBoxArray(int row_position, int column_position) {

		int ar[] = new int[1];

		if ((row_position >= 0) && (row_position <= 2)) {
			if ((column_position >= 0) && (column_position <= 2)) {
				ar = getGridArray(0, 2, 0, 2);
			} else if ((column_position >= 3) && (column_position <= 5)) {
				ar = getGridArray(0, 2, 3, 5);
			} else {
				ar = getGridArray(0, 2, 6, 8);
			}
		}

		else if ((row_position >= 3) && (row_position <= 5)) {
			if ((column_position >= 0) && (column_position <= 2)) {
				ar = getGridArray(3, 5, 0, 2);
			} else if ((column_position >= 3) && (column_position <= 5)) {
				ar = getGridArray(3, 5, 3, 5);
			} else {
				ar = getGridArray(3, 5, 6, 8);
			}
		}
		
		else {
			if ((column_position >= 0) && (column_position <= 2)) {
				ar = getGridArray(6, 8, 0, 2);
			} else if ((column_position >= 3) && (column_position <= 5)) {
				ar = getGridArray(6, 8, 3, 5);
			} else {
				ar = getGridArray(6, 8, 6, 8);
			}
		}
		
		return ar;
	}

	int[] getGridArray(int grid_start_row, int grid_end_row, int grid_start_column, int grid_end_column) {
		int i, j;
		int no_of_elements_in_the_grid = 0;
		for (i = grid_start_row; i <= grid_end_row; i++) {
			for (j = grid_start_column; j <= grid_end_column; j++) {
				if (!(sudoku_board[i][j].equals("-"))) {
					no_of_elements_in_the_grid = no_of_elements_in_the_grid + 1;
				}
			}
		}

		int array[] = new int[no_of_elements_in_the_grid];

		for (i = grid_start_row; i <= grid_end_row; i++) {
			for (j = grid_start_column; j <= grid_end_column; j++) {
				if (!(sudoku_board[i][j].equals("-"))) {
					array[i] = Integer.valueOf(sudoku_board[i][j]);
				}
			}
		}
		return array;
	}
}
