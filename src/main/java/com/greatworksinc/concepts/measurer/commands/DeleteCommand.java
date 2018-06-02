package com.greatworksinc.concepts.measurer.commands;

import java.util.List;

public class DeleteCommand implements Command {
    private final int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(List<String> list) {
        list.remove(index);
    }
}
