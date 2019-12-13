package josephus;

import java.io.*;

/**
 *
 * @author Abir Ganguly
 */
public class JosephusOutputObservation {
    
    public static String FILE_NAME;
    public static String FILE_PATH;
    public static int startN;
    public static int endN;
    public static Number[] number;
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter file name:");
        FILE_NAME = br.readLine();
        System.out.println("Enter file path:");
        FILE_PATH = br.readLine();
        FileReader fr = new FileReader(FILE_PATH + "\\" + FILE_NAME);
        BufferedReader brFile = new BufferedReader(fr);
        System.out.println("Enter start n:");
        startN = Integer.valueOf(br.readLine());
        System.out.println("Enter end n:");
        endN = Integer.valueOf(br.readLine());
        number = new Number[endN];
        int k = 0;
        for(int i=1;i<=endN;i++){
            number[k] = new Number(i);
            k = k + 1;
        }
        String currentLine = "";
        while((currentLine = brFile.readLine())!=null){
            for(int i=0;i<currentLine.length();i++){
                char ch = currentLine.charAt(i);
                if(ch==' '){
                    int index = Integer.valueOf(currentLine.substring(i + 1));
                    int numberOfMans = Integer.valueOf(currentLine.substring(0, i));
                    number[index - 1].addToList(numberOfMans);
                }
            }
        }
        for (Number number1 : number) {
            number1.display();
        }
        brFile.close();
        fr.close();
        br.close();
    }
}
