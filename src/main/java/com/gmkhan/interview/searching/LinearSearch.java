package com.gmkhan.interview.searching;

public class LinearSearch
{
    static private int linearSearch(int arr[],int target){
        for(int i=0;i<arr.length;i++)
            if(arr[i]==target)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {13,40,20,10,5,16,8,4,2,1};
        int targetElementIndex = linearSearch(arr,50);
        if(targetElementIndex!=-1)
            System.out.println("Target element present at "+targetElementIndex+" index");
        else
            System.out.println("Element not found");
    }
}
