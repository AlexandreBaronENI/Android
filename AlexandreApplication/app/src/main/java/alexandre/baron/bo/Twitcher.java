package alexandre.baron.bo;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Twitcher extends User {
    public Twitcher(int id, String lastname, String firstname, String pseudo, Date datebirth, String password, String mail, ArrayList<Twitcher> subs, ArrayList<Twitcher> follows, String profilePicture) {
        super(id, lastname, firstname, pseudo, datebirth, password, mail, subs, follows, profilePicture);
    }


    private Twitcher(Parcel in) {
        super(in);
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public static final Creator<Twitcher> CREATOR = new Creator<Twitcher>() {
        @Override
        public Twitcher createFromParcel(Parcel parcel) {
            return new Twitcher(parcel);
        }

        @Override
        public Twitcher[] newArray(int size) {
            return new Twitcher[size];
        }
    };
}