package l5;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends View.BaseSavedState {
    public static final Parcelable.Creator<g> CREATOR = new k8.x(4);
    public int A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f7839u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f7840v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f7841w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f7842x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f7843y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f7844z;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f7839u);
        parcel.writeFloat(this.f7841w);
        parcel.writeInt(this.f7842x ? 1 : 0);
        parcel.writeString(this.f7843y);
        parcel.writeInt(this.f7844z);
        parcel.writeInt(this.A);
    }
}
