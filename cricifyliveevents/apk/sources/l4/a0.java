package l4;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements Parcelable {
    public static final Parcelable.Creator<a0> CREATOR = new p(2);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ResultReceiver f7698v;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        this.f7698v.writeToParcel(parcel, i);
    }
}
