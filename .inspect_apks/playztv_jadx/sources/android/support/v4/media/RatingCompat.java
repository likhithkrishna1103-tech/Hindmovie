package android.support.v4.media;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a9.b(4);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f828u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f829v;

    public RatingCompat(int i, float f) {
        this.f828u = i;
        this.f829v = f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f828u;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Rating:style=");
        sb2.append(this.f828u);
        sb2.append(" rating=");
        float f = this.f829v;
        sb2.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f828u);
        parcel.writeFloat(this.f829v);
    }
}
