/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pufc;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author SimonLau
 */


import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

import java.lang.Integer;
/**
 *
 * @author Rox
 */
public class PPMAX {
   
   // An instance of Paillier Cryptosystem
   public Paillier paillier = null;
   // Vector A, Vector B
   public int[] VA = null;
   public int[] VB = null;

   int eee=0;
  
     public BigInteger DPP= null;
   //
 
      public BigInteger D = BigInteger.ONE;
      public BigInteger P = BigInteger.ONE;
      public BigInteger E = BigInteger.ONE;
     public BigInteger M = BigInteger.ZERO;
     public BigInteger M1 = BigInteger.ZERO;
     public BigInteger A =  BigInteger.ZERO;
     public BigInteger B =  BigInteger.ZERO;
      public BigInteger A1 =  BigInteger.ZERO;
        public BigInteger A2 =  BigInteger.ZERO;
      public BigInteger B1 =  BigInteger.ZERO;
      public BigInteger B2 =  BigInteger.ZERO;
      public BigInteger B3 =  BigInteger.ZERO;
   public BigInteger B4 =  BigInteger.ZERO;
    public BigInteger D1 =  BigInteger.ZERO;
     public BigInteger D2 =  BigInteger.ZERO;
      public BigInteger D3 =  BigInteger.ZERO;
       public BigInteger D4 =  BigInteger.ZERO;
   public BigInteger FIN =  BigInteger.ZERO;
 public BigInteger CCC =  BigInteger.valueOf(2);


   public int kkk = 0;
   //

   public BigInteger   RR = BigInteger.ZERO;

   public BigInteger a = BigInteger.ZERO;
   public BigInteger b = BigInteger.ZERO;
  
 
    
    
    public PPMAX(BigInteger  _VA, BigInteger _VB, Paillier _paillier) {
    a=  _VA;
    b=  _VB;
    paillier=_paillier;
   }
    
    
 
    

   
 
   
     
     
     
     


     
     //////////////////////////////////////////////////////////////////////
     public void StepOne ()
             
         
     {   
           RR = new BigInteger(200,  new Random());
           BigInteger Bi = new BigInteger(Integer.toString(2));
         P=paillier.Encryption(D);
         A1=(a.modPow(Bi, paillier.nsquare)).multiply(P);
         B1=b.modPow(Bi, paillier.nsquare);
       D1=paillier.Decryption(A1);
         D2=paillier.Decryption(B1); 
         M = paillier.n.subtract(D);
         
    //    E = paillier.nsquare.divide(Bi);
         E = new BigInteger(512,  new Random());
        A2 = paillier.Encryption(E);
         B2=B1.modPow(M, paillier.nsquare);
         B3= (A1.multiply(B2)).modPow(RR, paillier.nsquare);
         B4=B3.multiply(A2);
         
         
        
    //      System.out.println("Step One");
         ///////////////////////////
         // generate the paillier  Paillier(int bitLengthVal, int certainty)
 //        paillier = new Paillier(1024, 64);
         //
  //       System.out.println("p = " + paillier.p.toString());
 //        System.out.println("q = " + paillier.q.toString());
   //      System.out.println("n = " + paillier.n.toString());
   //      System.out.println("n^2 = " + paillier.nsquare.toString()); 
         //
        
         
     
         
     }
     
     

     
      //////////////////////////////////////////////////////////////////////

     
       public void NewStepTwo()
       {
          M1 = paillier.Decryption(B4);
          if(M1.compareTo(E)>0)
              eee=1;
          if(M1.compareTo(E)<0)
              eee=0;
          
          
          
  
        
 
                 
                 
       }  
               
               
         //////////////////////////////////////////////////////////////////////

   
   
       public void NewStepThree ()
     {
  //      System.out.println("New Step Three");
          ///////////////////////////
         // generate the paillier  Paillier(int bitLengthVal, int certainty)
         //
     if(eee == 1)
         FIN = a; 
      if(eee == 0)
         FIN = b; 
  // System.out.println("END the permutation ");
         
     } 
    
    
    
}
