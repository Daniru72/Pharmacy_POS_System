/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Rashan
 */
public class CreateID {

    public String idSecond() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
        LocalDateTime now = LocalDateTime.MAX.now();

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("MM");
        LocalDateTime now1 = LocalDateTime.MAX.now();

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd");
        LocalDateTime now2 = LocalDateTime.MAX.now();

        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("HH");
        LocalDateTime now3 = LocalDateTime.MAX.now();

        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("mm");
        LocalDateTime now4 = LocalDateTime.MAX.now();

        DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("ss");
        LocalDateTime now5 = LocalDateTime.MAX.now();

        String date = dtf.format(now);
        String date2 = dtf1.format(now1);
        String date3 = dtf2.format(now2);
        String date4 = dtf3.format(now3);
        String date5 = dtf4.format(now4);
        String date6 = dtf5.format(now5);

        String curdate = date + date2 + date3 + date4 + date5 + date6;

        return curdate;

    }

    
    public String idMilliseconds() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
        LocalDateTime now = LocalDateTime.MAX.now();

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("MM");
        LocalDateTime now1 = LocalDateTime.MAX.now();

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd");
        LocalDateTime now2 = LocalDateTime.MAX.now();

        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("HH");
        LocalDateTime now3 = LocalDateTime.MAX.now();

        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("mm");
        LocalDateTime now4 = LocalDateTime.MAX.now();

        DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("sss");
        LocalDateTime now5 = LocalDateTime.MAX.now();

        String date = dtf.format(now);
        String date2 = dtf1.format(now1);
        String date3 = dtf2.format(now2);
        String date4 = dtf3.format(now3);
        String date5 = dtf4.format(now4);
        String date6 = dtf5.format(now5);

        String curdate = date + date2 + date3 + date4 + date5 + date6;

        return curdate;

    }

    
    
}
