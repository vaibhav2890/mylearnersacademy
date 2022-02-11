package com.simplilearn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ClassRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String className;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "class_teacher", 
		joinColumns = { @JoinColumn(name = "teacher_id", referencedColumnName = "id") }, 
		inverseJoinColumns = {@JoinColumn(name = "class_id", referencedColumnName = "id") })
	private List<Teacher> teachers;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "class_subject", 
		joinColumns = { @JoinColumn(name = "subject_id", referencedColumnName = "id") }, 
		inverseJoinColumns = {@JoinColumn(name = "class_id", referencedColumnName = "id") })
	private List<Subject> subjects;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}


	public ClassRoom(String className) {
		super();
		this.className = className;
	}

	public ClassRoom() {
		super();
	}

	@Override
	public String toString() {
		return "ClassRoom [id=" + id + ", className=" + className + ", teachers=" + teachers +", subjects="+ subjects + "]";
	}
	public ClassRoom(String className, List<Subject> subjects, List<Teacher> teachers) {
		super();
		this.className = className;
		this.subjects = subjects;
		this.teachers = teachers;
	}

}
