package subtasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DELL on 24.10.2018.
 */
public class Part3 {
    private static String getText() throws IOException {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        File file = new File("part3.txt");
        InputStreamReader in = new InputStreamReader(new FileInputStream(file), "windows-1251");

        for (; ; ) {
            int rsz = in.read(buffer, 0, buffer.length);
            if (rsz < 0)
                break;
            out.append(buffer, 0, rsz);
        }
        return out.toString();

    }

    private  static String getStringFromMain(){
        StringBuilder stringBuilder = new StringBuilder();
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.next()+":0");
        }
        return stringBuilder.toString().replaceAll("0"," ");
    }

    private static String[] getArrayString(String str) {
        String full = getStringFromMain()+str;
        String[] arr = full.split(" ");
        return arr;
    }


    private static boolean checkInt(String str) {
        Pattern pattern = Pattern.compile("^[0-9]{0,9}$|int:");
        Matcher m = pattern.matcher(str);
        return m.matches();
    }

    private static boolean checkChar(String str) {
        Pattern pattern = Pattern.compile("^[A-Za-zА-Яа-я]{0,1}|char:$");
        Matcher m = pattern.matcher(str);
        return m.matches();
    }

    private static boolean checkString(String str) {
        Pattern pattern = Pattern.compile("^[A-Za-zА-Яа-я]{2,}|String:$");
        Matcher m = pattern.matcher(str);
        return m.matches();
    }
    private static boolean checkDouble(String str) {
        Pattern pattern = Pattern.compile("^[0-9]{1,}\\.[0-9]{1,}|[0-9]{1,}\\.|\\.[0-9]{1,}|double:$");
        Matcher m = pattern.matcher(str);
        return m.matches();
    }

    private static String convert(String[] strings) {
        StringBuilder getChars = new StringBuilder();
        StringBuilder getInts = new StringBuilder();
        StringBuilder getStrings = new StringBuilder();
        StringBuilder getDoubles = new StringBuilder();
        StringBuilder getAll = new StringBuilder();
        for (String s : strings) {
            if (checkInt(s) == true) {
                getInts.append(s + ",");
            }
            if (checkChar(s) == true) {
                getChars.append(s + ",");
            }
            if (checkString(s) == true  ) {
                getStrings.append(s + ",");
            }
            if (checkDouble(s) == true) {
                getDoubles.append(s + ",");
            }

        }
        getAll.append(getChars + "\n" + getStrings + "\n" + getInts + "\n" + getDoubles + "\n");
        return getAll.toString().replaceAll(",\n", "\n").replaceAll(":,",": ");
    }

    public static void main(String[] args) throws IOException {
        System.out.println(convert(getArrayString(getText())));
    }

}