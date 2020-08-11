package com.gmkhan.interview.leetcode.linkedlist;

import org.junit.Test;

public class MergeTwoSortedLinkedList{

	@Test
	public void test(){
		ListNode list1 = null;

		ListNode list2 = new ListNode(0);

//		ListNode list2 = new ListNode(2);
//		list2.next = new ListNode(4);
//		list2.next.next = new ListNode(5);
//		list2.next.next.next = new ListNode(6);
//		list2.next.next.next.next = new ListNode(6);
//		list2.next.next.next.next.next = new ListNode(6);
//		list2.next.next.next.next.next.next = new ListNode(7);
//		list2.next.next.next.next.next.next.next = new ListNode(8);
//		list2.next.next.next.next.next.next.next.next = new ListNode(9);

		printLinkedList(list1);
		printLinkedList(list2);

		ListNode mergedList = mergeTwoLists(list1,list2);
		printLinkedList(mergedList);
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode mergedList, tail;

		if(list1 == null && list2==null){
			return null;
		}

		if(list1 == null){
			return list2;
		}

		if(list2 == null){
			return list1;
		}

		if(list1.val <= list2.val){
			mergedList = list1;
			list1 = list1.next;
		}
		else{
			mergedList = list2;
			list2 = list2.next;
		}

		tail = mergedList;

		while(list1 != null && list2 != null){
			if(list1.val <= list2.val){
				tail.next = list1;
				tail = tail.next;
				list1 = list1.next;
			}
			else{
				tail.next = list2;
				tail = tail.next;
				list2 = list2.next;
			}
		}

		if(list1 == null){
			tail.next = list2;
		}
		else{
			tail.next = list1;
		}
		return mergedList;
	}

	private void printLinkedList(ListNode node){
		ListNode current = node;
		while(current != null){
			System.out.print(current.val+" ");
			current=current.next;
		}
		System.out.println();
	}
}
