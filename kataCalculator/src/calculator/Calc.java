package calculator;

public class Calc {
	
	private static final String SQUARE_BRACKET_OPEN = "[";
	private static final String SQUARE_BRACKET_CLOSE = "]";
	private static final String DOUBLE_SLASH = "//";
	private static final String ENTER = "\n";
	private static final String COMA = ",";
	private static final int LIMIT_STRING = 1;
	private String ExcepcionCustom = "Negatives not allowed: ";
	private int suma = 0;
	private String coma = "";
	private String []nums = {};
	private String strSep = ",";
	private String []separador = {};

	public int add(String strNum){
		if(strNum.length() >= LIMIT_STRING){
			strNum = formatNumberString(strNum);
			nums = strNum.split(COMA);
			for(int i=0; i<nums.length; i++){
				validateNumberNegative(nums[i]);
				addNumbersMinusOneThousand(nums[i]);
			}
		}
		LaunchException();
		return suma;
	}
	
	private String formatNumberString(String numberString){
		numberString = replaceString(	numberString, ENTER, strSep);
		if(numberString.contains(DOUBLE_SLASH)){
			if(numberString.contains(SQUARE_BRACKET_CLOSE)){
				numberString = replaceString(	numberString, SQUARE_BRACKET_OPEN, SQUARE_BRACKET_CLOSE);
				separador = numberString.split(SQUARE_BRACKET_CLOSE);
				numberString = numberString.substring(numberString.indexOf(COMA)+1);
				for(int i = 1;i< separador.length;i=i+2){
					numberString = numberString.replace(separador[i], COMA);
				}
			}else{
				strSep = numberString.substring(2, 3);
				numberString = numberString.substring(numberString.indexOf(COMA)+1);
			}
		}
		numberString = numberString.replace(strSep, COMA);
		return numberString;
	}
	
	private String replaceString(String word, String oldCaracther, String newCaracther){
		return word.replace(oldCaracther, newCaracther);
	}
	
	private void LaunchException(){
		if(ExcepcionCustom != "Negatives not allowed: "){
			throw new IllegalArgumentException(ExcepcionCustom);
		}
	}
	
	private void addNumbersMinusOneThousand(String number){
		if(Integer.parseInt(number) < 1000){
			suma = suma + Integer.parseInt(number);
		}
	}
	
	private void validateNumberNegative(String number){
		if(Integer.parseInt(number) < 0 ){
			ExcepcionCustom = ExcepcionCustom + coma + number;
			coma = ",";
		}
	}
}
