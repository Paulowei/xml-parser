package com.moderneinstein.logical.algorithms ; 
import java.util.Vector ; 
import  java.util.Arrays  ;
import java.util.Set ; 
import java.lang.StringBuilder ;
import java.io.Serializable ;  
import java.util.List; 
import java.util.ArrayList ; 
import java.util.Map ; 

public  class Tools{ 


    public static List<String> divide(String income,char chance){
        List<String>  comments = new ArrayList<String>() ;
        int east = 0 ;
        int west = 0 ; 
        while(east<income.length()){
            while(east<income.length()&&income.charAt(east)!=chance){east++ ; }  
            String  parts = income.substring(west,east) ; 
            comments.add(parts)  ;
            while(east<income.length()&&income.charAt(east)==chance){east++  ; }
            west = east  ;  
        }
        return comments ; 
    }     
    //   List<String> lines = new ArrayList<String>() ; 
    public static List<Integer>  derivePoints(String input,String point){ 
        List<Integer> lines = new ArrayList<Integer>() ; 
         for(int  bt=0;bt<input.length()-point.length()+1;bt++){  
            boolean chances = true ;  
            for (int cs=0 ;cs<point.length();cs++){
                if(input.charAt(cs+bt)!= point.charAt(cs)){
                    chances = false ; break ;  
                }
            }  
            if(chances==true){lines.add(bt) ; } 
         }
         return lines ; 
    }    

    public static Integer deriveFirst( String mains ,String check ,int  start,int limit){
        int  spread = check.length( )  ;
       for (int  ts = start;ts<limit-spread+1;ts++){
             boolean phase =  true  ;
             for (int by=0;by<spread;by++){
                if ( mains.charAt(ts+by)!=check.charAt(by)){
                    phase = false  ; 
                    break ; 
                }
             } 
            if ( phase==true){return Integer.valueOf(ts) ; }
       }  
       return Integer.valueOf(-1) ; 
    }
    public static <N,H> void  determine(N names,H hours,Map<N,List<H>> mapper){
        if(mapper.containsKey( names)) {
            List<H> serial = mapper.get(names) ; 
            serial.add(hours) ;
        }else{
            List<H> values = new ArrayList<H>( ) ;
            values.add(hours) ; 
            mapper.put( names,values);  
        }
    }
}