package g4;

import android.os.Bundle;
import android.os.Parcel;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b1 implements r {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final j f4980u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f4981v;

    public b1(j jVar, int i) {
        this.f4980u = jVar;
        this.f4981v = i;
    }

    @Override // g4.r
    public final void a(int i, p1.s0 s0Var) {
        Bundle bundleB = s0Var.b();
        i iVar = (i) this.f4980u;
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            q1.c.a(parcelObtain, bundleB);
            iVar.f5084d.transact(3009, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // g4.r
    public final void d(int i, p1 p1Var, boolean z2, boolean z10, int i10) {
        Bundle bundleB = p1Var.a(z2, z10).b(i10);
        i iVar = (i) this.f4980u;
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            q1.c.a(parcelObtain, bundleB);
            iVar.f5084d.transact(3008, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // g4.r
    public final void e(int i, m mVar) {
        Bundle bundle = new Bundle();
        bundle.putInt(m.f5108d, mVar.f5111a);
        bundle.putLong(m.f5109e, mVar.f5112b);
        bundle.putBundle(m.f5110g, mVar.f5113c.a());
        bundle.putInt(m.f, 4);
        i iVar = (i) this.f4980u;
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            q1.c.a(parcelObtain, bundle);
            iVar.f5084d.transact(3003, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != b1.class) {
            return false;
        }
        return Objects.equals(this.f4980u.asBinder(), ((b1) obj).f4980u.asBinder());
    }

    @Override // g4.r
    public final void g(int i) {
        i iVar = (i) this.f4980u;
        iVar.getClass();
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            iVar.f5084d.transact(3011, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // g4.r
    public final void h() {
        a.a.f(this.f4980u);
    }

    public final int hashCode() {
        return Objects.hash(this.f4980u.asBinder());
    }

    @Override // g4.r
    public final void i(int i, q1 q1Var) {
        Bundle bundle = new Bundle();
        bundle.putInt(q1.f5186e, q1Var.f5189a);
        bundle.putBundle(q1.f, q1Var.f5190b);
        bundle.putLong(q1.f5187g, q1Var.f5191c);
        o1 o1Var = q1Var.f5192d;
        if (o1Var != null) {
            bundle.putBundle(q1.f5188h, o1Var.a());
        }
        i iVar = (i) this.f4980u;
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            q1.c.a(parcelObtain, bundle);
            iVar.f5084d.transact(3002, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // g4.r
    public final void j(int i, m1 m1Var) {
        Bundle bundle = Bundle.EMPTY;
        Bundle bundle2 = new Bundle();
        bundle2.putInt(m1.f, m1Var.f5134a);
        bundle2.putString(m1.f5132g, m1Var.f5135b);
        bundle2.putBundle(m1.f5133h, m1Var.f5136c);
        i iVar = (i) this.f4980u;
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            q1.c.a(parcelObtain, bundle2);
            q1.c.a(parcelObtain, bundle);
            iVar.f5084d.transact(3005, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    @Override // g4.r
    public final void k(int i, h1 h1Var, p1.s0 s0Var, boolean z2, boolean z10) {
        Parcel parcelObtain;
        int i10 = this.f4981v;
        s1.d.g(i10 != 0);
        ?? r32 = (z2 || !s0Var.a(17)) ? 1 : 0;
        boolean z11 = z10 || !s0Var.a(30);
        j jVar = this.f4980u;
        if (i10 < 2) {
            Bundle bundleF = h1Var.e(s0Var, z2, true).f(i10);
            i iVar = (i) jVar;
            parcelObtain = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
                parcelObtain.writeInt(i);
                q1.c.a(parcelObtain, bundleF);
                parcelObtain.writeInt(r32);
                iVar.f5084d.transact(3007, parcelObtain, null, 1);
                return;
            } finally {
            }
        }
        Bundle bundleF2 = h1Var.e(s0Var, z2, z10).f(i10);
        Bundle bundle = new Bundle();
        bundle.putBoolean(g1.f5021a, r32);
        bundle.putBoolean(g1.f5022b, z11);
        i iVar2 = (i) jVar;
        parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            q1.c.a(parcelObtain, bundleF2);
            q1.c.a(parcelObtain, bundle);
            iVar2.f5084d.transact(3013, parcelObtain, null, 1);
        } finally {
        }
    }
}
