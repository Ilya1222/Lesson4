package subtasks;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.TreeSet;

/**
 * Created by DELL on 22.10.2018.
 */
public class Part2 {
     public static final String fileName ="the-file-name.txt";
    public static final String fileNameNew ="the-file-name#2.txt";

    private static String  randomValues(){
        StringBuilder stringBuilder = new StringBuilder("");
        Random random = new Random();
         for(int i =0;i<11;i++){
             int n=random.nextInt(50);
             stringBuilder.append(n+" ");
         }
        return stringBuilder.toString();
    }

    private static void newFile() throws Exception {
        Path file = Paths.get(fileName);
        FileWriter nFile = new FileWriter(String.valueOf(file));
            nFile.write(randomValues());
        nFile.close();
    }

    private static String getText() throws IOException {
        File file = new File(fileName);
        int size =(int) file.length();
        FileReader fileReader = new FileReader(file);
        char [] arrayChar = new char[size];
        fileReader.read(arrayChar);
        String text=String.valueOf(arrayChar);
        return text;

    }
    private static String sortString(String string) throws IOException {
        String finish;
        String [] arrayString = string.split(" ");
        TreeSet<Integer> treeSet =new TreeSet();
        for(String s:arrayString){
            int i = Integer.parseInt(s);
            treeSet.add(i);
        }
         finish=treeSet.toString().replaceAll(",|\\[|\\]","");
        Path file = Paths.get(fileNameNew);
        FileWriter nFile = new FileWriter(String.valueOf(file));
        nFile.write(finish);
        nFile.close();
        return finish;
    }

    public static void main(String[] args) throws Exception {
        newFile();
        System.out.println("input==>"+getText());
        System.out.println("output==>"+sortString(getText()));
    }

}
