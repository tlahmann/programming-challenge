package de.exxcellent.challenge.handler;

import java.util.List;
import java.util.function.BinaryOperator;

/**
 * The list reducer handler transforms a list of elements into a single element
 * based on a binary operator.
 * 
 * @author <a href="https://github.com/tlahmann">Tobias Lahmann</a>
 */
public class ListReducerHandler<T, S> implements IHandler<List<T>, T> {
    private final BinaryOperator<T> REDUCER;

    /**
     * List reducer instance
     * 
     * @param reducer the given reducer function determining the result of the
     *                transformation.
     */
    public ListReducerHandler(BinaryOperator<T> reducer) {
        this.REDUCER = reducer;
    }

    /**
     * Validate the given input list. If the list is empty, an exception is thrown.
     */
    @Override
    public void validate(List<T> input) throws Exception {
        if (input.size() <= 0) {
            throw new IllegalStateException("The provided list is empty!");
        } else if (this.REDUCER == null) {
            throw new IllegalStateException("The reducer is undefined!");
        }
    }

    /**
     * Process the given list and returning the element according to the reducer
     * method.
     * 
     * @param input the given list
     * @return the element according to the reducer method
     */
    @Override
    public T process(List<T> input) throws Exception {
        this.validate(input);
        return input.stream().reduce(input.get(0), this.REDUCER);
    }

}
