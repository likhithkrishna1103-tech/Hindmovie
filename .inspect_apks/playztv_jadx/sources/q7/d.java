package q7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import k8.x;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends u7.a {
    public static final Parcelable.Creator<d> CREATOR = new x(14);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f11034u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f11035v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f11036w;

    public d() {
        this.f11034u = "CLIENT_TELEMETRY";
        this.f11036w = 1L;
        this.f11035v = -1;
    }

    public final long b() {
        long j5 = this.f11036w;
        return j5 == -1 ? this.f11035v : j5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str = dVar.f11034u;
            String str2 = this.f11034u;
            if (((str2 != null && str2.equals(str)) || (str2 == null && str == null)) && b() == dVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11034u, Long.valueOf(b())});
    }

    public final String toString() {
        p2.c cVar = new p2.c(this);
        cVar.b(this.f11034u, "name");
        cVar.b(Long.valueOf(b()), "version");
        return cVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = t1.E(parcel, 20293);
        t1.C(parcel, 1, this.f11034u);
        t1.H(parcel, 2, 4);
        parcel.writeInt(this.f11035v);
        long jB = b();
        t1.H(parcel, 3, 8);
        parcel.writeLong(jB);
        t1.G(parcel, iE);
    }

    public d(int i, long j5, String str) {
        this.f11034u = str;
        this.f11035v = i;
        this.f11036w = j5;
    }
}
