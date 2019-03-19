package epamhw4.entities;

public enum Manufacturer {
    ALFA_ROMEO("Alfa Romeo"),
    AUDI("Audi"),
    BMW("BMW"),
    FIAT("Fiat"),
    FORD("Ford"),
    LADA("Lada"),
    MAZDA("Mazda"),
    PEUGEOT("Peugeot"),
    RENAULT("Renault"),
    SUZUKI("Suzuki"),
    MERCEDES("Mercedes"),
    VOLKSWAGEN("VolksWagen");

    private final String name;

    Manufacturer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
