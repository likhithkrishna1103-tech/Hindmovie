package k5;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends x0.b {
    public static final Parcelable.Creator<h> CREATOR = new c0.g(4);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f7030w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Parcelable f7031x;

    public h(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        classLoader = classLoader == null ? h.class.getClassLoader() : classLoader;
        this.f7030w = parcel.readInt();
        this.f7031x = parcel.readParcelable(classLoader);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentPager.SavedState{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" position=");
        return x.c.a(sb2, this.f7030w, "}");
    }

    @Override // x0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f7030w);
        parcel.writeParcelable(this.f7031x, i);
    }
}
