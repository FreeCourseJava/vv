package main.java;

import java.nio.charset.Charset;

public class JSONReader {
    private String json;

    public JSONReader(String json) {
        if (json != null) {
            this.json = json.replaceAll("[\\n ]", "");
        } else {
            this.json = "";
        }
    }

    public int getIntFiled(String name) {

        int nestedLevel = 0;
        for (int i = 0; i < json.length(); i++) {
            // Тут идём посимвольно, смотрим где начало объекта,
            // можно проверить, что началось начало поля, но нет начала объекта - тогда иключение
            // далее ищем имя, сравниваем тип, есои не совпадает - исключение
            if (json.charAt(i) == '{') {
                nestedLevel++;
            } else if (json.charAt(i) == '}') {
                nestedLevel--;
            } else if (json.charAt(i) == '\"' && nestedLevel == 1) {
                int nameFirstPos = i + 1;
                int nameLastPos = json.indexOf('\"', nameFirstPos);
                //System.out.println(json.substring(nameFirstPos, nameLastPos));
                if (name.equals(json.substring(nameFirstPos, nameLastPos))) {
//                    System.out.println(json.substring(nameFirstPos, nameLastPos));
                    String strValue = "";
                    int pos = nameLastPos + 1;
                    boolean readStarted = false;
                    boolean readEnded = false;
                    do {
                        if (Character.isDigit(json.charAt(pos))) {
                            if (readStarted != true) {
                                readStarted = true;
                            }
                            strValue += json.charAt(pos);
                        } else if (readStarted && strValue.length() > 0) {
                            readEnded = true;
                        } else if (readStarted) {
                            System.out.println("error");
                        }
                        pos++;

                    } while (!readEnded);
                    return Integer.parseInt(strValue);
                }

            }
        }

        return -1;
    }

    public String getStrFiled(String name) {

        int nestedLevel = 0;
        for (int i = 0; i < json.length(); i++) {
            // Тут идём посимвольно, смотрим где начало объекта,
            // можно проверить, что началось начало поля, но нет начала объекта - тогда иключение
            // далее ищем имя, сравниваем тип, есои не совпадает - исключение
            if (json.charAt(i) == '{') {
                nestedLevel++;
            } else if (json.charAt(i) == '}') {
                nestedLevel--;
            } else if (json.charAt(i) == '\"' && nestedLevel == 1) {
                int nameFirstPos = i + 1;
                int nameLastPos = json.indexOf('\"', nameFirstPos);
                //System.out.println(json.substring(nameFirstPos, nameLastPos));
                if (name.equals(json.substring(nameFirstPos, nameLastPos))) {
//                    System.out.println(json.substring(nameFirstPos, nameLastPos));
                    String strValue = "";
                    int pos = nameLastPos + 1;
                    boolean readStarted = false;
                    boolean readEnded = false;
                    do {
                        if (json.charAt(pos) == '\"') {
                            if (!readStarted) {
                                readStarted = true;
                            } else if (readStarted && strValue.length() > 0) {
                                readEnded = true;
                            } else {
                                System.out.println("error");
                            }
                        } else if (readStarted) {
                            strValue += json.charAt(pos);
                        }
                        pos++;
                    } while (!readEnded);
                    return strValue;
                }

            }
        }

        return null;
    }


    public boolean getBooleanFiled(String name) {

        int nestedLevel = 0;
        for (int i = 0; i < json.length(); i++) {
            // Тут идём посимвольно, смотрим где начало объекта,
            // можно проверить, что началось начало поля, но нет начала объекта - тогда иключение
            // далее ищем имя, сравниваем тип, есои не совпадает - исключение
            if (json.charAt(i) == '{') {
                nestedLevel++;
            } else if (json.charAt(i) == '}') {
                nestedLevel--;
            } else if (json.charAt(i) == '\"' && nestedLevel == 1) {
                int nameFirstPos = i + 1;
                int nameLastPos = json.indexOf('\"', nameFirstPos);
                //System.out.println(json.substring(nameFirstPos, nameLastPos));
                if (name.equals(json.substring(nameFirstPos, nameLastPos))) {
//                    System.out.println(json.substring(nameFirstPos, nameLastPos));
                    String strValue = "";
                    int pos = nameLastPos + 1;
                    boolean readStarted = false;
                    boolean readEnded = false;
                    do {
                        if (Character.isLetter(json.charAt(pos))) {
                            if (!readStarted) {
                                readStarted = true;
                            }
                            strValue += json.charAt(pos);
                        } else {
                            if (readStarted && strValue.length() > 0) {
                                readEnded = true;
                            } else if (readStarted) {
                                System.out.println("error");
                            }
                        }
                        pos++;

                    } while (!readEnded);
                    return Boolean.parseBoolean(strValue);
                }

            }
        }

        return false;
    }

    public String[] getArrayFiled(String name) {

        int nestedLevel = 0;
        for (int i = 0; i < json.length(); i++) {
            // Тут идём посимвольно, смотрим где начало объекта,
            // можно проверить, что началось начало поля, но нет начала объекта - тогда иключение
            // далее ищем имя, сравниваем тип, есои не совпадает - исключение
            if (json.charAt(i) == '{') {
                nestedLevel++;
            } else if (json.charAt(i) == '}') {
                nestedLevel--;
            } else if (json.charAt(i) == '\"' && nestedLevel == 1) {
                int nameFirstPos = i + 1;
                int nameLastPos = json.indexOf('\"', nameFirstPos);
                //System.out.println(json.substring(nameFirstPos, nameLastPos));
                if (name.equals(json.substring(nameFirstPos, nameLastPos))) {
//                    System.out.println(json.substring(nameFirstPos, nameLastPos));
                    int arrayLevel = 0;

                    String strValue = "";
                    String [] res={};
                    int pos = nameLastPos + 1;
                    boolean readEnded = false;
                    do {
                        if (json.charAt(pos) == '[') {
                            arrayLevel++;
                            if (arrayLevel == 1) {
                                pos++;
                                continue;
                            }
                            strValue += json.charAt(pos);
                        } else if (json.charAt(pos) == ']') {
                            arrayLevel--;
                            if (arrayLevel == 0 && res.length > 0) {
                                readEnded = true;
                            } else if (arrayLevel == 0) {
                                System.out.println("error");
                            } else {
                                strValue += json.charAt(pos);
                            }
                        } else if (arrayLevel > 0) {
                            if (json.charAt(pos) == '{') {
                                nestedLevel++;
                            } else if (json.charAt(pos) == '}') {
                                nestedLevel--;
                            }
                            if (nestedLevel >= 2) {
                                strValue += json.charAt(pos);

                            }
                            if (nestedLevel == 1) {
                                if (json.charAt(pos) != ',') {
                                    strValue += json.charAt(pos);
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

        return null;
    }
}
