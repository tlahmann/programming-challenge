package de.exxcellent.challenge.handler;

import java.util.List;

/**
 * The list reducer handler transforms a list of elements into a single element.
 * 
 * @author <a href="https://github.com/tlahmann">Tobias Lahmann</a>
 */
public class ListReducerHandler<T, S> implements IHandler<List<T>, T> {

    @Override
    public void validate(List<T> input) throws Exception {
        return;
    }

    @Override
    public T process(List<T> input) throws Exception {
        return null;
    }

}
