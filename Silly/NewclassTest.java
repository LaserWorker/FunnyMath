import java.io.*;
import java.util.*;

public class Up { 
	
	//Incase Error cannot be given or known.
	public static String ProgramError = "Unknown"; 

	public static class branch{
		public static byte[] Value = new byte[8];
		public branch(byte[] val){
			Value = val;
		}
		public void set(Class<?> arg){
		}
		public void fromString(){
		}
		public void isExp(Class<?> A){
		}
		public void isLn(Class<?> Answer){
		}
		public void isPow(Class<?> Base, Class<?> Exp){
		}
		public void isMul(Class<?> A, Class<?> B){
		}
		public void isDev(Class<?> N, Class<?> D){
		}
		public void isAdd(Class<?> A, Class<?> B){
		}
		public void isSub(Class<?> A, Class<?> B){
		}
		public void isLog(Class<?> Base, Class<?> Answer){
		}
		public static long GetVal(){
			long Val = 281474976710656L;
			if (0 > Value[6]){
				Val = Value[6] * (0L - Val);
			}else{
				Val = Value[6] * Val;
			}
			Val = Val + ParseVal(Value[5]) * 1099511627776L;
			Val = Val + ParseVal(Value[4]) * 4294967296L;
			Val = Val + ParseVal(Value[3]) * 16777216L;
			Val = Val + ParseVal(Value[2]) * 65536L;
			Val = Val + ParseVal(Value[1]) * 256L;
			Val = Val + ParseVal(Value[0]);
			if (0 > Value[6]){
				Val = 0 - Val;
			}
			return Val;
		}
		public static int[] GetTenPower(){
			return TenPower(Branch(Value[7]));
		}
		public static int[] TenPower(int[] raised){
			int to = raised[1];
			int rase = raised[0];
			return ToTenPow(rase, to);
		}
//301029995663981195213738894724493026768189881462108541310 Log 2 / Log 10
//10000000000
		public static int[] ToTenPow(int rase, int to){
			int[] raised = new int[]{rase, (LogBaseTwo(to))};
			if (0 < to){
				long sol = 30103L * to;
				raised[1] = (int)(sol / 100000L);
			}
			if (rase > 1){
				raised[1] = raised[1] - 1;
			}
			return raised;
		}
		public static int TwoToPowerOf(int val) {
			if (1 < val){
			return 2 * TwoToPowerOf(val - 1);
			}else if (1-0 > val){
			return 2 / TwoToPowerOf(val + 1);
			}else{ 
			return 2;
			}
		} 
		public static int[] Branch(byte branch) {
			int raised = 0;
			int to = 0;
			if (0 > branch){
				raised = 65536;
				branch = (byte) (0 - branch);
			}
			if (63 < branch){
				branch = (byte) (branch - 64);
				raised = raised + 2;
			}
			if (31 < branch){
				branch = (byte) (branch - 32);
				raised = raised + 1;
			}
			to = (int)branch;
			raised = raised + 1;
			if (65535 < raised){
				raised = 65536 - raised;
			}
			if (0 < branch){
				to = branch << 2;
			}
			System.out.println(to);
			return new int[]{raised, to};
		}
		public static long ParseVal(byte val){
			int v = val;
			if (0 > v){
				v = 0 - v;
				v = v + 256;
			}
			return (long)v;
		}
		public static int LogBaseTwo(int round){			
			if (2 < round){
				int min = Math.round(round / 2);
				round = 1 + LogBaseTwo(min);
			}else{
				round = 0;
			}
			return round;
		}
/**
		public static float LogBaseTwo(float round){
			return 0;
		}
**/
	}

	public static class power {
		
		public float power (float pow, float num) {
                        float onum=num;
		        if (pow < 0){
		        	while( -1 > pow ){
		        		num = num / onum;
	        			pow = pow + 1;
		        	}
		        }else{
	        		while( 1 < pow ){
				        num = num * onum;
			        	pow = pow - 1;
	        		}
	        	}
	        	return ((float)num);
                }
                public float powerl (long pow, long num) {
                        long onum=num;
		        if (pow < 0){
		        	while( -1 > pow ){
		        		num = num / onum;
	        			pow = pow + 1;
		        	}
		        }else{
	        		while( 1 < pow ){
				        num = num * onum;
			        	pow = pow - 1;
	        		}
	        	}
	        	return ((float)num);
                }
                public float poweri (long pow, int num) {
                        int onum=num;
		        if (pow < 0){
		        	while( -1 > pow ){
		        		num = num / onum;
	        			pow = pow + 1;
		        	}
		        }else{
	        		while( 1 < pow ){
				        num = num * onum;
			        	pow = pow - 1;
	        		}
	        	}
	        	return ((float)num);
                }
	}

	public static class Pow {
		float Solution;
                public Pow () {
                        Solution = 0;
                }
                public Pow (float pow, float num) {
                        float onum=num;
		        if (pow < 0){
		        	while( -1 > pow ){
		        		num = num / onum;
	        			pow = pow + 1;
		        	}
		        }else{
	        		while( 1 < pow ){
				        num = num * onum;
			        	pow = pow - 1;
	        		}
	        	}
	        	Solution = ((float)num);
                }
                public Pow (long pow, long num) {
                        long onum=num;
		        if (pow < 0){
		        	while( -1 > pow ){
		        		num = num / onum;
	        			pow = pow + 1;
		        	}
		        }else{
	        		while( 1 < pow ){
				        num = num * onum;
			        	pow = pow - 1;
	        		}
	        	}
	        	Solution = ((float)num);
                }
                public Pow (long pow, int num) {
                        int onum=num;
		        if (pow < 0){
		        	while( -1 > pow ){
		        		num = num / onum;
	        			pow = pow + 1;
		        	}
		        }else{
	        		while( 1 < pow ){
				        num = num * onum;
			        	pow = pow - 1;
	        		}
	        	}
	        	Solution = ((float)num);
                }
	}

	public static void main(String[] args) {
		if(null == args || 2 > args.length){
			ProgramError = "Usage: Up [Core Number] [Number of Uppings]";
			System.out.println(ProgramError);
			ProgramError = "Not enough initial input arguments";
			System.out.println(ProgramError);
			return;
		}
		float Core = Long.valueOf(args[0]).longValue();
		int Uppings = Integer.parseInt(args[1]);
		byte firstTest = (byte)Integer.parseInt(args[2]);
		branch NewTest = new branch(new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, firstTest});
		
		System.out.println(branch.GetVal());
		System.out.println(branch.GetTenPower()[0] + ", " + branch.GetTenPower()[1]);/**
		if (10 > Uppings){
			System.out.println(Upping(Core, Uppings));
		}else{
			ProgramError = "Your 'Up' value is too long, solution larger than 10^19.";
			System.out.println(ProgramError);
		}**/
			
	}//End main

	public static float Upping(float Core, int Upping) {
		float out = 0;
		power calc = new power();
		Upping = Upping - 1;
		if (1 < Upping) {
			out = calc.power(Core, Upping(Core, Upping));
		}else{
			out = calc.power(Core, Core);
		}
		return out;
	}//End funct

}//End class
