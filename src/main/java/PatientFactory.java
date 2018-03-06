public class PatientFactory {

    public Patient getPatient(String input) {


        if (input.equals("F"))
            return new FeverPatient();

        if(input.equals("D"))
            return new DiabetesPatient();

        if (input.equals("T"))
            return new TuberculosisPatient();

        return new HealthyPatient();

    }


}
