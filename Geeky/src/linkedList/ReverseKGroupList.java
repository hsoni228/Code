package linkedList;

public class ReverseKGroupList {
	static Node head;
	
	public static class Node {
		int value;
		Node next;
		
		public Node(int data) {
			value = data;
			next = null;
		}
	}
	
	public static void printLinkedList(Node head) {
		Node p = head;
		while(p != null)
		{
			System.out.print(p.value + " ");
			p = p.next;
		}
	}
	
	public static void main(String[] args) {
		head = new Node(2);
		head.next = new Node(5);
		head.next.next = new Node(10);
		head.next.next.next = new Node(12);
		head.next.next.next.next = new Node(18);
		printLinkedList(head);
		
		reverse(3);
		System.out.println();
		printLinkedList(head);
	}

	private static void reverse(int k) {
		Node p = head, h = head, temp = null, prev = null;
		boolean modifyHead = true;
		while(p != null){
			for(int i = 1; i <= k && p != null; i++){
				p = p.next;
			}
			h = reverse(h,p);
			if(modifyHead){
				temp = head;
				modifyHead = false;
			}else
				prev.next = head;
			h.next = p;
			prev = h;
			h = h.next;
		}
		head = temp;
	}

	private static Node reverse(Node h, Node p) {
		if(h.next == p){
			head = h;
			return h;
		}
		Node q = reverse(h.next, p);
		q.next = h;
		return h;
	}

}
