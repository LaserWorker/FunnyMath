import java.io.*;
import java.util.*;

public class BranchMathTest { 
	
	//Incase Error cannot be given or known.
	public static String ProgramError = "Unknown"; 

	public static class branch{
		byte[] Value = new byte[8];
		public branch(byte[] val){
			byte li = (byte)val.length;
			for (int c = 0; li > c; c++)
				Value[c] = val[c];
		}
		public branch(short val){
			Value = new byte[8];
		}
		public branch(int val){
			Value = new byte[8];
		}
		public branch(long val){
		System.out.println(val);
			long v = val;
			int num = 0;
			Value[7] = (byte)(v>>56);
			if((0 == Value[7]) | (-1 == Value[7])){
				for (int c = 0; 7 > c; c++){
					Value[(6-c)] = (byte)(v >> (6 - c << 3));
				}
				Value[7] = (byte)0;
			}else{
				if (v<0) v = 0L - v; 
				for (num = 0; v > 0; num++) v = v >> 1; 
				v = val;
				num = num - 55; 
				for (int c = 0; 7 > c; c++)
					Value[(6-c)] = (byte)(((v>>num) >> (6 - c << 3)));

				Value[7] = (byte)(num);
			}
		}
		public branch(float val){
			Value = new byte[8];
		}
		public branch(double val){

			Value = new byte[8];
		}
		public branch(){
			Value = new byte[8];
		}
		public void fromString(String val){
			Value = new byte[8];
		}
		public static branch isSq(Object val){
			double DVal = 0D;
			long LVal = 0L;
			int n=0;
			switch (val.getClass().getSimpleName()){ 
			case "Byte":
				n = (int)val;
			case "Short":
				n = (int)val;
			case "Integer":
				n = (int)val;
			case "Float":
				n = (int)val;
				DVal = (double)n;
				LVal = (long)n;
			break;
			case "Double":		
				DVal = (double)val;
				LVal = (long)val;
			break;
			case "String":
				DVal = Double.parseDouble((String)val);
				LVal = (long)DVal;
			break;
			case "Long":
				LVal = (long)val;
				n = (int)LVal;
			break;
			default:
			break;
			}
			if((30370004999L) > LVal & LVal > (0 - 30370004999L)){
				LVal = LVal * LVal;
				return new branch(LVal);
			}else{ //lost precision
				DVal = DVal * DVal;
			}
			
			return new branch(DVal);
		}
		public static branch isSqrt(Object A){
			return new branch();
		}
		public static branch isExp(Object A){
			return new branch();
		}
		public static branch isLn(Object Answer){
			return new branch();
		}
		public static branch isPow(Object Base, Object Exp){
			return new branch();
		}
		public static branch isMul(Object A, Object B){
			return new branch();
		}
		public static branch isDev(Object N, Object D){
			return new branch();
		}
		public static branch isAdd(Object A, Object B){
			return new branch();
		}
		public static branch isSub(Object A, Object B){
			return new branch();
		}
		public static branch isLog(Object Base, Object Answer){
			return new branch();
		}
		public String Display(){
			String Tens = "";
			int i[] = GetTenPower();
			if(0 > i[0]){
				Tens = "10^-10^";
				i[0] = 0 - i[0];
			}
			for(int c = i[0]; 0 < c; c--)
				Tens = Tens + "10^";

			Tens = " * " + Tens + (i[1]+2);
			//if (0==i[1] & 2 > i[1]) Tens = "  ";

			long val = (GetVal())/TenPower(i[1]);
			int branch = (Value[7]<<27)>>27;
			if (0 < branch) val = (val)<<branch;
			val = val / 100L;
			return val + Tens;
		}
		public String DisplayRawBytes(){
			String Vals = Value[7] + " ";
			for(int c = 6; (0 - 1) < c; c--)
				Vals = Vals + ",  " + Value[c];
			return Vals;
		}
		public long GetVal(){
			long  Val = ((long)Value[6])<<48;
			Val = Val | ((long)(Value[5] & 0xFF))<<40;
			Val = Val | ((long)(Value[4] & 0xFF))<<32;
			Val = Val | ((long)(Value[3] & 0xFF))<<24;
			Val = Val | ((long)(Value[2] & 0xFF))<<16;
			Val = Val | ((long)(Value[1] & 0xFF))<<8;
			Val = Val | (long)(0xFF & (Value[0]));
			return Val;
		}
		public static int TenPower(int raised){
			if (0 < raised){
			raised = raised - 1;
			return 10*TenPower(raised);
			}else{
			return 1;
			}
		}
		public int[] GetTenPower(){
			return ToTenPow(Branch(Value[7]));
		}
//301029995663981195213738894724493026768189881462108541310 Log 2 / Log 10
//10000000000
		public static int[] ToTenPow(int[] to){
			int[] raised = new int[]{to[0], (LogBaseTwo(to[1]))};
			if (0 < to[1]){
				long sol = 30103L * to[1];
				raised[1] = (int)(sol / 100000L);
			}
			if (to[0] > 1){
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
				to = branch;
			}
			return new int[]{raised, to};
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
		public byte[] ShiftArray(byte[] Array, int shift){
			for (int i = (Array.length-(shift+1)); i > -1; i--) {
				Array[i] = Array[i+shift];
			}
			return Array;
		}
	}
	public static void main(String[] args) {
		if(null == args || 1 > args.length){
			ProgramError = "Usage: Up [Action] [Values]";
			System.out.println(ProgramError);
			ProgramError = "Not enough initial input arguments";
			System.out.println(ProgramError);
			return;
		}
		//float Core = Long.valueOf(args[0]).longValue();
		//int Uppings = Integer.parseInt(args[1]);
		int InLnth = args.length;
		byte[] ByteArray = new byte[InLnth];
		Object J = ByteArray[0];
		
		Object K = InLnth;
		
		long val = Long.parseLong(args[0], 10);
		branch Test = new branch(val);
		System.out.println(Test.Display());
		System.out.println(Test.DisplayRawBytes());
		Test = branch.isSq(val);
		System.out.println(Test.Display());
		System.out.println(Test.DisplayRawBytes());

		//for (int c = 7; (0 - 1) < c; c--){
		//	ByteArray[c] = (byte)Integer.parseInt(args[c]);
		//}
		//branch NewTest = new branch(ByteArray);

		//System.out.println(NewTest.Display());
		//System.out.println(NewTest.DisplayRawBytes());

	}//End main

}//End class
