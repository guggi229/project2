package ch.guggisberg.stefan.groupfitness.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="tag")
@Named
@RequestScoped
//@NamedQueries({
//	@NamedQuery(
//	name = "findAllTags",
//	query = "SELECT t FROM TAG t"
//	)
//})
public class Tag {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idTag")
	private Long id;

	@Column(name="name")
	private String  tagName;

	public Tag() {

	}
	public Tag(String name) {
		this.tagName= name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	




}
