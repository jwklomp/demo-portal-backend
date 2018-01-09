package org.jwklomp.webportal.repository;

import java.util.List;

import org.jwklomp.webportal.domain.Client;
import org.jwklomp.webportal.domain.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	List<Client> findByClientStatus(ClientStatus clientStatus);
	
	Client getOneByClientId(String clientId);
	
}
