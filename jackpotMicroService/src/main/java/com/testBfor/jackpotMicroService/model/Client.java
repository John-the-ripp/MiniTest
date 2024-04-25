package com.testBfor.jackpotMicroService.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
public class Client implements Serializable {

    @Id
    @Getter
    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int client_id;

    @Getter
    @Setter
    private String name;

    private int visits=0;

    @Getter
    @Setter
    private int jackpot_amount;



    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public Client() {
    }

    public Client(String name, int visits, int jackpot_amount) {
        this.name = name;
        this.visits = visits;
        this.jackpot_amount = jackpot_amount;

    }



    @Override
    public String toString() {
        return "Client{" +
                "client_id=" + client_id +
                ", name='" + name + '\'' +
                ", visits=" + visits +
                ", jackpot_amount=" + jackpot_amount +
                '}';
    }
}
