package jd;

import android.os.Parcel;
import android.os.Parcelable;
import be.h;
import e6.j;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable, Serializable {
    public static final d CREATOR = new d();
    public final String A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f6950u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f6951v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f6952w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f6953x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f6954y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f6955z;

    public e(int i, int i10, int i11, long j5, long j8, String str, String str2) {
        this.f6950u = i;
        this.f6951v = i10;
        this.f6952w = i11;
        this.f6953x = j5;
        this.f6954y = j8;
        this.f6955z = str;
        this.A = str2;
    }

    public final String a() {
        StringBuilder sb2 = new StringBuilder("{\"Status\":");
        sb2.append(this.f6950u);
        sb2.append(",\"Md5\":");
        sb2.append("\"" + this.f6955z + "\"");
        sb2.append(",\"Connection\":");
        sb2.append(this.f6952w);
        sb2.append(",\"Date\":");
        sb2.append(this.f6953x);
        sb2.append(",\"Content-Length\":");
        sb2.append(this.f6954y);
        sb2.append(",\"Type\":");
        sb2.append(this.f6951v);
        sb2.append(",\"SessionId\":");
        sb2.append(this.A);
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
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f6950u == eVar.f6950u && this.f6951v == eVar.f6951v && this.f6952w == eVar.f6952w && this.f6953x == eVar.f6953x && this.f6954y == eVar.f6954y && h.a(this.f6955z, eVar.f6955z) && h.a(this.A, eVar.A);
    }

    public final int hashCode() {
        int i = ((((this.f6950u * 31) + this.f6951v) * 31) + this.f6952w) * 31;
        long j5 = this.f6953x;
        int i10 = (i + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j8 = this.f6954y;
        return this.A.hashCode() + j.h((i10 + ((int) (j8 ^ (j8 >>> 32)))) * 31, 31, this.f6955z);
    }

    public final String toString() {
        StringBuilder sbP = l4.a.p(this.f6950u, this.f6951v, "FileResponse(status=", ", type=", ", connection=");
        sbP.append(this.f6952w);
        sbP.append(", date=");
        sbP.append(this.f6953x);
        sbP.append(", contentLength=");
        sbP.append(this.f6954y);
        sbP.append(", md5=");
        sbP.append(this.f6955z);
        sbP.append(", sessionId=");
        sbP.append(this.A);
        sbP.append(")");
        return sbP.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        h.e(parcel, "dest");
        parcel.writeInt(this.f6950u);
        parcel.writeInt(this.f6951v);
        parcel.writeInt(this.f6952w);
        parcel.writeLong(this.f6953x);
        parcel.writeLong(this.f6954y);
        parcel.writeString(this.f6955z);
        parcel.writeString(this.A);
    }
}
