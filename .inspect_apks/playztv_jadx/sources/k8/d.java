package k8;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends u7.a {
    public static final Parcelable.Creator<d> CREATOR = new a9.b(27);
    public final v A;
    public long B;
    public v C;
    public final long D;
    public final v E;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f7128u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f7129v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public e4 f7130w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f7131x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f7132y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f7133z;

    public d(String str, String str2, e4 e4Var, long j5, boolean z2, String str3, v vVar, long j8, v vVar2, long j10, v vVar3) {
        this.f7128u = str;
        this.f7129v = str2;
        this.f7130w = e4Var;
        this.f7131x = j5;
        this.f7132y = z2;
        this.f7133z = str3;
        this.A = vVar;
        this.B = j8;
        this.C = vVar2;
        this.D = j10;
        this.E = vVar3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = wa.t1.E(parcel, 20293);
        wa.t1.C(parcel, 2, this.f7128u);
        wa.t1.C(parcel, 3, this.f7129v);
        wa.t1.B(parcel, 4, this.f7130w, i);
        long j5 = this.f7131x;
        wa.t1.H(parcel, 5, 8);
        parcel.writeLong(j5);
        boolean z2 = this.f7132y;
        wa.t1.H(parcel, 6, 4);
        parcel.writeInt(z2 ? 1 : 0);
        wa.t1.C(parcel, 7, this.f7133z);
        wa.t1.B(parcel, 8, this.A, i);
        long j8 = this.B;
        wa.t1.H(parcel, 9, 8);
        parcel.writeLong(j8);
        wa.t1.B(parcel, 10, this.C, i);
        wa.t1.H(parcel, 11, 8);
        parcel.writeLong(this.D);
        wa.t1.B(parcel, 12, this.E, i);
        wa.t1.G(parcel, iE);
    }

    public d(d dVar) {
        t7.v.h(dVar);
        this.f7128u = dVar.f7128u;
        this.f7129v = dVar.f7129v;
        this.f7130w = dVar.f7130w;
        this.f7131x = dVar.f7131x;
        this.f7132y = dVar.f7132y;
        this.f7133z = dVar.f7133z;
        this.A = dVar.A;
        this.B = dVar.B;
        this.C = dVar.C;
        this.D = dVar.D;
        this.E = dVar.E;
    }
}
