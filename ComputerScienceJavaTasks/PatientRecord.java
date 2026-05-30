import java.util.*;
public class PatientRecord {
    private String patientID;
    private String socialSecurityNumber;
    private List<MedicalDiagnosis> diagnoses;
    private List<Prescription> prescriptions;
    
    // Only authorized personnel can access sensitive data
    public String getRedactedSSN(User requestingUser) {
        if (requestingUser.hasPermission("VIEW_SENSITIVE_DATA")) {
            return socialSecurityNumber;
        }
        return "***-**-" + socialSecurityNumber.substring(7);
    }
    
    public void addDiagnosis(MedicalDiagnosis diagnosis, User doctor) {
        if (doctor.hasRole("PHYSICIAN")) {
            diagnoses.add(diagnosis);
        }
    }
}
