
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

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.PolicyRule;
import com.example.demo.service.PolicyRuleService;

@RestController
@RequestMapping("/api/policy-rules")
public class PolicyRuleController {

    private final PolicyRuleService service;

    public PolicyRuleController(PolicyRuleService service) {
        this.service = service;
    }

    @PostMapping
    public PolicyRule createRule(@RequestBody PolicyRule rule) {
        return service.createRule(rule);
    }

    @GetMapping
    public List<PolicyRule> getAllRules() {
        return service.getAllRules();
    }

    @GetMapping("/active")
    public List<PolicyRule> getActiveRules() {
        return service.getActiveRules();
    }

    @PutMapping("/{id}/active")
    public PolicyRule updateActiveStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.updateRuleActive(id, active);
    }

    @DeleteMapping("/{id}")
    public void deleteRule(@PathVariable Long id) {
        service.deleteRule(id);
    }
}
