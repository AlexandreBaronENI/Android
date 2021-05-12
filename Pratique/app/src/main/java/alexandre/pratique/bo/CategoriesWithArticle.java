package alexandre.pratique.bo;


import androidx.room.Embedded;
import androidx.room.Relation;
import org.parceler.Parcel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Parcel
public class CategoriesWithArticle{
    @Embedded private Category category;
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "categoryId"
    )
    private List<Article> articleList;
}
