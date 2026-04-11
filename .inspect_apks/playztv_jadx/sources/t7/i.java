package t7;

import android.os.Parcel;
import android.os.Parcelable;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends u7.a {
    public static final Parcelable.Creator<i> CREATOR = new k8.x(20);
    public final String A;
    public final int B;
    public final int C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f12306u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f12307v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f12308w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f12309x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f12310y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f12311z;

    public i(int i, int i10, int i11, long j5, long j8, String str, String str2, int i12, int i13) {
        this.f12306u = i;
        this.f12307v = i10;
        this.f12308w = i11;
        this.f12309x = j5;
        this.f12310y = j8;
        this.f12311z = str;
        this.A = str2;
        this.B = i12;
        this.C = i13;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = t1.E(parcel, 20293);
        t1.H(parcel, 1, 4);
        parcel.writeInt(this.f12306u);
        t1.H(parcel, 2, 4);
        parcel.writeInt(this.f12307v);
        t1.H(parcel, 3, 4);
        parcel.writeInt(this.f12308w);
        t1.H(parcel, 4, 8);
        parcel.writeLong(this.f12309x);
        t1.H(parcel, 5, 8);
        parcel.writeLong(this.f12310y);
        t1.C(parcel, 6, this.f12311z);
        t1.C(parcel, 7, this.A);
        t1.H(parcel, 8, 4);
        parcel.writeInt(this.B);
        t1.H(parcel, 9, 4);
        parcel.writeInt(this.C);
        t1.G(parcel, iE);
    }
}
