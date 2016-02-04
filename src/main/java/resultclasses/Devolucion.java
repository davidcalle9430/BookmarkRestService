package resultclasses;

import sidic.entities.Cardexi;
import sidic.entities.Genero;

/**
 * Clase intenmediaria que sirve para almacenar objetos, que se envía en un request HTTP 
 * cuando la fucnionalidad exige la actualización recurrente de varias tablas,
 * con el fin de modificarlos en la base de datos consumiento el api.
 * **/
public class Devolucion {
	
	private Genero genero;
	private Cardexi cardexi;	
	
	public Devolucion() {
		super();
	}

	public Devolucion(Genero genero, Cardexi cardexi) 
	{
		super();
		this.genero = genero;
		this.cardexi = cardexi;
	}

	
	public Genero getGenero() 
	{
		return genero;
	}

	public void setGenero(Genero genero) 
	{
		this.genero = genero;
	}

	
	public Cardexi getCardexi() 
	{
		return cardexi;
	}

	public void setCardexi(Cardexi cardexi) 
	{
		this.cardexi = cardexi;
	}

	@Override
	public String toString() 
	{
		return "Bodega [articulo=" + genero + ", cardexi=" + cardexi + "]";
	}

	
}
