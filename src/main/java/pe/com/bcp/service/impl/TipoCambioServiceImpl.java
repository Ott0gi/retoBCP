package pe.com.bcp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.bcp.entity.TipoCambioEntity;
import pe.com.bcp.model.TipoCambioModel;
import pe.com.bcp.repository.TipoCambioRepository;
import pe.com.bcp.service.TipoCambioService;
import pe.com.bcp.util.Constants;
import rx.Single;

@Service
public class TipoCambioServiceImpl implements TipoCambioService{
	
	@Autowired
	private TipoCambioRepository tipoCambioRepository;

	@Override
	public Single<TipoCambioModel> obtenerCambio(String monedaOrigen, String monedaDestino, Double cantidad) {
		return Single.create(x -> {
			TipoCambioModel model = new TipoCambioModel();
			List<TipoCambioEntity> listaCambio = tipoCambioRepository.obtenerCambio(monedaOrigen, monedaDestino);
			if (listaCambio.size() == 1) {
				TipoCambioEntity entity = listaCambio.get(0);
				double resultadoCambio = Math.round(cantidad*entity.getCambio()*100.0)/100.0;
				model.setMonedaOrigen(entity.getMonedaOrigen());
				model.setMonedaDestino(entity.getMonedaDestino());
				model.setTipoCambio(entity.getCambio());
				model.setResultadoCambio(Double.valueOf(resultadoCambio));
			} else {
				x.onError(new Exception(Constants.CODIGO_010101));
			}
			x.onSuccess(model);
	    });
	}
	
	@Override
	public Single<Void> actualizarCambio(String monedaOrigen, String monedaDestino, Double cambio) {
		return Single.create(x -> {
			tipoCambioRepository.actualizarCambio(monedaOrigen, monedaDestino, cambio);
			x.onSuccess(null);
		});
	}

}
