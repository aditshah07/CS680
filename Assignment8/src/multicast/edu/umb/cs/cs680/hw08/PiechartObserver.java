package multicast.edu.umb.cs.cs680.hw08;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class PiechartObserver implements Observer {

	public void update(Observable o, Object arg) {
		Field fields[] = arg.getClass().getDeclaredFields();
		HashMap <String, String> hashMap = new HashMap<String, String>();
		for(int i=0; i<fields.length; i++)
		{
			Field field = fields[i];
			field.setAccessible(true);
			try {
				hashMap.put(field.getName(), field.get(arg).toString());
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		System.out.print("PieChartObserver");
		Iterator<String> iterator = hashMap.keySet().iterator();
		while(iterator.hasNext()) {
			String str = iterator.next();
			if(!str.contains("jacoco"))
				System.out.print(" " + str + ": " + hashMap.get(str) + ",");
		}
		System.out.println("");
	
	}
}
