package com.moderneinstein.logical.algorithms;

import org.junit.jupiter.api.Test  ; 
import  java.util.Set ; 
import java.util.Map ; 
import  java.util.Arrays  ;
import java.util.List  ; 
import java.util.Vector ; 
import java.io.PrintStream ; 


/**
 * Hello world!
 *
 */
public class AppBaseTest 
{
    public static PrintStream  plans =  new PrintStream(System.out) ; 
    public static void TestString( String present ,PrintStream channels   ) {  
        XMLParser converter = new XMLParser( ) ; 
            XMLCore vertex = converter.parse( present)  ;
            Map<String,List<XMLCore>>  tracks = vertex.orientByTitle( ) ;  
            String places = vertex.toString()  ;  
            List<List<XMLCore>> levels = vertex.deriveLevels( ) ;
            channels.println(places) ; 
            channels.println(tracks.toString( )) ; 
            channels.println(levels.toString()) ;  
    }   
    //  String[] args 
    @Test
    public void  Signs()
    {
        System.out.println( "Hello World!" );  
        String  patternsR = new String( "<dependency><groupId>org.junit.jupiter</groupId><artifactId>junit-jupiter-api</artifactId><version>5.9.0</version><scope>test</scope></dependency> ") ;   
        String patternsF  = new String( "<xml version=2.4><groupId>com.moderneinstein.logical.algorithms</groupId><artifactId>xml-parser</artifactId><version>2.4</version><name>xml-parser</name>") ;  
        TestString(patternsR,plans)  ; 
        TestString(patternsF, plans) ;  
    }     
   // @Test   
     public  void Tests(){
        String variables[]  = new String[] {"Test","Variables"} ;   
      //  main(variables) ; 
     //  main ()  ;    
       Signs () ;
     }   
     // new String("<xml version=1.0 encoding=UTF-8><attempt class=frames><alias width=30px>Trials</alias></attempt><parse id=tracks><alias height=40px>plans</alias></parse>")
}
