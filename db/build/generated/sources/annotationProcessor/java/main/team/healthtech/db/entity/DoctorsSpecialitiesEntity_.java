package team.healthtech.db.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DoctorsSpecialitiesEntity.class)
public abstract class DoctorsSpecialitiesEntity_ {

	public static volatile SingularAttribute<DoctorsSpecialitiesEntity, DoctorEntity> doctor;
	public static volatile SingularAttribute<DoctorsSpecialitiesEntity, SpecialityEntity> speciality;
	public static volatile SingularAttribute<DoctorsSpecialitiesEntity, Date> receiveDate;
	public static volatile SingularAttribute<DoctorsSpecialitiesEntity, DoctorSpecialityId> id;

	public static final String DOCTOR = "doctor";
	public static final String SPECIALITY = "speciality";
	public static final String RECEIVE_DATE = "receiveDate";
	public static final String ID = "id";

}

