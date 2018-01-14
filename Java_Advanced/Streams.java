import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
	private static final String[] tensNames = {""," ten"," twenty", " thirty", " forty", " fifty",
		    " sixty", " seventy", " eighty", " ninety" };

		  private static final String[] numNames = { "", " one", " two", " three", " four",
		    " five", " six", " seven", " eight", " nine", " ten", " eleven", " twelve",
		    " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen",
		    " nineteen"
		  };

		  private static String convertDigitToWord(int number) {
		    String soFar;

		    if (number % 100 < 20){
		      soFar = numNames[number % 100];
		      number /= 100;
		    }
		    else {
		      soFar = numNames[number % 10];
		      number /= 10;

		      soFar = tensNames[number % 10] + soFar;
		      number /= 10;
		    }
		    if (number == 0) return soFar;
		    return numNames[number] + " hundred" + soFar;
		  }
	public static void main(String args[]){
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> multipleList = numbers.stream().filter(i -> i%5==0).collect(Collectors.toList());
		for(Integer i : multipleList)
			System.out.println(convertDigitToWord(i));
		
	}
}
