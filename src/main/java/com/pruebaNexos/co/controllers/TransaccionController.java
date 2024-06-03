package com.pruebaNexos.co.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaNexos.co.entity.Transaccion;
import com.pruebaNexos.co.services.ITransaccionService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/transaccion")
public class TransaccionController {
	
	@Autowired
	private ITransaccionService transaccionSerive;
	
    @GetMapping("/{id}")
    public Transaccion obtenerTransaccion(@PathVariable  Long id) {
        return transaccionSerive.obtenerTransaccion(id);
    }
    
    @PostMapping("/compra")
    public Transaccion compra(@Valid @RequestBody Transaccion transaccion) {
    	return transaccionSerive.compra(transaccion.getNumeroTarjeta(), transaccion.getMontoDeTarjeta());
    }
    
    @PostMapping("/pago")
    public ResponseEntity<Void> pagoTarjeta(@Valid @RequestBody Transaccion transaccion) {
    	transaccionSerive.pagoTarjeta(transaccion.getNumeroTarjeta(), transaccion.getMontoDeTarjeta());
        return ResponseEntity.ok().build();
    }
    
	@DeleteMapping("{id}")
	public  ResponseEntity<?> delete (@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			transaccionSerive.cancelarTransaccion(id);
		
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la consulta en la base de datos");
			response.put("mensaje", e.getMessage().concat(" : ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);		
		}
		
		response.put("mensaje", "El Cliente eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		
	}

}
