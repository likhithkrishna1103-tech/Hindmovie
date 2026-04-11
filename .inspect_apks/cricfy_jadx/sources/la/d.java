package la;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends a1.c {
    public static final Parcelable.Creator<d> CREATOR = new a1.b(6);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f7947x;

    public d(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f7947x = parcel.readInt();
    }

    @Override // a1.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f7947x);
    }

    public d(SideSheetBehavior sideSheetBehavior) {
        super(AbsSavedState.EMPTY_STATE);
        this.f7947x = sideSheetBehavior.C;
    }
}
