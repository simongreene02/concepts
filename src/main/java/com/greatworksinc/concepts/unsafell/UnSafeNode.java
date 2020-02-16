package com.greatworksinc.concepts.unsafell;

import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

public class UnSafeNode {

  private String content;
  private @Nullable UnSafeNode nextItem;

  public UnSafeNode(String content, @Nullable UnSafeNode nextItem) {
    this.content = Preconditions.checkNotNull(content);
    this.nextItem = nextItem;
  }

  public String getContent() {
    return content;
  }

  public UnSafeNode getNextItem() {
    return nextItem;
  }

  public void setNextItem(@Nullable UnSafeNode nextItem) {
    this.nextItem = nextItem;
  }
}
