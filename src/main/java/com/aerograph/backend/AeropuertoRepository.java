package com.aerograph.backend;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import java.util.List;

public interface AeropuertoRepository extends Neo4jRepository<Aeropuerto, String> {

    // Algoritmo Dijkstra nativo de Neo4j (Ruta más barata)
    // Busca el camino entre origen y destino sumando los precios
    @Query("MATCH path = shortestPath((start:Aeropuerto {iata: $origen})-[:VUELA_A*]->(end:Aeropuerto {iata: $destino})) " +
           "RETURN path")
    List<Aeropuerto> encontrarRuta(String origen, String destino);
}