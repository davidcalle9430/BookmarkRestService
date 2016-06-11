package resultclasses;

public class NotaDCVentasDTO {
	@Override
	public String toString() {
		return "NotaDCVentasDTO [tipo=" + tipo + ", nat=" + nat + ", valor=" + valor + "]";
	}
	public NotaDCVentasDTO() {
		super();
	}
	private String tipo;
	private String nat;
	private Integer valor;
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNat() {
		return nat;
	}
	public void setNat(String nat) {
		this.nat = nat;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public NotaDCVentasDTO(String tipo, String nat, Integer valor) {
		super();
		this.tipo = tipo;
		this.nat = nat;
		this.valor = valor;
	}
	
	
}
