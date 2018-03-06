public class HealthyPatient extends Patient {


    @Override
    public void wait40Days() {
        if(getHealthState().hasParacetamol && getHealthState().hasAspirin)
            getHealthState().dead = true;
    }


}
