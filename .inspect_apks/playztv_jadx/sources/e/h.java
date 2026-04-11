package e;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Parcelable {
    public static final Parcelable.Creator<h> CREATOR = new a9.b(15);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final IntentSender f4227u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Intent f4228v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f4229w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f4230x;

    public h(IntentSender intentSender, Intent intent, int i, int i10) {
        this.f4227u = intentSender;
        this.f4228v = intent;
        this.f4229w = i;
        this.f4230x = i10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        be.h.e(parcel, "dest");
        parcel.writeParcelable(this.f4227u, i);
        parcel.writeParcelable(this.f4228v, i);
        parcel.writeInt(this.f4229w);
        parcel.writeInt(this.f4230x);
    }
}
