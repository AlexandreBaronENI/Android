package alexandre.baron.bo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.TypeConverters;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(primaryKeys = {"idViewer", "idTwitcher"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public abstract class Support implements Parcelable {
    private long idViewer;
    private long idTwitcher;
    @TypeConverters(DateConverter.class)
    private Date date;

    protected Support(Parcel in) {
        idViewer = in.readInt();
        idTwitcher = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idViewer);
        dest.writeLong(idTwitcher);
    }
}
