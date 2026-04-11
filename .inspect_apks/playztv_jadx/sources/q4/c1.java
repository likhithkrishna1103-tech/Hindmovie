package q4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c1 implements Parcelable {
    public static final Parcelable.Creator<c1> CREATOR = new k8.x(11);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10756u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10757v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int[] f10758w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f10759x;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f10756u + ", mGapDir=" + this.f10757v + ", mHasUnwantedGapAfter=" + this.f10759x + ", mGapPerSpan=" + Arrays.toString(this.f10758w) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f10756u);
        parcel.writeInt(this.f10757v);
        parcel.writeInt(this.f10759x ? 1 : 0);
        int[] iArr = this.f10758w;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.f10758w);
        }
    }
}
