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

    // 2. Rearrange an array such that arr[i] = i, if not present then -1.(only in
    // aliter)
    public static int[] rearrangement3(int[] array1) {
        int length = array1.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (array1[j] == i) {
                    swapArray(array1, i, j);
                }
            }
        }
        return array1;
    }
    // Time complexity : O(N²)
    // Space complexity : O(1)

    // Aliter:
    public static int[] rearrangement4(int[] array1) {
        int length = array1.length;
        for (int i = 0; i < length; i++) {
            if (array1[i] != i) {
                array1[i] = -1;
            }
        }
        return array1;
    }
    // Time complexity : O(N)
    // Space complexity : O(1)

    // 3. Move all zeroes to end of array.
    public static int[] allZerosToEnd(int[] array1) {
        int length = array1.length;
        int count = length - 1;
        Arrays.sort(array1); // nlog(n)
        for (int i = 0; i < length / 2; i++) { // n/2
            swapArray(array1, i, length - 1 - i);
        }
        return array1;
    }
    // Time complexity : O(Nlog(N)
    // Space complexity : O(1)


    // 4. Rotate array left by d position.
    static int[] rotateLeft(int[] array, int rotateBy) { // and right
        // To handle if, rotateBy >= length of array
        int n = array.length; // n length of array
        rotateBy = rotateBy % n; // effective rotation count
        int gcd = gcd(rotateBy, n); // Calculate the GCD(rotateBy, n) -> to divide the array into sets.

        // (--> This is to rotate to left) and to rotate to right--> for(int i = n-1; i
        // >= gcd; i--){...
        for (int i = 0; i < gcd; i++) {
            /* move i-th values of blocks */
            int j = i;
            int temp = array[i];

            while (true) {
                int k = j + rotateBy;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                array[j] = array[k];
                j = k;
            }
            array[j] = temp;
        }
        return array;
    }

    // Greatest common divisor (gcd)
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
    // Time complexity : O(N)
    // Auxiliary Space : O(1)

    // 5. Search an element in sorted and rotated array.
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (nums[mid] > nums[right] && nums[left] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] < nums[left] && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
    // Time complexity : O(log(N))
    // Auxiliary Space : O(1)


    //--------------------------------Easy----------------------------------------//
    // 1.Rearrange an array such that arr[i] = i
    // ==> Done above!!!

    // 2. Move all zeroes to end of array
    // ==> Done above!!!

    // 3. Rearrange array such that even positioned are greater than odd
    public static int[] evenPosGreaterThenOdd(int[] array) {
        int length = array.length;
        Arrays.sort(array);
        for (int i = 1; i < length - 1; i++) {
            if (i % 2 == 0) {
                if (array[i] > array[i - 1]) {
                    swapArray(array, i, i - 1);
                }
            } else {
                if (array[i] < array[i - 1]) {
                    swapArray(array, i, i - 1);
                }
            }
        }
        return array;
    }
    // Time complexity : O(N)
    // Auxiliary Space : O(1)

    // 4. Rearrange an array in maximum minimum form using Two Pointer Technique.
    public static int[] maxMinFormTwoPointer(int[] array) {
        int length = array.length;
        int[] array2 = new int[length];
        int j = 0, k = length - 1;
        boolean bool = true;
        for (int i = 0; i < length; i++) {
            if (bool) {
                array2[i] = array[k];
                bool = false;
                k--;
            } else {
                array2[i] = array[j];
                bool = true;
                j++;
            }
        }
        return array2;
    }
    // Time complexity : O(N)
    // Auxiliary Space : O(N)

    // 5. Segregate even and odd numbers.
    public static int[] seregateEvenOdd(int[] array) {
        int length = array.length;
        int i = 0, j = 0;
        while (i < length) {
            if (array[i] % 2 == 0) {
                swapArray(array, i, j);
                j++;
            }
            i++;
        }
        return array;
    }
    // Time complexity : O(N)
    // Auxiliary Space : O(1)


    // 6. Reversal algorithm for Array rotation
    // O/p: Done above!!!

    // 7. Print left rotation of array in O(n) time and O(1) space
    static void leftRotate(int array[], int k) {
        int length = array.length;
        // To get the starting point of rotated array
        int mod = k % length;
        // Prints the rotated array from start position
        for (int i = 0; i < length; ++i) {
            System.out.print(array[(i + mod) % length] + " ");
        }
        System.out.println();

        /*
         * Aliter:
         * Collections.rotate(Arrays.asList(arr), length - k);
         * for(int i = 0; i < n; i++)
         * System.out.print(arr[i] + " ");
         */
    }
    // Time complexity : O(N)
    // Auxiliary Space : O(1)

    // 8. K’th Smallest/Largest Element in Unsorted Array
    public static void smallOrLargeInUnsorted(int[] array, int index) {
        int length = array.length;
        Arrays.sort(array);
        System.out.println(array[index - 1]);
    }

    // 9. Find the largest three distinct elements in an array
    public static void largestThreeDistinctElements(int[] array) {
        int length = array.length;
        Arrays.sort(array);
        if (length > 3) {
            int i = 0;
            while (i < 3) {
                System.out.print(array[length - 1 - i] + " ");
                i++;
            }
            System.out.println();
        } else {
            System.out.println("It has less than 3 elements.");
        }
    }
    // Time complexity : O(Nlog(N))
    // Auxiliary Space : O(1)

    // 10. Find Second largest element in an array
    public static void secondLargest(int[] array) {
        int length = array.length;
        Arrays.sort(array);
        System.out.println(array[length - 2]);
    }


    // 11. Sort an array in wave form
    public static int[] sortArrayWave(int[] array) {
        int length = array.length;
        Arrays.sort(array);
        for (int i = 0; i < length - 1;) {
            swapArray(array, i, i + 1);
            i += 2;
        }
        return array;
    }
    // Time complexity : O(N)
    // Auxiliary Space : O(1)

    // 12. Sort an array which contain 1 to n values
    // 👍👍 Applied Arrays.sort(array);
    // Time complexity : O(N log(N))
    // Auxiliary Space : O(1)

    // 13. Count the number of possible triangles
    public static int numberOfTriangles(int[] array) {
        int length = array.length;
        Arrays.sort(array);
        int count = 0;
        for (int i = length - 1; i >= 1; i--) {
            int j = 0, k = i - 1;
            while (j < k) {
                if (array[j] + array[k] >= array[i]) {
                    count += k - j;
                    k--;
                } else {
                    j++;
                }
            }
        }
        return count;
    }
    // Time complexity :
    // Auxiliary Space :

    // 14. Print All Distinct Elements of a given integer array
    public static void printAllDistinctElements(int[] array) {
        int length = array.length;
        HashSet<Integer> hashset = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (!hashset.contains(array[i])) {
                hashset.add(array[i]);
            }
        }
        System.out.println(Arrays.toString(hashset.toArray()));
    }
    // Time complexity : O(N)
    // Auxiliary Space : O(N)


    // 15.Find the element that appears once
    public static int numberThatOccurOnces(int[] array) {
        int length = array.length;
        int ele = array[0];
        for (int i = 1; i < length; i++) {
            ele = ele ^ array[i];
        }
        return ele;
    }
    // Time Complexity: O(n)
    // Auxiliary Space: O(1)


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

        // 2. Rearrange an array such that arr[i] = i, if not present then -1.
        int[] array7 = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };
        System.out.println(Arrays.toString(rearrangement3(array7)));
        // O/p: [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]

        int[] array8 = { -2, 8, 3, 4, 11, 0, 3, 1, 2, 5, 3, 12 };
        System.out.println(Arrays.toString(rearrangement3(array8)));
        // O/p: [0, 1, 2, 3, 4, 5, 12, 3, 8, -2, 3, 11]

        System.out.println(Arrays.toString(rearrangement4(array8)));
        // O/p: [0, 1, 2, 3, 4, 5, -1, -1, 8, -1, -1, 11]

        // 3. Move all zeroes to end of array.
        int[] array9 = { 1, 2, 0, 4, 3, 0, 5, 0 };
        System.out.println(Arrays.toString(allZerosToEnd(array9)));
        // O/p: [5, 4, 3, 2, 1, 0, 0, 0]

        // 4. Rotate array left by d position
        /*
         * Given an array of integers arr[] of size N and an integer, the task
         * is to rotate the array elements to the left by d positions.
         * Input: arr[] = {1, 2, 3, 4, 5, 6, 7}, d = 2
         * Output: 3 4 5 6 7 1 2
         * Input: arr[] = {3, 4, 5, 6, 7, 1, 2}, d=2
         * Output: 5 6 7 1 2 3 4
         */
        int[] array10 = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(Arrays.toString(rotateLeft(array10, 6)));
        // O/p: [7, 1, 2, 3, 4, 5, 6]

        int[] array11 = { 3, 4, 5, 6, 7, 1, 2 };
        System.out.println(Arrays.toString(rotateLeft(array11, 2)));
        // O/p: [5, 6, 7, 1, 2, 3, 4]

        int[] array12 = { 5, 8, 7, 9, 1, 5, 4, 6 };
        System.out.println(Arrays.toString(rotateLeft(array12, 3)));
        // O/p: [9, 1, 5, 4, 6, 5, 8, 7]


        // 5. Search an element in sorted and rotated array.
        /*
         * Search an element in a sorted and rotated Array in O(logN) time complexity.
         * Assume all elements are distinct.
         */
        int[] array13 = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        int vnum1 = search(array13, 1);

        if (vnum1 != -1) {
            System.out.println("Index is " + vnum1);
        } else {
            System.out.println("Element is not found.");
        }
        // O/p: Index is 6



        //----------------------------------------EASY---------------------------------//
        // 1.Rearrange an array such that arr[i] = i
        // ==> Done above!!!

        // 2. Move all zeroes to end of array
        // ==> Done above!!!

        // 3. Rearrange array such that even positioned are greater than odd
        int[] array13E1 = { 1, 3, 2, 5, 4, -7, 0, 4 };
        System.out.println(Arrays.toString(evenPosGreaterThenOdd(array13E1)));
        // O/p: [-7, 1, 0, 3, 2, 4, 4, 5]

        // 4. Rearrange an array in maximum minimum form using Two Pointer Technique.
        /*
         * Given a sorted array of positive integers, rearrange the array alternately
         * i.e first element should be a maximum value, at second position minimum
         * value,
         * at third position second max, at fourth position second min, and so on.
         */
        int[] array13E2 = { -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(Arrays.toString(maxMinFormTwoPointer(array13E2)));
        // O/p: [10, -2, 9, -1, 8, 0, 7, 1, 6, 2, 5, 3, 4]


        // 5. Segregate even and odd numbers.
        /*
         * Given an array arr[] of integers, segregate even and odd numbers
         * in the array. Such that all the even numbers should be present first,
         * and then the odd numbers.
         */
        int[] array13E3 = { 1, 3, 2, 4, 7, 6, 9, 10 };
        System.out.println(Arrays.toString(seregateEvenOdd(array13E3)));
        // O/p: [2, 4, 6, 10, 7, 1, 9, 3]

        // 6. Reversal algorithm for Array rotation
        /*
         * Given an array arr[] of size N, the task
         * is to rotate the array by d position to the left.
         */
        // O/p: Done above!!!

        // 7. Print left rotation of array in O(n) time and O(1) space
        /*
         * Given an array of size n and multiple values around which we
         * need to left rotate the array.
         * Input :
         * int arr[] = {1, 3, 5, 7, 9}
         * k1 = 1
         * k2 = 3
         * k3 = 4
         * k4 = 6
         * Output :
         * 3 5 7 9 1
         * 7 9 1 3 5
         * 9 1 3 5 7
         * 3 5 7 9 1
         */
        int[] array13E4 = { 1, 3, 5, 7, 9 };
        leftRotate(array13E4, 1);
        leftRotate(array13E4, 3);
        leftRotate(array13E4, 4);
        leftRotate(array13E4, 6);
        // O/p:
        /*
         * [3, 5, 7, 9, 1]
         * [9, 1, 3, 5, 7]
         * [7, 9, 1, 3, 5]
         * [9, 1, 3, 5, 7]
         */


        // 8. K’th Smallest/Largest Element in Unsorted Array
        /*
         * Given an array and a number K where K is smaller than
         * the size of the array. Find the K’th smallest element in
         * the given array. Given that all array elements are distinct.
         */
        int[] array13E5 = { 12, 3, 5, 7, 19 };
        smallOrLargeInUnsorted(array13E5, 2);
        // O/p: 5


        // 9. Find the largest three distinct elements in an array
        /*
         * Given an array with all distinct elements, find the largest
         * three elements. Expected time complexity is O(n) and extra space
         * is O(1).
         */
        int[] array13E6 = { 10, 4, 3, 50, 23, 90 };
        largestThreeDistinctElements(array13E6);
        // O/p: 90 50 23


        // 10. Find Second largest element in an array
        int[] arrat13E7 = { 12, 35, 1, 10, 34, 1 };
        secondLargest(arrat13E7);
        // O/p: 34


        // 11. Sort an array in wave form
        /* Given an unsorted array of integers, sort the array into a wave
        array. An array arr[0..n-1] is sorted in wave form if:
        arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= …..*/
        int[] array13E8 = {10, 90, 49, 2, 1, 5, 23};
        System.out.println(Arrays.toString(sortArrayWave(array13E8)));
        //O/p: [2, 1, 10, 5, 49, 23, 90]


        // 12. Sort an array which contain 1 to n values
        /*
         * You have given an array which contain 1 to n element, your
         * task is to sort this array in an efficient way and without replace
         * with 1 to n numbers.
         */
        int[] array13E9 = { 3, 2, 5, 6, 1, 4 };
        Arrays.sort(array13E9);
        System.out.println(Arrays.toString(array13E9));
        // O/p: [1, 2, 3, 4, 5, 6]


        // 13. Count the number of possible triangles
        /*
         * Given an unsorted array of positive integers, find the number of
         * triangles that can be formed with three different array elements as
         * three sides of triangles. For a triangle to be possible from 3 values,
         * the sum of any of the two values (or sides) must be greater than the
         * third value (or third side).
         */
        int[] array13E10 = { 10, 21, 22, 100, 101, 200, 300 };
        System.out.println(numberOfTriangles(array13E10));
        // O/p: 7


        // 14. Print All Distinct Elements of a given integer array
        int[] array13E11 = { 6, 10, 5, 4, 9, 120, 4, 6, 10 };
        printAllDistinctElements(array13E11);
        // O/p: [4, 5, 6, 120, 9, 10]


        // 15.Find the element that appears once
        /*
         * Given an array of integers. All numbers occur twice
         * except one number which occurs once. Find the number in O(n)
         * time & constant extra space.
         */
        int[] array13E12 = { 2, 3, 5, 4, 5, 3, 4 };
        System.out.println(numberThatOccurOnces(array13E12));
        // O/p: 2

    }
}