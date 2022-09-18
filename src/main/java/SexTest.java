package main.java;

public class SexTest {

    public static void main(String[] args) {
        SexInfo sex = SexEnum.MALE;

        System.out.println(sex.getSexDescription());

        sex = new Sex("MALE", "Man");

        System.out.println(sex.getSexDescription());

    }
}
