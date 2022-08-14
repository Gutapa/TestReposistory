package com.shreeganesh.SpringREST2;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.shreeganesh.SpringREST2.api.Studdentdto;
import com.shreeganesh.SpringREST2.dao.StudentDAO;

@Repository
public class StudentDAOImpl implements StudentDAO {

	List<Studdentdto> s = new ArrayList<Studdentdto>();
	List<Studdentdto> sa = new ArrayList<Studdentdto>();
	@Autowired
	JdbcTemplate jdbct;
	
	
	@PostConstruct
	void createStudent() {
		Studdentdto s1 = new Studdentdto(1, "tappu", "gokuldham");
		Studdentdto s2 = new Studdentdto(2, "Krishna", "Pune");
		Studdentdto s3 = new Studdentdto(3, "Vinita", "Ghorpadi");
		Studdentdto s4 = new Studdentdto(4, "Tushar", "US");
		Studdentdto s5 = new Studdentdto(5, "Sneha", "singapore");
		s.add(s1);
		s.add(s2);
		s.add(s3);
		s.add(s4);
		s.add(s5);
	}
	 
	
	
	
	@Override
	public List<Studdentdto> getAllStudents() {
		String sql = "select * from student";
		sa= jdbct.query(sql,new BeanPropertyRowMapper<Studdentdto>(Studdentdto.class));
		return sa;
	}

	@Override
	public Studdentdto getStudent(int id) {
		return s.get(id);
	}


	

	@Override
	public Studdentdto getStudent(String name) {
		Studdentdto student=null;
		for(Studdentdto stud : s)
		{
			if(stud.getName().equalsIgnoreCase(name)) {
				student=stud;
			}
		}
		return student;
	}



	@Override
	public void createstudent(int id, String name, String address) {
		Studdentdto stu = new Studdentdto(id, name, address);
		s.add(stu);
	}



	@Override
	public int findStudentsize() {
		return s.size();
	}



	@Override
	public boolean updatestudent(int id, String name, String address) {
		Studdentdto student = s.get(id-1);
		student.setName(name);
		student.setAddress(address);
		return true;
	}



	@Override
	public Studdentdto deletestudent(int id) {
		
		return s.remove(--id);
	}




	@Override
	public int createstudentdb(String name, String address) {

		String sql = "insert into student(`name`,`address`) values(?,?)";
		Object args[] = {name,address};
		
		int result = jdbct.update(sql, args);
		if(result!=1) {return -1;}
		else {	
		return result;
		}
	}




	@Override
	public int updatestudentdb(int id, String name, String address) {
		String sql = "update student set name=?, address=? where id=?";
		Object argObject[] = {name,address,id};
		int result = jdbct.update(sql, argObject);
		return result;
	}




	@Override
	public Studdentdto getStudentdb(int i) {
		String sql = "select * from student where id=?";
		Studdentdto studdto = jdbct.queryForObject(sql, new BeanPropertyRowMapper<Studdentdto>(Studdentdto.class),i);
		return studdto;
		
	}




	@Override
	public Studdentdto getStudentdb(String name) {

		String sql = "select * from student where name=?";
		Studdentdto stdto = jdbct.queryForObject(sql, new BeanPropertyRowMapper<Studdentdto>(Studdentdto.class),name);
		return stdto;
	}




	@Override
	public Studdentdto deletestudentdb(int id) {
		String sql = "delete from student where id=?";
		Studdentdto tempres = new Studdentdto(); 
		Studdentdto temp = getStudentdb(id);
		int result = jdbct.update(sql, id);
		if(result==1) {tempres = temp;}
		return tempres;
	}

}
