package cd;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import sd.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Parcelable, Serializable {
    public static final j CREATOR = new j();
    public String A;
    public a B;
    public boolean C;
    public int D;
    public md.g E;
    public final String F;
    public final String G;
    public final int H;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f2180v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2181w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final LinkedHashMap f2182x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public h f2183y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public g f2184z;

    public k(String str, String str2) {
        ge.i.e(str, "url");
        ge.i.e(str2, "file");
        this.f2182x = new LinkedHashMap();
        this.f2183y = ld.a.f7950c;
        this.f2184z = ld.a.f7948a;
        this.B = ld.a.f7953g;
        this.C = true;
        md.g.CREATOR.getClass();
        this.E = md.g.f8432w;
        this.F = str;
        this.G = str2;
        this.H = str2.hashCode() + (str.hashCode() * 31);
    }

    public final boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        ge.i.c(obj, "null cannot be cast to non-null type com.tonyodev.fetch2.RequestInfo");
        k kVar = (k) obj;
        return this.f2180v == kVar.f2180v && this.f2181w == kVar.f2181w && ge.i.a(this.f2182x, kVar.f2182x) && this.f2183y == kVar.f2183y && this.f2184z == kVar.f2184z && ge.i.a(this.A, kVar.A) && this.B == kVar.B && this.C == kVar.C && ge.i.a(this.E, kVar.E) && this.D == kVar.D;
    }

    public final int b() {
        long j4 = this.f2180v;
        int iHashCode = (this.f2184z.hashCode() + ((this.f2183y.hashCode() + ((this.f2182x.hashCode() + (((((int) (j4 ^ (j4 >>> 32))) * 31) + this.f2181w) * 31)) * 31)) * 31)) * 31;
        String str = this.A;
        return ((this.E.f8433v.hashCode() + ((((this.B.hashCode() + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31)) * 31) + (this.C ? 1231 : 1237)) * 31)) * 31) + this.D;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!k.class.equals(obj != null ? obj.getClass() : null) || !a(obj)) {
            return false;
        }
        ge.i.c(obj, "null cannot be cast to non-null type com.tonyodev.fetch2.Request");
        k kVar = (k) obj;
        return this.H == kVar.H && ge.i.a(this.F, kVar.F) && ge.i.a(this.G, kVar.G);
    }

    public final int hashCode() {
        return this.G.hashCode() + l0.e.e(((b() * 31) + this.H) * 31, 31, this.F);
    }

    public final String toString() {
        return "Request(url='" + this.F + "', file='" + this.G + "', id=" + this.H + ", groupId=" + this.f2181w + ", headers=" + this.f2182x + ", priority=" + this.f2183y + ", networkType=" + this.f2184z + ", tag=" + this.A + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ge.i.e(parcel, "parcel");
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeLong(this.f2180v);
        parcel.writeInt(this.f2181w);
        parcel.writeSerializable(new HashMap(this.f2182x));
        parcel.writeInt(this.f2183y.f2176v);
        parcel.writeInt(this.f2184z.f2171v);
        parcel.writeString(this.A);
        parcel.writeInt(this.B.f2146v);
        parcel.writeInt(this.C ? 1 : 0);
        parcel.writeSerializable(new HashMap(s.C(this.E.f8433v)));
        parcel.writeInt(this.D);
    }
}
