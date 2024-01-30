package com.moderneinstein.logical.algorithms ; 

import java.util.Arrays ;
import java.util.Queue ;
import java.util.Set  ;
import java.util.Vector ;
import java.util.Objects ;  
import java.util.List ;  
import java.util.Map ;
 import java.util.TreeMap ;  
import java.util.LinkedList  ; 
import java.util.ArrayList  ;  
import java.util.Iterator ;  

import com.moderneinstein.logical.algorithms.XMLParser ;
import com.moderneinstein.logical.algorithms.TreeUtils ; 
import com.moderneinstein.logical.algorithms.XMLElement ; 
import com.moderneinstein.logical.algorithms.NaryTree.NaryTreeNode ; 

public class XMLCore {

   // public NaryTree<H> centre ; 
    public XMLElement  element ;    
    public List<XMLCore>  links ;  //  children ;    
    public XMLCore parent ;   
    public static final String[] theta = new String[]{">",">"} ; 
    public static final String[] delta = new String[] {"</","<"} ; 
    public static String[] extras = new String[]{" "} ; 
    public final static char equals =  '=' ;   
    public final static char space = ' ' ; 
    public XMLCore(XMLElement  value ){
       // centre = new NaryTree(value) ;  
       element =  new XMLElement(value) ;     
       links = new  Vector<XMLCore>( ) ;   
       this.parent = null ;  //this.parent = this ; 
    } 
    public XMLCore (XMLCore append){ 
        this.parent = append.parent ;  
         this.element = new XMLElement(append.element) ; 
         List<XMLCore> serial = append.links ; 
        this.links = new Vector<XMLCore>() ; 
        for(int cr=0;cr<serial.size( );cr++){ 
            XMLCore crest =  new XMLCore (serial.get(cr)) ;   
            crest.parent = this ; 
             this.links.add(crest  )  ;   
        }
    }    
    public XMLCore (XMLElement parts,XMLCore creator){
         this.element =  new XMLElement(parts)  ;
        this.links = new Vector<XMLCore>( ) ; 
        this.parent = creator ;   
     }  
     public void setParent(XMLCore above){
        this.parent = above ;
     } 
    public void setLinks (List<XMLCore> below){
        this.links =new Vector<XMLCore>(below) ;  
    } 
    public void setElement(XMLElement verses){
        this.element  = verses ;
    }  
    public  XMLCore deriveParent(){
        return this.parent ; 
    } 
    public List<XMLCore> deriveLinks( ){
        return  this.links ; 
    } 
    public  XMLElement deriveElement(){
        return this.element ;  
    }
    // new XMLCore(serial.get(cr)) 
    public XMLCore(NaryTreeNode<XMLElement> naries){
        NaryTreeNode<XMLElement> equivs = TreeUtils.cloneNode(naries)   ;   
        links = new Vector<XMLCore> ()  ; 
        XMLCore cores =  createCore( naries )   ; 
        if (cores==null){return ;  }
        this.element = new XMLElement(cores.element) ; 
        this.links = new Vector<XMLCore>(cores.links) ; 
    }      
    @Override 
    public  Object clone() { 
        XMLCore created  = new XMLCore(this.element) ;   
        List<XMLCore> crest = this.links   ;  
        for(int vf=0 ; vf<crest.size();vf++){  
               XMLCore temps = (XMLCore) crest.get(vf).clone( ) ;   
               temps.parent = created  ;   
                created.links.add( temps )  ;  
        }  
        return  created ;
    }  
    //  List<NaryTreeNode<XMLElememt>> elements = nodes.links ; 
    public static  XMLCore createCore(NaryTreeNode<XMLElement> nodes){
        if(nodes==null){return null ;  } 
        List<NaryTreeNode<XMLElement>>  versions = nodes.links ; 
        XMLCore present = new  XMLCore(nodes.value) ; 
        for(int fr=0;fr<versions.size( );fr++){  
               XMLCore temps =  createCore (versions.get(fr)) ;
                present.links.add(temps)  ;
                temps.parent = present  ; 
        }   
        return present ;   
    }   // String example   // findElements  //     }
    //     if( example.equals( samples.element.title)){
    public Map<String,List<XMLCore>>  orientByTitle(){
        Map<String,List<XMLCore>> items = new TreeMap<String,List<XMLCore>>() ; 
        Queue<XMLCore>  channels = new LinkedList<XMLCore>( ) ;   
        channels.offer(this) ; 
        while(!channels.isEmpty ( )){
            XMLCore samples =channels.element( ) ; channels.poll( )   ; 
                Tools.determine(samples.element.deriveTitle(),samples,items) ; 
                List<XMLCore> nexts =  samples.links ; 
                for (int cf=0;cf<nexts.size( );cf++){  
                    channels.offer(nexts.get(cf)) ;  
                }     
        } 
        return  items ;  // null ; 
    }  
    
    public  List<XMLCore> findByTitle(String example){
        Objects.requireNonNull(example) ; 
        List<XMLCore> linear =new ArrayList<XMLCore >( );
        Queue<XMLCore> carrier = new LinkedList<XMLCore>(  )  ; 
        carrier.offer(this) ; 
        while(carrier.size()>0){
            XMLCore parts =  carrier.element( ) ; carrier.poll()  ;  
            if(example.equals(parts.element.deriveTitle())){
                linear.add(parts) ;     }   
            List<XMLCore> appends =  parts.links ;  
            for(int fv=0;fv<appends.size( );fv+=1){
                carrier.offer(appends.get(fv)  )  ;     }   }  
        return  linear ;      }

     public List<List<XMLCore>> deriveLevels(){
        List<List<XMLCore>> crest = new Vector<List<XMLCore>>( ) ; 
        int[] widths = new int[2] ; 
        int[] heights = new int[]{0}  ;   
        explain( this , 0,0,widths,heights)  ;  
        for(int fc=0;fc<=heights[0];fc++){
            crest.add( new ArrayList<XMLCore> ()) ; 
        } 
        unfold(this,0,crest) ;
        return crest ;   
     }  
     public void unfold(XMLCore present,int crest,List<List<XMLCore>> nested){
        if (present==null){return  ; }  
        List<XMLCore> voltage =  nested.get(crest) ; 
        voltage.add(present) ; 
        List<XMLCore> places = present.links ; 
        for(int dc=0;dc<places.size( );dc++)  {
             unfold   (places.get(dc),crest+1,nested  )  ; 
        }
     }
  
     /*   Queue<int[]>  braces =  new LinkedList<int[]>( )  ; braces.offer(new int[]{0,0}) ; 
          Queue<XMLCore> frames = new LinkedList<XMLCore>()  ;  frames.offer(this) ; int[][]  */  
          //   int[][] marks = new int[][ ]{new int[2],new int[2]} ;   while   return marks ;  
    public  void explain(XMLCore current,int posX,int posY,int[] widths,int[] heights){
        if(current==null) {return ;  }  
        widths[1] = Math.max(posX,widths[1])  ; 
        widths[0] = Math.min(posX,widths[0]) ; 
        heights[0] = Math.max(posY,heights[0]) ; 
        List<XMLCore> nexts =  current.links ;
        for( int cf=0 ; cf<nexts.size( );cf++){
            explain(nexts.get(cf),posX+cf-nexts.size( )/2, posY+1,widths,heights) ; 
        }
     }  
    @Override 
    public String toString( ) {
        String plains = this.element.toString( ) ; 
        return plains ;   
    } 
    public static String rebuild(XMLCore voltage){
        if(voltage==null) {return new String( ) ; } 
        StringBuilder  current= new StringBuilder("") ;  
        String[] parts =  collect(voltage) ; 
        current = current.append(parts[0]);  //.append(extras[0]) ;   
        for(int br=0;br<voltage.links.size();br++){
            XMLCore items = voltage.links.get (br) ;  
            String stacks = rebuild(items)  ;    
            current = current.append(stacks) ;    }
        current = current.append (parts[1]) ;
        current = current.append(parts[2]) ; 
        return current.toString() ; 
    }  
    /*List<String> serial = new ArrayList<String>(present.element.stores.keySet( )) ;  
         for(int  rf=0;rf<serial.size();rf++){
            
         } */

    public static String[] collect(XMLCore present){  
        String[] buffers = new String[3] ;
        StringBuilder  notes = new StringBuilder(delta[1]) ;
        notes = notes.append(present.element.deriveTitle()) ;  
        String created =  deriveMap(present.element.deriveMap()) ; 
        notes = notes.append(extras[0]).append(created); 
        buffers[0] =notes.append(theta[1]).toString() ;   // .append(extras[0])
        buffers[1] = new String(present.element.deriveInternal()) ; 
        buffers[2] = new String(delta[0]).concat(present.element.deriveTitle()).concat(theta[0]) ; 
        return buffers ; 
    }    
    //  Iterator<Map.Entry<String,List<String>>> serial
    // = present.element.stores.entrySet().iterator( ) ;  
    public  static String  deriveMap(Map<String,List<String>>  trials){
        Iterator<Map.Entry<String,List<String>>> versions =  trials.entrySet().iterator() ; 
        StringBuilder patterns = new StringBuilder() ; 
        while(versions.hasNext()){
            Map.Entry<String,List<String>> portions= versions.next() ; 
            List<String> iterable  = portions.getValue( ) ;
            for(int fv=0;fv<iterable.size();fv++){  
                 String frames =   portions.getKey().concat(Character.toString(equals)) ;   
                frames = frames.concat(iterable.get(fv)).concat (extras[0]) ;        
                patterns = patterns.append(frames) ;                      
            }    }   
        return  patterns.toString() ; 
    }   
    //  //   int digits = new String("grace") ;
    public void appendNode(XMLElement verses){  
        XMLCore created = new XMLCore( verses,this) ; 
        this.links.add(created) ; 
    } 
    public void setNodeAt(int post,XMLElement crest){
         XMLCore trials = new XMLCore(crest,this) ;   
         if(this.links.size( )<=post){return ;  }
        this.links.set(post,trials) ; 
    }  
    
    public void appendNode(String frontal,String within){
        XMLElement created = new XMLElement(frontal,within) ;
        appendNode(created) ;
    }  
    public void setNodeAt(int post, String title ,String  within){
        XMLElement greet =  new XMLElement(title,within) ; 
        setNodeAt(post,greet) ;
    }
    public void detachNode (int shift){  
            if(this.links.size()<=shift){return ; } 
            this.links.remove(shift) ; 
    }   
    public static NaryTreeNode<XMLElement> correlate(XMLCore voltage){
        if(voltage== null) {return null ;  }  
        NaryTreeNode<XMLElement> current = new NaryTreeNode<XMLElement>(voltage.element) ; 
        List<XMLCore> frames  = voltage.deriveLinks () ; 
        for(int cf=0;cf<frames.size();cf++){
             NaryTreeNode<XMLElement> created = correlate(frames.get(cf))  ; 
             if (created==null){continue ; }   
            current.links.add(created) ;
            created.parent = current  ; 
        } 
        return current ; 
    } 
     public XMLCore reverseCore(){
        NaryTreeNode<XMLElement> elements = correlate(this)  ; 
         TreeUtils.reverseTree( elements) ; 
        XMLCore created =  createCore( elements ); 
        return created ;  
     }  
     @Override 
     public boolean equals(Object checks ){
        if(checks==null ){return false ;  }
         XMLCore potential =  (XMLCore )checks ; 
        if (potential.element.equals(this.element)){return false ; }   
        boolean states =  true ;   
        List<XMLCore> serial  = potential.deriveLinks( ) ; 
        if(this.links.size()!=serial.size( )){return false; }
        for(int  ct=0;ct<this.links.size( );ct+=1){
            boolean bases = this.links.get(ct).equals(serial.get(ct)) ; 
            states = states&bases ; 
        } 
        return  states ; 
     }   
     // XMLElement data
     public List<XMLCore> find(XMLElement  target ){
       // XMLElement elements = new XMLElement(data) ; 
        NaryTreeNode<XMLElement> hierarchy =  correlate(this) ; 
        List<NaryTreeNode<XMLElement>> listed = TreeUtils.find(hierarchy,target);//data) ;//,element) ;  
        List<XMLCore>  vected = new  Vector<XMLCore>() ;
        Iterator<NaryTreeNode<XMLElement>>  iterator =  listed.iterator() ;  
        while(iterator.hasNext()){
            NaryTreeNode<XMLElement> portion =  iterator.next() ;   
             vected.add(createCore(portion)) ;   }
        return vected  ;      }   
     /*   for(int rv=0;rv<listed.size( );rv++){  
            NaryTreeNode<XMLElement> naries = listed.get(rv) ; 
            vected.add(createCore(naries)) ;
        } */
    public  List<XMLCore> find(String data){
        XMLElement crest =  new XMLElement(data,new String()) ;  
        List<XMLCore> found  =  find(crest) ;
        return  found ;   //crest  ;  
    }
     public List<XMLCore> search(XMLCore target){    
        NaryTreeNode<XMLElement> tree4 = correlate( this)  ;   
        NaryTreeNode<XMLElement> tree5 = correlate(target) ;  
         List<NaryTreeNode<XMLElement>> crest = TreeUtils.search(tree4,tree5) ; 
        List<XMLCore> linear = new ArrayList<XMLCore>() ;  
        Iterator<NaryTreeNode<XMLElement>> pointer = crest.iterator( ) ;  
        while(pointer.hasNext()){
            NaryTreeNode<XMLElement> xmlElement = pointer.next( ) ;
            linear.add(new XMLCore(xmlElement)) ;
                    }
        return linear ; 
      }      
}
  //   public static void 

/*public class XMLCore<H> {

    public NaryTree<H> centre ; 
    
    public XMLCore(H value ){
        centre = new NaryTree(value) ; 
    } 
    public List<H> deriveHeight ( int  tracks){
        List<List<H>> nested = TreeUtils.LevelOrder(centre.getRoot()) ;  
        if(tracks>=nested.size( )){return new Vector<H>() ; }
        List<H> vected =  nested.get (tracks)    ;
        return  vected ; 
    } 
    public List<List<H>> deriveTotal( ){  
        if(centre==null){return new Vector<List<H>>( ) ;  } 
        Objects.requireNonNull(centre) ;
        List<List<H>> present = TreeUtils.LevelOrder(centre.getRoot()) ; 
        return present ; 
    }  
     public List<H> deriveHeight ( int  tracks){
        List<List<H>> nested = TreeUtils.LevelOrder(centre.getRoot()) ;  
        if(tracks>=nested.size( )){return new Vector<H>() ; }
        List<H> vected =  nested.get (tracks)    ;
        return  vected ; 
    } 
    public List<List<H>> deriveTotal( ){  
        if(centre==null){return new Vector<List<H>>( ) ;  } 
        Objects.requireNonNull(centre) ;
        List<List<H>> present = TreeUtils.LevelOrder(centre.getRoot()) ; 
        return present ; 
    }  
    
} */
