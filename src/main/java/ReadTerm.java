import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.math.BigInteger;

public class ReadTerm {

    private String numExpression = "[+-]?[ \\t]*[+-]?\\d+[ \\t]*";
    private String numExpression1 = "\\s*[+-]?\\d\\s*";
    private String termExpression = "[+-]?[ \\t]*[+-]?[ \\t]*(\\d+[ \\t]" +
                            "*\\*[ \\t]*)?x([ \\t]*\\*\\*[ \\t]*[+-]?\\d+)?";

    BigInteger getNum(String temStr) {
        BigInteger sum = new BigInteger("1");
        for (int i = 0;i <= temStr.length() - 1;i++) {
            if (temStr.charAt(i) == 'x') {
                break;
            }
            if (temStr.charAt(i) == '-') {
                sum = sum.multiply(new BigInteger("-1"));
            }
            if (temStr.charAt(i) >= '0' && temStr.charAt(i) <= '9') {
                int j = i;
                while (temStr.charAt(j) >= '0' && temStr.charAt(j) <= '9') {
                    j++;
                    if (j >= temStr.length()) {
                        break;
                    }
                }
                String numSec = temStr.substring(i,j);
                sum = sum.multiply(new BigInteger(numSec));
                break;
            }
        }
        //System.out.println(sum);
        return sum;
    }

    Polynomial1 getTerm(BufferedReader br) throws IOException {
        //String oriTerm = sc.nextLine();
        String oriTerm = br.readLine();
        Pattern termPa = Pattern.compile(termExpression);
        Matcher termMa = termPa.matcher(oriTerm);
        Pattern termPaNum = Pattern.compile(numExpression);
        Matcher termMaNum = termPaNum.matcher(oriTerm);
        ArrayList<PolyTerm> arrPoly = new ArrayList<>();
        while (termMa.find()) {
            //System.out.println(termMa.group());
            String temStr = termMa.group();
            BigInteger coe = getNum(temStr);
            int i;
            for (i = 0;i <= temStr.length() - 1;i++) {
                if (temStr.charAt(i) == 'x') {
                    break;
                }
            }
            temStr = temStr.substring(i + 1);
            BigInteger ind = getNum(temStr);
            arrPoly.add(new PolyTerm(coe,ind));
        }

        while (termMaNum.find()) {
            if (termMaNum.start() - 2 >= 0) {
                if (oriTerm.charAt(termMaNum.start() - 2) == '*') {
                    continue;
                }
            }
            if (termMaNum.end() < oriTerm.length()) {
                if (oriTerm.charAt(termMaNum.end()) == '*') {
                    continue;
                }
            }
            //System.out.println(termMaNum.group());
            BigInteger reg = getNum(termMaNum.group());
            arrPoly.add(new PolyTerm(reg,new BigInteger("0")));
        }
        return new Polynomial1(arrPoly);
    }

}
