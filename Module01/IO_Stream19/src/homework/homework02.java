package homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ author Egcoo
 * @ date 2022/7/28 - 9:50
 */
public class homework02 {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\Egcoo\\Desktop\\Download\\news1.txt";
        BufferedReader br = null;
        String line = " ";

        int lineNum = 0;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                System.out.println(++lineNum + " " + line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
