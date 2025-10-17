package alessandraciccone.Gestione_Viaggi_Aziendali.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Premnotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    private LocalDate dataRichiesta;
    private String preferenza;


    public Premnotazione( LocalDate dataRichiesta, String preferenza) {
        this.dataRichiesta = dataRichiesta;
        this.preferenza = preferenza;
    }



    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(LocalDate dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public String getPreferenza() {
        return preferenza;
    }

    public void setPreferenza(String preferenza) {
        this.preferenza = preferenza;
    }

    @Override
    public String toString() {
        return "Premnotazione{" +
                "id=" + id +
                ", dataRichiesta=" + dataRichiesta +
                ", preferenza='" + preferenza + '\'' +
                '}';
    }
}


