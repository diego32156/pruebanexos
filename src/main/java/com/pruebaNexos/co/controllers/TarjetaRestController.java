package com.pruebaNexos.co.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.pruebaNexos.co.entity.Tarjeta;
import com.pruebaNexos.co.services.ITarjetaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tarjeta")
public class TarjetaRestController {

	@Autowired
	private ITarjetaService tarjetaService;

	@PostMapping("/crear")
	public Tarjeta crearTarjeta(@Valid @RequestBody Tarjeta tarjeta) {

		return tarjetaService.crearTarjeta(tarjeta.getNumeroTarjeta(), tarjeta.getNombreDelTitular());

	}
	
	@PutMapping("/{numeroTarjeta}/activar")
    public ResponseEntity<Void> activacionTarjeta ( @PathVariable String numeroTarjeta){
		
		tarjetaService.activacionTarjeta(numeroTarjeta);
		return ResponseEntity.ok().build();
		
	}
	
	@PutMapping("/{numeroTarjeta}/bloquear")
    public ResponseEntity<Void> bloquedoTarjeta ( @PathVariable String numeroTarjeta){
		
		tarjetaService.bloquedoTarjeta(numeroTarjeta);
		return ResponseEntity.ok().build();
		
	}
	
	@PutMapping("/{numeroTarjeta}/desbloquear")
    public ResponseEntity<Void> desbloqueoTarjeta ( @PathVariable String numeroTarjeta){
		
		tarjetaService.bloquedoTarjeta(numeroTarjeta);
		return ResponseEntity.ok().build();
		
	}

}
