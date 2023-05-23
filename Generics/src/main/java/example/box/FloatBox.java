package example.box;

public class FloatBox<S, I, F> {
    private S strValue;
    private I intValue;
    private F fltValue;

    public FloatBox(S strValue, I intValue, F fltValue) {
        setStrValue(strValue);
        setIntValue(intValue);
        setFltValue(fltValue);
    }

    public S getStrValue() {
        return strValue;
    }

    public void setStrValue(S strValue) {
        this.strValue = strValue;
    }

    public I getIntValue() {
        return intValue;
    }

    public void setIntValue(I intValue) {
        this.intValue = intValue;
    }

    public F getFltValue() {
        return fltValue;
    }

    public void setFltValue(F fltValue) {
        this.fltValue = fltValue;
    }
}
