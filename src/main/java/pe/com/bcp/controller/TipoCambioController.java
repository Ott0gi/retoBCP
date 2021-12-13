package pe.com.bcp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.com.bcp.model.ResponseError;
import pe.com.bcp.model.ResponseOK;
import pe.com.bcp.model.TipoCambioModel;
import pe.com.bcp.service.TipoCambioService;
import pe.com.bcp.util.Constants;
import rx.Single;
import rx.schedulers.Schedulers;

@RestController
@RequestMapping("/api/tipo-cambio")
public class TipoCambioController {
	
	@Autowired
	private TipoCambioService tipoCambioService;
	
	@GetMapping("/obtener")
	public Single<ResponseEntity<TipoCambioModel>> obtenerCambio(
			@RequestParam(required = true) String monedaOrigen,
			@RequestParam(required = true) String monedaDestino,
			@RequestParam(required = true) Double cantidad) {
		return tipoCambioService.obtenerCambio(monedaOrigen, monedaDestino, cantidad)
								.subscribeOn(Schedulers.io())
								.map(cambioResponse -> ResponseEntity.ok(cambioResponse))
								.onErrorReturn(y -> {
									ResponseError error = new ResponseError(Constants.CODIGO_010101, Constants.MENSAJE_010101);
									return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
								});
	}
	
	@PutMapping("/actualizar")
	public Single<ResponseEntity<ResponseOK>> actualizarCambio(
			@RequestParam(required = true) String monedaOrigen,
			@RequestParam(required = true) String monedaDestino,
			@RequestParam(required = true) Double cambio) {
		return tipoCambioService.actualizarCambio(monedaOrigen, monedaDestino, cambio)
								.subscribeOn(Schedulers.io())
								.map(x -> ResponseEntity.ok(new ResponseOK(Constants.MENSAJE_OK_UPD_TC)))
								.onErrorReturn(y -> {
									ResponseError error = new ResponseError(Constants.CODIGO_010102, Constants.MENSAJE_010102);
									return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
								});
	}

}
