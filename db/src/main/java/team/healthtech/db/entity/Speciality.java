package team.healthtech.db.entity;

import java.util.Optional;

public enum Speciality {

    SPECIALITY1(1),
    SPECIALITY2(2),
    SPECIALITY3(3)
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
