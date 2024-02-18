package it.epicode.w6Project.controller;


import it.epicode.w6Project.exception.NotFoundException;
import it.epicode.w6Project.model.Dispositivo;
import it.epicode.w6Project.service.AssegnazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assegnazione")
public class AssegnazioneController {

    @Autowired
    private AssegnazioneService assegnazioneService;

    @PostMapping("/dispositivo/{idDipendente}")
    public ResponseEntity<String> assegnaDispositivoADipendente(@PathVariable int idDipendente, @RequestBody Dispositivo dispositivo) {
        try {
            assegnazioneService.assegnaDispositivoADipendente(idDipendente, dispositivo);
            return ResponseEntity.ok("Dispositivo assegnato con successo al dipendente con ID " + idDipendente);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Si è verificato un errore durante l'assegnazione del dispositivo.");
        }
    }
}