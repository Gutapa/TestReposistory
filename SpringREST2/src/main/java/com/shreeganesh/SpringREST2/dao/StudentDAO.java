package com.shreeganesh.SpringREST2.dao;

import java.util.List;

import com.shreeganesh.SpringREST2.api.Studdentdto;

public interface StudentDAO {

	List<Studdentdto> getAllStudents();
	Studdentdto getStudent(int id);
	Studdentdto getStudent(String name);
	void createstudent(int id, String name, String address);
	int findStudentsize();
	boolean updatestudent(int id, String name, String address);
	Studdentdto deletestudent(int id);
	int createstudentdb(String name, String address);
	int updatestudentdb(int id, String name, String address);
	Studdentdto getStudentdb(int i);
	Studdentdto getStudentdb(String name);
	Studdentdto deletestudentdb(int id);
}
