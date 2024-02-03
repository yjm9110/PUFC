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
public class SEC {
    
    
      
    public Ciphertext A = new Ciphertext();
    public Ciphertext B = new Ciphertext();
    public BigInteger a = BigInteger.ZERO;
    public PaillierT paillier = null;
    public BigInteger h= BigInteger.ZERO;
    public Ciphertext H=  new Ciphertext();
    public BigInteger H1=  BigInteger.ZERO;
    public BigInteger H2=  BigInteger.ZERO;
    public BigInteger H3=  BigInteger.ZERO;
    public BigInteger H4=  BigInteger.ZERO;
    public BigInteger H5=  BigInteger.ZERO;
    public BigInteger H6=  BigInteger.ZERO;
    public Ciphertext H7=  new Ciphertext();
    public Ciphertext H8=  new Ciphertext();
    public Ciphertext K1=  new Ciphertext();
    public Ciphertext K2=  new Ciphertext();
    public Ciphertext T1=  new Ciphertext(); 
    public Ciphertext T2=  new Ciphertext();
    public Ciphertext T3=  new Ciphertext();
    
    
    public BigInteger RR1= BigInteger.ZERO;
    public BigInteger rr1= BigInteger.ZERO;
    public BigInteger tt1= BigInteger.ZERO;
    public BigInteger tt2= BigInteger.ZERO;
    
    public Ciphertext X1 =  new Ciphertext();
    public Ciphertext X2 =  new Ciphertext();
    public Ciphertext Y1 =  new Ciphertext();
    public Ciphertext Y2 =  new Ciphertext();
    
    public Ciphertext1 X11 =  new Ciphertext1();
    public Ciphertext1 X12 =  new Ciphertext1();
    public Ciphertext1 Y11 =  new Ciphertext1();
    public Ciphertext1 Y12 =  new Ciphertext1();    
    
    public BigInteger s1 = BigInteger.ZERO;
    public BigInteger s2 = BigInteger.ZERO;
    public BigInteger h2 = BigInteger.ZERO;
    public BigInteger k2 = BigInteger.ZERO;
    
    public BigInteger S= BigInteger.ZERO;
    public BigInteger h1= BigInteger.ZERO;
    public Ciphertext  X = new Ciphertext();
    public Ciphertext F = new Ciphertext();
    public Ciphertext F2 = new Ciphertext();
    public Ciphertext F3 = new Ciphertext();
    public BigInteger Fin2= BigInteger.ZERO;
    public int CCC = 0;
    public  long T11 = 0; 
    public  long T12 = 0; 
         public BigInteger CCC18= BigInteger.ZERO;
       
         
         
        public SEC(Ciphertext  _VA, Ciphertext _VB, PaillierT _paillier) {
         A=  _VA;
         B=  _VB;
         paillier=_paillier;
   }    
      
      
       public void StepOne (){
           
           
            
           RR1 = new BigInteger(20,  new Random());
           rr1 = new BigInteger(20,  new Random());
           tt1 = new BigInteger(20,  new Random());
           tt2 = new BigInteger(20,  new Random());
           
           if(tt2.equals( BigInteger.ZERO)){
           tt2 = new BigInteger(20,  new Random());
           }
           
           X1.T1 = A.T1.modPow(RR1,  paillier.nsquare);
           X1.T2 = A.T2.modPow(RR1,  paillier.nsquare);
           
           Ciphertext MM = paillier.Encryption(rr1);
           Ciphertext MM1 = paillier.Encryption(tt1);
           
           
           X2.T1 = B.T1.multiply(MM.T1);
           X2.T2 = B.T2.multiply(MM.T2);
           
           Y1.T1 = B.T1.multiply(MM1.T1);
           Y1.T2 = B.T2.multiply(MM1.T2);
           
           Y2.T1 = A.T1.modPow(tt2,  paillier.nsquare);
           Y2.T2 = A.T2.modPow(tt2,  paillier.nsquare);
           
           s1= RR1.modPow(tt1,  paillier.n);
           s2= tt2.modPow(rr1,  paillier.n);
           
           X11 = paillier.WPDecryption1(X1);
           X12 = paillier.WPDecryption1(X2);
           Y11 = paillier.WPDecryption1(Y1);
           Y12 = paillier.WPDecryption1(Y2);
           
    
          CCC18 = (RR1.modPow((rr1), paillier.n)).modInverse(paillier.n);
          
          CCC = X11.T1.bitLength() + X11.T2.bitLength()+ X11.T3.bitLength()+X12.T1.bitLength() + X12.T2.bitLength()+ X12.T3.bitLength()+Y11.T1.bitLength() + Y11.T2.bitLength()+ Y11.T3.bitLength()+Y12.T1.bitLength() + Y12.T2.bitLength()+ X12.T3.bitLength()+RR1.bitLength() + rr1.bitLength();
          
         
       }
         public void StepTwoA (){
        // BigInteger Bi = new BigInteger(Integer.toString(a));  
           
         h = paillier.WPDecryption2(X11);
         h2 = paillier.WPDecryption2(X12);
         
         h1 =  h.modPow(h2,paillier.n);
         
         H = paillier.Encryption(h1);
         CCC = CCC + H.T1.bitLength()+H.T2.bitLength();
       }     
       
           public void StepTwoB (){
        // BigInteger Bi = new BigInteger(Integer.toString(a));  
           
         H1 = paillier.WPDecryption2(Y11);
         H2 = paillier.WPDecryption2(Y12);
    //       System.out.println("H1=="+H1);
     //        System.out.println("H2=="+H2);
     //        System.out.println("rr1=="+rr1);
         H3 = RR1.modPow(H1,paillier.n).modInverse(paillier.n);;
         H4 = H2.modPow(rr1, paillier.n).modInverse(paillier.n);;
         
         
         
         H7 = paillier.Encryption(H3);
         H8 = paillier.Encryption(H4);
 
          CCC = CCC + H7.T1.bitLength()+H7.T2.bitLength()+H8.T1.bitLength()+H8.T2.bitLength();
       }    
         
          public void StepThree (){
    
            RSM KK2 = new RSM(H,H7,paillier);
         //      long T1a = System.currentTimeMillis();      
            KK2.StepOne();
        //    long T1b = System.currentTimeMillis(); 
            KK2.StepTwo();
      //     long T1c = System.currentTimeMillis(); 
            KK2.StepThree();
        //   long T1d = System.currentTimeMillis(); 
           
      //      T11= T11 + (T1d-T1a)-(T1c-T1b);
       //     T12 = T12+ (T1c-T1b);
            
            CCC = CCC + KK2.CCC;
            
            
            RSM KK3 = new RSM(KK2.FIN,H8,paillier);
        //     long T1e = System.currentTimeMillis();    
            KK3.StepOne();
        //    long T1f = System.currentTimeMillis(); 
            KK3.StepTwo();
        //    long T1g = System.currentTimeMillis(); 
            KK3.StepThree();
         //   long T1h = System.currentTimeMillis(); 
            
       //     T11= T11 + (T1h-T1e)-(T1g-T1f);
       //      T12 = T12+ (T1g-T1f);
            
            CCC = CCC + KK3.CCC;
       //     long T1i = System.currentTimeMillis(); 
            F2.T1 = KK3.FIN.T1.modPow(s1, paillier.nsquare);
            F2.T2 = KK3.FIN.T2.modPow(s1, paillier.nsquare);
              
            F3.T1 = F2.T1.modPow(s2, paillier.nsquare);
            F3.T2 = F2.T2.modPow(s2, paillier.nsquare);
            
            F.T1 = F3.T1.modPow(CCC18, paillier.nsquare);
            F.T2 = F3.T2.modPow(CCC18, paillier.nsquare);           
       //     long T1j = System.currentTimeMillis(); 
       //     T11 = T11 + (T1j-T1i);
         //   Fin2 = paillier.SDecryption(F);
       }          
    
    
}
