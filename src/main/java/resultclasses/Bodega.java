package resultclasses;

import sidic.entities.Cardexi;
import sidic.entities.Genero;

public class Bodega {
	
	private Genero genero;
	private Cardexi cardex;	
	
	public Bodega() {
		super();
	}

	public Bodega(Genero genero, Cardexi cardex) 
	{
		super();
		this.genero = genero;
		this.cardex = cardex;
	}

	
	public Genero getGenero() 
	{
		return genero;
	}

	public void setGenero(Genero genero) 
	{
		this.genero = genero;
	}

	
	public Cardexi getCardex() 
	{
		return cardex;
	}

	public void setCardex(Cardexi cardex) 
	{
		this.cardex = cardex;
	}

	@Override
	public String toString() 
	{
		return "Bodega [articulo=" + genero + ", cardex=" + cardex + "]";
	}

	
}
