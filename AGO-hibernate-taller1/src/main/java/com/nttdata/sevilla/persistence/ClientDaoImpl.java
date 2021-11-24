package com.nttdata.sevilla.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * IMPLEMENTACIÓN DAO CLIENT
 * 
 * @author agadelao
 *
 */

public class ClientDaoImpl implements ClientDaoI {

	/** Sesión de conexión con BBDD */
	private Session session;

	/**
	 * Constructor sobrecargado
	 * 
	 * @param session
	 */
	public ClientDaoImpl(Session session) {
		this.session = session;
	}

	@Override
	public Long insert(Client insertClient) {

		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Inserción
		final Long insertClientId = (Long) session.save(insertClient);

		// Commit
		session.getTransaction().commit();

		return insertClientId;
	}

	@Override
	public void update(Client updateClient) {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Inserción
		session.update(updateClient);

		// Commit
		session.getTransaction().commit();

	}

	@Override
	public Client searchById(Long idClient) {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por IP (PK)
		final Client entityResult = session.get(Client.class, idClient);

		return entityResult;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchAll() {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda completa
		final List<Client> entityListResult = session.createQuery("FROM " + Client.class.getName()).list();

		return entityListResult;
	}

	@Override
	public void delete(Client removeClient) {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Inserción
		session.remove(removeClient);

		// Commit
		session.getTransaction().commit();

	}

}
