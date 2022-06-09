import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MorseTreeTest {



    @Test
    void insertTest1() {
        MorseTree morseTree= new MorseTree();
        morseTree.insert("E", ".");
        assertEquals(morseTree.getRootNode().getLeft().getLetter(),"E");
    }


    @Test
    void insertTest2() {
        MorseTree morseTree= new MorseTree();
        morseTree.insert("E", ".");
        morseTree.insert("T", "-");
        morseTree.insert("I", "..");
        morseTree.insert("A", ".-");
        morseTree.insert("N", "-.");
        morseTree.insert("M", "--");
        assertEquals(morseTree.getRootNode().getRight().getRight().getLetter(),"M");
    }




    @Test
    void translateTest1() throws FileNotFoundException {
        MorseTree morseTree= new MorseTree();
        Scanner scan= new Scanner(new File("morse.txt"));
        while(scan.hasNext()) {
            String line= scan.next();
            String letter= line.substring(0, 1);
            String code= line.substring(1);
            morseTree.insert(letter,code);
        }
        scan.close();
        String text= "THE FIRST MEME WAS CALLED BABY CHA CHA CHA IT IS TERRIFYING";
        String morseEcodedText= "- .... .  ..-. .. .-. ... -  -- . -- .  .-- .- ...  -.-. .- .-.. .-.. . -..  -... .- -... -.--  -.-. .... .-  -.-. .... .-  -.-. .... .-  .. -  .. ...  - . .-. .-. .. ..-. -.-- .. -. --.";
        assertEquals(text,morseTree.decode(morseEcodedText));
    }


    @Test
    void translateTest2() throws FileNotFoundException {
        MorseTree morseTree= new MorseTree();
        Scanner scan= new Scanner(new File("morse.txt"));
        while(scan.hasNext()) {
            String line= scan.next();
            String letter= line.substring(0, 1);
            String code= line.substring(1);
            morseTree.insert(letter,code);
        }
        scan.close();
        String text= "EARTH IS NOT FLAT STUPID";
        String randomMorseCode= "-.-. --- -- -- . -. -  .- -.  .. -. - . .-. . ... - .. -. --.  ..-. .- -.-. -  .. -.  -.-- --- ..- .-.  -.-. --- -.. .";
        assertNotEquals(text,morseTree.decode(randomMorseCode));
    }

}