package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Articulo {

	@Id
	@GeneratedValue
	private Long id;
	
	private String reference;
	
	private String referencia;
	
	private String modelo1;
	
	private String modelo2;
	
	private String modelo3;
	
	private String marca;
	
	private Double precio;
	
	private Integer disponibles;
	
	private String procedencia;
	
	private Double costoPromedio;
	
	private Double costoJM;

	
	public Articulo(){
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(Integer disponibles) {
		this.disponibles = disponibles;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public Double getCostoPromedio() {
		return costoPromedio;
	}

	public void setCostoPromedio(Double costoPromedio) {
		this.costoPromedio = costoPromedio;
	}

	public Double getCostoJM() {
		return costoJM;
	}

	public void setCostoJM(Double costoJM) {
		this.costoJM = costoJM;
	}
	
	
	
	
	
	
}
