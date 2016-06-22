package resultclasses;

public class ArticuloGeneroCostoDTO {
	
	private String nombre;
	
	private String referencia;
	
	private Double costprom;
	
	private Double invimppas;
	
	private Double ultcomp;
	
	private Double ultcostpr;

	
	public ArticuloGeneroCostoDTO(){}
	
	
	
	
	public ArticuloGeneroCostoDTO(String nombre, String referencia, Double costprom, Double invimppas, Double ultcomp,
			Double ultcostpr) {
		super();
		this.nombre = nombre;
		this.referencia = referencia;
		this.costprom = costprom;
		this.invimppas = invimppas;
		this.ultcomp = ultcomp;
		this.ultcostpr = ultcostpr;
	}




	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Double getCostprom() {
		return costprom;
	}

	public void setCostprom(Double costprom) {
		this.costprom = costprom;
	}

	public Double getInvimppas() {
		return invimppas;
	}

	public void setInvimppas(Double invimppas) {
		this.invimppas = invimppas;
	}

	public Double getUltcomp() {
		return ultcomp;
	}

	public void setUltcomp(Double ultcomp) {
		this.ultcomp = ultcomp;
	}

	public Double getUltcostpr() {
		return ultcostpr;
	}

	public void setUltcostpr(Double ultcostpr) {
		this.ultcostpr = ultcostpr;
	}
	
	

}
