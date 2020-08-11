package com.gmkhan.interview.leetcode.linkedlist;

import org.junit.Test;

public class LinkedListPalindrome
{
	@Test
	public void test(){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		printLinkedList(head);
		System.out.println(isPalindrome(head));
	}

	private boolean isPalindrome(ListNode head){
		if(head == null || head.next == null){
			return true;
		}

		ListNode middleNode = getMiddleNode(head);

		ListNode secondHalf = middleNode.next;
		middleNode.next = null;
		secondHalf = reverseList(secondHalf);
		boolean result = compareList(head,secondHalf);
		secondHalf = reverseList(secondHalf);
		middleNode.next = secondHalf;
		return result;
	}

	private boolean compareList(ListNode list1, ListNode list2){
		while(list2 != null && list1.val == list2.val){
			list1 = list1.next;
			list2 = list2.next;
		}
		return list2 == null;
	}

	private ListNode reverseList(ListNode secondHalf){
		ListNode prev = null;
		ListNode current = secondHalf;
		ListNode nextNode;

		while(current != null){
			nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		secondHalf = prev;
		return secondHalf;
	}

	private ListNode getMiddleNode(ListNode head){
		if(head == null || head.next.next == null){
			return head;
		}

		if(head.next.next.next == null){
			return head.next;
		}

		ListNode slow = head;
		ListNode fast = head;

		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
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
