package alessandraciccone.Gestione_Viaggi_Aziendali.entities;


import jakarta.persistence.*;
import org.hibernate.validator.constraints.UUID;

import java.time.LocalDate;

@Entity
public class Viaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    private String destinazione;
    private LocalDate dataViaggio;
    @Enumerated(EnumType.STRING)
    private StatoViaggio statoViaggio;

    @OneToOne
    private Premnotazione premnotazione;

  public Viaggio(){};

    public Viaggio( String destinazione, LocalDate dataViaggio, StatoViaggio statoViaggio, Premnotazione premnotazione) {

        this.destinazione = destinazione;
        this.dataViaggio = dataViaggio;
        this.statoViaggio = statoViaggio;
        this.premnotazione = premnotazione;
    }

    public UUID getId() {
        return id;
    }


    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public LocalDate getDataViaggio() {
        return dataViaggio;
    }

    public void setDataViaggio(LocalDate dataViaggio) {
        this.dataViaggio = dataViaggio;
    }

    public StatoViaggio getStatoViaggio() {
        return statoViaggio;
    }

    public void setStatoViaggio(StatoViaggio statoViaggio) {
        this.statoViaggio = statoViaggio;
    }

    public Premnotazione getPremnotazione() {
        return premnotazione;
    }

    public void setPremnotazione(Premnotazione premnotazione) {
        this.premnotazione = premnotazione;
    }

    @Override
    public String toString() {
        return "Viaggio{" +
                "id=" + id +
                ", destinazione='" + destinazione + '\'' +
                ", dataViaggio=" + dataViaggio +
                ", statoViaggio=" + statoViaggio +
                ", premnotazione=" + premnotazione +
                '}';
    }
}
