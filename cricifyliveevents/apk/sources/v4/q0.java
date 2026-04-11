package v4;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 extends a1.c {
    public static final Parcelable.Creator<q0> CREATOR = new a1.b(14);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Parcelable f13336x;

    public q0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f13336x = parcel.readParcelable(classLoader == null ? h0.class.getClassLoader() : classLoader);
    }

    @Override // a1.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f13336x, 0);
    }
}
