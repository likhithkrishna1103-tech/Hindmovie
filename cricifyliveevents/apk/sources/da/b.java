package da;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a1.c {
    public static final Parcelable.Creator<b> CREATOR = new a1.b(1);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f3566x;

    public b(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f3566x = parcel.readInt() == 1;
    }

    @Override // a1.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f3566x ? 1 : 0);
    }
}
