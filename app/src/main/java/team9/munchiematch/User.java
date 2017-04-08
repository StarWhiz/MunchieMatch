package team9.munchiematch;

import android.net.Uri;

import com.google.firebase.auth.FirebaseUser;

import java.net.URI;
import java.util.ArrayList;

/**
 * Created by robert on 3/18/2017.
 */

public class User {
    private ArrayList<Recipe> userRecipes;
    private ArrayList<Recipe> likedRecipes;

    private FirebaseUser loggedInUser;
    //TODO Add login information
    private String userName;
    private String userAge;

    private static User instance;

    private User(FirebaseUser currentUser) {
        userRecipes = new ArrayList<Recipe>();
        likedRecipes = new ArrayList<Recipe>();

        loggedInUser = currentUser;
    }

    public static User getInstance(FirebaseUser currentUser) {
        if(instance == null) {
            instance = new User(currentUser);
            return instance;
        }
        else return instance;
    }

    public void addRecipe(Recipe newRecipe) {
        userRecipes.add(newRecipe);
    }

    public String getUserName() {
        return userName;
    }

    public Uri getProfilePicture() {
        return loggedInUser.getPhotoUrl();
    }

    public void addLikedRecipe(Recipe newLikeRecipe) {
        likedRecipes.add(newLikeRecipe);
    }

    public void setName(final String name) {
        userName = name;
    }

    public void setAge(final String age) {
        this.userAge = age;
    }
}
