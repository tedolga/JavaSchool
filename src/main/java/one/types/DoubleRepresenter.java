package one.types;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class DoubleRepresenter {
    private long integralPart;
    private short fractionalPart;

    public DoubleRepresenter() {

    }

    public DoubleRepresenter(double value) {
        integralPart = (long) value;
        fractionalPart = (short) Math.abs((long) (value * 10000) - integralPart * 10000);
    }

    public long getIntegralPart() {
        return integralPart;
    }


    public short getFractionalPart() {
        return fractionalPart;
    }

    @Override
    public String toString() {
        StringBuilder stringValue = new StringBuilder();
        stringValue.append(integralPart);
        stringValue.append(".");
        stringValue.append(fractionalPart);
        return stringValue.toString();
    }
}
