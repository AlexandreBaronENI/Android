package alexandre.baron.bo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data public abstract class User implements Parcelable {
    private int id;
    private String lastname;
    private String firstname;
    private String pseudo;
    private Date dateBirth;
    private String password;
    private String mail;
    private List<Twitcher> subs;
    private List<Twitcher> follows;
    private String profilePicture;

    protected User(Parcel in) {
        id = in.readInt();
        lastname = in.readString();
        firstname = in.readString();
        pseudo = in.readString();
        password = in.readString();
        mail = in.readString();
        subs = in.createTypedArrayList(Twitcher.CREATOR);
        follows = in.createTypedArrayList(Twitcher.CREATOR);
        profilePicture = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(lastname);
        dest.writeString(firstname);
        dest.writeString(pseudo);
        dest.writeString(password);
        dest.writeString(mail);
        dest.writeTypedList(subs);
        dest.writeTypedList(follows);
        dest.writeString(profilePicture);
    }
}
