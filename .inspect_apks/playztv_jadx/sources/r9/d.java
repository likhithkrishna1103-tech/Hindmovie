package r9;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import c0.g;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends x0.b {
    public static final Parcelable.Creator<d> CREATOR = new g(10);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f11559w;

    public d(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f11559w = parcel.readInt();
    }

    @Override // x0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f11559w);
    }

    public d(SideSheetBehavior sideSheetBehavior) {
        super(AbsSavedState.EMPTY_STATE);
        this.f11559w = sideSheetBehavior.B;
    }
}
