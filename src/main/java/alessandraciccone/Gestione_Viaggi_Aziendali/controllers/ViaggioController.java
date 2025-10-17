package alessandraciccone.Gestione_Viaggi_Aziendali.controllers;


/*

GET http://localhost:3001/viaggio
POST http://localhost:3001/viaggio(+ request body)
GET http://localhost:3001/viaggio/{viaggioid}
PUT http://localhost3001/viaggio/(+ request body)
DELETE http://localhost:3001/viaggio/{viaggioid}
 */

import alessandraciccone.Gestione_Viaggi_Aziendali.entities.Viaggio;
import alessandraciccone.Gestione_Viaggi_Aziendali.payloads.ViaggioPayload;
import alessandraciccone.Gestione_Viaggi_Aziendali.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/viaggio")
public class ViaggioController {
    @Autowired
    private ViaggioService viaggioService;

    //metodo get
    @GetMapping
    public Page<Viaggio> findAll(@RequestParam(defaultValue = "0") int page,

                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(defaultValue = "id")String sortBy){
        return viaggioService.findAll(page, size, sortBy);
    }

    //metodo postù
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Viaggio create(@RequestBody ViaggioPayload payload){
        return viaggioService.save(payload);
    }

    //metodo get id

    @GetMapping("/{id}")
    public Viaggio findById(@PathVariable UUID id){
        return viaggioService.findById(id);
    }

    //metodo put

    @PutMapping("/{id}")
    public Viaggio update(@PathVariable UUID id, @RequestBody ViaggioPayload payload){
        return viaggioService.findByIdAndUpdate(id, payload);
    }

    //metodo delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        viaggioService.findByIdAndDelete(id);
    }
}
