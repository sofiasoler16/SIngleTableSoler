package com.example.sigleTable.entidades;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Setter
@SuperBuilder

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name ="diferenciador")
public abstract class Persona extends BaseEntidad {

protected String nombre;
protected String apellido;
}
