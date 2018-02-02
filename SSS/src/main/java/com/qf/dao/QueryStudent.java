package com.qf.dao;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.qf.domain.Student;

public interface QueryStudent extends Repository<Student, Integer>, JpaRepository<Student, Integer> {
	Student getById(Integer id);

	@Query("select s from Student s")
	public List<Student> getAll();

	// @Modifying
	// @Query("insert into Student(name,password)values(?,?)")
	// public void insert(String name, String password);

	@Modifying
	@Query("delete from Student s where s.name=?1")
	public void delete(String name);

	public List<Student> findAll(Specification<Student> specification);

}
