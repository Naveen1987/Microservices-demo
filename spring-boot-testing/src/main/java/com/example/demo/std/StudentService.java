package com.example.demo.std;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ProjectException;
import com.example.demo.logs.LogCreate;
import com.example.demo.utils.ObjectModelMapper;


@Service
public class StudentService {

	@Autowired StudentRepo stdRepo;
	
	@LogCreate
	public StudentDto save(StudentDto std) {
		Student stdu=getConvertEntity(std);
		stdu=stdRepo.saveAndFlush(stdu);
		std=getJson(stdu).setMsg("saved");
		return std;
	}
	private StudentDto getJson(Student std) {
		ObjectModelMapper modelMapper = new ObjectModelMapper();
		modelMapper.addMappings(new PropertyMap<Student, StudentDto>() {
			@Override
			protected void configure() {
				map().setSid(source.getSid());
				map().setSname(source.getSname());
				map().setSfee(source.getSfee());
				map().setCreatedBy(source.getCreatedBy());
				map().setCreatedOn(source.getCreatedOn());
				map().setLastModifiedby(source.getLastModifiedby());
				map().setLastModifiedOn(source.getLastModifiedOn());
			}
		});
		StudentDto stdu=modelMapper.map(std, StudentDto.class);
		return stdu;
	}
	private Student getConvertEntity(StudentDto std) {
		ObjectModelMapper modelMapper = new ObjectModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		modelMapper.addMappings(new PropertyMap<StudentDto, Student>() {
			@Override
			protected void configure() {
				map().setSid(source.getSid());
				map().setSname(source.getSname());
				map().setSfee(source.getSfee());
			}
		});
		Student stdu=modelMapper.map(std, Student.class);
		return stdu;
	}
	public List<?> getList(Optional<Long> sid) {
		if(sid.isPresent()){
			Optional<Student> std=stdRepo.findById(sid.get());
					if(std.isPresent()){
						return new ArrayList<>(Arrays.asList(std.get()));
					}else{
						throw new ProjectException("Not record found sorry");
					}
		}else{
			return stdRepo.findAll();
		}
	}
	@LogCreate
	public StudentDto update(StudentDto std) {
		Optional<Student> stdu=stdRepo.findById(std.getSid());
		if(!stdu.isPresent()){
			throw new ProjectException("Record not found");
		}
		Student stds=stdu.get();
		if(!StringUtils.isNotEmpty(std.getSname())){
			stds.setSname(std.getSname());
		}
		if(std.getSfee()!=null){
			stds.setSfee(std.getSfee());
		}
		stds=stdRepo.saveAndFlush(stds);
		std=getJson(stds).setMsg("saved");
		return std;
	}

	
	
}
