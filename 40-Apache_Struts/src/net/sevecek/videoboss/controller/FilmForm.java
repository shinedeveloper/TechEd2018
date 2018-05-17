package net.sevecek.videoboss.controller;

import org.apache.struts.action.*;

public class FilmForm extends ActionForm {

    private Long id;
    private String name;
    private String externalLink;
    private int releaseYear;
    private double rating;
    private int version;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getExternalLink() {
        return externalLink;
    }


    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }


    public int getReleaseYear() {
        return releaseYear;
    }


    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }


    public double getRating() {
        return rating;
    }


    public void setRating(double rating) {
        this.rating = rating;
    }


    public int getVersion() {
        return version;
    }


    public void setVersion(int version) {
        this.version = version;
    }
}
