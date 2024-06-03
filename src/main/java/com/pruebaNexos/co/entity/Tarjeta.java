package com.pruebaNexos.co.entity;

import java.io.Serializable;
import java.time.YearMonth;

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
@Table(name="tarjeta")
public class Tarjeta implements  Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tarjeta")
	private long id;
	@Column(unique = true, name="numero_Tarjeta")
	private String numeroTarjeta;
	@Column(name="nombre_del_titular")
	private String nombreDelTitular;
	@Column(name="fecha_de_caducidad")
	private YearMonth fechaDeCaducidad;
	@Column(name="balance")
	private double balance;
	@Column(name="activada")
	private boolean activada;
	@Column(name="bloqueada")
	private boolean bloqueada;
	@Column(name="franquicia")
	private String franquicia;
	
	public Tarjeta() {}
	
    public Tarjeta (String numeroTarjeta, String nombreDelTitular, YearMonth fechaDeCaducidad, double balance, boolean activada, boolean bloqueada, String franquicia) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombreDelTitular = nombreDelTitular;
        this.fechaDeCaducidad = fechaDeCaducidad;
        this.balance = balance;
        this.activada = activada;
        this.bloqueada = bloqueada;
        this.franquicia = franquicia;
    }  
    

	public Tarjeta tuTarjeta() {
		return new Tarjeta (numeroTarjeta, nombreDelTitular,fechaDeCaducidad, balance, activada, bloqueada, franquicia);
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


	public String getNombreDelTitular() {
		return nombreDelTitular;
	}



	public void setNombreDelTitular(String nombreDelTitular) {
		this.nombreDelTitular = nombreDelTitular;
	}



	public YearMonth getFechaDeCaducidad() {
		return fechaDeCaducidad;
	}



	public void setFechaDeCaducidad(YearMonth fechaDeCaducidad) {
		this.fechaDeCaducidad = fechaDeCaducidad;
	}


	public double getBalance() {
		return balance;
	}




	public void setBalance(double balance) {
		this.balance = balance;
	}




	public boolean isActivada() {
		return activada;
	}




	public void setActivada(boolean activada) {
		this.activada = activada;
	}




	public boolean isBloqueada() {
		return bloqueada;
	}




	public void setBloqueada(boolean bloqueada) {
		this.bloqueada = bloqueada;
	}




	public String getFranquicia() {
		return franquicia;
	}




	public void setFranquica(String franquica) {
		this.franquicia = franquica;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

}
