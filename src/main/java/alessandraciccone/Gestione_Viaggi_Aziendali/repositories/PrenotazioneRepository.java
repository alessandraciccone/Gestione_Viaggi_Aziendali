package alessandraciccone.Gestione_Viaggi_Aziendali.repositories;

import alessandraciccone.Gestione_Viaggi_Aziendali.entities.Prenotazione;
import alessandraciccone.Gestione_Viaggi_Aziendali.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface PrenotazioneRepository extends JpaRepository <Prenotazione, UUID>{

    List<Prenotazione> findByDataRichiesta(LocalDate data);

List<Prenotazione> findByPreferenza(String preferenza);
List<Prenotazione> findByViaggio_Id(UUID idViaggio);
}
