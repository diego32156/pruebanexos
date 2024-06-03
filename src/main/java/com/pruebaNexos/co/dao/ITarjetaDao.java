package com.pruebaNexos.co.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaNexos.co.entity.Tarjeta;

public interface ITarjetaDao extends JpaRepository<Tarjeta, Long> {
	public Tarjeta   findById(long id);
    Tarjeta findByNumeroDeTarjeta(String numeroDeTarjeta);
}
