package main.java;

public class JSON {

    private String json = "";
    private boolean isFirstField = true;

    public JSON addIntField(String name, int value) {

        json += "\n\"" + name + "\" :" + value;

        return this;
    }

    public JSON addArrayItem(JSON item) {
        if (isFirstField) {
            isFirstField = false;
        } else {
            json += ",";
        }
        json += item.toString();

        return this;
    }

    public JSON startArray(String name ) {
        if (isFirstField) {

        } else {
            json += ",";
        }
        json += "\"" + name + "\" : [";

        return this;
    }

    public JSON closeArray() {
        json += "\n]";

        return this;
    }

    public JSON startObject() {
        json += "{\n";

        return this;
    }
    public JSON closeObject() {
        json += "\n}";
        isFirstField = true;

        return this;
    }

    @Override
    public String toString() {
        return this.json;
    }
}
