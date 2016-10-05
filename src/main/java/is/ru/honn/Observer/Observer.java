package is.ru.honn.Observer;

/**
 * A interface for Observer can be used for future uses of any kind of Observer(for example VideoObserver)
 */
public interface Observer {

    /**
     * Prints out if a Object that a observer is watching is added
     * @param object is the object that was added
     */
    public void notifyAdded(Object object);
}
