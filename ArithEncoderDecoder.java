package assign2;

/**
 * Assignment 2
 * Submitted by: 
 * Student 1.Matan Chibotero 	ID# 204076962
 * Student 2.Liel Levi 	ID# 307983320
 * Student 3.Yoni Amikam  ID#311532774
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.BitSet;

import base.compressor;

public class ArithEncoderDecoder implements compressor
{

	public ArithEncoderDecoder()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Compress(String[] input_names, String[] output_names)
	{for(int i=0;i<input_names.length;i++)//check if the input null 
		if(input_names[i]==null)
			input_names[i]="";
		for(int j=0;j<input_names.length;j++){
		output_names[j]="";//initialization
		if(input_names[j].length()!=0||j==0){
		int [] count=new int[10];
		BigDecimal [] c=new BigDecimal[10];
		BigDecimal[] p=new BigDecimal[10];
		for(int k=0;k<input_names.length;k++)
		for(int i=0;i<input_names[k].length();i++){
			count[input_names[k].charAt(i)-48]++;
		}
		int len=0;
		for(int i=0;i<input_names.length;i++){
			len+=input_names[i].length();
		}
		for(int i=0;i<10;i++){
			p[i]=new BigDecimal(((double)count[i]/len));
		}
		for(int i=0;i<c.length;i++)
			c[i]=new BigDecimal(0);
		c[0]=new BigDecimal(0);
		for(int i=1;i<10;i++){
			if(p[i].compareTo(new BigDecimal(0))!=0){
			for(int k=0;k<i;k++){
				c[i]=c[i].add(p[k]);
			}
		}
		}
		if(j==0){
		for(int i=0;i<10;i++){
			output_names[0]+=intToBinary(count[i]);//Enter count for char [i] with 16 bits
		}
		output_names[0]+=intToBinary(len);//Enter length for all strings
		}
		 	String mark="";//variable for scaling correctly
			BigDecimal L=new BigDecimal(0).setScale((int) (len/1.5), RoundingMode.HALF_UP);
			BigDecimal W=new BigDecimal(0).setScale((int) (len/1.5), RoundingMode.HALF_UP);
			BigDecimal R=new BigDecimal(1).setScale((int) (len/1.5), RoundingMode.HALF_UP);
			int couting=0;
			
		output_names[j]+=intToBinary(input_names[j].length());//Enter length for string current
		for(int i=0;i<input_names[j].length();i++){
			W=R.subtract(L);
			L=L.add(W.multiply((c[input_names[j].charAt(i)-48]))).setScale((int) (len/1.5), RoundingMode.HALF_UP);
			R=L.add(W.multiply((p[input_names[j].charAt(i)-48]))).setScale((int) (len/1.5), RoundingMode.HALF_UP);
			while((L.compareTo(new BigDecimal(0))>0&&R.compareTo(new BigDecimal(0.5))<=0)||(L.compareTo(new BigDecimal(0.5))>0&&R.compareTo(new BigDecimal(1))<=0)||(L.compareTo(new BigDecimal(0.25))>0&&R.compareTo(new BigDecimal(0.75))<=0)){//scaling
				if(L.compareTo(new BigDecimal(0))>0&&R.compareTo(new BigDecimal(0.5))<=0){
					L=L.multiply(new BigDecimal(2)).setScale((int) (len/1.5), RoundingMode.HALF_UP);
					R=R.multiply(new BigDecimal(2)).setScale((int) (len/1.5), RoundingMode.HALF_UP);
					output_names[j]+="0";
					for(int k=0;k<couting;k++)
						output_names[j]+="1";
					couting=0;
					mark="L";
				}
				else if(L.compareTo(new BigDecimal(0.5))>0&&R.compareTo(new BigDecimal(1))<=0){
					L=(L.multiply(new BigDecimal(2))).subtract(new BigDecimal(1)).setScale((int) (len/1.5), RoundingMode.HALF_UP);
					R=(R.multiply(new BigDecimal(2))).subtract(new BigDecimal(1)).setScale((int) (len/1.5), RoundingMode.HALF_UP);
					output_names[j]+="1";
					for(int k=0;k<couting;k++)
						output_names[j]+="0";
					couting=0;
					mark="H";

				}
				else{
					L=(L.multiply(new BigDecimal(2))).subtract(new BigDecimal(0.5)).setScale((int) (len/1.5), RoundingMode.HALF_UP);
					R=(R.multiply(new BigDecimal(2))).subtract(new BigDecimal(0.5)).setScale((int) (len/1.5), RoundingMode.HALF_UP);
					couting++;
				}
			}	
		}
		if(couting>1&&mark=="L"){//if ends with middle we add bits to the end of the string
			output_names[j]+="0";
			for(int i=0;i<couting+2;i++)
				output_names[j]+="1";
		}
		else if(couting>1&&mark=="H"){
			output_names[j]+="1";
			for(int i=0;i<couting+2;i++)
				output_names[j]+="0";
		}
		
		output_names[j]+=BigDecimalToBinary((L.add(R)).divide(new BigDecimal(2)).setScale(16, RoundingMode.HALF_UP),16);//Tag
		}
		}
	  
	}
	public static String intToBinary(int n){
		String s = "";
	    for(int i=0;i<16;i++)
	    {
	        if (n % 2== 0 ){
	        	s="0"+s;
	        }
	        else 
	        	s="1"+s;
	        n = n / 2;
	    }
	    return s;
	}
	public static BigDecimal StringToBigDecimal(String S){
		BigDecimal x=new BigDecimal(0);
		for(int i=-1;i>(-1)*S.length()/1.5-1;i--){
			if(S.charAt((-1)*i-1)=='1')
			x=x.add(new BigDecimal(Math.pow(2, i)));
		}
		return x;
	}
	public static String BigDecimalToBinary(BigDecimal num,int k){
		String Binary="";
		for(int i=0;i<k;i++)
		{
			num =num.multiply(new BigDecimal(2));
			int fract_bit =Integer.valueOf(num.intValue());
			if (fract_bit == 1)
			{
				num=num.subtract(new BigDecimal(1));
				Binary+='1';
			}
			else
				Binary+='0';
		}
		return Binary;	
	}
	
	public int StringToInt(String s){
		int n=0;
		for(int i=s.length()-1;i>=0;i--){
			if(s.charAt(i)=='1'){
				n+=Math.pow(2,s.length()-1-i);
			}
		}
		return n;
	}
	public void Decompress(String[] input_names, String[] output_names)
	{
		for(int g=0;g<input_names.length;g++){
			output_names[g]="";//initialization
		BigDecimal[] p=new BigDecimal[10];
		BigDecimal[] c=new BigDecimal[10];
		int [] count=new int[10];
		int k=0;
		int n=0;
		String s="";
		for(int i=0;i<160;i++){
			k++;
			s+=input_names[0].charAt(i);
			if(k%16==0){
				count[k/16-1]=StringToInt(s);//Enter to count array
				s="";
			}
		}
		int len=0;
		for(int i=175;i>=160;i--){
			if(input_names[0].charAt(i)=='1'){
				len+=Math.pow(2,175-i);
			}
		}
		for(int i=0;i<10;i++){
			p[i]=new BigDecimal(((double)count[i]/len)).setScale((int) (len/1.5), RoundingMode.HALF_UP);
		}
		for(int i=0;i<10;i++)
			c[i]=new BigDecimal(0);
		for(int i=1;i<10;i++){
			if(p[i].compareTo(new BigDecimal(0))!=0){
			for(int j=0;j<i;j++){
				c[i]=c[i].add(p[j]).setScale((int) (len/1.5), RoundingMode.HALF_UP);
			}
		}
		}
			if(input_names[g].length()!=0){
				String T="";
				s="";
				if(g==0){
					for(int i=191;i>=176;i--){
						if(input_names[0].charAt(i)=='1'){
							n+=Math.pow(2,191-i);
						}
					}
					T=input_names[g].substring(192, input_names[g].length());
				}
				else{
					 n=0;
			for(int i=15;i>=0;i--){
				if(input_names[g].charAt(i)=='1'){
					n+=Math.pow(2,15-i);
				}
			}
			T=input_names[g].substring(16, input_names[g].length());
				}	
			BigDecimal W=new BigDecimal(0).setScale((int) (len/1.5), RoundingMode.HALF_UP);
			BigDecimal L=new BigDecimal(0).setScale((int) (len/1.5), RoundingMode.HALF_UP);
			BigDecimal R=new BigDecimal(1).setScale((int) (len/1.5), RoundingMode.HALF_UP);
		for(int i=0;i<n;i++){
			W=R.subtract(L);
			BigDecimal TD=StringToBigDecimal(T);
			int j = 0;
			for(int m=0;m<10;m++){
				if(TD.compareTo(L.add(W.multiply((c[m]))))>=0&&(TD.compareTo(L.add(W.multiply((c[m].add(p[m])))))<0)){
					j=m;
					break;
				}
			}
			output_names[g]+=(char)(j+48);
			L=L.add(W.multiply((c[j]))).setScale((int) (len/1.5), RoundingMode.HALF_UP);
			R=L.add(W.multiply((p[j]))).setScale((int) (len/1.5), RoundingMode.HALF_UP);

			while((L.compareTo(new BigDecimal(0))>0&&R.compareTo(new BigDecimal(0.5))<=0)||(L.compareTo(new BigDecimal(0.5))>0&&R.compareTo(new BigDecimal(1))<=0)||(L.compareTo(new BigDecimal(0.25))>0&&R.compareTo(new BigDecimal(0.75))<=0)){
				if(L.compareTo(new BigDecimal(0))>0&&R.compareTo(new BigDecimal(0.5))<=0){
					L=L.multiply(new BigDecimal(2)).setScale((int) (len/1.5), RoundingMode.HALF_UP);
					R=R.multiply(new BigDecimal(2)).setScale((int) (len/1.5), RoundingMode.HALF_UP);
					T=T.substring(1, T.length());
				}
				else if(L.compareTo(new BigDecimal(0.5))>0&&R.compareTo(new BigDecimal(1))<=0){
					L=(L.multiply(new BigDecimal(2))).subtract(new BigDecimal(1)).setScale((int) (len/1.5), RoundingMode.HALF_UP);
					R=(R.multiply(new BigDecimal(2))).subtract(new BigDecimal(1)).setScale((int) (len/1.5), RoundingMode.HALF_UP);
					T=T.substring(1, T.length());
				}
				else{
					L=(L.multiply(new BigDecimal(2))).subtract(new BigDecimal(0.5)).setScale((int) (len/1.5), RoundingMode.HALF_UP);
					R=(R.multiply(new BigDecimal(2))).subtract(new BigDecimal(0.5)).setScale((int) (len/1.5), RoundingMode.HALF_UP);
					if(T.charAt(0)=='0'&&T.charAt(1)=='1'){
						T=T.substring(2, T.length());
						T="0"+T;
					}
					else{
						T=T.substring(2, T.length());
						T="1"+T;
					}
				}
			}
		}
      }
	 }
	}
	@Override
	public byte[] CompressWithArray(String[] input_names, String[] output_names)
	{
		Compress(input_names,output_names);
		BitSet out=new BitSet();
		for(int i=0;i<output_names[0].length();i++){
			if(output_names[0].charAt(i)=='1'){
				out.set(i);
			}
		}
		return out.toByteArray();
	}

	@Override
	public byte[] DecompressWithArray(String[] input_names, String[] output_names)
	{
		Decompress(input_names, output_names);
		BitSet out=new BitSet();
		for(int i=0;i<output_names[0].length();i++){
			if(output_names[0].charAt(i)=='1'){
				out.set(i);
			}
		}
		return out.toByteArray();
	}

}
