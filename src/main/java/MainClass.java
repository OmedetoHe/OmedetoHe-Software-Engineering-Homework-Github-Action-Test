import java.io.*;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/input.txt"), "UTF-8"));
        ReadTerm readTerm = new ReadTerm();
        //Polynomial1 myPoly = readTerm.getTerm(sc);
        Polynomial1 myPoly = readTerm.getTerm(br);
        //System.out.println(myPoly.getTerm());
        myPoly.deriveTerm();
        System.out.println(myPoly.getTerm());
    }

}

/*

- 2 * x ** 6 + -6 * x ** 4 + +4 + -4 + 3 * x ** 0 + - x
 */