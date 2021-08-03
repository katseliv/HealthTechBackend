package team.healthtech.service;

public class EntityNotFoundException extends RuntimeException {

  public EntityNotFoundException(int id, String entityName) {
    super(entityName + " with ID =" + id + " not found!");
  }
}
