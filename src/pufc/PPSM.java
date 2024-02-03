/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pufc;
import java.math.BigInteger;
import java.util.Random;
/**
 *
 * @author SimonLau
 */
public class PPSM {
  
   public BigInteger a = BigInteger.ZERO;
   public BigInteger b = BigInteger.ZERO;
     public Paillier paillier = null;
   public BigInteger RR1= BigInteger.ZERO;
    public BigInteger RR2 = BigInteger.ZERO;
    public BigInteger RR3= BigInteger.ZERO;
   public BigInteger ERR1= BigInteger.ZERO;
  
    public BigInteger ERR2 = BigInteger.ZERO; 
       public BigInteger ERR3= BigInteger.ZERO;
          public BigInteger ERR4= BigInteger.ZERO;
    
    
     public BigInteger EONE= BigInteger.ONE;
      public BigInteger a1 = BigInteger.ZERO;
       public BigInteger a2 = BigInteger.ZERO;
            public BigInteger EERR1 = BigInteger.ZERO;
       public BigInteger EERR2 = BigInteger.ZERO;
       public BigInteger EERR3 = BigInteger.ZERO;
                   public BigInteger D1 = BigInteger.ZERO;
       public BigInteger D2 = BigInteger.ZERO;
       public BigInteger D3 = BigInteger.ZERO;
       
             public BigInteger m1 = BigInteger.ZERO;
       public BigInteger m2 = BigInteger.ZERO;
       public BigInteger m3 = BigInteger.ZERO;
       public BigInteger m4 = BigInteger.ZERO;
         public BigInteger T1 = BigInteger.ZERO;
           public BigInteger T2 = BigInteger.ZERO;
             public BigInteger T3 = BigInteger.ZERO;
             public BigInteger T4 = BigInteger.ZERO;
            public BigInteger P1 = BigInteger.ZERO;
             public BigInteger P2 = BigInteger.ZERO;     
             public BigInteger FIN = BigInteger.ZERO;
             public BigInteger FIN2 = BigInteger.ZERO;
             
    public PPSM(BigInteger  _VA, BigInteger _VB, Paillier _paillier) {
    a=  _VA;
    b=  _VB;
    paillier=_paillier;
   }
    
          public void StepOne (){
           
           
            
           RR1 = new BigInteger(200,  new Random());
           RR2 = new BigInteger(200,  new Random()); 
           RR3 = RR1.multiply(RR2);
           
          ERR1=paillier.Encryption( RR1);
          ERR2=paillier.Encryption( RR2);
          ERR3=paillier.Encryption( RR3);
           a1= paillier.n.subtract(EONE);
           
           
           T1=a.modPow(RR2, paillier.nsquare); 
           T2=b.modPow(RR1, paillier.nsquare); 
           T3=T1.modPow(a1, paillier.nsquare); 
           T4=T2.modPow(a1, paillier.nsquare); 
           
           EERR1=ERR1.modPow(a1, paillier.nsquare);
         EERR2=ERR2.modPow(a1, paillier.nsquare);
           
         
           EERR3=ERR3.modPow(a1, paillier.nsquare);
           D1=a.multiply(ERR1);
           D2=b.multiply(ERR2);
         } 
   
                    public void StepTwo (){
           
            m1=paillier.Decryption(D2);
            m2=paillier.Decryption(D1); 
            m3=m1.multiply(m2);
            m4=paillier.Encryption(m3);
            
 
         } 
          
                    public void StepThree (){
     //      FIN =m4.multiply(T4);
        FIN = m4.multiply(T3).multiply(T4).multiply(EERR3);
            FIN2= paillier.Decryption(FIN);
 
         }           
          
          
          
    
    
}
