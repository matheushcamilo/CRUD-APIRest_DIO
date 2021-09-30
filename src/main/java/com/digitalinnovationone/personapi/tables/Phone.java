package com.digitalinnovationone.personapi.tables;


import com.digitalinnovationone.personapi.enums.PhoneType;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Entidade de Banco de Dados
@Entity
//@Data insere Getters e Setter
@Data
@Builder
//Os dois abaixo inserem construtores
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    //PK gerada automaticamente, seguindo estratégia de auto incremento unitário
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    //Tipo de campo NOT NULL
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;
}
