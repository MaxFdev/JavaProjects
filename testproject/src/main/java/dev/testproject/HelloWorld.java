package dev.testproject;

import static java.lang.System.out;

import java.io.PrintStream;

/**
 * Hello world!
 *
 */
public class HelloWorld 
{
    private static final PrintStream p = System.out;
    public static void main( String[] args )
    {
        System.out.println("Hello World!");
        out.println("Hello World, again.");
        p.println("Goodbye now.");
    }
}
