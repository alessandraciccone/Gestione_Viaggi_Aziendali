package alessandraciccone.Gestione_Viaggi_Aziendali.controllers;

import alessandraciccone.Gestione_Viaggi_Aziendali.entities.Prenotazione;
import alessandraciccone.Gestione_Viaggi_Aziendali.payloads.PrenotazionePayload;
import alessandraciccone.Gestione_Viaggi_Aziendali.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


/*

GET http://localhost:3001/prenotazioni
POST http://localhost:3001/prenotazioni(+ request body)
GET http://localhost:3001/prenotazioni/{prenotazioneid}
PUT http://localhost3001/prenotazioni/(+ request body)
DELETE http://localhost:3001/prenotazioni/{prenotazioniid}
 */
@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping
    public List<Prenotazione> findAll() {
        return prenotazioneService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazione create(@RequestBody PrenotazionePayload payload) {
        return prenotazioneService.save(payload);
    }

    @GetMapping("/{id}")
    public Prenotazione findById(@PathVariable UUID id) {
        return prenotazioneService.findById(id);
    }

    @PutMapping("/{id}")
    public Prenotazione update(@PathVariable UUID id, @RequestBody PrenotazionePayload payload) {
        return prenotazioneService.findByIdAndUpdate(id, payload);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        prenotazioneService.findByIdAndDelete(id);
    }
}