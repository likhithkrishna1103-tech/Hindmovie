package o;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 extends View.BaseSavedState {
    public static final Parcelable.Creator<m0> CREATOR = new l4.p(17);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f9274v;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.f9274v ? (byte) 1 : (byte) 0);
    }
}
