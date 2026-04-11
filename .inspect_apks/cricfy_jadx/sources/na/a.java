package na;

import a1.b;
import a1.c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import v.k;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends c {
    public static final Parcelable.Creator<a> CREATOR = new b(7);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final k f8921x;

    public a(Parcelable parcelable) {
        super(parcelable);
        this.f8921x = new k(0);
    }

    public final String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f8921x + "}";
    }

    @Override // a1.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        k kVar = this.f8921x;
        int i10 = kVar.f12542x;
        parcel.writeInt(i10);
        String[] strArr = new String[i10];
        Bundle[] bundleArr = new Bundle[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            strArr[i11] = (String) kVar.f(i11);
            bundleArr[i11] = (Bundle) kVar.j(i11);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int i = parcel.readInt();
        String[] strArr = new String[i];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[i];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f8921x = new k(i);
        for (int i10 = 0; i10 < i; i10++) {
            this.f8921x.put(strArr[i10], bundleArr[i10]);
        }
    }
}
