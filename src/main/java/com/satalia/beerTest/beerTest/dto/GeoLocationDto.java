package com.satalia.beerTest.beerTest.dto;



public class GeoLocationDto {
    private int id;
    private double latitude;
    private double longitude;
    private boolean visited;



    public GeoLocationDto(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public GeoLocationDto(double latitude, double longitude, boolean visited) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.visited = visited;
    }

    public GeoLocationDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "GeoLocationDto{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", visited=" + visited +
                '}';
    }
}
