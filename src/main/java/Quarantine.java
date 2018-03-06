import java.util.ArrayList;
import java.util.List;

public class Quarantine {

    List<Patient> patients = new ArrayList<>();
    List<Patient> deadPatients = new ArrayList<>();

    public Quarantine(String patientsInput) {

        String[] splitInput = patientsInput.split(",");

        PatientFactory patientFactory = new PatientFactory();

        for (int i=0; i<splitInput.length; i++) {
            Patient patient = patientFactory.getPatient(splitInput[i]);
            patients.add(patient);
        }
    }

    public String report() {
        int healthyPatientsNbr = 0;
        int diabetesPatientsNbr = 0;
        int feverPatientsNbr = 0;
        int tuberculosisPatientsNbr = 0;

        for(Patient patient : patients) {
            if(patient instanceof DiabetesPatient)
                diabetesPatientsNbr++;
            if(patient instanceof FeverPatient)
                feverPatientsNbr++;
            if(patient instanceof TuberculosisPatient)
                tuberculosisPatientsNbr++;
            if(patient instanceof HealthyPatient)
                healthyPatientsNbr++;
        }

        return "F:"+feverPatientsNbr+" H:"+healthyPatientsNbr+" D:"+diabetesPatientsNbr+" T:"+tuberculosisPatientsNbr+" X:"+deadPatients.size();
    }


    public void wait40Days() {
        for(Patient patient: patients) {
            patient.wait40Days();
        }

        checkForDeadPatients();
    }

    private void checkForDeadPatients() {
        for(Patient patient: patients) {
            if(patient.isDead()) {
                deadPatients.add(patient);
            }
        }
        patients.removeAll(deadPatients);

    }

    public void aspirin() {
        healFever();
        for(Patient patient: patients) {
            patient.aspirin();
        }

        checkForDeadPatients();
    }

    private void healFever() {
        List<Patient> curedPatients = new ArrayList<>();
        List<Patient> healthyPatients = new ArrayList<>();
        for(Patient patient: patients) {
            if (patient instanceof FeverPatient) {
                healthyPatients.add(new HealthyPatient());
                curedPatients.add(patient);
            }
        }
        patients.removeAll(curedPatients);
        patients.addAll(healthyPatients);
    }

    public void insulin() {
        for(Patient patient: patients) {
            patient.insulin();
        }
        checkInsulinAndAntibiotic();
    }

    public void antibiotic() {

        List<Patient> patientsToRemove = new ArrayList<>();
        List<Patient> healthyPatients = new ArrayList<>();

        for(Patient patient: patients) {
            patient.antibiotic();
            if (patient instanceof TuberculosisPatient) {
                healthyPatients.add(new HealthyPatient());
                patientsToRemove.add(patient);
            }
        }

        patients.removeAll(patientsToRemove);
        patients.addAll(healthyPatients);

        checkInsulinAndAntibiotic();
    }

    public void checkInsulinAndAntibiotic() {
        List<Patient> patientsToRemove = new ArrayList<>();
        List<Patient> feverPatients = new ArrayList<>();

        for(Patient patient: patients) {


            if(patient instanceof HealthyPatient) {
                if (patient.hasInsulin() && patient.hasAntibiotic()) {
                    feverPatients.add(new FeverPatient());
                    patientsToRemove.add(patient);
                }
            }
        }
        patients.removeAll(patientsToRemove);
        patients.addAll(feverPatients);
    }

    public void paracetamol() {
        healFever();
        for(Patient patient: patients) {
            patient.paracetamol();
        }
        checkForDeadPatients();
    }

}
