package subtasks;

import parser.Parser;

import java.io.IOException;

/**
 * Created by DELL on 22.10.2018.
 */
public class Part4 {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser("part4.txt", "windows-1251");
        for (Object str : parser) {
            System.out.println(str);
        }

    }
}
