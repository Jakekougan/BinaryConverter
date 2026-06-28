package bin.convert.binconvert;

public class ValueResponse<T> {
        private String value;
        private String format;

        public ValueResponse(String value, String format) {
            this.value = value;
            this.format = format;
        }

        public String getValue() { return value; }
        public String getFormat() { return format; }
        public void setValue(String value) { this.value = value; }
        public void setFormat(String format) { this.format = format; }
    }