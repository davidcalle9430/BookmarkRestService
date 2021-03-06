package resultclasses;

import sidic.entities.Articulo;
import sidic.entities.Cardex;
import sidic.entities.Importaciones;

/**
 * Clase intenmediaria que sirve para almacenar objetos, que se envía en un request HTTP 
 * cuando la fucnionalidad exige la actualización recurrente de varias tablas,
 * con el fin de modificarlos en la base de datos consumiento el api.
 * **/

public class Compra 
{
	
	private Articulo articulo;
	private Cardex cardex;
	private Importaciones importacion;
	
	
	
	public Compra() 
	{
		super();
	}

	public Compra(Articulo articulo, Cardex cardex, Importaciones importacion) 
	{
		super();
		this.articulo = articulo;
		this.cardex = cardex;
		this.importacion = importacion;
	}

	
	public Articulo getArticulo() 
	{
		return articulo;
	}

	public void setArticulo(Articulo articulo) 
	{
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

	public Importaciones getImportacion() 
	{
		return importacion;
	}

	public void setImportacion(Importaciones importacion) 
	{
		this.importacion = importacion;
	}

	@Override
	public String toString() 
	{
		return "Compra [articulo=" + articulo + ", cardex=" + cardex + ", importacion=" + importacion + "]";
	}
	
}
