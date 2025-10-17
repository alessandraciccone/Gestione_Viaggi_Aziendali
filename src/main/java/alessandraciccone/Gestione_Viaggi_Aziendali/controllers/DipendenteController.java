package alessandraciccone.Gestione_Viaggi_Aziendali.controllers;

import alessandraciccone.Gestione_Viaggi_Aziendali.entities.Dipendente;
import alessandraciccone.Gestione_Viaggi_Aziendali.payloads.DipendentePayload;
import alessandraciccone.Gestione_Viaggi_Aziendali.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


/*

GET http://localhost:3001/dipendenti
POST http://localhost:3001/dipendenti(+ request body)
GET http://localhost:3001/dipendenti/{vdipendentiid}
PUT http://localhost3001/dipendenti/(+ request body)
DELETE http://localhost:3001/dipendenti/{dipendentiid}
 */


    @RestController
    @RequestMapping("/dipendenti")
    public class DipendenteController {

        @Autowired
        private DipendenteService dipendenteService;


        //metodo get
        @GetMapping
        public List<Dipendente> findAll() {
            return dipendenteService.findAll();
        }


        //metodo post
        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Dipendente create(@RequestBody DipendentePayload payload) {
            return dipendenteService.save(payload);
        }
//metodo get
        @GetMapping("/{id}")
        public Dipendente findById(@PathVariable UUID id) {
            return dipendenteService.findById(id);
        }
//metodo put
        @PutMapping("/{id}")
        public Dipendente update(@PathVariable UUID id, @RequestBody DipendentePayload payload) {
            return dipendenteService.findByIdAndUpdate(id, payload);
        }


        //metodo delete
        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void delete(@PathVariable UUID id) {
            dipendenteService.findByIdAndDelete(id);
        }
    }

