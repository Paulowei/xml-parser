package com.moderneinstein.logical.algorithms;


import java.util.function.Consumer ; 
import java.util.function.Function ; 

import java.util.Vector ; 
import java.util.Set ; 
import java.util.Arrays ; 

import java.util.Map ;  
import java.util.List ; 


import org.junit.jupiter.api.Test; 

import com.moderneinstein.logical.algorithms.Future  ;

public class AsyncTest {
    
    public void attempt(String input,Consumer<XMLCore> consumer){
        String similar = new String(input) ; 
        XMLParser parser = new XMLParser() ; 
        parser.parseAsync( similar, consumer) ;  
        return   ; 
    }

    public Future<XMLCore> dispatch(String input){
        String clones = new String(input) ;  
        XMLParser parser = new XMLParser() ;
        Future<XMLCore> futures =  parser.parseAsync(input) ;  
        return  futures ; 
    }  



 @Test
    public  void caller(){
        String theta = new String("<groupId>org.apache.maven.plugins</groupId>\r\n" + //
                " <artifactId>maven-surefire-plugin</artifactId>\r\n" + //
                "<version>3.0.0-M7</version>") ;
         String delta = new String("<plugin><groupId>org.apache.maven.plugins</groupId><artifactId>maven-jar-plugin</artifactId><version>3.0.2</version>") ;  
        Future<XMLCore> futures = dispatch(theta) ; 
        Consumer<XMLCore> consumes = new Consumer<XMLCore>(){
            @Override 
            public void  accept(XMLCore cores){
                 Map<String,List<XMLCore>> mapper =  cores.orientByTitle() ;  
                 System.out.println(mapper.toString()) ; 
                String patterns = XMLCore.rebuild( cores) ; 
                System.out.println(patterns) ;  }   } ;  
                futures.setSuccess(consumes) ; 
        attempt(delta ,consumes) ;   
    }

    public static void main(String[] args){
        int  range =  args.length ;  
    }
}
