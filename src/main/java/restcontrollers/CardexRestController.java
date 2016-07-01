package restcontrollers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import services.KardexService;
import sidic.entities.Cardexi;

@RestController
public class CardexRestController {

	
	@Autowired
	private KardexService kardexService;

	@RequestMapping(value="/api/kardexi/articulo/")
	public ResponseEntity< List< Cardexi > > todosLosArticulos(@RequestParam Long codigo , @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam Date fecha ){
		
		
		List< Cardexi > res = kardexService.cardexArticuloImpordisa( codigo , fecha );
		
		return new ResponseEntity<>( res , HttpStatus.ACCEPTED );
	}
}
