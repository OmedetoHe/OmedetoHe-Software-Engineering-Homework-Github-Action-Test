import java.util.ArrayList;
import java.math.BigInteger;

public class Polynomial {
    private ArrayList<PolyTerm> arrPoly = new ArrayList<PolyTerm>();

    public Polynomial(ArrayList<PolyTerm> arrPoly) {
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

    String getTerm() {
        StringBuffer str = new StringBuffer();
        for (int i = 0;i <= arrPoly.size() - 1;i++) {
            str.append(" + ");
            str.append(arrPoly.get(i).getTerm());
        }
        return str.toString();
    }

}
