package com.gmkhan.interview.searching;

public class RecursiveBinarySearch
{
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,8,10,13,16,20,40};
        int targetIndex = recursiveBinarySearch(arr,0,arr.length-1,20);
        if(targetIndex!=-1)
            System.out.println("Element is present in "+targetIndex+" index");
        else
            System.out.println("Element not found");
    }

    private static int recursiveBinarySearch(int[] arr, int leftIndex, int rightIndex, int target){
        if(leftIndex<=rightIndex){
            int middleIndex = leftIndex + (rightIndex-leftIndex)/2;
            if(target == arr[middleIndex])
                return middleIndex;
            else if(target>arr[middleIndex])
                return recursiveBinarySearch(arr,middleIndex+1,rightIndex,target);
            else
                return recursiveBinarySearch(arr,leftIndex,middleIndex-1,target);
        }
        return -1;
    }
}
