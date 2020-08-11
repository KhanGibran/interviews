package com.gmkhan.interview.leetcode.linkedlist;

import org.junit.Test;

public class DeleteDuplicateNode{

	@Test
	public void test(){
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(2);
//		head.next.next = new ListNode(1);
//		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(3);
//		head.next.next.next.next.next = new ListNode(4);
//		head.next.next.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next.next.next = new ListNode(6);
//		head.next.next.next.next.next.next.next.next = new ListNode(6);
//		head.next.next.next.next.next.next.next.next.next = new ListNode(6);

		printLinkedList(head);
		ListNode refactoredList = deleteDuplicatesSecond(head);
		printLinkedList(refactoredList);
	}

	/**
	 * Input: 1->1->2->3->3
	 * Output: 1->2->3
	 * @param head
	 * @return
	 */
	private ListNode deleteDuplicates(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode refactoredList = head;
		ListNode temp = null;
		boolean refactored = false;
		while(head != null){
			temp = head;
			while(temp.next != null && temp.val == temp.next.val){
				refactored = true;
				temp = temp.next;
			}
			if(refactored){
				head.next = temp.next;
				refactored = false;
			}
			head = head.next;
		}
		return refactoredList;
	}

	private void printLinkedList(ListNode node){
		ListNode current = node;
		while(current != null){
			System.out.print(current.val+" ");
			current=current.next;
		}
		System.out.println();
	}

	/**
	 * Input: 1->2->3->3->4->4->5
	 * Output: 1->2->5
	 * @param head
	 * @return
	 */
	private ListNode deleteDuplicatesSecond(ListNode head){
		ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
		dummyNode.next = head;
		head = dummyNode;

		ListNode prev1 = head;
		ListNode prev2 = head;
		ListNode current = head.next;

		while(current != null){
			if(prev1.val != current.val){
				prev2 = prev1;
				prev1 = current;
				current = current.next;
			}
			else{
				while(current != null && prev1.val == current.val){
					current = current.next;
				}
				prev2.next = current;
				prev1=prev2;
			}
		}
		return head.next;
	}
}
