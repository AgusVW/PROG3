package tp2_2arboles;

public class TreeNode {//node de arbol

	private Integer value;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(Integer value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value){ this.value=value; }


}
