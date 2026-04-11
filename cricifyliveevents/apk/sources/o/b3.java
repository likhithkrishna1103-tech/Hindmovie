package o;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b3 extends a1.c {
    public static final Parcelable.Creator<b3> CREATOR = new a1.b(8);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f9184x;

    public b3(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f9184x = ((Boolean) parcel.readValue(null)).booleanValue();
    }

    public final String toString() {
        return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f9184x + "}";
    }

    @Override // a1.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(Boolean.valueOf(this.f9184x));
    }
}
