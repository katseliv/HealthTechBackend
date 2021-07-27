package team.healthtech.db.entity.enums;

import java.util.Optional;

public enum Speciality {

    IMMUNOLOGIST(1),
    NUTRITIONIST(2),
    ORTHODONTIST(3)
    ;

    private final int id;

    Speciality(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Optional<Speciality> fromId(Integer id) {
        if (id == null) {
            return Optional.empty();
        }

        for (var value : Speciality.values()) {
            if (value.id == id) {
                return Optional.of(value);
            }
        }

        return Optional.empty();
    }

}
