package q9;

import a1.c;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends c {
    public static final Parcelable.Creator<a> CREATOR = new a1.b(12);
    public final boolean A;
    public final boolean B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f10457x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f10458y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f10459z;

    public a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f10457x = parcel.readInt();
        this.f10458y = parcel.readInt();
        this.f10459z = parcel.readInt() == 1;
        this.A = parcel.readInt() == 1;
        this.B = parcel.readInt() == 1;
    }

    @Override // a1.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f10457x);
        parcel.writeInt(this.f10458y);
        parcel.writeInt(this.f10459z ? 1 : 0);
        parcel.writeInt(this.A ? 1 : 0);
        parcel.writeInt(this.B ? 1 : 0);
    }

    public a(BottomSheetBehavior bottomSheetBehavior) {
        super(AbsSavedState.EMPTY_STATE);
        this.f10457x = bottomSheetBehavior.f2797i0;
        this.f10458y = bottomSheetBehavior.f2817z;
        this.f10459z = bottomSheetBehavior.f2811w;
        this.A = bottomSheetBehavior.f2792d0;
        this.B = bottomSheetBehavior.f2793e0;
    }
}
