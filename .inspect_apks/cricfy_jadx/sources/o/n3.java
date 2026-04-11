package o;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n3 extends a1.c {
    public static final Parcelable.Creator<n3> CREATOR = new a1.b(9);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f9279x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f9280y;

    public n3(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f9279x = parcel.readInt();
        this.f9280y = parcel.readInt() != 0;
    }

    @Override // a1.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f9279x);
        parcel.writeInt(this.f9280y ? 1 : 0);
    }
}
