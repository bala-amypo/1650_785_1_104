
// package com.example.demo.service;

// import com.example.demo.model.EligibilityCheckRecord;

// import java.util.List;

// public interface EligibilityCheckService {

//     EligibilityCheckRecord save(EligibilityCheckRecord record);

//     EligibilityCheckRecord validate(Long employeeId, Long deviceItemId);

//     List<EligibilityCheckRecord> getAll();

//     List<EligibilityCheckRecord> getByEmployee(Long employeeId);

// }

// public interface EligibilityCheckService {}
package com.example.demo.service;

import com.example.demo.model.EligibilityCheckRecord;

public interface EligibilityCheckService {

    EligibilityCheckRecord checkEligibility(Long employeeId, Long deviceItemId);
}
