package ai;

import ai.model.EnvironmentModel;

/**
 * This interface represents a contract for objects that can be connected in a chain.
 * Each chainable object should be able to be connected to another via the setNext method.
 * Each object should also be able to accept an object of type EnvironmentModel via the setNext() method.
 * Created by raghavnarula on 03/11/2015.
 */
public interface IChainable {
    /**
     * Accept a model for processing.
     * @param model The model to be processed
     */
    void put (EnvironmentModel model);

    /**
     * Should set what getNext() returns.
     * @param next The next component in the chain.
     */
    void setNext(IChainable next);

    /**
     * Should return the next component set by setNext()
     * @return IChainable Compnent
     */
    IChainable getNext();

    /**
     * Should return true if a next component has been set.
     * @return True or False
     */
    boolean hasNext();
}
