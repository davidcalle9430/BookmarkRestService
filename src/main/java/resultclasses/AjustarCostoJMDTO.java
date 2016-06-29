package resultclasses;

public class AjustarCostoJMDTO {

	private Long codigo;
	
	private String nombre;
	
	private String referencia;
	
	private Double cosultcom;
	
	private Double nvocosto;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public Double getCosultcom() {
		return cosultcom;
	}

	public void setCosultcom(Double cosultcom) {
		this.cosultcom = cosultcom;
	}

	public Double getNvocosto() {
		return nvocosto;
	}

	public void setNvocosto(Double nvocosto) {
		this.nvocosto = nvocosto;
	}

	@Override
	public String toString() {
		return "AjustarCostoJMDTO [codigo=" + codigo + ", nombre=" + nombre + ", referencia=" + referencia
				+ ", cosultcom=" + cosultcom + ", nvocosto=" + nvocosto + "]";
	}
	
	
	
}
