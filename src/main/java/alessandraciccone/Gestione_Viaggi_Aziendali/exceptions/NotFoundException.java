package alessandraciccone.Gestione_Viaggi_Aziendali.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException{

    public NotFoundException(UUID id){
        super("Il record con Id" + id +" non è stato trovato");
    }
    public NotFoundException(String message){
        super(message);
    }

}
