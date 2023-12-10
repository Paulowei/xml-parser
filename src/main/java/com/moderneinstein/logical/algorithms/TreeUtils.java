package com.moderneinstein.logical.algorithms ; 


import java.util.Objects  ; 
import java.util.Queue ; 
import java.util.LinkedList ; 
import java.util.ArrayList ; 
import java.util.Set  ; 

import  java.util.List ; 
import java.util.concurrent.ConcurrentLinkedQueue ; 
import java.util.Vector ; 
import java.util.Iterator ;  
import java.util.HashSet  ; 

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

    /*void reverse(char* source){
         int width = strlen(source) ;
         int halfs =  width/2 ; 
         char check = 't' ; // source[0] ; 
         for( int cr=0;cr<halfs;cr++ ){
            check = source[width-cr-1] ; 
            source[width-cr-1] = source[cr] ; 
            source[cr] = check ;  
         }
    } */
    public static <F> void reverseNode(NaryTreeNode<F> voltage){
        if(voltage==null){return ; } 
         List<NaryTreeNode<F>> listed = voltage.links ; 
         int divide =  listed.size( )/2 ; 
        for( int tr=0;tr<divide;tr ++){
            NaryTreeNode<F> brace = listed.get(tr) ; 
            listed.set(tr,listed.get(listed.size()-tr -1)) ; 
            listed.set(listed.size( )-tr-1 ,brace) ; 
        }
    }

    public static <R> void  reverseTree(NaryTreeNode<R> entrance){
        Queue<NaryTreeNode<R>> nodes=   new LinkedList<NaryTreeNode<R>>( ) ;  
        nodes.offer(entrance)  ; 
        while( nodes.size ()>0){
            NaryTreeNode<R> current =  nodes.element () ; nodes.poll () ; 
            if (current ==null ){continue ; } 
             reverseNode(current) ; 
             Iterator<NaryTreeNode<R>> iterator = current.links.iterator(); 
              while(iterator.hasNext()){
                nodes.offer( iterator.next()) ; 
              }
        }
    }  
    public static <D> List<NaryTreeNode<D>> find(NaryTreeNode<D> begin,D value){
        List<NaryTreeNode<D>> vected = new ArrayList<NaryTreeNode<D>>() ;
        Queue<NaryTreeNode<D>>  carrier=  new LinkedList<NaryTreeNode<D>>()  ;  
        carrier.offer(begin )  ; 
        while(!carrier.isEmpty( )){
            NaryTreeNode<D> point = carrier.element( ); carrier.poll(  ) ;
            if(point==null){ continue  ; } 
            if(point.value.equals(value)){vected.add(point) ; }  
            for(int vt=0;vt<point.links.size();vt++){
                carrier.offer(point.links.get( vt)) ;
            }
        }   
        return vected ; 
    }
    public static <X> List<NaryTreeNode<X>> search(NaryTreeNode<X> start,NaryTreeNode<X> target){
        Queue<NaryTreeNode<X>>  queue = new LinkedList<NaryTreeNode<X>>() ; 
        queue.offer(start)  ;  
        List<NaryTreeNode<X>> serial = new LinkedList<NaryTreeNode<X>>() ; 
        while(!queue.isEmpty()){
            NaryTreeNode<X> node = queue.poll() ; 
            if(node==null){continue ;  } 
            if (node.equals( target)){serial.add(node ); continue ; } 
            Iterator<NaryTreeNode<X>> iterator =  node.links.iterator() ; 
            while(iterator.hasNext( )){queue.offer(iterator.next()) ;  }
        }
        return  serial ;  
    }

    public static <F> boolean ensure(NaryTreeNode<F> frames,Set<NaryTreeNode<F>> contains){
            if(frames==null){return true ;  }
            if(contains.contains(frames)){return false ; } 
            contains.add  (frames) ; 
            Iterator<NaryTreeNode<F>> pointer = frames.links.iterator() ; 
            while(pointer.hasNext( )){
                NaryTreeNode<F> yields = pointer.next() ;  
                 boolean cases = ensure(yields,contains) ; 
                 if(cases ==false){return false ; }
            }
            return true  ; 
    }
    public static <V> boolean validate(NaryTreeNode<V> root){
        if( root==null){return true ;} 
        Set<NaryTreeNode<V>> contains = new HashSet<NaryTreeNode<V>>( ) ;
        boolean brace = ensure(root,contains) ;   
        return brace ; 
    }
    
    
    }
