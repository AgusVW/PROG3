
public class MySimpleLinkedList<Integer> {
	
	private Node<Integer> first;
	
	public MySimpleLinkedList() {
		this.first = null;
	}
	
	public void insertFront(Integer info) {
		Node<Integer> tmp = new Node<Integer>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
	}
	
	public Integer extractFront() {		
		// TODO
		return null;
	}

	public boolean isEmpty() {
		// TODO
		return false;
	}
	
	public Integer get(int index) {
		// TODO
		return null;
	}
	
	public int size() {
		// TODO
		return 0;
	}
	
	@Override
	public String toString() {
		// TODO
		return "";
	}
	
}
