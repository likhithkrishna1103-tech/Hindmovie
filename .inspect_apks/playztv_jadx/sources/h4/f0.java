package h4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements Parcelable {
    public static final Parcelable.Creator<f0> CREATOR = new a9.b(22);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f5801u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f5802v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f5803w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f5804x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f5805y;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f5801u);
        parcel.writeInt(this.f5803w);
        parcel.writeInt(this.f5804x);
        parcel.writeInt(this.f5805y);
        parcel.writeInt(this.f5802v);
    }
}
