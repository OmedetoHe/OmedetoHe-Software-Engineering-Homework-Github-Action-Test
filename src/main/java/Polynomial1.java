import java.util.ArrayList;
import java.math.BigInteger;
import java.util.HashMap;

public class Polynomial1 {
    private ArrayList<PolyTerm> arrPoly = new ArrayList<PolyTerm>();

    public Polynomial1(ArrayList<PolyTerm> arrPoly) {
        this.arrPoly = arrPoly;
    }

    void setPoly(int pos,BigInteger coefficient,BigInteger indexNum) {
        arrPoly.get(pos).setCoefficient(coefficient);
        arrPoly.get(pos).setIndexNum(indexNum);
    }

    PolyTerm getPoly(int pos) {
        return arrPoly.get(pos);
    }

    void deriveTerm() {
        for (int i = 0;i <= arrPoly.size() - 1;i++) {
            arrPoly.get(i).deriveTerm();
        }
    }

    void addTerm(BigInteger ind,BigInteger coe,StringBuffer str) {
        BigInteger zero = new BigInteger("0");
        BigInteger poOne = new BigInteger("1");
        BigInteger neOne = new BigInteger("-1");
        if (ind.compareTo(zero) != 0) {
            if (coe.compareTo(poOne) != 0) {
                if (coe.compareTo(neOne) == 0) {
                    str.append("-");
                }
                else {
                    str.append(coe);
                    str.append("*");
                }
            }
            str.append("x");
            if (ind.compareTo(poOne) != 0) {
                str.append("**");
                str.append(ind);
            }
        }
        else {
            str.append(coe);
        }
    }

    String getTerm() {
        StringBuffer str = new StringBuffer();
        HashMap<BigInteger,BigInteger> hashPoly = new HashMap<>();
        for (int i = 0;i <= arrPoly.size() - 1;i++) {
            if (!hashPoly.containsKey(arrPoly.get(i).getInd())) {
                hashPoly.put(arrPoly.get(i).getInd(),arrPoly.get(i).getCoe());
            }
            else {
                BigInteger neBig = hashPoly.get(arrPoly.get(i).getInd());
                neBig = neBig.add(arrPoly.get(i).getCoe());
                hashPoly.replace(arrPoly.get(i).getInd(),neBig);
            }
        }
        //System.out.println("fuck" + hashPoly.get(new BigInteger("2")));
        boolean flag = false;
        BigInteger zero = new BigInteger("0");
        BigInteger poOne = new BigInteger("1");
        BigInteger neOne = new BigInteger("-1");
        for (BigInteger ind : hashPoly.keySet()) {
            BigInteger coe = hashPoly.get(ind);
            if (coe.compareTo(zero) > 0) {
                flag = true;
                addTerm(ind,coe,str);
                hashPoly.remove(ind);
                break;
            }
        }
        for (BigInteger ind : hashPoly.keySet()) {
            BigInteger coe = hashPoly.get(ind);
            //System.out.println(coe + " " + ind);
            if (coe.compareTo(zero) == 0) {
                continue;
            }
            if (!flag) {
                flag = true;
            }
            else {
                if (coe.compareTo(zero) > 0) {
                    str.append("+");
                }
            }
            addTerm(ind,coe,str);
            //System.out.println(str);
        }
        if (str.length() == 0) {
            str.append("0");
        }
        return str.toString();
    }

}
