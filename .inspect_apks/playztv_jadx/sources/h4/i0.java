package h4;

import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i0 implements Parcelable {
    public static final Parcelable.Creator<i0> CREATOR = new a9.b(25);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f5818u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f5819v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Rating f5820w;

    public i0(int i, float f) {
        this.f5818u = i;
        this.f5819v = f;
    }

    public static i0 c(float f) {
        if (f >= 0.0f && f <= 100.0f) {
            return new i0(6, f);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static i0 d(int i, float f) {
        float f4;
        if (i == 3) {
            f4 = 3.0f;
        } else if (i == 4) {
            f4 = 4.0f;
        } else {
            if (i != 5) {
                Log.e("Rating", "Invalid rating style (" + i + ") for a star rating");
                return null;
            }
            f4 = 5.0f;
        }
        if (f >= 0.0f && f <= f4) {
            return new i0(i, f);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    public final float a() {
        int i = this.f5818u;
        if ((i == 3 || i == 4 || i == 5) && b()) {
            return this.f5819v;
        }
        return -1.0f;
    }

    public final boolean b() {
        return this.f5819v >= 0.0f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f5818u;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Rating:style=");
        sb2.append(this.f5818u);
        sb2.append(" rating=");
        float f = this.f5819v;
        sb2.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5818u);
        parcel.writeFloat(this.f5819v);
    }
}
