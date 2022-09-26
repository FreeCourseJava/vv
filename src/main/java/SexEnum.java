package main.java;

public enum SexEnum implements SexInfo{
    MALE("Мужчина"),
    FEMALE("Женщина");
    private String desc;
    SexEnum(String desc) {
        this.desc = desc;
    }

    @Override
    public String getSexDescription() {
        return this.desc;
    }
}
