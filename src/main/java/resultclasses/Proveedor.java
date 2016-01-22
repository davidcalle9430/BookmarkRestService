package resultclasses;

/**
 * Clase intenmediaria que sirve para almacenar objetos, que se envía en un request HTTP 
 * cuando la fucnionalidad exige la actualización recurrente de varias tablas,
 * con el fin de modificarlos en la base de datos consumiento el api.
 * **/

public class Proveedor 
{
	private Long numReg;
	private String procedenc;
	
	
	public Proveedor(Long numReg, String procedenc) 
	{
		super();
		this.numReg = numReg;
		this.procedenc = procedenc;
	}
	
	public Long getNumReg() 
	{
		return numReg;
	}
	public void setNumReg(Long numReg) 
	{
		this.numReg = numReg;
	}
	public String getProcedenc() 
	{
		return procedenc;
	}
	public void setProcedenc(String procedenc) 
	{
		this.procedenc = procedenc;
	}
	
}
