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
	private String []separador = {};

	public int add(String strNum){
		if(strNum.length() >= LIMIT_STRING){
			strNum = strNum.replace(ENTER, strSep);
			if(strNum.contains(DOUBLE_SLASH)){				
				strSep = strNum.substring(2, 3);
				if(strNum.contains(SQUARE_BRACKET_CLOSE)){
					strNum = strNum.replace(SQUARE_BRACKET_OPEN, SQUARE_BRACKET_CLOSE);
					separador = strNum.split(SQUARE_BRACKET_CLOSE);
					strNum = strNum.substring(strNum.indexOf(",")+1);
					for(int i = 1;i< separador.length;i=i+2){
						strNum = strNum.replace(separador[i], ",");
					}
				}else{
					strNum = strNum.substring(strNum.indexOf(",")+1);
				}
				
			}
			strNum = strNum.replace(strSep, ",");
			nums = strNum.split(",");
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
