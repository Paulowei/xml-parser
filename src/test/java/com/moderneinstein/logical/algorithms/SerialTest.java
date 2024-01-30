package com.moderneinstein.logical.algorithms  ; 


import java.util.Set ; 
import java.util.Queue ; 
import java.util.Map ; 
import java.util.List ; 

import java.lang.reflect.Constructor ; 
import java.lang.reflect.Field ;  
import java.lang.reflect.Method ; 
import java.lang.reflect.Array  ;


import org.junit.jupiter.api.Test ; 

import com.moderneinstein.logical.algorithms.XMLParser  ; 
import com.moderneinstein.logical.algorithms.XMLCore ; 
import com.moderneinstein.logical.algorithms.XMLSerialiser  ; 


public class SerialTest{

    
    public static class TestClass1{

       public  String title ; 
       public String extras ; 
        public TestClass1 ( String params1,String params2){
            this.title = params1 ; 
            this.extras = params2 ;   
        }  
        @Override  
        public String toString(){
            String  created = new String(title ) ; 
            String joint  =  created.concat(" ") ; 
            String lines =  joint.concat(extras) ; 
            return lines  ; 
        }
    } 

    public void dispatch( TestClass1 source) throws Exception  { 
        XMLSerialiser serialiser = new XMLSerialiser() ;
        XMLCore xmlCore =  serialiser.Serialise(source) ; 
        List<List<XMLCore>> levels =  xmlCore.deriveLevels() ; 
        Map<String,List<XMLCore>> mapper = xmlCore.orientByTitle() ; 
        System.out.println (levels.toString())  ; 
        System.out.println(mapper.toString()) ;  
        String straps = XMLCore.rebuild(xmlCore) ; 
        System.out.println (straps) ;    
        ClassLoader loader4 =ClassLoader.getPlatformClassLoader()  ;  
        ClassLoader loader5 =  source.getClass().getClassLoader() ;
          // ClassLoader.getSystemClassLoader() ; 
      //   loader5.resolveClass(source.getClass()) ;
        Object objects =  serialiser.DeSerialise(xmlCore,loader5) ;  
    }
    @Test
    public void test5() throws Exception {
        TestClass1 class1  =  new TestClass1("Trials","Verse" ) ;  
        TestClass1 class2 = new TestClass1("Straight","Straps") ; 
        dispatch(class2) ; 
        dispatch(class1) ;   
        Class<?> clazz =  class2.getClass () ; 
        Constructor<?>[] buffers = clazz.getConstructors() ; 
        Object objects[] = new Object[]{"construct","instance"} ; 
         TestClass1 classes =   (TestClass1)buffers[0].newInstance(objects) ; //(new String[]{}) ;    
         System.out.println(classes.toString()) ; 
    }  
     
    public static void  main(String[] args){
        int width = args.length ; 
        
    }
}