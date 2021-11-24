package com.nttdata.sevilla.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * IMPLEMENTACIÓN DAO CLIENT
 * 
 * @author agadelao
 *
 */

public class ClientDaoImpl extends CommonDaoImpl<Client> implements ClientDaoI {

	/** Sesión de conexión con BBDD */
	private Session session;
	
	/**
	 * Constructor sobrecargado
	 * 
	 * @param session
	 */
	public ClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	@Override
	public Client searchByNameAndSurname(String nameClient, String surname1Client, String surname2Client) {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		// Buscar contratos del cliente
		final Client clientResult = (Client) session.createQuery("FROM Client WHERE nameClient ='"+ nameClient + "' AND surname1Client='" + surname1Client + "' AND surname2Client= '" + surname2Client + "'");
	
		return clientResult;
	}





}
