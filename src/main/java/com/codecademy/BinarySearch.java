package com.codecademy;

public class BinarySearch {

    public static void main(String[] args) {
        var searchable = new int[]{1, 2, 7, 8, 22, 28, 41, 58, 67, 71, 94};
        var target = 41;

        System.out.println(search(searchable, target));
    }

    private static int search(int[] arr, int target) {
        var left = 0;
        var right = arr.length;

        while (left < right) {
           var mid = Math.floorDiv(left + right, 2);
           var midValue = arr[mid];

           if (midValue == target) {
               return mid;
           } else if (midValue < target) {
               left = mid + 1;
           } else {
               right = mid;
           }
        }

        return -1;
    }

}
