package com.epam.locale;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleTest {

    public static void main(String[] args) {
        String language = "";
        String country = "";

        System.out.println("1 - Беларуская мова" + "\n" + "2 - English language" + "\n" + "3 - Русский язык");

        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1:
                language = "be";
                country = "BY";
                break;
            case 2:
                language = "en";
                country = "UK";
                break;
            case 3:
                language = "ru";
                country = "RU";
                break;
            default:
                language = "en";
                country = "UK";
        }
        Locale locale = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("property.text", locale);


        try {
            String s1 = new String(rb.getString("key1").getBytes("iso-8859-1"),"windows-1251");
            String s2 = new String(rb.getString("key2").getBytes("iso-8859-1"),"windows-1251");
            System.out.println(s1);
            System.out.println(s2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }




    }
}
