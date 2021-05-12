package alexandre.pratique.bo;

import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.parceler.Parcel;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Parcel
public class Article {

    public static final String ClassName = "article";

    @PrimaryKey(autoGenerate = true)
    private long articleId;
    private String name;
    private String description;
    private double prix;
    private long categoryId;
    private String uriPicture;


    public Article(String name, String description, double prix, long categoryId, String uriPicture){
        this.name = name;
        this.description = description;
        this.prix = prix;
        this.categoryId = categoryId;
        this.uriPicture = uriPicture;
    }
}
