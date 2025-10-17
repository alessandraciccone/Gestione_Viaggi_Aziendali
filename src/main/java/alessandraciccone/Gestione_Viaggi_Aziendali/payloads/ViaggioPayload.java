package alessandraciccone.Gestione_Viaggi_Aziendali.payloads;

import alessandraciccone.Gestione_Viaggi_Aziendali.entities.StatoViaggio;

import java.time.LocalDate;
import java.util.UUID;

public class ViaggioPayload {

    private UUID id;
    private String destinazione;
    private LocalDate dataViaggio;
    private StatoViaggio statoViaggio;
    private UUID dipendenteId;
    private UUID prenotazioneID;


    public String getDestinazione() {
        return destinazione;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDataViaggio() {
        return dataViaggio;
    }

    public StatoViaggio getStatoViaggio() {
        return statoViaggio;
    }

    public UUID getDipendenteId() {
        return dipendenteId;
    }

    public UUID getPrenotazioneID() {
        return prenotazioneID;
    }
}
