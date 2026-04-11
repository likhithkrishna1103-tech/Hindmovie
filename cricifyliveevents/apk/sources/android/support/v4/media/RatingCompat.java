package android.support.v4.media;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a(3);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f484v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f485w;

    public RatingCompat(int i, float f) {
        this.f484v = i;
        this.f485w = f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f484v;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.f484v);
        sb.append(" rating=");
        float f = this.f485w;
        sb.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f484v);
        parcel.writeFloat(this.f485w);
    }
}
