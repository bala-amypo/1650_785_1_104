public interface EligibilityCheckService {
    EligibilityCheckRecord save(EligibilityCheckRecord e);
    List<EligibilityCheckRecord> findAll();
}