package t9;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c0.g;
import s.i;
import x0.b;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends b {
    public static final Parcelable.Creator<a> CREATOR = new g(11);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i f12347w;

    public a(Parcelable parcelable) {
        super(parcelable);
        this.f12347w = new i(0);
    }

    public final String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f12347w + "}";
    }

    @Override // x0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        i iVar = this.f12347w;
        int i10 = iVar.f11635w;
        parcel.writeInt(i10);
        String[] strArr = new String[i10];
        Bundle[] bundleArr = new Bundle[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            strArr[i11] = (String) iVar.f(i11);
            bundleArr[i11] = (Bundle) iVar.j(i11);
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
        this.f12347w = new i(i);
        for (int i10 = 0; i10 < i; i10++) {
            this.f12347w.put(strArr[i10], bundleArr[i10]);
        }
    }
}
