package it.epicode.w6Project.model;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


    @Data
    public class DispositivoRequest {

        @NotNull(message = "Tipo obbligatorio")
        private Tipo tipo;

        @NotNull(message = "Status obbligatorio")
        private StatoDispositivo statoDispositivo;

        private int id;

        private Dipendente dipendente;
}
