package alessandraciccone.Gestione_Viaggi_Aziendali.exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message){
        super(message);
    }
}
