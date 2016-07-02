package resultclasses;

public class InformacionArticuloDTO {
	
	private Double cantdisp;
	
	private Double costprom;
	
	private Double costpromim;
	
	private Long codigo;
	
	private Double precio;
	
	private String nombre;
	
	private Double utlcosproi;
	
	private String referencia;
	
	private String uso;
	
	private String marca;
	
	private String procedenc;
	
	private String modelo1;
	
	private String modelo2;
	
	private String modelo3;
	
	private Double rotacion;

	public InformacionArticuloDTO() {
		super();
	}
	
	

	public InformacionArticuloDTO(Double cantdisp, Double costprom, Double costpromim, Long codigo, Double precio,
			String nombre, Double utlcosproi, String referencia, String uso, String marca, String procedenc,
			String modelo1, String modelo2, String modelo3) {
		super();
		this.cantdisp = cantdisp;
		this.costprom = costprom;
		this.costpromim = costpromim;
		this.codigo = codigo;
		this.precio = precio;
		this.nombre = nombre;
		this.utlcosproi = utlcosproi;
		this.referencia = referencia;
		this.uso = uso;
		this.marca = marca;
		this.procedenc = procedenc;
		this.modelo1 = modelo1;
		this.modelo2 = modelo2;
		this.modelo3 = modelo3;
	}



	public Double getCantdisp() {
		return cantdisp;
	}

	public void setCantdisp(Double cantdisp) {
		this.cantdisp = cantdisp;
	}

	public Double getCostprom() {
		return costprom;
	}

	public void setCostprom(Double costprom) {
		this.costprom = costprom;
	}

	public Double getCostpromim() {
		return costpromim;
	}

	public void setCostpromim(Double costpromim) {
		this.costpromim = costpromim;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getUtlcosproi() {
		return utlcosproi;
	}

	public void setUtlcosproi(Double utlcosproi) {
		this.utlcosproi = utlcosproi;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getProcedenc() {
		return procedenc;
	}

	public void setProcedenc(String procedenc) {
		this.procedenc = procedenc;
	}

	public String getModelo1() {
		return modelo1;
	}

	public void setModelo1(String modelo1) {
		this.modelo1 = modelo1;
	}

	public String getModelo2() {
		return modelo2;
	}

	public void setModelo2(String modelo2) {
		this.modelo2 = modelo2;
	}

	public String getModelo3() {
		return modelo3;
	}

	public void setModelo3(String modelo3) {
		this.modelo3 = modelo3;
	}



	public Double getRotacion() {
		return rotacion;
	}



	public void setRotacion(Double rotacion) {
		this.rotacion = rotacion;
	}



	@Override
	public String toString() {
		return "InformacionArticuloDTO [cantdisp=" + cantdisp + ", costprom=" + costprom + ", costpromim=" + costpromim
				+ ", codigo=" + codigo + ", precio=" + precio + ", nombre=" + nombre + ", utlcosproi=" + utlcosproi
				+ ", referencia=" + referencia + ", uso=" + uso + ", marca=" + marca + ", procedenc=" + procedenc
				+ ", modelo1=" + modelo1 + ", modelo2=" + modelo2 + ", modelo3=" + modelo3 + ", rotacion=" + rotacion
				+ "]";
	}
	
	
	
	

}
