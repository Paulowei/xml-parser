package com.moderneinstein.logical.algorithms    ; 

import java.util.List ; 
import java.util.Vector ; 
import java.util.Set ; 
import java.util.LinkedList  ; 
import java.util.ArrayList  ; 
import java.util.Map ; 
import java.util.TreeMap ; 
import java.util.Objects ;

  // public class DOMElement implements Comparable<DOMElement>
  //,Cloneable  //  public static String  title ; 
public class  XMLElement implements Comparable<XMLElement>,Cloneable {
    private  String  title ; 
    private   List<String>  attributes ; 
    private   List<List<String>>  values  ;
    private String  internal  ;     
    private Map<String,List<String>> stores ;   
    public static final  char notice  = ':' ;
    // public  DOMElement(String params1,String[] params2,String[] params3){  
        /*    attributes = new  ArrayList<String>() ; 
        values = new LinkedList<List<String>>() ;   */
    public  XMLElement(String params1,String inside,String[] params2,String[] params3){
        this.title = new String(params1) ;    
        stores =  new TreeMap<String,List<String>>( ) ;   
        internal =  new String(inside) ; 
        for(int vd=params3.length-2;vd>=0;vd--){  
            Tools.determine(params2[vd],params3[vd],stores) ;
         }
    }    
    /*      //     values.add(params3[vd]) ;
            attributes.add(params2[vd]) ;  */
    //  public  DOMElement(String params1,List<String> params2,List<List<String>> params3 ){  
        /*   this.values = new Vector<List<String>>(params3) ; 
     this.attributes = new LinkedList<String>(params2) ; */
    public  XMLElement(String params1,String attached,List<String> params2,List<List<String>> params3){
     this.title = new  String(params1) ;   
     stores = new TreeMap<String,List<String>>(); 
    internal = new String(attached) ;  
    for(int vt=0;vt<params2.size();vt++){
        stores.put( params2.get(vt),params3.get (vt)) ;
    }
     }  
     // public DOMElement(String  starts)
     /*     this.attributes = new LinkedList<String>() ;
        this.values = new ArrayList<List<String>> () ; */
     public XMLElement(String  starts,String inside){
         this.title  = new String( starts) ;  
         internal =  new String(inside)   ; 
        stores = new TreeMap<String,List<String>>( ) ;     
     }  
    public XMLElement(String notes,List<String> aligns,List<String> lanes,String attached){
        this.stores = new TreeMap<String,List<String>>( ) ;
        this.internal  = new String(attached)  ;
        this.title = new String( notes) ; 
        for(int bt=0;bt< lanes.size( );bt++){
             Tools. determine (aligns.get(bt),lanes.get(bt),stores) ;
         }
    }   
    public void includeTag(String key,String value){
        Tools.determine(key,value,this.stores) ;
    }  
    public XMLElement (XMLElement previous)   {
            this.stores =  new TreeMap<String,List<String>>(previous.stores) ; 
            this.title = new String(previous.title ) ; 
            this.internal = new String(previous.internal) ; 
    } 
     public XMLElement(String tracks,String  within,Map<String,List<String>> created){
        this.internal = new String(within) ; 
        this.title = new String(tracks) ; 
        this.stores = new TreeMap<String,List<String>>(created) ;
     }   

    public List<String> search(String keys){
        if(!stores.containsKey(keys)){ 
            return new Vector<String>() ;
        }else{
            List<String> iterable =  stores.get( keys) ;
            return iterable ; 
         }
    }  
    /*  int height =  attributes.size() ;
        for(int ed=0;ed<height;ed++) {
            String notes =   attributes.get(ed) ; 
            if(notes.equals (keys)){return  values.get(ed) ; }
        }

        return List.of(new String(" ") )  ;  */
    // To be reimplemented later  ;   
    // DOMElement  
        /*public XMLElement(String mains,String crease) {
         this.internal = new String ( crease) ;  
          this.title = new String(mains) ;  
        this.stores = new TreeMap<String,List<String>>() ;
     }  */
    @Override 
     public int compareTo( XMLElement other){    
        int  cases = this.title.compareTo(other.title) ; 
        if(this.title.compareTo(other.title)!=0){
            return   cases ; 
        }
        return cases  ; 
     }  
     @Override   
     public String toString( ) {
         StringBuilder verses = new StringBuilder( ) ; 
        verses.append (title.toString( )) ;  
        verses.append(Character.toString(notice) )  ;  
        verses.append(  internal  ) ;  
        verses.append(String.valueOf(notice)) ;
        verses.append(stores.toString( ))  ;   
        return verses.toString( )  ;  
     }   

     public  Map<String,List<String>> deriveMap( ){
        return  this.stores ; 
     } 
    public String  deriveInternal(){
        return this.internal ; 
    } 
    public String   deriveTitle(){
        return this.title  ;
    }
    public  List<List<String>> deriveValues(){
        return  this.values ; 
    } 
    public List<String>  deriveAttributes(){
        return  this.attributes  ;
    } 
    public void    setMap(Map<String,List<String>> braces){
        this.stores =  new TreeMap<String,List<String>>( braces ); 
    } 
    public void  setInternal(String  words){
        this.internal =  new String( words) ;
    } 
    public void setTitle(String  crest){
        this.title =  new String() ;
    }
    public void setValues(List<List<String>> nested){
        this.values = new  Vector<List<String>>(nested) ; 
    }
    public void setAttributes(List<String> patterns){
        this.attributes = new ArrayList<String>(patterns) ; 
        } 
    
    @Override 
    public boolean equals(Object  other){
        Objects.requireNonNull(other) ; 
        if( other==null){return false ; }  
        XMLElement elems = (XMLElement)other ; 
        if(this.title.equals(elems.deriveTitle())){ 
            return true ;   }
        return false   ; 
    }
}
