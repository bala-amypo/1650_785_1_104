
// // package com.example.demo.controller;

// // import com.example.demo.model.EmployeeProfile;
// // import com.example.demo.service.EmployeeProfileService;
// // import org.springframework.web.bind.annotation.*;

// // import java.util.List;

// // @RestController
// // @RequestMapping("/employees")
// // public class EmployeeProfileController {

// //     private final EmployeeProfileService service;

// //     public EmployeeProfileController(EmployeeProfileService service) {
// //         this.service = service;
// //     }

// //     @PostMapping
// //     public EmployeeProfile create(@RequestBody EmployeeProfile employee) {
// //         return service.create(employee);
// //     }

// //     @GetMapping("/{id}")
// //     public EmployeeProfile getById(@PathVariable Long id) {
// //         return service.getById(id);
// //     }

// //     @GetMapping
// //     public List<EmployeeProfile> getAll() {
// //         return service.getAll();
// //     }

// //     @PutMapping("/{id}")
// //     public EmployeeProfile update(
// //             @PathVariable Long id,
// //             @RequestBody EmployeeProfile employee) {
// //         return service.update(id, employee);
// //     }

// //     @DeleteMapping("/{id}")
// //     public void delete(@PathVariable Long id) {
// //         service.delete(id);
// //     }
// // }

package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeProfileController {

    private final EmployeeProfileService employeeService;

    public EmployeeProfileController(EmployeeProfileService employeeService) {
        this.employeeService = employeeService;
    }

    // CREATE employee
    @PostMapping
    public ResponseEntity<EmployeeProfile> createEmployee(
            @RequestBody EmployeeProfile employee) {

        EmployeeProfile savedEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // GET employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeProfile> getEmployeeById(@PathVariable Long id) {

        EmployeeProfile employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    // GET all employees
    @GetMapping
    public ResponseEntity<List<EmployeeProfile>> getAllEmployees() {

        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // UPDATE employee active status (PUT)
    @PutMapping("/{id}/status")
    public ResponseEntity<EmployeeProfile> updateEmployeeStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {

        EmployeeProfile updatedEmployee =
                employeeService.updateEmployeeStatus(id, active);

        return ResponseEntity.ok(updatedEmployee);
    }
}
