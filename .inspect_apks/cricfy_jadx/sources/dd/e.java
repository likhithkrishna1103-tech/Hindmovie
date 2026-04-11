package dd;

import android.os.Parcel;
import android.os.Parcelable;
import cd.h;
import cd.l;
import ge.i;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import sd.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable, Serializable {
    public static final d CREATOR = new d();
    public long C;
    public String I;
    public long K;
    public md.g M;
    public int N;
    public int O;
    public long P;
    public long Q;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3676v;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3680z;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f3677w = "";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f3678x = "";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f3679y = "";
    public h A = ld.a.f7950c;
    public Map B = new LinkedHashMap();
    public long D = -1;
    public l E = ld.a.f7952e;
    public cd.b F = ld.a.f7951d;
    public cd.g G = ld.a.f7948a;
    public long H = Calendar.getInstance().getTimeInMillis();
    public cd.a J = cd.a.f2143x;
    public boolean L = true;

    public e() {
        md.g.CREATOR.getClass();
        this.M = md.g.f8432w;
        this.P = -1L;
        this.Q = -1L;
    }

    public final long a() {
        return this.C;
    }

    public final long b() {
        return this.D;
    }

    public final void c(long j4) {
        this.C = j4;
    }

    public final void d(long j4) {
        this.Q = j4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e(cd.b bVar) {
        i.e(bVar, "<set-?>");
        this.F = bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!e.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        i.c(obj, "null cannot be cast to non-null type com.tonyodev.fetch2.database.DownloadInfo");
        e eVar = (e) obj;
        return this.f3676v == eVar.f3676v && i.a(this.f3677w, eVar.f3677w) && i.a(this.f3678x, eVar.f3678x) && i.a(this.f3679y, eVar.f3679y) && this.f3680z == eVar.f3680z && this.A == eVar.A && i.a(this.B, eVar.B) && this.C == eVar.C && this.D == eVar.D && this.E == eVar.E && this.F == eVar.F && this.G == eVar.G && this.H == eVar.H && i.a(this.I, eVar.I) && this.J == eVar.J && this.K == eVar.K && this.L == eVar.L && i.a(this.M, eVar.M) && this.P == eVar.P && this.Q == eVar.Q && this.N == eVar.N && this.O == eVar.O;
    }

    public final void f(long j4) {
        this.P = j4;
    }

    public final void g(String str) {
        i.e(str, "<set-?>");
        this.f3679y = str;
    }

    public final void h(String str) {
        i.e(str, "<set-?>");
        this.f3677w = str;
    }

    public final int hashCode() {
        int iHashCode = (this.B.hashCode() + ((this.A.hashCode() + ((l0.e.e(l0.e.e(l0.e.e(this.f3676v * 31, 31, this.f3677w), 31, this.f3678x), 31, this.f3679y) + this.f3680z) * 31)) * 31)) * 31;
        long j4 = this.C;
        int i = (iHashCode + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j7 = this.D;
        int iHashCode2 = (this.G.hashCode() + ((this.F.hashCode() + ((this.E.hashCode() + ((i + ((int) (j7 ^ (j7 >>> 32)))) * 31)) * 31)) * 31)) * 31;
        long j10 = this.H;
        int i10 = (iHashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        String str = this.I;
        int iHashCode3 = (this.J.hashCode() + ((i10 + (str != null ? str.hashCode() : 0)) * 31)) * 31;
        long j11 = this.K;
        int iHashCode4 = (this.M.hashCode() + ((((iHashCode3 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + (this.L ? 1231 : 1237)) * 31)) * 31;
        long j12 = this.P;
        int i11 = (iHashCode4 + ((int) (j12 ^ (j12 >>> 32)))) * 31;
        long j13 = this.Q;
        return ((((i11 + ((int) ((j13 >>> 32) ^ j13))) * 31) + this.N) * 31) + this.O;
    }

    public final void i(long j4) {
        this.D = j4;
    }

    public final void j(String str) {
        i.e(str, "<set-?>");
        this.f3678x = str;
    }

    public final String toString() {
        return "DownloadInfo(id=" + this.f3676v + ", namespace='" + this.f3677w + "', url='" + this.f3678x + "', file='" + this.f3679y + "', group=" + this.f3680z + ", priority=" + this.A + ", headers=" + this.B + ", downloaded=" + this.C + ", total=" + this.D + ", status=" + this.E + ", error=" + this.F + ", networkType=" + this.G + ", created=" + this.H + ", tag=" + this.I + ", enqueueAction=" + this.J + ", identifier=" + this.K + ", downloadOnEnqueue=" + this.L + ", extras=" + this.M + ", autoRetryMaxAttempts=" + this.N + ", autoRetryAttempts=" + this.O + ", etaInMilliSeconds=" + this.P + ", downloadedBytesPerSecond=" + this.Q + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        i.e(parcel, "dest");
        parcel.writeInt(this.f3676v);
        parcel.writeString(this.f3677w);
        parcel.writeString(this.f3678x);
        parcel.writeString(this.f3679y);
        parcel.writeInt(this.f3680z);
        parcel.writeInt(this.A.f2176v);
        parcel.writeSerializable(new HashMap(this.B));
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeInt(this.E.f2189v);
        parcel.writeInt(this.F.f2154v);
        parcel.writeInt(this.G.f2171v);
        parcel.writeLong(this.H);
        parcel.writeString(this.I);
        parcel.writeInt(this.J.f2146v);
        parcel.writeLong(this.K);
        parcel.writeInt(this.L ? 1 : 0);
        parcel.writeLong(this.P);
        parcel.writeLong(this.Q);
        parcel.writeSerializable(new HashMap(s.C(this.M.f8433v)));
        parcel.writeInt(this.N);
        parcel.writeInt(this.O);
    }
}
