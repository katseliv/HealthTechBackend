package team.healthtech.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import team.healthtech.common.Role;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserEntity.class)
public abstract class UserEntity_ {

	public static volatile SingularAttribute<UserEntity, String> password;
	public static volatile SingularAttribute<UserEntity, Role> role;
	public static volatile SingularAttribute<UserEntity, Integer> id;
	public static volatile SingularAttribute<UserEntity, String> login;
	public static volatile SingularAttribute<UserEntity, String> email;

	public static final String PASSWORD = "password";
	public static final String ROLE = "role";
	public static final String ID = "id";
	public static final String LOGIN = "login";
	public static final String EMAIL = "email";

}

