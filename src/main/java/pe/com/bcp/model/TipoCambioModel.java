package pe.com.bcp.model;

public class TipoCambioModel {
	
	private String monedaOrigen;
	private String monedaDestino;
	private Double tipoCambio;
	private Double resultadoCambio;
	
	public TipoCambioModel() {}
	
	public TipoCambioModel(Double tipoCambio, Double resultadoCambio) {
		super();
		this.tipoCambio = tipoCambio;
		this.resultadoCambio = resultadoCambio;
	}

	public Double getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public Double getResultadoCambio() {
		return resultadoCambio;
	}

	public void setResultadoCambio(Double resultadoCambio) {
		this.resultadoCambio = resultadoCambio;
	}

	public String getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	public String getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

}
