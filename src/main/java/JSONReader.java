package main.java;


public class JSONReader {
    private final String json;

    public JSONReader(String json) {
        if (json != null) {
            this.json = json.replaceAll("[\\n ]", "");
        } else {
            this.json = "";
        }
    }

    public int getIntFiled(String name) throws JsonReadException {

        int nestedLevel = 0;
        for (int i = 0; i < this.json.length(); i++) {
            if (this.json.charAt(i) == '{') {
                nestedLevel++;
            } else if (this.json.charAt(i) == '}') {
                nestedLevel--;
            } else if (this.json.charAt(i) == '\"' && nestedLevel == 1) {
                int nameFirstPos = i + 1;
                int nameLastPos = this.json.indexOf('\"', nameFirstPos);
                if (nameLastPos > 0 && name.equals(this.json.substring(nameFirstPos, nameLastPos))) {
                    String strValue = "";
                    int pos = nameLastPos + 1;
                    boolean readStarted = false;
                    boolean readEnded = false;
                    do {
                        if (Character.isDigit(this.json.charAt(pos))) {
                            if (!readStarted) {
                                readStarted = true;
                            }
                            strValue += this.json.charAt(pos);
                        } else if (readStarted && strValue.length() > 0) {
                            readEnded = true;
                        } else if (readStarted) {
                            throw new JsonReadException("input file doesn't container correct json");
                        }
                        pos++;

                    } while (!readEnded);
                    return Integer.parseInt(strValue);
                }

            }
        }

        throw new JsonReadException("Integer field \""+name +"\" was not found");
    }

    public String getStrFiled(String name) throws JsonReadException {

        int nestedLevel = 0;
        for (int i = 0; i < this.json.length(); i++) {
            if (this.json.charAt(i) == '{') {
                nestedLevel++;
            } else if (this.json.charAt(i) == '}') {
                nestedLevel--;
            } else if (this.json.charAt(i) == '\"' && nestedLevel == 1) {
                int nameFirstPos = i + 1;
                int nameLastPos = this.json.indexOf('\"', nameFirstPos);
                if (nameLastPos > 0 && name.equals(this.json.substring(nameFirstPos, nameLastPos))) {
                    String strValue = "";
                    int pos = nameLastPos + 1;
                    boolean readStarted = false;
                    boolean readEnded = false;
                    do {
                        if (this.json.charAt(pos) == '\"') {
                            if (!readStarted) {
                                readStarted = true;
                            } else if (strValue.length() > 0) {
                                readEnded = true;
                            } else {
                                throw new JsonReadException("input file doesn't container correct json");
                            }
                        } else if (readStarted) {
                            strValue += this.json.charAt(pos);
                        }
                        pos++;
                    } while (!readEnded);
                    return strValue;
                }

            }
        }

        throw new JsonReadException("String field \""+name +"\" was not found");
    }


    public boolean getBooleanFiled(String name) throws JsonReadException {

        int nestedLevel = 0;
        for (int i = 0; i < this.json.length(); i++) {
            if (this.json.charAt(i) == '{') {
                nestedLevel++;
            } else if (this.json.charAt(i) == '}') {
                nestedLevel--;
            } else if (this.json.charAt(i) == '\"' && nestedLevel == 1) {
                int nameFirstPos = i + 1;
                int nameLastPos = this.json.indexOf('\"', nameFirstPos);
                if (nameLastPos > 0 && name.equals(this.json.substring(nameFirstPos, nameLastPos))) {
                    String strValue = "";
                    int pos = nameLastPos + 1;
                    boolean readStarted = false;
                    boolean readEnded = false;
                    do {
                        if (Character.isLetter(this.json.charAt(pos))) {
                            if (!readStarted) {
                                readStarted = true;
                            }
                            strValue += this.json.charAt(pos);
                        } else {
                            if (readStarted && strValue.length() > 0) {
                                readEnded = true;
                            } else if (readStarted) {
                                throw new JsonReadException("input file doesn't container correct json");
                            }
                        }
                        pos++;

                    } while (!readEnded);
                    return Boolean.parseBoolean(strValue);
                }

            }
        }

        throw new JsonReadException("Boolean field \""+name +"\" was not found");
    }

    public String[] getArrayFiled(String name) throws JsonReadException {

        int nestedLevel = 0;
        for (int i = 0; i < this.json.length(); i++) {
            if (this.json.charAt(i) == '{') {
                nestedLevel++;
            } else if (this.json.charAt(i) == '}') {
                nestedLevel--;
            } else if (this.json.charAt(i) == '\"' && nestedLevel == 1) {
                int nameFirstPos = i + 1;
                int nameLastPos = this.json.indexOf('\"', nameFirstPos);
                if (nameLastPos > 0 && name.equals(this.json.substring(nameFirstPos, nameLastPos))) {
                    int arrayLevel = 0;

                    String strValue = "";
                    String [] res={};
                    int pos = nameLastPos + 1;
                    boolean readEnded = false;
                    do {
                        if (this.json.charAt(pos) == '[') {
                            arrayLevel++;
                            if (arrayLevel == 1) {
                                pos++;
                                continue;
                            }
                            strValue += this.json.charAt(pos);
                        } else if (this.json.charAt(pos) == ']') {
                            arrayLevel--;
                            if (arrayLevel == 0 && res.length > 0) {
                                readEnded = true;
                            } else if (arrayLevel == 0) {
                                throw new JsonReadException("input file doesn't container correct json");
                            } else {
                                strValue += this.json.charAt(pos);
                            }
                        } else if (arrayLevel > 0) {
                            if (this.json.charAt(pos) == '{') {
                                nestedLevel++;
                            } else if (this.json.charAt(pos) == '}') {
                                nestedLevel--;
                            }
                            if (nestedLevel >= 2) {
                                strValue += this.json.charAt(pos);

                            }
                            if (nestedLevel == 1) {
                                if (this.json.charAt(pos) != ',') {
                                    strValue += this.json.charAt(pos);
                                    String[] tmp = res;
                                    res = new String[tmp.length + 1];
                                    System.arraycopy(tmp, 0, res, 0, tmp.length);
                                    res[tmp.length] = strValue;
                                    strValue = "";
                                }

                            }

                        }

                        pos++;

                    } while (!readEnded);
                    return res;
                }

            }
        }

        throw new JsonReadException("Array \""+name +"\" was not found");
    }
    @Override
    public String toString() {
        return this.json;
    }
}
