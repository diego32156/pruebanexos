package com.pruebaNexos.co.services;




import com.pruebaNexos.co.entity.Tarjeta;



public interface ITarjetaService {
		
	public Tarjeta crearTarjeta (String franquica, String nombreDelTitular);
	public void activacionTarjeta(String numeroTarjeta);
	public void bloquedoTarjeta(String numeroTarjeta);
	public void desbloqueoTarjeta(String numeroTarjeta);
	public String generarNumeroTarjeta(long numeroTarejeta);
	public Tarjeta obtenerNumerodeTarjeta(String numeroTarjeta);
	public void actualizarTarjeta(Tarjeta tarjeta);
	public Tarjeta save(Tarjeta tarjeta);
	public Tarjeta   findById(long id);

}
