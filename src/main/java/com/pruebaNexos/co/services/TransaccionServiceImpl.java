package com.pruebaNexos.co.services;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.NoSuchElementException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaNexos.co.dao.ITransaccionDao;
import com.pruebaNexos.co.entity.Tarjeta;
import com.pruebaNexos.co.entity.Transaccion;

@Service
public class TransaccionServiceImpl implements ITransaccionService {
	
	@Autowired
	private ITransaccionDao transaccionDao;
	
	@Autowired
	private ITarjetaService tarjetaService;

	@Override
	public Transaccion compra(String numeroTarjeta, double montoDeTarjeta) {
		
	
		Tarjeta tarjeta = tarjetaService.obtenerNumerodeTarjeta(numeroTarjeta);
		if(tarjeta != null) {
			throw new NoSuchElementException("Tarjeta no encontrada con número " + numeroTarjeta );
	
		}else {
			if(!tarjeta.isActivada() || tarjeta.isBloqueada() || tarjeta.getBalance() < montoDeTarjeta || tarjeta.getFechaDeCaducidad().isBefore(YearMonth.now())) {
				throw new NoSuchElementException("Tarjeta no encontrada con número " + numeroTarjeta );
			}
		}
		
		tarjeta.setBalance(tarjeta.getBalance()-montoDeTarjeta );
		tarjetaService.actualizarTarjeta(tarjeta);
		
		Transaccion transacion = new Transaccion();
		transacion.setNumeroTarjeta(numeroTarjeta);
		transacion.setMontoDeTarjeta(montoDeTarjeta);
		transacion.setMarcadeTiempo(LocalDateTime.now());
		transacion = transaccionDao.save(transacion);
		
		return transacion.tuTransaccion();
	}

	@Override
	public void pagoTarjeta(String numeroDeTarjeta, double montoDeTarjeta) {
		Tarjeta tarjeta = tarjetaService.obtenerNumerodeTarjeta(numeroDeTarjeta);
		if(tarjeta != null) {
			throw new NoSuchElementException("Tarjeta no encontrada con número " + numeroDeTarjeta );
	
		}else {
			if(tarjeta.isActivada() || tarjeta.isBloqueada() ) {
				throw new NoSuchElementException("Tarjeta no encontrada con número " + numeroDeTarjeta );
			}
		}
		tarjeta.setBalance(tarjeta.getBalance()-montoDeTarjeta );
		tarjetaService.actualizarTarjeta(tarjeta);
	}

	@Override
	public Transaccion obtenerTransaccion(long id) {
		
		return transaccionDao.findById(id).orElse(null);
	}

	@Override
	public void cancelarTransaccion(long id) {
		 transaccionDao.deleteById(id);
		
	}

}
