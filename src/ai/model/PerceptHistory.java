package ai.model;

import info.Percept;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raghavnarula on 20/10/15.
 */
public class PerceptHistory {
    private List<Percept> percepts = new ArrayList<>();

    public void addPercept(final Percept p){
        percepts.add(p);
    }

    public List<Percept> getCopy() {
        List<Percept> clone = new ArrayList<>(percepts.size());
        for(Percept p : percepts){
            clone.add(p);
        }
        return clone;
    }

    public List<Percept> getPercepts() {
        return percepts;
    }
}
