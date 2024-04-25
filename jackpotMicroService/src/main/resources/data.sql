DROP TABLE IF EXISTS Client;
CREATE TABLE Client (
                         client_id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255),
                         visits INT,
                         jackpot_amount int
);

INSERT INTO Client (name, visits, jackpot_amount) VALUES
                                                           ('Alice', 3, 15),
                                                           ('Bob',  1, 5),
                                                           ('Charlie',4, 12);