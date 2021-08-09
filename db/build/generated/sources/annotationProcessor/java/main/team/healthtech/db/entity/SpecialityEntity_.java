package team.healthtech.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SpecialityEntity.class)
public abstract class SpecialityEntity_ {

	public static volatile ListAttribute<SpecialityEntity, DoctorsSpecialitiesEntity> doctors;
	public static volatile SingularAttribute<SpecialityEntity, String> name;
	public static volatile SingularAttribute<SpecialityEntity, Integer> id;

	public static final String DOCTORS = "doctors";
	public static final String NAME = "name";
	public static final String ID = "id";

}

