
public class AVLTree {
	private Node root;
	
	public AVLTree() {
		this.root = null;
	}
	
	
	/**
	 * search(int val) - Searches the tree for the given value 
	 * in O(logN) time. Returns true if the value is found.
	 * 
	 * @param val - the value to search for.
	 * @return true if the value is found, false if not.
	 */
	public boolean search(int val) {
	
	}
	
	/**
	 * delete(int val) - Deletes the given value from the 
	 * tree, then rebalances if necessary.
	 * 
	 * @param val - the value to delete.
	 * @return false if the value does not exist in the tree,
	 * true if it was deleted successfully.
	 */
	public boolean delete(int val) {
		 // Only implement this if we have time
		return true;
	}
	
	/**
	 * insert(int newVal) -Inserts a new value into its correct 
	 * spot in the tree in O(logN) time. Then balances the tree 
	 * if necessary.
	 * 
	 * @param val - the value to insert.
	 */
	public void insert(int newVal) {
		if (this.root == null) {
			this.root = new Node(newVal);
			return;
		}
		recursiveInsert(this.root, newVal);
	}
	
	/**
	 * recursiveInsert(Node node, int newVal) - Inserts the given value 
	 * into the tree recursively, balancing each subtree it traverses
	 * if necessary.
	 * 
	 * @param node - the current subtree to insert into 
	 * @param newVal - the value of the node to insert
	 * @return the current node, rebalanced if necessary.
	 */
	private Node recursiveInsert(Node node, int newVal) {
		if (node == null) {
	        return new Node(newVal);
	    } 
		
		if (newVal < node.val) {
	        node.left = recursiveInsert(node.left, newVal);
	    } else if (newVal > node.val) {
	        node.right = recursiveInsert(node.right, newVal);
	    } else if (newVal == node.val) {
	        throw new RuntimeException("Node " + newVal + "already exists");
	    }
	    return checkIfUnbalanced(node);
	}
	
	/**
	 * checkIfUnbalanced(Node node) - Checks if the subtree is unbalanced
	 * (if the heights of the right and left subtrees differ by
	 * more than one). If it is, balances the tree. 
	 * 
	 * @param node - the root of the subtree to check
	 */
	private static Node checkIfUnbalanced(Node node) {
		// This should update the height of the node first
		// by adding one to the height of its tallest child.
		// Then balance node if necessary, setting the variable
		// node to the new balanced version, then return node.
	}
	
	/**
	 * balance(Node node) - Makes the given subtree balanced by rotating values.
	 * 
	 * @param node - the subtree to balance
	 * @return the root of the new balanced subtree
	 */
	private static Node balance(Node node) {
		
	}
	
	/**
	 * rotateRight(Node node) - rotates the given subtree right
	 * 
	 * @param node - the subtree to rotate
	 * @return the root of the rotated subtree
	 */
	private static Node rotateRight(Node node) {
		
	}
	
	/**
	 * rotateLeft(Node node) - rotates the given subtree left
	 * 
	 * @param node - the subtree to rotate
	 * @return the root of the rotated subtree
	 */
	private static Node rotateLeft(Node node) {
		
	}
	
	//@Override
	public String toString() {
		String str = getString(root);
		return str;
	}
	
	/**
	 * Returns the string representation of a node, by recursively
	 * getting the string of the left node and the string of the right node,
	 * and returning a string in the format: left, node, right, 
	 * 
	 * @param node - the node to get the string of.
	 * @return the string representation of node.
	 */
	private String getString(Node node) {
		if (node == null) {
			return "";
		}
		
		String leftStr;
		if (node.left == null) {
			leftStr = "";
		} else {
			leftStr = getString(node.left);
		}
		
		String rightStr;
		if (node.right == null) {
			rightStr = "";
		} else {
			rightStr = getString(node.right);
		}
		
		return leftStr + " " + node.val + " " + rightStr;
	}
}
