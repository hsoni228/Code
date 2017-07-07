package linkedList;

public class MergeTwoSortedLinkedList {

	static Node head1, head2;
	
	public static class Node {
		int value;
		Node next;
		
		public Node(int data) {
			value = data;
			next = null;
		}
	}
	
	public void printLinkedList(Node head) {
		Node p = head;
		while(p != null)
		{
			System.out.print(p.value + " ");
			p = p.next;
		}
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		MergeTwoSortedLinkedList list = new MergeTwoSortedLinkedList();
		list.head1 = new Node(2);
		list.head1.next = new Node(5);
		list.head1.next.next = new Node(10);
		list.head1.next.next.next = new Node(12);
		list.head1.next.next.next.next = new Node(18);
		list.printLinkedList(list.head1);
		
		System.out.println();
		
		list.head2 = new Node(4);
		list.head2.next = new Node(6);
		list.head2.next.next = new Node(7);
		list.head2.next.next.next = new Node(8);
		list.head2.next.next.next.next = new Node(13);
		list.printLinkedList(list.head2);
		
		list.head1 = mergeLists(list.head2, list.head1);
		System.out.println();
		
		list.printLinkedList(list.head1);
	}

	private static Node mergeLists(Node head1, Node head2) {
		Node origHead = null;
		if(head1.value < head2.value){
			origHead = head1;
			merge(head1, head2);
		}
		else{
			origHead = head2;
			merge(head2, head1);
		}
		return origHead;
	}

	private static void merge(Node head1, Node head2) {
		if(head1.next == null)
		{
			head1.next = head2;
			return;
		}
		if(head2 == null){
			return;
		}
		
		Node prev1 = head1;
		Node prev2 = head2;
		
		while(head1.next != null && head1.next.value <= head2.value)
			head1 = head1.next;
		while(head2.next != null && head1.next.value >= head2.next.value)
			head2 = head2.next;

		Node next1 = head1.next, next2 = head2.next;
		prev1.next = prev2;
		head2.next = next1;
		merge(next1,next2);
	}
}
