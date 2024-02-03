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
 * @author simon
 */
public class PMAX {
      public PaillierT paillier = null;
   // Vector A, Vector B
   public int[] VA = null;
   public int[] VB = null;

   int eee=0;
  
     public BigInteger DPP= null;
   //
 
      public BigInteger D = BigInteger.ONE;
      public Ciphertext P = new Ciphertext();
      
      
      
      public BigInteger E = BigInteger.ONE;
     public BigInteger M = BigInteger.ZERO;
     public BigInteger M1 = BigInteger.ZERO;
     public Ciphertext A =  new Ciphertext();
     public BigInteger B =  BigInteger.ZERO;
      public Ciphertext A1 =   new Ciphertext();
        public Ciphertext A2 =  new Ciphertext();
      public Ciphertext B1 =  new Ciphertext();
      public Ciphertext B2 =  new Ciphertext();
      public Ciphertext B3 =  new Ciphertext();
   public Ciphertext B4 =  new Ciphertext();
    public BigInteger D1 =  BigInteger.ZERO;
     public BigInteger D2 =  BigInteger.ZERO;
      public BigInteger D3 =  BigInteger.ZERO;
       public BigInteger D4 =  BigInteger.ZERO;
   public Ciphertext FIN =  new Ciphertext();
 public BigInteger CCC =  BigInteger.valueOf(2);


   public int kkk = 0;
   //

   public BigInteger   RR = BigInteger.ZERO;

   public Ciphertext a = new Ciphertext();
   public Ciphertext b = new Ciphertext();
  
 
    
    
    public PMAX(Ciphertext  _VA, Ciphertext _VB, PaillierT _paillier) {
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
         A1.T1=(a.T1.modPow(Bi, paillier.nsquare)).multiply(P.T1);
         A1.T2=(a.T2.modPow(Bi, paillier.nsquare)).multiply(P.T2);
         
         B1.T1=b.T1.modPow(Bi, paillier.nsquare);
         B1.T2=b.T2.modPow(Bi, paillier.nsquare);
         
         
         D1=paillier.SDecryption(A1);
         D2=paillier.SDecryption(B1); 
         M = paillier.n.subtract(D);
         
    //    E = paillier.nsquare.divide(Bi);
         E = new BigInteger(512,  new Random());
         A2 = paillier.Encryption(E);
         B2.T1=B1.T1.modPow(M, paillier.nsquare);
         B2.T2=B1.T2.modPow(M, paillier.nsquare);
         
         
         
         B3.T1= (A1.T1.multiply(B2.T1)).modPow(RR, paillier.nsquare);
         B3.T2= (A1.T2.multiply(B2.T2)).modPow(RR, paillier.nsquare);
         
         B4.T1=B3.T1.multiply(A2.T1);
         B4.T2=B3.T2.multiply(A2.T2);
         
        
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

     
       public void StepTwo()
       {
          M1 = paillier.SDecryption(B4);
          if(M1.compareTo(E)>0)
              eee=1;
          if(M1.compareTo(E)<0)
              eee=0;
          
          
          
  
        
 
                 
                 
       }  
               
               
         //////////////////////////////////////////////////////////////////////

   
   
       public void StepThree ()
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
