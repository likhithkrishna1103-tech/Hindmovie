package l8;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import nb.w;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends p8.a {
    public static final Parcelable.Creator<d> CREATOR = new l4.p(9);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f7884v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f7885w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f7886x;

    public d() {
        this.f7884v = "CLIENT_TELEMETRY";
        this.f7886x = 1L;
        this.f7885w = -1;
    }

    public final long a() {
        long j4 = this.f7886x;
        return j4 == -1 ? this.f7885w : j4;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str = dVar.f7884v;
            String str2 = this.f7884v;
            if (((str2 != null && str2.equals(str)) || (str2 == null && str == null)) && a() == dVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7884v, Long.valueOf(a())});
    }

    public final String toString() {
        w wVar = new w(this);
        wVar.v(this.f7884v, "name");
        wVar.v(Long.valueOf(a()), "version");
        return wVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = t1.w(parcel, 20293);
        t1.r(parcel, 1, this.f7884v);
        t1.v(parcel, 2, 4);
        parcel.writeInt(this.f7885w);
        long jA = a();
        t1.v(parcel, 3, 8);
        parcel.writeLong(jA);
        t1.y(parcel, iW);
    }

    public d(int i, long j4, String str) {
        this.f7884v = str;
        this.f7885w = i;
        this.f7886x = j4;
    }
}
