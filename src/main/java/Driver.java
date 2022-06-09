import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        MorseTree mtree = new MorseTree();

        Scanner scan = new Scanner(new File("morse.txt"));
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String l = line.substring(0, 1);
            String c = line.substring(1);
            mtree.insert(l,c);
        }

        scan.close();
        System.out.println();
        System.out.print("Inorder Traversal: ");
        mtree.printInorder();
        System.out.println();
        System.out.print("Preorder Traversal: ");
        mtree.printPreorder();
        System.out.println();
        System.out.print("Postorder Traversal: ");
        mtree.printPostorder();
        System.out.println();

        Scanner scan2= new Scanner(new File("translate.txt"));
        while (scan2.hasNextLine()){
            String line = scan2.nextLine();
            System.out.println();
            System.out.print("Morse code phrase: " + line);
            System.out.println();
            System.out.print("English phrase: " + mtree.decode(line));


        }






    }

}
