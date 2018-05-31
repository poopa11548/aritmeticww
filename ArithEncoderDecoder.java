package assign2;

/**
 * Assignment 2
 * Submitted by: 
 * Student 1. 	ID# XXXXXXXXX
 * Student 2. 	ID# XXXXXXXXX
 */

import java.math.BigDecimal;
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
	{for(int j=0;j<input_names.length;j++){
		if(input_names[j].length()!=0){
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
			//System.out.println(count[i]);
			p[i]=new BigDecimal(((double)count[i]/len));
			//System.out.println(p[i]);
		}
		for(int i=0;i<c.length;i++)
			c[i]=new BigDecimal(0);
		//System.out.println(p[i]);
		c[0]=new BigDecimal(0);
		for(int i=1;i<10;i++){
			if(p[i].compareTo(new BigDecimal(0))!=0){
			for(int k=0;k<i;k++){
				c[i]=c[i].add(p[k]);
				//System.out.println(p[k]);
			}
		}
		}
		
		double l=0,r=1,w;
		for(int i=0;i<10;i++){
			output_names[0]+=intToBinary(count[i]);
		}
		output_names[0]+=intToBinary(len);
		 	String mark="";
			BigDecimal L=new BigDecimal(0);
			BigDecimal W=new BigDecimal(0);
			BigDecimal R=new BigDecimal(1);
			int couting=0;
		output_names[j]+=intToBinary(input_names[j].length());
		for(int i=0;i<input_names[j].length();i++){
			//System.out.println(L+"-"+R);
			W=R.subtract(L);
			//w=r-l;
			L=L.add(W.multiply((c[input_names[j].charAt(i)-48])));
			R=L.add(W.multiply((p[input_names[j].charAt(i)-48])));
			//l=l+w*c[input_names[j].charAt(i)-48];
			//r=l+w*p[input_names[j].charAt(i)-48];
			//System.out.println(l+"-"+r);
			//System.out.println(L+"-"+R);
			
			while((L.compareTo(new BigDecimal(0))>0&&R.compareTo(new BigDecimal(0.5))<=0)||(L.compareTo(new BigDecimal(0.5))>0&&R.compareTo(new BigDecimal(1))<=0)||(L.compareTo(new BigDecimal(0.25))>0&&R.compareTo(new BigDecimal(0.75))<=0)){
			//while((l>0&&r<=0.5)||(l>0.5&&r<=1)||(l>=0.25&&r<0.75)){
				//System.out.println(L+"-"+R);
				if(L.compareTo(new BigDecimal(0))>0&&R.compareTo(new BigDecimal(0.5))<=0){
					//System.out.println("L");
					//l=2*l;
					//r=2*r;
					L=L.multiply(new BigDecimal(2));
					R=R.multiply(new BigDecimal(2));
					output_names[j]+="0";
					for(int k=0;k<couting;k++)
						output_names[j]+="1";
					couting=0;
					mark="L";
				}
				else if(L.compareTo(new BigDecimal(0.5))>0&&R.compareTo(new BigDecimal(1))<=0){
					//System.out.println("H");
					//l=2*l-1;
					//r=2*r-1;
					L=(L.multiply(new BigDecimal(2))).subtract(new BigDecimal(1));
					R=(R.multiply(new BigDecimal(2))).subtract(new BigDecimal(1));
					output_names[j]+="1";
					for(int k=0;k<couting;k++)
						output_names[j]+="0";
					couting=0;
					mark="H";

				}
				else{
					//System.out.println("M");
					//l=2*l-0.5;
					//r=2*r-0.5;
					L=(L.multiply(new BigDecimal(2))).subtract(new BigDecimal(0.5));
					R=(R.multiply(new BigDecimal(2))).subtract(new BigDecimal(0.5));
					couting++;
				}
			}	
		}
		System.out.println(couting+" "+mark);
	if(couting>1&&mark=="L"){
			output_names[j]+="0";
			for(int i=0;i<couting+1;i++)
				output_names[j]+="1";
		}
		else if(couting>1&&mark=="H"){
			output_names[j]+="1";
			for(int i=0;i<couting+1;i++)
				output_names[j]+="0";
		}
		/*output_names[j]+="0";
		output_names[j]+="1";
		output_names[j]+="1";
		output_names[j]+="1";
		output_names[j]+="1";
		output_names[j]+="1";
		output_names[j]+="1";
		output_names[j]+="1";*/
		/*output_names[j]+="1";
		output_names[j]+="1";*/


		//printp(p);
		//System.out.println(output_names[0].length());
		//System.out.println(L+"-"+R);
		//output_names[0]+=decimalToBinary((l+r)/2.0,64);
		output_names[j]+=BigDecimalToBinary((L.add(R)).divide(new BigDecimal(2)),64);
		}
	}
		//System.out.println(output_names[0].substring(672, output_names[0].length()));
		//System.out.println(decimalToBinary((l+r)/2.0,64));
		//System.out.println((L.add(R)).divide(new BigDecimal(2)));
		//System.out.println((l+r)/2.0);
		//System.out.println((l+r)/2.0);
		//System.out.println(output_names[0].length()/8);
		//System.out.println(input_names[0].length());
	}
	public static String intToBinary(int n){
		String s = "";
	    for(int i=0;i<32;i++)
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
	public static void printp(double[] p){
		for(int i=0;i<10;i++){
			//System.out.println(i+": "+p[i]);
		}
	}
	public static BigDecimal StringToBigDecimal(String S){
		BigDecimal x=new BigDecimal(0);
		for(int i=-1;i>(-1)*S.length()-1;i--){
			if(S.charAt((-1)*i-1)=='1')
			x=x.add(new BigDecimal(Math.pow(2, i)));
		}
		return x;
	}
	public static double StringToDouble(String S){
		double x=0;
		for(int i=-1;i>(-1)*S.length()-1;i--){
			if(S.charAt((-1)*i-1)=='1')
			x+=Math.pow(2, i);
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
	public static String decimalToBinary(double num,int k)
	{
		String binary = "";
		for(int i=0;i<k;i++)
		{
			num *= 2;
			int fract_bit =(int) num;

			if (fract_bit == 1)
			{
				num -= fract_bit;
				binary+='1';
			}
			else
				binary+='0';
		}
		return binary;
	}
	public int StringToInt(String s){
		int n=0;
		//System.out.println(s.length());
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
			//System.out.println("mam");
		BigDecimal[] p=new BigDecimal[10];
		BigDecimal[] c=new BigDecimal[10];
		int [] count=new int[10];
		int k=0;
		int n=0;
		String s="";
		for(int i=0;i<320;i++){
			k++;
			s+=input_names[0].charAt(i);
			if(k%32==0){
				count[k/32-1]=StringToInt(s);
				s="";
			}
		}
		int len=0;
		for(int i=351;i>=320;i--){
			if(input_names[0].charAt(i)=='1'){
				len+=Math.pow(2,351-i);
			}
		}
		for(int i=0;i<10;i++){
			//System.out.println(count[i]);
			p[i]=new BigDecimal(((double)count[i]/len));
			//System.out.println(p[i]+"masm");
		}
		for(int i=0;i<10;i++)
			c[i]=new BigDecimal(0);
		for(int i=1;i<10;i++){
			if(p[i].compareTo(new BigDecimal(0))!=0){
			for(int j=0;j<i;j++){
				c[i]=c[i].add(p[j]);
			}
		}
		}
		//	System.out.println();
			if(input_names[g].length()!=0){
				String T="";
				s="";
				if(g==0){
					for(int i=383;i>=352;i--){
						if(input_names[0].charAt(i)=='1'){
							n+=Math.pow(2,383-i);
						}
					}
		T=input_names[g].substring(384, input_names[g].length());
				}
				else{
					 n=0;
			for(int i=31;i>=0;i--){
				if(input_names[g].charAt(i)=='1'){
					n+=Math.pow(2,31-i);
				}
			}
			T=input_names[g].substring(32, input_names[g].length());
				}
		//printp(p);
		
			BigDecimal W=new BigDecimal(0);
			BigDecimal L=new BigDecimal(0);
			BigDecimal R=new BigDecimal(1);
		
		//double l=0, r = 1,w;
		//System.out.println(T);
			//System.out.println(n+"mam");
		for(int i=0;i<n;i++){
			//w=r-l;
			W=R.subtract(L);
			BigDecimal TD=StringToBigDecimal(T);
			//System.out.println(T);
			//double td=StringToDouble(T);
			int j = 0;
			//System.out.println(td);
			//System.out.println(l+"-"+r);
			for(int m=0;m<10;m++){
				if(TD.compareTo(L.add(W.multiply((c[m]))))>=0&&(TD.compareTo(L.add(W.multiply((c[m].add(p[m])))))<0)){
					j=m;
					//System.out.println(j);
				}
				/*if((td>=(l+w*c[m]))&&(td<(l+w*(c[m]+p[m])))){
					j=m;
				System.out.println(j);
				}*/
			}
			output_names[g]+=(char)(j+48);
			//System.out.println(j);
			//l=l+w*c[j];
			//r=l+w*p[j];
			L=L.add(W.multiply((c[j])));
			R=L.add(W.multiply((p[j])));

			//System.out.println(l+"-"+r);
			while((L.compareTo(new BigDecimal(0))>0&&R.compareTo(new BigDecimal(0.5))<=0)||(L.compareTo(new BigDecimal(0.5))>0&&R.compareTo(new BigDecimal(1))<=0)||(L.compareTo(new BigDecimal(0.25))>0&&R.compareTo(new BigDecimal(0.75))<=0)){
			//while((l>0&&r<=0.5)||(l>0.5&&r<=1)||(l>=0.25&&r<0.75)){
				//System.out.println(L+"-"+R);
				if(L.compareTo(new BigDecimal(0))>0&&R.compareTo(new BigDecimal(0.5))<=0){
					//System.out.println("L"+T);
					L=L.multiply(new BigDecimal(2));
					R=R.multiply(new BigDecimal(2));
					T=T.substring(1, T.length());
					//System.out.println("L"+T);
				}
				else if(L.compareTo(new BigDecimal(0.5))>0&&R.compareTo(new BigDecimal(1))<=0){
					//System.out.println("H"+T);
					//l=2*l-1;
					//r=2*r-1;
					L=(L.multiply(new BigDecimal(2))).subtract(new BigDecimal(1));
					R=(R.multiply(new BigDecimal(2))).subtract(new BigDecimal(1));
					T=T.substring(1, T.length());
					//System.out.println("H"+T);
				}
				else{
					//System.out.println(L+"-"+R);
					//System.out.println("M"+T);
					int h=0;
					//l=2*l-0.5;
					//r=2*r-0.5;
					L=(L.multiply(new BigDecimal(2))).subtract(new BigDecimal(0.5));
					R=(R.multiply(new BigDecimal(2))).subtract(new BigDecimal(0.5));
					if(T.charAt(h)=='0'&&T.charAt(1)=='1'){
						T=T.substring(2, T.length());
						T="0"+T;
					}
					else{
						T=T.substring(2, T.length());
						T="1"+T;
					}
					//System.out.println("M"+T);
					//System.out.println("matatata");
				}
			}
		}
		}
			}
		
	}
	public static int Find(double td,double[] p){
		if(td<p[0])
			return 0;
		System.out.println(td);
		for(int i=1;i<10;i++){
			if(td>p[i-1]&&td<p[i]){
				return i;
			}
		}
		return 9;
		
	}

	@Override
	public byte[] CompressWithArray(String[] input_names, String[] output_names)
	{
		/*String[] input=new String [1];
		String [] output=new String[1];
		input[0]=input_names[0];
		output[0]=output_names[0];*/
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
		/*String[] input=new String [1];
		String [] output=new String[1];
		input[0]=input_names[0];
		output[0]=output_names[0];*/
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
