package brain;

import info.Percept;

import java.util.List;

/**
 * Created by raghavnarula on 20/10/15.
 */
public class PerceptHistory {
    private List<Percept> percepts;

    public void addPercept(final Percept p){
        percepts.add(p);
    }
}
