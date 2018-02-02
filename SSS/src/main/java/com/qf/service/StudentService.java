package com.qf.service;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.qf.dao.QueryStudent;
import com.qf.domain.Student;

@Service("studentService")
@Transactional
public class StudentService {
	@Resource(name = "queryStudent")
	private QueryStudent queryStudent;

	public Student queryById(Integer id) {
		Student student = queryStudent.getById(id);
		return student;
	}

	public List<Student> getAll() {
		List<Student> list = queryStudent.getAll();
		return list;
	}

	public Page<Student> getAll(Pageable pageable) {
		return queryStudent.findAll(pageable);
	}

	public List<Student> getAllBySort(Sort sort) {
		return queryStudent.findAll(sort);
	}

	// public void insert(String name, String password) {
	// queryStudent.insert(name, password);
	// }

	public void del(String name) {
		queryStudent.delete(name);
	}

	public List<Student> findAll(String name) {
		Specification<Student> specification = new Specification<Student>() {

			@Override
			public Predicate toPredicate(Root<Student> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				// TODO Auto-generated method stub
				return arg2.and(arg2.like(arg0.get("name").as(String.class), "%" + name + "%"));

			}
		};
		return queryStudent.findAll(specification);
	}

	public void save(Student student) {
		queryStudent.save(student);
	}
}
