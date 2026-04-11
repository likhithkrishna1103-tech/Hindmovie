package y5;

import android.os.Parcel;
import android.os.Parcelable;
import l4.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new p(29);
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public String L;
    public String M;
    public String N;
    public int O;
    public int P;
    public int Q;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f14904v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f14905w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f14906x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f14907y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f14908z;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14906x);
        parcel.writeString(this.f14907y);
        parcel.writeString(this.f14908z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.f14904v);
        parcel.writeString(this.f14905w);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
        parcel.writeInt(this.O);
        parcel.writeInt(this.P);
        parcel.writeInt(this.Q);
    }
}
