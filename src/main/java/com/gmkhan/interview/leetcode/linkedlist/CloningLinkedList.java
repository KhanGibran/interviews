package com.gmkhan.interview.leetcode.linkedlist;

import org.junit.Test;

import java.util.Hashtable;

public class CloningLinkedList{

	@Test
	public void cloneList(){
		CloneListNode head = new CloneListNode(10);
		head.next = new CloneListNode(20);
		head.next.next = new CloneListNode(30);
		head.next.next.next = new CloneListNode(40);

		head.random = head.next.next;
		head.next.random = head.next.next.next;
		head.next.next.random = head.next;
		head.next.next.next.random = head;
		printLinkedList(head);
//		CloneListNode clonedList = cloneListByCopy(head);
//		CloneListNode clonedList = cloneListByHashTable(head);
//		CloneListNode clonedList = cloneListByLinkManipulation(head);
		CloneListNode clonedList = cloneLinkedListByLinkManipulation(head);
		printLinkedList(clonedList);
	}

	/**
	 * This is the simple brute force approach.
	 * This approach failed when the values of two different nodes are same in linked list.
	 * O(n^2)
	 * @param head
	 * @return
	 */
	private CloneListNode cloneListByCopy(CloneListNode head){
		CloneListNode clonedList = new CloneListNode(head.val);
		CloneListNode current = head.next;
		CloneListNode tempNode = clonedList;

		while(current != null){
			CloneListNode newNode = new CloneListNode(current.val);
			tempNode.next = newNode;
			tempNode = newNode;
			current = current.next;
		}

		CloneListNode p = head;
		CloneListNode q = clonedList;

		while(p != null){
			int randomNodeValue = p.random.val;
			CloneListNode temp = clonedList;
			while(temp != null){
				if(temp.val == randomNodeValue){
					q.random = temp;
					break;
				}
				temp = temp.next;
			}
			q = q.next;
			p=p.next;
		}
		return clonedList;
	}

	/**
	 * This approach uses Hash Table
	 * O(n)
	 * @param head
	 * @return
	 */
	private CloneListNode cloneListByHashTable(CloneListNode head){
		Hashtable<CloneListNode,CloneListNode> addressTable = new Hashtable<>();
		CloneListNode clonedList = new CloneListNode(head.val);
		addressTable.put(head,clonedList);
		CloneListNode tempNode = clonedList;
		CloneListNode current = head.next;

		while(current != null){
			CloneListNode newNode = new CloneListNode(current.val);
			addressTable.put(current,newNode);
			tempNode.next = newNode;
			tempNode = newNode;
			current = current.next;
		}

		CloneListNode p = head;
		CloneListNode q=null;

		while(p != null){
			q = addressTable.get(p);
			if(p.random == null){
				q.random = null;
			}
			else{
				q.random = addressTable.get(p.random);
			}
			p=p.next;
		}
		return clonedList;
	}

	private CloneListNode cloneListByLinkManipulation(CloneListNode head){
		if(head == null){
			return null;
		}

		CloneListNode clonedList = null;
		CloneListNode p = head;
		CloneListNode temp = head;
		while(p != null){
			CloneListNode newNode = new CloneListNode(p.val);
			CloneListNode pointer = p.next;
			if(clonedList == null){
				clonedList = newNode;
			}
			else{
				temp.next = newNode;
			}
			temp = newNode;
			p.next = newNode;
			newNode.random = p;
			p = pointer;
		}
		CloneListNode q = clonedList;
		while(q != null){
			q.random = q.random.random.next;
			q = q.next;
		}
		return clonedList;
	}

	private CloneListNode cloneLinkedListByLinkManipulation(CloneListNode head){
		if(head == null){
			return head;
		}

		CloneListNode current = head;
		while(current != null){
			CloneListNode newNode = new CloneListNode(current.val);
			newNode.next = current.next;
			current.next = newNode;
			current = current.next.next;
		}

		current = head;
		while(current != null){
			if(current.random == null){
				current.next.random = null;
			}
			else{
				current.next.random = current.random.next;
			}
			current = current.next.next;
		}

		CloneListNode odd = head;
		CloneListNode even = head.next;
		CloneListNode result = even;

		while(even != null && even.next != null){
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = null;
		return result;
	}


	/**
	 * Print Linked List
	 * @param head
	 */
	private void printLinkedList(CloneListNode head){
		CloneListNode current = head;
		while(current != null){
			System.out.print(current.val+" ");
			current=current.next;
		}
		System.out.println();
	}
}
