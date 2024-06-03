package com.pruebaNexos.co.services;

import com.pruebaNexos.co.entity.Transaccion;

public interface ITransaccionService {
	
	public Transaccion compra(String numeroTarjeta, double montoDeTarjeta);
	public void pagoTarjeta(String numeroTarjeta, double montoDeTarjeta);
	public Transaccion obtenerTransaccion(long id);
	public void cancelarTransaccion(long id);

}
