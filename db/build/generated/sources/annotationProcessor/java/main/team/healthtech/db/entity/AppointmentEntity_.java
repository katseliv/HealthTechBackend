package team.healthtech.db.entity;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppointmentEntity.class)
public abstract class AppointmentEntity_ {

	public static volatile SingularAttribute<AppointmentEntity, String> result;
	public static volatile SingularAttribute<AppointmentEntity, Instant> datetime;
	public static volatile SingularAttribute<AppointmentEntity, Boolean> isTaken;
	public static volatile SingularAttribute<AppointmentEntity, PatientEntity> patient;
	public static volatile SingularAttribute<AppointmentEntity, TimeRecordEntity> timeRecord;
	public static volatile SingularAttribute<AppointmentEntity, String> recipe;
	public static volatile SingularAttribute<AppointmentEntity, Integer> id;

	public static final String RESULT = "result";
	public static final String DATETIME = "datetime";
	public static final String IS_TAKEN = "isTaken";
	public static final String PATIENT = "patient";
	public static final String TIME_RECORD = "timeRecord";
	public static final String RECIPE = "recipe";
	public static final String ID = "id";

}

