package com.gmkhan.interview.leetcode.linkedlist;

import org.junit.Test;

public class LinkedListAlternatingSplit {

	@Test
	public void splitAlternateLinkedList(){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		printLinkedList(head);
		head = splitLinkedListAlternate(head);
		printLinkedList(head);
	}

	private ListNode splitLinkedListAlternate(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenStart = even;

		while(even != null && even.next != null){
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenStart;
		return head;
 	}

	/**
	 * Print Linked List
	 * @param node
	 */
	private void printLinkedList(ListNode node){
		ListNode current = node;
		while(current != null){
			System.out.print(current.val+" ");
			current=current.next;
		}
		System.out.println();
	}
}
