package j9;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends x0.b {
    public static final Parcelable.Creator<b> CREATOR = new c0.g(2);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6842w;

    public b(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f6842w = parcel.readInt() == 1;
    }

    @Override // x0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f6842w ? 1 : 0);
    }
}
