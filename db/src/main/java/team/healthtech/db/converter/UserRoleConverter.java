package team.healthtech.db.converter;

import team.healthtech.common.Role;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserRoleConverter implements AttributeConverter<Role, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Role attribute) {
        return attribute == null ? null : attribute.getId();
    }

    @Override
    public Role convertToEntityAttribute(Integer dbData) {
        return Role.of(dbData).orElse(null);
    }

}
