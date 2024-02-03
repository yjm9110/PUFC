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
public class TEST1 {
        public static final String FILE_PATH_A = "x:\\PUFC.txt";
  //  public static final String FILE_PATH_A = "x:\\no12015.txt";
     //   public static final String FILE_PATH_B = "e:\\p3.txt";
        public static final int STR_ARR_ROW = 2000;
       
        public static final int STR_ARR_NUM = 2000;
        public static final int STR1 = 536;
        public static final int STR2 = 536;
        public static final int[] NN ={10,10,10,10,10,10};
        public static final int  NNC =3;
        public static final int finalti =2;
         public static final int K =2;
        
   //     public static final int  FF = 4;
        public static final int STR_ARR_ROX =100;
        public static final int STR_ARR_ROY =500;
    //       public static final int STR_ARR_ROY =536;
   //    public static final int MODK =1100;

        public static final int FOR_RUN_TIMES =1;
         public static void main(String[] args) {
         Testnew();   
         
         
           
}
         
           public static void Testnew()
{
         System.out.println("Big Data Loading");
         String[][] intArr = new String[STR_ARR_ROW][STR_ARR_NUM];
    

         int i = 0;
     
         try {
             FileReader fr = new FileReader(FILE_PATH_A);
             BufferedReader br = new BufferedReader(fr);

             String str = null;
             while ((str = br.readLine()) != null) {
                 intArr[i] = str.split("\t");
                 i++;
             }
             br.close();
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
         System.out.println("=========Big Data A Loading End==========");
        
        System.out.println("Generate a vector"); 
     //   int[][] VAA = new int[STR_ARR_ROX][NN[NN.length-1]]; 
     //   int[][] VAR = new int[STR_ARR_ROX][NN[NN.length-1]];  
         BigInteger Z = BigInteger.ZERO; 
        
         System.out.println("Generate a vector End");  
         for (int j = 0; j < NN.length; j++)
        {
           int N =  NN[j];
           long t1 = 0, t2 = 0, t3 = 0, t4 = 0, t5=0, t6=0, t7=0, t8=0, t9=0, TT1=0, TT2=0, tp=0;
           System.out.println("Vector Length = " + NN[j]);
           System.out.println("P Vector Length = " + N);
           
           
           PaillierT       paillier = new PaillierT(1024, 64);   
           
       //     AHPR ahpr = new AHPR("a.properties");
      //     AHPRCipher[][]       EVABR    = new AHPRCipher [STR_ARR_ROX][NN[j]];   
       //    AHPRCipher[][]       FEA    = new AHPRCipher [STR_ARR_ROX][finalti];  
       //    AHPRCipher[][]       FEB    = new AHPRCipher [STR_ARR_ROX][finalti];
        //   BigInteger[][]       DFEB    = new BigInteger [STR_ARR_ROX][finalti];
    //        int [] FinTag = new int [STR_ARR_ROX];
   //        BigInteger      v1= BigInteger.valueOf(1);
     //      BigInteger      v2= BigInteger.valueOf(1);
          
           
       //    AHPRCipher[] VV11 =  new    AHPRCipher [2]; 
        //    AHPRCipher V = ahpr.Encryption(v1);   
          // AHPRCipher V1 = ahpr.Encryption(v2); 
             
       //     VV11[0] =V;
       //     VV11[1] =V1;  
      //        
              
        for (int iii=0; iii< FOR_RUN_TIMES; iii++)
         {
              int[][] VBA = new int[STR_ARR_ROX][N];
              int[][] VBDD = new int[STR_ARR_ROX][N];
        /////////////     ////////////////////////////////////////// 
              int  TTPSM = 0;
              int  TTSEC = 0;
                             Ciphertext  MIDDD =  new    Ciphertext();
               Ciphertext []    QUERY  =  new    Ciphertext [NNC];
               Ciphertext []    QUERYT =  new    Ciphertext [N];
               Ciphertext [][]  VBB =  new    Ciphertext [STR_ARR_ROX][N];
               Ciphertext [][]  VBE =  new    Ciphertext [STR_ARR_ROX][NNC];
               BigInteger []    VBF =  new    BigInteger [STR_ARR_ROX] ;
               Ciphertext []    VBC  =  new    Ciphertext [STR_ARR_ROX];
               BigInteger CCCC =  BigInteger.ZERO ;
               BigInteger CCCC2 =  BigInteger.ZERO ;
                 
                 
                 
                 long T1 = System.currentTimeMillis(); 
                 
                 for (int jjj=0; jjj< N; jjj++)
                 {
                   //  System.out.println("=== jjj======"+ jjj); 
                   
                   BigInteger    RR2 = new BigInteger(3,  new Random());

                   QUERYT[jjj] = paillier.Encryption(RR2);
                   CCCC = CCCC .add(BigInteger.valueOf( QUERYT[jjj] .T1.bitLength()+  QUERYT[jjj] .T2.bitLength()));
                   
               //     System.out.println("=== QUERY[jjj]======="+RR1); 
                //   System.out.println("=== QUERYT[jjj]======="+RR2); 
                 } 
                 
                 
                                  for (int jjj=0; jjj< NNC; jjj++)
                 {
                 BigInteger    RR1 = new BigInteger(10,  new Random());
                  QUERY[jjj] =  paillier.Encryption(RR1);
                   CCCC = CCCC .add(BigInteger.valueOf( QUERY[jjj] .T1.bitLength()+  QUERY[jjj] .T2.bitLength()));
                 } 
              
              long T2 = System.currentTimeMillis();
              
              long T3 = System.currentTimeMillis(); 
              
                 for (int k=0; k < STR_ARR_ROX; k++)
              {  
                  
                  VBC[k] = paillier.Encryption(BigInteger.ZERO);
                         
                 for (int jjj=0; jjj< N; jjj++)
                   {
               
                       VBA[k][jjj] =Integer.parseInt(intArr[k][jjj]); 
                       VBB[k][jjj] = paillier.Encryption(BigInteger.ZERO);
                       
                   } 

                 
                                  for (int jjj=0; jjj< NNC; jjj++)
                   {
               
                        
                       VBE[k][jjj] = paillier.Encryption(BigInteger.ZERO);
                   } 
                 
              }     
                 
                 
                 
                 
                 
                 
                 
                 
         //         for (int k=0; k < STR_ARR_ROX; k++)
           //   {
          //        FinTag[k] =1;
          //    }
                 
              
         
                  for (int k=0; k < STR_ARR_ROX; k++)
                 { System.out.println("k=="+k);
                     for (int jjj=0; jjj< NNC; jjj++)
                     {
                         
                          MIDDD =  paillier.Encryption(BigInteger.ONE);
                         
                            for (int jjjj=0; jjjj< NN[j]; jjjj++)
                     {
                       
                                    SECE SK1 = new SECE(QUERYT[jjjj],BigInteger.valueOf(VBA[k][jjjj]),paillier);
                                 SK1.StepOne();
                                 SK1.StepTwo();
                                 SK1.StepThree();
                                 TTSEC = TTSEC +1; 
                           
                          
                           CCCC2 = CCCC2 .add(BigInteger.valueOf( SK1.CCC));
                                  
                                  PSM SK11 = new PSM(MIDDD,SK1.F,paillier);
                                          SK11.StepOne();
                                          SK11.StepTwo();
                                          SK11.StepThree();
                                          TTPSM = TTPSM +1;
                                   MIDDD= SK11.FIN;
                                    // System.out.println("PSM=="+SK11.FIN2); 
                       
                  CCCC2 = CCCC2 .add(BigInteger.valueOf( SK11.CCC));

    
                            
                     } 
                               VBE[k][jjj] =  MIDDD;
                     }
               }    
               
               
               
               
               
             System.out.println("====innitial end========");   
         
                     for (int k=0; k < STR_ARR_ROX; k++)
                 {
                     
                      for (int jjj=0; jjj< NNC; jjj++)
                     {
                         VBC[k].T1=VBC[k].T1.multiply( VBE[k][jjj].T1);
                         VBC[k].T2=VBC[k].T2.multiply( VBE[k][jjj].T2);
                     }
                      
             

               }  
                     
                long T4 = System.currentTimeMillis();      
               
              System.out.println("====user innitial end========");  
               System.out.println("====start TOP-K calculation========"); 
            
              
              
                        
              
              
    
            System.out.println("====end TOP-K  calculation========"); 
             
             long T5 = System.currentTimeMillis(); 
             System.out.println("====start Decryption========"); 
                         for (int k=0; k < STR_ARR_ROX; k++)
                 {
                     
                      CCCC = CCCC .add(BigInteger.valueOf( VBC[k] .T1.bitLength()+  VBC[k] .T2.bitLength()));
                     {
                         VBF[k] = paillier.SDecryption(VBC[k]);
                     }
                 }
             
              System.out.println("====end Decryption========"); 
              long T6 = System.currentTimeMillis(); 
             System.out.println("====start decryption========"); 
              long T7 = System.currentTimeMillis(); 
          ///          for (int k=0; k < STR_ARR_ROX; k++)
      //           {
     //                for (int jj=0; jj < finalti;jj++){
     //                         if(FinTag[k] == 1)
     //                              {
                 //         DFEB[k][jj]  =  ahpr.Decryption( FEA[k][jj]);     
     //                              }
     //             }
     //            }             
           
              long T8 = System.currentTimeMillis();   
              
              System.out.println("====end decryption========"); 
              t1=T2-T1;
              t2=T4-T3;
              t3=T6-T5;
              t4=T8-T7;
              System.out.println("===$$$$$$$$$$$$=result$$$$$$$$$$$$========"); 
              System.out.println("====user innitial calculation========"+t1);  
              System.out.println("==== TOP-K========"+t2); 
               System.out.println("================="+t3); 
              System.out.println("====  TOTLE user time========"+(t3+t1)); 
              System.out.println("====  Communication Cost====User side==="+CCCC); 
              System.out.println("====  Communication Cost====sever side==="+CCCC2); 
              System.out.println("====  TTPSMe=="+TTPSM); 
              
              System.out.println("====  TTSEC Cost=====Sever side=="+TTSEC); 
              
         //////////////////////////////////////////////////////////////     
              
      //    public AHPRCipher[] VA = null;     
              
             
         }
        
        }
        
         
         
         
          }





}