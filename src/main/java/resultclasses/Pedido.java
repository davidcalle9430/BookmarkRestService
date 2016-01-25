package resultclasses;

import java.util.Date;

/**
 * Clase intenmediaria para almacenar el resultado de un consulta JPQL.
 * Modela un Pedido con sus detalles.
 * **/
public class Pedido 
{
    private Date fecha;
	private Double nDoc;
	private Double costo;
	private Double venta;
	private Double utilidad;
	
	
	public Pedido() 
	{
		super();
	}


	public Pedido(Date fecha, Double nDoc, Double costo, Double venta) 
	{
		super();
		this.fecha = fecha;
		this.nDoc = nDoc;
		this.costo = costo;
		this.venta = venta;
	}


	public Date getFecha() 
	{
		return fecha;
	}


	public void setFecha(Date fecha) 
	{
		this.fecha = fecha;
	}


	public Double getnDoc() 
	{
		return nDoc;
	}


	public void setnDoc(Double nDoc) 
	{
		this.nDoc = nDoc;
	}


	public Double getCosto() {
		return costo;
	}


	public void setCosto(Double costo) 
	{
		this.costo = costo;
	}


	public Double getVenta() 
	{
		return venta;
	}


	public void setVenta(Double venta) 
	{
		this.venta = venta;
	}


	public Double getUtilidad() 
	{
		return utilidad;
	}


	public void setUtilidad(Double utilidad) 
	{
		this.utilidad = utilidad;
	}


	@Override
	public String toString() 
	{
		return "Pedido [fecha=" + fecha + ", nDoc=" + nDoc + ", costo=" + costo + ", venta=" + venta + ", utilidad="
				+ utilidad + "]";
	}
	
	
	
}
