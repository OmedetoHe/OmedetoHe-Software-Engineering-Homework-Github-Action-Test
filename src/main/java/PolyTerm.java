import java.math.BigInteger;

public class PolyTerm extends PowFuc {

    private BigInteger coefficient;

    public PolyTerm(BigInteger coefficient,BigInteger indexNum) {
        super(indexNum);
        this.coefficient = coefficient;
    }

    void setCoefficient(BigInteger coefficient) {
        this.coefficient = coefficient;
    }

    BigInteger getCoe() {
        return coefficient;
    }

    void deriveTerm() {
        if (this.getInd().compareTo(new BigInteger("0")) == 0) {
            this.coefficient = new BigInteger("0");
        }
        else {
            this.coefficient = this.coefficient.multiply(this.getInd());
            this.setIndexNum(this.getInd().subtract(new BigInteger("1")));
        }
    }

    String getTerm() {
        if (coefficient.compareTo(new BigInteger("0")) == 0) {
            return "0";
        }
        else {
            StringBuffer str = new StringBuffer();
            str.append(coefficient);
            str.append(" * ");
            str.append(super.getTerm());
            return str.toString();
        }
    }

}
