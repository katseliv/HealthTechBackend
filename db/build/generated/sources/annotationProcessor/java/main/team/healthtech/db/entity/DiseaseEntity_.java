package team.healthtech.db.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DiseaseEntity.class)
public abstract class DiseaseEntity_ {

	public static volatile SingularAttribute<DiseaseEntity, Date> endDate;
	public static volatile SingularAttribute<DiseaseEntity, PatientEntity> patient;
	public static volatile SingularAttribute<DiseaseEntity, String> name;
	public static volatile SingularAttribute<DiseaseEntity, Integer> id;
	public static volatile SingularAttribute<DiseaseEntity, Date> startDate;

	public static final String END_DATE = "endDate";
	public static final String PATIENT = "patient";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String START_DATE = "startDate";

}

