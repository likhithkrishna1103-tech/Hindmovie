package k4;

import android.os.Bundle;
import android.os.Parcel;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 implements r {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final j f7200v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f7201w;

    public z0(j jVar, int i) {
        this.f7200v = jVar;
        this.f7201w = i;
    }

    @Override // k4.r
    public final void b(int i, k1 k1Var) {
        Bundle bundle = Bundle.EMPTY;
        Bundle bundle2 = new Bundle();
        bundle2.putInt(k1.f, k1Var.f7055a);
        bundle2.putString(k1.f7053g, k1Var.f7056b);
        bundle2.putBundle(k1.f7054h, k1Var.f7057c);
        i iVar = (i) this.f7200v;
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            w8.e.a(parcelObtain, bundle2);
            w8.e.a(parcelObtain, bundle);
            iVar.f7039d.transact(3005, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // k4.r
    public final void c(int i) {
        i iVar = (i) this.f7200v;
        iVar.getClass();
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            iVar.f7039d.transact(3011, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // k4.r
    public final void d(int i, n1 n1Var, boolean z10, boolean z11, int i10) {
        Bundle bundleB = n1Var.a(z10, z11).b(i10);
        i iVar = (i) this.f7200v;
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            w8.e.a(parcelObtain, bundleB);
            iVar.f7039d.transact(3008, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // k4.r
    public final void e() {
        android.support.v4.media.session.b.i(this.f7200v);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != z0.class) {
            return false;
        }
        return Objects.equals(((i) this.f7200v).asBinder(), ((i) ((z0) obj).f7200v).asBinder());
    }

    public final int hashCode() {
        return Objects.hash(((i) this.f7200v).asBinder());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    @Override // k4.r
    public final void i(int i, f1 f1Var, v1.s0 s0Var, boolean z10, boolean z11) {
        Parcel parcelObtain;
        int i10 = this.f7201w;
        y1.d.g(i10 != 0);
        ?? r32 = (z10 || !s0Var.a(17)) ? 1 : 0;
        boolean z12 = z11 || !s0Var.a(30);
        j jVar = this.f7200v;
        if (i10 < 2) {
            Bundle bundleF = f1Var.e(s0Var, z10, true).f(i10);
            i iVar = (i) jVar;
            parcelObtain = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
                parcelObtain.writeInt(i);
                w8.e.a(parcelObtain, bundleF);
                parcelObtain.writeInt(r32);
                iVar.f7039d.transact(3007, parcelObtain, null, 1);
                return;
            } finally {
            }
        }
        Bundle bundleF2 = f1Var.e(s0Var, z10, z11).f(i10);
        Bundle bundle = new Bundle();
        bundle.putBoolean(e1.f6949a, r32);
        bundle.putBoolean(e1.f6950b, z12);
        i iVar2 = (i) jVar;
        parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            w8.e.a(parcelObtain, bundleF2);
            w8.e.a(parcelObtain, bundle);
            iVar2.f7039d.transact(3013, parcelObtain, null, 1);
        } finally {
        }
    }

    @Override // k4.r
    public final void j(int i, o1 o1Var) {
        Bundle bundle = new Bundle();
        bundle.putInt(o1.f7120e, o1Var.f7123a);
        bundle.putBundle(o1.f, o1Var.f7124b);
        bundle.putLong(o1.f7121g, o1Var.f7125c);
        m1 m1Var = o1Var.f7126d;
        if (m1Var != null) {
            bundle.putBundle(o1.f7122h, m1Var.a());
        }
        i iVar = (i) this.f7200v;
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            w8.e.a(parcelObtain, bundle);
            iVar.f7039d.transact(3002, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // k4.r
    public final void k(int i, v1.s0 s0Var) {
        Bundle bundleB = s0Var.b();
        i iVar = (i) this.f7200v;
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            w8.e.a(parcelObtain, bundleB);
            iVar.f7039d.transact(3009, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // k4.r
    public final void l(int i, m mVar) {
        Bundle bundle = new Bundle();
        bundle.putInt(m.f7077d, mVar.f7080a);
        bundle.putLong(m.f7078e, mVar.f7081b);
        bundle.putBundle(m.f7079g, mVar.f7082c.a());
        bundle.putInt(m.f, 4);
        i iVar = (i) this.f7200v;
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            w8.e.a(parcelObtain, bundle);
            iVar.f7039d.transact(3003, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
