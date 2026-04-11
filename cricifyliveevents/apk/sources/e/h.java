package e;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import ge.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable {
    public static final Parcelable.Creator<h> CREATOR = new android.support.v4.media.a(15);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final IntentSender f3747v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Intent f3748w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f3749x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3750y;

    public h(IntentSender intentSender, Intent intent, int i, int i10) {
        this.f3747v = intentSender;
        this.f3748w = intent;
        this.f3749x = i;
        this.f3750y = i10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        i.e(parcel, "dest");
        parcel.writeParcelable(this.f3747v, i);
        parcel.writeParcelable(this.f3748w, i);
        parcel.writeInt(this.f3749x);
        parcel.writeInt(this.f3750y);
    }
}
