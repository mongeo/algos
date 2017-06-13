package algos;

public class DLList {
	
	protected class Node {
		protected Node prev;
		protected Node next;
		protected Object data;
		public Node(){
			prev = null;
			next = null;
			data = null;		
		}
		
		public void setData(Object d){
			this.data = d;
		}
	}

	protected Node first;
	protected Node last;
	
	public DLList(){
		first = null;
		last = null;
	}
	
	public boolean isEmpty(){
		if (first == null)
			return false;
		return true;
	}
	
	public void insertFront(Object n){
		Node temp = new Node();
		temp.setData(n);
		if(first == null){
			first = temp;
			last = temp;
			return;
		}
		first.prev = temp;
		temp.next = first;
		first = temp;
	}
	
	public void insertRear(Object n){
		if (first == null){
			insertFront(n);
			return;
		}
		Node temp = new Node();
		temp.setData(n);
		temp.prev = last;
		last.next = temp;
		last = temp;
	}
	
	public void deleteFront(){
		if (first == null){
			return;
		}
		if (first == last){
			first = null;
			last = null;
			return;
		}
		first.next.prev =  null;
		first = first.next;
	}
	
	public void deleteRear(){
		if (first == null){
			return;
		}
		if (first == last){
			first = null;
			last = null;
			return;
		}
		last.prev.next = null;
		last = last.prev;
	}
	
	public void print(){
		Node temp = first;
		while(temp != null){
			System.out.print(temp.data);
			System.out.print(" ");
			temp = temp.next;
		}
		System.out.println();
	}	
}
