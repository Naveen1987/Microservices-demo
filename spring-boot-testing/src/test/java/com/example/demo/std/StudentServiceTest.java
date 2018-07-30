package com.example.demo.std;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.std.Student;
import com.example.demo.std.StudentDto;

import com.example.demo.utils.ObjectModelMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

	@Mock StudentRepo stdRepo;
	@Autowired StudentService stdService;
	
	
	@Test
	public void save() {
		 Student s=getStudent();
		 Mockito.when(stdRepo.save(s)).thenReturn(s);
		 assertThat(getConvertEntity(stdService.save(getJson(s)))).isEqualTo(s);
	}
//	@Test
//	public void getList() {
//		
//	}
//	@Test
//	public void update() {
//	
//	}

	private Student getStudent() {
		Student std=new Student();
		std.setSid(Long.valueOf(1));
		std.setSname("abc");
		std.setSfee(234.56);
		std.setCreatedBy("Naveen");
		std.setCreatedOn(LocalDateTime.now());
		std.setLastModifiedby("Naveen");
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
}
