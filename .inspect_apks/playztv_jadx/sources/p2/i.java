package p2;

import aa.l0;
import android.net.Uri;
import androidx.media3.decoder.DecoderInputBuffer;
import e6.f0;
import h4.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k8.a0;
import o2.b1;
import o2.c1;
import o2.d1;
import o2.e1;
import o2.u;
import p1.m0;
import p1.q;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements c1, e1, s2.h, s2.k {
    public final l0 A;
    public final a0 B;
    public final s2.m C;
    public final f0 D;
    public final ArrayList E;
    public final List F;
    public final b1 G;
    public final b1[] H;
    public final c I;
    public f J;
    public q K;
    public h L;
    public long M;
    public long N;
    public int O;
    public a P;
    public boolean Q;
    public boolean R;
    public boolean S;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f10154u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int[] f10155v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final q[] f10156w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean[] f10157x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final j f10158y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Object f10159z;

    public i(int i, int[] iArr, q[] qVarArr, j jVar, d1 d1Var, s2.e eVar, long j5, f2.n nVar, f2.k kVar, a0 a0Var, l0 l0Var, boolean z2) {
        this.f10154u = i;
        int i10 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.f10155v = iArr;
        this.f10156w = qVarArr == null ? new q[0] : qVarArr;
        this.f10158y = jVar;
        this.f10159z = d1Var;
        this.A = l0Var;
        this.B = a0Var;
        this.Q = z2;
        this.C = new s2.m("ChunkSampleStream");
        this.D = new f0();
        ArrayList arrayList = new ArrayList();
        this.E = arrayList;
        this.F = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.H = new b1[length];
        this.f10157x = new boolean[length];
        int i11 = length + 1;
        int[] iArr2 = new int[i11];
        b1[] b1VarArr = new b1[i11];
        nVar.getClass();
        b1 b1Var = new b1(eVar, nVar, kVar);
        this.G = b1Var;
        iArr2[0] = i;
        b1VarArr[0] = b1Var;
        while (i10 < length) {
            b1 b1Var2 = new b1(eVar, null, null);
            this.H[i10] = b1Var2;
            int i12 = i10 + 1;
            b1VarArr[i12] = b1Var2;
            iArr2[i12] = this.f10155v[i10];
            i10 = i12;
        }
        this.I = new c(iArr2, 0, b1VarArr);
        this.M = j5;
        this.N = j5;
    }

    public final void A() {
        int iB = B(this.G.t(), this.O - 1);
        while (true) {
            int i = this.O;
            if (i > iB) {
                return;
            }
            this.O = i + 1;
            a aVar = (a) this.E.get(i);
            q qVar = aVar.f10146x;
            if (!qVar.equals(this.K)) {
                this.A.g(this.f10154u, qVar, aVar.f10147y, aVar.f10148z, aVar.A);
            }
            this.K = qVar;
        }
    }

    public final int B(int i, int i10) {
        ArrayList arrayList;
        do {
            i10++;
            arrayList = this.E;
            if (i10 >= arrayList.size()) {
                return arrayList.size() - 1;
            }
        } while (((a) arrayList.get(i10)).e(0) <= i);
        return i10 - 1;
    }

    public final void C(d2.b bVar) {
        this.L = bVar;
        b1 b1Var = this.G;
        b1Var.k();
        f2.h hVar = b1Var.f9063h;
        if (hVar != null) {
            hVar.c(b1Var.f9061e);
            b1Var.f9063h = null;
            b1Var.f9062g = null;
        }
        for (b1 b1Var2 : this.H) {
            b1Var2.k();
            f2.h hVar2 = b1Var2.f9063h;
            if (hVar2 != null) {
                hVar2.c(b1Var2.f9061e);
                b1Var2.f9063h = null;
                b1Var2.f9062g = null;
            }
        }
        this.C.e(this);
    }

    public final void D(long j5) {
        ArrayList arrayList;
        a aVar;
        boolean zG;
        this.N = j5;
        int i = 0;
        this.Q = false;
        if (z()) {
            this.M = j5;
            return;
        }
        int i10 = 0;
        while (true) {
            arrayList = this.E;
            if (i10 >= arrayList.size()) {
                break;
            }
            aVar = (a) arrayList.get(i10);
            long j8 = aVar.A;
            if (j8 == j5 && aVar.E == -9223372036854775807L) {
                break;
            } else if (j8 > j5) {
                break;
            } else {
                i10++;
            }
        }
        aVar = null;
        b1 b1Var = this.G;
        if (aVar != null) {
            zG = b1Var.F(aVar.e(0));
        } else {
            long jG = g();
            zG = b1Var.G(jG == Long.MIN_VALUE || j5 < jG, j5);
        }
        b1[] b1VarArr = this.H;
        if (zG) {
            this.O = B(b1Var.t(), 0);
            int length = b1VarArr.length;
            while (i < length) {
                b1VarArr[i].G(true, j5);
                i++;
            }
            return;
        }
        this.M = j5;
        this.S = false;
        arrayList.clear();
        this.O = 0;
        s2.m mVar = this.C;
        if (mVar.d()) {
            b1Var.k();
            int length2 = b1VarArr.length;
            while (i < length2) {
                b1VarArr[i].k();
                i++;
            }
            mVar.a();
            return;
        }
        mVar.f11769w = null;
        b1Var.D(false);
        for (b1 b1Var2 : b1VarArr) {
            b1Var2.D(false);
        }
    }

    @Override // o2.c1
    public final void b() {
        s2.m mVar = this.C;
        mVar.b();
        this.G.z();
        if (mVar.d()) {
            return;
        }
        this.f10158y.b();
    }

    @Override // o2.e1
    public final boolean c() {
        return this.C.d();
    }

    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Object, o2.d1] */
    @Override // s2.h
    public final void d(s2.j jVar, long j5, long j8) {
        f fVar = (f) jVar;
        this.J = null;
        this.f10158y.f(fVar);
        long j10 = fVar.f10143u;
        Uri uri = fVar.C.f13128w;
        u uVar = new u(j8);
        this.B.getClass();
        this.A.o(uVar, fVar.f10145w, this.f10154u, fVar.f10146x, fVar.f10147y, fVar.f10148z, fVar.A, fVar.B);
        this.f10159z.d(this);
    }

    @Override // o2.c1
    public final int e(z zVar, DecoderInputBuffer decoderInputBuffer, int i) {
        if (z()) {
            return -3;
        }
        a aVar = this.P;
        b1 b1Var = this.G;
        if (aVar != null && aVar.e(0) <= b1Var.t()) {
            return -3;
        }
        A();
        return b1Var.C(zVar, decoderInputBuffer, i, this.S);
    }

    @Override // s2.k
    public final void f() {
        b1 b1Var = this.G;
        b1Var.D(true);
        f2.h hVar = b1Var.f9063h;
        if (hVar != null) {
            hVar.c(b1Var.f9061e);
            b1Var.f9063h = null;
            b1Var.f9062g = null;
        }
        for (b1 b1Var2 : this.H) {
            b1Var2.D(true);
            f2.h hVar2 = b1Var2.f9063h;
            if (hVar2 != null) {
                hVar2.c(b1Var2.f9061e);
                b1Var2.f9063h = null;
                b1Var2.f9062g = null;
            }
        }
        this.f10158y.release();
        h hVar3 = this.L;
        if (hVar3 != null) {
            d2.b bVar = (d2.b) hVar3;
            synchronized (bVar) {
                d2.n nVar = (d2.n) bVar.H.remove(this);
                if (nVar != null) {
                    b1 b1Var3 = nVar.f3756a;
                    b1Var3.D(true);
                    f2.h hVar4 = b1Var3.f9063h;
                    if (hVar4 != null) {
                        hVar4.c(b1Var3.f9061e);
                        b1Var3.f9063h = null;
                        b1Var3.f9062g = null;
                    }
                }
            }
        }
    }

    @Override // o2.e1
    public final long g() {
        if (z()) {
            return this.M;
        }
        if (this.S) {
            return Long.MIN_VALUE;
        }
        return x().B;
    }

    public final void h(boolean z2, long j5) {
        long j8;
        if (z()) {
            return;
        }
        b1 b1Var = this.G;
        int i = b1Var.f9071q;
        b1Var.j(j5, z2, true);
        b1 b1Var2 = this.G;
        int i10 = b1Var2.f9071q;
        if (i10 > i) {
            synchronized (b1Var2) {
                j8 = b1Var2.f9070p == 0 ? Long.MIN_VALUE : b1Var2.f9068n[b1Var2.f9072r];
            }
            int i11 = 0;
            while (true) {
                b1[] b1VarArr = this.H;
                if (i11 >= b1VarArr.length) {
                    break;
                }
                b1VarArr[i11].j(j8, z2, this.f10157x[i11]);
                i11++;
            }
        }
        int iMin = Math.min(B(i10, 0), this.O);
        if (iMin > 0) {
            b0.T(this.E, 0, iMin);
            this.O -= iMin;
        }
    }

    @Override // o2.c1
    public final boolean j() {
        return !z() && this.G.x(this.S);
    }

    @Override // s2.h
    public final void k(s2.j jVar, long j5, long j8, int i) {
        u uVar;
        f fVar = (f) jVar;
        if (i == 0) {
            long j10 = fVar.f10143u;
            uVar = new u(fVar.f10144v);
        } else {
            long j11 = fVar.f10143u;
            Uri uri = fVar.C.f13128w;
            uVar = new u(j8);
        }
        u uVar2 = uVar;
        this.A.t(uVar2, fVar.f10145w, this.f10154u, fVar.f10146x, fVar.f10147y, fVar.f10148z, fVar.A, fVar.B, i);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // o2.e1
    public final boolean l(a2.c1 c1Var) {
        long j5;
        List list;
        if (!this.S) {
            s2.m mVar = this.C;
            if (!mVar.d() && !mVar.c()) {
                boolean z2 = z();
                if (z2) {
                    list = Collections.EMPTY_LIST;
                    j5 = this.M;
                } else {
                    j5 = x().B;
                    list = this.F;
                }
                this.f10158y.e(c1Var, j5, list, this.D);
                f0 f0Var = this.D;
                boolean z10 = f0Var.f4498u;
                f fVar = (f) f0Var.f4499v;
                f0Var.f4499v = null;
                f0Var.f4498u = false;
                if (z10) {
                    this.M = -9223372036854775807L;
                    this.S = true;
                    return true;
                }
                if (fVar != null) {
                    this.J = fVar;
                    boolean z11 = fVar instanceof a;
                    c cVar = this.I;
                    if (z11) {
                        a aVar = (a) fVar;
                        if (z2) {
                            long j8 = aVar.A;
                            long j10 = this.M;
                            if (j8 < j10) {
                                this.G.f9074t = j10;
                                for (b1 b1Var : this.H) {
                                    b1Var.f9074t = this.M;
                                }
                                if (this.Q) {
                                    q qVar = aVar.f10146x;
                                    this.R = !m0.a(qVar.f10023n, qVar.f10020k);
                                }
                            }
                            this.Q = false;
                            this.M = -9223372036854775807L;
                        }
                        aVar.G = cVar;
                        b1[] b1VarArr = (b1[]) cVar.f10131w;
                        int[] iArr = new int[b1VarArr.length];
                        for (int i = 0; i < b1VarArr.length; i++) {
                            b1 b1Var2 = b1VarArr[i];
                            iArr[i] = b1Var2.f9071q + b1Var2.f9070p;
                        }
                        aVar.H = iArr;
                        this.E.add(aVar);
                    } else if (fVar instanceof l) {
                        ((l) fVar).E = cVar;
                    }
                    mVar.f(fVar, this, this.B.k(fVar.f10145w));
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, o2.d1] */
    @Override // s2.h
    public final e4.f m(s2.j jVar, long j5, long j8, IOException iOException, int i) {
        e4.f fVar;
        f fVar2 = (f) jVar;
        long j10 = fVar2.C.f13127v;
        boolean z2 = fVar2 instanceof a;
        ArrayList arrayList = this.E;
        int size = arrayList.size() - 1;
        boolean z10 = (j10 != 0 && z2 && y(size)) ? false : true;
        Uri uri = fVar2.C.f13128w;
        u uVar = new u(j8);
        b0.b0(fVar2.A);
        b0.b0(fVar2.B);
        e6.i iVar = new e6.i(i, iOException);
        j jVar2 = this.f10158y;
        a0 a0Var = this.B;
        if (!jVar2.c(fVar2, z10, iVar, a0Var)) {
            fVar = null;
        } else if (z10) {
            if (z2) {
                s1.d.g(w(size) == fVar2);
                if (arrayList.isEmpty()) {
                    this.M = this.N;
                }
            }
            fVar = s2.m.f11765y;
        } else {
            s1.b.p("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            fVar = null;
        }
        if (fVar == null) {
            a0Var.getClass();
            long jN = a0.n(iVar);
            fVar = jN != -9223372036854775807L ? new e4.f(0, jN, false) : s2.m.f11766z;
        }
        boolean zA = fVar.a();
        this.A.q(uVar, fVar2.f10145w, this.f10154u, fVar2.f10146x, fVar2.f10147y, fVar2.f10148z, fVar2.A, fVar2.B, iOException, !zA);
        if (!zA) {
            this.J = null;
            a0Var.getClass();
            this.f10159z.d(this);
        }
        return fVar;
    }

    @Override // o2.c1
    public final int q(long j5) {
        if (z()) {
            return 0;
        }
        boolean z2 = this.S;
        b1 b1Var = this.G;
        int iV = b1Var.v(z2, j5);
        a aVar = this.P;
        if (aVar != null) {
            iV = Math.min(iV, aVar.e(0) - b1Var.t());
        }
        b1Var.H(iV);
        A();
        return iV;
    }

    @Override // o2.e1
    public final long r() {
        if (this.S) {
            return Long.MIN_VALUE;
        }
        if (z()) {
            return this.M;
        }
        long jMax = this.N;
        a aVarX = x();
        if (!aVarX.d()) {
            ArrayList arrayList = this.E;
            aVarX = arrayList.size() > 1 ? (a) arrayList.get(arrayList.size() - 2) : null;
        }
        if (aVarX != null) {
            jMax = Math.max(jMax, aVarX.B);
        }
        return Math.max(jMax, this.G.q());
    }

    /* JADX WARN: Type inference failed for: r13v5, types: [java.lang.Object, o2.d1] */
    @Override // s2.h
    public final void u(s2.j jVar, long j5, long j8, boolean z2) {
        f fVar = (f) jVar;
        this.J = null;
        this.P = null;
        long j10 = fVar.f10143u;
        Uri uri = fVar.C.f13128w;
        u uVar = new u(j8);
        this.B.getClass();
        this.A.m(uVar, fVar.f10145w, this.f10154u, fVar.f10146x, fVar.f10147y, fVar.f10148z, fVar.A, fVar.B);
        if (z2) {
            return;
        }
        if (z()) {
            this.G.D(false);
            for (b1 b1Var : this.H) {
                b1Var.D(false);
            }
        } else if (fVar instanceof a) {
            ArrayList arrayList = this.E;
            w(arrayList.size() - 1);
            if (arrayList.isEmpty()) {
                this.M = this.N;
            }
        }
        this.f10159z.d(this);
    }

    @Override // o2.e1
    public final void v(long j5) {
        s2.m mVar = this.C;
        if (mVar.c() || z()) {
            return;
        }
        boolean zD = mVar.d();
        List list = this.F;
        j jVar = this.f10158y;
        ArrayList arrayList = this.E;
        if (zD) {
            f fVar = this.J;
            fVar.getClass();
            boolean z2 = fVar instanceof a;
            if (!(z2 && y(arrayList.size() - 1)) && jVar.g(j5, fVar, list)) {
                mVar.a();
                if (z2) {
                    this.P = (a) fVar;
                    return;
                }
                return;
            }
            return;
        }
        int iD = jVar.d(j5, list);
        if (iD < arrayList.size()) {
            s1.d.g(!mVar.d());
            int size = arrayList.size();
            while (true) {
                if (iD >= size) {
                    iD = -1;
                    break;
                } else if (!y(iD)) {
                    break;
                } else {
                    iD++;
                }
            }
            if (iD == -1) {
                return;
            }
            long j8 = x().B;
            a aVarW = w(iD);
            if (arrayList.isEmpty()) {
                this.M = this.N;
            }
            this.S = false;
            this.A.y(this.f10154u, aVarW.A, j8);
        }
    }

    public final a w(int i) {
        ArrayList arrayList = this.E;
        a aVar = (a) arrayList.get(i);
        b0.T(arrayList, i, arrayList.size());
        this.O = Math.max(this.O, arrayList.size());
        int i10 = 0;
        this.G.n(aVar.e(0));
        while (true) {
            b1[] b1VarArr = this.H;
            if (i10 >= b1VarArr.length) {
                return aVar;
            }
            b1 b1Var = b1VarArr[i10];
            i10++;
            b1Var.n(aVar.e(i10));
        }
    }

    public final a x() {
        return (a) this.E.get(r0.size() - 1);
    }

    public final boolean y(int i) {
        int iT;
        a aVar = (a) this.E.get(i);
        if (this.G.t() > aVar.e(0)) {
            return true;
        }
        int i10 = 0;
        do {
            b1[] b1VarArr = this.H;
            if (i10 >= b1VarArr.length) {
                return false;
            }
            iT = b1VarArr[i10].t();
            i10++;
        } while (iT <= aVar.e(i10));
        return true;
    }

    public final boolean z() {
        return this.M != -9223372036854775807L;
    }
}
