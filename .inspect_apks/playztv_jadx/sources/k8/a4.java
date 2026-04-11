package k8;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a4 extends u7.a {
    public static final Parcelable.Creator<a4> CREATOR = new x(3);
    public final String A;
    public final boolean B;
    public final boolean C;
    public final long D;
    public final String E;
    public final long F;
    public final long G;
    public final int H;
    public final boolean I;
    public final boolean J;
    public final String K;
    public final Boolean L;
    public final long M;
    public final List N;
    public final String O;
    public final String P;
    public final String Q;
    public final String R;
    public final boolean S;
    public final long T;
    public final int U;
    public final String V;
    public final int W;
    public final long X;
    public final String Y;
    public final String Z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f7076u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f7077v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f7078w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f7079x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f7080y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f7081z;

    public a4(String str, String str2, String str3, long j5, String str4, long j8, long j10, String str5, boolean z2, boolean z10, String str6, long j11, int i, boolean z11, boolean z12, String str7, Boolean bool, long j12, List list, String str8, String str9, String str10, boolean z13, long j13, int i10, String str11, int i11, long j14, String str12, String str13) {
        t7.v.d(str);
        this.f7076u = str;
        this.f7077v = TextUtils.isEmpty(str2) ? null : str2;
        this.f7078w = str3;
        this.D = j5;
        this.f7079x = str4;
        this.f7080y = j8;
        this.f7081z = j10;
        this.A = str5;
        this.B = z2;
        this.C = z10;
        this.E = str6;
        this.F = 0L;
        this.G = j11;
        this.H = i;
        this.I = z11;
        this.J = z12;
        this.K = str7;
        this.L = bool;
        this.M = j12;
        this.N = list;
        this.O = null;
        this.P = str8;
        this.Q = str9;
        this.R = str10;
        this.S = z13;
        this.T = j13;
        this.U = i10;
        this.V = str11;
        this.W = i11;
        this.X = j14;
        this.Y = str12;
        this.Z = str13;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = wa.t1.E(parcel, 20293);
        wa.t1.C(parcel, 2, this.f7076u);
        wa.t1.C(parcel, 3, this.f7077v);
        wa.t1.C(parcel, 4, this.f7078w);
        wa.t1.C(parcel, 5, this.f7079x);
        wa.t1.H(parcel, 6, 8);
        parcel.writeLong(this.f7080y);
        wa.t1.H(parcel, 7, 8);
        parcel.writeLong(this.f7081z);
        wa.t1.C(parcel, 8, this.A);
        wa.t1.H(parcel, 9, 4);
        parcel.writeInt(this.B ? 1 : 0);
        wa.t1.H(parcel, 10, 4);
        parcel.writeInt(this.C ? 1 : 0);
        wa.t1.H(parcel, 11, 8);
        parcel.writeLong(this.D);
        wa.t1.C(parcel, 12, this.E);
        wa.t1.H(parcel, 13, 8);
        parcel.writeLong(this.F);
        wa.t1.H(parcel, 14, 8);
        parcel.writeLong(this.G);
        wa.t1.H(parcel, 15, 4);
        parcel.writeInt(this.H);
        wa.t1.H(parcel, 16, 4);
        parcel.writeInt(this.I ? 1 : 0);
        wa.t1.H(parcel, 18, 4);
        parcel.writeInt(this.J ? 1 : 0);
        wa.t1.C(parcel, 19, this.K);
        Boolean bool = this.L;
        if (bool != null) {
            wa.t1.H(parcel, 21, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        wa.t1.H(parcel, 22, 8);
        parcel.writeLong(this.M);
        List<String> list = this.N;
        if (list != null) {
            int iE2 = wa.t1.E(parcel, 23);
            parcel.writeStringList(list);
            wa.t1.G(parcel, iE2);
        }
        wa.t1.C(parcel, 24, this.O);
        wa.t1.C(parcel, 25, this.P);
        wa.t1.C(parcel, 26, this.Q);
        wa.t1.C(parcel, 27, this.R);
        wa.t1.H(parcel, 28, 4);
        parcel.writeInt(this.S ? 1 : 0);
        wa.t1.H(parcel, 29, 8);
        parcel.writeLong(this.T);
        wa.t1.H(parcel, 30, 4);
        parcel.writeInt(this.U);
        wa.t1.C(parcel, 31, this.V);
        wa.t1.H(parcel, 32, 4);
        parcel.writeInt(this.W);
        wa.t1.H(parcel, 34, 8);
        parcel.writeLong(this.X);
        wa.t1.C(parcel, 35, this.Y);
        wa.t1.C(parcel, 36, this.Z);
        wa.t1.G(parcel, iE);
    }

    public a4(String str, String str2, String str3, String str4, long j5, long j8, String str5, boolean z2, boolean z10, long j10, String str6, long j11, long j12, int i, boolean z11, boolean z12, String str7, Boolean bool, long j13, ArrayList arrayList, String str8, String str9, String str10, String str11, boolean z13, long j14, int i10, String str12, int i11, long j15, String str13, String str14) {
        this.f7076u = str;
        this.f7077v = str2;
        this.f7078w = str3;
        this.D = j10;
        this.f7079x = str4;
        this.f7080y = j5;
        this.f7081z = j8;
        this.A = str5;
        this.B = z2;
        this.C = z10;
        this.E = str6;
        this.F = j11;
        this.G = j12;
        this.H = i;
        this.I = z11;
        this.J = z12;
        this.K = str7;
        this.L = bool;
        this.M = j13;
        this.N = arrayList;
        this.O = str8;
        this.P = str9;
        this.Q = str10;
        this.R = str11;
        this.S = z13;
        this.T = j14;
        this.U = i10;
        this.V = str12;
        this.W = i11;
        this.X = j15;
        this.Y = str13;
        this.Z = str14;
    }
}
