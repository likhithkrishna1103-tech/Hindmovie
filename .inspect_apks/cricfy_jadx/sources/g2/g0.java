package g2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseBooleanArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.o4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends a7.a implements r {
    public final Context A;
    public boolean A0;
    public final g0 B;
    public final v1.i B0;
    public final e[] C;
    public v1.r1 C0;
    public final e[] D;
    public v1.j0 D0;
    public final v2.t E;
    public i1 E0;
    public final y1.x F;
    public int F0;
    public final z G;
    public long G0;
    public final o0 H;
    public final y1.p I;
    public final CopyOnWriteArraySet J;
    public final v1.c1 K;
    public final ArrayList L;
    public final boolean M;
    public final s2.b0 N;
    public final h2.f O;
    public final Looper P;
    public final w2.d Q;
    public final long R;
    public final long S;
    public final long T;
    public final d0 U;
    public final e0 V;
    public final com.bumptech.glide.l W;
    public final a3.l0 X;
    public final a3.l0 Y;
    public final long Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final ff.k f4689a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f4690b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f4691c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f4692d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f4693e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f4694f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final q1 f4695g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public s2.d1 f4696h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public v1.s0 f4697i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public v1.j0 f4698j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public v1.j0 f4699k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public Object f4700l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public Surface f4701m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public SurfaceHolder f4702n0;
    public z2.k o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f4703p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public TextureView f4704q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final int f4705r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public y1.u f4706s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public v1.c f4707t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public float f4708u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f4709v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public x1.c f4710w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final v2.u f4711x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final boolean f4712x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final v1.s0 f4713y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f4714y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final y1.g f4715z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final int f4716z0;

    static {
        v1.h0.a("media3.exoplayer");
    }

    public g0(p pVar) throws Throwable {
        g0 g0Var;
        Context context;
        y1.v vVar;
        int i;
        g0 g0Var2;
        int i10;
        super(7);
        this.f4715z = new y1.g();
        try {
            y1.b.k("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.8.0] [" + y1.a0.f14552b + "]");
            context = pVar.f4854a;
            vVar = pVar.f4855b;
            this.A = context.getApplicationContext();
            this.O = new h2.f(vVar);
            this.f4716z0 = pVar.i;
            this.f4707t0 = pVar.f4861j;
            this.f4705r0 = pVar.f4862k;
            this.f4709v0 = false;
            this.Z = pVar.f4871t;
            d0 d0Var = new d0(this);
            this.U = d0Var;
            this.V = new e0();
            e[] eVarArrA = ((l) pVar.f4856c.get()).a(new Handler(pVar.f4860h), d0Var, d0Var, d0Var, d0Var);
            this.C = eVarArrA;
            y1.d.g(eVarArrA.length > 0);
            this.D = new e[eVarArrA.length];
            i = 0;
        } catch (Throwable th) {
            th = th;
            g0Var = this;
        }
        while (true) {
            e[] eVarArr = this.D;
            if (i >= eVarArr.length) {
                break;
            }
            int i11 = this.C[i].f4658w;
            eVarArr[i] = null;
            i++;
            g0Var.f4715z.e();
            throw th;
        }
        v2.t tVar = (v2.t) pVar.f4858e.get();
        this.E = tVar;
        this.N = (s2.b0) pVar.f4857d.get();
        w2.d dVar = (w2.d) pVar.f4859g.get();
        this.Q = dVar;
        this.M = pVar.f4863l;
        r1 r1Var = pVar.f4864m;
        this.R = pVar.f4866o;
        this.S = pVar.f4867p;
        this.T = pVar.f4868q;
        this.f4695g0 = pVar.f4865n;
        Looper looper = pVar.f4860h;
        this.P = looper;
        this.B = this;
        this.I = new y1.p(looper, vVar, new a3.m(this));
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.J = copyOnWriteArraySet;
        this.L = new ArrayList();
        this.f4696h0 = new s2.d1();
        e[] eVarArr2 = this.C;
        v2.u uVar = new v2.u(new o1[eVarArr2.length], new v2.q[eVarArr2.length], v1.n1.f12880b, null);
        this.f4711x = uVar;
        this.K = new v1.c1();
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = {1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32};
        int length = iArr.length;
        int i12 = 0;
        while (i12 < length) {
            int i13 = iArr[i12];
            y1.d.g(!false);
            sparseBooleanArray.append(i13, true);
            i12++;
            dVar = dVar;
        }
        w2.d dVar2 = dVar;
        tVar.getClass();
        y1.d.g(!false);
        sparseBooleanArray.append(29, true);
        y1.d.g(!false);
        v1.n nVar = new v1.n(sparseBooleanArray);
        this.f4713y = new v1.s0(nVar);
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray();
        for (int i14 = 0; i14 < nVar.f12877a.size(); i14++) {
            int iB = nVar.b(i14);
            y1.d.g(!false);
            sparseBooleanArray2.append(iB, true);
        }
        y1.d.g(!false);
        sparseBooleanArray2.append(4, true);
        y1.d.g(!false);
        sparseBooleanArray2.append(10, true);
        y1.d.g(!false);
        this.f4697i0 = new v1.s0(new v1.n(sparseBooleanArray2));
        this.F = vVar.a(looper, null);
        z zVar = new z(this, 0);
        this.G = zVar;
        this.E0 = i1.k(uVar);
        this.O.X(this, looper);
        h2.l lVar = new h2.l(pVar.f4874w);
        o0 o0Var = new o0(this.A, this.C, this.D, tVar, uVar, (q0) pVar.f.get(), dVar2, this.f4690b0, this.f4691c0, this.O, r1Var, pVar.f4869r, pVar.f4870s, looper, vVar, zVar, lVar, this.V);
        y1.x xVar = o0Var.C;
        this.H = o0Var;
        Looper looper2 = o0Var.E;
        this.f4708u0 = 1.0f;
        this.f4690b0 = 0;
        v1.j0 j0Var = v1.j0.K;
        this.f4698j0 = j0Var;
        this.f4699k0 = j0Var;
        this.D0 = j0Var;
        this.F0 = -1;
        this.f4710w0 = x1.c.f14266d;
        this.f4712x0 = true;
        T0(this.O);
        Handler handler = new Handler(looper);
        h2.f fVar = this.O;
        w2.g gVar = (w2.g) dVar2;
        gVar.getClass();
        fVar.getClass();
        kf.i iVar = gVar.f13860c;
        iVar.getClass();
        CopyOnWriteArrayList<w2.c> copyOnWriteArrayList = (CopyOnWriteArrayList) iVar.f7483w;
        for (w2.c cVar : copyOnWriteArrayList) {
            if (cVar.f13843b == fVar) {
                cVar.f13844c = true;
                copyOnWriteArrayList.remove(cVar);
            }
        }
        copyOnWriteArrayList.add(new w2.c(handler, fVar));
        copyOnWriteArraySet.add(this.U);
        if (Build.VERSION.SDK_INT >= 31) {
            try {
                i10 = 1;
                g0Var2 = this;
                try {
                    vVar.a(o0Var.E, null).c(new a0(0, this.A, this, lVar, pVar.f4872u));
                } catch (Throwable th2) {
                    th = th2;
                    g0Var = g0Var2;
                }
            } catch (Throwable th3) {
                th = th3;
                g0Var2 = this;
                g0Var = g0Var2;
            }
        } else {
            i10 = 1;
            g0Var2 = this;
        }
        g0Var = g0Var2;
        try {
            ff.k kVar = new ff.k(0, looper2, looper, vVar, new z(g0Var2, i10));
            g0Var.f4689a0 = kVar;
            kVar.G(new androidx.emoji2.text.w(9, g0Var));
            com.bumptech.glide.l lVar2 = new com.bumptech.glide.l(pVar.f4854a, looper2, pVar.f4860h, g0Var.U, vVar);
            g0Var.W = lVar2;
            lVar2.n();
            g0Var.X = new a3.l0(context, looper2, vVar, i10);
            g0Var.Y = new a3.l0(context, looper2, vVar, 2);
            g0Var.B0 = v1.i.f12713c;
            g0Var.C0 = v1.r1.f12978d;
            g0Var.f4706s0 = y1.u.f14612c;
            xVar.a(38, g0Var.f4695g0).b();
            v1.c cVar2 = g0Var.f4707t0;
            y1.w wVarB = y1.x.b();
            wVarB.f14616a = xVar.f14618a.obtainMessage(31, 0, 0, cVar2);
            wVarB.b();
            g0Var.G1(i10, 3, g0Var.f4707t0);
            g0Var.G1(2, 4, Integer.valueOf(g0Var.f4705r0));
            g0Var.G1(2, 5, 0);
            g0Var.G1(i10, 9, Boolean.valueOf(g0Var.f4709v0));
            g0Var.G1(6, 8, g0Var.V);
            g0Var.G1(-1, 16, Integer.valueOf(g0Var.f4716z0));
            g0Var.f4715z.e();
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static long x1(i1 i1Var) {
        v1.e1 e1Var = new v1.e1();
        v1.c1 c1Var = new v1.c1();
        i1Var.f4750a.g(i1Var.f4751b.f11156a, c1Var);
        long j4 = i1Var.f4752c;
        return j4 == -9223372036854775807L ? i1Var.f4750a.m(c1Var.f12618c, e1Var, 0L).f12652l : c1Var.f12620e + j4;
    }

    public static i1 y1(i1 i1Var, int i) {
        i1 i1VarH = i1Var.h(i);
        return (i == 1 || i == 4) ? i1VarH.b(false) : i1VarH;
    }

    @Override // v1.w0
    public final void A(boolean z10) {
        P1();
        if (this.f4691c0 != z10) {
            this.f4691c0 = z10;
            y1.x xVar = this.H.C;
            xVar.getClass();
            y1.w wVarB = y1.x.b();
            wVarB.f14616a = xVar.f14618a.obtainMessage(12, z10 ? 1 : 0, 0);
            wVarB.b();
            y yVar = new y(0, z10);
            y1.p pVar = this.I;
            pVar.c(9, yVar);
            L1();
            pVar.b();
        }
    }

    public final Pair A1(v1.f1 f1Var, int i, long j4) {
        if (f1Var.p()) {
            this.F0 = i;
            if (j4 == -9223372036854775807L) {
                j4 = 0;
            }
            this.G0 = j4;
            return null;
        }
        if (i == -1 || i >= f1Var.o()) {
            i = f1Var.a(this.f4691c0);
            j4 = y1.a0.b0(f1Var.m(i, (v1.e1) this.f307w, 0L).f12652l);
        }
        return f1Var.i((v1.e1) this.f307w, this.K, i, y1.a0.O(j4));
    }

    @Override // v1.w0
    public final void B0() {
        P1();
    }

    public final void B1(int i, int i10) {
        y1.u uVar = this.f4706s0;
        if (i == uVar.f14613a && i10 == uVar.f14614b) {
            return;
        }
        this.f4706s0 = new y1.u(i, i10);
        this.I.e(24, new w(i, i10, 0));
        G1(2, 14, new y1.u(i, i10));
    }

    @Override // v1.w0
    public final boolean C0() {
        P1();
        return this.f4691c0;
    }

    public final void C1() {
        boolean zC;
        y1.b.k("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.8.0] [" + y1.a0.f14552b + "] [" + v1.h0.b() + "]");
        P1();
        this.W.n();
        this.X.a(false);
        this.Y.a(false);
        o0 o0Var = this.H;
        if (o0Var.f4824d0 || !o0Var.E.getThread().isAlive()) {
            zC = true;
        } else {
            o0Var.f4824d0 = true;
            y1.g gVar = new y1.g(o0Var.L);
            o0Var.C.a(7, gVar).b();
            zC = gVar.c(o0Var.Q);
        }
        if (!zC) {
            this.I.e(10, new a3.m(9));
        }
        this.I.d();
        this.F.f14618a.removeCallbacksAndMessages(null);
        w2.d dVar = this.Q;
        h2.f fVar = this.O;
        CopyOnWriteArrayList<w2.c> copyOnWriteArrayList = (CopyOnWriteArrayList) ((w2.g) dVar).f13860c.f7483w;
        for (w2.c cVar : copyOnWriteArrayList) {
            if (cVar.f13843b == fVar) {
                cVar.f13844c = true;
                copyOnWriteArrayList.remove(cVar);
            }
        }
        i1 i1Var = this.E0;
        if (i1Var.f4763p) {
            this.E0 = i1Var.a();
        }
        i1 i1VarY1 = y1(this.E0, 1);
        this.E0 = i1VarY1;
        i1 i1VarC = i1VarY1.c(i1VarY1.f4751b);
        this.E0 = i1VarC;
        i1VarC.f4764q = i1VarC.f4766s;
        this.E0.f4765r = 0L;
        h2.f fVar2 = this.O;
        y1.x xVar = fVar2.C;
        y1.d.h(xVar);
        xVar.c(new androidx.emoji2.text.w(14, fVar2));
        F1();
        Surface surface = this.f4701m0;
        if (surface != null) {
            surface.release();
            this.f4701m0 = null;
        }
        this.f4710w0 = x1.c.f14266d;
        this.A0 = true;
    }

    public final i1 D1(i1 i1Var, int i, int i10) {
        int iV1 = v1(i1Var);
        long jT1 = t1(i1Var);
        v1.f1 f1Var = i1Var.f4750a;
        ArrayList arrayList = this.L;
        int size = arrayList.size();
        this.f4692d0++;
        E1(i, i10);
        n1 n1Var = new n1(arrayList, this.f4696h0);
        i1 i1VarZ1 = z1(i1Var, n1Var, w1(f1Var, n1Var, iV1, jT1));
        int i11 = i1VarZ1.f4754e;
        if (i11 != 1 && i11 != 4 && i < i10 && i10 == size && iV1 >= i1VarZ1.f4750a.o()) {
            i1VarZ1 = y1(i1VarZ1, 4);
        }
        s2.d1 d1Var = this.f4696h0;
        y1.x xVar = this.H.C;
        xVar.getClass();
        y1.w wVarB = y1.x.b();
        wVarB.f14616a = xVar.f14618a.obtainMessage(20, i, i10, d1Var);
        wVarB.b();
        return i1VarZ1;
    }

    @Override // v1.w0
    public final int E() {
        P1();
        return this.E0.f4754e;
    }

    @Override // v1.w0
    public final v1.l1 E0() {
        P1();
        return ((v2.o) this.E).e();
    }

    public final void E1(int i, int i10) {
        for (int i11 = i10 - 1; i11 >= i; i11--) {
            this.L.remove(i11);
        }
        s2.d1 d1Var = this.f4696h0;
        int i12 = i10 - i;
        int[] iArr = d1Var.f11167b;
        int[] iArr2 = new int[iArr.length - i12];
        int i13 = 0;
        for (int i14 = 0; i14 < iArr.length; i14++) {
            int i15 = iArr[i14];
            if (i15 < i || i15 >= i10) {
                int i16 = i14 - i13;
                if (i15 >= i) {
                    i15 -= i12;
                }
                iArr2[i16] = i15;
            } else {
                i13++;
            }
        }
        this.f4696h0 = new s2.d1(iArr2, new Random(d1Var.f11166a.nextLong()));
    }

    @Override // v1.w0
    public final void F(int i) {
        P1();
    }

    public final void F1() {
        z2.k kVar = this.o0;
        d0 d0Var = this.U;
        if (kVar != null) {
            l1 l1VarS1 = s1(this.V);
            y1.d.g(!l1VarS1.f);
            l1VarS1.f4799c = 10000;
            y1.d.g(!l1VarS1.f);
            l1VarS1.f4800d = null;
            l1VarS1.b();
            this.o0.f15161v.remove(d0Var);
            this.o0 = null;
        }
        TextureView textureView = this.f4704q0;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != d0Var) {
                y1.b.p("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f4704q0.setSurfaceTextureListener(null);
            }
            this.f4704q0 = null;
        }
        SurfaceHolder surfaceHolder = this.f4702n0;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(d0Var);
            this.f4702n0 = null;
        }
    }

    @Override // v1.w0
    public final v1.n1 G() {
        P1();
        return this.E0.i.f13131d;
    }

    @Override // v1.w0
    public final long G0() {
        P1();
        if (this.E0.f4750a.p()) {
            return this.G0;
        }
        i1 i1Var = this.E0;
        long j4 = 0;
        if (i1Var.f4758k.f11159d != i1Var.f4751b.f11159d) {
            return y1.a0.b0(i1Var.f4750a.m(Y(), (v1.e1) this.f307w, 0L).f12653m);
        }
        long j7 = i1Var.f4764q;
        if (this.E0.f4758k.b()) {
            i1 i1Var2 = this.E0;
            i1Var2.f4750a.g(i1Var2.f4758k.f11156a, this.K).d(this.E0.f4758k.f11157b);
        } else {
            j4 = j7;
        }
        i1 i1Var3 = this.E0;
        v1.f1 f1Var = i1Var3.f4750a;
        Object obj = i1Var3.f4758k.f11156a;
        v1.c1 c1Var = this.K;
        f1Var.g(obj, c1Var);
        return y1.a0.b0(j4 + c1Var.f12620e);
    }

    public final void G1(int i, int i10, Object obj) {
        for (e eVar : this.C) {
            if (i == -1 || eVar.f4658w == i) {
                l1 l1VarS1 = s1(eVar);
                y1.d.g(!l1VarS1.f);
                l1VarS1.f4799c = i10;
                y1.d.g(!l1VarS1.f);
                l1VarS1.f4800d = obj;
                l1VarS1.b();
            }
        }
        for (e eVar2 : this.D) {
            if (eVar2 != null && (i == -1 || eVar2.f4658w == i)) {
                l1 l1VarS12 = s1(eVar2);
                y1.d.g(!l1VarS12.f);
                l1VarS12.f4799c = i10;
                y1.d.g(!l1VarS12.f);
                l1VarS12.f4800d = obj;
                l1VarS12.b();
            }
        }
    }

    @Override // v1.w0
    public final void H0(int i, int i10) {
        P1();
        y1.d.b(i >= 0 && i10 >= i);
        int size = this.L.size();
        int iMin = Math.min(i10, size);
        if (i >= size || i == iMin) {
            return;
        }
        i1 i1VarD1 = D1(this.E0, i, iMin);
        N1(i1VarD1, 0, !i1VarD1.f4751b.f11156a.equals(this.E0.f4751b.f11156a), 4, u1(i1VarD1), -1, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H1(java.util.List r16, int r17, long r18, boolean r20) {
        /*
            r15 = this;
            r1 = r17
            g2.i1 r2 = r15.E0
            int r2 = r15.v1(r2)
            long r3 = r15.V0()
            int r5 = r15.f4692d0
            r6 = 1
            int r5 = r5 + r6
            r15.f4692d0 = r5
            java.util.ArrayList r5 = r15.L
            boolean r7 = r5.isEmpty()
            r8 = 0
            if (r7 != 0) goto L22
            int r7 = r5.size()
            r15.E1(r8, r7)
        L22:
            r7 = r16
            java.util.ArrayList r10 = r15.n1(r8, r7)
            g2.n1 r7 = new g2.n1
            s2.d1 r9 = r15.f4696h0
            r7.<init>(r5, r9)
            boolean r5 = r7.p()
            int r9 = r7.f4813g
            if (r5 != 0) goto L40
            if (r1 >= r9) goto L3a
            goto L40
        L3a:
            j9.b r1 = new j9.b
            r1.<init>()
            throw r1
        L40:
            r5 = -1
            if (r20 == 0) goto L50
            boolean r1 = r15.f4691c0
            int r1 = r7.a(r1)
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L4e:
            r12 = r1
            goto L58
        L50:
            if (r1 != r5) goto L55
            r12 = r2
            r2 = r3
            goto L58
        L55:
            r2 = r18
            goto L4e
        L58:
            g2.i1 r1 = r15.E0
            android.util.Pair r4 = r15.A1(r7, r12, r2)
            g2.i1 r1 = r15.z1(r1, r7, r4)
            int r4 = r1.f4754e
            if (r12 == r5) goto L74
            if (r4 == r6) goto L74
            boolean r4 = r7.p()
            if (r4 != 0) goto L73
            if (r12 < r9) goto L71
            goto L73
        L71:
            r4 = 2
            goto L74
        L73:
            r4 = 4
        L74:
            g2.i1 r1 = y1(r1, r4)
            long r13 = y1.a0.O(r2)
            s2.d1 r11 = r15.f4696h0
            g2.o0 r2 = r15.H
            y1.x r2 = r2.C
            g2.j0 r9 = new g2.j0
            r9.<init>(r10, r11, r12, r13)
            r3 = 17
            y1.w r2 = r2.a(r3, r9)
            r2.b()
            g2.i1 r2 = r15.E0
            s2.c0 r2 = r2.f4751b
            java.lang.Object r2 = r2.f11156a
            s2.c0 r3 = r1.f4751b
            java.lang.Object r3 = r3.f11156a
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto Lac
            g2.i1 r2 = r15.E0
            v1.f1 r2 = r2.f4750a
            boolean r2 = r2.p()
            if (r2 != 0) goto Lac
            r3 = r6
            goto Lad
        Lac:
            r3 = r8
        Lad:
            long r5 = r15.u1(r1)
            r7 = -1
            r8 = 0
            r2 = 0
            r4 = 4
            r0 = r15
            r0.N1(r1, r2, r3, r4, r5, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.g0.H1(java.util.List, int, long, boolean):void");
    }

    @Override // v1.w0
    public final void I0(int i) {
        P1();
    }

    public final void I1(SurfaceHolder surfaceHolder) {
        this.f4703p0 = false;
        this.f4702n0 = surfaceHolder;
        surfaceHolder.addCallback(this.U);
        Surface surface = this.f4702n0.getSurface();
        if (surface == null || !surface.isValid()) {
            B1(0, 0);
        } else {
            Rect surfaceFrame = this.f4702n0.getSurfaceFrame();
            B1(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // v1.w0
    public final long J() {
        P1();
        return this.T;
    }

    public final void J1(Object obj) {
        Object obj2 = this.f4700l0;
        boolean zC = true;
        boolean z10 = (obj2 == null || obj2 == obj) ? false : true;
        long j4 = z10 ? this.Z : -9223372036854775807L;
        o0 o0Var = this.H;
        if (!o0Var.f4824d0 && o0Var.E.getThread().isAlive()) {
            y1.g gVar = new y1.g(o0Var.L);
            o0Var.C.a(30, new Pair(obj, gVar)).b();
            if (j4 != -9223372036854775807L) {
                zC = gVar.c(j4);
            }
        }
        if (z10) {
            Object obj3 = this.f4700l0;
            Surface surface = this.f4701m0;
            if (obj3 == surface) {
                surface.release();
                this.f4701m0 = null;
            }
        }
        this.f4700l0 = obj;
        if (zC) {
            return;
        }
        K1(new n(2, new a9.l("Detaching surface timed out."), 1003));
    }

    public final void K1(n nVar) {
        i1 i1Var = this.E0;
        i1 i1VarC = i1Var.c(i1Var.f4751b);
        i1VarC.f4764q = i1VarC.f4766s;
        i1VarC.f4765r = 0L;
        i1 i1VarY1 = y1(i1VarC, 1);
        if (nVar != null) {
            i1VarY1 = i1VarY1.f(nVar);
        }
        i1 i1Var2 = i1VarY1;
        this.f4692d0++;
        y1.x xVar = this.H.C;
        xVar.getClass();
        y1.w wVarB = y1.x.b();
        wVarB.f14616a = xVar.f14618a.obtainMessage(6);
        wVarB.b();
        N1(i1Var2, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // v1.w0
    public final v1.j0 L() {
        P1();
        return this.f4699k0;
    }

    @Override // v1.w0
    public final void L0(TextureView textureView) {
        P1();
        if (textureView == null) {
            q1();
            return;
        }
        F1();
        this.f4704q0 = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            y1.b.p("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.U);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            J1(null);
            B1(0, 0);
        } else {
            Surface surface = new Surface(surfaceTexture);
            J1(surface);
            this.f4701m0 = surface;
            B1(textureView.getWidth(), textureView.getHeight());
        }
    }

    public final void L1() {
        v1.s0 s0Var = this.f4697i0;
        int i = y1.a0.f14551a;
        g0 g0Var = this.B;
        boolean zL = g0Var.l();
        boolean zX = g0Var.x();
        boolean zC1 = g0Var.c1();
        boolean zB1 = g0Var.b1();
        boolean zX0 = g0Var.X0();
        boolean zQ0 = g0Var.q0();
        boolean zP = g0Var.v0().p();
        v1.r0 r0Var = new v1.r0();
        r0Var.f12977a = new o4(8);
        o4 o4Var = (o4) r0Var.f12977a;
        o4Var.d(this.f4713y.f12990a);
        boolean z10 = !zL;
        r0Var.a(4, z10);
        r0Var.a(5, zX && !zL);
        r0Var.a(6, zC1 && !zL);
        r0Var.a(7, !zP && (zC1 || !zX0 || zX) && !zL);
        r0Var.a(8, zB1 && !zL);
        r0Var.a(9, !zP && (zB1 || (zX0 && zQ0)) && !zL);
        r0Var.a(10, z10);
        r0Var.a(11, zX && !zL);
        r0Var.a(12, zX && !zL);
        v1.s0 s0Var2 = new v1.s0(o4Var.e());
        this.f4697i0 = s0Var2;
        if (s0Var2.equals(s0Var)) {
            return;
        }
        this.I.c(13, new z(this, 2));
    }

    public final void M1(int i, boolean z10) {
        i1 i1VarA = this.E0;
        int i10 = i1VarA.f4761n;
        int i11 = (i10 != 1 || z10) ? 0 : 1;
        if (i1VarA.f4759l == z10 && i10 == i11 && i1VarA.f4760m == i) {
            return;
        }
        this.f4692d0++;
        if (i1VarA.f4763p) {
            i1VarA = i1VarA.a();
        }
        i1 i1VarE = i1VarA.e(i, i11, z10);
        y1.x xVar = this.H.C;
        xVar.getClass();
        y1.w wVarB = y1.x.b();
        wVarB.f14616a = xVar.f14618a.obtainMessage(1, z10 ? 1 : 0, i | (i11 << 4));
        wVarB.b();
        N1(i1VarE, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // v1.w0
    public final void N0(v1.j0 j0Var) {
        P1();
        if (j0Var.equals(this.f4699k0)) {
            return;
        }
        this.f4699k0 = j0Var;
        this.I.e(15, new z(this, 3));
    }

    public final void N1(final i1 i1Var, int i, boolean z10, int i10, long j4, int i11, boolean z11) {
        Pair pair;
        int i12;
        v1.g0 g0Var;
        boolean z12;
        boolean z13;
        boolean z14;
        int i13;
        Object obj;
        v1.g0 g0Var2;
        Object obj2;
        int i14;
        long j7;
        long j10;
        long jX1;
        long jX12;
        Object obj3;
        v1.g0 g0Var3;
        Object obj4;
        int i15;
        i1 i1Var2 = this.E0;
        this.E0 = i1Var;
        boolean zEquals = i1Var2.f4750a.equals(i1Var.f4750a);
        v1.e1 e1Var = (v1.e1) this.f307w;
        v1.c1 c1Var = this.K;
        v1.f1 f1Var = i1Var2.f4750a;
        s2.c0 c0Var = i1Var2.f4751b;
        v1.f1 f1Var2 = i1Var.f4750a;
        s2.c0 c0Var2 = i1Var.f4751b;
        if (f1Var2.p() && f1Var.p()) {
            pair = new Pair(Boolean.FALSE, -1);
        } else if (f1Var2.p() != f1Var.p()) {
            pair = new Pair(Boolean.TRUE, 3);
        } else if (f1Var.m(f1Var.g(c0Var.f11156a, c1Var).f12618c, e1Var, 0L).f12643a.equals(f1Var2.m(f1Var2.g(c0Var2.f11156a, c1Var).f12618c, e1Var, 0L).f12643a)) {
            pair = (z10 && i10 == 0 && c0Var.f11159d < c0Var2.f11159d) ? new Pair(Boolean.TRUE, 0) : (z10 && i10 == 1 && z11) ? new Pair(Boolean.TRUE, 2) : new Pair(Boolean.FALSE, -1);
        } else {
            if (z10 && i10 == 0) {
                i12 = 1;
            } else if (z10 && i10 == 1) {
                i12 = 2;
            } else {
                if (zEquals) {
                    throw new IllegalStateException();
                }
                i12 = 3;
            }
            pair = new Pair(Boolean.TRUE, Integer.valueOf(i12));
        }
        boolean zBooleanValue = ((Boolean) pair.first).booleanValue();
        int iIntValue = ((Integer) pair.second).intValue();
        if (zBooleanValue) {
            g0Var = !i1Var.f4750a.p() ? i1Var.f4750a.m(i1Var.f4750a.g(i1Var.f4751b.f11156a, this.K).f12618c, (v1.e1) this.f307w, 0L).f12645c : null;
            this.D0 = v1.j0.K;
        } else {
            g0Var = null;
        }
        if (zBooleanValue || !i1Var2.f4757j.equals(i1Var.f4757j)) {
            v1.i0 i0VarA = this.D0.a();
            List list = i1Var.f4757j;
            for (int i16 = 0; i16 < list.size(); i16++) {
                v1.l0 l0Var = (v1.l0) list.get(i16);
                int i17 = 0;
                while (true) {
                    v1.k0[] k0VarArr = l0Var.f12828a;
                    if (i17 < k0VarArr.length) {
                        k0VarArr[i17].c(i0VarA);
                        i17++;
                    }
                }
            }
            this.D0 = new v1.j0(i0VarA);
        }
        v1.j0 j0VarP1 = p1();
        boolean zEquals2 = j0VarP1.equals(this.f4698j0);
        this.f4698j0 = j0VarP1;
        boolean z15 = i1Var2.f4759l != i1Var.f4759l;
        boolean z16 = i1Var2.f4754e != i1Var.f4754e;
        if (z16 || z15) {
            O1();
        }
        boolean z17 = i1Var2.f4755g != i1Var.f4755g;
        if (!zEquals) {
            this.I.c(0, new s(i, 0, i1Var));
        }
        if (z10) {
            v1.c1 c1Var2 = new v1.c1();
            if (i1Var2.f4750a.p()) {
                z12 = zBooleanValue;
                z13 = zEquals2;
                z14 = z16;
                i13 = i11;
                obj = null;
                g0Var2 = null;
                obj2 = null;
                i14 = -1;
            } else {
                Object obj5 = i1Var2.f4751b.f11156a;
                i1Var2.f4750a.g(obj5, c1Var2);
                int i18 = c1Var2.f12618c;
                int iB = i1Var2.f4750a.b(obj5);
                z12 = zBooleanValue;
                z13 = zEquals2;
                z14 = z16;
                obj = i1Var2.f4750a.m(i18, (v1.e1) this.f307w, 0L).f12643a;
                g0Var2 = ((v1.e1) this.f307w).f12645c;
                obj2 = obj5;
                i13 = i18;
                i14 = iB;
            }
            if (i10 == 0) {
                if (i1Var2.f4751b.b()) {
                    s2.c0 c0Var3 = i1Var2.f4751b;
                    jX1 = c1Var2.a(c0Var3.f11157b, c0Var3.f11158c);
                    jX12 = x1(i1Var2);
                } else if (i1Var2.f4751b.f11160e != -1) {
                    jX1 = x1(this.E0);
                    jX12 = jX1;
                } else {
                    j7 = c1Var2.f12620e;
                    j10 = c1Var2.f12619d;
                    jX1 = j7 + j10;
                    jX12 = jX1;
                }
            } else if (i1Var2.f4751b.b()) {
                jX1 = i1Var2.f4766s;
                jX12 = x1(i1Var2);
            } else {
                j7 = c1Var2.f12620e;
                j10 = i1Var2.f4766s;
                jX1 = j7 + j10;
                jX12 = jX1;
            }
            long jB0 = y1.a0.b0(jX1);
            long jB02 = y1.a0.b0(jX12);
            s2.c0 c0Var4 = i1Var2.f4751b;
            v1.v0 v0Var = new v1.v0(obj, i13, g0Var2, obj2, i14, jB0, jB02, c0Var4.f11157b, c0Var4.f11158c);
            v1.e1 e1Var2 = (v1.e1) this.f307w;
            int iY = Y();
            if (this.E0.f4750a.p()) {
                obj3 = null;
                g0Var3 = null;
                obj4 = null;
                i15 = -1;
            } else {
                i1 i1Var3 = this.E0;
                Object obj6 = i1Var3.f4751b.f11156a;
                i1Var3.f4750a.g(obj6, this.K);
                int iB2 = this.E0.f4750a.b(obj6);
                Object obj7 = this.E0.f4750a.m(iY, e1Var2, 0L).f12643a;
                g0Var3 = e1Var2.f12645c;
                i15 = iB2;
                obj4 = obj6;
                obj3 = obj7;
            }
            long jB03 = y1.a0.b0(j4);
            long jB04 = this.E0.f4751b.b() ? y1.a0.b0(x1(this.E0)) : jB03;
            s2.c0 c0Var5 = this.E0.f4751b;
            this.I.c(11, new d8.f(i10, v0Var, new v1.v0(obj3, iY, g0Var3, obj4, i15, jB03, jB04, c0Var5.f11157b, c0Var5.f11158c)));
        } else {
            z12 = zBooleanValue;
            z13 = zEquals2;
            z14 = z16;
        }
        if (z12) {
            this.I.c(1, new s(iIntValue, 1, g0Var));
        }
        if (i1Var2.f != i1Var.f) {
            final int i19 = 7;
            this.I.c(10, new y1.m() { // from class: g2.u
                @Override // y1.m
                public final void a(Object obj8) {
                    v1.u0 u0Var = (v1.u0) obj8;
                    switch (i19) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            i1 i1Var4 = i1Var;
                            u0Var.l(i1Var4.f4755g);
                            u0Var.q(i1Var4.f4755g);
                            break;
                        case 1:
                            i1 i1Var5 = i1Var;
                            u0Var.x(i1Var5.f4754e, i1Var5.f4759l);
                            break;
                        case 2:
                            u0Var.C(i1Var.f4754e);
                            break;
                        case 3:
                            i1 i1Var6 = i1Var;
                            u0Var.y(i1Var6.f4760m, i1Var6.f4759l);
                            break;
                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.g(i1Var.f4761n);
                            break;
                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.Q(i1Var.m());
                            break;
                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.D(i1Var.f4762o);
                            break;
                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.v(i1Var.f);
                            break;
                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                            u0Var.u(i1Var.f);
                            break;
                        default:
                            u0Var.M(i1Var.i.f13131d);
                            break;
                    }
                }
            });
            if (i1Var.f != null) {
                final int i20 = 8;
                this.I.c(10, new y1.m() { // from class: g2.u
                    @Override // y1.m
                    public final void a(Object obj8) {
                        v1.u0 u0Var = (v1.u0) obj8;
                        switch (i20) {
                            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                i1 i1Var4 = i1Var;
                                u0Var.l(i1Var4.f4755g);
                                u0Var.q(i1Var4.f4755g);
                                break;
                            case 1:
                                i1 i1Var5 = i1Var;
                                u0Var.x(i1Var5.f4754e, i1Var5.f4759l);
                                break;
                            case 2:
                                u0Var.C(i1Var.f4754e);
                                break;
                            case 3:
                                i1 i1Var6 = i1Var;
                                u0Var.y(i1Var6.f4760m, i1Var6.f4759l);
                                break;
                            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                                u0Var.g(i1Var.f4761n);
                                break;
                            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                                u0Var.Q(i1Var.m());
                                break;
                            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                                u0Var.D(i1Var.f4762o);
                                break;
                            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                                u0Var.v(i1Var.f);
                                break;
                            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                                u0Var.u(i1Var.f);
                                break;
                            default:
                                u0Var.M(i1Var.i.f13131d);
                                break;
                        }
                    }
                });
            }
        }
        v2.u uVar = i1Var2.i;
        v2.u uVar2 = i1Var.i;
        if (uVar != uVar2) {
            v2.t tVar = this.E;
            Object obj8 = uVar2.f13132e;
            tVar.getClass();
            final int i21 = 9;
            this.I.c(2, new y1.m() { // from class: g2.u
                @Override // y1.m
                public final void a(Object obj82) {
                    v1.u0 u0Var = (v1.u0) obj82;
                    switch (i21) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            i1 i1Var4 = i1Var;
                            u0Var.l(i1Var4.f4755g);
                            u0Var.q(i1Var4.f4755g);
                            break;
                        case 1:
                            i1 i1Var5 = i1Var;
                            u0Var.x(i1Var5.f4754e, i1Var5.f4759l);
                            break;
                        case 2:
                            u0Var.C(i1Var.f4754e);
                            break;
                        case 3:
                            i1 i1Var6 = i1Var;
                            u0Var.y(i1Var6.f4760m, i1Var6.f4759l);
                            break;
                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.g(i1Var.f4761n);
                            break;
                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.Q(i1Var.m());
                            break;
                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.D(i1Var.f4762o);
                            break;
                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.v(i1Var.f);
                            break;
                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                            u0Var.u(i1Var.f);
                            break;
                        default:
                            u0Var.M(i1Var.i.f13131d);
                            break;
                    }
                }
            });
        }
        if (!z13) {
            this.I.c(14, new t(this.f4698j0));
        }
        if (z17) {
            final int i22 = 0;
            this.I.c(3, new y1.m() { // from class: g2.u
                @Override // y1.m
                public final void a(Object obj82) {
                    v1.u0 u0Var = (v1.u0) obj82;
                    switch (i22) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            i1 i1Var4 = i1Var;
                            u0Var.l(i1Var4.f4755g);
                            u0Var.q(i1Var4.f4755g);
                            break;
                        case 1:
                            i1 i1Var5 = i1Var;
                            u0Var.x(i1Var5.f4754e, i1Var5.f4759l);
                            break;
                        case 2:
                            u0Var.C(i1Var.f4754e);
                            break;
                        case 3:
                            i1 i1Var6 = i1Var;
                            u0Var.y(i1Var6.f4760m, i1Var6.f4759l);
                            break;
                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.g(i1Var.f4761n);
                            break;
                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.Q(i1Var.m());
                            break;
                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.D(i1Var.f4762o);
                            break;
                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.v(i1Var.f);
                            break;
                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                            u0Var.u(i1Var.f);
                            break;
                        default:
                            u0Var.M(i1Var.i.f13131d);
                            break;
                    }
                }
            });
        }
        if (z14 || z15) {
            final int i23 = 1;
            this.I.c(-1, new y1.m() { // from class: g2.u
                @Override // y1.m
                public final void a(Object obj82) {
                    v1.u0 u0Var = (v1.u0) obj82;
                    switch (i23) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            i1 i1Var4 = i1Var;
                            u0Var.l(i1Var4.f4755g);
                            u0Var.q(i1Var4.f4755g);
                            break;
                        case 1:
                            i1 i1Var5 = i1Var;
                            u0Var.x(i1Var5.f4754e, i1Var5.f4759l);
                            break;
                        case 2:
                            u0Var.C(i1Var.f4754e);
                            break;
                        case 3:
                            i1 i1Var6 = i1Var;
                            u0Var.y(i1Var6.f4760m, i1Var6.f4759l);
                            break;
                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.g(i1Var.f4761n);
                            break;
                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.Q(i1Var.m());
                            break;
                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.D(i1Var.f4762o);
                            break;
                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.v(i1Var.f);
                            break;
                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                            u0Var.u(i1Var.f);
                            break;
                        default:
                            u0Var.M(i1Var.i.f13131d);
                            break;
                    }
                }
            });
        }
        if (z14) {
            final int i24 = 2;
            this.I.c(4, new y1.m() { // from class: g2.u
                @Override // y1.m
                public final void a(Object obj82) {
                    v1.u0 u0Var = (v1.u0) obj82;
                    switch (i24) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            i1 i1Var4 = i1Var;
                            u0Var.l(i1Var4.f4755g);
                            u0Var.q(i1Var4.f4755g);
                            break;
                        case 1:
                            i1 i1Var5 = i1Var;
                            u0Var.x(i1Var5.f4754e, i1Var5.f4759l);
                            break;
                        case 2:
                            u0Var.C(i1Var.f4754e);
                            break;
                        case 3:
                            i1 i1Var6 = i1Var;
                            u0Var.y(i1Var6.f4760m, i1Var6.f4759l);
                            break;
                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.g(i1Var.f4761n);
                            break;
                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.Q(i1Var.m());
                            break;
                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.D(i1Var.f4762o);
                            break;
                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.v(i1Var.f);
                            break;
                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                            u0Var.u(i1Var.f);
                            break;
                        default:
                            u0Var.M(i1Var.i.f13131d);
                            break;
                    }
                }
            });
        }
        if (z15 || i1Var2.f4760m != i1Var.f4760m) {
            final int i25 = 3;
            this.I.c(5, new y1.m() { // from class: g2.u
                @Override // y1.m
                public final void a(Object obj82) {
                    v1.u0 u0Var = (v1.u0) obj82;
                    switch (i25) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            i1 i1Var4 = i1Var;
                            u0Var.l(i1Var4.f4755g);
                            u0Var.q(i1Var4.f4755g);
                            break;
                        case 1:
                            i1 i1Var5 = i1Var;
                            u0Var.x(i1Var5.f4754e, i1Var5.f4759l);
                            break;
                        case 2:
                            u0Var.C(i1Var.f4754e);
                            break;
                        case 3:
                            i1 i1Var6 = i1Var;
                            u0Var.y(i1Var6.f4760m, i1Var6.f4759l);
                            break;
                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.g(i1Var.f4761n);
                            break;
                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.Q(i1Var.m());
                            break;
                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.D(i1Var.f4762o);
                            break;
                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.v(i1Var.f);
                            break;
                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                            u0Var.u(i1Var.f);
                            break;
                        default:
                            u0Var.M(i1Var.i.f13131d);
                            break;
                    }
                }
            });
        }
        if (i1Var2.f4761n != i1Var.f4761n) {
            final int i26 = 4;
            this.I.c(6, new y1.m() { // from class: g2.u
                @Override // y1.m
                public final void a(Object obj82) {
                    v1.u0 u0Var = (v1.u0) obj82;
                    switch (i26) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            i1 i1Var4 = i1Var;
                            u0Var.l(i1Var4.f4755g);
                            u0Var.q(i1Var4.f4755g);
                            break;
                        case 1:
                            i1 i1Var5 = i1Var;
                            u0Var.x(i1Var5.f4754e, i1Var5.f4759l);
                            break;
                        case 2:
                            u0Var.C(i1Var.f4754e);
                            break;
                        case 3:
                            i1 i1Var6 = i1Var;
                            u0Var.y(i1Var6.f4760m, i1Var6.f4759l);
                            break;
                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.g(i1Var.f4761n);
                            break;
                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.Q(i1Var.m());
                            break;
                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.D(i1Var.f4762o);
                            break;
                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.v(i1Var.f);
                            break;
                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                            u0Var.u(i1Var.f);
                            break;
                        default:
                            u0Var.M(i1Var.i.f13131d);
                            break;
                    }
                }
            });
        }
        if (i1Var2.m() != i1Var.m()) {
            final int i27 = 5;
            this.I.c(7, new y1.m() { // from class: g2.u
                @Override // y1.m
                public final void a(Object obj82) {
                    v1.u0 u0Var = (v1.u0) obj82;
                    switch (i27) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            i1 i1Var4 = i1Var;
                            u0Var.l(i1Var4.f4755g);
                            u0Var.q(i1Var4.f4755g);
                            break;
                        case 1:
                            i1 i1Var5 = i1Var;
                            u0Var.x(i1Var5.f4754e, i1Var5.f4759l);
                            break;
                        case 2:
                            u0Var.C(i1Var.f4754e);
                            break;
                        case 3:
                            i1 i1Var6 = i1Var;
                            u0Var.y(i1Var6.f4760m, i1Var6.f4759l);
                            break;
                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.g(i1Var.f4761n);
                            break;
                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.Q(i1Var.m());
                            break;
                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.D(i1Var.f4762o);
                            break;
                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.v(i1Var.f);
                            break;
                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                            u0Var.u(i1Var.f);
                            break;
                        default:
                            u0Var.M(i1Var.i.f13131d);
                            break;
                    }
                }
            });
        }
        if (!i1Var2.f4762o.equals(i1Var.f4762o)) {
            final int i28 = 6;
            this.I.c(12, new y1.m() { // from class: g2.u
                @Override // y1.m
                public final void a(Object obj82) {
                    v1.u0 u0Var = (v1.u0) obj82;
                    switch (i28) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            i1 i1Var4 = i1Var;
                            u0Var.l(i1Var4.f4755g);
                            u0Var.q(i1Var4.f4755g);
                            break;
                        case 1:
                            i1 i1Var5 = i1Var;
                            u0Var.x(i1Var5.f4754e, i1Var5.f4759l);
                            break;
                        case 2:
                            u0Var.C(i1Var.f4754e);
                            break;
                        case 3:
                            i1 i1Var6 = i1Var;
                            u0Var.y(i1Var6.f4760m, i1Var6.f4759l);
                            break;
                        case g1.h.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.g(i1Var.f4761n);
                            break;
                        case g1.h.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.Q(i1Var.m());
                            break;
                        case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.D(i1Var.f4762o);
                            break;
                        case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.v(i1Var.f);
                            break;
                        case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                            u0Var.u(i1Var.f);
                            break;
                        default:
                            u0Var.M(i1Var.i.f13131d);
                            break;
                    }
                }
            });
        }
        L1();
        this.I.b();
        if (i1Var2.f4763p != i1Var.f4763p) {
            Iterator it = this.J.iterator();
            while (it.hasNext()) {
                ((d0) it.next()).f4651v.O1();
            }
        }
    }

    @Override // v1.w0
    public final int O() {
        P1();
        if (this.E0.f4750a.p()) {
            return 0;
        }
        i1 i1Var = this.E0;
        return i1Var.f4750a.b(i1Var.f4751b.f11156a);
    }

    @Override // v1.w0
    public final void O0(float f) {
        P1();
        float fH = y1.a0.h(f, 0.0f, 1.0f);
        if (this.f4708u0 == fH) {
            return;
        }
        this.f4708u0 = fH;
        this.H.C.a(32, Float.valueOf(fH)).b();
        this.I.e(22, new v(0, fH));
    }

    public final void O1() {
        int iE = E();
        a3.l0 l0Var = this.Y;
        a3.l0 l0Var2 = this.X;
        boolean z10 = false;
        if (iE != 1) {
            if (iE == 2 || iE == 3) {
                P1();
                boolean z11 = this.E0.f4763p;
                if (w() && !z11) {
                    z10 = true;
                }
                l0Var2.a(z10);
                l0Var.a(w());
                return;
            }
            if (iE != 4) {
                throw new IllegalStateException();
            }
        }
        l0Var2.a(false);
        l0Var.a(false);
    }

    @Override // v1.w0
    public final x1.c P() {
        P1();
        return this.f4710w0;
    }

    @Override // v1.w0
    public final v1.j0 P0() {
        P1();
        return this.f4698j0;
    }

    public final void P1() {
        this.f4715z.b();
        Thread threadCurrentThread = Thread.currentThread();
        Looper looper = this.P;
        if (threadCurrentThread != looper.getThread()) {
            String name = Thread.currentThread().getName();
            String name2 = looper.getThread().getName();
            int i = y1.a0.f14551a;
            Locale locale = Locale.US;
            String str = "Player is accessed on the wrong thread.\nCurrent thread: '" + name + "'\nExpected thread: '" + name2 + "'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread";
            if (this.f4712x0) {
                throw new IllegalStateException(str);
            }
            y1.b.q("ExoPlayerImpl", str, this.f4714y0 ? null : new IllegalStateException());
            this.f4714y0 = true;
        }
    }

    @Override // v1.w0
    public final void Q(TextureView textureView) {
        P1();
        if (textureView == null || textureView != this.f4704q0) {
            return;
        }
        q1();
    }

    @Override // v1.w0
    public final void Q0(List list) {
        P1();
        ArrayList arrayListR1 = r1(list);
        P1();
        H1(arrayListR1, -1, -9223372036854775807L, true);
    }

    @Override // v1.w0
    public final v1.r1 R() {
        P1();
        return this.C0;
    }

    @Override // v1.w0
    public final void T0(v1.u0 u0Var) {
        u0Var.getClass();
        this.I.a(u0Var);
    }

    @Override // v1.w0
    public final float U() {
        P1();
        return this.f4708u0;
    }

    @Override // v1.w0
    public final long V0() {
        P1();
        return y1.a0.b0(u1(this.E0));
    }

    @Override // v1.w0
    public final v1.c W() {
        P1();
        return this.f4707t0;
    }

    @Override // v1.w0
    public final long W0() {
        P1();
        return this.R;
    }

    @Override // v1.w0
    public final int X() {
        P1();
        if (l()) {
            return this.E0.f4751b.f11157b;
        }
        return -1;
    }

    @Override // v1.w0
    public final int Y() {
        P1();
        int iV1 = v1(this.E0);
        if (iV1 == -1) {
            return 0;
        }
        return iV1;
    }

    @Override // v1.w0
    public final boolean a() {
        P1();
        return this.E0.f4755g;
    }

    @Override // v1.w0
    public final void b() {
        P1();
        i1 i1Var = this.E0;
        if (i1Var.f4754e != 1) {
            return;
        }
        i1 i1VarF = i1Var.f(null);
        i1 i1VarY1 = y1(i1VarF, i1VarF.f4750a.p() ? 4 : 2);
        this.f4692d0++;
        y1.x xVar = this.H.C;
        xVar.getClass();
        y1.w wVarB = y1.x.b();
        wVarB.f14616a = xVar.f14618a.obtainMessage(29);
        wVarB.b();
        N1(i1VarY1, 1, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // v1.w0
    public final void b0(int i, boolean z10) {
        P1();
    }

    @Override // v1.w0
    public final v1.i c0() {
        P1();
        return this.B0;
    }

    @Override // v1.w0
    public final v1.q0 d() {
        P1();
        return this.E0.f4762o;
    }

    @Override // v1.w0
    public final void d0() {
        P1();
    }

    @Override // v1.w0
    public final void e0(v1.l1 l1Var) {
        P1();
        v2.t tVar = this.E;
        tVar.getClass();
        v1.l1 l1VarE0 = E0();
        if (!l1Var.equals(((v2.o) tVar).e())) {
            tVar.b(l1Var);
        }
        if (l1VarE0.equals(l1Var)) {
            return;
        }
        this.I.e(19, new androidx.fragment.app.f1(9, l1Var));
    }

    @Override // v1.w0
    public final void f(v1.q0 q0Var) {
        P1();
        if (this.E0.f4762o.equals(q0Var)) {
            return;
        }
        i1 i1VarG = this.E0.g(q0Var);
        this.f4692d0++;
        this.H.C.a(4, q0Var).b();
        N1(i1VarG, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // v1.w0
    public final void g(List list, int i, long j4) {
        P1();
        ArrayList arrayListR1 = r1(list);
        P1();
        H1(arrayListR1, i, j4, false);
    }

    @Override // v1.w0
    public final void g0(int i) {
        P1();
        if (this.f4690b0 != i) {
            this.f4690b0 = i;
            y1.x xVar = this.H.C;
            xVar.getClass();
            y1.w wVarB = y1.x.b();
            wVarB.f14616a = xVar.f14618a.obtainMessage(11, i, 0);
            wVarB.b();
            x xVar2 = new x(i, 0);
            y1.p pVar = this.I;
            pVar.c(8, xVar2);
            L1();
            pVar.b();
        }
    }

    @Override // v1.w0
    public final long getDuration() {
        P1();
        if (!l()) {
            return N();
        }
        i1 i1Var = this.E0;
        s2.c0 c0Var = i1Var.f4751b;
        v1.f1 f1Var = i1Var.f4750a;
        Object obj = c0Var.f11156a;
        v1.c1 c1Var = this.K;
        f1Var.g(obj, c1Var);
        return y1.a0.b0(c1Var.a(c0Var.f11157b, c0Var.f11158c));
    }

    @Override // v1.w0
    public final v1.p0 h() {
        P1();
        return this.E0.f;
    }

    @Override // v1.w0
    public final void h0(int i, int i10) {
        P1();
    }

    @Override // v1.w0
    public final int i() {
        P1();
        return 0;
    }

    @Override // v1.w0
    public final void i0(boolean z10) {
        P1();
    }

    @Override // v1.w0
    public final void j(boolean z10) {
        P1();
        M1(1, z10);
    }

    @Override // v1.w0
    public final void j0(int i) {
        P1();
    }

    @Override // a7.a
    public final void j1(int i, long j4, boolean z10) {
        P1();
        if (i == -1) {
            return;
        }
        y1.d.b(i >= 0);
        v1.f1 f1Var = this.E0.f4750a;
        if (f1Var.p() || i < f1Var.o()) {
            h2.f fVar = this.O;
            if (!fVar.D) {
                h2.a aVarR = fVar.R();
                fVar.D = true;
                fVar.W(aVarR, -1, new a3.m(29));
            }
            this.f4692d0++;
            if (l()) {
                y1.b.p("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                l0 l0Var = new l0(this.E0);
                l0Var.f(1);
                g0 g0Var = this.G.f4951w;
                g0Var.F.c(new androidx.fragment.app.d(5, g0Var, l0Var));
                return;
            }
            i1 i1VarH = this.E0;
            int i10 = i1VarH.f4754e;
            if (i10 == 3 || (i10 == 4 && !f1Var.p())) {
                i1VarH = this.E0.h(2);
            }
            int iY = Y();
            i1 i1VarZ1 = z1(i1VarH, f1Var, A1(f1Var, i, j4));
            this.H.C.a(3, new n0(f1Var, i, y1.a0.O(j4))).b();
            N1(i1VarZ1, 0, true, 1, u1(i1VarZ1), iY, z10);
        }
    }

    @Override // v1.w0
    public final void k(Surface surface) {
        P1();
        F1();
        J1(surface);
        int i = surface == null ? 0 : -1;
        B1(i, i);
    }

    @Override // v1.w0
    public final int k0() {
        P1();
        if (l()) {
            return this.E0.f4751b.f11158c;
        }
        return -1;
    }

    @Override // v1.w0
    public final boolean l() {
        P1();
        return this.E0.f4751b.b();
    }

    @Override // v1.w0
    public final void l0(SurfaceView surfaceView) {
        P1();
        if (surfaceView instanceof y2.t) {
            F1();
            J1(surfaceView);
            I1(surfaceView.getHolder());
            return;
        }
        boolean z10 = surfaceView instanceof z2.k;
        d0 d0Var = this.U;
        if (z10) {
            F1();
            this.o0 = (z2.k) surfaceView;
            l1 l1VarS1 = s1(this.V);
            y1.d.g(!l1VarS1.f);
            l1VarS1.f4799c = 10000;
            z2.k kVar = this.o0;
            y1.d.g(true ^ l1VarS1.f);
            l1VarS1.f4800d = kVar;
            l1VarS1.b();
            this.o0.f15161v.add(d0Var);
            J1(this.o0.getVideoSurface());
            I1(surfaceView.getHolder());
            return;
        }
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        P1();
        if (holder == null) {
            q1();
            return;
        }
        F1();
        this.f4703p0 = true;
        this.f4702n0 = holder;
        holder.addCallback(d0Var);
        Surface surface = holder.getSurface();
        if (surface == null || !surface.isValid()) {
            J1(null);
            B1(0, 0);
        } else {
            J1(surface);
            Rect surfaceFrame = holder.getSurfaceFrame();
            B1(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // v1.w0
    public final void m0(v1.u0 u0Var) {
        P1();
        u0Var.getClass();
        y1.p pVar = this.I;
        pVar.f();
        CopyOnWriteArraySet<y1.o> copyOnWriteArraySet = pVar.f14594d;
        for (y1.o oVar : copyOnWriteArraySet) {
            if (oVar.f14587a.equals(u0Var)) {
                y1.n nVar = pVar.f14593c;
                oVar.f14590d = true;
                if (oVar.f14589c) {
                    oVar.f14589c = false;
                    nVar.b(oVar.f14587a, oVar.f14588b.e());
                }
                copyOnWriteArraySet.remove(oVar);
            }
        }
    }

    @Override // v1.w0
    public final void n0(SurfaceView surfaceView) {
        P1();
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        P1();
        if (holder == null || holder != this.f4702n0) {
            return;
        }
        q1();
    }

    public final ArrayList n1(int i, List list) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            g1 g1Var = new g1((s2.a) list.get(i10), this.M);
            arrayList.add(g1Var);
            f0 f0Var = new f0(g1Var.f4718b, g1Var.f4717a);
            this.L.add(i10 + i, f0Var);
        }
        this.f4696h0 = this.f4696h0.a(i, arrayList.size());
        return arrayList;
    }

    @Override // v1.w0
    public final long o() {
        P1();
        return this.S;
    }

    public final i1 o1(i1 i1Var, int i, ArrayList arrayList) {
        v1.f1 f1Var = i1Var.f4750a;
        this.f4692d0++;
        ArrayList arrayListN1 = n1(i, arrayList);
        n1 n1Var = new n1(this.L, this.f4696h0);
        i1 i1VarZ1 = z1(i1Var, n1Var, w1(f1Var, n1Var, v1(i1Var), t1(i1Var)));
        s2.d1 d1Var = this.f4696h0;
        y1.x xVar = this.H.C;
        j0 j0Var = new j0(arrayListN1, d1Var, -1, -9223372036854775807L);
        xVar.getClass();
        y1.w wVarB = y1.x.b();
        wVarB.f14616a = xVar.f14618a.obtainMessage(18, i, 0, j0Var);
        wVarB.b();
        return i1VarZ1;
    }

    @Override // v1.w0
    public final void p0(int i, int i10, int i11) {
        P1();
        y1.d.b(i >= 0 && i <= i10 && i11 >= 0);
        ArrayList arrayList = this.L;
        int size = arrayList.size();
        int iMin = Math.min(i10, size);
        int iMin2 = Math.min(i11, size - (iMin - i));
        if (i >= size || i == iMin || i == iMin2) {
            return;
        }
        v1.f1 f1VarV0 = v0();
        this.f4692d0++;
        y1.a0.N(arrayList, i, iMin, iMin2);
        s2.d1 d1Var = this.f4696h0;
        d1Var.getClass();
        this.f4696h0 = d1Var;
        n1 n1Var = new n1(arrayList, this.f4696h0);
        i1 i1Var = this.E0;
        i1 i1VarZ1 = z1(i1Var, n1Var, w1(f1VarV0, n1Var, v1(i1Var), t1(this.E0)));
        s2.d1 d1Var2 = this.f4696h0;
        o0 o0Var = this.H;
        o0Var.getClass();
        o0Var.C.a(19, new k0(i, iMin, iMin2, d1Var2)).b();
        N1(i1VarZ1, 0, false, 5, -9223372036854775807L, -1, false);
    }

    public final v1.j0 p1() {
        v1.f1 f1VarV0 = v0();
        if (f1VarV0.p()) {
            return this.D0;
        }
        v1.g0 g0Var = f1VarV0.m(Y(), (v1.e1) this.f307w, 0L).f12645c;
        v1.i0 i0VarA = this.D0.a();
        v1.j0 j0Var = g0Var.f12699d;
        if (j0Var != null) {
            ua.i0 i0Var = j0Var.J;
            byte[] bArr = j0Var.f12773k;
            CharSequence charSequence = j0Var.f12765a;
            if (charSequence != null) {
                i0VarA.f12718a = charSequence;
            }
            CharSequence charSequence2 = j0Var.f12766b;
            if (charSequence2 != null) {
                i0VarA.f12719b = charSequence2;
            }
            CharSequence charSequence3 = j0Var.f12767c;
            if (charSequence3 != null) {
                i0VarA.f12720c = charSequence3;
            }
            CharSequence charSequence4 = j0Var.f12768d;
            if (charSequence4 != null) {
                i0VarA.f12721d = charSequence4;
            }
            CharSequence charSequence5 = j0Var.f12769e;
            if (charSequence5 != null) {
                i0VarA.f12722e = charSequence5;
            }
            CharSequence charSequence6 = j0Var.f;
            if (charSequence6 != null) {
                i0VarA.f = charSequence6;
            }
            CharSequence charSequence7 = j0Var.f12770g;
            if (charSequence7 != null) {
                i0VarA.f12723g = charSequence7;
            }
            Long l10 = j0Var.f12771h;
            if (l10 != null) {
                y1.d.b(l10.longValue() >= 0);
                i0VarA.f12724h = l10;
            }
            v1.x0 x0Var = j0Var.i;
            if (x0Var != null) {
                i0VarA.i = x0Var;
            }
            v1.x0 x0Var2 = j0Var.f12772j;
            if (x0Var2 != null) {
                i0VarA.f12725j = x0Var2;
            }
            Uri uri = j0Var.f12775m;
            if (uri != null || bArr != null) {
                i0VarA.f12728m = uri;
                Integer num = j0Var.f12774l;
                i0VarA.f12726k = bArr == null ? null : (byte[]) bArr.clone();
                i0VarA.f12727l = num;
            }
            Integer num2 = j0Var.f12776n;
            if (num2 != null) {
                i0VarA.f12729n = num2;
            }
            Integer num3 = j0Var.f12777o;
            if (num3 != null) {
                i0VarA.f12730o = num3;
            }
            Integer num4 = j0Var.f12778p;
            if (num4 != null) {
                i0VarA.f12731p = num4;
            }
            Boolean bool = j0Var.f12779q;
            if (bool != null) {
                i0VarA.f12732q = bool;
            }
            Boolean bool2 = j0Var.f12780r;
            if (bool2 != null) {
                i0VarA.f12733r = bool2;
            }
            Integer num5 = j0Var.f12781s;
            if (num5 != null) {
                i0VarA.f12734s = num5;
            }
            Integer num6 = j0Var.f12782t;
            if (num6 != null) {
                i0VarA.f12734s = num6;
            }
            Integer num7 = j0Var.f12783u;
            if (num7 != null) {
                i0VarA.f12735t = num7;
            }
            Integer num8 = j0Var.f12784v;
            if (num8 != null) {
                i0VarA.f12736u = num8;
            }
            Integer num9 = j0Var.f12785w;
            if (num9 != null) {
                i0VarA.f12737v = num9;
            }
            Integer num10 = j0Var.f12786x;
            if (num10 != null) {
                i0VarA.f12738w = num10;
            }
            Integer num11 = j0Var.f12787y;
            if (num11 != null) {
                i0VarA.f12739x = num11;
            }
            CharSequence charSequence8 = j0Var.f12788z;
            if (charSequence8 != null) {
                i0VarA.f12740y = charSequence8;
            }
            CharSequence charSequence9 = j0Var.A;
            if (charSequence9 != null) {
                i0VarA.f12741z = charSequence9;
            }
            CharSequence charSequence10 = j0Var.B;
            if (charSequence10 != null) {
                i0VarA.A = charSequence10;
            }
            Integer num12 = j0Var.C;
            if (num12 != null) {
                i0VarA.B = num12;
            }
            Integer num13 = j0Var.D;
            if (num13 != null) {
                i0VarA.C = num13;
            }
            CharSequence charSequence11 = j0Var.E;
            if (charSequence11 != null) {
                i0VarA.D = charSequence11;
            }
            CharSequence charSequence12 = j0Var.F;
            if (charSequence12 != null) {
                i0VarA.E = charSequence12;
            }
            CharSequence charSequence13 = j0Var.G;
            if (charSequence13 != null) {
                i0VarA.F = charSequence13;
            }
            Integer num14 = j0Var.H;
            if (num14 != null) {
                i0VarA.G = num14;
            }
            Bundle bundle = j0Var.I;
            if (bundle != null) {
                i0VarA.H = bundle;
            }
            if (!i0Var.isEmpty()) {
                i0VarA.I = ua.i0.k(i0Var);
            }
        }
        return new v1.j0(i0VarA);
    }

    @Override // v1.w0
    public final long q() {
        P1();
        return t1(this.E0);
    }

    public final void q1() {
        P1();
        F1();
        J1(null);
        B1(0, 0);
    }

    @Override // v1.w0
    public final long r() {
        P1();
        return y1.a0.b0(this.E0.f4765r);
    }

    @Override // v1.w0
    public final int r0() {
        P1();
        return this.E0.f4761n;
    }

    public final ArrayList r1(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(this.N.d((v1.g0) list.get(i)));
        }
        return arrayList;
    }

    @Override // v1.w0
    public final void s0(int i, int i10, List list) {
        P1();
        y1.d.b(i >= 0 && i10 >= i);
        ArrayList arrayList = this.L;
        int size = arrayList.size();
        if (i > size) {
            return;
        }
        int iMin = Math.min(i10, size);
        if (iMin - i == list.size()) {
            for (int i11 = i; i11 < iMin; i11++) {
                if (((f0) arrayList.get(i11)).f4679b.f11276k.a((v1.g0) list.get(i11 - i))) {
                }
            }
            this.f4692d0++;
            y1.x xVar = this.H.C;
            xVar.getClass();
            y1.w wVarB = y1.x.b();
            wVarB.f14616a = xVar.f14618a.obtainMessage(27, i, iMin, list);
            wVarB.b();
            for (int i12 = i; i12 < iMin; i12++) {
                f0 f0Var = (f0) arrayList.get(i12);
                f0Var.f4680c = new m1(f0Var.f4680c, (v1.g0) list.get(i12 - i));
            }
            N1(this.E0.j(new n1(arrayList, this.f4696h0)), 0, false, 4, -9223372036854775807L, -1, false);
            return;
        }
        ArrayList arrayListR1 = r1(list);
        if (!arrayList.isEmpty()) {
            i1 i1VarD1 = D1(o1(this.E0, iMin, arrayListR1), i, iMin);
            N1(i1VarD1, 0, !i1VarD1.f4751b.f11156a.equals(this.E0.f4751b.f11156a), 4, u1(i1VarD1), -1, false);
        } else {
            boolean z10 = this.F0 == -1;
            P1();
            H1(arrayListR1, -1, -9223372036854775807L, z10);
        }
    }

    public final l1 s1(k1 k1Var) {
        int iV1 = v1(this.E0);
        v1.f1 f1Var = this.E0.f4750a;
        if (iV1 == -1) {
            iV1 = 0;
        }
        o0 o0Var = this.H;
        return new l1(o0Var, k1Var, f1Var, iV1, o0Var.E);
    }

    @Override // v1.w0
    public final void stop() {
        P1();
        K1(null);
        this.f4710w0 = new x1.c(this.E0.f4766s, ua.z0.f12413z);
    }

    @Override // v1.w0
    public final void t(int i, List list) {
        P1();
        ArrayList arrayListR1 = r1(list);
        P1();
        y1.d.b(i >= 0);
        ArrayList arrayList = this.L;
        int iMin = Math.min(i, arrayList.size());
        if (!arrayList.isEmpty()) {
            N1(o1(this.E0, iMin, arrayListR1), 0, false, 5, -9223372036854775807L, -1, false);
            return;
        }
        boolean z10 = this.F0 == -1;
        P1();
        H1(arrayListR1, -1, -9223372036854775807L, z10);
    }

    public final long t1(i1 i1Var) {
        s2.c0 c0Var = i1Var.f4751b;
        long j4 = i1Var.f4752c;
        v1.f1 f1Var = i1Var.f4750a;
        if (!c0Var.b()) {
            return y1.a0.b0(u1(i1Var));
        }
        Object obj = i1Var.f4751b.f11156a;
        v1.c1 c1Var = this.K;
        f1Var.g(obj, c1Var);
        if (j4 == -9223372036854775807L) {
            return y1.a0.b0(f1Var.m(v1(i1Var), (v1.e1) this.f307w, 0L).f12652l);
        }
        return y1.a0.b0(j4) + y1.a0.b0(c1Var.f12620e);
    }

    @Override // v1.w0
    public final v1.s0 u() {
        P1();
        return this.f4697i0;
    }

    @Override // v1.w0
    public final int u0() {
        P1();
        return this.f4690b0;
    }

    public final long u1(i1 i1Var) {
        if (i1Var.f4750a.p()) {
            return y1.a0.O(this.G0);
        }
        long jL = i1Var.f4763p ? i1Var.l() : i1Var.f4766s;
        if (i1Var.f4751b.b()) {
            return jL;
        }
        v1.f1 f1Var = i1Var.f4750a;
        Object obj = i1Var.f4751b.f11156a;
        v1.c1 c1Var = this.K;
        f1Var.g(obj, c1Var);
        return jL + c1Var.f12620e;
    }

    @Override // v1.w0
    public final long v() {
        P1();
        if (!l()) {
            return G0();
        }
        i1 i1Var = this.E0;
        return i1Var.f4758k.equals(i1Var.f4751b) ? y1.a0.b0(this.E0.f4764q) : getDuration();
    }

    @Override // v1.w0
    public final v1.f1 v0() {
        P1();
        return this.E0.f4750a;
    }

    public final int v1(i1 i1Var) {
        return i1Var.f4750a.p() ? this.F0 : i1Var.f4750a.g(i1Var.f4751b.f11156a, this.K).f12618c;
    }

    @Override // v1.w0
    public final boolean w() {
        P1();
        return this.E0.f4759l;
    }

    @Override // v1.w0
    public final boolean w0() {
        P1();
        return false;
    }

    public final Pair w1(v1.f1 f1Var, n1 n1Var, int i, long j4) {
        if (f1Var.p() || n1Var.p()) {
            boolean z10 = !f1Var.p() && n1Var.p();
            return A1(n1Var, z10 ? -1 : i, z10 ? -9223372036854775807L : j4);
        }
        Pair pairI = f1Var.i((v1.e1) this.f307w, this.K, i, y1.a0.O(j4));
        Object obj = pairI.first;
        if (n1Var.b(obj) != -1) {
            return pairI;
        }
        int iT = o0.T((v1.e1) this.f307w, this.K, this.f4690b0, this.f4691c0, obj, f1Var, n1Var);
        if (iT == -1) {
            return A1(n1Var, -1, -9223372036854775807L);
        }
        v1.e1 e1Var = (v1.e1) this.f307w;
        n1Var.m(iT, e1Var, 0L);
        return A1(n1Var, iT, y1.a0.b0(e1Var.f12652l));
    }

    @Override // v1.w0
    public final void x0(v1.c cVar, boolean z10) {
        P1();
        if (this.A0) {
            return;
        }
        boolean zEquals = Objects.equals(this.f4707t0, cVar);
        y1.p pVar = this.I;
        if (!zEquals) {
            this.f4707t0 = cVar;
            G1(1, 3, cVar);
            pVar.c(20, new androidx.fragment.app.f1(10, cVar));
        }
        v1.c cVar2 = this.f4707t0;
        y1.x xVar = this.H.C;
        xVar.getClass();
        y1.w wVarB = y1.x.b();
        wVarB.f14616a = xVar.f14618a.obtainMessage(31, z10 ? 1 : 0, 0, cVar2);
        wVarB.b();
        pVar.b();
    }

    @Override // v1.w0
    public final Looper y0() {
        return this.P;
    }

    public final i1 z1(i1 i1Var, v1.f1 f1Var, Pair pair) {
        List list;
        y1.d.b(f1Var.p() || pair != null);
        v1.f1 f1Var2 = i1Var.f4750a;
        long jT1 = t1(i1Var);
        i1 i1VarJ = i1Var.j(f1Var);
        if (f1Var.p()) {
            s2.c0 c0Var = i1.f4749u;
            long jO = y1.a0.O(this.G0);
            i1 i1VarC = i1VarJ.d(c0Var, jO, jO, jO, 0L, s2.l1.f11260d, this.f4711x, ua.z0.f12413z).c(c0Var);
            i1VarC.f4764q = i1VarC.f4766s;
            return i1VarC;
        }
        Object obj = i1VarJ.f4751b.f11156a;
        int i = y1.a0.f14551a;
        boolean zEquals = obj.equals(pair.first);
        s2.c0 c0Var2 = !zEquals ? new s2.c0(pair.first) : i1VarJ.f4751b;
        long jLongValue = ((Long) pair.second).longValue();
        long jO2 = y1.a0.O(jT1);
        if (!f1Var2.p()) {
            jO2 -= f1Var2.g(obj, this.K).f12620e;
        }
        if (!zEquals || jLongValue < jO2) {
            s2.c0 c0Var3 = c0Var2;
            y1.d.g(!c0Var3.b());
            s2.l1 l1Var = !zEquals ? s2.l1.f11260d : i1VarJ.f4756h;
            v2.u uVar = !zEquals ? this.f4711x : i1VarJ.i;
            if (zEquals) {
                list = i1VarJ.f4757j;
            } else {
                ua.g0 g0Var = ua.i0.f12341w;
                list = ua.z0.f12413z;
            }
            i1 i1VarC2 = i1VarJ.d(c0Var3, jLongValue, jLongValue, jLongValue, 0L, l1Var, uVar, list).c(c0Var3);
            i1VarC2.f4764q = jLongValue;
            return i1VarC2;
        }
        if (jLongValue != jO2) {
            s2.c0 c0Var4 = c0Var2;
            y1.d.g(!c0Var4.b());
            long jMax = Math.max(0L, i1VarJ.f4765r - (jLongValue - jO2));
            long j4 = i1VarJ.f4764q;
            if (i1VarJ.f4758k.equals(i1VarJ.f4751b)) {
                j4 = jLongValue + jMax;
            }
            i1 i1VarD = i1VarJ.d(c0Var4, jLongValue, jLongValue, jLongValue, jMax, i1VarJ.f4756h, i1VarJ.i, i1VarJ.f4757j);
            i1VarD.f4764q = j4;
            return i1VarD;
        }
        int iB = f1Var.b(i1VarJ.f4758k.f11156a);
        if (iB != -1 && f1Var.f(iB, this.K, false).f12618c == f1Var.g(c0Var2.f11156a, this.K).f12618c) {
            return i1VarJ;
        }
        f1Var.g(c0Var2.f11156a, this.K);
        long jA = c0Var2.b() ? this.K.a(c0Var2.f11157b, c0Var2.f11158c) : this.K.f12619d;
        s2.c0 c0Var5 = c0Var2;
        i1 i1VarC3 = i1VarJ.d(c0Var5, i1VarJ.f4766s, i1VarJ.f4766s, i1VarJ.f4753d, jA - i1VarJ.f4766s, i1VarJ.f4756h, i1VarJ.i, i1VarJ.f4757j).c(c0Var5);
        i1VarC3.f4764q = jA;
        return i1VarC3;
    }
}
