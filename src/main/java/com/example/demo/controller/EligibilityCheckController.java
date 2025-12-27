
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
// // }
// package com.example.demo.controller;

// import com.example.demo.model.EligibilityCheckRecord;
// import com.example.demo.service.EligibilityCheckService;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/eligibility-checks")
// public class EligibilityCheckController {

//     private final EligibilityCheckService eligibilityCheckService;

//     public EligibilityCheckController(EligibilityCheckService eligibilityCheckService) {
//         this.eligibilityCheckService = eligibilityCheckService;
//     }

//     // VALIDATE eligibility (CREATE record)
//     @PostMapping("/validate")
//     public ResponseEntity<EligibilityCheckRecord> validateEligibility(
//             @RequestParam Long employeeId,
//             @RequestParam Long deviceItemId) {

//         EligibilityCheckRecord record =
//                 eligibilityCheckService.validateEligibility(employeeId, deviceItemId);

//         return new ResponseEntity<>(record, HttpStatus.CREATED);
//     }

//     // GET all checks by employee
//     @GetMapping("/employee/{employeeId}")
//     public ResponseEntity<List<EligibilityCheckRecord>> getChecksByEmployee(
//             @PathVariable Long employeeId) {

//         return ResponseEntity.ok(
//                 eligibilityCheckService.getChecksByEmployee(employeeId));
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
