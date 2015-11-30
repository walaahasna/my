package com.example.walaa_p.myresturent;

/**
 * Created by walaa-p on 09/29/2015.
 */
public class food {
String name ;
    int photo;

    public food(int photo, String name) {
        this.photo = photo;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;

    }
}
