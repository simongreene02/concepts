package com.greatworksinc.concepts.linkedlist;

import com.google.common.base.Preconditions;

import javax.annotation.Nullable;

public class Node {
    private String content;
    private @Nullable Node nextItem;

    public Node(String content, @Nullable Node nextItem) {
        this.content = Preconditions.checkNotNull(content);
        this.nextItem = nextItem;
    }

    public String getContent() {
        return content;
    }

    public Node getNextItem() {
        return nextItem;
    }

    public void setNextItem(@Nullable Node nextItem) {
        this.nextItem = nextItem;
    }
}
