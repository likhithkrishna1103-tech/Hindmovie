package fa;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends a1.c {
    public static final Parcelable.Creator<g> CREATOR = new a1.b(4);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Bundle f4527x;

    public g(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f4527x = parcel.readBundle(classLoader);
    }

    @Override // a1.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeBundle(this.f4527x);
    }
}
