package com.testBfor.jackpotMicroService.Repository;

import com.testBfor.jackpotMicroService.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Integer> {

}
