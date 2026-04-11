package k8;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v extends u7.a {
    public static final Parcelable.Creator<v> CREATOR = new x(0);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f7444u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final u f7445v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f7446w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f7447x;

    public v(String str, u uVar, String str2, long j5) {
        this.f7444u = str;
        this.f7445v = uVar;
        this.f7446w = str2;
        this.f7447x = j5;
    }

    public final String toString() {
        return "origin=" + this.f7446w + ",name=" + this.f7444u + ",params=" + String.valueOf(this.f7445v);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = wa.t1.E(parcel, 20293);
        wa.t1.C(parcel, 2, this.f7444u);
        wa.t1.B(parcel, 3, this.f7445v, i);
        wa.t1.C(parcel, 4, this.f7446w);
        wa.t1.H(parcel, 5, 8);
        parcel.writeLong(this.f7447x);
        wa.t1.G(parcel, iE);
    }

    public v(v vVar, long j5) {
        t7.v.h(vVar);
        this.f7444u = vVar.f7444u;
        this.f7445v = vVar.f7445v;
        this.f7446w = vVar.f7446w;
        this.f7447x = j5;
    }
}
