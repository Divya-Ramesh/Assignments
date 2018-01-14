import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class DateTime {
	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z");
		
		df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		String IST = df.format(date);
		System.out.println("Indian Timezone : "+IST);
		
		df.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
		String PST = df.format(date);
		System.out.println("Paris Timezone : "+PST);
		
		df.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		String NST = df.format(date);
		System.out.println("NewYork Timezone : "+NST);
		
		df.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		String LST = df.format(date);
		System.out.println("London Timezone : "+LST);
		
		df.setTimeZone(TimeZone.getTimeZone("Africa/Malabo"));
		String MST = df.format(date);
		System.out.println("Malabo Timezone : "+MST);
		
		List<Date> myList = new ArrayList<>();
        myList.add(new Date(2015-1900, 01, 01));
        myList.add(new Date(2013-1900, 01, 01));
        myList.add(new Date(2013-1900, 01, 02));
        myList.add(new Date(2012-1900, 10, 01));
        myList.add(new Date(2012-1900, 11, 01));
        myList.add(new Date(2015-1900, 01, 10));
         
        Collections.sort(myList, new Comparator<Date>(){
 
            @Override
            public int compare(Date o1, Date o2) {
                return o1.compareTo(o2);
            }
        });
         
        for(int i = 0; i < myList.size(); i++){
            System.out.println(myList.get(i).toString());
        }
		}
}
