
// // package com.example.demo.controller;

// // import com.example.demo.model.PolicyRule;
// // import com.example.demo.service.PolicyRuleService;
// // import org.springframework.web.bind.annotation.*;

// // import java.util.List;

// // @RestController
// // @RequestMapping("/policies")
// // public class PolicyRuleController {

// //     private final PolicyRuleService service;

// //     public PolicyRuleController(PolicyRuleService service) {
// //         this.service = service;
// //     }

// //     @PostMapping
// //     public PolicyRule create(@RequestBody PolicyRule rule) {
// //         return service.create(rule);
// //     }

// //     @GetMapping("/active")
// //     public List<PolicyRule> getActiveRules() {
// //         return service.getActiveRules();
// //     }

// //     @GetMapping
// //     public List<PolicyRule> getAll() {
// //         return service.getAll();
// //     }

// //     @DeleteMapping("/{id}")
// //     public void delete(@PathVariable Long id) {
// //         service.delete(id);
// //     }
// // }
// package com.example.demo.controller;

// import com.example.demo.model.PolicyRule;
// import com.example.demo.service.PolicyRuleService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("api/policy-rules")
// public class PolicyRuleController {

//     private final PolicyRuleService service;

//     public PolicyRuleController(PolicyRuleService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public PolicyRule createRule(@RequestBody PolicyRule rule) {
//         return service.createRule(rule);
//     }

//     @GetMapping
//     public List<PolicyRule> getAllRules() {
//         return service.getAllRules();
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policy-rules")
public class PolicyRuleController {

    private final PolicyRuleService policyRuleService;

    public PolicyRuleController(PolicyRuleService policyRuleService) {
        this.policyRuleService = policyRuleService;
    }

    // CREATE policy rule
    @PostMapping
    public ResponseEntity<PolicyRule> createRule(
            @RequestBody PolicyRule rule) {

        PolicyRule createdRule = policyRuleService.createRule(rule);
        return new ResponseEntity<>(createdRule, HttpStatus.CREATED);
    }

    // GET all rules
    @GetMapping
    public ResponseEntity<List<PolicyRule>> getAllRules() {

        return ResponseEntity.ok(policyRuleService.getAllRules());
    }

    // GET active rules only
    @GetMapping("/active")
    public ResponseEntity<List<PolicyRule>> getActiveRules() {

        return ResponseEntity.ok(policyRuleService.getActiveRules());
    }
}
