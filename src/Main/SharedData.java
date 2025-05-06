/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author Human
 */
import java.util.Date;

public class SharedData {
    private static Date selectedDate = new Date(); // Default to current date

    public static Date getSelectedDate() {
        return selectedDate;
    }

    public static void setSelectedDate(Date date) {
        selectedDate = date;
    }
}
