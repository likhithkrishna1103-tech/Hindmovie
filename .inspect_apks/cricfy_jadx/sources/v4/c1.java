package v4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 implements Parcelable {
    public static final Parcelable.Creator<c1> CREATOR = new l4.p(26);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13193v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13194w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int[] f13195x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f13196y;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.f13193v + ", mGapDir=" + this.f13194w + ", mHasUnwantedGapAfter=" + this.f13196y + ", mGapPerSpan=" + Arrays.toString(this.f13195x) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f13193v);
        parcel.writeInt(this.f13194w);
        parcel.writeInt(this.f13196y ? 1 : 0);
        int[] iArr = this.f13195x;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.f13195x);
        }
    }
}
