package com.aerograph.backend;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import lombok.Data;
import java.io.Serializable; // <--- NUEVO
import java.util.ArrayList;
import java.util.List;

@Node
@Data
public class Aeropuerto implements Serializable { // <--- NUEVO
    @Id
    private String iata;
    private String nombre;
    
    @Relationship(type = "VUELA_A", direction = Relationship.Direction.OUTGOING)
    private List<Vuelo> destinos = new ArrayList<>();

    public Aeropuerto() {}

    public Aeropuerto(String iata, String nombre) {
        this.iata = iata;
        this.nombre = nombre;
    }

    public void agregarVuelo(Aeropuerto destino, double precio, int duracion) {
        Vuelo v = new Vuelo();
        v.setDestino(destino);
        v.setPrecio(precio);
        v.setDuracion(duracion);
        this.destinos.add(v);
    }
}
