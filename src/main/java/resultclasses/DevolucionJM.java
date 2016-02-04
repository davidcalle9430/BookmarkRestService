package resultclasses;

import sidic.entities.Articulo;
import sidic.entities.Cardex;

/**
 * Clase intenmediaria que sirve para almacenar objetos, que se envía en un request HTTP 
 * cuando la fucnionalidad exige la actualización recurrente de varias tablas,
 * con el fin de modificarlos en la base de datos consumiento el api.
 * **/
public class DevolucionJM {
	
	private Articulo articulo;
	private Cardex cardex;	
	
	public DevolucionJM() {
		super();
	}

	public DevolucionJM( Cardex cardex, Articulo articulo) 
	{
		super();
		this.cardex = cardex;
		this.articulo = articulo;
	}
	
	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Cardex getCardex() 
	{
		return cardex;
	}

	public void setCardex(Cardex cardex) 
	{
		this.cardex = cardex;
	}

	@Override
	public String toString() 
	{
		return "Bodega [articulo=" + articulo + ", cardex=" + cardex + "]";
	}

	
}
