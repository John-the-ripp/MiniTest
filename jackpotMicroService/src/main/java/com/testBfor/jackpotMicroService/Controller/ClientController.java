package com.testBfor.jackpotMicroService.Controller;

import com.testBfor.jackpotMicroService.Service.ClientService;
import com.testBfor.jackpotMicroService.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;


    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients = clientService.findAllClient();
        return new ResponseEntity<>(clients, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        Client newClient = clientService.addClient(client);
        return  new ResponseEntity<>(newClient,HttpStatus.CREATED);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Client> findClientById(@PathVariable("id") int id){
        Client client = clientService.findClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    // i have tested the addToJackpot http://localhost:8080/client/add-to-jackpot/1?amount=20 and it did increase same as all the other request
    @PostMapping("/add-to-jackpot/{id}")
    public ResponseEntity<?> addToJackpot(@PathVariable("id") int clientId, @RequestParam int amount) {
        if (amount <= 0) {
            return ResponseEntity.badRequest().body("Amount must be greater than 0.");
        }
        try {
            Client client = clientService.addToJackpot(clientId, amount);
            return ResponseEntity.ok(client);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
    }

    @GetMapping("/checkAvailability/{id}")
    public ResponseEntity<String> checkJackpotAvailability(@PathVariable("id") int clientId) {
        Optional<String> result = clientService.checkJackpotAvailability(clientId);
        if (!result.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        return ResponseEntity.ok(result.get());
    }




}
