package bin.convert.binconvert;

public class Number {
    private String number;
    private String format;

    public Number() {}

    Number(String numb, String fmt) {
        this.number = numb;
        this.format = fmt;
    }

    public String getNumber() {
        return this.number;
    }

    public String getFormat() {
        return this.format;
    }

    public int expressValue() {
        if (this.format == "deciaml" | this.format == "base10") {
            int trueValue = Integer.parseInt(this.number);
            return trueValue;
        }

        else {
            return 0;
        }
    }
}