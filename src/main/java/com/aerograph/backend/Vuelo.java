package com.aerograph.backend;

import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;
import lombok.Data;
import java.io.Serializable; // <--- NUEVO

@RelationshipProperties
@Data
public class Vuelo implements Serializable { // <--- NUEVO
    @RelationshipId
    private Long id;

    private double precio;
    private int duracion;

    @TargetNode
    private Aeropuerto destino;
}
