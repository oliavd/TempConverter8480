/**
 * Created by oliavd on 2/20/18.
 */

package com.example.oliavd.tempconverter8480;
public class ConverterUtil {
    //convert to celsius
    public static float convertFahrenheitToCelsius(float fahrenheit){
        return ((fahrenheit - 32)*5 / 9);
    }

    //convert to fahrenheit
    public static float convertCelsiusToFahrenheit(float celsius){
        return ((celsius * 9)/5)+32;
    }
}
