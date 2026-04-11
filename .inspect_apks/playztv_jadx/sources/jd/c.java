package jd;

import android.os.Parcel;
import android.os.Parcelable;
import be.h;
import e6.j;
import id.g;
import java.io.Serializable;
import java.util.HashMap;
import od.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable, Serializable {
    public static final b CREATOR = new b();
    public final g A;
    public final int B;
    public final int C;
    public final boolean D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f6944u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f6945v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f6946w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f6947x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f6948y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f6949z;

    public c(int i, String str, long j5, long j8, String str2, String str3, g gVar, int i10, int i11, boolean z2) {
        h.e(gVar, "extras");
        this.f6944u = i;
        this.f6945v = str;
        this.f6946w = j5;
        this.f6947x = j8;
        this.f6948y = str2;
        this.f6949z = str3;
        this.A = gVar;
        this.B = i10;
        this.C = i11;
        this.D = z2;
    }

    public final String a() {
        StringBuilder sb2 = new StringBuilder("{\"Type\":");
        sb2.append(this.f6944u);
        sb2.append(",\"FileResourceId\":");
        sb2.append("\"" + this.f6945v + "\"");
        sb2.append(",\"Range-Start\":");
        sb2.append(this.f6946w);
        sb2.append(",\"Range-End\":");
        sb2.append(this.f6947x);
        sb2.append(",\"Authorization\":");
        sb2.append("\"" + this.f6948y + "\"");
        sb2.append(",\"Client\":");
        sb2.append("\"" + this.f6949z + "\"");
        sb2.append(",\"Extras\":");
        sb2.append(this.A.a());
        sb2.append(",\"Page\":");
        sb2.append(this.B);
        sb2.append(",\"Size\":");
        sb2.append(this.C);
        sb2.append(",\"Persist-Connection\":");
        sb2.append(this.D);
        sb2.append('}');
        String string = sb2.toString();
        h.d(string, "toString(...)");
        return string;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f6944u == cVar.f6944u && h.a(this.f6945v, cVar.f6945v) && this.f6946w == cVar.f6946w && this.f6947x == cVar.f6947x && h.a(this.f6948y, cVar.f6948y) && h.a(this.f6949z, cVar.f6949z) && h.a(this.A, cVar.A) && this.B == cVar.B && this.C == cVar.C && this.D == cVar.D;
    }

    public final int hashCode() {
        int iH = j.h(this.f6944u * 31, 31, this.f6945v);
        long j5 = this.f6946w;
        int i = (iH + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j8 = this.f6947x;
        return ((((((this.A.hashCode() + j.h(j.h((i + ((int) (j8 ^ (j8 >>> 32)))) * 31, 31, this.f6948y), 31, this.f6949z)) * 31) + this.B) * 31) + this.C) * 31) + (this.D ? 1231 : 1237);
    }

    public final String toString() {
        return "FileRequest(type=" + this.f6944u + ", fileResourceId=" + this.f6945v + ", rangeStart=" + this.f6946w + ", rangeEnd=" + this.f6947x + ", authorization=" + this.f6948y + ", client=" + this.f6949z + ", extras=" + this.A + ", page=" + this.B + ", size=" + this.C + ", persistConnection=" + this.D + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "dest");
        parcel.writeInt(this.f6944u);
        parcel.writeString(this.f6945v);
        parcel.writeLong(this.f6946w);
        parcel.writeLong(this.f6947x);
        parcel.writeString(this.f6948y);
        parcel.writeString(this.f6949z);
        parcel.writeSerializable(new HashMap(t.J(this.A.f6577u)));
        parcel.writeInt(this.B);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D ? 1 : 0);
    }
}
