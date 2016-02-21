package resultclasses;

public class RolesMenuNivel {
	private Integer nivel;
	private String nombre;
	private String codMenu;
	private String nombreMenu;
	
	public RolesMenuNivel(){}
	
	public RolesMenuNivel(Integer nivel, String nombre, String codMenu, String nombreMenu) {
		super();
		this.nivel = nivel;
		this.nombre = nombre;
		this.codMenu = codMenu;
		this.nombreMenu = nombreMenu;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodMenu() {
		return codMenu;
	}
	public void setCodMenu(String codMenu) {
		this.codMenu = codMenu;
	}
	public String getNombreMenu() {
		return nombreMenu;
	}
	public void setNombreMenu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}
	
	
}
