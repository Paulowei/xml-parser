package com.moderneinstein.logical.algorithms   ;

import java.util.Arrays ; 
import java.util.Vector  ; 
import  java.util.List ;  
import java.util.Set ; 
import java.util.HashSet    ;


import java.lang.ClassLoader ;  
import java.io.InputStream ; 
import java.io.Serializable ; 
import java.util.function.Function ; 

import java.util.Map ; 
import java.util.TreeMap ; 
import java.util.HashMap ; 
import java.lang.reflect.Field ; 

import java.lang.IllegalAccessException  ;
import java.lang.reflect.Method ; 
import java.lang.IllegalArgumentException ;
// import java.lang.ReflectiveOperationException  ;   
//import   java.lang.ReflectiveOperationException ; 

import java.util.Iterator ; 
import java.util.Map ; 
import java.util.Collection ; 
import java.util.TreeSet ;  
//import com.moderneinstein.logical.algorithms.SerialTest  ;
public class XMLSerialiser {
    public static final Class<?>[] terminals =  {Long.class,Float.class,Character.class,String.class,Integer.class,Double.class} ;    
    public static final Class<?>[] helpers = {Set.class,List.class,Map.class,Collection.class } ;  
    public final static   Function<Object,String>[] functional = new Function[]{ XMLSerialiser::DeriveLong,XMLSerialiser::DeriveFloat
        ,XMLSerialiser::DeriveCharacter,XMLSerialiser::DeriveString,XMLSerialiser::DeriveInteger,XMLSerialiser::DeriveDouble} ;  
    public final  static Function<Object,XMLCore>[] relational = new Function[] 
    {XMLSerialiser::Sets,XMLSerialiser::Collections,XMLSerialiser::Maps,XMLSerialiser::Collections} ;
      private Map<Class<?>,Function<Object,String>> mapper   ;  
     
     public XMLSerialiser(){
        mapper = new HashMap<Class<?>,Function<Object,String>>( )  ; 
        int width =  terminals.length ; 
        for(int dc=0;dc<width;dc++){  
            Class<?> clazz = terminals[dc] ; 
            Function<Object,String> worker = functional[dc]  ; 
            mapper.put(clazz,worker) ;
        }
     }   
     // Long::valueOf::andThen( Long::toString)
    public static String DeriveLong(Object source){  
        if(!source.getClass().equals(Long.class)){return source.toString( ) ; }
        Long lines =  (Long)(source) ;  
        long longs =  lines.longValue( ); 
        String sample = Long.toString(lines ) ; 
        return sample ; 
    }   
    public static String  DeriveString(Object source){  
        if(!String.class.equals(source.getClass())){return source.toString(); }
        String  gains = (String)source  ; 
        String other = gains.toString()  ;
        return other ; 
     }    
     public static String DeriveDouble(Object source){  
        if(!source.getClass().equals(Double.class)){return source.toString() ; }
        Double wrapper =  (Double)source ; 
        double primitive =  wrapper.doubleValue() ; 
        String stripes = Double.toString(primitive) ;
        return stripes ; 
   } 
   public static String DeriveFloat(Object input){  
    if(!Float.class.equals(input.getClass())){return input.toString() ; } 
        Float  wrapper = (Float)input ; 
        float primitive = wrapper.floatValue() ; 
        String straps =  Float.toString(primitive) ; 
        return straps ;  
   }  
    public static  String DeriveInteger(Object input){  
        if(!Integer.class.equals(input.getClass())){return  input.toString() ; }
        Integer wrapper =  (Integer)input  ;  
        int  digit =  wrapper.intValue() ; 
        String crest =  Integer.toString(digit) ; 
        return crest ;  
    }  
    public static String DeriveCharacter(Object input){  
        if(!input.getClass().equals(Character.class)){return input.toString() ; }
        Character wrapper =  (Character)input ; 
        char checks = wrapper.charValue() ; 
         String patterns = Character.toString(checks ) ; 
        return patterns   ;    
    }
    //   Collection<Object> collects = (Collection<Object>)source ;   
    public static XMLCore Collections(Object source){
        Collection<?> collects = (Collection<?>)source ;   
        Iterator<?> iterator = collects.iterator() ;   
        XMLElement elements = new XMLElement(source.getClass().getCanonicalName( ),new String()) ;
        XMLCore created =new XMLCore(elements) ;     
        XMLSerialiser serialiser = new XMLSerialiser() ; 
        while(iterator.hasNext()){
            Object  present = iterator.next() ; 
            XMLCore xmls =  serialiser.Serialise(present) ; 
            created.deriveLinks().add(xmls) ; 
          //  xmls.setParent(created) ; 
        }
        return  created  ; //new String("") ; 
    }  
    public static <C,R>  XMLCore  Maps(Object source){  
        Map<C,R> frames =  (Map<C,R>)source ;   
        Set<Map.Entry<C,R>> setty = (Set<Map.Entry<C,R>>)frames.entrySet() ;   
        Iterator<Map.Entry<C,R>> iterator = setty.iterator() ; 
        XMLElement elements = new XMLElement(source.getClass().toGenericString(),new String()) ; 
        XMLCore XmlCore =  new XMLCore(elements) ;  
        XMLSerialiser serialiser = new XMLSerialiser() ;
        while(iterator.hasNext()){ 
            Map.Entry<C,R> entry = iterator.next() ; 
            XMLCore  descendant = serialiser.Serialise(entry) ; 
             descendant.setParent(XmlCore) ;  
            XmlCore.deriveLinks().add( descendant) ;
        }   
        return XmlCore ;   
    }    
    public static <R>  XMLCore Sets(Object source){
        Set<R> setty  =    (Set<R>)source ;  
        Class<?> cleans =  source.getClass() ; 
        Iterator<R> iterator =  setty.iterator() ; 
        XMLElement element = new XMLElement(cleans.descriptorString(),new String()) ; 
        XMLCore central = new XMLCore(element) ;   
        XMLSerialiser  writer = new XMLSerialiser() ; 
        while(iterator.hasNext()){
            R temps = iterator.next() ;  
            XMLCore descendant =  writer.Serialise(temps) ;  
          //  descendant.setParent(central) ; 
            central.deriveLinks().add(descendant) ;
        } 
        return central ;  
    }
    //  ? temps = iterator.hasNext() ;   
    //   // if(source instanceof Collection){  source.getClass().getSimpleName(),
        // descriptorString // descriptorString  // (cleans.getSimpleName(),
    public XMLCore Serialise( Object source) throws IllegalArgumentException{   
        if(source==null){return  new XMLCore(new XMLElement("null","null")) ; }
        if(mapper.containsKey(source.getClass( ))){
            Function<Object,String> verse = mapper.get(source.getClass( )) ; 
             String straps =  verse.apply(source) ;   
             XMLElement created =new XMLElement(source.getClass().getCanonicalName(),straps) ;  
             XMLCore cores = new XMLCore(created) ;
            return  cores     ;  
         }    
        for(int  cs=0;cs<helpers.length;cs++){    
            Class<?> checks = helpers[cs] ;  
         //   System.out.println(source.getClass ().toString( ))   ;  
            if(Tools.isParent(checks,source.getClass())){   //  if(source instanceof    ){ 
                //<?> temps =  helpers[cs] ;   
               Function< Object,XMLCore> frames = relational[cs] ;  
            XMLCore  created = frames.apply(source) ;  
            return created  ;   
            }
         }  

         Class<?> cleans = source.getClass() ; 
         Field[] buffers = cleans.getFields() ;     
         XMLElement element  = new XMLElement(cleans.getCanonicalName(),new String()) ;
         XMLCore parents = new XMLCore(element) ; //(cleans.toString()) ;    
         if(source.getClass().isArray()){
            return parents ; 
         }
         try{
         for(int  cf=0;cf< buffers.length;cf++){  
            Field parts =  buffers[cf] ; 
            Object objects =  parts.get(source) ;  
             XMLCore created =   Serialise(objects) ; 
            parents.deriveLinks().add(created) ;  
          //  created.setParent(parents) ;
         }}catch(IllegalArgumentException|IllegalAccessException except){

         }
        return  parents  ;  // null ;  
    }
    /*  for(int fc=0;fc<width;fc++){
                Object parts =  
            } */
     
    public Object DeSerialise(XMLCore source,ClassLoader loader) throws Exception {
        String patterns = new String("") ;  
      //  ClassLoader loader =  ClassLoader.getSystemClassLoader() ; 
        String upper =  source.element.deriveTitle() ;  
      //  Class<?>  crest =  load; //com.moderneinstein.logical.algorithms.SerialTest.TestClass1.class  ; 
        Class<?> classes =  loader.loadClass("java.lang.String"); // (upper) ;    
        System.out.println(classes.getName()) ;  
        return patterns  ;  
    }   
    /*   Map<C,R> frames =  (Map<C,R>)source ;   
        Set<Map.Entry<C,R>> setty = (Set<Map.Entry<C,R>>)frames.entrySet() ;   
        Set<?> verse =   frames.keySet() ; 
        Iterator<?> iterator = verse.iterator() ; 
        XMLElement element = new XMLElement(source.getClass().getName(),"") ;
        XMLCore cores =   new XMLCore(element) ; 
        XMLSerialiser  worker =  new XMLSerialiser() ; 
        while(iterator.hasNext()){
            Object temps = iterator.next() ; 
            Object other = frames.get(temps) ;
             XMLCore linked =  worker.Serialise(temps) ;  
             XMLCore paired = worker.Serialise(temps) ; 
            linked.parent = cores ; 
            cores.deriveLinks().add(linked) ;
        }    
        return cores ;  
         */
}
