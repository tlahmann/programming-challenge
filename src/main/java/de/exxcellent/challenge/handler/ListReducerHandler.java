package de.exxcellent.challenge.handler;

import java.util.List;

/**
 * The list reducer handler transforms a list of elements into a single element.
 * 
 * @author <a href="https://github.com/tlahmann">Tobias Lahmann</a>
 */
public class ListReducerHandler<T, S> implements IHandler<List<T>, T> {

    /**
     * Validate the given input list. If the list is empty, an exception is thrown.
     */
    @Override
    public void validate(List<T> input) throws Exception {
        if (input.size() <= 0) {
            throw new IllegalStateException("The provided list is empty!");
        }
    }

    /**
     * Process the given list and return the first element of the list.
     */
    @Override
    public T process(List<T> input) throws Exception {
        this.validate(input);
        return input.get(0);
    }

}
