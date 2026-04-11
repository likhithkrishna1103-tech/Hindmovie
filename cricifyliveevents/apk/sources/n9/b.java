package n9;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;
import l4.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new p(14);
    public Integer A;
    public Integer B;
    public Integer C;
    public String E;
    public Locale I;
    public CharSequence J;
    public CharSequence K;
    public int L;
    public int M;
    public Integer N;
    public Integer P;
    public Integer Q;
    public Integer R;
    public Integer S;
    public Integer T;
    public Integer U;
    public Integer V;
    public Integer W;
    public Integer X;
    public Boolean Y;
    public Integer Z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f8906v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Integer f8907w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Integer f8908x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Integer f8909y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Integer f8910z;
    public int D = 255;
    public int F = -2;
    public int G = -2;
    public int H = -2;
    public Boolean O = Boolean.TRUE;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f8906v);
        parcel.writeSerializable(this.f8907w);
        parcel.writeSerializable(this.f8908x);
        parcel.writeSerializable(this.f8909y);
        parcel.writeSerializable(this.f8910z);
        parcel.writeSerializable(this.A);
        parcel.writeSerializable(this.B);
        parcel.writeSerializable(this.C);
        parcel.writeInt(this.D);
        parcel.writeString(this.E);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        parcel.writeInt(this.H);
        CharSequence charSequence = this.J;
        parcel.writeString(charSequence != null ? charSequence.toString() : null);
        CharSequence charSequence2 = this.K;
        parcel.writeString(charSequence2 != null ? charSequence2.toString() : null);
        parcel.writeInt(this.L);
        parcel.writeSerializable(this.N);
        parcel.writeSerializable(this.P);
        parcel.writeSerializable(this.Q);
        parcel.writeSerializable(this.R);
        parcel.writeSerializable(this.S);
        parcel.writeSerializable(this.T);
        parcel.writeSerializable(this.U);
        parcel.writeSerializable(this.X);
        parcel.writeSerializable(this.V);
        parcel.writeSerializable(this.W);
        parcel.writeSerializable(this.O);
        parcel.writeSerializable(this.I);
        parcel.writeSerializable(this.Y);
        parcel.writeSerializable(this.Z);
    }
}
