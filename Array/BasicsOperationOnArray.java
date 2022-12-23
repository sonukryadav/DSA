class BasicsOperationOnArray{

// 1. Linear Search Algorithm
    public static int linearSearch(int[] array, int element){
        int i = 0;
        int length = array.length;
        while(i<length){
            if(element==array[i])
                return i;
            i++;
        }
        return -1;
    }
    // Time complexity : O(N)
    // Space complexity : O(1)


    // 2. Sort an Array
    public static int[] sortArray(int[] array){
        int length = array.length;
        for(int i=0;i<array.length-1; i++){
            for(int j=i+1; j<length;j++){
                if(array[i] > array[j]){
                    swapArray(array,i,j);
                }
            }
        }
        return array;
    }
    // Time complexity : O(N²)
    // Space complexity : O(1)




    public static void main(String[] args) {
        System.out.println("Hi buddy!!");
        
            // 1. Linear Search Algorithm
            int[] array1 ={4,8,5,4,8,0,2,3,9,-4,-7,20};
            System.out.println(linearSearch(array1,20));
            //O/p: 11
        
            System.out.println(linearSearch(array1,1));
            //O/p: -1
        
            // 2. Sort an Array
            int[] array2 ={4,8,5,4,8,0, 1, 2,3,120120,9,-4,-7, -101010,20};
            System.out.println(Arrays.toString(sortArray(array2)));
            //O/p: [-101010, -7, -4, 0, 1, 2, 3, 4, 4, 5, 8, 8, 9, 20, 120120]
    }
}