package subtasks;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DELL on 25.10.2018.
 */
public class Part5 {
    private static final String BASE_NAME = "resource";
    private  static  StringBuilder local = new StringBuilder();
    private  static  StringBuilder key = new StringBuilder();

    private static   String getStringFromMain(){
        StringBuilder stringBuilder = new StringBuilder();
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.next()+" ");
        }
        return stringBuilder.toString();
    }

    private static boolean checkLocal(String str){
        Pattern pattern = Pattern.compile("^[a-z]{0,2}$");
        Matcher m = pattern.matcher(str);
        return m.matches();
    }
    private static boolean checkKey(String str){
        Pattern pattern = Pattern.compile("^[A-Za-z]{3,}$");
        Matcher m = pattern.matcher(str);
        return m.matches();
    }

    private static boolean checkEn(String str){
        Pattern pattern = Pattern.compile("^en$");
        Matcher m = pattern.matcher(str);
        return m.matches();
    }
    private static   boolean checkRu(String str){
        Pattern pattern = Pattern.compile("^ru$");
        Matcher m = pattern.matcher(str);
        return m.matches();
    }

    private static void  getLocalAndKey(String str){
         String [] current = str.split(" ");
         for(String s: current){
             if(checkLocal(s)==true){
                 local.append(s+" ");
             }
             if(checkKey(s)==true){
                 key.append(s+" ");
             }
         }
    }
    private static String returnRuResource(String nameResource ,String nameKey, String local) throws UnsupportedEncodingException {
        ResourceBundle bundle1 = ResourceBundle.getBundle(nameResource,new Locale("ru", "RU"));
        String current = new  String ( bundle1.getString(nameKey).getBytes("ISO-8859-1"),("windows-1251"));
        return nameKey+" "+local+"="+current;
    }

    private  static   String returnEngResource(String nameResource ,String nameKey, String local){
        ResourceBundle bundle = ResourceBundle.getBundle(nameResource,new Locale("en", "US"));
        String current = new String(bundle.getString(nameKey));
        return  nameKey+" "+local+"="+current;
    }



    public static void main(String[] args) throws UnsupportedEncodingException {
        getLocalAndKey(getStringFromMain());
        String [] localArr = local.toString().split(" ");
        String [] keyArr = key.toString().split(" ");
         StringBuilder stringBuilder = new StringBuilder();
       for(int i = 0; i<localArr.length; i++ ){
             if(checkEn(localArr[i])==true){
                 stringBuilder.append(returnEngResource(BASE_NAME,keyArr[i],localArr[i])+"\n");
             }
             if(checkRu(localArr[i])==true){
                 stringBuilder.append(returnRuResource(BASE_NAME,keyArr[i],localArr[i])+"\n");
             }
       }
        System.out.println(stringBuilder);
    }
}
