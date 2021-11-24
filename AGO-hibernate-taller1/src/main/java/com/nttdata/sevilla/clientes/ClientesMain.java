package com.nttdata.sevilla.clientes;

import java.util.Date;

import org.hibernate.Session;

import com.nttdata.sevilla.persistence.Client;
import com.nttdata.sevilla.services.ClientServiceI;
import com.nttdata.sevilla.services.ClientServiceImpl;


/**
 * CLIENTES
 * 
 * @author agadelao
 *
 */
public class ClientesMain {

	/**
	 * Clase principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

// Apertura de sesión

		final Session session = ClientsSessionUtil.getSessionFactory().openSession();

		// Inicialización de servicios

		final ClientServiceI clientService = new ClientServiceImpl(session);

		final Client client1 = new Client();
		client1.setNameClient("Alma");
		client1.setSurname1Client("García");
		client1.setSurname2Client("Obra");
		client1.setDniClient("22D");

		clientService.insertClient(client1);

		// Cierre de sesión
		session.close();

	}
}
