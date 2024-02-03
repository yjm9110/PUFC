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
 * @author SimonLau
 */
public class PPTKP {
    
     public Paillier paillier = null;
     public BigInteger a = BigInteger.ZERO;
     public BigInteger b = BigInteger.ZERO;
      public BigInteger DDD1 = BigInteger.ZERO;
       public BigInteger DDD2 = BigInteger.ZERO;
     
     public BigInteger[] VA = null;
      public BigInteger[] VA1 = null;
     public BigInteger[] VB = null;
     public BigInteger[] VB1 = null;
     public BigInteger[] VC = null;     
     public BigInteger[] VD = null; 
     public BigInteger[] DD1 = null; 
     public BigInteger[] Finnal = null;
      public BigInteger [] CCC=null;
     public int K=0;
     public int[] vector = null;
  public PPTKP(BigInteger[]  _VA, int _K, Paillier _paillier) {
    VC = _VA;
    K = _K;
    paillier = _paillier;
    vector = new int[VC.length];
    for(int i = 0; i < VC.length; ++i)
        vector[i] = i+1;
   }
  
  public void swap(int i, int j)
  {
      BigInteger tmp;
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
        PPMAX  kkpp = new PPMAX(VC[i],VC[r],paillier);
          kkpp.StepOne();
          kkpp.NewStepTwo();
          kkpp.NewStepThree();
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
      
      return;
  }
  
  
    public void StepOne ()
    { int a=0;
      int rando=0;
      int leth1=0;   
      int tleth1=0;  
      int tleth2=0;  
      int leth2=0; 
      int leth3=0; 
     int leth4=0;
    int fileg=0; 
      a= VC.length ;
     leth4=VC.length;
      fileg=VC.length;
      
      VA = new BigInteger[VC.length];
      VB = new BigInteger[VC.length];
      VD = new BigInteger[K];
      Finnal = new BigInteger[K];
     
      

     for(;(fileg!=K)&&(fileg!=(K-1));){
         System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!=");
       Random rd1 = new Random();
       rando= rd1.nextInt(leth4);
       System.out.println(" rd1=" +rando);
      for(int k=0; k < leth4; k++)
      {
      if( k != rando ){
      PPMAX  kkpp = new PPMAX(VC[k],VC[rando],paillier);  
          
               kkpp.StepOne();
               kkpp.NewStepTwo();
               kkpp.NewStepThree();
              
               if(kkpp.eee==1)
               {
                  VA[leth1]=VC[k];
                  leth1 = leth1+1;
                    DDD1=paillier.Decryption(VC[k]); 
                     DDD2=paillier.Decryption(VC[rando]); 
                   System.out.println("VC1="+DDD1);
                   System.out.println("VC2="+DDD2);                     
                   System.out.println("k="+k);
                   System.out.println("rando="+rando);
                    System.out.println("kkpp.eee="+kkpp.eee);
               }
               if(kkpp.eee==0)
               {
                  VB[leth2]=VC[k];
                  leth2 = leth2+1;
                  tleth2 = leth2 ;
                    DDD1=paillier.Decryption(VC[k]); 
                     DDD2=paillier.Decryption(VC[rando]); 
                   System.out.println("VC1="+DDD1);
                   System.out.println("VC2="+DDD2);                     
                   System.out.println("k="+k);
                   System.out.println("rando="+rando);
                    System.out.println("kkpp.eee="+kkpp.eee);
               }     
          
          
              }
      
         }
      
      
      
    System.out.println("====================================");
         System.out.println("leth1="+leth1);
  System.out.println("leth2="+leth2);
      System.out.println("leth4="+ leth4);  
      System.out.println("leth3="+ leth3);
       System.out.println("leth1="+leth1);   
          System.out.println("====================================");
          if((leth1+leth3) == K)
                { System.out.println("!!!!!!!!!!!KKKK=" );
                      Finnal = new BigInteger[ K];
                      CCC= new BigInteger[K];
                      
               for(int tt=0;tt<(leth3);tt++)
                   { Finnal[tt]=VD[tt];
                    CCC[tt]=paillier.Decryption(Finnal[tt]);
                     System.out.println("K,leth1+leth3="+CCC[tt]);
                   } 
                      for(int tt=leth3;tt<(leth3+leth1);tt++)
                    { Finnal[tt]=VA[tt-leth3];
                    CCC[tt]=paillier.Decryption(Finnal[tt]);
                     System.out.println("K,leth1="+CCC[tt]);
                    System.out.println("tt="+tt);
                    System.out.println("leth1="+leth1);
                    System.out.println("leth2="+leth2);
                     }

             

                      fileg=K;
                      break;
                 }
      
           if(((leth1+leth3) == (K-1))&&(K-1!=0))
            { System.out.println("!!!!!!!!!!!+=" );
                
                 CCC= new BigInteger[K];
                 System.out.println("leth1=="+leth1);
                  System.out.println("leth3=="+leth3);
          
                  
                  for(int tt=0;tt<(leth3);tt++)
                   { Finnal[tt]=VD[tt];
                     CCC[tt]=paillier.Decryption(Finnal[tt]);
                      System.out.println("K-1,leth1+leth3"+ CCC[tt]);
                   } 
                  
                  
                  
                    for(int tt=leth3;tt<(leth1+leth3);tt++)
                    { Finnal[tt]=VA[tt-leth3];
                      CCC[tt]=paillier.Decryption(Finnal[tt]);
                       System.out.println("K-1,leth1"+CCC[tt]);
                     }
             

                 
                 
                 Finnal[K-1]=VC[rando];
                 CCC[K-1]=paillier.Decryption(VC[rando]); 
               //   System.out.println("K-1,leth1=="+CCC[K-1]);
                 fileg=K-1; 
                  break;
                  
              }  
           if((leth1+leth3) < (K-1))
              {//System.out.println("@@@@@@@@@@@@");
              
                  for(int tt=0;tt<leth1;tt++)
                   { VD[leth3+tt]=VA[tt];
                   leth3 = leth3+1;
                    }
           
                
                 VD[leth3] = VC[rando];
                   leth3 = leth3 + 1;
                   
                
                 leth4=VC.length-leth3;
                 for(int tt=0;tt< leth4;tt++)
                     
                 {   VC[tt]=VB[tt];
                 }
                     
        ///         System.out.println("VB.length==="+VB.length);
         //           System.out.println("leth1==="+leth1);
         //            System.out.println("leth2==="+leth2);
         //         System.out.println("leth3==="+leth3);
        //           System.out.println("leth4==="+leth4);
                   
           //      System.out.println("@@@@@@@@@@@@");
                 leth1 = 0;
                 leth2 = 0;
              }
           
           
      if((leth1+leth3) > K)
         {
              
             for(int tt=0;tt<leth1;tt++)
             { VC[tt]=VA[tt];
             }
             
             for(int tt=leth1;tt<(leth1+leth3);tt++)
             { VC[tt]=VD[tt];
             }             
             leth4=leth1+leth3;//this line 
              leth1 = 0;
              leth2 = 0;
        }
            
                  leth1 = 0;
                 leth2 = 0;
   
   // System.out.println("p = " + a);  
    }  
        
        
    }
  
  
  
  
  
}
