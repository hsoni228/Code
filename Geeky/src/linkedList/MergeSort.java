package linkedList;

public class MergeSort {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Node head = list.head;
		int arr[] = {7,8,9,0,2,4,1,3,1,2,21};
		
		for(int i = 0; i < arr.length; i++)
			head = list.insertElementAtBeginning(head, arr[i]);
		
		list.printLinkedList(head);
		System.out.println();
		
		if(head.next != null){
			Node last = head;
			while(last.next != null)
				last = last.next;
			
			Node mid = getMiddle(head, last.next);
			Node nMid = mid.next;
			Node p = mergeSort(head, mid);
			Node q = mergeSort(nMid, last);
			head = mergeLists(p, q);
		}
		list.printLinkedList(head);
	}

	private static Node mergeLists(Node p, Node q) {
		Node head = null, pPrev = null, temp = null;
		if(p.value > q.value){
			temp = p;
			p = q;
			q = temp;
		}
		head = p;
		
		while(p != null && q != null){
			if(p.value <= q.value){
				pPrev = p;
				p = p.next;
			}else{
				temp = q.next;
				pPrev.next = q;
				pPrev = q;
				q.next = p;
				q = temp;
			}
		}
		if(p == null)
			pPrev.next = q;
		return head;
	}

	private static Node mergeSort(Node start, Node end) {
		if(start == end){
			start.next = null;
			return start;
		}
		Node mid = getMiddle(start, end.next);
		Node nMid = mid.next;
		Node p = mergeSort(start, mid);
		Node q = mergeSort(nMid, end);
		return mergeLists(p, q);
	}

	private static Node getMiddle(Node head, Node end) {
		Node slow = head, fast = head;
		while(fast.next != end && fast.next.next != end){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
