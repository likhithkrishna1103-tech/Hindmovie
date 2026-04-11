package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import l4.p;
import n5.c;
import n5.d;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new p(13);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d f1487v;

    public ParcelImpl(d dVar) {
        this.f1487v = dVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new c(parcel).l(this.f1487v);
    }

    public ParcelImpl(Parcel parcel) {
        this.f1487v = new c(parcel).h();
    }
}
