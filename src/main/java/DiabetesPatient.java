public class DiabetesPatient extends Patient {


    @Override
    public void wait40Days() {

        if(getHealthState().hasParacetamol && getHealthState().hasAspirin)
            this.getHealthState().dead = true;

        if(!getHealthState().hasInsulin)
            getHealthState().dead = true;

    }

}
