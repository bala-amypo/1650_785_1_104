// package com.example.demo.repository;

// import com.example.demo.model.PolicyRule;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;
// import java.util.Optional;


// public interface PolicyRuleRepository
//         extends JpaRepository<PolicyRule, Long> {

//     List<PolicyRule> findByActiveTrue();
// }
// public interface PolicyRuleRepository extends JpaRepository<PolicyRule, Long> {
//     List<PolicyRule> findByActiveTrue();
//     Optional<PolicyRule> findByRuleCode(String ruleCode);
// }
package com.example.demo.repository;

import com.example.demo.model.PolicyRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRuleRepository extends JpaRepository<PolicyRule, Long> {
    boolean existsByRuleCode(String ruleCode);

    List<PolicyRule> findByActiveTrue();
}
