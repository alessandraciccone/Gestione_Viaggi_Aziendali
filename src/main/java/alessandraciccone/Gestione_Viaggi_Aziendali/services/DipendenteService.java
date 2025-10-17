package alessandraciccone.Gestione_Viaggi_Aziendali.services;


import alessandraciccone.Gestione_Viaggi_Aziendali.entities.Dipendente;
import alessandraciccone.Gestione_Viaggi_Aziendali.exceptions.BadRequestException;
import alessandraciccone.Gestione_Viaggi_Aziendali.exceptions.NotFoundException;
import alessandraciccone.Gestione_Viaggi_Aziendali.payloads.DipendentePayload;
import alessandraciccone.Gestione_Viaggi_Aziendali.repositories.DipendenteRepository;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class DipendenteService {

    private static final Logger Log= Logger.getLogger(DipendenteService.class.getName());

    @Autowired
    private DipendenteRepository dipendenteRepository;
    //trova tutti
    public List<Dipendente> findAll(){
        return dipendenteRepository.findAll();
    }

    //salva un nuovo dipendente

    public Dipendente save(DipendentePayload payload){
        List<Dipendente> duplicati= dipendenteRepository.findByEmail(payload.getEmail());

        if(!duplicati.isEmpty()){
            throw new BadRequestException("Dipendente già registrato con questa email");

        }

        Dipendente nuovo= new Dipendente(
                payload.getNome(),
                payload.getCognome(),
                payload.getEmail(),
                null
        );

        Dipendente salvato= dipendenteRepository.save(nuovo);
        Log.info(String.format("Dipendente salvato con id: %s", salvato.getId()));
        return salvato;
    }

    //cerca x id
    public Dipendente findById(UUID id){
        return dipendenteRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    public Dipendente fimdByIdAndUpdate(UUID id, DipendentePayload payload){
    Dipendente found=findById(id);
    if(!found.getEmail().equals(payload.getEmail())){
        List<Dipendente> duplicati= dipendenteRepository.findByEmail(payload.getEmail());
        if(!duplicati.isEmpty()){
            throw new BadRequestException("Email già in uso");
        }
    }

    found.setNome(payload.getNome());
    found.setCognome(payload.getCognome());
    found.setEmail(payload.getEmail());
    Dipendente modificato=dipendenteRepository.save(found);
    Log.info("dipendente modificato");
    return modificato;
    }

    //cancella dipendente

    public void findByIdAndDelete(UUID id){
        Dipendente found=findById(id);
        dipendenteRepository.delete(found);
        Log.info("Dipendente eliminato");
    }
}
