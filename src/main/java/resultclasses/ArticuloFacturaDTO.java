package resultclasses;

public class ArticuloFacturaDTO {
	
	private Long codigo;
	
	private String nombre;
	
	private String referencia;
	
	private Double valor;
	
	public ArticuloFacturaDTO(){
		
	}

	public ArticuloFacturaDTO(Long codigo, String nombre, String referencia, Double valor) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.referencia = referencia;
		this.valor = valor;
	}

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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
