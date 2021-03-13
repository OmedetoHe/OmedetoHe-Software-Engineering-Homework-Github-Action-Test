import java.math.BigInteger;

public class PowFuc {

    private BigInteger indexNum;

    public PowFuc(BigInteger indexNum) {
        this.indexNum = indexNum;
    }

    void setIndexNum(BigInteger indexNum) {
        this.indexNum = indexNum;
    }

    BigInteger getInd() {
        return indexNum;
    }

    String getTerm() {
        StringBuffer str = new StringBuffer();
        str.append("x ** ");
        str.append(indexNum);
        return str.toString();
    }

}
