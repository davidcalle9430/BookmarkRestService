package background;

import java.util.HashMap;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import reports.datasources.ListadoClientesReferenciaEspecialDS;
import services.ArticuloService;

@Service
public class ClientesRefEspecialReportImpl implements  ClientesRefEspecialReport{

	final static Logger logger = Logger.getLogger( ClientesRefEspecialReportImpl.class );
	
	@Autowired
	private ArticuloService articuloService;
	
	
	@Async
	public Future<Boolean> generarReporte( String formato ){
		JasperPrint jasperPrint = null;
        try {
            JasperReport report = JasperCompileManager.compileReport("src/main/resources/reports/listadoClientesReferenciaEspecial.jrxml");
            HashMap<String, Object> data = new HashMap<>(); // por ahora el reporte va a venir vacío
            
            ListadoClientesReferenciaEspecialDS ds = new ListadoClientesReferenciaEspecialDS(
            		articuloService.darClientesEspeciales() );
            
            jasperPrint = JasperFillManager.fillReport( report , data ,  ds );
            
            JasperExportManager.exportReportToPdfFile( jasperPrint , "reports/clientesRefenciaEspecial.pdf");
            
            logger.info( "Reporte clientes referencia especial generado correctamente" );
            return new AsyncResult<>( true );
        } catch (JRException ex) {
        	
        	logger.error( ex.getMessage() );
            return new AsyncResult<>( false );
            
        }        
	}

}
