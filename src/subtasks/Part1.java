package subtasks;

import sun.misc.IOUtils;

import java.io.*;

import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.*;

/**
 * Created by DELL on 21.10.2018.
 */
public class Part1{
 private static  String getText() throws IOException {
     final int bufferSize = 1024;
     final char[] buffer = new char[bufferSize];
     final StringBuilder out = new StringBuilder();
     File file = new File("part1.txt");
     InputStreamReader in = new InputStreamReader(new FileInputStream(file),"windows-1251");

     for (; ; ) {
         int rsz = in.read(buffer, 0, buffer.length);
         if (rsz < 0)
             break;
         out.append(buffer, 0, rsz);
     }
     return out.toString();

 }

    private static boolean check(String str){
        Pattern pattern = Pattern.compile("^.{0,5}$");
        Matcher m = pattern.matcher(str);
        return m.matches();
    }

    private static String convert(String str){
        String string [] = str.split("\\s");
        StringBuilder stringBuilder = new StringBuilder("");
        for(String s: string){
            if(check(s)==false){
                stringBuilder.append(s.toUpperCase()+" ");
            }
            else stringBuilder.append(s+" ");
        }
        return  stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(convert(getText()));
    }






}
