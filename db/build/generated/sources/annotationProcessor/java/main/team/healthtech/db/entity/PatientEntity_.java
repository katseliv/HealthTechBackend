package team.healthtech.db.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PatientEntity.class)
public abstract class PatientEntity_ extends team.healthtech.db.entity.UserEntity_ {

	public static volatile ListAttribute<PatientEntity, AllergyEntity> allergies;
	public static volatile SingularAttribute<PatientEntity, String> firstName;
	public static volatile SingularAttribute<PatientEntity, String> lastName;
	public static volatile SingularAttribute<PatientEntity, Date> birthdate;
	public static volatile SingularAttribute<PatientEntity, String> phoneNumber;
	public static volatile ListAttribute<PatientEntity, CommentEntity> comments;
	public static volatile SingularAttribute<PatientEntity, Character> sex;
	public static volatile SingularAttribute<PatientEntity, String> midName;

	public static final String ALLERGIES = "allergies";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String BIRTHDATE = "birthdate";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String COMMENTS = "comments";
	public static final String SEX = "sex";
	public static final String MID_NAME = "midName";

}

