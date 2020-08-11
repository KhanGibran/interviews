package com.gmkhan.interview.leetcode.linkedlist;

import org.junit.Test;

import java.util.Stack;

public class LinkedListIntersect{

	@Test
	public void checkIntersectionPoint(){
		ListNode headA = new ListNode(3);

		ListNode headB = new ListNode(2);
		headB.next = headA;

		printLinkedList(headA);
		printLinkedList(headB);
		ListNode intersectingNode = getIntersectionPointByStack(headA,headB);
		System.out.println(intersectingNode.val);
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

	private ListNode getIntersectionPointByStack(ListNode headA,ListNode headB){
		Stack<ListNode> stack1 = new Stack<>();
		Stack<ListNode> stack2 = new Stack<>();

		if(headA == headB){
			return headA;
		}

		ListNode current1 = headA;
		ListNode current2 = headB;

		while(current1 != null){
			stack1.push(current1);
			current1=current1.next;
		}

		while(current2 != null){
			stack2.push(current2);
			current2=current2.next;
		}

		if(stack1.empty() || stack2.empty()){
			return null;
		}

		if(stack1.peek() != stack2.peek()){
			return null;
		}

		ListNode previousNode = null;

		while(!stack1.empty() && !stack2.empty()){
			if(stack1.peek() != stack2.peek()){
				return previousNode;
			}
			else{
				previousNode = stack1.peek();
				stack1.pop();
				stack2.pop();
			}
		}
		return previousNode;
	}
}
