package de.exxcellent.challenge.handler;

/**
 * Interface for all handlers. A handler is responsible for processing a
 * specific type of input and returning a result.
 * 
 * @author <a href="https://github.com/tlahmann">Tobias Lahmann</a>
 */
public interface IHandler<I, O> {
    /**
     * Validation method to check if the handler can handle the input. Default
     * implementation returns nothing, invalid inputs must throw an exception.
     */
    default void validate(I input) throws Exception {
        return;
    };

    /**
     * Processing method to process the input and return the result.
     */
    O process(I input) throws Exception;
}
