package info;

import info.flag.FlagInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raghavnarula on 20/10/15.
 */
public class Percept {

    private int timestep;
    private List<FlagInfo> flags;

    public Percept(int timestep) {
        this.timestep = timestep;
        this.flags = new ArrayList<>();
    }

    public void addFlag(final FlagInfo flag){
        flags.add(flag);
    }
}
