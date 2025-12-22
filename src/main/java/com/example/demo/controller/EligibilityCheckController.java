// package com.example.demo.controller;

// import com.example.demo.model.EligibilityCheckRecord;
// import com.example.demo.service.EligibilityCheckService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/eligibility")
// public class EligibilityCheckController {

//     private final EligibilityCheckService service;
                                                        
//     public EligibilityCheckController(EligibilityCheckService service) {
//         this.service = service;
//     }

//     @PostMapping("/validate/{employeeId}/{deviceItemId}")
//     public EligibilityCheckRecord validate(
//             @PathVariable Long employeeId,
//             @PathVariable Long deviceItemId) {
//         return service.validate(employeeId, deviceItemId);
//     }

//     @GetMapping("/employee/{employeeId}")
//     public List<EligibilityCheckRecord> getByEmployee(
//             @PathVariable Long employeeId) {
//         return service.getByEmployee(employeeId);
//     }
// }
// package com.example.demo.controller;

// import com.example.demo.model.EligibilityCheckRecord;
// import com.example.demo.service.EligibilityCheckService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/eligibility-checks")
// public class EligibilityCheckController {

//     private final EligibilityCheckService service;

//     public EligibilityCheckController(EligibilityCheckService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public EligibilityCheckRecord save(@RequestBody EligibilityCheckRecord record) {
//         return service.save(record);
//     }

//     @GetMapping
//     public List<EligibilityCheckRecord> getAll() {
//         return service.getAll();
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.service.EligibilityCheckService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eligibility-checks")
public class EligibilityCheckRecordController { // <-- rename file to match

    private final EligibilityCheckService service;

    public EligibilityCheckRecordController(EligibilityCheckService service) {
        this.service = service;
    }

    @PostMapping("/validate/{employeeId}/{deviceItemId}")
    public EligibilityCheckRecord validate(
            @PathVariable Long employeeId,
            @PathVariable Long deviceItemId) {
        return service.validate(employeeId, deviceItemId);
    }

    @GetMapping("/employee/{employeeId}")
    public List<EligibilityCheckRecord> getByEmployee(
            @PathVariable Long employeeId) {
        return service.getByEmployee(employeeId);
    }

    @PostMapping
    public EligibilityCheckRecord save(@RequestBody EligibilityCheckRecord record) {
        return service.save(record);
    }

    @GetMapping
    public List<EligibilityCheckRecord> getAll() {
        return service.getAll();
    }
}
