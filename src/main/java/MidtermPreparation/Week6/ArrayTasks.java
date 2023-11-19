package MidtermPreparation.Week6;

import java.util.Arrays;

class ArrayTasks {
    public int smallest(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    public int indexOfTheSmallest(int[] array) {
        int min = array[0];
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    public int indexOfTheSmallestStartingFrom(int[] array, int index) {
        int min = array[index];
        int minIndex = index;
        for (int i = index; i < array.length; i++) {
            if (array[i] < min){
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    public void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public void sortArray(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public boolean search(int[] array, int searchedValue) {
        int left = 0, rihgt = array.length-1;
        boolean flag = false;
        while (left <= rihgt) {
            int middle = left + (rihgt - left) / 2;

            if (array[middle] == searchedValue) {
                flag = true;
            }
            if (array[middle] > searchedValue) {
                rihgt = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return flag;
    }
    public void printElegantly(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length-1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
    }
}
class RunArrayTasks {
    public static void main(String[] args) {
        ArrayTasks at = new ArrayTasks();
        int[] array = {8,6,3,1,2,9,11};

        System.out.println("smallest: " + at.smallest(array));
        System.out.println("Index of the smallest: " + at.indexOfTheSmallest(array));
        System.out.println("Indef of the smallest starting from 2: " + at.indexOfTheSmallestStartingFrom(array, 2));
        at.swap(array, 1,0);
        System.out.println("Swapped: " + Arrays.toString(array));
        at.sortArray(array);
        System.out.println("Sorted array: " + Arrays.toString(array));

        int value = 9;
        boolean result = at.search(array, value);
        if (result) {
            System.out.println("Value " + value + " is in the array");
        } else {
            System.out.println("Value " + value + " is not in the array");
        }

        at.printElegantly(array);
    }
}
