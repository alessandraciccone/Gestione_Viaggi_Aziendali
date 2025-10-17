package alessandraciccone.Gestione_Viaggi_Aziendali.services;


import alessandraciccone.Gestione_Viaggi_Aziendali.entities.Viaggio;
import alessandraciccone.Gestione_Viaggi_Aziendali.payloads.ViaggioPayload;
import alessandraciccone.Gestione_Viaggi_Aziendali.repositories.DipendenteRepository;
import alessandraciccone.Gestione_Viaggi_Aziendali.repositories.PrenotazioneRepository;
import alessandraciccone.Gestione_Viaggi_Aziendali.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import static org.springframework.data.util.ClassUtils.ifPresent;

@Service
public class ViaggioService {
    private static final Logger log = Logger.getLogger(ViaggioService.class.getName());
    @Autowired
    private ViaggioRepository viaggioRepository;
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private DipendenteRepository dipendenteRepository;

    //paginazione e find all
    public Page<Viaggio> findAll(int pageNumber, int pageSize, String sortBy) {
        if (pageSize > 10) pageSize = 10;

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
        return viaggioRepository.findAll(pageable);
    }


    //salva viaggio

    public Viaggio save(ViaggioPayload payload) {
        List<Viaggio> esistenti = viaggioRepository.findByPrenotazione_Id(payload.getPrenotazioneID());
        if (!esistenti.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Viaggio già esistente!");
        }


        Viaggio newViaggio = new Viaggio(
                payload.getDestinazione(),
                payload.getDataViaggio(),
                payload.getStatoViaggio()

        );

        Viaggio savedViaggio = viaggioRepository.save(newViaggio);
        log.info(String.format("Il viaggio è stato salvato! ID: %s", savedViaggio.getId()));
        return savedViaggio;
    }
    //cerco viaggio x id

    public Viaggio findById(UUID id){
        return viaggioRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Viaggio non trovato!"));}


    // trova e modifca

    public Viaggio findByIdAndUpdate(UUID id, ViaggioPayload payload) {
        Viaggio found = findById(id);

        if (!found.getDataViaggio().equals(payload.getDataViaggio())) {
            List<Viaggio> duplicati = viaggioRepository.findByDataViaggio(payload.getDataViaggio());
            if (!duplicati.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Viaggio già conseguito!");
            }
        }

        found.setDataViaggio(payload.getDataViaggio());
        found.setDestinazione(payload.getDestinazione());
        found.setStatoViaggio(payload.getStatoViaggio());

        Viaggio modifiedViaggio = viaggioRepository.save(found);
        log.info("Viaggio modificato");
        return modifiedViaggio;
    }
//cancella viaggio

    public void findByIdAndDelete(UUID id){
        Viaggio found=findById(id);
        viaggioRepository.delete(found);
        log.info("viaggio eliminato" );
    }


    }



