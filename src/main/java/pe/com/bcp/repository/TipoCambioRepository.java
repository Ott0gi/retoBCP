package pe.com.bcp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.bcp.entity.TipoCambioEntity;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambioEntity, Integer> {
	
	@Query(value = "SELECT id,moneda_origen,moneda_destino, cambio "
			+ "FROM TipoCambio "
			+ "WHERE moneda_origen = ?1 "
			+ "AND moneda_destino = ?2", nativeQuery = true)
	List<TipoCambioEntity> obtenerCambio(String monedaOrigen,String destino);
	
	@Transactional
	@Modifying
	@Query(value = "update TipoCambio "
			+ "SET cambio = ?3 "
			+ "WHERE moneda_origen = ?1 "
			+ "AND moneda_destino = ?2", nativeQuery = true)
	void actualizarCambio(String monedaOrigen, String destino, Double cambio);
	
}
