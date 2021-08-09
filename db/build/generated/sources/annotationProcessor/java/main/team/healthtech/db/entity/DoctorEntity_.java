package team.healthtech.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DoctorEntity.class)
public abstract class DoctorEntity_ extends team.healthtech.db.entity.UserEntity_ {

	public static volatile SingularAttribute<DoctorEntity, String> firstName;
	public static volatile SingularAttribute<DoctorEntity, String> lastName;
	public static volatile ListAttribute<DoctorEntity, CommentEntity> comments;
	public static volatile SingularAttribute<DoctorEntity, String> midName;
	public static volatile ListAttribute<DoctorEntity, DoctorsSpecialitiesEntity> specialities;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String COMMENTS = "comments";
	public static final String MID_NAME = "midName";
	public static final String SPECIALITIES = "specialities";

}

