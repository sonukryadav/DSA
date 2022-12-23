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

    // 3. Search, insert and delete in a sorted array
    //search in sorted array :
    public static int binarySearchIterative(int[] array, int startIndex, int endIndex, int givenElement){
        while(startIndex <= endIndex){
            int midIndex = startIndex + (endIndex-startIndex)/2;
            if(array[midIndex] == givenElement){
                return midIndex;
            }
            else if(array[midIndex] > givenElement){
                endIndex = midIndex -1;
            }
            else if(array[midIndex] < givenElement){
                startIndex = midIndex + 1;
            }

        }
        return -1;
    }
    // Time complexity : O(log(n))
    // Space complexity : O(1) (if recursive O(log(n)))




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


            // 3. Search, insert and delete in a sorted array
            // Search:
            int[] array3 ={-4,-1,0,2,4,5,6,7,9};
            System.out.println(binarySearchIterative(array3,0,array3.length-1,5));
            //O/p: 5
    }
}