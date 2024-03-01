package com.moderneinstein.logical.algorithms;

//import static org.junit.Assert.assertTrue;

//import org.junit.Test;
 
import org.junit.jupiter.api.Test ; 

import java.util.List ; 
import java.util.Map ; 
import java.util.Arrays ; 
import java.io.PrintStream ; 
import java.util.Vector ;
import java.util.LinkedList ; 

/**
 * Unit test for simple App.
 */  

public class AppTest 
{
    /**
     * Rigorous Test :-)  
     */     
    public static PrintStream crest  = new PrintStream(System.out) ; 
    public static void TestString( String present ,PrintStream  frames   ) {  
        XMLParser converter = new XMLParser( ) ; 
            XMLCore vertex = converter.parse( present)  ;
            Map<String,List<XMLCore>>  tracks = vertex.orientByTitle( ) ;  
            String places = vertex.toString()  ;  
            List<List<XMLCore>> levels = vertex.deriveLevels( ) ;
            frames.println(places) ; 
              frames.println(tracks.toString( )) ; 
            frames.println(levels.toString()) ;  crest.print ( "\n") ; 
    }   
  public static void TestRebuild(String  patterns)  {
      XMLParser parser = new XMLParser( ) ; 
      XMLCore cores =  parser.parse(patterns ) ; 
      String created =  XMLCore.rebuild(cores) ; 
      crest.print(created ) ; 
      crest.print("\n") ;   
      parser = new XMLParser() ; 
      XMLCore attempt = parser.parse(created) ; 
      String repeats =  XMLCore.rebuild(attempt) ;  
       crest.println(repeats.equals(created)) ; 
      crest.printf("%s \n",repeats) ; crest.print("\n") ; 
    }  
 //   @Test
    public void shouldAnswerWithTrue()
    {
      //  assertTrue( true );      
       int [] marks = new int[]{4,3} ; 
      //  System.out.println(marks[5]) ;
        String patterns4 = new String( "<dependency><groupId>junit</groupId><artifactId>junit</artifactId><version>4.11</version><scope>test</scope></dependency>") ;  
        String patterns5 = new String( "<xml version=2.1><pluginManagement><plugins><plugin><artifactId>maven-clean-plugin</artifactId><version>3.1.0</version></plugin><plugin><artifactId>maven-resources-plugin</artifactId><version>3.0.2</version></plugin></plugins></pluginManagement>") ; 
        String patterns6 = new String( "<xml version=1.0 encoding=UTF-8><attempt class=frames><alias width=30px>Trials</alias></attempt><parse id=tracks><alias height=40px>plans</alias></parse>") ;
        TestString(patterns5,crest) ;     
        TestRebuild( patterns6 ) ;
        TestRebuild( patterns4)  ;    
         crest.println( ) ;  
    }  
    // <!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->   
    // <!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
}
