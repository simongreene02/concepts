package com.greatworksinc.concepts.measurer.commands;

import java.util.List;

public class SearchCommand implements Command {
  private String target;

  public SearchCommand(String target) {
    this.target = target;
  }

  @Override
  public void execute(List<String> list) {
    list.indexOf(target);
  }

  @Override
  public String getName() {
    return "Search-" + target;
  }
}
