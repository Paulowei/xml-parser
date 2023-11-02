package com.moderneinstein.logical.algorithms ; 

import java.util.Arrays ; 
import java.util.function.Function ;
import java.util.Objects ;
import java.util.Set ; 
import java.util.Map ;
import java.util.HashMap;  
import java.util.List ;
import java.io.PrintStream ;  
import java.io.BufferedWriter ;
import java.io.OutputStreamWriter ;
import java.io.FileOutputStream ; 
import java.io.File  ; 
import java.io.PrintWriter ; 
import java.io.IOException ; 
import java.io.InputStreamReader ; 
import java.io.InputStream ; 
import java.io.FileInputStream ; 
import java.io.InputStreamReader ; 
import java.io.BufferedReader  ; 


public class Central{       
    // //(Function<String[],Object>)Central::Terminal, 
    //  (Function<String[],Object>)Central::FileStream  // "Terminal","FileStream"
    public static String[] express = new String[]{"Terminal_Terminal","Terminal_FileStream","FileStream_Terminal","FileStream_FileStream"} ; 
     public static Function<String[],Object> callers[] = new Function[] { (Function<String[],Object>)Central::TerminalTerminal,
    (Function<String[],Object>)Central::TerminalFileStream,(Function<String[],Object>)Central::FileStreamTerminal,(Function<String[],Object>)Central::FileStreamFileStream }  ; 
     public static Map<String,Function<String[],Object>> alias ; 
    public static PrintStream stream4 = new PrintStream(System.out) ;   
    
    // PrintWriter abstracts
    public static Object Terminal( String source,PrintWriter abstracts,boolean cases ){
           XMLParser converter =new XMLParser( ) ;
           String elements = source ; //[1] ; 
           XMLCore created =  converter.parse(elements) ; 
           Map<String,List<XMLCore>> traces =  created.orientByTitle() ; 
           List<List<XMLCore>> levels = created.deriveLevels () ; 
           if (cases==true){
           abstracts.println(created.toString( )) ; 
           abstracts.println (traces.toString()) ; 
           abstracts.println(levels.toString( )) ;   }
           return  created ; 
    }     
    public static Object TerminalFileStream(String[] buffers){
        String greet =  buffers[2] ;
        File outer = null ; 
        PrintWriter authors = null  ; 
        try{
            outer = new File(buffers[1])  ;  
            authors = createWriter(outer) ;
        }catch (IOException except ){
            except.printStackTrace( ) ; 
        }   
        Object  assigned =  Terminal(greet,authors,true) ;  
        XMLCore attempt =   (XMLCore)assigned  ;  
         authors.close( ) ; 
         return attempt ; 
    }
    public static Object FileStreamTerminal (String[] input){
         PrintWriter writer = null ; 
         File inner = null ; 
        String given = null  ;
        try{
            inner = new File(input[1]) ; 
            given = readFile(inner) ; 
            writer = new PrintWriter(System.out) ;  
        } catch (Exception reluctant){
             reluctant.printStackTrace( ) ; 
        }  
        Object objective =    Terminal(given,writer,true) ; 
        XMLCore cores  = (XMLCore)objective ;  
         writer.close ();  
        return cores ; 
    }   
    //   PrintWriter writer = createWriter(useful) ;  
    public static Object FileStreamFileStream(String[] source){
        File useful = null ;  
        File inner = null ;  
        String yields = null  ;  
        PrintWriter writer = null ; 
        try{
            useful = new File(source[2]) ;  
            inner = new File(source [1]) ; 
            yields = readFile(inner) ;   
            writer = createWriter(useful) ;
        }catch(Exception distress){
              stream4.println(distress.getMessage( )) ; 
        } 
        Object gains =  Terminal(yields,writer,true) ; 
        XMLCore cores = (XMLCore)gains  ;   
        writer.close( ) ;
        return cores   ;    
    } 
    public static Object TerminalTerminal(String[] frames){
         PrintWriter prints = null ;  
         String plans = frames[1] ;      
         OutputStreamWriter writes = null ; 
       //  prints = new PrintWriter(new PrintStream(System.out)) ;
        try{
            prints = new PrintWriter(System.out) ;  
             writes = new OutputStreamWriter(System.out)  ;  
           // writes.write("5454") ; //writes.close( ) ; 
        }catch(Exception except){
            String parts = except.toString ( ) ; 
            stream4.println(parts) ;  
        } 
      //  prints.write("55") ;// prints.close( ) ; 
       //  System.out.println(66) ; 
        Object vectors =  Terminal(plans,prints,true) ;  
        XMLCore voltage = (XMLCore)vectors ;   
        prints.close( ) ;  //writes.write("This was written")  ;//writes.close( ) ; 
        return voltage ;  
    }  
   /// public static PrintStream createOutputStream(File income){
     //   FileOutputStream output = new FileOutputStream
  //  }
    /*  public static Object FileStream(String[] source){
        File files = new File(source[1]) ;
        files.createNewFile( ) ; */ 
   // public static BufferedWriter createWriter( File files){  
    public static PrintWriter createWriter( File files) throws IOException {
        FileOutputStream outer =  new FileOutputStream(files,true ) ; 
        OutputStreamWriter author = new OutputStreamWriter( outer) ; 
        BufferedWriter buffered = new BufferedWriter(author) ;  
        PrintWriter writer = new PrintWriter(buffered) ; 
         return writer  ; 
    }    
    public static BufferedReader createReader(File access ) throws IOException {
        Objects.requireNonNull(access ) ; 
        FileInputStream inner = new FileInputStream(access ) ;
        InputStreamReader stream = new InputStreamReader(inner)  ;
        BufferedReader buffers  = new BufferedReader(stream) ; 
        return buffers ; 
    }  
    // FileWriter written = createReader(pointer)  ; 
     public static String readFile(File pointer) throws IOException{
         BufferedReader reader = createReader(pointer)  ;  
        StringBuilder patterns = new StringBuilder() ; 
        while( true){
            String gains = reader.readLine() ; 
            if( gains==null){break ; } 
            patterns.append(gains) ; 
        } 
        return patterns.toString( ) ;  
    }    
   // public void 
    //  BufferedWriter writer = createWriter(crest) ;  
        public static Object FileStream (String[] source ) {  
            PrintWriter writer = null ;
            File  crest = null ; 
            try{
               crest =  new File  (source[1])  ; 
            crest.createNewFile () ;  
              writer = createWriter(crest) ;   
             }catch(IOException except){
               except.printStackTrace( ) ;  }
            XMLParser converter = new XMLParser() ; 
            XMLCore parent  =   converter.parse(source[2])  ;
            List<List<XMLCore>> listed =  parent.deriveLevels() ; 
             Map<String,List<XMLCore>> tracks = parent.orientByTitle( ) ; 
            writer.write(parent.toString( ) ) ;  writer.print("\n") ; 
            writer.print(tracks.toString( )) ; writer.print("\n") ; 
            writer.write(listed.toString( ))  ;  writer.print("\n") ;  
            writer.close() ; 
            return   parent  ; 
        }   
        //    System.out.println(source[2]) ; 
    //     public static Object FileStream(String[] source){
    public static void configure(){  
        alias = new HashMap<String,Function<String[],Object>>( ) ; 
       // int width =  callers.length ;    
       int width = express.length ;  
        for( int fc=0;fc<width;fc++){
            alias.put(express[fc],callers[fc]) ; 
        }
    }

    public static  void main ( String[] args){
       // alias = new HashMap<String,Function<String[],Object>>( ); 
        configure () ; 
       // Terminal(args) ;  
      // System.out.println (args[ 0 ]) ; 
       Function<String[],Object> worker = alias.get(args[0]) ; 
       Object  derived =  worker.apply(args) ;
       //  stream4.println(args[1]) ;   
       XMLCore cores = (XMLCore)derived ;      
      // Void voided = (Void)(new String("Casts")) ; //new Void( )   ;   
        return  ; 
     }
}