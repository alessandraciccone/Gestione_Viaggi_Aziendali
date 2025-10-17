package alessandraciccone.Gestione_Viaggi_Aziendali.payloads;

import java.time.LocalDate;

public class ErrorsPayload {

    private String messageg;
    private LocalDate timestamp;

    public String getMessageg() {
        return messageg;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public ErrorsPayload(String messageg, LocalDate timestamp) {
        this.messageg = messageg;
        this.timestamp = timestamp;


    }
}
