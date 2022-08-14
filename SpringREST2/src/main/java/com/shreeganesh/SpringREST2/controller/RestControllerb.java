package com.shreeganesh.SpringREST2.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shreeganesh.SpringREST2.api.ErrorResponse;
import com.shreeganesh.SpringREST2.api.Studdentdto;
import com.shreeganesh.SpringREST2.api.StudentResponse;
import com.shreeganesh.SpringREST2.dao.StudentDAO;
import com.shreeganesh.SpringREST2.exception.StudentException;

@RestController
public class RestControllerb {

	@Autowired
	StudentDAO sdao;
	
	/*
	 * @Autowired StudentResponse stur;
	 */

	@GetMapping(value = "/stu", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Studdentdto> getStudent() {

		Studdentdto stu = new Studdentdto(1, "Krishna", "Pune");

		return ResponseEntity.status(HttpStatus.OK).body(stu);
	}

	@GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StudentResponse>> getstudents() { 
		List<StudentResponse> sturlist = new ArrayList<StudentResponse>();
		for (Studdentdto stu : sdao.getAllStudents()) {
			StudentResponse stur = new StudentResponse();
			stur.setId(stu.getId());
			stur.setName(stu.getName());
			sturlist.add(stur);
		}
		return ResponseEntity.status(HttpStatus.OK).body(sturlist);
	}

	@GetMapping(value = "/student/{id}", params = "id")
	public ResponseEntity<StudentResponse> getStudentById(@PathVariable("id") int stuid) throws Exception {

		if (sdao.findStudentsize() < stuid) {
			throw new StudentException("Itne toh log nahi hai bhai");

		}

		StudentResponse stur = new StudentResponse();
		Studdentdto stude = sdao.getStudentdb(stuid);
		stur.setId(stude.getId());
		stur.setName(stude.getName());
		return ResponseEntity.status(HttpStatus.OK).body(stur);
	}

	@GetMapping(value = "/student/{name}", params = "name")
	public ResponseEntity<StudentResponse> getStudentByName(@PathVariable("name") String name) {
		StudentResponse stur = new StudentResponse();
		Studdentdto studto = sdao.getStudentdb(name);
		stur.setId(studto.getId());
		stur.setName(studto.getName());
		return ResponseEntity.status(HttpStatus.OK).body(stur);
	}

	/*
	 * @PostMapping("/student") public String createStudent(@RequestParam("id") int
	 * id,@RequestParam("name") String name,@RequestParam("address") String address)
	 * { sdao.createstudent(id,name,address); return "Student Created"; }
	 */

	@PostMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> createStudentReqBody(@RequestBody Studdentdto stu) {
		
		int result = sdao.createstudentdb(stu.getName(), stu.getAddress());
		StudentResponse stur = new StudentResponse();
		if (result != 1) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(stur);
		} else {
			stur.setId(sdao.getStudentdb(stu.getName()).getId());
			stur.setName(stu.getName());
			return ResponseEntity.status(HttpStatus.CREATED).body(stur);
		}
	}

	/*
	 * @ExceptionHandler ResponseEntity<ErrorResponse>
	 * handleStudentexception(StudentException se){ ErrorResponse er = new
	 * ErrorResponse(); er.setErrordate(new Date());
	 * er.setErrormessage(se.getMessage());
	 * er.setErrortype(se.getClass().toString()); return new
	 * ResponseEntity<ErrorResponse>(er,HttpStatus.NOT_FOUND); }
	 */

	@PutMapping(value = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> updateStudent(@RequestBody Studdentdto sdto, @PathVariable int id) {
		int result = sdao.updatestudentdb(id, sdto.getName(), sdto.getAddress());
		StudentResponse stur = new StudentResponse();
		if (result!=1) {
			return new ResponseEntity<StudentResponse>(stur,HttpStatus.PARTIAL_CONTENT);
		}
		else {
			stur.setId(id);
			stur.setName(sdto.getName());
		return new ResponseEntity<StudentResponse>(stur, HttpStatus.ACCEPTED);
		}
	}

	@DeleteMapping(value = "/student/{id}")
	public ResponseEntity<StudentResponse> deleteStudent(@PathVariable int id) {

		StudentResponse stur = new StudentResponse();
		Studdentdto result = sdao.deletestudentdb(id);
		stur.setId(result.getId());
		stur.setName(result.getName());
		return ResponseEntity.status(HttpStatus.OK).body(stur);

	}
}
