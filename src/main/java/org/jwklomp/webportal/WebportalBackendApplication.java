package org.jwklomp.webportal;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.jwklomp.webportal.domain.Account;
import org.jwklomp.webportal.domain.AccountStatus;
import org.jwklomp.webportal.domain.Client;
import org.jwklomp.webportal.domain.ClientStatus;
import org.jwklomp.webportal.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebportalBackendApplication implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(WebportalBackendApplication.class);

	@Autowired
	private ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebportalBackendApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {

		//createData();

		List<Client> allActiveClients = clientRepository.findByClientStatus(ClientStatus.ACTIVE);
		List<Client> allBlockedClients = clientRepository.findByClientStatus(ClientStatus.BLOCKED);
		List<Client> allRetiredClients = clientRepository.findByClientStatus(ClientStatus.RETIRED);

		LOG.info("number of active clients: " + allActiveClients.size());
		LOG.info("number of blocked clients: " + allBlockedClients.size());
		LOG.info("number of retired clients: " + allRetiredClients.size());

	}

	private void createData() {
		Client client1 = new Client();
		client1.setFirstName("Poe");
		client1.setLastName("Dameron");
		client1.setClientId("pda00001");
		client1.setBirthDate(new Date());
		client1.setClientStatus(ClientStatus.ACTIVE);

		List<Account> accounts1 = new LinkedList<>();
		IntStream.rangeClosed(1, 3).forEach(number -> {
			accounts1.add(createAccount(client1, number));
		});

		client1.setAccounts(accounts1);

		Client client2 = new Client();
		client2.setFirstName("Finn");
		client2.setLastName("FN-2187");
		client2.setClientId("ffn00002");
		client2.setBirthDate(new Date());
		client2.setClientStatus(ClientStatus.ACTIVE);

		List<Account> accounts2 = new LinkedList<>();
		IntStream.rangeClosed(4, 6).forEach(number -> {
			accounts2.add(createAccount(client2, number));
		});

		client2.setAccounts(accounts2);

		Client client3 = new Client();
		client3.setFirstName("Han");
		client3.setLastName("Solo");
		client3.setClientId("hso00003");
		client3.setBirthDate(new Date());
		client3.setClientStatus(ClientStatus.BLOCKED);

		List<Account> accounts3 = new LinkedList<>();
		IntStream.rangeClosed(7, 9).forEach(number -> {
			accounts3.add(createAccount(client3, number));
		});

		client3.setAccounts(accounts3);

		clientRepository.save(client1);

		clientRepository.save(client2);

		clientRepository.save(client3);
	}

	private Account createAccount(Client client, int number) {
		Account account = new Account();

		account.setAccountNumber(12345678 + number);
		account.setAmount(new BigDecimal((12345678 + number) * 2.0f));
		if (client.getFirstName() == "Han") {
			account.setAccountStatus(AccountStatus.CLOSED);
		} else {
			account.setAccountStatus(AccountStatus.OPEN);
		}
		account.setClient(client);

		return account;
	}
}
