package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 implements Parcelable {
    public static final Parcelable.Creator<x0> CREATOR = new android.support.v4.media.a(8);
    public final String A;
    public final boolean B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public final int F;
    public final String G;
    public final int H;
    public final boolean I;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f1096v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f1097w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f1098x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f1099y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f1100z;

    public x0(y yVar) {
        this.f1096v = yVar.getClass().getName();
        this.f1097w = yVar.A;
        this.f1098x = yVar.I;
        this.f1099y = yVar.R;
        this.f1100z = yVar.S;
        this.A = yVar.T;
        this.B = yVar.W;
        this.C = yVar.H;
        this.D = yVar.V;
        this.E = yVar.U;
        this.F = yVar.f1110i0.ordinal();
        this.G = yVar.D;
        this.H = yVar.E;
        this.I = yVar.f1105d0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f1096v);
        sb.append(" (");
        sb.append(this.f1097w);
        sb.append(")}:");
        if (this.f1098x) {
            sb.append(" fromLayout");
        }
        int i = this.f1100z;
        if (i != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i));
        }
        String str = this.A;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.B) {
            sb.append(" retainInstance");
        }
        if (this.C) {
            sb.append(" removing");
        }
        if (this.D) {
            sb.append(" detached");
        }
        if (this.E) {
            sb.append(" hidden");
        }
        String str2 = this.G;
        if (str2 != null) {
            sb.append(" targetWho=");
            sb.append(str2);
            sb.append(" targetRequestCode=");
            sb.append(this.H);
        }
        if (this.I) {
            sb.append(" userVisibleHint");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1096v);
        parcel.writeString(this.f1097w);
        parcel.writeInt(this.f1098x ? 1 : 0);
        parcel.writeInt(this.f1099y);
        parcel.writeInt(this.f1100z);
        parcel.writeString(this.A);
        parcel.writeInt(this.B ? 1 : 0);
        parcel.writeInt(this.C ? 1 : 0);
        parcel.writeInt(this.D ? 1 : 0);
        parcel.writeInt(this.E ? 1 : 0);
        parcel.writeInt(this.F);
        parcel.writeString(this.G);
        parcel.writeInt(this.H);
        parcel.writeInt(this.I ? 1 : 0);
    }

    public x0(Parcel parcel) {
        this.f1096v = parcel.readString();
        this.f1097w = parcel.readString();
        this.f1098x = parcel.readInt() != 0;
        this.f1099y = parcel.readInt();
        this.f1100z = parcel.readInt();
        this.A = parcel.readString();
        this.B = parcel.readInt() != 0;
        this.C = parcel.readInt() != 0;
        this.D = parcel.readInt() != 0;
        this.E = parcel.readInt() != 0;
        this.F = parcel.readInt();
        this.G = parcel.readString();
        this.H = parcel.readInt();
        this.I = parcel.readInt() != 0;
    }
}
