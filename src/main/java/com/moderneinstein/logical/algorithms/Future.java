package com.moderneinstein.logical.algorithms;


import java.util.function.Consumer ; 
import java.util.concurrent.ConcurrentLinkedQueue ;
import java.util.function.Function ; 
import java.lang.Runnable ; 
 import java.lang.Thread ; 


public class Future<C> {
 
    private Consumer<C> successHandler  ;
    private Consumer<Throwable> failureHandler ; 
    private C internal  ; 
    
    public Future(){
            successHandler = new  Consumer<C>(){
                @Override 
                public void accept(C  crest){

                } 
            } ;   
            failureHandler =new Consumer<Throwable>(){
                @Override 
                public void accept(Throwable error){

                }
            }  ; 
    }  
    public void setSuccess(Consumer<C>  inputHandler){
        successHandler = new Consumer<C>( ){
            @Override 
            public void accept(C caller){
                inputHandler.accept(caller) ;
            }
        } ;   
       // if(intern)
    } 
    public void succeed(C  variable){
        Thread present  =   new Thread( ){
            @Override  
             public void run( ){
                successHandler.accept(variable) ;
             }
          } ;  
        this.internal =  variable ; 
        present.run() ;  
    }   
    public void setFailure(Consumer<Throwable> consumes){ 
         failureHandler = new Consumer<Throwable>(){
            @Override 
            public void accept(Throwable thrown){
                consumes.accept(thrown) ; 
            }
         } ;
    } 
    public void fail(Throwable thrown){
        Thread worker = new Thread(){
            @Override 
            public void run(){
                failureHandler.accept(thrown) ;
            }
        }  ;  
        worker.run() ; 
    }
    public  C  collect(){
        return   internal  ; 
    }
}
