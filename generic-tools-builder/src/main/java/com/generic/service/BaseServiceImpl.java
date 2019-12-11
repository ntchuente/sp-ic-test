/**
 * 
 */
package com.generic.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generic.repository.BaseRepository;

/**
 * @author SPRINT-PAY-NTW
 *
 */
@Service
public abstract class BaseServiceImpl<T extends Object, PK extends Serializable> implements BaseService<T, PK> {

	/**
	 * Methode d'obtention du Repository d'une entité
	 * 
	 * @return Repo
	 */
	@Autowired
	public abstract BaseRepository<T, PK> getDao();

	/**
	 * Methode generique d'enregistrement d'une entite
	 * 
	 * @param entity Entite a enregistrer
	 * @return Entite enregistree
	 */
	public T save(T entity) {
		// Operation de pré-persistence
		this.processBeforeSave(entity);
		// Enregismetrement en base de données
		getDao().save(entity);
		// Operation de post-persistence
		processAfterSave(entity);
		// return l'object entity
		return entity;

	}

	/**
	 * Methode vidage du contexte de persistence en BD
	 */
	public void flush() {
		getDao().flush();
	}

	/**
	 * Bloc de code à executer avant l'insertion en base de données
	 * 
	 * @param entity
	 */
	@SuppressWarnings("empty-statement")
	public void processBeforeSave(T entity) {
		;
	}

	/**
	 * Bloc de code à executer apres l'insertion en base de données
	 * 
	 * @param entity
	 */
	@SuppressWarnings("empty-statement")
	public void processAfterSave(T entity) {
		;
	}


}
