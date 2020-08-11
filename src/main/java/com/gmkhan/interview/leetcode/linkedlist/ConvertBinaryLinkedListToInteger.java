package com.gmkhan.interview.leetcode.linkedlist;

import org.junit.Test;

public class ConvertBinaryLinkedListToInteger{

	@Test
	public void test(){
		ListNode head = new ListNode(1);
		head.next = new ListNode(0);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(1);
		printLinkedList(head);
		System.out.println(getDecimalValue(head));
	}

	public int getDecimalValue(ListNode head) {
		int result = 0;
		while(head != null){
			result = result*2+head.val;
			head=head.next;
		}
		return result;
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
