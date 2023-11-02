package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "erreur")
public class Erreur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int ligne;
	private String contenu;
	private String erreurStackTrace;
	
	public Erreur() {}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the ligne
	 */
	public int getLigne() {
		return ligne;
	}

	/**
	 * @param ligne the ligne to set
	 */
	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	/**
	 * @return the contenu
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * @param contenu the contenu to set
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	/**
	 * @return the erreurStackTrace
	 */
	public String getErreurStackTrace() {
		return erreurStackTrace;
	}

	/**
	 * @param erreurStackTrace the erreurStackTrace to set
	 */
	public void setErreurStackTrace(String erreurStackTrace) {
		this.erreurStackTrace = erreurStackTrace;
	}

	
}
