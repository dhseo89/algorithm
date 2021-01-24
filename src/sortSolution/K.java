package sortSolution;

public class K {
	
    public int[] solution(int[] array, int[][] commands) {
    	int[] answer = new int[commands.length];
    	for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0];
			int end = commands[i][1];
			int pick = commands[i][2];
			int range = end-start+1; //5-2+1
			int[] sortArray = new int[range];
			for (int j = start-1; j < end; j++) {
				sortArray[j-start+1] = array[j];
			}
			int[] sortArrays = selectionSort(sortArray);
			for (int j = 0; j < sortArrays.length; j++) {
			}
			answer[i] = sortArrays[pick-1];
		}
        return answer;
    }	

	private int[] selectionSort(int[] sortArray) {
		for (int i = 0; i < sortArray.length; i++) {
			int min = i;
			int tmp = 0;
			for (int j = i+1; j < sortArray.length; j++) {
				if(sortArray[j] < sortArray[min])
					min = j;
			}
			tmp = sortArray[i];
			sortArray[i] = sortArray[min];
			sortArray[min] = tmp;
		}
		return sortArray;
	}

	public static void main(String[] args) {
		K k = new K();
		int a[] = {1,5,2,6,3,7,4};
		int c[][] = {{2,5,3},{4,4,1},{1,7,4}};
		k.solution(a, c);
	}
}
