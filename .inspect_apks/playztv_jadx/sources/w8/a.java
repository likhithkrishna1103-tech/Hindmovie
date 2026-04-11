package w8;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import c0.g;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends x0.b {
    public static final Parcelable.Creator<a> CREATOR = new g(13);
    public final boolean A;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f13752w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f13753x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f13754y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f13755z;

    public a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f13752w = parcel.readInt();
        this.f13753x = parcel.readInt();
        this.f13754y = parcel.readInt() == 1;
        this.f13755z = parcel.readInt() == 1;
        this.A = parcel.readInt() == 1;
    }

    @Override // x0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f13752w);
        parcel.writeInt(this.f13753x);
        parcel.writeInt(this.f13754y ? 1 : 0);
        parcel.writeInt(this.f13755z ? 1 : 0);
        parcel.writeInt(this.A ? 1 : 0);
    }

    public a(BottomSheetBehavior bottomSheetBehavior) {
        super(AbsSavedState.EMPTY_STATE);
        this.f13752w = bottomSheetBehavior.f3341f0;
        this.f13753x = bottomSheetBehavior.f3363y;
        this.f13754y = bottomSheetBehavior.f3357v;
        this.f13755z = bottomSheetBehavior.f3338c0;
        this.A = bottomSheetBehavior.f3339d0;
    }
}
