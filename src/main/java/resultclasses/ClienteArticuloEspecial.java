package resultclasses;

/**
 * Clase intenmediaria que sirve para almacenar objetos, que se envía en un request HTTP 
 * cuando la fucnionalidad exige la actualización recurrente de varias tablas,
 * con el fin de modificarlos en la base de datos consumiento el api.
 * **/

public class ClienteArticuloEspecial 
{
	private Long codigo;
	private String razonSocial;
	private Long articulo;
	private String referencia;
	private Double precio;
	
	public ClienteArticuloEspecial(){}
	
	public Long getCodigo() 
	{
		return codigo;
	}
	
	public void setCodigo(Long codigo) 
	{
		this.codigo = codigo;
	}
	
	public String getRazonSocial() 
	{
		return razonSocial;
	}
	
	public void setRazonSocial(String razonSocial)
	{
		this.razonSocial = razonSocial;
	}
	
	public Long getArticulo() 
	{
		return articulo;
	}
	
	public void setArticulo(Long articulo) 
	{
		this.articulo = articulo;
	}
	
	public String getReferencia() 
	{
		return referencia;
	}
	
	public void setReferencia(String referencia) 
	{
		this.referencia = referencia;
	}
	
	public Double getPrecio() 
	{
		return precio;
	}
	
	public void setPrecio(Double precio) 
	{
		this.precio = precio;
	}
	
	
}
