package team.healthtech.db.converter;

import team.healthtech.db.entity.Speciality;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SpecialitiesConverter implements AttributeConverter<Speciality, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Speciality attribute) {
        return attribute == null ? null : attribute.getId();
    }

    @Override
    public Speciality convertToEntityAttribute(Integer dbData) {
        return Speciality.fromId(dbData).orElse(null);
    }
}
