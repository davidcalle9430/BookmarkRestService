package web;

import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Clase encargada de servir los archivo estaticos que se
 * encuentran fuera del classpath
 * @author david
 *
 */
@Controller
public class ReportesController {

	public final static String REPORTS_PATH = "reports/"; //ruta del archivo
	public final static String XLS_EXTENSION = ".xls";
	public final static String PDF_EXTENSION = ".pdf";
	
	/**
	 * funcion encargada de servir el archivo estático para descarga
	 * @param fileName, nombre del archivo a descagar
	 * @return
	 */
	@RequestMapping(value = "/reports/{file_name}/", method = RequestMethod.GET)
	@ResponseBody
	public FileSystemResource getFile( @PathVariable("file_name") String fileName) {
	    return new FileSystemResource(  REPORTS_PATH + fileName ); 
	}
	
}
