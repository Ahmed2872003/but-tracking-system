/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ahmed
 */
public class EmailValidation {
    
    private static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$";
    
   public static boolean validate(String email) {
       Pattern pattern = Pattern.compile(regex);
       
       Matcher matcher = pattern.matcher(email);
       
       return matcher.matches();
   }
}
    