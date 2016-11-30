package lsu.team4330.justask;

/**
 * Created by ben on 11/26/16.
 */

public class User {

    private String name;
    private String userId;

    User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public String getUserId() {
        return this.userId;
    }
}
