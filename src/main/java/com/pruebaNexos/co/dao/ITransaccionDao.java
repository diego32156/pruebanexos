package com.pruebaNexos.co.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaNexos.co.entity.Transaccion;

public interface ITransaccionDao extends JpaRepository<Transaccion, Long> {
	
	List<Transaccion> findByNumeroDeTarjeta(String numeroDeTarjeta);

}
