/**
 * 
 */
package com.generic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author SPRINT-PAY-NTW
 *
 */
@Entity
public abstract class BaseEntity {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String value;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
		 public abstract int hashCode() ;
		 
		 public abstract boolean equals(Object obj) ;
	 
}
