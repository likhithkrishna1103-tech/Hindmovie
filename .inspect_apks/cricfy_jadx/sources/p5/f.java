package p5;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends a1.c {
    public static final Parcelable.Creator<f> CREATOR = new a1.b(10);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f10000x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Parcelable f10001y;

    public f(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        classLoader = classLoader == null ? f.class.getClassLoader() : classLoader;
        this.f10000x = parcel.readInt();
        this.f10001y = parcel.readParcelable(classLoader);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentPager.SavedState{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" position=");
        return q4.a.o(sb, this.f10000x, "}");
    }

    @Override // a1.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f10000x);
        parcel.writeParcelable(this.f10001y, i);
    }
}
