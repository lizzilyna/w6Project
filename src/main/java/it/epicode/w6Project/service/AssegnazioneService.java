package it.epicode.w6Project.service;

import it.epicode.w6Project.exception.NotFoundException;
import it.epicode.w6Project.model.Dipendente;
import it.epicode.w6Project.model.Dispositivo;
import it.epicode.w6Project.model.StatoDispositivo;
import it.epicode.w6Project.repository.DipendenteRepository;
import it.epicode.w6Project.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssegnazioneService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public void assegnaDispositivoADipendente(int id, Dispositivo dispositivo) {

        Dipendente dipendente = dipendenteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Dipendente con ID " + id + " non trovato"));


        Dispositivo dispositivoDaAssegnare = dispositivoRepository.findById(dispositivo.getId())
                .orElseThrow(() -> new NotFoundException("Dispositivo con ID " + dispositivo.getId() + " non trovato"));


        if (dispositivoDaAssegnare.getStatoDispositivo() != StatoDispositivo.DISPONIBILE) {
            throw new IllegalArgumentException("Il dispositivo non è disponibile per l'assegnazione.");
        }


        dispositivoDaAssegnare.setDipendente(dipendente);
        dispositivoDaAssegnare.setStatoDispositivo(StatoDispositivo.ASSEGNATO);


        dispositivoRepository.save(dispositivoDaAssegnare);
    }
}