package eni.fr;

public class Article implements android.os.Parcelable {
    String nom, description, url;
    double prix;
    int degreEnvie, id;
    boolean isAchete;

    public Article() {
    }

    Article(int id, String nom, String description, double prix, int degreEnvie, String url, boolean isAchete){
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.degreEnvie = degreEnvie;
        this.url = url;
        this.isAchete = isAchete;
    }

    protected Article(android.os.Parcel in) {
        id = in.readInt();
        nom = in.readString();
        description = in.readString();
        url = in.readString();
        prix = in.readDouble();
        degreEnvie = in.readInt();
        isAchete = in.readByte() != 0;
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(android.os.Parcel in) {
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
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeDouble(prix);
        dest.writeInt(degreEnvie);
        dest.writeByte((byte) (isAchete ? 1 : 0));
    }

    @Override
    public String toString() {
        return "Article : " + this.nom + " " + this.prix;
    }
}
