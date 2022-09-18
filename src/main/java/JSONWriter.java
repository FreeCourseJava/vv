package main.java;

public class JSONWriter {

    private String json = "";
    // если массив или объект только создан и в нём ещё нет данных
    private boolean isFirstField = true;

    public JSONWriter addIntField(String name, int value) {
        if (this.isFirstField) {
            this.isFirstField = false;
        } else {
            this.json += ",";
        }
        this.json += "\n\"" + name + "\" :" + value;

        return this;
    }

    public JSONWriter addStrField(String name, String value) {
        if (this.isFirstField) {
            this.isFirstField = false;
        } else {
            this.json += ",";
        }
        this.json += "\n\"" + name + "\" : \"" + value + "\"";

        return this;
    }

    public JSONWriter addBooleanField(String name, boolean value) {
        if (this.isFirstField) {
            this.isFirstField = false;
        } else {
            this.json += ",";
        }
        this.json += "\n\"" + name + "\" : " + value;

        return this;
    }


    public JSONWriter addArrayItem(JSONWriter item) {
        if (this.isFirstField) {
            this.isFirstField = false;
        } else {
            this.json += ",";
        }
        this.json += "\n" + item.toString();

        return this;
    }

    public JSONWriter startArray(String name) {
        if (!this.isFirstField) {
            this.json += ",";
        }
        this.isFirstField = true;
        this.json += "\"" + name + "\" : [";

        return this;
    }

    public JSONWriter closeArray() {
        this.json += "\n]";

        return this;
    }

    public JSONWriter startObject() {
        this.json += "{";
        this.isFirstField = true;
        return this;
    }

    public JSONWriter closeObject() {
        this.json += "\n}";
        return this;
    }

    @Override
    public String toString() {
        return this.json;
    }


}
