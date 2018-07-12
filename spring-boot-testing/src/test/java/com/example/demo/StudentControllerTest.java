package com.example.demo;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.std.StudentController;
import com.example.demo.std.StudentDto;
import com.example.demo.std.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentController.class, secure = false)
public class StudentControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;
	
	@Test
	public void save() throws Exception {
		StudentDto s=new StudentDto();
		s.setSid(Long.valueOf(1));
		s.setSname("Xyz");
		s.setSfee(120.90);
		s.setCreatedBy("naveen");
		s.setLastModifiedby("naveen");
		String inputInJson = this.mapToJson(s);
		System.out.println(inputInJson);
		Mockito.when(
				studentService.save(Mockito.any(StudentDto.class))).thenReturn(s);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/saveStd").accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();	
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		System.out.println(outputInJson);
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void update() throws Exception {
		StudentDto s=new StudentDto();
		s.setSid(Long.valueOf(1));
		s.setSname("Xyz");
		s.setSfee(120.90);
		String inputInJson = this.mapToJson(s);
		System.out.println(inputInJson);
		Mockito.when(
				studentService.update(Mockito.any(StudentDto.class))).thenReturn(s);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/updateStd").accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();	
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		System.out.println(outputInJson);
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void getList() throws Exception {
		StudentDto s=new StudentDto();
		s.setSid(Long.valueOf(1));
		s.setSname("Xyz");
		s.setSfee(120.90);
		List<StudentDto>sm=Arrays.asList(s);
		String inputInJson = this.mapToJson(sm);
		System.out.println(inputInJson);
		Mockito.<List<?>>when(
				studentService.getList(Optional.of(Long.valueOf(1)))).thenReturn(sm);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/students").content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();	
		MockHttpServletResponse response = result.getResponse();
		String outputInJson = response.getContentAsString();
		System.out.println(outputInJson);
		assertThat(Arrays.asList(outputInJson)).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
