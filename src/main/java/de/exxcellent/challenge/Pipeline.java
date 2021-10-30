package de.exxcellent.challenge;

import de.exxcellent.challenge.handler.IHandler;

/**
 * Pipeline implementation for the challenge. The pipeline is a chain of
 * handlers that can be executed in sequence. The handlers are somewhat
 * dependent on eachother as they process the output of their predecessor.
 * 
 * @author <a href="https://github.com/tlahmann">Tobias Lahmann</a>
 */
public class Pipeline<I, O> {

    /**
     * The current handler.
     */
    private final IHandler<I, O> currentHandler;

    Pipeline(IHandler<I, O> currentHandler) {
        this.currentHandler = currentHandler;
    }

    /**
     * Adding a new handler to the pipeline returning a new pipeline instance
     * 
     * @param <K>        The type of the output of the new handler. The pipeline
     *                   will thus not output the initial type but the new one.
     * @param newHandler The new handler to add to the pipeline.
     * @return A new pipeline instance with the new handler added.
     * 
     * @see IHandler
     */
    <K> Pipeline<I, K> addHandler(IHandler<O, K> newHandler) {
        /*
         * The new handler will process the result of the current handler resulting in a
         * chain of handlers
         */
        return new Pipeline<>(input -> newHandler.process(currentHandler.process(input)));
    }

    /**
     * Executing the pipeline with the given input. The execution step will perform
     * the action of the provided current handler.
     * 
     * @param input The input to process.
     * @return The output of the pipeline.
     * @throws Exception If any error occurs during the processing.
     * 
     * @see IHandler
     */
    O execute(I input) throws Exception {
        return currentHandler.process(input);
    }
}
