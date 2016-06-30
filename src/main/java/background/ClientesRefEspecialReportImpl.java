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
import resultclasses.EstadoReporte;
import services.ArticuloService;
import web.ReportesController;

@Service
public class ClientesRefEspecialReportImpl implements  ClientesRefEspecialReport{

	final static Logger logger = Logger.getLogger( ClientesRefEspecialReportImpl.class );
	
	private EstadoReporte  estado = new EstadoReporte( EstadoReporte.NINGUNO );
	
	@Autowired
	private ArticuloService articuloService;
	
	
	public EstadoReporte getEstado( ){
		return estado;
	}
	
	@Async
	public Future<Boolean> generarReporte( String formato ){
		JasperPrint jasperPrint = null;
		estado.setEstado( EstadoReporte.GENERANDO );
        try {
            JasperReport report = JasperCompileManager.compileReport("src/main/resources/reports/listadoClientesReferenciaEspecial.jrxml");
            HashMap<String, Object> data = new HashMap<>(); // por ahora el reporte va a venir vac�o
            
            ListadoClientesReferenciaEspecialDS ds = new ListadoClientesReferenciaEspecialDS(
            		articuloService.darClientesEspeciales() );
            
            jasperPrint = JasperFillManager.fillReport( report , data ,  ds );
            
            JasperExportManager.exportReportToPdfFile( jasperPrint , ReportesController.REPORTS_PATH + "clientesRefenciaEspecial.pdf" );
            
            logger.info( "Reporte clientes referencia especial generado correctamente" );
            estado.setEstado( EstadoReporte.TERMINADO );
            return new AsyncResult<>( true );
        } catch (JRException ex) {
        	
        	logger.error( ex.getMessage() );
            return new AsyncResult<>( false );
            
        }        
	}

}
