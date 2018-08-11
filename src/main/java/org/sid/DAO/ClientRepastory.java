package org.sid.DAO;

import org.sid.entites.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepastory extends JpaRepository<Client, Long> {

}
