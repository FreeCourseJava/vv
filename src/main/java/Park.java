package main.java;

import static java.lang.Math.multiplyExact;

public class Park {
    public String name;
    public int length;
    public int width;

    public Park(String jsonStr) throws JsonReadException {
        JSONReader json = new JSONReader(jsonStr);
        this.name = json.getStrFiled("name");
        this.length = json.getIntFiled("length");
        this.width = json.getIntFiled("width");
    }

    public Park (String name, int length, int width ) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    public int calcArea () {
        return multiplyExact(this.length, this.width);
    }

    public JSONWriter getJson() {
        return new JSONWriter()
                .startObject()
                .addStrField("name", name)
                .addIntField("length", length)
                .addIntField("width", width)
                .closeObject();
    }

    public String getJsonString() {
        return getJson().toString();
    }
}
