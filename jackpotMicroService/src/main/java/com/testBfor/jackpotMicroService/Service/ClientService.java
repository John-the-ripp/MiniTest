package com.testBfor.jackpotMicroService.Service;

import com.testBfor.jackpotMicroService.Repository.ClientRepo;
import com.testBfor.jackpotMicroService.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepo clientRepo;


    public List<Client> findAllClient(){return clientRepo.findAll();}
    public Client addClient(Client clients){
        return clientRepo.save(clients);

    }

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client findClientById(int clientId) {
        return clientRepo.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Client not found"));
    }



    public Client addToJackpot(int clientId, int amount) {
        Client client = clientRepo.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));
        if (amount > 0) {
            client.setJackpot_amount(client.getJackpot_amount() + amount);
            client.setVisits(client.getVisits() + 1);
            clientRepo.save(client);
        } else {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        return client;
    }
    public Optional<String> checkJackpotAvailability(int clientId) {
        Client client = clientRepo.findById(clientId).orElse(null);
        if (client == null) {
            return Optional.empty();
        }
        if (client.getVisits() < 3 && client.getJackpot_amount() < 10) {
            return Optional.of("Jackpot not available: requires at least 3 visits and a minimum of €10 in the jackpot.");
        }
        if (client.getVisits() < 3) {
            return Optional.of("Jackpot not available: requires at least 3 visits.");
        }
        if (client.getJackpot_amount() < 10) {
            return Optional.of("Jackpot not available: requires a minimum of €10 in the jackpot.");
        }
        return Optional.of("Jackpot is available.");
    }







}
