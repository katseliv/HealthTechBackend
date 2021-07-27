package team.healthtech.db.entity.enums;

import java.util.Optional;

public enum Allergy {
    ALLERGY1(1),
    ALLERGY2(2),
    ALLERGY3(3);
    private final int id;

    Allergy(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Optional<Allergy> fromId(Integer id) {
        if (id == null) {
            return Optional.empty();
        }
        for (var value : Allergy.values()) {
            if (value.id == id) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
}
