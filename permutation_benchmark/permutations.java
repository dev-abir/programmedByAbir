class permutations {
	public static void main(String[] args) {
		String word = "abcdefghij";
		/*System.out.println("permutations : ");
		printArray(getPermutations(word));*/
		getPermutations(word);
		System.out.println("Done");
	}

	public static String[] getPermutations(String word) {
		if (word.length() == 1) {
			String[] x = {word};
			return x;
		}
		String[] permutations = new String[factorial(word.length())];
		int i, j, x = 0;
		for(i = 0; i < word.length(); i++) {
			word = swap(word, i, 0);
			String[] temp = getPermutations(word.substring(1));
			for(j = 0; j < temp.length; j++) {
				permutations[x] = word.charAt(0) + temp[j];
				x = x + 1;
			}
		}

		return permutations;
	}

	public static String swap(String str, int currentIndex, int destinationIndex) {
		char[] x = str.toCharArray();
		char temp = x[currentIndex];
		x[currentIndex] = x[destinationIndex];
		x[destinationIndex] = temp;
		return new String(x);
	}

	public static int factorial(int n) {
		if((n == 1) || (n == 0)) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static void printArray(String[] array) {
		int i;
		for(i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
