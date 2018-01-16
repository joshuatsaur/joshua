package springMVC;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.joshua.spring.model.Employee;

public class RestTest {
	String SERVER_URI;

	@Before
	public void setUp() throws Exception {
		SERVER_URI = "http://localhost:8080/springMVC/";
	}

	@Test
	public void testGetDummyEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = restTemplate.getForObject(SERVER_URI + "rest/emp/dummy", Employee.class);
		assertEquals("Dummy1", emp.getName());
	}
	
	@Test
	public void testGetEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = restTemplate.getForObject(SERVER_URI + "/rest/emp/1", Employee.class);
		assertEquals("Dummy1", emp.getName());
	}
	
	@Test
	public void testCreateEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = new Employee();
		emp.setId(2);
		emp.setName("joshua");
		Employee response = restTemplate.postForObject(SERVER_URI + "/rest/emp/create", emp, Employee.class);
		assertEquals("joshua", response.getName());
	}
	
	@Test
	public void testGetAllEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI + "/rest/emps", List.class);
		System.out.println(emps.size());
		for(LinkedHashMap map : emps){
			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
		}
	}
	
	@Test
	public void testDeleteEmployee() {
		RestTemplate restTemplate = new RestTemplate();
		Employee emp = restTemplate.getForObject(SERVER_URI + "/rest/emp/delete/2", Employee.class);
		assertEquals("joshua", emp.getName());
	}

}
