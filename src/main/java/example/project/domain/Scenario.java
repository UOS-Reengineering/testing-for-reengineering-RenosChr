package example.project.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * A class defining the definition of a driving scenario, which is dependent on the domain/application.
 * This must be modified and updated with class Snapshot.
 */
public class Scenario {
    String roadType;
    String weatherCondition;
    List<Float> initEgoCarPos;  // (x, y)
    List<Float> initCarInFrontPos;  // (x, y)

    public Scenario() {
        roadType = null;
        weatherCondition = null;
        initEgoCarPos = null;
        initCarInFrontPos = null;
    }

    public Scenario(String scenarioDescription) {
        // parse scenarioDescription and save the result to the class attributes
        // not implemented
    }

    /**
     * Calculate the Euclidean distance between two n-dimensional float lists.
     * (Note: the two positions must have the same dimensionality)
     *
     * @param pos1 an n-dimensional position1
     * @param pos2 an n-dimensional position2
     * @return the distance between the two positions
     */
    double calcEuclideanDist(List<Float> pos1, List<Float> pos2) {
        assert pos1.size() == pos2.size();
        int num_dimensions = pos1.size();
        double sum = 0;
        for(int i=0; i<num_dimensions; i++) {
            sum += Math.pow(pos1.get(i) - pos2.get(i), 2);
        }
        return Math.sqrt(sum);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        Scenario scenario = (Scenario) obj;

        return roadType.equals(scenario.roadType) &&
                weatherCondition.equals(scenario.weatherCondition) &&
                calcEuclideanDist(initEgoCarPos, scenario.initEgoCarPos) <= 0.05 &&
                calcEuclideanDist(initCarInFrontPos, scenario.initCarInFrontPos) <= 0.05;
    }
}
