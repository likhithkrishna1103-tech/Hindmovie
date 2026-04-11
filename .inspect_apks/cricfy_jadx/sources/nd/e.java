package nd;

import android.os.Parcel;
import android.os.Parcelable;
import ge.i;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable, Serializable {
    public static final d CREATOR = new d();
    public final String A;
    public final String B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f9121v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f9122w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f9123x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f9124y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f9125z;

    public e(int i, int i10, int i11, long j4, long j7, String str, String str2) {
        this.f9121v = i;
        this.f9122w = i10;
        this.f9123x = i11;
        this.f9124y = j4;
        this.f9125z = j7;
        this.A = str;
        this.B = str2;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder("{\"Status\":");
        sb.append(this.f9121v);
        sb.append(",\"Md5\":");
        sb.append("\"" + this.A + "\"");
        sb.append(",\"Connection\":");
        sb.append(this.f9123x);
        sb.append(",\"Date\":");
        sb.append(this.f9124y);
        sb.append(",\"Content-Length\":");
        sb.append(this.f9125z);
        sb.append(",\"Type\":");
        sb.append(this.f9122w);
        sb.append(",\"SessionId\":");
        sb.append(this.B);
        sb.append('}');
        String string = sb.toString();
        i.d(string, "toString(...)");
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
        return this.f9121v == eVar.f9121v && this.f9122w == eVar.f9122w && this.f9123x == eVar.f9123x && this.f9124y == eVar.f9124y && this.f9125z == eVar.f9125z && i.a(this.A, eVar.A) && i.a(this.B, eVar.B);
    }

    public final int hashCode() {
        int i = ((((this.f9121v * 31) + this.f9122w) * 31) + this.f9123x) * 31;
        long j4 = this.f9124y;
        int i10 = (i + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j7 = this.f9125z;
        return this.B.hashCode() + l0.e.e((i10 + ((int) (j7 ^ (j7 >>> 32)))) * 31, 31, this.A);
    }

    public final String toString() {
        StringBuilder sbR = q4.a.r(this.f9121v, this.f9122w, "FileResponse(status=", ", type=", ", connection=");
        sbR.append(this.f9123x);
        sbR.append(", date=");
        sbR.append(this.f9124y);
        sbR.append(", contentLength=");
        sbR.append(this.f9125z);
        sbR.append(", md5=");
        sbR.append(this.A);
        sbR.append(", sessionId=");
        sbR.append(this.B);
        sbR.append(")");
        return sbR.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        i.e(parcel, "dest");
        parcel.writeInt(this.f9121v);
        parcel.writeInt(this.f9122w);
        parcel.writeInt(this.f9123x);
        parcel.writeLong(this.f9124y);
        parcel.writeLong(this.f9125z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
    }
}
