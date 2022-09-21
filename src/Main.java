import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        ArrayList<String> data = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();

        result=method(data);
        System.out.println(result);

    }

    public static ArrayList<String> method(ArrayList<String> data){
        ArrayList<String> resultdata = new ArrayList<String>();
        int i=1;
        try {
            File myObj = new File("readfile.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data.add(myReader.nextLine());
                i+=1;
//              System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(data);

        for (String dat:data ){
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(dat);
            while(m.find()) {

                if(Integer.parseInt(m.group())>=10){
                    resultdata.add(dat);
                }
            }


        }
        return resultdata;
    }


}