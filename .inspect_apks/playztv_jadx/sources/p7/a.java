package p7;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends u7.a {
    public static final Parcelable.Creator<a> CREATOR = new c(0);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Intent f10247u;

    public a(Intent intent) {
        this.f10247u = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = t1.E(parcel, 20293);
        t1.B(parcel, 1, this.f10247u, i);
        t1.G(parcel, iE);
    }
}
