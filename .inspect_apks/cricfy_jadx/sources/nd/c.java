package nd;

import android.os.Parcel;
import android.os.Parcelable;
import ge.i;
import java.io.Serializable;
import java.util.HashMap;
import md.g;
import sd.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable, Serializable {
    public static final b CREATOR = new b();
    public final String A;
    public final g B;
    public final int C;
    public final int D;
    public final boolean E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f9116v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f9117w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f9118x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f9119y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f9120z;

    public c(int i, String str, long j4, long j7, String str2, String str3, g gVar, int i10, int i11, boolean z10) {
        i.e(gVar, "extras");
        this.f9116v = i;
        this.f9117w = str;
        this.f9118x = j4;
        this.f9119y = j7;
        this.f9120z = str2;
        this.A = str3;
        this.B = gVar;
        this.C = i10;
        this.D = i11;
        this.E = z10;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder("{\"Type\":");
        sb.append(this.f9116v);
        sb.append(",\"FileResourceId\":");
        sb.append("\"" + this.f9117w + "\"");
        sb.append(",\"Range-Start\":");
        sb.append(this.f9118x);
        sb.append(",\"Range-End\":");
        sb.append(this.f9119y);
        sb.append(",\"Authorization\":");
        sb.append("\"" + this.f9120z + "\"");
        sb.append(",\"Client\":");
        sb.append("\"" + this.A + "\"");
        sb.append(",\"Extras\":");
        sb.append(this.B.a());
        sb.append(",\"Page\":");
        sb.append(this.C);
        sb.append(",\"Size\":");
        sb.append(this.D);
        sb.append(",\"Persist-Connection\":");
        sb.append(this.E);
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
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f9116v == cVar.f9116v && i.a(this.f9117w, cVar.f9117w) && this.f9118x == cVar.f9118x && this.f9119y == cVar.f9119y && i.a(this.f9120z, cVar.f9120z) && i.a(this.A, cVar.A) && i.a(this.B, cVar.B) && this.C == cVar.C && this.D == cVar.D && this.E == cVar.E;
    }

    public final int hashCode() {
        int iE = l0.e.e(this.f9116v * 31, 31, this.f9117w);
        long j4 = this.f9118x;
        int i = (iE + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j7 = this.f9119y;
        return ((((((this.B.hashCode() + l0.e.e(l0.e.e((i + ((int) (j7 ^ (j7 >>> 32)))) * 31, 31, this.f9120z), 31, this.A)) * 31) + this.C) * 31) + this.D) * 31) + (this.E ? 1231 : 1237);
    }

    public final String toString() {
        return "FileRequest(type=" + this.f9116v + ", fileResourceId=" + this.f9117w + ", rangeStart=" + this.f9118x + ", rangeEnd=" + this.f9119y + ", authorization=" + this.f9120z + ", client=" + this.A + ", extras=" + this.B + ", page=" + this.C + ", size=" + this.D + ", persistConnection=" + this.E + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        i.e(parcel, "dest");
        parcel.writeInt(this.f9116v);
        parcel.writeString(this.f9117w);
        parcel.writeLong(this.f9118x);
        parcel.writeLong(this.f9119y);
        parcel.writeString(this.f9120z);
        parcel.writeString(this.A);
        parcel.writeSerializable(new HashMap(s.C(this.B.f8433v)));
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E ? 1 : 0);
    }
}
