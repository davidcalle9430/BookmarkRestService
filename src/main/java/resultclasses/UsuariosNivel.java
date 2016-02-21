package resultclasses;

public class UsuariosNivel {
	private String usuario;
	private Integer nivel;
	private String nombreNivel;
	private Integer maxDias;
	private Integer diasAlerta;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public String getNombreNivel() {
		return nombreNivel;
	}
	public void setNombreNivel(String nombreNivel) {
		this.nombreNivel = nombreNivel;
	}
	public Integer getMaxDias() {
		return maxDias;
	}
	public void setMaxDias(Integer maxDias) {
		this.maxDias = maxDias;
	}
	public Integer getDiasAlerta() {
		return diasAlerta;
	}
	public void setDiasAlerta(Integer diasAlerta) {
		this.diasAlerta = diasAlerta;
	}
	public UsuariosNivel() {
		super();
	}
	public UsuariosNivel(String usuario, Integer nivel, String nombreNivel, Integer maxDias, Integer diasAlerta) {
		super();
		this.usuario = usuario;
		this.nivel = nivel;
		this.nombreNivel = nombreNivel;
		this.maxDias = maxDias;
		this.diasAlerta = diasAlerta;
	}
	
	
}
