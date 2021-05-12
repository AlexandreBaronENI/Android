package alexandre.baron.bo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.room.TypeConverters;

import java.util.Date;
import java.util.List;

import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data public class User implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String lastname;
    private String firstname;
    private String pseudo;
    @TypeConverters(DateConverter.class)
    private Date dateBirth;
    private String password;
    private String mail;
    private String profilePicture;

    protected User(Parcel in) {
        lastname = in.readString();
        firstname = in.readString();
        pseudo = in.readString();
        password = in.readString();
        mail = in.readString();
        profilePicture = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(lastname);
        dest.writeString(firstname);
        dest.writeString(pseudo);
        dest.writeString(password);
        dest.writeString(mail);
        dest.writeString(profilePicture);
    }
}
