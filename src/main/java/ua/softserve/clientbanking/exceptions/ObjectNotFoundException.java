package ua.softserve.clientbanking.exceptions;
@SuppressWarnings("serial")
public class ObjectNotFoundException extends NoteException {
	private String objectType;
	private String objectId;
	/**
	 * A convenience constructor which takes an object type name and the ID of the object
	 *
	 * @param objectType the name of the object which could not be found
	 * @param id the ID of the object  which could not be found
	 */
	public ObjectNotFoundException(String objectType, Integer id) {
		this(objectType, String.valueOf(id));
	}

	/**
	 * A convenience constructor which takes an object type name and the ID of the object
	 *
	 * @param objectType the name of the object which could not be found
	 * @param id the ID of the object  which could not be found
	 */
	public ObjectNotFoundException(String objectType, String id) {
		super("The "+objectType+" id='"+id+"' does not exist");
		this.objectType = objectType;
		this.objectId = id;
	}

	/**
	 * A convenience constructor which takes an object class and the ID of the object
	 *
	 * @param objectClass the class of the object which could not be found
	 * @param id the ID of the object  which could not be found
	 */
	public ObjectNotFoundException(Class<?> objectClass, String id) {
		this(objectClass.getSimpleName(), id);
	}

	/**
	 * A convenience constructor which takes an object class and the ID of the object
	 *
	 * @param objectClass class of the object which could not be found
	 * @param id ID of the object  which could not be found
	 */
	public ObjectNotFoundException(Class<?> objectClass, Integer id) {
		this(objectClass.getSimpleName(), id);
	}

	/**
	 * @return ID of the object which was not found
	 */
	public String getObjectId() {
		return this.objectId;
	}

	/**
	 * @return type or class name of the object which was not found
	 */
	public String getObjectType() {
		return this.objectType;
	}

}
