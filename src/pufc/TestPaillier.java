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
 * @author simon
 */
public class TestPaillier {
    
    public static void main(String[] args) {
     int a= 10;
      int b=5;
     int K=2;
       Ciphertext [] Di = null;      
       PaillierT       paillier = new PaillierT(1024, 64);              
       BigInteger B = new BigInteger(Integer.toString(2));
       
       int a2 = 5;
       int a3 = 4;
       Ciphertext E1 = paillier.Encryption(B);
     
       BigInteger C1 =  paillier.WDecryption(E1);
       BigInteger C2 =  paillier.SDecryption(E1);
       
       
       Ciphertext1 ECC = paillier.WPDecryption1(E1);
       BigInteger CCK = paillier.WPDecryption2(ECC);
       
       
       
       System.out.println("======================================="); 
       System.out.println("C1=="+B); 
       System.out.println("C1=="+C1); 
       System.out.println("C2=="+C2); 
        System.out.println("CCk=="+CCK);
       System.out.println("n=="+paillier.n); 
       System.out.println("=======================================");   
       
        BigInteger Bi = new BigInteger(Integer.toString(a2));
        BigInteger B2 = new BigInteger(Integer.toString(a3));
        Ciphertext E2 = paillier.Encryption(Bi);
       //      BigInteger Bi = new BigInteger(Integer.toString(15));
        BigInteger Ai = new BigInteger(Integer.toString(60));
        BigInteger Ci = new BigInteger(Integer.toString(70));
        BigInteger Pi = new BigInteger(Integer.toString(1));
          long i1=0,i2=0,i3=0,i4=0,i5=0,i6=0;
          int CCC1=0,CCC2 = 0,CCC3 =0;
          int KKKK =1000;
  //     SECB SK = new SECB(E1,Bi,paillier);
   //    SK.StepOne();
   //    SK.StepTwo();
  //     SK.StepThree();
  //     BigInteger C3 =  paillier.SDecryption(SK.F);
     //  System.out.println("SECB=="+C3); 
     //  System.out.println("SECBCC1=="+SK.CCC); 
    //   System.out.println("SECBCC2=="+SK.CCC1);
    
          long Tk1 = System.currentTimeMillis(); 
          for(int ii=0;ii<KKKK;ii++) 
      {// System.out.println("ii=="+(ii));
          
          
          Ciphertext E22 = paillier.Encryption(Bi);
          
      
       
  //      System.out.println("PSM=="+SK11.FIN2); 
     // System.out.println("PSM=="+SK11.CCC); 
       
        
               
          
     //  RSM SK16 = new RSM(E1,E2,paillier);
      //  long T1 = System.currentTimeMillis(); 
     //  SK16.StepOne();
     //   long T2 = System.currentTimeMillis(); 
     //  SK16.StepTwo();
      // long T3 = System.currentTimeMillis(); 
      // SK16.StepThree();
      //  long T4 = System.currentTimeMillis(); 
       // i1 =i1 +(T4-T3)+(T2-T1);
       // i2 =i2 +(T3-T2);
    // CCC1 = CCC1+SK16.CCC;
 //        System.out.println("RSM=="+SK16.FIN2); 
        
     //  SEC SK14 = new SEC(E1,E2,paillier);
      //  long T5 = System.currentTimeMillis(); 
      // SK14.StepOne();
      //  long T6 = System.currentTimeMillis(); 
     //  SK14.StepTwoA();
      // SK14.StepTwoB();
     //  long T7 = System.currentTimeMillis(); 
     //  SK14.StepThree();
     //  long T8 = System.currentTimeMillis(); 
       
     //  CCC2 =CCC2 +SK14.CCC;
     //  i3 = i3 + (T6-T5)+ SK14.T11;
     //  i4 = i4 +  (T7-T6)+SK14.T12;
  //     System.out.println("FINNNN=="+SK14.Fin2); 
   //    System.out.println("FSECCCC=="+SK14.CCC);
       
       
       
    //   SECE SK1 = new SECE(E1,Bi,paillier);
     //  long T9 = System.currentTimeMillis();
     //  SK1.StepOne();
     //  long T10 = System.currentTimeMillis();
     //  SK1.StepTwo();
    //   long T11 = System.currentTimeMillis();
    //   SK1.StepThree();
    //   long T12 = System.currentTimeMillis();
    //   i5 = i5 + (T12-T9)-(T11-T10);
    //   i6 = i6 +  (T11-T10);
     //  CCC3 = CCC3 +SK1.CCC;
  //     BigInteger C4 =  paillier.SDecryption(SK1.F);
    //   System.out.println("SECE=="+SK1.CCC); 
      }   
      
       long Tk2 = System.currentTimeMillis(); 
       
             
       for(int ii=0;ii<KKKK;ii++) 
      {// System.out.println("ii=="+(ii));
          
          
         BigInteger  E22 = paillier.SDecryption(E2);
          
  
      }  
     long Tk3 = System.currentTimeMillis(); 
       
              for(int ii=0;ii<KKKK;ii++) 
      {// System.out.println("ii=="+(ii));
          
          
   //      BigInteger  E22 = paillier.SDecryption(E2);
          
  
      }  
    long Tk4 = System.currentTimeMillis();  
    
                for(int ii=0;ii<KKKK;ii++) 
      {// System.out.println("ii=="+(ii));
          
          
         BigInteger  E22 = paillier.WDecryption(E2);
          
  
      }  
    long Tk5 = System.currentTimeMillis();  
    
                    for(int ii=0;ii<KKKK;ii++) 
      {// System.out.println("ii=="+(ii));
          
          Ciphertext1 ECCC = paillier.WPDecryption1(E1);
          
  
      }  
    long Tk6 = System.currentTimeMillis();  
    
    
    
     for(int ii=0;ii<KKKK;ii++) 
      {// System.out.println("ii=="+(ii));
          
          BigInteger ECCC = paillier.WPDecryption2(ECC);
          
  
      }  
    long Tk7 = System.currentTimeMillis();
    
    
     System.out.println("ENC=="+(Tk2-Tk1)); 
     System.out.println("SDEC=="+(Tk3-Tk2)); 
     System.out.println("WDEC=="+(Tk5-Tk4));
     System.out.println("WDEC1=="+(Tk6-Tk5));
       System.out.println("WDEC2=="+(Tk7-Tk6)); 
    //   System.out.println("SM A=="+(i1/KKKK)); 
   //   System.out.println("SM B=="+(i2/KKKK)); 
   //   System.out.println("COmmunication SM B=="+(CCC1/KKKK)); 
   //   System.out.println("SEC A=="+(i3/KKKK)); 
    //  System.out.println("SEC B=="+(i4/KKKK)); 
    //  System.out.println("COmmunication SEC B=="+(CCC2/KKKK));
    //  System.out.println("SECE A=="+(i5/KKKK)); 
     // System.out.println("SECE B=="+(i6/KKKK)); 
    //  System.out.println("COmmunication SEC B=="+(CCC3/KKKK));
      
//       PMAX SK2 = new PMAX(E1,E2,paillier);
 //     SK2.StepOne();
  //     SK2.StepTwo();
  ////     SK2.StepThree();
  //     BigInteger C5 =  paillier.SDecryption(SK2.FIN);
  //     System.out.println("SECE=="+C5); 
  //     System.out.println("SECE=="+SK2.eee); 
       
 //      Ciphertext  E11=paillier.Encryption(Ai);
  //     Ciphertext  E12=paillier.Encryption(Bi);
 ////      Ciphertext  E13=paillier.Encryption(Ci);
 //      Ciphertext  E14=paillier.Encryption(Pi); 
  //     Di= new Ciphertext [4];
        
   //     Di[0]= E11;
   //     Di[1]= E12;
  //      Di[2]= E13;
  //      Di[3]= E14; 
        
 //       System.out.println("==========TOPK===========");
 //       TOPK  ppkk = new TOPK(Di,K,paillier);  
 //       ppkk.find_k(0, 3, 2);
         //ppkk.StepOne();
 //        for (int i = 0; i < 4; ++i) {
 //           System.out.println(paillier.SDecryption(ppkk.VC[i]));
            // System.out.println(ppkk.VC[i]);
  //          System.out.println(ppkk.vector[i]);
  //  }
    
    
       
}
}