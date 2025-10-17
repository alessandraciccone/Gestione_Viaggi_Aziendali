package alessandraciccone.Gestione_Viaggi_Aziendali.services;


import alessandraciccone.Gestione_Viaggi_Aziendali.entities.Prenotazione;
import alessandraciccone.Gestione_Viaggi_Aziendali.exceptions.BadRequestException;
import alessandraciccone.Gestione_Viaggi_Aziendali.exceptions.NotFoundException;
import alessandraciccone.Gestione_Viaggi_Aziendali.payloads.PrenotazionePayload;
import alessandraciccone.Gestione_Viaggi_Aziendali.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class PrenotazioneService {
    private static final Logger log = Logger.getLogger(PrenotazioneService.class.getName());

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    //cerca tuttte prenotazioni
    public List<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();
    }

//salva nuova prenotazione


    public Prenotazione save(PrenotazionePayload payload) {
        List<Prenotazione> duplicati = prenotazioneRepository.findByDataRichiesta(payload.getDataRichiesta());
        if (!duplicati.isEmpty()) {
            throw new BadRequestException("prenotazione già registrata");

        }

        Prenotazione nuova = new Prenotazione(
                payload.getDataRichiesta(),
                payload.getPreferenza(),
                null);

        Prenotazione salvata = prenotazioneRepository.save(nuova);
        log.info(String.format("prenotazione salvata! ID:  %s", salvata.getId()));
        return salvata;
    }


    //cerca x id


    public Prenotazione findById(UUID id){
        return prenotazioneRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    //trova e mopdifica

    public Prenotazione findByIdAndUpdate(UUID id, PrenotazionePayload payload){
        Prenotazione found=findById(id);
        if(!found.getDataRichiesta().equals(payload.getDataRichiesta())){
            List<Prenotazione> duplicati= prenotazioneRepository.findByDataRichiesta(payload.getDataRichiesta());
          if(!duplicati.isEmpty()){
              throw  new BadRequestException("prenotazione già esistente!");
          }
        }

        found.setDataRichiesta(payload.getDataRichiesta());
        found.setPreferenza(payload.getPreferenza());
        Prenotazione modificata=prenotazioneRepository.save(found);
        log.info("prenotazione modificata");
        return modificata;
    }

    //cancella prenotazione

    public void findByIdAndDelete(UUID id){
        Prenotazione found= findById(id);
        prenotazioneRepository.delete(found);
        log.info("prenotazione cancellata");
    }
}
