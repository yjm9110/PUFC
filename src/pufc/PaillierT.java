/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pufc;
import java.math.*;
import java.util.*;
/**
 *
 * @author simon
 */
public class PaillierT {
    
     public  BigInteger p,  q,  lambda, x, x1, x2, h, a ,g1;
    /**
     * n = p*q, where p and q are two large primes.
     */
    public BigInteger n;
    /**
     * nsquare = n*n
     */
    
    public BigInteger nsquare;
    /**
     * a random integer in Z*_{n^2} where gcd (L(g^lambda mod n^2), n) = 1.
     */
    private BigInteger g;
    /**
     * number of bits of modulus
     */
    private int bitLength;
    
       public PaillierT(int bitLengthVal, int certainty) {
        KeyGeneration(bitLengthVal, certainty);
    }

    /**
     * Constructs an instance of the Paillier cryptosystem with 512 bits of modulus and at least 1-2^(-64) certainty of primes generation.
     */
    public PaillierT() {
        KeyGeneration(1024, 64);
    }
   
    
        public void KeyGeneration(int bitLengthVal, int certainty) {
        bitLength = bitLengthVal;
        /*Constructs two randomly generated positive BigIntegers that are probably prime, with the specified bitLength and certainty.*/
        p = new BigInteger(bitLength / 2, certainty, new Random());
        q = new BigInteger(bitLength / 2, certainty, new Random());
        
        a =    new BigInteger(bitLength / 2, certainty, new Random());

        n = p.multiply(q);
        nsquare = n.multiply(n);
        g1 = new BigInteger("2");
        g = BigInteger.ZERO.subtract(a.modPow(g1.multiply(n), nsquare)).mod(nsquare);
        
        
      
        x = new BigInteger(bitLength / 2, certainty, new Random());
        x1 = new BigInteger(bitLength / 4, certainty, new Random());
        
        x2 = x.subtract(x1);
        
        h = g.modPow(x, nsquare);
        
        lambda = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)).divide(
                p.subtract(BigInteger.ONE).gcd(q.subtract(BigInteger.ONE)));
        /* check whether g is good.*/
      //  if (g.modPow(lambda, nsquare).subtract(BigInteger.ONE).divide(n).gcd(n).intValue() != 1) {
      //      System.out.println("g is not good. Choose g again.");
       //     System.exit(1);
      //  }
    }
    
        public Ciphertext Encryption(BigInteger m, BigInteger r) {
            
            Ciphertext cc = new Ciphertext();
            cc.T1 = (BigInteger.ONE.add(m.multiply(n)).mod(nsquare)).multiply(r.modPow(n, nsquare)).mod(nsquare);
            cc.T2 = g.modPow(r, nsquare);
            
            return  cc;
    }
       public Ciphertext Encryption(BigInteger m) {
        BigInteger r = new BigInteger(bitLength/2, new Random());
        
        
            Ciphertext cc = new Ciphertext();
            cc.T1 = (BigInteger.ONE.add(m.multiply(n)).mod(nsquare)).multiply(h.modPow(r, nsquare)).mod(nsquare);
            cc.T2 = g.modPow(r, nsquare);
       //     System.out.println("xxxxx=="+m.multiply(n).multiply(lambda).add(BigInteger.ONE));
         return  cc;

    }     
 
     public BigInteger WDecryption(Ciphertext c) {
        BigInteger u = c.T1.multiply( ((c.T2.modPow(x, nsquare)).modInverse(nsquare)));
     //    System.out.println("T1=="+c.T1);
    //    System.out.println("u=="+u);
       
        return u.subtract(BigInteger.ONE).divide(n).mod(n);
    }    
     
     
     
          public Ciphertext1 WPDecryption1(Ciphertext c) {
               Ciphertext1 cc = new Ciphertext1();
                BigInteger r = new BigInteger(bitLength/2, new Random());
              cc.T1 = c.T1.multiply((h.modPow(r, nsquare))).mod(nsquare);
              cc.T2 = c.T2.multiply((g.modPow(r, nsquare))).mod(nsquare);  
              cc.T3 = cc.T2.modPow(x1, nsquare);
         
              
        //      BigInteger ccccc = cc.T1.multiply( ((cc.T2.modPow(x, nsquare)).modInverse(nsquare)));
      
      //       BigInteger cccccc = cc.T3.multiply(cc.T2.modPow(x2, nsquare)).mod(nsquare);
             
       //      BigInteger ccccck =  ((cc.T2.modPow((x1.add(x2)), nsquare)));
             
        //      System.out.println("ccccc=="+ ccccc);
        //      System.out.println("cccccc=="+ cccccc);
        //       System.out.println("ccccck=="+ ccccck);
        return cc;
    } 
   
          
       public BigInteger WPDecryption2(Ciphertext1 c) {
           
           
         BigInteger u1 =    c.T3.multiply(c.T2.modPow(x2, nsquare)).mod(nsquare);
         BigInteger u = c.T1.multiply(u1.modInverse(nsquare));
     

//    System.out.println("T1=="+c.T1);
    //    System.out.println("u=="+u);
       
        return u.subtract(BigInteger.ONE).divide(n).mod(n);
    } 
          
     public BigInteger SDecryption(Ciphertext c) {
        BigInteger u = c.T1.modPow(lambda, nsquare);
        BigInteger u1 = lambda.modInverse(n);
     //    System.out.println("xxxxx=="+u);
     //    System.out.println("g=="+g.modPow(lambda, nsquare));
        return  c.T1.modPow(lambda, nsquare).subtract(BigInteger.ONE).divide(n).multiply(u1).mod(n);
    }        
    
    
}
