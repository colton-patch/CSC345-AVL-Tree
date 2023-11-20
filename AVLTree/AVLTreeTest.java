
public class AVLTreeTest {

	public static void main(String[] args) {
		test1(); // Insert 10 random values
		test2(); // Insert 50 random values
		test3(); // Insert 20 values in order
		test4(); // Insert 10 values and search
		test5(); // Insert 10 values and delete
	}
	
	/*
	 * Inserts 10 random values in the tree and prints the results
	 */
	private static void test1() {
		System.out.println("+------+");
		System.out.println(" TEST 1");
		System.out.println("+------+");
		System.out.println("Insert 10 random values\n");
		
		AVLTree tree = new AVLTree();
		for (int i = 0; i < 10; i++) {
			int newVal = (int) (Math.random() * 100);
			if (!tree.search(newVal)) {
				System.out.print("insert(" + newVal +") ");
				tree.insert(newVal);
			}
		}
		
		printResults(tree);
	}
	
	/*
	 * Inserts 50 random values in the tree and prints the results
	 */
	private static void test2() {
		System.out.println("+------+");
		System.out.println(" TEST 2");
		System.out.println("+------+");
		System.out.println("Insert 50 random values\n");
		
		AVLTree tree = new AVLTree();
		for (int i = 0; i < 50; i++) {
			int newVal = (int) (Math.random() * 200);
			if (!tree.search(newVal)) {
				System.out.print("insert(" + newVal +") ");
				tree.insert(newVal);
			}
		}
		
		printResults(tree);
	}
	
	/*
	 * Inserts 20 values from 0 to 19 in order into the tree and prints the results
	 */
	private static void test3() {
		System.out.println("+------+");
		System.out.println(" TEST 3");
		System.out.println("+------+");
		System.out.println("Insert 20 values in order\n");
		
		AVLTree tree = new AVLTree();
		for (int i = 0; i < 20; i++) {
			System.out.print("insert(" + i +") ");
			tree.insert(i);
		}
		
		printResults(tree);
	}
	
	/*
	 * Inserts numbers 0-9 into the tree then searches for 3, 5, 8, and 100.
	 * Prints true if the number is found, false if not.
	 */
	private static void test4() {
		System.out.println("+------+");
		System.out.println(" TEST 4");
		System.out.println("+------+");
		System.out.println("Insert 10 values and search\n");
		
		AVLTree tree = new AVLTree();
		for (int i = 0; i < 10; i++) {
			System.out.print("insert(" + i +") ");
			tree.insert(i);
		}
		
		System.out.print("\nSearching for 3: ");
		System.out.println(tree.search(3));
		System.out.print("Searching for 5: ");
		System.out.println(tree.search(5));
		System.out.print("Searching for 8: ");
		System.out.println(tree.search(8));
		System.out.print("Searching for 100: ");
		System.out.println(tree.search(100) + "\n\n");
	}
	
	/*
	 * Inserts numbers 0-9 into the tree then tries to delete
	 * 5, 0, 9, and 100. If a number is successfully deleted, it prints
	 * true then prints the tree. If not, prints false.
	 */
	private static void test5() {
		System.out.println("+------+");
		System.out.println(" TEST 5");
		System.out.println("+------+");
		System.out.println("Insert 10 values and delete\n");
		
		AVLTree tree = new AVLTree();
		for (int i = 0; i < 10; i++) {
			System.out.print("insert(" + i +") ");
			tree.insert(i);
		}
		
		printResults(tree);
		System.out.print("\nDeleting 5: ");
		System.out.print(tree.delete(5));
		printResults(tree);
		System.out.print("Deleting 0: ");
		System.out.print(tree.delete(0));
		printResults(tree);
		System.out.print("Deleting 9: ");
		System.out.print(tree.delete(9));
		printResults(tree);
		System.out.print("Deleting 100: ");
		System.out.println(tree.delete(100));;
	}
	
	/*
	 * Prints the given tree in an inorder format and in a hierarchical format
	 */
	private static void printResults(AVLTree tree) {
		System.out.println();
		System.out.println("\nINORDER:");
		System.out.println(tree);
		System.out.println("\nHIERARCHICAL:");
		tree.printHierarchy();
		System.out.println();
	}

}
