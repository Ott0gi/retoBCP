package pe.com.bcp.service;

import pe.com.bcp.model.TipoCambioModel;
import rx.Single;

public interface TipoCambioService {
	
	public Single<TipoCambioModel> obtenerCambio(String monedaOrigen, String monedaDestino, Double cantidad);
	
	public Single<Void> actualizarCambio(String monedaOrigen, String monedaDestino, Double cambio);
	
}
