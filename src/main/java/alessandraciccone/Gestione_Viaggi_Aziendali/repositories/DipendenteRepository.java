package alessandraciccone.Gestione_Viaggi_Aziendali.repositories;

import alessandraciccone.Gestione_Viaggi_Aziendali.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, UUID> {

     List<Dipendente> findByNome (String nome);
    List<Dipendente> findByCognome(String cognome);
    List<Dipendente> findByEmail(String email);
    List<Dipendente> findByViaggio_Id(UUID viaggioID);
}
