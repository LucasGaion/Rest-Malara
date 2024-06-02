package br.edu.uniara.lpi2.rest;

package br.edu.uniara.lpi2.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

package br.edu.uniara.lpi2.rest.controller;

import br.edu.uniara.lpi2.rest.model.Employee;
import br.edu.uniara.lpi2.rest.model.EmployeePagingRepository;
import br.edu.uniara.lpi2.rest.model.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EmployeeControllerTest {

	@Mock
	private EmployeeRepository repository;

	@Mock
	private EmployeePagingRepository pagingRepository;

	@InjectMocks
	private EmployeeController controller;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetEmployeeById() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("John Doe");

		when(repository.findById(anyLong())).thenReturn(Optional.of(employee));

		Employee result = controller.one(1L);
		assertEquals(1L, result.getId());
		assertEquals("John Doe", result.getName());
	}

	@Test
	void testGetEmployeeByIdNotFound() {
		when(repository.findById(anyLong())).thenReturn(Optional.empty());

		try {
			controller.one(1L);
		} catch (RuntimeException e) {
			assertEquals("Erro pesquisando id: 1", e.getMessage());
		}
	}

	@Test
	void testGetAllEmployees() {
		// Adicione a lógica para testar o método "all"
	}

	@Test
	void testInsertEmployee() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("John Doe");

		when(repository.save(any(Employee.class))).thenReturn(employee);

		ResponseEntity<Employee> response = controller.insert(employee);
		assertEquals(200, response.getStatusCodeValue());
		assertEquals(employee, response.getBody());
	}

	@Test
	void testDeleteEmployee() {
		when(repository.existsById(anyLong())).thenReturn(true);
		doNothing().when(repository).deleteById(anyLong());

		ResponseEntity<?> response = controller.delete(1L);
		assertEquals(200, response.getStatusCodeValue());
		assertEquals("1was removed", response.getBody());
	}

	@Test
	void testDeleteEmployeeNotFound() {
		when(repository.existsById(anyLong())).thenReturn(false);

		ResponseEntity<?> response = controller.delete(1L);
		assertEquals(404, response.getStatusCodeValue());
	}
}

