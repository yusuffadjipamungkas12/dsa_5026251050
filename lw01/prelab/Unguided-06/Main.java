import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        BinarySearchTree bst = new BinarySearchTree();

        Scanner line = new Scanner(sc.nextLine());
        while (line.hasNextInt()) {
            bst.insert(line.nextInt());
        }
        line.close();

        int target = sc.nextInt();
        sc.close();

        System.out.print("Preorder : ");
        bst.preOrder();

        System.out.print("Inorder : ");
        bst.inOrder();

        System.out.print("Postorder : ");
        bst.postOrder();

        if (bst.search(target)) {
            System.out.println("Search " + target + " : true");
        } else {
            System.out.println("Search " + target + " : false");
        }

        System.out.println("Minimum : " + bst.findMin());
        System.out.println("Maximum : " + bst.findMax());
    }
}