package epamhw4.entities;

public enum Model {
    BRAVO("Bravo"),
    FIESTA("Fiesta"),
    GL("GL"),
    GOLF("Golf"),
    GRANDVITARA("Grand Vitara"),
    GRANTA("Granta"),
    GUILIA("Guilta"),
    KALINA("Kalina"),
    LOGAN("Logan"),
    MDX("Mdx"),
    P308("308"),
    Q5("Q5"),
    RX3("Rx3"),
    RS6("RS6"),
    TRANSPORTER("Transporter"),
    X5("X5"),
    X6("X6");
    private final String name;

    Model(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
