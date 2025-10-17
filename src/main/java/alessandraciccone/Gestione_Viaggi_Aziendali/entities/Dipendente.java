package alessandraciccone.Gestione_Viaggi_Aziendali.entities;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Dipendente {


    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
  private String nome;
  private String cognome;
  private String email;

  @OneToOne
    private Viaggio viaggio;


  public Dipendente(){};

    public Dipendente( String nome, String cognome, String email, Viaggio viaggio) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.viaggio = viaggio;
    }

    public UUID getId() {
        return id;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", viaggio=" + viaggio +
                '}';
    }
}
