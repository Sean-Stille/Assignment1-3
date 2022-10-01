import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.random.*;
/**
 * 
 */
public class FileReader {
    final String INPUT_4 = "input4.txt";
    final String TREE_FILE = "treeNames.txt";
    public FileReader(int numElements){
        generateList(numElements);
    }

    /**
     * 
     * @param numElements 
     * @return
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
        return false;
    }


}
