package team.healthtech.db.converter;

import team.healthtech.db.entity.Allergy;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class AllergyConverter implements AttributeConverter<Allergy, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Allergy attribute) {
        return attribute == null ? null : attribute.getId();
    }

    @Override
    public Allergy convertToEntityAttribute(Integer dbData) {
        return Allergy.fromId(dbData).orElse(null);
    }

}
