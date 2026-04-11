package v4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d1 implements Parcelable {
    public static final Parcelable.Creator<d1> CREATOR = new l4.p(27);
    public int[] A;
    public ArrayList B;
    public boolean C;
    public boolean D;
    public boolean E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13202v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13203w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f13204x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f13205y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13206z;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f13202v);
        parcel.writeInt(this.f13203w);
        parcel.writeInt(this.f13204x);
        if (this.f13204x > 0) {
            parcel.writeIntArray(this.f13205y);
        }
        parcel.writeInt(this.f13206z);
        if (this.f13206z > 0) {
            parcel.writeIntArray(this.A);
        }
        parcel.writeInt(this.C ? 1 : 0);
        parcel.writeInt(this.D ? 1 : 0);
        parcel.writeInt(this.E ? 1 : 0);
        parcel.writeList(this.B);
    }
}
