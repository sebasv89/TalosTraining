package calculator;

public class Calc {
	
	private static final String SQUARE_BRACKET_OPEN = "[";
	private static final String SQUARE_BRACKET_CLOSE = "]";
	private static final String DOUBLE_SLASH = "//";
	private static final String ENTER = "\n";
	private static final int LIMIT_STRING = 1;
	private String ExcepcionCustom = "Negatives not allowed: ";
	private int suma = 0;
	private String coma = "";
	private String []nums = {};
	private String strSep = ",";

	public int add(String strNum){
		if(strNum.length() >= LIMIT_STRING){
			strNum = strNum.replace(ENTER, strSep).replace(SQUARE_BRACKET_OPEN, "").replace(SQUARE_BRACKET_CLOSE, "");
			//System.out.println(strNum);
			if(strNum.contains(DOUBLE_SLASH)){
				strSep = strNum.substring(2, 3);
				strNum = strNum.substring(4);
			}
			System.out.println(strNum);
			System.out.println(strSep);
			nums = strNum.split(strSep);
			for(int i=0; i<nums.length; i++){
				if(Integer.parseInt(nums[i]) < 0 ){
					ExcepcionCustom = ExcepcionCustom + coma + nums[i];
					coma = ",";
				}
				if(Integer.parseInt(nums[i]) < 1000){
					suma = suma + Integer.parseInt(nums[i]);
				}
			}
			if(ExcepcionCustom != "Negatives not allowed: "){
				throw new IllegalArgumentException(ExcepcionCustom);
			}
		}
		return suma;	
	}
}
