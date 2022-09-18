package main.java;

public class JSONWriter {

    private String json = "";
    // если массив или объект только создан и в нём ещё нет данных
    private boolean isFirstField = true;

    public JSONWriter addIntField(String name, int value) {
        if (isFirstField) {
            isFirstField = false;
        } else {
            json += ",";
        }
        json += "\n\"" + name + "\" :" + value;

        return this;
    }

    public JSONWriter addStrField(String name, String value) {
        if (isFirstField) {
            isFirstField = false;
        } else {
            json += ",";
        }
        json += "\n\"" + name + "\" : \"" + value + "\"";

        return this;
    }

    public JSONWriter addBooleanField(String name, boolean value) {
        if (isFirstField) {
            isFirstField = false;
        } else {
            json += ",";
        }
        json += "\n\"" + name + "\" : " + value;

        return this;
    }


    public JSONWriter addArrayItem(JSONWriter item) {
        if (isFirstField) {
            isFirstField = false;
        } else {
            json += ",";
        }
        json += "\n" + item.toString();

        return this;
    }

    public JSONWriter startArray(String name) {
        if (!isFirstField) {
            json += ",";
        }
        isFirstField = true;
        json += "\"" + name + "\" : [";

        return this;
    }

    public JSONWriter closeArray() {
        json += "\n]";

        return this;
    }

    public JSONWriter startObject() {
        json += "{";
        isFirstField = true;
        return this;
    }

    public JSONWriter closeObject() {
        json += "\n}";
        return this;
    }

    @Override
    public String toString() {
        return this.json;
    }


}
