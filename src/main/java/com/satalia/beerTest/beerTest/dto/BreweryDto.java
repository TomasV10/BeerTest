package com.satalia.beerTest.beerTest.dto;

public class BreweryDto {
    private String name;
    private int id;
    private boolean visited;

    public BreweryDto(String name, int id, boolean visited) {
        this.id = id;
        this.name = name;
        this.visited = visited;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "BreweryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", visited=" + visited +
                '}';
    }
}
