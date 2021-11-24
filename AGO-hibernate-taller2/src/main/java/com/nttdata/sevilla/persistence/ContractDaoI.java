package com.nttdata.sevilla.persistence;

import java.util.List;

/**
 * INTERFAZ DAO CONTRACT
 * 
 * @author agadelao
 *
 */
public interface ContractDaoI extends CommonDaoI<Contract>{
	

	/**
	 * Método para buscar contratos por ID
	 * 
	 * @param idClient
	 * @return Contract
	 */
	public List<Contract> searchByClientId(final Long idClient);

	
}
