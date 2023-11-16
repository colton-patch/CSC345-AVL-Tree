
public class AVLTreeTest {

	public static void main(String[] args) {
		test1(); // Insert 10 random values
		test2(); // Insert 50 random values
		test3(); // Insert 20 values in order
		test4(); // Insert 10 values and search
		test5(); // Insert 10 values and delete
	}
	
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
	
	private static void printResults(AVLTree tree) {
		System.out.println();
		System.out.println("\nINORDER:");
		System.out.println(tree);
		System.out.println("\nHIERARCHICAL:");
		tree.printHierarchy();
		System.out.println();
	}

}
