package travel_type.tt_test.useranalysis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // 질문 유형
    private boolean likesQuietPlaces;
    private boolean likesDesserts;
    private boolean likesCoolPlaces;
    private boolean likesNature;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isLikesQuietPlaces() {
        return likesQuietPlaces;
    }

    public void setLikesQuietPlaces(boolean likesQuietPlaces) {
        this.likesQuietPlaces = likesQuietPlaces;
    }

    public boolean isLikesDesserts() {
        return likesDesserts;
    }

    public void setLikesDesserts(boolean likesDesserts) {
        this.likesDesserts = likesDesserts;
    }

    public boolean isLikesCoolPlaces() {
        return likesCoolPlaces;
    }

    public void setLikesCoolPlaces(boolean likesCoolPlaces) {
        this.likesCoolPlaces = likesCoolPlaces;
    }

    public boolean isLikesNature() {
        return likesNature;
    }

    public void setLikesNature(boolean likesNature) {
        this.likesNature = likesNature;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
