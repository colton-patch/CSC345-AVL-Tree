
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
	    return searchRecursive(root, val);
	}

	private boolean searchRecursive(Node node, int val) {
	    if (node == null) {
	        return false;
	    }

	    if (val == node.val) {
	        return true; 
	    } else if (val < node.val) {
	        return searchRecursive(node.left, val); 
	    } else {
	        return searchRecursive(node.right, val);
	    }
	}
	
	/**
	 * delete(int val) - Deletes the given value from the 
	 * tree, then rebalances if necessary.
	 * 
	 * @param val - the value to delete.
	 * @return false if the value does not exist in the tree,
	 * true if it was deleted successfully.
	 */
	public boolean delete(Node root, int val) {
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
		// Then balance node if necessary, setting the value
		// of node to the new balanced version, then return
		// node.
		computeHeight(node);	// update the height of the node
		int balance = 0;
		
		if (node != null) {
			balance = height(node.left) - height(node.right);	// retrieve balance factor
		}
		// heavier on left
		if (balance > 1) {
			// left node heavier on right
	        if (height(node.left.left) - height(node.left.right) < 0) {
	            // rotate the left node to the left
	            node.left = rotateLeft(node.left);
	        }
	        // rotate the original node to the right
	        return rotateRight(node);
	    }
		// heavier on right
	    if (balance < -1) {
	    	// right node heavier on left
	        if (height(node.right.left) - height(node.right.right) > 0) {
	            // rotate the right node to the right
	            node.right = rotateRight(node.right);
	        }
	        // rotate the original node to the left
	        return rotateLeft(node);
	    }
		return node;
	}
	
	/**
	 * balance(Node node) - Makes the given subtree balanced by rotating values.
	 * 
	 * @param node - the subtree to balance
	 * @return the root of the new balanced subtree
	 */
	private static Node balance(Node node) {
		// TODO
		return node;
	
	}
	
	/**
	 * rotateRight(Node node) - rotates the given subtree right
	 * 
	 * @param node - the subtree to rotate
	 * @return the root of the rotated subtree
	 */
	private static Node rotateRight(Node h) {
		Node x = h.left;
		Node y = x.right;
		x.right = h;
		h.left = y;
		computeHeight(h);
		computeHeight(x);
		return h;
		
	}

	/**
	 * rotateLeft(Node node) - rotates the given subtree left
	 * 
	 * @param node - the subtree to rotate
	 * @return the root of the rotated subtree
	 */
	private static Node rotateLeft(Node h) {
		Node x = h.right;
		Node y = x.left;
		x.left = h;
		h.right = y;
		computeHeight(h);
		computeHeight(x);
		return h;
		
	}
	
	/*
	 * 
	 */
	private static void computeHeight(Node h) {
		h.height = 1 + Math.max(height(h.left), height(h.right));
	}

	/*
	 * 
	 */
	private static int height(Node n) {
		if (n == null) {
			return 0;
		}
		return 1+ Math.max(height(n.left), height(n.right));
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
