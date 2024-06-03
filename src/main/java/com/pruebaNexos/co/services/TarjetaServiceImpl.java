package com.pruebaNexos.co.services;


import java.util.NoSuchElementException;
import java.util.Random;
import java.time.YearMonth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaNexos.co.dao.ITarjetaDao;
import com.pruebaNexos.co.entity.Tarjeta;

@Service
public class TarjetaServiceImpl implements ITarjetaService{
	
	@Autowired
	private ITarjetaDao tarjetaDao;

	@Override
	public Tarjeta crearTarjeta(String franquicia, String nombreDelTitular) {
		
		String numeroTarjeta = generarNumeroTarjeta(franquicia);
		YearMonth fechaDeCaducidad = YearMonth.now().plusYears(3);
		Tarjeta tarjeta = new Tarjeta();
		tarjeta.setNumeroTarjeta(numeroTarjeta); 
		tarjeta.setNombreDelTitular(nombreDelTitular);
		tarjeta.setFechaDeCaducidad(fechaDeCaducidad);
		tarjeta.setBalance(0.0);
		tarjeta.setActivada(false);
		tarjeta.setBloqueada(false);
		tarjeta = tarjetaDao.save(tarjeta);
		return tarjeta.tuTarjeta();
	}

	@Override
	public void activacionTarjeta(String numeroTarjeta) {
		Tarjeta tarjeta = tarjetaDao.findByNumeroDeTarjeta(numeroTarjeta);
		if (tarjeta != null) {
			tarjeta.setActivada(true);
			tarjetaDao.save(tarjeta);
		}

	}

	@Override
	public void bloquedoTarjeta(String numeroTarjeta) {

			Tarjeta tarjeta = tarjetaDao.findByNumeroDeTarjeta(numeroTarjeta);
			if(tarjeta != null) {
				tarjeta.setBloqueada(true);
				tarjetaDao.save(tarjeta);
			}


	}

	@Override
	public void desbloqueoTarjeta(String numeroTarjeta) {
			Tarjeta tarjeta = tarjetaDao.findByNumeroDeTarjeta(numeroTarjeta);
			if(tarjeta != null) {
				tarjeta.setBloqueada(false);
				tarjetaDao.save(tarjeta);
			}
		
	}

	@Override
	public String generarNumeroTarjeta(String franquicia) {
		
		StringBuilder numeroTarjeta = new StringBuilder(franquicia);
		Random random = new Random();
		for(int i=0; i < 10; i++){
			numeroTarjeta.append(random.nextInt(10));
		}
		
		return numeroTarjeta.toString();
	}

	@Override
    public Tarjeta obtenerNumerodeTarjeta(String numeroTarjeta) {
        return tarjetaDao.findByNumeroDeTarjeta(numeroTarjeta);
    }

	@Override
	public void actualizarTarjeta(Tarjeta tarjeta) {
		tarjetaDao.save(tarjeta);
		
	}
	
	public Tarjeta save(Tarjeta tarjeta) {
		return tarjetaDao.save(tarjeta);
	}

	@Override
	public Tarjeta findById(long id) {
		return tarjetaDao.findById(id);
	}


}
