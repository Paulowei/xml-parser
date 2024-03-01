package com.moderneinstein.logical.algorithms;


import java.util.Stack ;
import java.util.Queue ;
import java.util.Set  ;
import java.io.PrintStream  ;

import  java.util.ArrayList ;
import java.util.LinkedList  ;
import java.util.Objects  ;
import java.util.List ;

import java.io.StringReader;
import java.util.Map ;
import java.util.Vector ;
import java.util.TreeMap ;
import java.util.TreeSet  ;

import java.util.HashMap ;
import java.util.HashSet ;
import java.util.function.Consumer ; 
import java.lang.Runnable ; 
import java.util.function.Function  ; 

// import java.util.concurrent.Future  ; 
 
import  com.moderneinstein.logical.algorithms.NaryTree;
import com.moderneinstein.logical.algorithms.NaryTree.NaryTreeNode ;
//import com.moderneinstein.logical.algorithms.DOMElement ;
import  com.moderneinstein.logical.algorithms.TreeUtils ;
import com.moderneinstein.logical.algorithms.XMLElement ;

public class XMLParser {

    private LinkedList<NaryTreeNode<XMLElement>>  referral  ;
    private Map<String,List<NaryTreeNode<XMLElement>>>  stores ;
    private Set<XMLElement> elements ;
    public static char delimO1 =  '>' ;
    public static char delimC1 =  '<' ;
    public static char delimC2 = '>' ;
    public static char delimO2  = '<' ;
    public static String closers[] = new String []{">",">"} ;
    public static String[] openers = new String[]{"<","</"} ;
    public static  String SPACE  =new String(" ") ;
    public static char EQUALS = '=' ;
    //  stores = new TreeMap<String,List<NaryTreeNode<XMLElement>>>() ;     
    public static final  String[] operands = new String[ ]{"starts" ,"items","encoding","UTF-8","version","1.0","xml"} ; 
    //public static XMLElement defaults = new XMLElement( operands[ 0],new Vector<String>(),new ArrayList<List<String>>( ),operands[ 1]) ;     
    public static final XMLElement defaults =new XMLElement(operands[6],new ArrayList<String>(),new Vector<String>(),new String()) ; 
    public static final XMLElement  reserve  = new XMLElement(operands[6],new String(),new String[]{operands[2],operands[4]},new String[]{operands[3],operands[5]})  ;
    public XMLParser(){
           referral = new LinkedList<NaryTreeNode<XMLElement>>()   ;
           stores = new   HashMap<String,List<NaryTreeNode<XMLElement>>>() ;
        elements = new TreeSet<XMLElement>() ;
    }
    //   int width =  stripes.charAt(prev)  ;
    public static <M,B>  void resolve(B  keys,M values,Map<B,List<M>> mapper){
        if(!mapper.containsKey(keys)){
            List<M> container = new Vector<M>()  ;
            container.add(values) ;
             mapper.put(keys,container) ;
        }else{
            List<M> braces = mapper.get(keys) ;
            braces.add(values ) ;
        }
    }
    public static  Map<String,List<String>> recreate(String insertion){
        Map<String,List<String>>  frames =new TreeMap<String,List<String>>() ;
        List<String> verses =  Tools.divide(insertion,SPACE.charAt (0))  ; 
     //   System.out.println (insertion ) ; 
      //  System.out.println(verses ) ;  
        for(int  nj=0;nj<verses.size();nj++){
            String commons = verses.get(nj)  ;
            List<String> realise  =  Tools.divide(commons,EQUALS)  ; 
            if(realise.size()<=1){continue ;  }
            Tools.determine(realise.get(0),realise.get(1),frames) ;
        }
        return frames ;
    }
    public static XMLElement createElement(String stripes,String prev,String post){
         int width =  stripes.length () ;
         String derived =   new String(stripes) ;  //.substring(1,width-1) ;
         int states =  0 ; 
         String yield = new String() ; 
         while(states<derived.length()){
            char current =  derived.charAt(states) ;
            if(current==SPACE.charAt(0)){  states= states+1 ; break ; }
            states = states+1 ;
             yield = yield.concat(Character.toString(current)) ;   }
         String intermediate =  derived.substring( states)  ;
         Map<String,List<String>> candidate =  recreate(intermediate) ;
         return new XMLElement(yield,new String( ),new LinkedList<String>(candidate.keySet()),
         new  ArrayList<List<String>>(candidate.values())) ;
    }
    //  while(true){   // (int[] point,String serve,char prev,char  post)
    public static  XMLElement shift(int[] point,String serve,String prev,String  post){
        int phase = point[0]+prev.length()   ;
         int  crest = Tools.deriveFirst(serve,String.valueOf(post),point[0],serve.length( ) );
        StringBuilder builder =new StringBuilder () ;
        while(phase<crest){
            char crease =  serve.charAt(phase) ;
           // if(crease==post){break ; }
            phase = phase+1  ;
            builder.append(crease)  ;
        }
        point[0] = phase+post.length()-1;
        XMLElement created= createElement(builder.toString(),prev,post) ;
        return created ;
    }
    public NaryTreeNode<XMLElement> handleOpener(int[] interrupt,String input){
           XMLElement created =  shift(interrupt,input,openers[0],closers[0]) ;  
            NaryTreeNode<XMLElement> brace = new NaryTreeNode<XMLElement>(created) ;
            if(referral.size()>0){ 
             referral.peekLast().links.add(brace) ;   }
            referral.addLast(brace) ;    
            return brace ;  
    }  
    public NaryTreeNode<XMLElement> handleCloser(int[] interrupt,String input){
           XMLElement element = shift(interrupt,input,openers[1],closers[1]) ;  
                 if(referral.size()==0){return new NaryTreeNode<XMLElement>(element) ; }
                NaryTreeNode<XMLElement>  coils =  referral.peekLast() ;  //System.out.println(coils.value.deriveTitle()) ; 
                 referral.removeLast() ;   
                 return coils ;  
    }  
    /*          //    System.out.println (input) ;
                   System.out.println(voltage) ;  
         //   if(referral.size()==0){referral.addLast
            (new NaryTreeNode<XMLElement>(defaults)) ; }  
                System.out.println( referral.size()) ;       */
    public XMLCore  parse(String input){
        int height = input.length()  ;
        int[] interrupt = new int[2] ; 
        Set<Integer> starts = new HashSet<Integer>( Tools.derivePoints(input,openers[0])) ;
        Set<Integer> limits = new HashSet<Integer>( Tools.derivePoints(input, openers[1])) ;    
         NaryTreeNode<XMLElement>  known = new NaryTreeNode<XMLElement>(defaults)  ;  // new XMLElement( defaults ) ;   
        boolean states = false ;   
        for(interrupt[0]=0;interrupt[0]<height;interrupt[0]++){
            char voltage = input.charAt  (interrupt[0]) ;    
            if(starts.contains(interrupt[0])&&!limits.contains(interrupt[0])){
            NaryTreeNode<XMLElement> brace = handleOpener(interrupt,input)  ; 
            if(states==false){states=true ;  known = referral.peekLast() ;  }
                  continue ;    }
            if(limits.contains(interrupt[0])){
            NaryTreeNode<XMLElement> brace =  handleCloser(interrupt,input) ;
                   continue ;  }   
         if(referral.size ()>0){  
            String prevs = referral.peekLast().value.deriveInternal() ; 
            referral.peekLast().value.setInternal
            (prevs.concat(Character.toString (voltage))) ; }
           }  
        if(referral.size( )==0){referral.clear() ; return  new XMLCore(known) ; }
         referral.clear() ; return  new XMLCore(known)  ; //\referral.element())  ;  // .links.get (0)  // null ;   //point ;   //null ;
    }       

    public  void parseAsync(String input,Consumer<XMLCore> handler){  
        XMLParser  parser = new XMLParser() ; 
        Thread threaded  = new Thread(){
            @Override 
            public void run(){  
                XMLCore cores =  parser.parse(input) ; 
                handler.accept(cores) ; 
            }
        } ;  
        threaded.start() ; 
    }  
    public Future<XMLCore> parseAsync(String input){
        Future<XMLCore>  futures =new Future<XMLCore>() ;  
        XMLParser parser = new XMLParser( ) ; 
        Thread  trials = new Thread(){
            @Override 
            public void run(){
                 XMLCore created = parser.parse(input)  ;  
                futures.succeed( created) ;   
            }
        } ;  
         return futures ; 
    }

   /*   public static void TestString( String present    ) {  
        XMLParser converter = new XMLParser( ) ; 
            XMLCore vertex = converter.parse( present)  ;
            Map<String,List<XMLCore>>  tracks = vertex.orientByTitle( ) ;  
            String places = vertex.toString()  ;  
            List<List<XMLCore>> levels = vertex.deriveLevels( ) ;
         //   System.out.println(places) ; 
          //  System.out.println(tracks.toString( )) ; 
          //  System.out.println(levels.toString()) ;  
    } 
    public static void main(String[] args){    
        PrintStream practice = new PrintStream(System.out) ; 
        XMLParser parser = new XMLParser ( ) ; 
        String trials = new String ("<xml version=1.0 encoding=UTF-8><attempt class=frames><alias width=30px>Trials</alias></attempt><parse id=tracks><alias height=40px>plans</alias></parse>")  ; 
        String efforts =new String( "<xml version=1.0 encoding=UTF-8><properties><project.build.sourceEncoding>UTF-8</project.build.sourceEncoding><maven.compiler.source>1.7</maven.compiler.source><maven.compiler.target>1.7</maven.compiler.target></properties>" ) ;
       // TestString( efforts ) ;    
       // TestString( trials ) ;     
        
    }  */
    //  XMLElement created =  shift(interrupt,input,before,after) ;
    //   DOMElement element = shift(interrupt,input,before,after ) ;
     // interrupt[0] = cs ;  //  DOMElement created =  shift(interrupt,input,before,after) ;

  //  public NaryTree<DOMElement> parse(StringReader serial){ //  }
   // public
     // new NaryTree(point)  ;
        /*NaryTreeNode<XMLElement> temps =  referral.element() ;
            temps.value.internal = temps.value.internal.concat (String.valueOf(voltage)) ; */  
}   
/* trials= new String("<xml version=1.0 encoding=UTF-8><properties><project.build.sourceEncoding>UTF-8</project.build.sourceEncoding><maven.compiler.source>1.7</maven.compiler.source><maven.compiler.target>1.7</maven.compiler.target></properties>") ; 
         XMLCore nodes = parser.parse( trials) ; 
        String brace = nodes.toString( ) ;  
        practice.printf("%s \n" ,brace) ; 
        List<List<XMLCore>> potent = nodes.deriveLevels( ) ;  
        practice.println(potent.toString( )) ; 
        practice.println(nodes.links.size( ))  ;   
        Map<String,List<XMLCore>> plans =  nodes.orientByTitle() ; 
        practice.println(plans) ;    
        String others = new String( ) ;  */   


           /*new DOMElement(yield,new LinkedList<String>(candidate.keySet()),
         new  ArrayList<List<String>>(candidate.values())) ;  */
         //  public static DOMElement createElement(String stripes,char prev,char post){  
 


                // known = referral.peekLast() ;
    // //System.out.println(44) ;referral.clear() ; referral.addLast(new NaryTreeNode<XMLElement>(defaults)) ; return parse(input ) ;  
    // System.out.println(55 ) ;  System.out.println("Resolved ... ... ... ...\n") ;   referral.peekLast().links.add(coils) ; 
    //  NaryTreeNode<XMLElement> point = null ; 
     // referral.add(new NaryTreeNode<XMLElement>(new XMLElement( defaults)))  ;    
    /*      //  System.out.println(limits)  ;  */ 


        //  DOMElement created= createElement(builder.toString(),prev,post) ;
    //    interrupt[0] = cs   ;
       //   cs = interrupt[0] ;
       //  public  NaryTree<DOMElement> parse(String input,char before,char after ){
        // ,char before,char after  // voltage==after  // voltage==before
        // XMLElement element = shift(interrupt,input,before,after ) ;  // NaryTree<XMLElement>  // <XMLElement>  
        // System.out.println (created.deriveTitle()) ;     

        // public class DOMParser {
    /*    private Map<String,String>  stores ;
    private Set<DOMElement> elements ;
     private Queue<NaryTreeNode<DOMElement>>  referral  
      private Queue<NaryTreeNode<XMLElement>>  referral  ;  */
