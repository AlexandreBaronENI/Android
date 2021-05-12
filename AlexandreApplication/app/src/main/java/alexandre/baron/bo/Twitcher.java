package alexandre.baron.bo;

import android.os.Parcel;

import androidx.room.Entity;
import androidx.room.Junction;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Twitcher extends User {

    public Twitcher(int id, String lastname, String firstname, String pseudo, Date datebirth, String password, String mail, ArrayList<Sub> subs, ArrayList<Follow> follows, String profilePicture) {
        super(id, lastname, firstname, pseudo, datebirth, password, mail,  profilePicture);
    }
}