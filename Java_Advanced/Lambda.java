import java.util.Arrays;
import java.util.List;

@FunctionalInterface  
interface Sayable{  
    String multiple(int number);  
}  
  
public class Lambda{  
    public static void main(String[] args) {  
    	String[] tensNames = {""," ten"," twenty", " thirty", " forty", " fifty",
    		    " sixty", " seventy", " eighty", " ninety" };

    	String[] numNames = { "", " one", " two", " three", " four",
    		    " five", " six", " seven", " eight", " nine", " ten", " eleven", " twelve",
    		    " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen",
    		    " nineteen"
    		  };  
       
    	Sayable multiple = (number)-> {  
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
		};  
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        for(int i : numbers)
            System.out.println(multiple.multiple(i));  
    }

	
}  