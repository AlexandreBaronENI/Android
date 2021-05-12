package alexandre.baron.bo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Follow extends Support {

    private Follow(Parcel in) {
        super(in);
    }

    public static final Parcelable.Creator<Follow> CREATOR = new Parcelable.Creator<Follow>() {
        @Override
        public Follow createFromParcel(Parcel parcel) {
            return new Follow(parcel);
        }

        @Override
        public Follow[] newArray(int size) {
            return new Follow[size];
        }
    };
}
