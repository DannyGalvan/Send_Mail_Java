package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Email.sendTextEmail("correo prueba", "Mensaje desde Java", "Este Mensaje es una prueba");
    }
}
