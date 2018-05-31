package assign2;

import java.math.BigDecimal;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ArithEncoderDecoder x=new ArithEncoderDecoder();
/*BigDecimal L=new BigDecimal(0.10254654512213564);
String S=x.BigDecimalToBinary(L,64);
System.out.println(S);
L=x.StringToBigDecimal(S); */
//System.out.println(L);
String [] s=new String [3];
s[0]="0506967180";
s[1]="302490545";
s[2]="";
String [] w=new String [3];
w[0]="";
w[1]="";
w[2]="";
x.Compress(s,w);
//System.out.println(w[1]);
String [] z=new String [3];
z[0]="";
z[1]="";
z[2]="";
//System.out.println(s[0]);
x.Decompress(w, z);
System.out.println(z[0]);
System.out.println(z[1]);
//System.out.println(z[2]);
for(int i=0;i<s.length;i++){
if(z[i].equals(s[i])){
	System.out.println(true);
}
}
//System.out.println((w[1].length()+w[0].length())/8+"<-"+(z[0].length()+z[1].length()));
	}	
}

