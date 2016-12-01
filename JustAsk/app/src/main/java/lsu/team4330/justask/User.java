package lsu.team4330.justask;

/**
 * Created by ben on 11/26/16.
 */

public class User {
    private String displayName;
    private String uid;
    private String photoUrl;

    User() {
        // Empty Constructor
    }

    User(String displayName, String uid, String photoUrl) {
        this.displayName = displayName;
        this.uid = uid;
        this.photoUrl = photoUrl;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getUid() {
        return uid;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
