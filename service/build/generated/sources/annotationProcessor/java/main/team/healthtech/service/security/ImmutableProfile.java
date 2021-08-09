package team.healthtech.service.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;
import team.healthtech.common.Role;

/**
 * Immutable implementation of {@link Profile}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableProfile.builder()}.
 */
@Generated(from = "Profile", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableProfile implements Profile {
  private final Integer id;
  private final String login;
  private final String email;
  private final Role role;

  private ImmutableProfile(
      Integer id,
      String login,
      String email,
      Role role) {
    this.id = id;
    this.login = login;
    this.email = email;
    this.role = role;
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @Override
  public Integer getId() {
    return id;
  }

  /**
   * @return The value of the {@code login} attribute
   */
  @Override
  public String getLogin() {
    return login;
  }

  /**
   * @return The value of the {@code email} attribute
   */
  @Override
  public String getEmail() {
    return email;
  }

  /**
   * @return The value of the {@code role} attribute
   */
  @Override
  public Role getRole() {
    return role;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Profile#getId() id} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableProfile withId(Integer value) {
    Integer newValue = Objects.requireNonNull(value, "id");
    if (this.id.equals(newValue)) return this;
    return new ImmutableProfile(newValue, this.login, this.email, this.role);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Profile#getLogin() login} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for login
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableProfile withLogin(String value) {
    String newValue = Objects.requireNonNull(value, "login");
    if (this.login.equals(newValue)) return this;
    return new ImmutableProfile(this.id, newValue, this.email, this.role);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Profile#getEmail() email} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for email
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableProfile withEmail(String value) {
    String newValue = Objects.requireNonNull(value, "email");
    if (this.email.equals(newValue)) return this;
    return new ImmutableProfile(this.id, this.login, newValue, this.role);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Profile#getRole() role} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for role
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableProfile withRole(Role value) {
    if (this.role == value) return this;
    Role newValue = Objects.requireNonNull(value, "role");
    if (this.role.equals(newValue)) return this;
    return new ImmutableProfile(this.id, this.login, this.email, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableProfile} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableProfile
        && equalTo((ImmutableProfile) another);
  }

  private boolean equalTo(ImmutableProfile another) {
    return id.equals(another.id)
        && login.equals(another.login)
        && email.equals(another.email)
        && role.equals(another.role);
  }

  /**
   * Computes a hash code from attributes: {@code id}, {@code login}, {@code email}, {@code role}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + id.hashCode();
    h += (h << 5) + login.hashCode();
    h += (h << 5) + email.hashCode();
    h += (h << 5) + role.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Profile} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Profile{"
        + "id=" + id
        + ", login=" + login
        + ", email=" + email
        + ", role=" + role
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link Profile} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Profile instance
   */
  public static ImmutableProfile copyOf(Profile instance) {
    if (instance instanceof ImmutableProfile) {
      return (ImmutableProfile) instance;
    }
    return ImmutableProfile.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableProfile ImmutableProfile}.
   * <pre>
   * ImmutableProfile.builder()
   *    .id(Integer) // required {@link Profile#getId() id}
   *    .login(String) // required {@link Profile#getLogin() login}
   *    .email(String) // required {@link Profile#getEmail() email}
   *    .role(team.healthtech.common.Role) // required {@link Profile#getRole() role}
   *    .build();
   * </pre>
   * @return A new ImmutableProfile builder
   */
  public static ImmutableProfile.Builder builder() {
    return new ImmutableProfile.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableProfile ImmutableProfile}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Profile", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_ID = 0x1L;
    private static final long INIT_BIT_LOGIN = 0x2L;
    private static final long INIT_BIT_EMAIL = 0x4L;
    private static final long INIT_BIT_ROLE = 0x8L;
    private long initBits = 0xfL;

    private Integer id;
    private String login;
    private String email;
    private Role role;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Profile} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Profile instance) {
      Objects.requireNonNull(instance, "instance");
      id(instance.getId());
      login(instance.getLogin());
      email(instance.getEmail());
      role(instance.getRole());
      return this;
    }

    /**
     * Initializes the value for the {@link Profile#getId() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder id(Integer id) {
      this.id = Objects.requireNonNull(id, "id");
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link Profile#getLogin() login} attribute.
     * @param login The value for login 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder login(String login) {
      this.login = Objects.requireNonNull(login, "login");
      initBits &= ~INIT_BIT_LOGIN;
      return this;
    }

    /**
     * Initializes the value for the {@link Profile#getEmail() email} attribute.
     * @param email The value for email 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder email(String email) {
      this.email = Objects.requireNonNull(email, "email");
      initBits &= ~INIT_BIT_EMAIL;
      return this;
    }

    /**
     * Initializes the value for the {@link Profile#getRole() role} attribute.
     * @param role The value for role 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder role(Role role) {
      this.role = Objects.requireNonNull(role, "role");
      initBits &= ~INIT_BIT_ROLE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableProfile ImmutableProfile}.
     * @return An immutable instance of Profile
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableProfile build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableProfile(id, login, email, role);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      if ((initBits & INIT_BIT_LOGIN) != 0) attributes.add("login");
      if ((initBits & INIT_BIT_EMAIL) != 0) attributes.add("email");
      if ((initBits & INIT_BIT_ROLE) != 0) attributes.add("role");
      return "Cannot build Profile, some of required attributes are not set " + attributes;
    }
  }
}
