package resultclasses;

/**
 * Clase intenmediaria que sirve para almacenar objetos, que se envía en un request HTTP 
 * cuando la fucnionalidad exige la actualización recurrente de varias tablas,
 * con el fin de modificarlos en la base de datos consumiento el api.
 * **/
public class ArticuloGenero 
{

	private Long codigo;
	private String nombre;
	private String referencia;
	private Double precio;
	
	public ArticuloGenero(){}
	
	public Long getCodigo() 
	{
		return codigo;
	}
	
	public void setCodigo(Long codigo) 
	{
		this.codigo = codigo;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
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
