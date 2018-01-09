package org.jwklomp.webportal.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	private int id;
	private String clientId;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private ClientStatus clientStatus;
	private List<Account> accounts;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
    public ClientStatus getClientStatus() {
		return clientStatus;
	}

	public void setClientStatus(ClientStatus clientStatus) {
		this.clientStatus = clientStatus;
	}

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", clientId=" + clientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthDate=" + birthDate + ", clientStatus=" + clientStatus + ", accounts=" + accounts + "]";
	}
	
	

}
