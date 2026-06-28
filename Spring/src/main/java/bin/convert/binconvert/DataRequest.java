package bin.convert.binconvert;

public class DataRequest {
    private String data;
    private String toFmt;

    public DataRequest() {}

    public DataRequest(String data, String toFmt) {
        this.data = data;
        this.toFmt = toFmt;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String newData) {
        this.data = newData;
    }

    public String getToFmt() {
        return this.toFmt;
    }

    public void setToFmt(String toFmt) {
        this.toFmt = toFmt;
    }

}
