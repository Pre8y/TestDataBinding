package com.learncode.testdatabinding.data.model;

import java.util.List;

public class RepoApiResponse {
    public List<RepoModel> getItems() {
        return items;
    }

    public void setItems(List<RepoModel> items) {
        this.items = items;
    }

    List<RepoModel> items;
}
