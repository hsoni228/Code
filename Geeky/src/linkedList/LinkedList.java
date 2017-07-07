package linkedList;

public class LinkedList {

	Node head;
	
	public LinkedList() {
		head = null;
	}

	public void printLinkedList(Node head) {
		Node p = head;
		while(p != null)
		{
			System.out.print(p.value + " ");
			p = p.next;
		}
	}

	public Node insertElementAtEnd(Node head, int data) {
		Node node = new Node(data);
		Node p = head;
		if(head == null)
			head = node;
		else{
			while(p.next != null){
				p = p.next;
			}
			p.next = node;
		}
		return head;
	}
	
	public Node insertElementAtBeginning(Node head, int data){
		Node node = new Node(data);
		if(head == null)
			head = node;
		else{
			node.next = head;
			head = node;
		}
		return head;
	}
}
