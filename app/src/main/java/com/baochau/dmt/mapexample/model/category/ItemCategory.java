package com.baochau.dmt.mapexample.model.category;

public class ItemCategory {
    private int icon;
    private String content;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ItemCategory(int icon, String content) {
        this.icon = icon;
        this.content = content;
    }
}
