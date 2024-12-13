package com.matheusgrael.Brasileirao.dominio;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {

    private UUID id;
    @NotBlank(message = "Nome é um requisito necessário")
    @Size(max = 30)
    private String nome;
    @NotNull(message = "Ano de fundação é um requisito necessário")
    @Past(message = "A data deve ser no passado")
    private LocalDate anoFundacao;
    @NotBlank(message = "Estado é um requisito necessário")
    private String estado;
    @Min(value = 0, message = "O número deve ser >= 0")
    private int titulosNacionais;
    @Min(value = 0, message = "O número deve ser >= 0")
    private int titulosInternacionais;
    private boolean serieA;


    public int anosHistoria() {
        return (LocalDate.now().getYear() - anoFundacao.getYear());
    }

    public boolean pertenceAoEstado(String uf) {
        return this.estado.equalsIgnoreCase(uf);
    }

    public boolean isDaSerieA() {
        return this.serieA;
    }
}
