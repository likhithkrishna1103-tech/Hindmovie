package yc;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import od.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Parcelable, Serializable {
    public static final i CREATOR = new i();
    public a A;
    public boolean B;
    public int C;
    public id.g D;
    public final String E;
    public final String F;
    public final int G;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f14681u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f14682v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final LinkedHashMap f14683w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public g f14684x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public f f14685y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f14686z;

    public j(String str, String str2) {
        be.h.e(str, "url");
        be.h.e(str2, "file");
        this.f14683w = new LinkedHashMap();
        this.f14684x = hd.a.f6070c;
        this.f14685y = hd.a.f6068a;
        this.A = hd.a.f6073g;
        this.B = true;
        id.g.CREATOR.getClass();
        this.D = id.g.f6576v;
        this.E = str;
        this.F = str2;
        this.G = str2.hashCode() + (str.hashCode() * 31);
    }

    public final boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        be.h.c(obj, "null cannot be cast to non-null type com.tonyodev.fetch2.RequestInfo");
        j jVar = (j) obj;
        return this.f14681u == jVar.f14681u && this.f14682v == jVar.f14682v && be.h.a(this.f14683w, jVar.f14683w) && this.f14684x == jVar.f14684x && this.f14685y == jVar.f14685y && be.h.a(this.f14686z, jVar.f14686z) && this.A == jVar.A && this.B == jVar.B && be.h.a(this.D, jVar.D) && this.C == jVar.C;
    }

    public final int b() {
        long j5 = this.f14681u;
        int iHashCode = (this.f14685y.hashCode() + ((this.f14684x.hashCode() + ((this.f14683w.hashCode() + (((((int) (j5 ^ (j5 >>> 32))) * 31) + this.f14682v) * 31)) * 31)) * 31)) * 31;
        String str = this.f14686z;
        return ((this.D.f6577u.hashCode() + ((((this.A.hashCode() + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31)) * 31) + (this.B ? 1231 : 1237)) * 31)) * 31) + this.C;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!j.class.equals(obj != null ? obj.getClass() : null) || !a(obj)) {
            return false;
        }
        be.h.c(obj, "null cannot be cast to non-null type com.tonyodev.fetch2.Request");
        j jVar = (j) obj;
        return this.G == jVar.G && be.h.a(this.E, jVar.E) && be.h.a(this.F, jVar.F);
    }

    public final int hashCode() {
        return this.F.hashCode() + e6.j.h(((b() * 31) + this.G) * 31, 31, this.E);
    }

    public final String toString() {
        return "Request(url='" + this.E + "', file='" + this.F + "', id=" + this.G + ", groupId=" + this.f14682v + ", headers=" + this.f14683w + ", priority=" + this.f14684x + ", networkType=" + this.f14685y + ", tag=" + this.f14686z + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        be.h.e(parcel, "parcel");
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeLong(this.f14681u);
        parcel.writeInt(this.f14682v);
        parcel.writeSerializable(new HashMap(this.f14683w));
        parcel.writeInt(this.f14684x.f14677u);
        parcel.writeInt(this.f14685y.f14671u);
        parcel.writeString(this.f14686z);
        parcel.writeInt(this.A.f14645u);
        parcel.writeInt(this.B ? 1 : 0);
        parcel.writeSerializable(new HashMap(t.J(this.D.f6577u)));
        parcel.writeInt(this.C);
    }
}
