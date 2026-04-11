package l4;

import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 implements Parcelable {
    public static final Parcelable.Creator<l0> CREATOR = new p(7);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f7738v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f7739w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Rating f7740x;

    public l0(int i, float f) {
        this.f7738v = i;
        this.f7739w = f;
    }

    public static l0 c(float f) {
        if (f >= 0.0f && f <= 100.0f) {
            return new l0(6, f);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static l0 d(int i, float f) {
        float f10;
        if (i == 3) {
            f10 = 3.0f;
        } else if (i == 4) {
            f10 = 4.0f;
        } else {
            if (i != 5) {
                Log.e("Rating", "Invalid rating style (" + i + ") for a star rating");
                return null;
            }
            f10 = 5.0f;
        }
        if (f >= 0.0f && f <= f10) {
            return new l0(i, f);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    public final float a() {
        int i = this.f7738v;
        if ((i == 3 || i == 4 || i == 5) && b()) {
            return this.f7739w;
        }
        return -1.0f;
    }

    public final boolean b() {
        return this.f7739w >= 0.0f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f7738v;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.f7738v);
        sb.append(" rating=");
        float f = this.f7739w;
        sb.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7738v);
        parcel.writeFloat(this.f7739w);
    }
}
