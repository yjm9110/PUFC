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
public class SECB {
    
    
    public Ciphertext A = new Ciphertext();
    public int a = 0;
    public PaillierT paillier = null;
    public BigInteger h= BigInteger.ZERO;
    public Ciphertext H=  new Ciphertext();
    public BigInteger RR1= BigInteger.ZERO;
    public BigInteger S= BigInteger.ZERO;
    public BigInteger h1= BigInteger.ZERO;
    public BigInteger Bi= BigInteger.ZERO;
    public Ciphertext  X = new Ciphertext();
     public Ciphertext F = new Ciphertext();
    public int CCC = 0;
    public int CCC1 = 0;
    
      public SECB(Ciphertext  _VA, BigInteger _VB, PaillierT _paillier) {
         A=  _VA;
          Bi=  _VB;
         paillier=_paillier;
   }
      
      
      
       public void StepOne (){
           
           
            
           RR1 = new BigInteger(20,  new Random());
           S = RR1.modPow(Bi,  paillier.nsquare).modInverse(paillier.nsquare);
           X.T1 = A.T1.modPow(RR1, paillier.nsquare);
           X.T2 = A.T2.modPow(RR1, paillier.nsquare);
          CCC = X.T1.bitLength() + X.T2.bitLength();
     //     CCC1 = X.T1.bitLength() + X.T2.bitLength();
       }
         public void StepTwo (){
      //   BigInteger Bi = new BigInteger(Integer.toString(a));  
           
         h = paillier.SDecryption(X);
         h1 = h.modPow(Bi, paillier.nsquare);
         
         H = paillier.Encryption(h1);
           CCC =  CCC + H.T1.bitLength() + H.T2.bitLength();
       }     
       
          public void StepThree (){
    
              F.T1 = H.T1.modPow(S, paillier.nsquare);
              F.T2 = H.T2.modPow(S, paillier.nsquare);
       }          
       
       
       
       
}
