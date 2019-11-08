package magongwa.jeremia.student.generator;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class StudentNoGenerator {
	
	public static String  StudentNo(String schoolId,String province,int count)
	{
		Calendar date = new GregorianCalendar(2012, 9, 5);
		int year = date.get(Calendar.YEAR); 
	    int newCount = count + 1;
	    
		String StudentNo = year+province+String.format("%05d", newCount);
	    return StudentNo;
	}
	

}
