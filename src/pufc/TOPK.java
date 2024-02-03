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
public class TOPK {
      
      public PaillierT paillier = null;
      public BigInteger a = BigInteger.ZERO;
      public BigInteger b = BigInteger.ZERO;
      public BigInteger DDD1 = BigInteger.ZERO;
      public BigInteger DDD2 = BigInteger.ZERO;
     
     public Ciphertext[] VA = null;
     public BigInteger[] VA1 = null;
     public Ciphertext[] VB = null;
     public BigInteger[] VB1 = null;
     public Ciphertext[] VC = null;     
     public Ciphertext[] VD = null; 
     public BigInteger[] DD1 = null; 
     public Ciphertext[] Finnal = null;
     public BigInteger [] CCC=null;
     public int K=0;
     public int[] vector = null;
     
     
  public TOPK(Ciphertext[]  _VA, int _K, PaillierT _paillier) {
    VC = _VA;
    K = _K;
    paillier = _paillier;
    vector = new int[VC.length];
    for(int i = 0; i < VC.length; ++i)
        vector[i] = i+1;
   }
  
  public void swap(int i, int j)
  {
      Ciphertext tmp;
      tmp = VC[i];
      VC[i] = VC[j];
      VC[j] = tmp;
      
      int tmp1;
      tmp1 = vector[i];
      vector[i] = vector[j];
      vector[j] = tmp1;
      
  }
  
  public void find_k(int l, int r, int k)
  {
      if (l >= r || k <= 0) return;
      
       Random rd1 = new Random();
       int rando= rd1.nextInt(r-l);
       
       int p = l + rando;
       swap(p, r);
       int firstHigh = l;
       for (int i = l; i < r; ++i) {
        PMAX  kkpp = new PMAX(VC[i],VC[r],paillier);
          kkpp.StepOne();
          kkpp.StepTwo();
          kkpp.StepThree();
          
          
         if ( kkpp.eee ==  1) {
         //if (VC[i].compareTo(VC[r]) > 0) {
                swap(i, firstHigh);
                firstHigh ++;
            }       
       }
      swap(firstHigh, r);
      if (firstHigh - l < k - 1) {
          find_k(firstHigh+1, r, k - (firstHigh - l + 1));
      } else if (firstHigh - l > k -1) {
          find_k(l, firstHigh - 1, k);
      }
      
       
  }
  
  
  
  
}
