package resultclasses;




public class AnularFacturaDTO {
	
    private Long codigo;
	
    private String fecha;

    private Long factura;
    
    

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Long getFactura() {
		return factura;
	}

	public void setFactura(Long factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "AnularFacturaDTO [codigo=" + codigo + ", fecha=" + fecha + ", factura=" + factura + "]";
	}

    
}
