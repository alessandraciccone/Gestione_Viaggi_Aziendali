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
    private Prenotazione prenotazione;
    @OneToOne(mappedBy = "viaggio")
    private Dipendente dipendente;

  public Viaggio(){};

   public Viaggio( String destinazione, LocalDate dataViaggio, StatoViaggio statoViaggio, Prenotazione prenotazione, Dipendente dipendente) {

        this.destinazione = destinazione;
        this.dataViaggio = dataViaggio;
        this.statoViaggio = statoViaggio;
        this.prenotazione = prenotazione;
        this.dipendente=dipendente;
    }

    public Viaggio(String destinazione, LocalDate dataViaggio, StatoViaggio statoViaggio) {
    }

    //public Viaggio(String destinazione, LocalDate dataViaggio, StatoViaggio statoViaggio, java.util.UUID prenotazioneID, java.util.UUID dipendenteId) {
    //}


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

    public Prenotazione getPrenotazione() {
        return prenotazione;
    }

    public void setPrenotazione(Prenotazione prenotazione) {
        this.prenotazione = prenotazione;
    }


    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    @Override
    public String toString() {
        return "Viaggio{" +
                "id=" + id +
                ", destinazione='" + destinazione + '\'' +
                ", dataViaggio=" + dataViaggio +
                ", statoViaggio=" + statoViaggio +
                ", prenotazione=" + prenotazione +
                ", dipendente=" + dipendente +
                '}';
    }
}
