package com.moderneinstein.logical.algorithms ; 


import java.util.Objects  ; 
import java.util.Queue ; 
import java.util.LinkedList ; 
import java.util.ArrayList ; 
import  java.util.List ; 
import java.util.concurrent.ConcurrentLinkedQueue ; 
import java.util.Vector ; 

import  com.moderneinstein.logical.algorithms.NaryTree ; 
import  com.moderneinstein.logical.algorithms.NaryTree.NaryTreeNode ; 

public class TreeUtils {
    
    private static <S> void  recurseLevel(NaryTreeNode<S> saves,Integer alter , List<List<S>> nested){
        if(saves==null){return  ;}
        List<S> equivs =  nested.get(alter)  ;
        equivs.add(saves.value) ; 
        List<NaryTreeNode<S>> nexts = saves.links ; 
        for(int  er=0;er<nexts.size();er++){
            recurseLevel(nexts.get(er),alter+1,nested)  ;
        }
    }
    private  static <F> void serialLevel(NaryTreeNode<F> intro,List<List<F>> levels){
        Queue<NaryTreeNode<F>>  items = new LinkedList<NaryTreeNode<F>>() ;  items.offer(intro) ; 
        Queue<Integer> points= new  LinkedList<Integer>() ; points.add((int)0) ; 
        while(points.size()>0){
            Integer voltage = points.element() ; points.poll ()  ;
            NaryTreeNode<F> current = items.element() ;  items.poll() ; 
            if(current ==null){continue; }
            levels.get(voltage).add(current.value) ; 
            for(int df =0;df<current.links.size();df++){
                items.offer(current.links.get(df)) ; 
                points.offer(voltage+1) ;   } }
    }
    public static <R> List<List<R>>  LevelOrder(NaryTreeNode<R> begin){ 
        Integer[] paired = NaryTree.countNodes(begin)  ;
        Integer reach =   paired[1] ;   
        List<List<R>> aggregate =  new ArrayList<List<R>>() ; 
        for(int fs=reach;fs>=0;fs--){
            List<R> contents = new ArrayList<R>() ; 
         aggregate.add(contents) ; 
        }
        recurseLevel(begin,0,aggregate) ; 
        return aggregate ; 
    }  
    
    public static <T>  void RecurseVertical(NaryTreeNode<T> branch,int drift,List<List<T>> nested){
        if(branch==null){return   ; } 
        List<T> listed = nested.get(drift) ; 
        listed.add(branch.value ) ;
        List<NaryTreeNode<T>> present = branch.links ;
        for(int dc=0;dc<present.size();dc++){
            RecurseVertical(present.get(dc),drift-dc/2,nested ) ; 
        }
    }
    public static <R> List<List<R>> VerticalOrder(NaryTreeNode<R> start){
        int[]  above =  new int[]{0} ;
        int[] below = new int[]{0}  ;
        NaryTree.computeWidth(start,above,below,0) ; 
        int  yield =      above[0]-below[0]+1 ; 
        List<List<R>> represented = new Vector<List<R>>() ;
        for(int sd=0;sd<yield ;sd++){
            List<R> temps = new   LinkedList<R>() ;
                represented.add(temps)  ;    } 
         RecurseVertical(start,below[0]*-1,represented) ;
         return represented ;    
    }  
    //   List<String> strips= new ArrayList<String>() ;
    public static <R> String  Serialize (NaryTreeNode<R> input){
            List<List<R>>  crease =  TreeUtils.LevelOrder (input) ; 
            StringBuilder built = new StringBuilder() ; 
            for(int  cf=0;cf<crease.size();cf++){
                List<R> listed = crease.get (cf)  ; 
                for(int  th=0;th<listed.size();th++){
                    built.append( listed.get(th).toString()) ;
                }
            }
            return built.toString( ) ; 
    }
    public static <V> NaryTreeNode<V>  cloneNode(NaryTreeNode<V>  branch){
         if(branch==null){return  null ;  }  
         // V  recent =  (V)branch.value.clone() ;
        NaryTreeNode<V>  verse  = new NaryTreeNode(branch.value ) ;   
        List<NaryTreeNode<V>> traverse = branch.links ; 
        for(int ds=0;ds< traverse.size();ds++){
             NaryTreeNode<V>  kinds = cloneNode(traverse.get (ds)) ;
             verse.links.add(kinds) ;
        } 
        return  verse ;  
    }

}
