package com.gmkhan.interview.leetcode.linkedlist;

import org.junit.Test;

public class RotateLinkedList{
	@Test
	public void splitAlternateLinkedList(){
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next = new ListNode(6);
//		head.next.next.next.next.next.next = new ListNode(7);
//		head.next.next.next.next.next.next.next = new ListNode(8);
//		head.next.next.next.next.next.next.next.next = new ListNode(9);
//		head.next.next.next.next.next.next.next.next.next = new ListNode(10);
		printLinkedList(head);
		head = rotateList(head,4);
		printLinkedList(head);
	}

	private ListNode rotateList(ListNode head, int k){
		if(k==0 || head==null || head.next == null){
			return head;
		}
		int length = 0;
		ListNode currentNode = head;
		ListNode lastNode = null;
		while(currentNode != null){
			length++;
			lastNode = currentNode;
			currentNode=currentNode.next;
		}
		int netRotation = k%length;

		int count = 1;
		ListNode kthNode = head;
		while(count < length-netRotation && kthNode != null){
			kthNode = kthNode.next;count++;
		}

		lastNode.next = head;
		ListNode node = kthNode.next;
		kthNode.next = null;
		head = node;
		return head;
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
