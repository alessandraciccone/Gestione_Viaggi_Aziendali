package alessandraciccone.Gestione_Viaggi_Aziendali.payloads;

import java.util.UUID;

public class DipendentePayload {

    private UUID id;
    private String nome;
    private String cognome;
    private String email;


    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }


}
