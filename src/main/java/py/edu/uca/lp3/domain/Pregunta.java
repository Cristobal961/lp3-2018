package py.edu.uca.lp3.domain;

import java.util.ArrayList;

public class Pregunta {
	private String pregunta;
	private Integer upvote;
	private Integer downvote;
	private Integer id;
	private String fecha;
	private Boolean comentarios=true;
	private ArrayList<String> listaComentarios = new ArrayList<String>();
	
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
	
	public ArrayList<String> getListaComentarios() {
		return listaComentarios;
	}
	
	public void setListaComentarios(ArrayList<String> listaComentarios) {
		this.listaComentarios = listaComentarios;
	}
	
	
	
}
