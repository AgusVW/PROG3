
public class Node<Integer> {

	private Integer info;
	private Node<Integer> next;

	public Node() {
		this.info = null;
		this.next = null;
	}
	
	public Node(Integer info, Node<Integer> next) {
		this.setInfo(info);
		this.setNext(next);
	}
	
	public Node<Integer> getNext() {
		return next;
	}

	public void setNext(Node<Integer> next) {
		this.next = next;
	}

	public Integer getInfo() {
		return this.info;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}

}
