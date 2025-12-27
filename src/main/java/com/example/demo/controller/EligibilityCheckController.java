
// // package com.example.demo.controller;

// // import com.example.demo.model.EligibilityCheckRecord;
// // import com.example.demo.service.EligibilityCheckService;
// // import org.springframework.web.bind.annotation.*;

// // import java.util.List;

// // @RestController
// // @RequestMapping("/eligibility-checks")
// // public class EligibilityCheckController {

// //     private final EligibilityCheckService service;

// //     public EligibilityCheckController(EligibilityCheckService service) {
// //         this.service = service;
// //     }

// //     @PostMapping("/validate/{employeeId}/{deviceItemId}")
// //     public EligibilityCheckRecord validate(
// //             @PathVariable Long employeeId,
// //             @PathVariable Long deviceItemId) {
// //         return service.validate(employeeId, deviceItemId);
// //     }

// //     @PostMapping
// //     public EligibilityCheckRecord save(@RequestBody EligibilityCheckRecord record) {
// //         return service.save(record);
// //     }

// //     @GetMapping
// //     public List<EligibilityCheckRecord> getAll() {
// //         return service.getAll();
// //     }

// //     @GetMapping("/employee/{employeeId}")
// //     public List<EligibilityCheckRecord> getByEmployee(@PathVariable Long employeeId) {
// //         return service.getByEmployee(employeeId);
// //     }
// // }
// package com.example.demo.controller;

// import com.example.demo.service.EligibilityCheckService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/eligibility")
// public class EligibilityCheckController {

//     private final EligibilityCheckService service;

//     public EligibilityCheckController(EligibilityCheckService service) {
//         this.service = service;
//     }

//     @GetMapping("/check")
//     public String checkEligibility() {
//         return "Eligibility check executed";
//     }
// }

package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.EligibilityCheckRecord;
import com.example.demo.service.EligibilityCheckService;

@RestController
@RequestMapping("/api/eligibility")
public class EligibilityCheckController {

    private final EligibilityCheckService service;

    public EligibilityCheckController(EligibilityCheckService service) {
        this.service = service;
    }

    @PostMapping("/validate/{employeeId}/{deviceItemId}")
    public EligibilityCheckRecord validate(
            @PathVariable Long employeeId,
            @PathVariable Long deviceItemId) {

        return service.validateEligibility(employeeId, deviceItemId);
    }

    @GetMapping("/employee/{employeeId}")
    public List<EligibilityCheckRecord> byEmployee(@PathVariable Long employeeId) {
        return service.getChecksByEmployee(employeeId);
    }

    @GetMapping("/{id}")
    public EligibilityCheckRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
