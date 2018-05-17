package net.sevecek.videoboss.entity;

import java.io.*;
import javax.xml.bind.annotation.*;

public class Film implements Serializable {

    private Long id;

    private String name;

    private String externalLink;

    private int releaseYear;

    private double rating;

    private int version;

    //------------------------------------------------------------------------

    @Deprecated
    protected Film() {
    }

    public Film(String name, String externalLink, int releaseYear, double rating) {
        this.name = name;
        this.externalLink = externalLink;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public Film(Long id, String name, String externalLink, int releaseYear, double rating) {
        this.id = id;
        this.name = name;
        this.externalLink = externalLink;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public Film(Long id, String name, String externalLink, int releaseYear, double rating, int version) {
        this.id = id;
        this.name = name;
        this.externalLink = externalLink;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.version = version;
    }

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

    //------------------------------------------------------------------------

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (this.getId() == null) return false;
        if (!this.testInstanceOf(other)) return false;
        Film otherEntity = (Film) other;
        if (!otherEntity.testInstanceOf(this)) return false;

        return getId().equals(otherEntity.getId());
    }


    protected boolean testInstanceOf(Object other) {
        return other instanceof Film;
    }


    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }


    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", externalLink='" + externalLink + '\'' +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                ", version=" + version +
                '}';
    }

}
