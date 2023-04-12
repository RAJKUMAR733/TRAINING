package org.example.Service;

public class CreateUserName {

    public static String createUserName(String name,int date,int year,String adharNumber)
    {
        return name.replaceAll("\\s","").substring(0,4)+date+year+
                adharNumber.substring(adharNumber.length()-4,adharNumber.length());
    }
}
