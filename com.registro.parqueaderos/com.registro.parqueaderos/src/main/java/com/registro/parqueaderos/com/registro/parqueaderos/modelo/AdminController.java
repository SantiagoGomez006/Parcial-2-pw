package com.registro.parqueaderos.com.registro.parqueaderos.modelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private Vehiculo vehiculoService;

    @PostMapping("/vehiculos")
    public ResponseEntity<?> registrarVehiculo(@RequestBody Vehiculo vehiculo) {
        vehiculoService.registrarVehiculo(vehiculo);
        return ResponseEntity.ok("Vehículo registrado");
    }

    @PutMapping("/vehiculos/{placa}")
    public ResponseEntity<?> actualizarVehiculo(@PathVariable String placa, @RequestBody Vehiculo vehiculo) {
        vehiculoService.actualizarVehiculo(placa, vehiculo);
        return ResponseEntity.ok("Vehículo actualizado");
    }

    @DeleteMapping("/vehiculos/{placa}")
    public ResponseEntity<?> eliminarVehiculo(@PathVariable String placa) {
        vehiculoService.eliminarVehiculo(placa);
        return ResponseEntity.ok("Vehículo eliminado");
    }

    @GetMapping("/vehiculos")
    public List<Vehiculo> listarVehiculos() {
        return vehiculoService.obtenerTodosVehiculos();
    }
}
