package com.pruebaNexos.co.entity;

import java.io.Serializable;
import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="transaccion")
public class Transaccion implements  Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_transaccion ")
	private long id;
	@Column(name="numero_Tarjeta")
	private String numeroTarjeta;
	@Column(name="monto_de_tarjeta")
	private double montoDeTarjeta;
	@Column(name="marca_de_tiempo")
	private LocalDateTime  marcadeTiempo;
	
	public Transaccion() {
	}
	
	
	
	public Transaccion(long id, String numeroTarjeta, double montoDeTarjeta, LocalDateTime marcadeTiempo) {
		super();
		this.id = id;
		this.numeroTarjeta = numeroTarjeta;
		this.montoDeTarjeta = montoDeTarjeta;
		this.marcadeTiempo = marcadeTiempo;
	}

	public Transaccion tuTransaccion() {
		return new Transaccion(id, numeroTarjeta, montoDeTarjeta ,marcadeTiempo);
	}

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}



	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}



	public double getMontoDeTarjeta() {
		return montoDeTarjeta;
	}



	public void setMontoDeTarjeta(double montoDeTarjeta) {
		this.montoDeTarjeta = montoDeTarjeta;
	}



	public LocalDateTime getMarcadeTiempo() {
		return marcadeTiempo;
	}



	public void setMarcadeTiempo(LocalDateTime marcadeTiempo) {
		this.marcadeTiempo = marcadeTiempo;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
