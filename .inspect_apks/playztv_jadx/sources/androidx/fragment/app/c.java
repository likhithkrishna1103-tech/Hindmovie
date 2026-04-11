package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a9.b(6);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList f1255u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f1256v;

    public c(Parcel parcel) {
        this.f1255u = parcel.createStringArrayList();
        this.f1256v = parcel.createTypedArrayList(b.CREATOR);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.f1255u);
        parcel.writeTypedList(this.f1256v);
    }
}
