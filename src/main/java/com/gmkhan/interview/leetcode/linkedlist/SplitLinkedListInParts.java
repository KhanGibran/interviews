package com.gmkhan.interview.leetcode.linkedlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SplitLinkedListInParts {

	@Test
	public void splitAlternateLinkedList(){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next.next.next.next.next = new ListNode(10);
		printLinkedList(head);
		ListNode[] result = splitListToParts(head,3);
		System.out.println(result);
	}

	private ListNode[] splitListToParts(ListNode head, int k){
		int length = 0;
		ListNode current = head;
		List<ListNode> result = new ArrayList<>();

		while(current != null){
			length++;
			current = current.next;
		}

		if(length <= k){
			ListNode curr = head;
			while(result.size() < k){
				if(curr != null){
					ListNode temp = curr.next;
					curr.next = null;
					result.add(curr);
					curr = temp;
				}
				else{
					result.add(curr);
				}
			}
		}
		else{
			int[] parts = new int[k];
			int quotient = length/k;
			int remainder = length%k;

			for(int i=0;i<k;i++){
				parts[i] = quotient;
			}
			int i=0;
			while(remainder > 0){
				parts[i] = parts[i]+1;
				i++;
				remainder--;
			}

			int index=0;
			while(result.size()<k){
				ListNode currentNode = head;
				ListNode tempNode = null;
				int elements = parts[index++];
				elements--;
				while(elements>0){
					currentNode=currentNode.next;
					elements--;
				}
				tempNode = currentNode.next;
				currentNode.next = null;
				result.add(head);
				head = tempNode;
			}
		}
		return convertToArray(result);
	}

	private ListNode[] convertToArray(List<ListNode> result){
		ListNode[] arr = new ListNode[result.size()];
		for(int i=0;i<result.size();i++){
			arr[i] = result.get(i);
		}
		return arr;
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
