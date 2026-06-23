package org.HEI.kdot.modele;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@Data
public abstract  class Human {
    private final int id;
    private final String name;
    private final String surname;
    private Sex sex;
    private  final LocalDate birthDate;
}
