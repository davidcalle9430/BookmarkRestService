package resultclasses;

import java.util.Date;

public class NotasCarteraDTO {
	
	private Integer factura;
	private String tipo;
	private Date fecha;
	private Integer codigo;
	private String razsoc;
	private Double valor;
	private Double iva;
	private String nat;
	private Integer causal;
	private String nombre;
	
	public NotasCarteraDTO(){}
	
	public Integer getFactura() {
		return factura;
	}
	public void setFactura(Integer factura) {
		this.factura = factura;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getRazsoc() {
		return razsoc;
	}
	public void setRazsoc(String razsoc) {
		this.razsoc = razsoc;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Double getIva() {
		return iva;
	}
	public void setIva(Double iva) {
		this.iva = iva;
	}
	public String getNat() {
		return nat;
	}
	public void setNat(String nat) {
		this.nat = nat;
	}
	public Integer getCausal() {
		return causal;
	}
	public void setCausal(Integer causal) {
		this.causal = causal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
