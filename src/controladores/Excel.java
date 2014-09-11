package controladores;

import java.io.FileOutputStream;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel {
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void GuardarDatos(Vector datos){
		int size = datos.size();
		
		// Se crea el libro
        HSSFWorkbook libro = new HSSFWorkbook();

        // Se crea una hoja dentro del libro
        HSSFSheet hoja = libro.createSheet();
		
		
		for (int i = 0; i < size; i++) {
			
			String elemento = datos.get(i).toString();
			int longitud = elemento.length();
			String subs = elemento.substring(1,longitud -1);
			String [] valores = subs.split(",");
			
			// Se crea una fila dentro de la hoja
	        HSSFRow row = hoja.createRow(i);
	        
	        for (int j = 0; j < valores.length; j++) {			        	
	        	 //Se crea una celda dentro de la fila
			     HSSFCell celda = row.createCell((short) j);					     
			     String valor = valores[j];
			     HSSFRichTextString texto = new HSSFRichTextString(valor);
			     celda.setCellValue(texto);				     
	        							
			}  
								
						
		}
		
		// Se salva el libro.
		long epoch = System.currentTimeMillis()/1000;					
		String name = String.valueOf(epoch);
        try {
            FileOutputStream elFichero = new FileOutputStream(""+name+".xls");
            libro.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

}
