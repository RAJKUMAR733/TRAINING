package org.example.service;

import java.time.LocalDate;

public class GenerateUniqueId {
    public static String generateUniqueId(LocalDate date)
    {
        return ""+System.currentTimeMillis()+date.getYear();
    }
}
