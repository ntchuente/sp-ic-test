/**
 * 
 */
package com.sprintpay.ic.test.rh;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author SPRINT-PAY-NTW model gestion employee
 */
@Entity
@Table(name = "k_empll")
@EntityListeners(AuditingEntityListener.class)
public class KEmpl implements Serializable {

	public KEmpl() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String firstName;
	private String lastName;
	@NotBlank
	private String email;
	
	

	public KEmpl(Integer id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
	}
	
	public KEmpl(KEmpl entity) {
		
		this.id= entity.getId();
		this.firstName= entity.getFirstName();
		this.lastName= entity.getLastName();
		this.email= entity.getEmail();
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	  @Override
	    public int hashCode() {
	        int hash = 7;
	        hash = 79 * hash + Objects.hashCode(this.id);
	        hash = 79 * hash + Objects.hashCode(this.lastName);
	        hash = 79 * hash + Objects.hashCode(this.firstName);;
	        return hash;
	    }
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final KEmpl other = (KEmpl) obj;
	        if (this.firstName != other.firstName) {
	            return false;
	        }
	        if (!Objects.equals(this.lastName, other.lastName)) {
	            return false;
	        }
	        return Objects.equals(this.id, other.id);
	    }

	 // getters and setters

		@Override
		public String toString() {
			return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
		}

}
