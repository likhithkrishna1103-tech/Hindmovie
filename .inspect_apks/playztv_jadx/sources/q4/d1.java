package q4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d1 implements Parcelable {
    public static final Parcelable.Creator<d1> CREATOR = new k8.x(12);
    public ArrayList A;
    public boolean B;
    public boolean C;
    public boolean D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10765u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10766v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10767w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int[] f10768x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f10769y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int[] f10770z;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f10765u);
        parcel.writeInt(this.f10766v);
        parcel.writeInt(this.f10767w);
        if (this.f10767w > 0) {
            parcel.writeIntArray(this.f10768x);
        }
        parcel.writeInt(this.f10769y);
        if (this.f10769y > 0) {
            parcel.writeIntArray(this.f10770z);
        }
        parcel.writeInt(this.B ? 1 : 0);
        parcel.writeInt(this.C ? 1 : 0);
        parcel.writeInt(this.D ? 1 : 0);
        parcel.writeList(this.A);
    }
}
