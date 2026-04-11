package androidx.versionedparcelable;

import a9.b;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import i5.c;
import i5.d;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new b(26);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d f1704u;

    public ParcelImpl(d dVar) {
        this.f1704u = dVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new c(parcel).l(this.f1704u);
    }

    public ParcelImpl(Parcel parcel) {
        this.f1704u = new c(parcel).h();
    }
}
