package parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by DELL on 22.10.2018.
 */
public class Parser  implements  Iterable{
    private    String fileName;
    private   String encoding;
    private  String [] arr;
    private int size=0;
    public  String getText() throws IOException {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        File file = new File(fileName);
        InputStreamReader in = new InputStreamReader(new FileInputStream(file),encoding);
        for (; ; ) {
            int rsz = in.read(buffer, 0, buffer.length);
            if (rsz < 0)
                break;
            out.append(buffer, 0, rsz);
        }
        return  out.toString();
    }

    private String[] parsing(String string){
        String finish = string.replaceAll("\n","");
        String [] strings = finish.split("\\. |\\.|\\. ");
        String [] current = new String[strings.length];
        for(int i =0 ; i<current.length;i++){
            current[i]=strings[i]+".";
        }
        size = strings.length;
        return current;
    }

    public Parser(String file_name, String encoding) throws IOException {
        fileName=file_name;
        this.encoding=encoding;
        arr=parsing(getText());
    }

    @Override
    public Iterator  iterator() {
        return new myIterator();
    }

    private class myIterator implements Iterator {
         int indicator =0;
         int last=0;

        @Override
        public boolean hasNext() {
            return  indicator!=size;
        }

        @Override
        public Object next() {
            int next =indicator;
            Object [] newArray =  Parser.this.arr;
            if(next>=size) throw new NoSuchElementException();
            if(next>=newArray.length)throw new NoSuchElementException();
            indicator=next+1;
            last=next;
            return  newArray[last];
        }
    }

}
