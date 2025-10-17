package alessandraciccone.Gestione_Viaggi_Aziendali.payloads;

import java.time.LocalDate;

public class ErrorsPayload {

    private String message;
    private LocalDate timestamp;

    public String getMessage() {
        return message;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public ErrorsPayload(String message, LocalDate timestamp) {
        this.message = message;
        this.timestamp = timestamp;


    }
}
