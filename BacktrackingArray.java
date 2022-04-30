

public class BacktrackingArray implements Array<Integer>, Backtrack {
    private Stack stack;
    private int[] arr;
    private int arrActualSize; //helps to monitor if we can add to the array

    // Do not change the constructor's signature
    public BacktrackingArray(Stack stack, int size) {
        this.stack = stack;
        arr = new int[size];
        arrActualSize = 0;
    }

    @Override
    public Integer get(int index){
        // TODO: implement your code here
    	return null; // temporal return command to prevent compilation error
    }

    @Override
    public Integer search(int k) {
        //regular binary search
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == k)
                return m;
            if (arr[m] < k)
                l = m + 1;
            else
                r = m - 1;
        }
    	return -1;
    }

    @Override
    public void insert(Integer x) {
        if(arrActualSize == arr.length - 1)
            throw new RuntimeException("There is no space in the array!");
        arr[arrActualSize] = x;
        arrActualSize++;
    }

    @Override
    public void delete(Integer index) {
        if(index > arrActualSize)
            throw new RuntimeException("There is nothing to delete in this index!");
        for(int i = index; i < arrActualSize; i++){
            arr[i] = arr[i+1];
        }
        arrActualSize--; //the value in arrActualSize will be overwritten with the next insert.
        //It doesn't change, but doesn't affect maximum/minimum, as it's value is duplicated to its predecessor
    }

    @Override
    public Integer minimum() {
        if(arrActualSize == 0){
            throw new RuntimeException("The array is empty!");
        }
        int minIdx = 0;
        for(int i = 1; i <= arrActualSize; i++){
            if(arr[i] < arr[minIdx])
                minIdx = i;
        }
    	return arr[minIdx];
    }

    @Override
    public Integer maximum() {
        if(arrActualSize == 0){
            throw new RuntimeException("The array is empty!");
        }
        int maxIdx = 0;
        for(int i = 1; i <= arrActualSize; i++){
            if(arr[i] > arr[maxIdx])
                maxIdx = i;
        }
        return arr[maxIdx];
    }

    @Override
    public Integer successor(Integer index) {

        return null;
    }

    @Override
    public Integer predecessor(Integer index) {

        return null;
    }

    @Override
    public void backtrack() {
        // TODO: implement your code here
    }

    @Override
    public void retrack() {
		/////////////////////////////////////
		// Do not implement anything here! //
		/////////////////////////////////////
    }

    @Override
    public void print() {
        // print should be "arr[1] arr[2] ... arr[last]"
        for(int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1)
                System.out.println(arr[i]); //for not adding unnecessary space at the end
            else
                System.out.print(arr[i] + " ");
        }
    }
    
}
