package resultclasses;

public class Proveedor {
	private Long numReg;
	private String procedenc;
	
	
	public Proveedor(Long numReg, String procedenc) {
		super();
		this.numReg = numReg;
		this.procedenc = procedenc;
	}
	public Long getNumReg() {
		return numReg;
	}
	public void setNumReg(Long numReg) {
		this.numReg = numReg;
	}
	public String getProcedenc() {
		return procedenc;
	}
	public void setProcedenc(String procedenc) {
		this.procedenc = procedenc;
	}
	
}
