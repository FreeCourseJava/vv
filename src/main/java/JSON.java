package main.java;

public class JSON {

    private String json = "";
    // если массив или объект только создан и в нём ещё нет данных
    private boolean isFirstField = true;

    public JSON addIntField(String name, int value) {
        if (isFirstField) {
            isFirstField = false;
        } else {
            json += ",";
        }
        json += "\n\"" + name + "\" :" + value;

        return this;
    }

    public JSON addStrField(String name, String value) {
        if (isFirstField) {
            isFirstField = false;
        } else {
            json += ",";
        }
        json += "\n\"" + name + "\" : \"" + value + "\"";

        return this;
    }

    public JSON addBooleanField(String name, boolean value) {
        if (isFirstField) {
            isFirstField = false;
        } else {
            json += ",";
        }
        json += "\n\"" + name + "\" : " + value;

        return this;
    }


    public JSON addArrayItem(JSON item) {
        if (isFirstField) {
            isFirstField = false;
        } else {
            json += ",";
        }
        json += "\n" + item.toString();

        return this;
    }

    public JSON startArray(String name) {
        if (!isFirstField) {
            json += ",";
        }
        isFirstField = true;
        json += "\"" + name + "\" : [";

        return this;
    }

    public JSON closeArray() {
        json += "\n]";

        return this;
    }

    public JSON startObject() {
        json += "{";
        isFirstField = true;
        return this;
    }

    public JSON closeObject() {
        json += "\n}";
        return this;
    }

    @Override
    public String toString() {
        return this.json;
    }

}
