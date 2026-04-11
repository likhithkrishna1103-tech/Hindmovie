package o8;

import android.os.Parcel;
import android.os.Parcelable;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends p8.a {
    public static final Parcelable.Creator<f> CREATOR = new l4.p(22);
    public final int[] A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k f9647v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f9648w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f9649x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f9650y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f9651z;

    public f(k kVar, boolean z10, boolean z11, int[] iArr, int i, int[] iArr2) {
        this.f9647v = kVar;
        this.f9648w = z10;
        this.f9649x = z11;
        this.f9650y = iArr;
        this.f9651z = i;
        this.A = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = t1.w(parcel, 20293);
        t1.q(parcel, 1, this.f9647v, i);
        t1.v(parcel, 2, 4);
        parcel.writeInt(this.f9648w ? 1 : 0);
        t1.v(parcel, 3, 4);
        parcel.writeInt(this.f9649x ? 1 : 0);
        int[] iArr = this.f9650y;
        if (iArr != null) {
            int iW2 = t1.w(parcel, 4);
            parcel.writeIntArray(iArr);
            t1.y(parcel, iW2);
        }
        t1.v(parcel, 5, 4);
        parcel.writeInt(this.f9651z);
        int[] iArr2 = this.A;
        if (iArr2 != null) {
            int iW3 = t1.w(parcel, 6);
            parcel.writeIntArray(iArr2);
            t1.y(parcel, iW3);
        }
        t1.y(parcel, iW);
    }
}
