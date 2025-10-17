package alessandraciccone.Gestione_Viaggi_Aziendali.repositories;



import alessandraciccone.Gestione_Viaggi_Aziendali.entities.StatoViaggio;
import alessandraciccone.Gestione_Viaggi_Aziendali.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ViaggioRepository extends JpaRepository<Viaggio, UUID> {

List<Viaggio> findByDestinazione(String destinazione);
List <Viaggio> findByDataViaggio(LocalDate data);
List<Viaggio> findByStatoViaggio(StatoViaggio statoViaggio);
List<Viaggio> findByPrenotazione_Id( UUID prenotazioneId);
List<Viaggio> findByDipendente_Id(UUID dipendenteID);


}
