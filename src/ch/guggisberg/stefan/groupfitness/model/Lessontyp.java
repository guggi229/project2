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
@Table(name="lessontyp")
@Named
@RequestScoped
public class Lessontyp {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ltId")
	private Long id;

	@Column(name="ltName")
	private String  ltName;
	
	@Column(name="ltKat")
	private String  ltKat;
	
	@Column(name="ltDesc")
	private String  ltDesc;

	public Lessontyp() {
		
	}
	public Lessontyp(String name) {
		this.ltName=name;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLtName() {
		return ltName;
	}

	public void setLtName(String ltName) {
		this.ltName = ltName;
	}

	public String getLtKat() {
		return ltKat;
	}

	public void setLtKat(String ltKat) {
		this.ltKat = ltKat;
	}

	public String getLtDesc() {
		return ltDesc;
	}

	public void setLtDesc(String ltDesc) {
		this.ltDesc = ltDesc;
	}
	
	
}
