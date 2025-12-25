
// package com.example.demo.service;

// import com.example.demo.model.EmployeeProfile;

// import java.util.List;

// public interface EmployeeProfileService {
//     EmployeeProfile create(EmployeeProfile employee);
//     EmployeeProfile getById(Long id);
//     List<EmployeeProfile> getAll();
//     EmployeeProfile update(Long id, EmployeeProfile employee);
//     void delete(Long id);
//     EmployeeProfile updateStatus(Long id, boolean active);
//     boolean existsByEmployeeId(String employeeId);
// // }
// package com.example.demo.service;

// import com.example.demo.model.EmployeeProfile;
// import java.util.List;

// public interface EmployeeProfileService {
//     EmployeeProfile createEmployee(EmployeeProfile emp);
//     EmployeeProfile updateEmployeeStatus(Long id, boolean active);
//     EmployeeProfile getEmployeeById(Long id);
//     List<EmployeeProfile> getAllEmployees();
// }
// package com.example.demo.service;

// import com.example.demo.model.EmployeeProfile;
// import java.util.List;

// public interface EmployeeProfileService {

//     EmployeeProfile create(EmployeeProfile profile);

//     List<EmployeeProfile> getAll();

//     EmployeeProfile activate(Long id, boolean active);
// }
package com.example.demo.service;

import com.example.demo.model.EmployeeProfile;
import java.util.List;

public interface EmployeeProfileService {

    EmployeeProfile createEmployee(EmployeeProfile profile);

    EmployeeProfile updateEmployeeStatus(Long id, boolean active);

    EmployeeProfile getEmployeeById(Long id);

    List<EmployeeProfile> getAllEmployees();
}
