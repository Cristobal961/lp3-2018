package py.edu.uca.lp3.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pregunta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4542417306426189892L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String pregunta;
	private Integer upvote;
	private Integer downvote;
	private String fecha;
	private Boolean comentarios = true;

	@ElementCollection
	private List<String> listaComentarios = new ArrayList<String>();

	public Boolean getComentarios() {
		return comentarios;
	}

	public void setComentarios(Boolean comentarios) {
		this.comentarios = comentarios;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public Integer getUpvote() {
		return upvote;
	}

	public void setUpvote(Integer upvote) {
		this.upvote = upvote;
	}

	public Integer getDownvote() {
		return downvote;
	}

	public void setDownvote(Integer downvote) {
		this.downvote = downvote;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public List<String> getListaComentarios() {
		return listaComentarios;
	}

	public void setListaComentarios(List<String> listaComentarios) {
		this.listaComentarios = listaComentarios;
	}

}
