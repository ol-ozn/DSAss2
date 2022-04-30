

public class Warmup {
    public static int backtrackingSearch(int[] arr, int x, int forward, int back, Stack myStack) {
        int index =0;
        while (index < arr.length){
            for (int j=0; j < forward; j++, index ++){
                if (index >= arr.length)
                    return -1;
                if (arr[index] == x)
                    return index;
                else
                    myStack.push(arr[index]);
            }
            for (int j =index ;index > j-back; index = index-1){
                myStack.pop();
            }
        }

    	return -1;
    }

    public static int consistentBinSearch(int[] arr, int x, Stack myStack) {
        int left =0, right = arr.length-1;
        while (left < right ){
            myStack.push(left);
            myStack.push(right);
            int middle = (left + right) /2;
            if (arr[middle] == x)
                return middle;
            if (arr[middle] < x)
                left = middle +1;
            else
                right = middle -1;
            int inconsistencies = Consistency.isConsistent(arr);
            for (int j=0; j< inconsistencies; j++){
                right = (int) myStack.pop();
                left = (int) myStack.pop();
            }
        }
    	
    	// Your implementation should contain this line:
    	//int inconsistencies = Consistency.isConsistent(arr);
    	
    	return -1; // temporal return command to prevent compilation error
    }
    
}
