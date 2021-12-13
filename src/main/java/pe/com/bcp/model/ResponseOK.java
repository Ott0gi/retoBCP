package pe.com.bcp.model;

public class ResponseOK {
	
	private String mensaje;

	public ResponseOK(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
