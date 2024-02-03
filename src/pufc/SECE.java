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
 * @author simon
 */
public class SECE {
    
    
      
    public Ciphertext A = new Ciphertext();
    public BigInteger a = BigInteger.ZERO;
    public PaillierT paillier = null;
    public BigInteger h= BigInteger.ZERO;
    public Ciphertext H=  new Ciphertext();
    public BigInteger RR1= BigInteger.ZERO;
    public BigInteger S= BigInteger.ZERO;
    public BigInteger h1= BigInteger.ZERO;
    public Ciphertext  X = new Ciphertext();
    public Ciphertext1  X1 = new Ciphertext1();
    
    
     public Ciphertext F = new Ciphertext();
        public int CCC = 0;
    public int CCC1 = 0;
 
        public SECE(Ciphertext  _VA, BigInteger _VB, PaillierT _paillier) {
         A=  _VA;
         a=  _VB;
         paillier=_paillier;
   }    
      
      
       public void StepOne (){
           
           
            
           RR1 = new BigInteger(20,  new Random());
        if(RR1.equals( BigInteger.ZERO)){
           RR1 = new BigInteger(20,  new Random());
           }
           S = a.modPow(RR1,  paillier.nsquare).modInverse(paillier.nsquare);
           
           Ciphertext B2 = paillier.Encryption(RR1);
           X.T1 = A.T1.multiply(B2.T1);
           X.T2 = A.T2.multiply(B2.T2);
           
           X1 = paillier.WPDecryption1(X);
           CCC = X1.T1.bitLength() + X1.T2.bitLength()+X1.T3.bitLength();
           
       }
         public void StepTwo (){
        // BigInteger Bi = new BigInteger(Integer.toString(a));  
           
         h = paillier.WPDecryption2(X1);
         h1 =  a.modPow(h,paillier.n);
         
         H = paillier.Encryption(h1);
 
         
         
         CCC =  CCC + H.T1.bitLength() + H.T2.bitLength();
     //    System.out.println("========SECBCCC1=="+ CCC1);
     //    System.out.println("========SECBCCC=="+ CCC);
       }     
       
          public void StepThree (){
    
              F.T1 = H.T1.modPow(S, paillier.nsquare);
              F.T2 = H.T2.modPow(S, paillier.nsquare);
       }          
    
    
}
