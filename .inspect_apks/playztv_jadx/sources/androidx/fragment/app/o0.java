package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o0 implements Parcelable {
    public static final Parcelable.Creator<o0> CREATOR = new a9.b(8);
    public ArrayList A;
    public ArrayList B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList f1335u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList f1336v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public b[] f1337w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1338x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f1339y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ArrayList f1340z;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f1335u);
        parcel.writeStringList(this.f1336v);
        parcel.writeTypedArray(this.f1337w, i);
        parcel.writeInt(this.f1338x);
        parcel.writeString(this.f1339y);
        parcel.writeStringList(this.f1340z);
        parcel.writeTypedList(this.A);
        parcel.writeTypedList(this.B);
    }
}
