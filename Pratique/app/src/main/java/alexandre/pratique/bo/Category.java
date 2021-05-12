package alexandre.pratique.bo;


import androidx.room.Entity;
import androidx.room.PrimaryKey;


import org.parceler.Parcel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Parcel
public class Category {

    public static final String ClassName = "category";

    @PrimaryKey(autoGenerate = true)
    private int categoryId;
    private String name;
    private String uriPicture;

    public Category(String name, String uriPicture){
        this.name = name;
        this.uriPicture = uriPicture;
    }
}
