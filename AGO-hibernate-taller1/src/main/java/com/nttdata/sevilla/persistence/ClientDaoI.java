package com.nttdata.sevilla.persistence;

import java.util.List;

/**
 * INTERFAZ DAO CLIENT
 * 
 * @author agadelao
 *
 */
public interface ClientDaoI {

	/**
	 * Método para insertar clientes
	 * 
	 * @param insertClient
	 * @return Long
	 */
	public Long insert(final Client insertClient);

	/**
	 * Método para actualizar un cliente
	 * 
	 * @param updateClient
	 * @return Client
	 */
	public void update(final Client updateClient);

	/**
	 * Método para buscar clientes por ID
	 * 
	 * @param idClient
	 * @return Client
	 */
	public Client searchById(final Long idClient);

	/**
	 * Método para buscar clientes por nombre y apellidos
	 * 
	 * @param nameClient
	 * @param surname1Client
	 * @param surname2Client
	 * @return Client
	 */
	public Client searchByNameAndSurname(final String nameClient, final String surname1Client,
			final String surname2Client);

	/**
	 * Método para buscar todos los clientes
	 * 
	 * @return List<Client>
	 */
	public List<Client> searchAll();

	/**
	 * Método para eliminar clientes
	 * 
	 * @param removeClient
	 */
	public void delete(final Client removeClient);

}
