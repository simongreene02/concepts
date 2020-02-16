package com.greatworksinc.concepts.measurer.commands;

import java.util.List;

public class RetrieveCommand implements Command {
  private final int index;

  public RetrieveCommand(int index) {
    this.index = index;
  }

  @Override
  public void execute(List<String> list) {
    list.get(index);
  }

  @Override
  public String getName() {
    return "Retrieve-" + index;
  }
}
