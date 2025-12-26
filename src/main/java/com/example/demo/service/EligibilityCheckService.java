
// // package com.example.demo.service;

// // import com.example.demo.model.EligibilityCheckRecord;

// // import java.util.List;

// // public interface EligibilityCheckService {

// //     EligibilityCheckRecord save(EligibilityCheckRecord record);

// //     EligibilityCheckRecord validate(Long employeeId, Long deviceItemId);

// //     List<EligibilityCheckRecord> getAll();

// //     List<EligibilityCheckRecord> getByEmployee(Long employeeId);

// // }

// package com.example.demo.service;

// import com.example.demo.model.EligibilityCheckRecord;
// import java.util.List;

// public interface EligibilityCheckService {
//     EligibilityCheckRecord validateEligibility(Long employeeId, Long deviceItemId);
//     List<EligibilityCheckRecord> getChecksByEmployee(Long employeeId);
// }

package com.example.demo.service;

import com.example.demo.model.EligibilityCheckRecord;
import java.util.List;

public interface EligibilityCheckService {
    EligibilityCheckRecord validateEligibility(String employeeId, Long deviceItemId);
    List<EligibilityCheckRecord> getChecksByEmployee(String employeeId);
}