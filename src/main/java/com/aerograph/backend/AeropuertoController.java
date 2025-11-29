package com.aerograph.backend;

import org.springframework.web.bind.annotation.*;
import org.springframework.cache.annotation.Cacheable; // <-- Importamos Redis
import java.util.List;

@RestController
@RequestMapping("/api/vuelos")
public class AeropuertoController {

    private final AeropuertoRepository repositorio;

    public AeropuertoController(AeropuertoRepository repositorio) {
        this.repositorio = repositorio;
    }

    // --- GUARDAR DATOS ---

    @PostMapping("/aeropuerto")
    public Aeropuerto crearAeropuerto(@RequestBody Aeropuerto a) {
        return repositorio.save(a);
    }

    @PostMapping("/ruta")
    public Aeropuerto crearRuta(@RequestParam String origen, 
                                @RequestParam String destino,
                                @RequestParam double precio,
                                @RequestParam int duracion) {
        
        Aeropuerto aOrigen = repositorio.findById(origen).orElseThrow();
        Aeropuerto aDestino = repositorio.findById(destino).orElseThrow();
        aOrigen.agregarVuelo(aDestino, precio, duracion);
        return repositorio.save(aOrigen);
    }

    @GetMapping
    public List<Aeropuerto> listarTodos() {
        return repositorio.findAll();
    }

    // --- LA MAGIA (Cerebro + Memoria) ---

    // 1. Busca el camino más corto en Neo4j
    // 2. @Cacheable: Guarda el resultado en Redis. 
    //    Si vuelves a preguntar lo mismo, NO ejecuta el código, responde desde RAM.
    @GetMapping("/camino")
    @Cacheable(value = "rutas", key = "#origen + '-' + #destino") 
    public List<Aeropuerto> buscarCamino(@RequestParam String origen, @RequestParam String destino) {
        System.out.println("⚠️ Consultando a Neo4j (Lento)..."); 
        return repositorio.encontrarRuta(origen, destino);
    }
}
