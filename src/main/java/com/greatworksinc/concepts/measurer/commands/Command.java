package com.greatworksinc.concepts.measurer.commands;

import java.util.List;

public interface Command {
    /**
     * Runs the command on a list.
     * @param list The list that the command will be performed on.
     */
    void execute(List<String> list);
}
