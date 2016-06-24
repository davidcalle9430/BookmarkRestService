package services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.AcumVentasMesRepository;
import repositories.LineasRepository;
import repositories.NFactRepository;
import repositories.ValorizacionInventarioRepository;
import sidic.entities.AcumVentasMes;
import sidic.entities.Lineas;
import sidic.entities.Nfact;
import sidic.entities.ValorizacionInventario;
import sidic.entities.ValorizacionInventarioPK;
import utility.DateBuilder;

@Service
public class PrincipalServiceImpl implements PrincipalService {

	
	@Autowired
	private NFactRepository nfactRepository;
	
	@Autowired
	private LineasRepository lineasRepository;
	
	
	@Autowired
	private AcumVentasMesRepository acumVentasMesRepository;
	
	@Autowired
	private ArticuloService articuloService;
	
	@Autowired
	private ValorizacionInventarioRepository valorizacionInventarioRepository;
	
	@Override
	public void acumVentasMes() {
		
		Double v1AcumIva;
		Nfact nfact = nfactRepository.findOne( 1 );
		if( nfact != null ){
			v1AcumIva = nfact.getAcumiva() != null ? nfact.getAcumiva() : 0.0 ;
		}else{
			v1AcumIva = 0.0;
		}
		Date hoy = DateBuilder.crearFechaSinHora();
		AcumVentasMes acum = acumVentasMesRepository.findOne( hoy );
		if( acum == null ){
			acum = new AcumVentasMes( );
			acum.setFecha( hoy );
			acum.setValor( v1AcumIva );
		}else{
			acum.setValor( v1AcumIva );
		}
		acumVentasMesRepository.save( acum );
	}

	@Override
	public void valorizacion() {
		Double v1_codcorr = 90000.0;
		List< Lineas > lineas = lineasRepository.findAll();
		for (Lineas linea : lineas) {
			Double suma = articuloService
					.darSumaDisponibleRango( linea.getRango1() , linea.getRango2() );
			Double v1Total = suma != null? suma : 0.0;	
			if( v1Total != 0.0 ){ 
				v1_codcorr = v1_codcorr + 1;
				List< ValorizacionInventario > valorInv = valorizacionInventarioRepository.findAllByValorizacionInventarioPK_FechaAndValorizacionInventarioPK_LineaAndTiporeg(
						DateBuilder.crearFechaSinHora() ,
						linea.getLinea(),
						5l);
				valorizacionInventarioRepository.delete( valorInv );
				//crear una nueva valorizacion
				ValorizacionInventario valorizacionNueva = new ValorizacionInventario();
				valorizacionNueva.setValorizacionInventarioPK( new ValorizacionInventarioPK() );
				valorizacionNueva.getValorizacionInventarioPK().setFecha( DateBuilder.crearFechaSinHora() );
				valorizacionNueva.setTiporeg( 5l );
				valorizacionNueva.getValorizacionInventarioPK().setLinea( linea.getLinea() );
				valorizacionNueva.setNomlinea("VALORIZACION DEL INVENTARIO JM AL " 
						+ DateBuilder.getDay( DateBuilder.crearFechaSinHora() ) +
						" DE " + DateBuilder.getNombreMes( DateBuilder.crearFechaSinHora() ));
				valorizacionNueva.setCodcorr( v1_codcorr );
				valorizacionNueva.setNomcorr( linea.getDescripcion() );
				valorizacionNueva.setValor( v1Total );
				valorizacionInventarioRepository.save( valorizacionNueva );
			}
		}
		Double total = articuloService.darTotal();
		Double v1_total = total != null ? total : 0;
		List< ValorizacionInventario > valorInv = valorizacionInventarioRepository.findAllByValorizacionInventarioPK_FechaAndValorizacionInventarioPK_LineaAndTiporeg(
				DateBuilder.crearFechaSinHora() ,
				99999l ,
				6l );
		valorizacionInventarioRepository.delete( valorInv );
		//crear una nueva valorizacion
		ValorizacionInventario valorizacionNueva = new ValorizacionInventario();
		valorizacionNueva.setValorizacionInventarioPK( new ValorizacionInventarioPK() );
		valorizacionNueva.getValorizacionInventarioPK().setFecha( DateBuilder.crearFechaSinHora() );
		valorizacionNueva.setTiporeg( 5l );
		valorizacionNueva.getValorizacionInventarioPK().setLinea( 6l );
		valorizacionNueva.setNomlinea("VALORIZACION DEL INVENTARIO JM AL " 
				+ DateBuilder.getDay( DateBuilder.crearFechaSinHora() ) +
				" DE " + DateBuilder.getNombreMes( DateBuilder.crearFechaSinHora() ));
		valorizacionNueva.setCodcorr( 99999.0 );
		valorizacionNueva.setNomcorr( "." );
		valorizacionNueva.setValor( v1_total );
		valorizacionInventarioRepository.save( valorizacionNueva );
		
	}

}
