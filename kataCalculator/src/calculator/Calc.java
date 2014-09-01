package calculator;

public class Calc {
	
	public static void main(String[] args) {
		Calc suma = new Calc();
		try{
			int numberReturn = suma.add("1,1,10,234,1,34565645,234234,232,43,5");
			System.out.println(numberReturn);
		}catch(Exception e){
			throw new IllegalArgumentException("String not valid.");
		}
	}
	
	private static final String SQUARE_BRACKET_OPEN = "[";
	private static final String SQUARE_BRACKET_CLOSE = "]";
	private static final String DOUBLE_SLASH = "//";
	private static final String ENTER = "\n";
	private static final String COMMA = ",";
	private static final int LIMIT_STRING = 1;
	private String ExcepcionCustom = "Negatives not allowed: ";
	private int plus = 0;
	private String comma = "";
	private String []nums = {};
	private String stringSeparator = ",";
	private String []separator = {};

	public int add(String stringNumber){
		if(stringNumber.length() >= LIMIT_STRING){
			stringNumber = formatNumberString(stringNumber);
			nums = stringNumber.split(COMMA);
			for(int i=0; i<nums.length; i++){
				validateNumberNegative(nums[i]);
				addNumbersMinusOneThousand(nums[i]);
			}
		}
		LaunchException();
		return plus;
	}
	
	private String formatNumberString(String numberString){
		numberString = replaceString(	numberString, ENTER, stringSeparator);
		if(numberString.contains(DOUBLE_SLASH)){
			if(numberString.contains(SQUARE_BRACKET_CLOSE)){
				numberString = replaceString(	numberString, SQUARE_BRACKET_OPEN, SQUARE_BRACKET_CLOSE);
				separator = numberString.split(SQUARE_BRACKET_CLOSE);
				numberString = numberString.substring(numberString.indexOf(COMMA)+1);
				for(int i = 1;i< separator.length;i=i+2){
					numberString = numberString.replace(separator[i], COMMA);
				}
			}else{
				stringSeparator = numberString.substring(2, 3);
				numberString = numberString.substring(numberString.indexOf(COMMA)+1);
			}
		}
		numberString = numberString.replace(stringSeparator, COMMA);
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
			plus = plus + Integer.parseInt(number);
		}
	}
	
	private void validateNumberNegative(String number){
		if(Integer.parseInt(number) < 0 ){
			ExcepcionCustom = ExcepcionCustom + comma + number;
			comma = COMMA;
		}
	}
}
