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
// AppBaseTest 
public class VerseTest 
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
            channels.println(levels.toString()) ;  channels.print("\n") ;
    }   
    
    public static void  TestFunctions( String frames){
        XMLParser  compiler = new XMLParser() ; 
        XMLCore nodes = compiler.parse(frames)  ; 
         String  given = XMLCore.rebuild(nodes) ;  
         nodes.deriveLinks( ).get(0).appendNode( "This","included") ; 
        String other = XMLCore.rebuild(nodes) ; 
        plans.printf("%s \n",given) ; 
        plans.printf( "%s \n",other) ;  
        XMLCore current = nodes.deriveLinks().get(0) ; 
         current.detachNode(0) ; 
         String notice =  XMLCore.rebuild( current) ; 
        plans.println( notice) ;  
        current.setNodeAt(1,"replace","element") ; 
        String created = XMLCore.rebuild (current) ; 
        plans.println ( created) ;   plans.println() ;
    }
    //  String[] args 
    @Test
    public void  Signs()
    {
       // System.out.println( "Hello World!" );  
        String  patternsR = new String( "<dependency><groupId>org.junit.jupiter</groupId><artifactId>junit-jupiter-api</artifactId><version>5.9.0</version><scope>test</scope></dependency> ") ;   
        String patternsF  = new String( "<xml version=2.4><groupId>com.moderneinstein.logical.algorithms</groupId><artifactId>xml-parser</artifactId><version>2.4</version><name>xml-parser</name>") ;  
        String patternsD =  new String( "<groupId>com.moderneinstein.logical.algorithms</groupId><artifactId>xml-parser</artifactId><version>2.4</version><name>xml-parser</name>") ; 
        TestString(patternsR,plans)  ; 
        TestString(patternsF, plans) ;   
        TestString(patternsD,plans) ;  
        plans.print("\n") ; 
    }      
     //  main(variables) ; 
     //  main ()  ;     
  @Test   
     public  void Tests(){
        String variables[]  = new String[] {"Test","Variables"} ;   
     //  Signs () ;  
       String patterns4 = new String("<prior><xml version=1.0 encoding=UTF-8><groupId>com.moderneinstein.logical.algorithms</groupId class=names><artifactId>xml-parser</artifactId><version>2.4</version></xml></prior>") ;  
       AppTest.TestRebuild( patterns4 ) ; 
       TestString (patterns4,plans) ;  
       TestFunctions(patterns4 );  
     }   
     // new String("<xml version=1.0 encoding=UTF-8><attempt class=frames><alias width=30px>Trials</alias></attempt><parse id=tracks><alias height=40px>plans</alias></parse>")
}
