/**
 * 
 */
package com.generic.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T extends Object, PK extends Serializable>  extends JpaRepository<T, PK>{

}
