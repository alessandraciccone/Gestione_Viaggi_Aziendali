package alessandraciccone.Gestione_Viaggi_Aziendali.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Prenotazione {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    private LocalDate dataRichiesta;
    private String preferenza;

    @OneToOne(mappedBy = "prenotazione")
    private Viaggio viaggio;

    public Prenotazione(){};
    public Prenotazione( LocalDate dataRichiesta, String preferenza, Viaggio viaggio)  {
        this.dataRichiesta = dataRichiesta;
        this.preferenza = preferenza;
        this.viaggio= viaggio;
    }


    public UUID getId() {
        return id;
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

    public Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", dataRichiesta=" + dataRichiesta +
                ", preferenza='" + preferenza + '\'' +
                ", viaggio=" + viaggio +
                '}';
    }
}


