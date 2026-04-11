package g6;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends View.BaseSavedState {
    public static final Parcelable.Creator<f> CREATOR = new android.support.v4.media.a(27);
    public int A;
    public int B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f5070v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f5071w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f5072x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f5073y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f5074z;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f5070v);
        parcel.writeFloat(this.f5072x);
        parcel.writeInt(this.f5073y ? 1 : 0);
        parcel.writeString(this.f5074z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B);
    }
}
