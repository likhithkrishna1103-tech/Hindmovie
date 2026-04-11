package s8;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;
import k8.x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new x(18);
    public Integer A;
    public Integer B;
    public String D;
    public Locale H;
    public CharSequence I;
    public CharSequence J;
    public int K;
    public int L;
    public Integer M;
    public Integer O;
    public Integer P;
    public Integer Q;
    public Integer R;
    public Integer S;
    public Integer T;
    public Integer U;
    public Integer V;
    public Integer W;
    public Boolean X;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f11918u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Integer f11919v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Integer f11920w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Integer f11921x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Integer f11922y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Integer f11923z;
    public int C = 255;
    public int E = -2;
    public int F = -2;
    public int G = -2;
    public Boolean N = Boolean.TRUE;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11918u);
        parcel.writeSerializable(this.f11919v);
        parcel.writeSerializable(this.f11920w);
        parcel.writeSerializable(this.f11921x);
        parcel.writeSerializable(this.f11922y);
        parcel.writeSerializable(this.f11923z);
        parcel.writeSerializable(this.A);
        parcel.writeSerializable(this.B);
        parcel.writeInt(this.C);
        parcel.writeString(this.D);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        CharSequence charSequence = this.I;
        parcel.writeString(charSequence != null ? charSequence.toString() : null);
        CharSequence charSequence2 = this.J;
        parcel.writeString(charSequence2 != null ? charSequence2.toString() : null);
        parcel.writeInt(this.K);
        parcel.writeSerializable(this.M);
        parcel.writeSerializable(this.O);
        parcel.writeSerializable(this.P);
        parcel.writeSerializable(this.Q);
        parcel.writeSerializable(this.R);
        parcel.writeSerializable(this.S);
        parcel.writeSerializable(this.T);
        parcel.writeSerializable(this.W);
        parcel.writeSerializable(this.U);
        parcel.writeSerializable(this.V);
        parcel.writeSerializable(this.N);
        parcel.writeSerializable(this.H);
        parcel.writeSerializable(this.X);
    }
}
