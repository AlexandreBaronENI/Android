package eni.fr;

import android.os.Parcel;
import android.os.Parcelable;

public class Article implements Parcelable {
    String nom, description, url;
    double prix;
    int degreEnvie;

    Article(String nom, String description, double prix, int degreEnvie, String url){
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.degreEnvie = degreEnvie;
        this.url = url;
    }

    protected Article(Parcel in) {
        nom = in.readString();
        description = in.readString();
        url = in.readString();
        prix = in.readDouble();
        degreEnvie = in.readInt();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeDouble(prix);
        dest.writeInt(degreEnvie);
    }
}
