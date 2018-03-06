public class Patient {

    private HealthState healthState = new HealthState();

    public boolean isDead() {
        return healthState.dead;
    }

    public void wait40Days() {

    }

    public void insulin() {
        healthState.hasInsulin = true;
    }

    public void antibiotic() {
        healthState.hasAntibiotic = true;
    }

    public void aspirin() {
        healthState.hasAspirin = true;
        if(healthState.hasParacetamol)
            healthState.dead = true;
    }

    public boolean hasAntibiotic() {
        return healthState.hasAntibiotic;
    }

    public boolean hasInsulin() {
        return healthState.hasInsulin;
    }

    public void paracetamol() {
        healthState.hasParacetamol = true;
        if(healthState.hasAspirin)
            healthState.dead = true;
    }

    public boolean hasParacetamol() {
        return healthState.hasParacetamol;
    }

    public boolean hasAspirin() {
        return healthState.hasAspirin;
    }

    public HealthState getHealthState() {
        return healthState;
    }
}
