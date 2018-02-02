package com.qf.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.qf.domain.Student;
import com.qf.service.StudentService;

public class test01 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		StudentService bean = context.getBean(StudentService.class);
		Student queryById = bean.queryById(1);
		System.out.println(queryById);

		// bean.insert("zz", "111");
		// List<Student> list = bean.getAll();
		// System.out.println(list);
		// bean.del("fff");
		// List<Student> all = bean.getAll();
		// System.out.println(all);
		// List<Student> list2 = bean.findAll("z");
		// System.out.println(list2);
		// System.out.println("======================");
		// Student student = new Student();
		// student.setName("ff");
		// student.setPassword("111");
		// bean.save(student);
		Pageable pageable = new PageRequest(0, 2);
		Page<Student> page = bean.getAll(pageable);
		System.out.println(page.getContent());
		Sort sort = new Sort("name");
		System.out.println(bean.getAllBySort(sort));
	}
}
