/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.sound.sampled.Clip;
import model.Line;

/**
 *
 * @author gabri
 */
public class NewClass {
    public static void main(String[] args) throws ParseException {
        int cont2 = 0;
        int cont3 = 0;
        Line line = new Line();
        ArrayList list = line.report("2021-11-24", "2021-11-27");
        System.out.println(list);
        
    }
}
