package alexandre.baron.bo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Sub extends Support{
    private int nbMonths;
    private int level;

    private Sub(Parcel in) {
        super(in);
        nbMonths = in.readInt();
        level = in.readInt();
    }

    public static final Parcelable.Creator<Sub> CREATOR = new Parcelable.Creator<Sub>() {
        @Override
        public Sub createFromParcel(Parcel parcel) {
            return new Sub(parcel);
        }

        @Override
        public Sub[] newArray(int size) {
            return new Sub[size];
        }
    };
}
