/**
 * 
 */
package com.generic.service;

import java.io.Serializable;

import com.generic.repository.BaseRepository;

/**
 * @author SPRINT-PAY-NTW
 *
 */
public interface BaseService<T extends Object, PK extends Serializable> {
	
	/**
	 * Methode d'obtention du Repository
	 * @return	Repo
	 */
	public BaseRepository<T, PK> getDao();
        
    
	
	/**
	 * Methode generique d'enregistrement d'une entite
	 * @param entity	Entite a enregistrer
	 * @return	Entite enregistree
	 */
	public T save(T entity);


}
