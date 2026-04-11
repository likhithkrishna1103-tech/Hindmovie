package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s0 implements Parcelable {
    public static final Parcelable.Creator<s0> CREATOR = new a9.b(9);
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final Bundle D;
    public final boolean E;
    public final int F;
    public Bundle G;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f1355u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f1356v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f1357w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f1358x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f1359y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f1360z;

    public s0(v vVar) {
        this.f1355u = vVar.getClass().getName();
        this.f1356v = vVar.f1398z;
        this.f1357w = vVar.H;
        this.f1358x = vVar.Q;
        this.f1359y = vVar.R;
        this.f1360z = vVar.S;
        this.A = vVar.V;
        this.B = vVar.G;
        this.C = vVar.U;
        this.D = vVar.A;
        this.E = vVar.T;
        this.F = vVar.f1385h0.ordinal();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f1355u);
        sb2.append(" (");
        sb2.append(this.f1356v);
        sb2.append(")}:");
        if (this.f1357w) {
            sb2.append(" fromLayout");
        }
        int i = this.f1359y;
        if (i != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(i));
        }
        String str = this.f1360z;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(str);
        }
        if (this.A) {
            sb2.append(" retainInstance");
        }
        if (this.B) {
            sb2.append(" removing");
        }
        if (this.C) {
            sb2.append(" detached");
        }
        if (this.E) {
            sb2.append(" hidden");
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1355u);
        parcel.writeString(this.f1356v);
        parcel.writeInt(this.f1357w ? 1 : 0);
        parcel.writeInt(this.f1358x);
        parcel.writeInt(this.f1359y);
        parcel.writeString(this.f1360z);
        parcel.writeInt(this.A ? 1 : 0);
        parcel.writeInt(this.B ? 1 : 0);
        parcel.writeInt(this.C ? 1 : 0);
        parcel.writeBundle(this.D);
        parcel.writeInt(this.E ? 1 : 0);
        parcel.writeBundle(this.G);
        parcel.writeInt(this.F);
    }

    public s0(Parcel parcel) {
        this.f1355u = parcel.readString();
        this.f1356v = parcel.readString();
        this.f1357w = parcel.readInt() != 0;
        this.f1358x = parcel.readInt();
        this.f1359y = parcel.readInt();
        this.f1360z = parcel.readString();
        this.A = parcel.readInt() != 0;
        this.B = parcel.readInt() != 0;
        this.C = parcel.readInt() != 0;
        this.D = parcel.readBundle();
        this.E = parcel.readInt() != 0;
        this.G = parcel.readBundle();
        this.F = parcel.readInt();
    }
}
