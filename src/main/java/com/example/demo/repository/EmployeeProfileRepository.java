// package com.example.demo.repository;
// import java.util.Optional;

// import com.example.demo.model.*;
// import org.springframework.data.jpa.repository.JpaRepository;
// public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long> {
//     Optional<EmployeeProfile> findByEmployeeId(String employeeId);
//     boolean existsByEmployeeId(String employeeId);

// }
// // public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long> {}
// package com.example.demo.repository;

// import com.example.demo.model.*;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.Optional;

// public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long> {
//     Optional<EmployeeProfile> findByEmployeeId(String employeeId);
//     Optional<EmployeeProfile> findByEmail(String email);
// }
package com.example.demo.repository;

import com.example.demo.model.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long> {
}
