
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeProfileController {

    private final EmployeeProfileService employeeProfileService;

    public EmployeeProfileController(EmployeeProfileService employeeProfileService) {
        this.employeeProfileService = employeeProfileService;
    }

    // CREATE → 200 OK
    @PostMapping
    public EmployeeProfile createEmployee(@RequestBody EmployeeProfile employee) {
        return employeeProfileService.createEmployee(employee);
    }

    // GET BY ID → 200 OK
    @GetMapping("/{id}")
    public EmployeeProfile getEmployeeById(@PathVariable Long id) {
        return employeeProfileService.getEmployeeById(id);
    }

    // GET ALL → 200 OK
    @GetMapping
    public List<EmployeeProfile> getAllEmployees() {
        return employeeProfileService.getAllEmployees();
    }

    // UPDATE ACTIVE STATUS → 200 OK
    @PutMapping("/{id}/active")
    public EmployeeProfile updateEmployeeStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return employeeProfileService.updateEmployeeStatus(id, active);
    }
}
