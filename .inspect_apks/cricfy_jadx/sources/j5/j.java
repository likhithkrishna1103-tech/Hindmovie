package j5;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends View.BaseSavedState {
    public static final Parcelable.Creator<j> CREATOR = new android.support.v4.media.a(28);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f6623v;

    public j(Parcelable parcelable, boolean z10) {
        super(parcelable);
        this.f6623v = z10;
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.f6623v ? (byte) 1 : (byte) 0);
    }

    public j(Parcel parcel) {
        super(parcel);
        this.f6623v = parcel.readByte() != 0;
    }
}
