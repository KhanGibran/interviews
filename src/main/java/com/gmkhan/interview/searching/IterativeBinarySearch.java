package com.gmkhan.interview.searching;

public class IterativeBinarySearch
{
    private static int iterativeBinarySearch(int arr[],int leftIndex,int rightIndex,int targetValue){
        while(leftIndex <= rightIndex){
            int middleIndex = leftIndex + (rightIndex-leftIndex)/2;
            if(targetValue == arr[middleIndex])
                return middleIndex;
            else if(targetValue > arr[middleIndex])
                leftIndex = middleIndex+1;
            else
                rightIndex = middleIndex-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,4,5,8,10,13,16,20,40};
        int targetIndex = iterativeBinarySearch(arr,0,arr.length-1,17);
        if(targetIndex!=-1)
            System.out.println("Element is present in "+targetIndex+" index");
        else
            System.out.println("Element not found");
    }
}
