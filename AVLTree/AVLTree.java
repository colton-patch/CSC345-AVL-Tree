/**
 * AVLTree
 * Authors: Colton Patch, Brenda Coutino, Femor Garfo
 * A self-balancing binary search tree, that balances itself by checking if any node's
 * left and right subtrees differ in height by more than one, and rotating the necessary
 * nodes if they do. 
 * 
 */
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

	/**
	 * searchRecursive(Node node, int val) - Recursive helper
	 * function for searching
	 * 
	 * @param node - current node
	 * @param val - value to search for
	 * @return boolean: true if the node with the given value is found,
	 * false if not
	 */
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
	public boolean delete(int val) {
		return deleteRecursive(this.root, val) != null;
	}
	
	/**
	 * deleteRecursive(Node root, int val) - Recursive helper function
	 * for deleting.
	 * 
	 * @param root - current node
	 * @param val - value of node to delete
	 * @return deleted node
	 */
	public Node deleteRecursive(Node root, int val) {
	    // value not found
	    if (!search(val)) {
	        return null; 
	    }

	    // traverse through left subtree 
	    if (val < root.val) 
	        root.left = deleteRecursive(root.left, val); 
	    // traverse through right subtree 
	    else if (val > root.val) 
	        root.right = deleteRecursive(root.right, val);
	    // value found
	    else {
	        if (root.left == null || root.right == null) {
	            Node temp = (root.left != null) ? root.left : root.right;
	            
	            // If the node has one child
	            if (temp != null) {
	                root.val = temp.val;
	                root.left = temp.left;
	                root.right = temp.right;
	            } else {
	                // Node is a leaf node
	                root = null;
	            }
	        } else {
	            // Node has two children
	        	Node current = root.right;
        		while(current.left != null) {
        			current = current.left;
        		}
        		Node temp = current;
        		root.val = temp.val;
        		root.right = deleteRecursive(root.right, temp.val);
	        	
	        }
	    }

	    return checkIfUnbalanced(root);
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
		this.root = recursiveInsert(this.root, newVal);
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
	        throw new RuntimeException("Node " + newVal + " already exists");
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
		if (node == null) {
		    return null;
		}
		
		// update the height of the node
		computeHeight(node);
		return balance(node);
	}
	
	/**
	 * balance(Node node) - Makes the given subtree balanced by rotating values.
	 * 
	 * @param node - the subtree to balance
	 * @return the root of the new balanced subtree
	 */
	private static Node balance(Node node) {
		int balance = 0;
		if (node != null) {
			// retrieve balance factor
			balance = height(node.left) - height(node.right);
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
	 * rotateRight(Node node) - rotates the given subtree right
	 * 
	 * @param node - the subtree to rotate
	 * @return the root of the rotated subtree
	 */
	private static Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		computeHeight(h);
		computeHeight(x);
		return x;
		
	}

	/**
	 * rotateLeft(Node node) - rotates the given subtree left
	 * 
	 * @param node - the subtree to rotate
	 * @return the root of the rotated subtree
	 */
	private static Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		computeHeight(h);
		computeHeight(x);
		return x;
		
	}
	
	/**
	 * computeHeight(Node h) - sets the height value of the given node
	 * 	to its correct value
	 * 
	 * @param h - node whose height to find
	 */
	private static void computeHeight(Node h) {
		h.height = 1 + Math.max(height(h.left), height(h.right));
	}

	/**
	 * height(Node n) - Gives the height of the given node
	 * 
	 * @param n - node to get the height of
	 * @return	- height of the node
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
	 * printHierarchy() - prints the tree with a hierarchical notation.
	 * 
	 */
	public void printHierarchy() {
		printHierarchyRecursive(this.root, 0);
    }

	/**
	 * printHierarchyRecursive(Node node, int depth) - Helper function to recursively
	 * 	print the tree in hierarchical notation
	 * 
	 * @param node - node whose value to print
	 * @param depth - the depth of the node
	 */
    private static void printHierarchyRecursive(Node node, int depth) {
    	if (node == null) {
    		return;
    	}
        for (int i = 0; i < depth; i++) {
            System.out.print("|  ");
        }
        System.out.println(node.val);

        printHierarchyRecursive(node.left, depth + 1);
        printHierarchyRecursive(node.right, depth + 1);
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
