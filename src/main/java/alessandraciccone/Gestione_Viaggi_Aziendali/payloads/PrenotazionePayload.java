package alessandraciccone.Gestione_Viaggi_Aziendali.payloads;

import java.time.LocalDate;
import java.util.UUID;

public class PrenotazionePayload {

 private UUID id;
private LocalDate dataRichiesta;
private String preferenza;
private UUID viaggioId;

    public LocalDate getDataRichiesta() {
        return dataRichiesta;
    }

    public UUID getId() {
        return id;
    }

    public String getPreferenza() {
        return preferenza;
    }

    public UUID getViaggioId() {
        return viaggioId;
    }
}
