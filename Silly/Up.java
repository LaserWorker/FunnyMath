import java.io.*;
import java.util.*;

public class Up { 
	
	//Incase Error cannot be given or known.
	public static String ProgramError = "Unknown"; 

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
	        	Solution = num;
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
		if (7 > Uppings){
			System.out.println(Upping(Core, Uppings));
		}else{
			ProgramError = "Your 'Up' value is too long, solution larger than 10^19.";
			System.out.println(ProgramError);
		}
			
	}//End main

	public static float Upping(float Core, int Upping) {
		float out = 0;
		Upping = Upping - 1;
		if (1 < Upping) {
			out = new Pow(Core, Upping(Core, Upping)).Solution;
		}else{
			out = new Pow(Core, Core).Solution;
		}
		return out;
	}//End funct

}//End class
