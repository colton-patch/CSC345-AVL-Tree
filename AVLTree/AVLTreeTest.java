
public class AVLTreeTest {

	public static void main(String[] args) {
		test1();
	}
	
	private static void test1() {
		System.out.println("TEST 1");
		AVLTree tree = new AVLTree();
		for (int i = 0; i < 10; i++) {
			if (!tree.search(i)) {
				int newVal = (int) (Math.random() * 100);
				System.out.print("insert(" + newVal +") ");
				tree.insert(newVal);
			}
		}
		System.out.println();
		System.out.println("\nINORDER:");
		System.out.println(tree);
		System.out.println("\nHIERARCHICAL:");
		tree.printHierarchy();
	}

}
