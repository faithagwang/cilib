/**           __  __
 *    _____ _/ /_/ /_    Computational Intelligence Library (CIlib)
 *   / ___/ / / / __ \   (c) CIRG @ UP
 *  / /__/ / / / /_/ /   http://cilib.net
 *  \___/_/_/_/_.___/
 */
package net.sourceforge.cilib.algorithm;

import net.sourceforge.cilib.problem.Problem;
import net.sourceforge.cilib.problem.solution.OptimisationSolution;
import net.sourceforge.cilib.util.Cloneable;

/**
 * Base interface defining all {@code Algorithm} classes.
 */
public interface Algorithm extends Runnable, Cloneable {

    /**
     * Perform the actions of the current {@linkplain Algorithm} for a single iteration.
     */
    void performIteration();

    /**
     * Perform the needed initialisation required before the execution of the algorithm
     * starts.
     */
    void performInitialisation();

    /**
     * Obtain the best current solution.
     * @return The {@code OptimisationSolution} representing the best solution.
     * @see net.sourceforge.cilib.entity.Topology#getBestEntity()
     */
    OptimisationSolution getBestSolution();

    /**
     * Obtain the collection of best solutions. This result does not actually make sense in normal
     * {@code PopulationBasedAlgorithm}s, but rather in a MultiObjective optimisation.
     * @return An {@code Iterable} containing the solutions.
     */
    Iterable<OptimisationSolution> getSolutions();

    /**
     * Returns the number of iterations that have been performed by the algorihtm.
     * @return The number of iterations.
     *
     * Not Needed>??>????????????
     */
    int getIterations();

    /**
     * Set the optimisation problem to be solved. By default, the problem is <code>null</code>.
     * That is, it is necessary to set the optimisation problem before calling {@link #initialise()}.
     * @param problem An implementation of the
     * {@link net.sourceforge.cilib.problem.OptimisationProblemAdapter} interface.
     */
    void setOptimisationProblem(Problem problem);

    /**
     * Get the specified {@linkplain OptimisationProblem}.
     * @return The specified {@linkplain OptimisationProblem}.
     */
    Problem getOptimisationProblem();

    boolean isFinished();
}
