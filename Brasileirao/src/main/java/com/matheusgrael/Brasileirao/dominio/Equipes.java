package com.matheusgrael.Brasileirao.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipes {

    private UUID id;
    private String nome;
    private LocalDate anoFundacao;
    private String Estado;
    private int titulosNacionais;
    private int titulosInternacionais;
    private boolean serieA;

    public int anosHistoria() {
        return (LocalDate.now().getYear() - anoFundacao.getYear());
    }


}
