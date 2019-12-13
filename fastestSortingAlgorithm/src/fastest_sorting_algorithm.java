/**
Created by : Abir Ganguly.

---------------------NOTE---------------------

THIS PROGRAM DOESN'T SUPPORT NEGATIVE NUMBERS, AS INPUT.

----------------------------------------------

*/
import java.util.*;

class fastest_sorting_algorithm {

  private static void getArray(int[] array, Scanner sc) {
    System.out.println("Enter array elements :");
    int i;
    for(i = 0; i < array.length; i++) {
      System.out.print("Enter element " + (i + 1) + " : ");
      array[i] = sc.nextInt();
    }
  }

  private static void displayArray(String message, int[] array) {
    System.out.print(message);
    int i;
    for(i = 0; i < array.length; i++) {
      System.out.print(array[i] + ", ");
    }
    System.out.println();
  }

  private static int getmaxElement(int[] array) {
    int i, max = array[0];
    for(i = 0; i < array.length; i++) {
      if(array[i] > max) {max = array[i];}
    }
    return max;
  }

  public static int[] sort(int[] array) {
    /**
    The elementCounter array will contain how many times each number is repeated.

    For example : array is = A = [6, 2, 0, 2, 5]

    This array has minimum element 0, and maximum is 6,  so length of elementCounter should be (6 + 1) = 7(also consider 0)

    on traversing this array, the system will first encounter '6', so it will increse elementCounter[6] by 1.
    then the system will see '2', so it will increse elementCounter[2] by 1.
    then the system will see '0', so it will increse elementCounter[0] by 1.
    then the system will see '2', so it will increse elementCounter[2] by 1.(Now the value of elementCounter[2] is 2)
    then the system will see '5', so it will increse elementCounter[6] by 1.


    Now... elementCounter[0] is 1, so the sorted array should contain 0, 1 time.
    elementCounter[1] is 0, so the sorted array should not contain 1.
    elementCounter[2] is 2, so the sorted array should contain 2, two times.

    ...Like this, it will proceed....
    */
    int[] elementCounter = new int[getmaxElement(array) + 1];	//The user can also enter 0, as an element.
    int i;
    for(i = 0; i < array.length; i++) {
      elementCounter[array[i]] += 1;
    }
    int[] result = new int[array.length];
    arrange(elementCounter, result);
    return result;
  }

  private static void arrange(int[] from, int[] to) {
	int x = 0, i, j;
	for(i = 0; i < from.length; i++) {
		for(j = 0; j < from[i]; j++) {
			to[x] = i;
			x++;
		}
	}
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter length of the array : ");
    int array_length = sc.nextInt();
    int[] array = new int[array_length];
    getArray(array, sc);
    displayArray("Original array : ", array);
    displayArray("Sorted array : ", sort(array));
    sc.close();
  }
}
