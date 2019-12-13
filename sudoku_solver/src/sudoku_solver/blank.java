package sudoku_solver;

public class blank {

	int upArray[];
	int downArray[];
	int leftArray[];
	int rightArray[];
	int ownBoxArray[];
	int row_position;
	int column_position;
	String most_possible_values[];
	String value_to_be_inserted_after_computation;

	void setMostPossibleValue() {
		int natural_numbers_less_than_ten_grater_than_zero[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int len = natural_numbers_less_than_ten_grater_than_zero.length;
		int number_of_most_possible_values = 9;
		int i, j, k, l, m;
		for (i = 0; i < len; i++) {
			for (j = 0; j < upArray.length; j++) {
				if (natural_numbers_less_than_ten_grater_than_zero[i] == upArray[i]) {
					number_of_most_possible_values = number_of_most_possible_values - 1;
				}
			}
			for (j = 0; j < downArray.length; j++) {
				if (natural_numbers_less_than_ten_grater_than_zero[i] == downArray[i]) {
					number_of_most_possible_values = number_of_most_possible_values - 1;
				}
			}
			for (j = 0; j < leftArray.length; j++) {
				if (natural_numbers_less_than_ten_grater_than_zero[i] == leftArray[i]) {
					number_of_most_possible_values = number_of_most_possible_values - 1;
				}
			}
			for (j = 0; j < rightArray.length; j++) {
				if (natural_numbers_less_than_ten_grater_than_zero[i] == rightArray[i]) {
					number_of_most_possible_values = number_of_most_possible_values - 1;
				}
			}
			for (j = 0; j < ownBoxArray.length; j++) {
				if (natural_numbers_less_than_ten_grater_than_zero[i] == ownBoxArray[i]) {
					number_of_most_possible_values = number_of_most_possible_values - 1;
				}
			}
		}

		most_possible_values = new String[number_of_most_possible_values];

		int x = 0;

		for (i = 0; i < len; i++) {
			for (j = 0; j < upArray.length; j++) {
				if (natural_numbers_less_than_ten_grater_than_zero[i] != upArray[j]) {
					if (!(elementIsAlreadyPresent(String.valueOf(natural_numbers_less_than_ten_grater_than_zero[i]),most_possible_values))) {
						most_possible_values[x] = String.valueOf(natural_numbers_less_than_ten_grater_than_zero[i]);
						x=x+1;
					}
				}
			}
			for (j = 0; j < downArray.length; j++) {
				if (natural_numbers_less_than_ten_grater_than_zero[i] != upArray[j]) {
					if (!(elementIsAlreadyPresent(String.valueOf(natural_numbers_less_than_ten_grater_than_zero[i]),most_possible_values))) {
						most_possible_values[x] = String.valueOf(natural_numbers_less_than_ten_grater_than_zero[i]);
						x=x+1;
					}
				}
			}
			for (j = 0; j < leftArray.length; j++) {
				if (natural_numbers_less_than_ten_grater_than_zero[i] != upArray[j]) {
					if (!(elementIsAlreadyPresent(String.valueOf(natural_numbers_less_than_ten_grater_than_zero[i]),most_possible_values))) {
						most_possible_values[x] = String.valueOf(natural_numbers_less_than_ten_grater_than_zero[i]);
						x=x+1;
					}
				}
			}
			for (j = 0; j < rightArray.length; j++) {
				if (natural_numbers_less_than_ten_grater_than_zero[i] != upArray[j]) {
					if (!(elementIsAlreadyPresent(String.valueOf(natural_numbers_less_than_ten_grater_than_zero[i]),most_possible_values))) {
						most_possible_values[x] = String.valueOf(natural_numbers_less_than_ten_grater_than_zero[i]);
						x=x+1;
					}
				}
			}
			for (j = 0; j < ownBoxArray.length; j++) {
				if (natural_numbers_less_than_ten_grater_than_zero[i] != upArray[j]) {
					if (!(elementIsAlreadyPresent(String.valueOf(natural_numbers_less_than_ten_grater_than_zero[i]),most_possible_values))) {
						most_possible_values[x] = String.valueOf(natural_numbers_less_than_ten_grater_than_zero[i]);
						x=x+1;
					}
				}
			}
		}
	}
	
	void fillBlank() {
		//Filling the blank with first element of most_possible_values array
		value_to_be_inserted_after_computation = most_possible_values[0];
	}
	boolean elementIsAlreadyPresent(String element_to_check, String array[]) {
		boolean flag = false;
		int i, l_array, l_element, j;
		l_array = array.length;
		l_element = element_to_check.length();
		for (i = 0; i < l_array; i++) {
			for (j = 0; j < l_element; j++) {
				if (array[i].equals(element_to_check)) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
}
