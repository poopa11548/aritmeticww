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
s[0]="0526692724";
//s[1]="086898579";
s[2]="";
s[0]="20027200054301073423516516515615615154878798984984984465613123131564877982002720005430107342351651651561561515487879892002720005430107342351651651561561515487879898498498446561312313156487798200272000543010734235165165156156151548787989200272000543010734235165165156156151548787989849849844656131231315648779820027200054301073423516516515615615154878798920027200054301073423516516515615615154878798984984984465613123131564877982002720005430107342351651651561561515487879892002720005430107342351651651561561515487879898498498446561312313156487798200272000543010734235165165156156151548787989200272000543010734235165165156156151548787989849849844656131231315648779820027200054301073423516516515615615154878798920027200054301073423516516515615615154878798984984984465613123131564877982002720005430107342351651651561561515487879892002720005430107342351651651561561515487879898498498446561312313156487798200272000543010734235165165156156151548787989200272000543010734235165165156156151548787989849849844656131231315648779820027200054301073423516516515615615154878798920027200054301073423516516515615615154878798984984984465613123131564877982002720005430107342351651651561561515487879892002720005430107342351651651561561515487879898498498446561312313156487798200272000543010734235165165156156151548787989200272000543010734235165165156156151548787989849849844656131231315648779820027200054301073423516516515615615154878798920027200054301073423516516515615615154878798984984984465613123131564877982002720005430107342351651651561561515487879892002720005430107342351651651561561515487879898498498446561312313156487798200272000543010734235165165156156151548787989200272000543010734235165165156156151548787989849849844656131231315648779820027200054301073423516516515615615154878798920027200054301073423516516515615615154878798984984984465613123131564877982002720005430107342351651651561561515487879892002720005430107342351651651561561515487879898498498446561312313156487798200272000543010734235165165156156151548787989200272000543010734235165165156156151548787989849849844656131231315648779820027200054301073423516516515615615154878798920027200054301073423516516515615615154878798984984984465613123131564877982002720005430107342351651651561561515487879892002720005430107342351651651561561515487879898498498446561312313156487798200272000543010734235165165156156151548787989200272000543010734235165165156156151548787989849849844656131231315648779820027200054301073423516516515615615154878798920027200054301073423516516515615615154878798984984984465613123131564877982002720005430107342351651651561561515487879892002720005430107342351651651561561515487879898498498446561312313156487798200272000543010734235165165156156151548787989200272000543010734235165165156156151548787989849849844656131231315648779820027200054301073423516516515615615154878798920027200054301073423516516515615615154878798984984984465613123131564877982002720005430107342351651651561561515487879892002720005430107342351651651561561515487879898498498446561312313156487798200272000543010734235165165156156151548787989200272000543010734235165165156156151548787989849849844656131231315648779820027200054301073423516516515615615154878798984984984465613123131564877987866513215646878945615515161231131054301073422002720005430107342351651651561561515487879898498498446561312313156487798786651321564687894561551516123113105430107342786651321564687894561551516123113105430107342200272000543010734235165165156156151548787989849849844656131231315648779878665132156468789456155151612311310543010734220027200054301073423516516515615615154878798984984984465613123131564877987866513215646878945615515161231131054301073422002720005430107342351651651561561515487879898498498446561312313156487798786651321564687894561551516123113105430107342200272000543010734235165165156156151548787989849849844656131231315648779878665132156468789456155151612311310543010734235165165156156151548787989849849844656131231315648779878665132156468789456155151612311313";
//s[1]="05468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999054689799905468979990546897999";
//s[0]="0506967180654654561611321547746151561132154774615156112312231531546498498487486465464649849848748646546464984984874864654646498498487486474615156113215477461515611231223153154649849848748646546464984984874864654646498498487486465464649849848748647461515611321547746151561123122315315464984984874864654646498498487486465464649849848748646546464984984874864654646498498487486465465151323";
//s[1]="302490610321412417461517461530249061032141241746151746153024906103214124174615174615302490610321412417461517461530249061032141241746151746153024906103214124174615174615302490610321412417461517461515611321547746151561123122315315464984984874864654646498498487486465464649849848748646546464984984874864746151561132154774615156112312231531546498498487486465464649849848748646546464984984874864654646498498487486456113215477461515611231223153154649849848748646546464984984874864654646498498487486465464649849848748645315236236263463643";
//s[2]="054301073423516516515615615154878798984984984465613123131564877987866513215646878945615515161231131054301073423516516515615615154878798984984984465613123131564877987866513215646878945615515161231131054301073423516516515615615154878798984984984465613123131564877987866513215646878945615515161231131054301073423516516515615615154878798984984984465613123131564877987866513215646878945615515161231131054301073423516516515615615154878798984984984465613123131564877987866513215646878945615515161231131054301073423516516515615615154878798984984984465613123131564877987866513215646878945615515161231131";
String [] w=new String [3];
x.Compress(s,w);
System.out.println("c");
String [] z=new String [3];
x.Decompress(w, z);
//System.out.println(z[0]);
System.out.println(z[1]);
System.out.println(z[2]);
for(int i=0;i<s.length;i++){
if(z[i].equals(s[i])){
	System.out.println(true);
}
}
System.out.println((w[1].length()+w[0].length()+w[2].length())/8+"<-"+(z[0].length()+z[1].length()+z[2].length()));
	}	
}

