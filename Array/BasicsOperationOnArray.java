import java.util.*;
class BasicsOperationOnArray {

    // ----------------------Some general
    // methods-----------------------------------//

    public static int[] swapArray(int[] array1, int i, int j) {
        int temp = array1[i];
        array1[i] = array1[j];
        array1[j] = temp;
        return array1;
    }

    // --------------------------Basic Operations on
    // array--------------------------------//
    // 1. Linear Search Algorithm
    public static int linearSearch(int[] array, int element) {
        int i = 0;
        int length = array.length;
        while (i < length) {
            if (element == array[i])
                return i;
            i++;
        }
        return -1;
    }
    // Time complexity : O(N)
    // Space complexity : O(1)

    // 2. Sort an Array
    public static int[] sortArray(int[] array) {
        int length = array.length;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] > array[j]) {
                    swapArray(array, i, j);
                }
            }
        }
        return array;
    }
    // Time complexity : O(N²)
    // Space complexity : O(1)

    // 3. Search, insert and delete in an unsorted array
    // simple go with sorted methods.

    // 4. Search, insert and delete in a sorted array

    // search in sorted array :
    public static int binarySearchIterative(int[] array, int startIndex, int endIndex, int givenElement) {
        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (array[midIndex] == givenElement) {
                return midIndex;
            } else if (array[midIndex] > givenElement) {
                endIndex = midIndex - 1;
            } else if (array[midIndex] < givenElement) {
                startIndex = midIndex + 1;
            }

        }
        return -1;
    }
    // Time complexity : O(log(n))
    // Space complexity : O(1) (if recursive O(log(n)))

    // Insert:
    public static int[] insertInArray(int[] sortedArray, int element, int filledIndex) {
        int capacityOfArray = sortedArray.length;
        if (filledIndex >= capacityOfArray) {
            return sortedArray;
        }
        int index = -1;
        for (int i = filledIndex - 1; i >= 0; i--) {
            if (sortedArray[i] < element) {
                index = i;
                break;
            }
        }
        for (int i = filledIndex + 1; i > index; i--) {
            if (i == index + 1) {
                int temp = sortedArray[i];
                sortedArray[i] = element;
                sortedArray[i + 1] = temp;
            } else {
                sortedArray[i + 1] = sortedArray[i];
            }
        }
        return sortedArray;
    }
    // Time complexity : O(N)
    // Space complexity : O(O)

    // delete in a sorted array
    public static int deleteInSortedArray(int[] array, int element) {
        int size = array.length;
        int elementIndex = binarySearchIterative(array, 0, array.length - 1, element);

        if (elementIndex == -1) {
            System.out.println("Element not found");
            return size;
        }
        for (int i = elementIndex; i < size - 1; i++)
            array[i] = array[i + 1];
        return size - 1;
    }
    // Time complexity : O(N)
    // Space complexity : O(log(N)


    // ---------------------------Array Questions------------------------//

    // 1. Program to reverse an array.
    public static int[] reverseArray1(int[] array1) {
        int length = array1.length;
        int[] array2 = new int[length];
        for (int i = 0; i < length; i++) {
            array2[i] = array1[length - i - 1];
        }
        return array2;
    }
    // Time complexity : O(N)
    // Space complexity : O(N)

    // Aliter:
    public static int[] reverseArray2(int[] array1) {
        int length = array1.length;
        for (int i = 0; i < length / 2; i++) {
            swapArray(array1, i, length - i - 1);
        }
        return array1;
    }
    // Time complexity : O(N/2)
    // Space complexity : O(1)



    public static void main(String[] args) {
        System.out.println("Hi buddy!!");

        // --------------------------Basic Operations on
        // array--------------------------------//
        // 1. Linear Search Algorithm
        int[] array1 = { 4, 8, 5, 4, 8, 0, 2, 3, 9, -4, -7, 20 };
        System.out.println(linearSearch(array1, 120));
        // O/p: 11

        System.out.println(linearSearch(array1, 1));
        // O/p: -1

        // 2. Sort an Array
        int[] array2 = { 4, 8, 5, 4, 8, 0, 1, 2, 3, 120120, 9, -4, -7, -101010, 20 };
        System.out.println(Arrays.toString(sortArray(array2)));
        // O/p: [-101010, -7, -4, 0, 1, 2, 3, 4, 4, 5, 8, 8, 9, 20, 120120]

        // 3. Search, insert and delete in an unsorted array
        // see for the sorted.

        // 4. Search, insert and delete in a sorted array

        // Search:
        int[] array3 = { -4, -1, 0, 2, 4, 5, 6, 7, 9 };
        System.out.println(binarySearchIterative(array3, 0, array3.length - 1, 5));
        // O/p: 5

        // Insert:
        int[] array4 = new int[20];
        array4[0] = 12;
        array4[1] = 16;
        array4[2] = 20;
        array4[3] = 40;
        array4[4] = 50;
        array4[5] = 70;
        int indexFilled = 6;

        System.out.println(Arrays.toString(insertInArray(array4, 26, indexFilled)));
        // O/p: [12, 16, 20, 26, 40, 50, 70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

        // Delete:
        int[] array5 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int size = array5.length;
        System.out.println("Array before delete : " + Arrays.toString(array5));
        // O/p: Array before delete : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        size = deleteInSortedArray(array5, 5);
        System.out.println("Array after delete : ");
        for (int i = 0; i < size; i++) {
            System.out.print(array5[i] + " ");
        }
        System.out.println();
        // O/p: Array after delete :
        // 1 2 3 4 6 7 8 9 10

        // --------------------------Array
        // Question---------------------------------------//

        // 1. Program to reverse an array.
        int[] array6 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(Arrays.toString(reverseArray1(array6)));
        // O/p: [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]

    }
}