package net.sevecek.techeddemo;

public class Film {

    private Long id;
    private String name;
    private String externalLink;
    private int releaseYear;
    private double rating;

    public Film() {
        this(null, null, null, 0, 0.0);
    }

    public Film(String name, String externalLink, int releaseYear, double rating) {
        this(null, name, externalLink, releaseYear, rating);
    }

    public Film(Long id, String name, String externalLink, int releaseYear, double rating) {
        if (id == null) {
            id = (long)(Math.random() * 10000L);
        }
        this.id = id;
        this.name = name;
        this.externalLink = externalLink;
        this.releaseYear = releaseYear;
        this.rating = rating;
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
}
