import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.random.*;
/**
 * FileReader class, essentially takes in an int, which specifies how many elements you want in input4.txt, and then
 * randomly generates them, choosing from the list of tree names which needs to be entered in "treeNames.txt"
 */
public class FileReader {
    final String INPUT_4 = "input4.txt";
    final String TREE_FILE = "treeNames.txt";
    /**
     * Constructor, takes in the number of elements and generates them
     * @param numElements The number of elements you want input4.txt to have
     */
    public FileReader(int numElements){
        generateList(numElements);
    }

    /**
     * This is the method that actually does all the work. it is called when the class is first instantiated,
     * it can also be called after that to regenerate a new random list, in case we want to do unit testing.
     * @param numElements The number of elements you want input4.txt to have
     * @return boolean to show it worked, I didn't really implement this though.
     */
    public boolean generateList(int numElements){
        LinkedList<String> list = new LinkedList<>();
        Scanner scan = null;
        PrintWriter write = null;
        Random rand = new Random();

        try{
            scan = new Scanner(new File(TREE_FILE));
            write = new PrintWriter(new File(INPUT_4));
            while(scan.hasNext()){
                list.add(scan.nextLine());
            }

            for( int i = 0; i < numElements; i++){
                write.write(list.get(rand.nextInt(list.size()))+"\n");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            scan.close();
            write.close();     
        }
        return true;
    }


}
