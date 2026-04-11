package f9;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w4 extends p8.a {
    public static final Parcelable.Creator<w4> CREATOR = new android.support.v4.media.a(26);
    public final long A;
    public final String B;
    public final boolean C;
    public final boolean D;
    public final long E;
    public final String F;
    public final long G;
    public final int H;
    public final boolean I;
    public final boolean J;
    public final Boolean K;
    public final long L;
    public final List M;
    public final String N;
    public final String O;
    public final String P;
    public final boolean Q;
    public final long R;
    public final int S;
    public final String T;
    public final int U;
    public final long V;
    public final String W;
    public final String X;
    public final long Y;
    public final int Z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f4462v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f4463w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f4464x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f4465y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f4466z;

    public w4(String str, String str2, String str3, long j4, String str4, long j7, long j10, String str5, boolean z10, boolean z11, String str6, long j11, int i, boolean z12, boolean z13, Boolean bool, long j12, List list, String str7, String str8, String str9, boolean z14, long j13, int i10, String str10, int i11, long j14, String str11, String str12, long j15, int i12) {
        o8.u.d(str);
        this.f4462v = str;
        this.f4463w = true == TextUtils.isEmpty(str2) ? null : str2;
        this.f4464x = str3;
        this.E = j4;
        this.f4465y = str4;
        this.f4466z = j7;
        this.A = j10;
        this.B = str5;
        this.C = z10;
        this.D = z11;
        this.F = str6;
        this.G = j11;
        this.H = i;
        this.I = z12;
        this.J = z13;
        this.K = bool;
        this.L = j12;
        this.M = list;
        this.N = str7;
        this.O = str8;
        this.P = str9;
        this.Q = z14;
        this.R = j13;
        this.S = i10;
        this.T = str10;
        this.U = i11;
        this.V = j14;
        this.W = str11;
        this.X = str12;
        this.Y = j15;
        this.Z = i12;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = qb.t1.w(parcel, 20293);
        qb.t1.r(parcel, 2, this.f4462v);
        qb.t1.r(parcel, 3, this.f4463w);
        qb.t1.r(parcel, 4, this.f4464x);
        qb.t1.r(parcel, 5, this.f4465y);
        qb.t1.v(parcel, 6, 8);
        parcel.writeLong(this.f4466z);
        qb.t1.v(parcel, 7, 8);
        parcel.writeLong(this.A);
        qb.t1.r(parcel, 8, this.B);
        qb.t1.v(parcel, 9, 4);
        parcel.writeInt(this.C ? 1 : 0);
        qb.t1.v(parcel, 10, 4);
        parcel.writeInt(this.D ? 1 : 0);
        qb.t1.v(parcel, 11, 8);
        parcel.writeLong(this.E);
        qb.t1.r(parcel, 12, this.F);
        qb.t1.v(parcel, 14, 8);
        parcel.writeLong(this.G);
        qb.t1.v(parcel, 15, 4);
        parcel.writeInt(this.H);
        qb.t1.v(parcel, 16, 4);
        parcel.writeInt(this.I ? 1 : 0);
        qb.t1.v(parcel, 18, 4);
        parcel.writeInt(this.J ? 1 : 0);
        Boolean bool = this.K;
        if (bool != null) {
            qb.t1.v(parcel, 21, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        qb.t1.v(parcel, 22, 8);
        parcel.writeLong(this.L);
        List<String> list = this.M;
        if (list != null) {
            int iW2 = qb.t1.w(parcel, 23);
            parcel.writeStringList(list);
            qb.t1.y(parcel, iW2);
        }
        qb.t1.r(parcel, 25, this.N);
        qb.t1.r(parcel, 26, this.O);
        qb.t1.r(parcel, 27, this.P);
        qb.t1.v(parcel, 28, 4);
        parcel.writeInt(this.Q ? 1 : 0);
        qb.t1.v(parcel, 29, 8);
        parcel.writeLong(this.R);
        qb.t1.v(parcel, 30, 4);
        parcel.writeInt(this.S);
        qb.t1.r(parcel, 31, this.T);
        qb.t1.v(parcel, 32, 4);
        parcel.writeInt(this.U);
        qb.t1.v(parcel, 34, 8);
        parcel.writeLong(this.V);
        qb.t1.r(parcel, 35, this.W);
        qb.t1.r(parcel, 36, this.X);
        qb.t1.v(parcel, 37, 8);
        parcel.writeLong(this.Y);
        qb.t1.v(parcel, 38, 4);
        parcel.writeInt(this.Z);
        qb.t1.y(parcel, iW);
    }

    public w4(String str, String str2, String str3, String str4, long j4, long j7, String str5, boolean z10, boolean z11, long j10, String str6, long j11, int i, boolean z12, boolean z13, Boolean bool, long j12, ArrayList arrayList, String str7, String str8, String str9, boolean z14, long j13, int i10, String str10, int i11, long j14, String str11, String str12, long j15, int i12) {
        this.f4462v = str;
        this.f4463w = str2;
        this.f4464x = str3;
        this.E = j10;
        this.f4465y = str4;
        this.f4466z = j4;
        this.A = j7;
        this.B = str5;
        this.C = z10;
        this.D = z11;
        this.F = str6;
        this.G = j11;
        this.H = i;
        this.I = z12;
        this.J = z13;
        this.K = bool;
        this.L = j12;
        this.M = arrayList;
        this.N = str7;
        this.O = str8;
        this.P = str9;
        this.Q = z14;
        this.R = j13;
        this.S = i10;
        this.T = str10;
        this.U = i11;
        this.V = j14;
        this.W = str11;
        this.X = str12;
        this.Y = j15;
        this.Z = i12;
    }
}
