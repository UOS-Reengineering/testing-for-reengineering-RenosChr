package example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import example.project.domain.Scenario;
import example.project.domain.SimulationResult;
import org.junit.jupiter.api.Test;

public class TestChecker {

    @Test
    public void testCheckCollisionViolations()
    {
        // setup
        Scenario scenario = mock(); // no need to make an actual scenario object since the simulation result will be mocked anyway
        Simulator simulator = mock(); // this is the key class to mock in this task
        when(simulator.run(scenario)).thenReturn(new SimulationResult()); // because `simulation.run()` is the cause of the null pointer exception


        // testing target
        Checker checker = new Checker(simulator);
        boolean isCollision = checker.checkCollisionViolations(scenario);

        // assertion
        verify(simulator, times(1)).run(scenario); // we can verify the interaction between Checker and Simulator like this
        assertEquals(false, isCollision); // this can be added, because we know the fact that there should be no collision in an empty simulation result (i.e., new SimulationResult())
    }

}