package zc;

import android.os.Parcel;
import android.os.Parcelable;
import be.h;
import e6.j;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import od.t;
import yc.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable, Serializable {
    public static final d CREATOR = new d();
    public long B;
    public String H;
    public long J;
    public id.g L;
    public int M;
    public int N;
    public long O;
    public long P;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f14950u;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f14954y;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f14951v = "";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f14952w = "";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f14953x = "";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public yc.g f14955z = hd.a.f6070c;
    public Map A = new LinkedHashMap();
    public long C = -1;
    public k D = hd.a.f6072e;
    public yc.b E = hd.a.f6071d;
    public yc.f F = hd.a.f6068a;
    public long G = Calendar.getInstance().getTimeInMillis();
    public yc.a I = yc.a.f14641w;
    public boolean K = true;

    public e() {
        id.g.CREATOR.getClass();
        this.L = id.g.f6576v;
        this.O = -1L;
        this.P = -1L;
    }

    public final long a() {
        return this.B;
    }

    public final long b() {
        return this.C;
    }

    public final void c(long j5) {
        this.B = j5;
    }

    public final void d(long j5) {
        this.P = j5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e(yc.b bVar) {
        h.e(bVar, "<set-?>");
        this.E = bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!e.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        h.c(obj, "null cannot be cast to non-null type com.tonyodev.fetch2.database.DownloadInfo");
        e eVar = (e) obj;
        return this.f14950u == eVar.f14950u && h.a(this.f14951v, eVar.f14951v) && h.a(this.f14952w, eVar.f14952w) && h.a(this.f14953x, eVar.f14953x) && this.f14954y == eVar.f14954y && this.f14955z == eVar.f14955z && h.a(this.A, eVar.A) && this.B == eVar.B && this.C == eVar.C && this.D == eVar.D && this.E == eVar.E && this.F == eVar.F && this.G == eVar.G && h.a(this.H, eVar.H) && this.I == eVar.I && this.J == eVar.J && this.K == eVar.K && h.a(this.L, eVar.L) && this.O == eVar.O && this.P == eVar.P && this.M == eVar.M && this.N == eVar.N;
    }

    public final void f(long j5) {
        this.O = j5;
    }

    public final void g(String str) {
        h.e(str, "<set-?>");
        this.f14953x = str;
    }

    public final void h(String str) {
        h.e(str, "<set-?>");
        this.f14951v = str;
    }

    public final int hashCode() {
        int iHashCode = (this.A.hashCode() + ((this.f14955z.hashCode() + ((j.h(j.h(j.h(this.f14950u * 31, 31, this.f14951v), 31, this.f14952w), 31, this.f14953x) + this.f14954y) * 31)) * 31)) * 31;
        long j5 = this.B;
        int i = (iHashCode + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j8 = this.C;
        int iHashCode2 = (this.F.hashCode() + ((this.E.hashCode() + ((this.D.hashCode() + ((i + ((int) (j8 ^ (j8 >>> 32)))) * 31)) * 31)) * 31)) * 31;
        long j10 = this.G;
        int i10 = (iHashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        String str = this.H;
        int iHashCode3 = (this.I.hashCode() + ((i10 + (str != null ? str.hashCode() : 0)) * 31)) * 31;
        long j11 = this.J;
        int iHashCode4 = (this.L.hashCode() + ((((iHashCode3 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + (this.K ? 1231 : 1237)) * 31)) * 31;
        long j12 = this.O;
        int i11 = (iHashCode4 + ((int) (j12 ^ (j12 >>> 32)))) * 31;
        long j13 = this.P;
        return ((((i11 + ((int) ((j13 >>> 32) ^ j13))) * 31) + this.M) * 31) + this.N;
    }

    public final void i(long j5) {
        this.C = j5;
    }

    public final void j(String str) {
        h.e(str, "<set-?>");
        this.f14952w = str;
    }

    public final String toString() {
        return "DownloadInfo(id=" + this.f14950u + ", namespace='" + this.f14951v + "', url='" + this.f14952w + "', file='" + this.f14953x + "', group=" + this.f14954y + ", priority=" + this.f14955z + ", headers=" + this.A + ", downloaded=" + this.B + ", total=" + this.C + ", status=" + this.D + ", error=" + this.E + ", networkType=" + this.F + ", created=" + this.G + ", tag=" + this.H + ", enqueueAction=" + this.I + ", identifier=" + this.J + ", downloadOnEnqueue=" + this.K + ", extras=" + this.L + ", autoRetryMaxAttempts=" + this.M + ", autoRetryAttempts=" + this.N + ", etaInMilliSeconds=" + this.O + ", downloadedBytesPerSecond=" + this.P + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "dest");
        parcel.writeInt(this.f14950u);
        parcel.writeString(this.f14951v);
        parcel.writeString(this.f14952w);
        parcel.writeString(this.f14953x);
        parcel.writeInt(this.f14954y);
        parcel.writeInt(this.f14955z.f14677u);
        parcel.writeSerializable(new HashMap(this.A));
        parcel.writeLong(this.B);
        parcel.writeLong(this.C);
        parcel.writeInt(this.D.f14692u);
        parcel.writeInt(this.E.f14653u);
        parcel.writeInt(this.F.f14671u);
        parcel.writeLong(this.G);
        parcel.writeString(this.H);
        parcel.writeInt(this.I.f14645u);
        parcel.writeLong(this.J);
        parcel.writeInt(this.K ? 1 : 0);
        parcel.writeLong(this.O);
        parcel.writeLong(this.P);
        parcel.writeSerializable(new HashMap(t.J(this.L.f6577u)));
        parcel.writeInt(this.M);
        parcel.writeInt(this.N);
    }
}
