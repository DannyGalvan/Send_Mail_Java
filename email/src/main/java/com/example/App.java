package com.example;

import java.io.IOException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Email.sendTextEmail("correo prueba", "Mensaje desde Java con properties", "Este Mensaje es una prueba");
    }

    public static Properties applicationProperties() {
        Properties properties = new Properties();
        try {
            properties.load(App.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
