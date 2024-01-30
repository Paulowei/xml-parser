package  com.moderneinstein.logical.algorithms ;

import java.util.Set ;
import java.util.Objects ;
import java.util.List ;
import java.util.ArrayList  ;
import java.util.HashSet  ;
import java.io.Serializable   ;
import java.lang.Cloneable ;
import java.lang.Comparable ;
import java.lang.Iterable ;
import  java.util.LinkedList ;
import java.util.Queue  ;


import  com.moderneinstein.logical.algorithms.TreeUtils ;


public    class NaryTree<C> implements Serializable{

    public static class NaryTreeNode<C> implements Serializable,Comparable<NaryTreeNode<C>>,Cloneable{
           public  C value ;
          public  List<NaryTreeNode<C>> links ;
          public NaryTreeNode<C> parent ;
          public NaryTreeNode(C voltage){
            this.value = voltage ;
            this.links = new ArrayList<NaryTreeNode<C>>() ;
            this.parent  =  null  ;
          }
          public  NaryTreeNode(C current,NaryTreeNode<C> ancestor){
            this.links = new ArrayList<NaryTreeNode<C>>( ) ;
            this.value =  current  ;
            this.parent = ancestor ;
          }
          @Override
          public int compareTo( NaryTreeNode<C> other){
              int stated = this.toString().compareTo(other.toString()) ;
              return stated ;
          }
        public Object clone(){
            NaryTreeNode<C> others = TreeUtils.cloneNode(this) ;
            return others ;
        }
        public String toString(){
            String stripes =  this.value.toString() ;
            return stripes ;
        }   
        //   Iterator<NaryTreeNode<C>> iterator = this.links.iterator ; 
        @Override 
        public boolean equals(Object other){
            if(other==null){return false ;  } 
            NaryTreeNode<C> equivs =  (NaryTreeNode<C>)other ;
            if(!this.value.equals(equivs.value)){return false ;  }
            if(equivs.links.size( )!=this.links.size()){return false ;  } 
            for(int ce=0;ce<equivs.links.size();ce++){
                boolean cases = this.links.get(ce).equals(equivs.links.get(ce)) ; 
                if(cases==false){return false ; }
            }
            return true ;  
        }  
        /* while( iterator.hasNext()){
                NaryTreeNode<C>
            } */
    }

    private NaryTreeNode<C>  root  ;
    private Integer  height ;

    public NaryTreeNode<C> getRoot(){
        return  this.root ;
    }
    public NaryTree(C value){
        this.root =  new NaryTreeNode( value ) ;
        this.height = 1 ;  //this.height = -1 ;
    }
    private <N> boolean  searchNode(NaryTreeNode<N> branch,N checks){
        if(branch==null){return false ;}
        if( branch.value.equals(checks)) {return  true ;}
        boolean cases =  false ;
        List<NaryTreeNode<N>>  reach = branch.links ;
        for( int vs=reach.size()-1;vs>=0;vs--){
            if(searchNode(reach.get( vs ),checks)==true){return true ; }
        }
        return cases ;
    }
    public boolean search(C voltage){
        NaryTreeNode<C> phases =  this.root ;
        boolean cases = searchNode(phases,voltage)  ;
        return  cases ;
    }
    public boolean insert(C current){
        NaryTreeNode<C> voltage = this.root ;

      //  while()
      return true ;
    }
    public  boolean  eliminate(C reference){
        NaryTreeNode<C>  upper = this.root ;
        boolean[] buffer = new boolean[]{false   } ;
        NaryTreeNode<C> results =  eliminateNode(upper,reference,buffer) ;
        return buffer[0] ;
    }
    public  static <H>   void  computeWidth(NaryTreeNode<H> capacitor,int[] marksL,int marksR[],int post){
        if(capacitor==null){return  ; }
        marksR[0] = Math.max(marksR[0],post) ;
        marksL[0] = Math.min(marksL[0] ,post) ;
        List<NaryTreeNode<H>> equivs  = capacitor.links  ;
        for(int gs=equivs.size()-1;gs>=0;gs--){
            computeWidth(equivs.get( gs),marksL,marksR,post-equivs.size()/2) ;
        }
    }
    public  <H>  int deriveWidth(NaryTree<H> mains){
        int[]  wests = new int[]{0} ;
        int[] easts = new int[]{0} ;
        int start = 0 ;
        NaryTreeNode<H> gears = mains.root ;
        computeWidth(gears,wests,easts,start) ;
        return easts[0] -  wests[0] ;
    }
    public static <C> NaryTreeNode<C> eliminateNode(NaryTreeNode<C> carrier,C cases,boolean[] clarity){
        if(carrier==null){return carrier ;  }
        if(carrier.value==cases){clarity[0] = true ; return null  ; }
        List<NaryTreeNode<C>> phases= carrier.links ;
        for(int fc=0;fc<phases.size();fc++){
             NaryTreeNode<C> trials =  eliminateNode (phases.get(fc),cases,clarity)  ;
             if(trials==null){phases.remove(fc) ; continue ; }
            phases.set (fc,trials) ;
        }
        return carrier ;
    }  
    //           List<NaryTreeNode<C>> magnetic = current.links ;
    public static <C> Integer[] countNodes(NaryTreeNode<C> voltage){
        Integer[] delta = new Integer[]{Integer.valueOf(0),Integer.valueOf(0) };
        Queue<NaryTreeNode<C>> carrier = new LinkedList<NaryTreeNode<C>>() ;
        Queue<Integer>  channels = new LinkedList<Integer>() ;
        carrier.offer(voltage) ;  channels.offer(Integer.valueOf(0)) ;
        while(!carrier.isEmpty()){
            NaryTreeNode<C> current = carrier.element() ;     carrier.poll() ;
            Integer  drift =  channels.element () ; channels.poll() ;
             if(current==null){continue ; }
             delta[1] = Math.max(delta[1],drift) ;
            delta[0] = delta[0]+1 ;
           for(int  ku=0;ku<current.links.size();ku++){
                carrier.offer(current.links.get (ku)) ;
            channels.offer(drift+1) ;   }    }
        return  delta ;      }
 
    public static <X> void invertNode(NaryTreeNode<X> present){
         List<NaryTreeNode<X>> crest =  present.links ; 
         int halfs = crest.size ()/2 ; 
         for(int bt=crest.size()-1;bt>=halfs;bt-- ){
            NaryTreeNode<X> temps =  crest.get(crest.size()-bt-1) ; 
            crest.set(crest.size()-bt-1,crest.get(bt)) ;  
            crest.set(bt,temps) ; 
         }
    }
        public  void invertTree(){
            NaryTreeNode<C> cores =   this.root ; 
            Queue<NaryTreeNode<C>> greet = new LinkedList<NaryTreeNode<C>>( ) ;
            greet.offer(cores); 
            while(greet.size()>0){
                NaryTreeNode<C> temps =  greet.element()  ;  greet.poll() ;    
                 invertNode(temps)  ; 
                for(int  re=0;re<temps.links.size( );re+=1){
                    greet.offer(temps.links.get(re)) ; 
                }
            }
        } 

        // NaryTreeNode<C>  phase = magnetic.get( ku ) ;
  }
