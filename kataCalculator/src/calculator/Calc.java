package calculator;

public class Calc {
	
	private static final String SQUARE_BRACKET = "[";

	public int add(String strNum){
		String exc = "Negatives not allowed: ";
		int ret = 0;
		String coma = "";
		String []nums = {};
		String strSep = ",";
		if(strNum.length() >= 1){
			//System.out.println("-----");
			//System.out.println(strNum);
			//System.out.println("-----");
			strNum = strNum.replace("\n", strSep).replace(SQUARE_BRACKET, "").replace("]", "");
			//System.out.println(strNum);
			//System.out.println("-----");
			if(strNum.contains("//")){
				strSep = strNum.substring(2, 3);
				strNum = strNum.substring(4);
			}
			//System.out.println(strNum);
			//System.out.println("-----");
			//System.out.println(strSep);
			//System.out.println("-----");
			nums = strNum.split(strSep);
			for(int i=0; i<nums.length; i++){
				if(Integer.parseInt(nums[i]) < 0 ){
					exc = exc + coma + nums[i];
					coma = ",";
				}
				if(Integer.parseInt(nums[i]) < 1000){
					ret = ret + Integer.parseInt(nums[i]);
				}
			}
			if(exc != "Negatives not allowed: "){
				throw new IllegalArgumentException(exc);
			}
		}
		
		return ret;
		
	}


}
