package team.healthtech.db.entity;

import java.util.Optional;

public enum AllergyEntity {
    ALLERGY1(1),
    ALLERGY2(2),
    ALLERGY3(3);
    private final int id;

    AllergyEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Optional<AllergyEntity> fromId(Integer id) {
        if (id == null) {
            return Optional.empty();
        }
        for (var value : AllergyEntity.values()) {
            if (value.id == id) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
}
