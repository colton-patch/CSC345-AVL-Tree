# AVL Tree
Implementation of an AVL Tree data structure in Java.

The AVL Tree class is defined in AVLTree.java, and makes use of the Node.java class. 
It defines a tree data structure which allows for inserting values, searching for
values, and deleting values. It is self-balancing, so on each insert or deletion it
checks if the tree is unbalanced, and rebalances it accordingly, ensuring that each
operation has a runtime of O(logN).

# Running the Tests
Tests are included in AVLTreeTest.java. These test for inserting, searching, and 
deleting, and will print the tree in an inorder and hierarchical format after 
inserting and deleting to prove that it remains balanced.

To run the tests, run AVLTreeTest.java with AVLTree.java and Node.java in the same 
directory. The results will be printed to the console.
