package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FechasParser {
	
	public Date parseFecha(String fechaString){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try {
			fecha = formatter.parse(fechaString);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return fecha;
		
	}

}
