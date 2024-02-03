/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pufc;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author SimonLau
 */
public class testtse {
    
         public static final int tt = 10;
         
    
     public static void main(String[] args) {
    int a= 10;
    int b=5;
   int K=2;
         
        BigInteger     alpha2  = new BigInteger(400, 64, new Random());
        Paillier       paillier = new Paillier(1024, 64);              
        BigInteger     E1 =  null; 
        BigInteger    E2 = null; 
         BigInteger    E3 = null; 
          BigInteger    E4 = null; 
        BigInteger     gamainv =    null; 
        BigInteger Bi = new BigInteger(Integer.toString(15));
        BigInteger Ai = new BigInteger(Integer.toString(60));
         BigInteger Ci = new BigInteger(Integer.toString(70));
          BigInteger Pi = new BigInteger(Integer.toString(1));
         BigInteger [] Di = null;
        E1=paillier.Encryption(Ai);
        E2=paillier.Encryption(Bi);
        E3=paillier.Encryption(Ci);
        E4=paillier.Encryption(Pi);
        
        Di= new BigInteger [4];
        
        Di[0]= E1;
        Di[1]= E2;
        Di[2]= E3;
         Di[3]= E4; 
        /*
        Di[0]= Ai;
        Di[1]= Bi;
        Di[2]= Ci;
         Di[3]= Pi;
         */
        PPMAX  kkpp = new PPMAX(E1,E2,paillier);  
          
               kkpp.StepOne();
               kkpp.NewStepTwo();
               kkpp.NewStepThree();
        
           System.out.println(kkpp.FIN);
            System.out.println(kkpp.eee);
    System.out.println(kkpp.D1);
    System.out.println(kkpp.D2);
         System.out.println("=======================================");   
  
         
          PPTKP  ppkk = new PPTKP(Di,K,paillier);  
         ppkk.find_k(0, 3, 4);
         //ppkk.StepOne();
         for (int i = 0; i < 4; ++i) {
            System.out.println(paillier.Decryption(ppkk.VC[i]));
            // System.out.println(ppkk.VC[i]);
            System.out.println(ppkk.vector[i]);
         }
         
    }   
}
