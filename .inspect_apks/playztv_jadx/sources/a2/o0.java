package a2;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o0 extends c3.e implements w {
    public final o0 A;
    public final p1.j A0;
    public final g[] B;
    public p1.r1 B0;
    public final g[] C;
    public p1.j0 C0;
    public final r2.u D;
    public u1 D0;
    public final s1.y E;
    public int E0;
    public final e0 F;
    public long F0;
    public final x0 G;
    public final s1.p H;
    public final CopyOnWriteArraySet I;
    public final p1.c1 J;
    public final ArrayList K;
    public final boolean L;
    public final o2.c0 M;
    public final b2.h N;
    public final Looper O;
    public final s2.d P;
    public final long Q;
    public final long R;
    public final long S;
    public final l0 T;
    public final m0 U;
    public final c V;
    public final f2 W;
    public final f2 X;
    public final long Y;
    public final n.p Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f342a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f343b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f344c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f345d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f346e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final c2 f347f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public o2.f1 f348g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public p1.s0 f349h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public p1.j0 f350i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public p1.j0 f351j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public Object f352k0;
    public Surface l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public SurfaceHolder f353m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public v2.k f354n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f355o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public TextureView f356p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final int f357q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public s1.v f358r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public p1.d f359s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public float f360t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f361u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public r1.c f362v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final r2.v f363w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final boolean f364w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final p1.s0 f365x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f366x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final s1.g f367y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final int f368y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Context f369z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f370z0;

    static {
        p1.h0.a("media3.exoplayer");
    }

    public o0(u uVar) throws Throwable {
        o0 o0Var;
        Context context;
        s1.w wVar;
        int i;
        int i10;
        o0 o0Var2;
        super(5);
        this.f367y = new s1.g();
        try {
            s1.b.k("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.8.0] [" + s1.b0.f11648b + "]");
            context = uVar.f421a;
            wVar = uVar.f422b;
            this.f369z = context.getApplicationContext();
            this.N = new b2.h(wVar);
            this.f368y0 = uVar.i;
            this.f359s0 = uVar.f428j;
            this.f357q0 = uVar.f429k;
            this.f361u0 = false;
            this.Y = uVar.f438t;
            l0 l0Var = new l0(this);
            this.T = l0Var;
            this.U = new m0();
            g[] gVarArrA = ((n) uVar.f423c.get()).a(new Handler(uVar.f427h), l0Var, l0Var, l0Var, l0Var);
            this.B = gVarArrA;
            s1.d.g(gVarArrA.length > 0);
            this.C = new g[gVarArrA.length];
            i = 0;
        } catch (Throwable th) {
            th = th;
            o0Var = this;
        }
        while (true) {
            g[] gVarArr = this.C;
            if (i >= gVarArr.length) {
                break;
            }
            int i11 = this.B[i].f232v;
            gVarArr[i] = null;
            i++;
            o0Var.f367y.e();
            throw th;
        }
        r2.u uVar2 = (r2.u) uVar.f425e.get();
        this.D = uVar2;
        this.M = (o2.c0) uVar.f424d.get();
        s2.d dVar = (s2.d) uVar.f426g.get();
        this.P = dVar;
        this.L = uVar.f430l;
        d2 d2Var = uVar.f431m;
        this.Q = uVar.f433o;
        this.R = uVar.f434p;
        this.S = uVar.f435q;
        this.f347f0 = uVar.f432n;
        Looper looper = uVar.f427h;
        this.O = looper;
        this.A = this;
        this.H = new s1.p(looper, wVar, new s(this));
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.I = copyOnWriteArraySet;
        this.K = new ArrayList();
        this.f348g0 = new o2.f1();
        g[] gVarArr2 = this.B;
        r2.v vVar = new r2.v(new a2[gVarArr2.length], new r2.r[gVarArr2.length], p1.n1.f9950b, null);
        this.f363w = vVar;
        this.J = new p1.c1();
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = {1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32};
        int length = iArr.length;
        int i12 = 0;
        while (i12 < length) {
            int i13 = iArr[i12];
            s1.d.g(!false);
            sparseBooleanArray.append(i13, true);
            i12++;
            dVar = dVar;
        }
        s2.d dVar2 = dVar;
        uVar2.getClass();
        s1.d.g(!false);
        sparseBooleanArray.append(29, true);
        s1.d.g(!false);
        p1.o oVar = new p1.o(sparseBooleanArray);
        this.f365x = new p1.s0(oVar);
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray();
        for (int i14 = 0; i14 < oVar.f9953a.size(); i14++) {
            int iB = oVar.b(i14);
            s1.d.g(!false);
            sparseBooleanArray2.append(iB, true);
        }
        s1.d.g(!false);
        sparseBooleanArray2.append(4, true);
        s1.d.g(!false);
        sparseBooleanArray2.append(10, true);
        s1.d.g(!false);
        this.f349h0 = new p1.s0(new p1.o(sparseBooleanArray2));
        this.E = wVar.a(looper, null);
        e0 e0Var = new e0(this, 0);
        this.F = e0Var;
        this.D0 = u1.k(vVar);
        this.N.X(this, looper);
        b2.o oVar2 = new b2.o(uVar.f441w);
        x0 x0Var = new x0(this.f369z, this.B, this.C, uVar2, vVar, (a1) uVar.f.get(), dVar2, this.f342a0, this.f343b0, this.N, d2Var, uVar.f436r, uVar.f437s, looper, wVar, e0Var, oVar2, this.U);
        s1.y yVar = x0Var.B;
        this.G = x0Var;
        Looper looper2 = x0Var.D;
        this.f360t0 = 1.0f;
        this.f342a0 = 0;
        p1.j0 j0Var = p1.j0.K;
        this.f350i0 = j0Var;
        this.f351j0 = j0Var;
        this.C0 = j0Var;
        this.E0 = -1;
        this.f362v0 = r1.c.f11270d;
        this.f364w0 = true;
        J(this.N);
        Handler handler = new Handler(looper);
        b2.h hVar = this.N;
        s2.g gVar = (s2.g) dVar2;
        gVar.getClass();
        hVar.getClass();
        o4.c cVar = gVar.f11747c;
        cVar.getClass();
        CopyOnWriteArrayList<s2.c> copyOnWriteArrayList = (CopyOnWriteArrayList) cVar.f9349u;
        for (s2.c cVar2 : copyOnWriteArrayList) {
            if (cVar2.f11730b == hVar) {
                cVar2.f11731c = true;
                copyOnWriteArrayList.remove(cVar2);
            }
        }
        copyOnWriteArrayList.add(new s2.c(handler, hVar));
        copyOnWriteArraySet.add(this.T);
        if (Build.VERSION.SDK_INT >= 31) {
            try {
                Context context2 = this.f369z;
                boolean z2 = uVar.f439u;
                s1.y yVarA = wVar.a(x0Var.D, null);
                i10 = 1;
                i0 i0Var = new i0(context2, z2, this, oVar2, 0);
                o0Var2 = this;
                try {
                    yVarA.c(i0Var);
                } catch (Throwable th2) {
                    th = th2;
                    o0Var = o0Var2;
                }
            } catch (Throwable th3) {
                th = th3;
                o0Var2 = this;
                o0Var = o0Var2;
            }
        } else {
            i10 = 1;
            o0Var2 = this;
        }
        o0Var = o0Var2;
        try {
            n.p pVar = new n.p(0, looper2, looper, wVar, new e0(o0Var2, i10));
            o0Var.Z = pVar;
            pVar.v(new a(2, o0Var));
            c cVar3 = new c(uVar.f421a, looper2, uVar.f427h, o0Var.T, wVar);
            o0Var.V = cVar3;
            cVar3.k();
            o0Var.W = new f2(context, looper2, wVar, 0);
            o0Var.X = new f2(context, looper2, wVar, i10);
            o0Var.A0 = p1.j.f9812c;
            o0Var.B0 = p1.r1.f10046d;
            o0Var.f358r0 = s1.v.f11712c;
            yVar.a(38, o0Var.f347f0).b();
            p1.d dVar3 = o0Var.f359s0;
            s1.x xVarB = s1.y.b();
            xVarB.f11716a = yVar.f11718a.obtainMessage(31, 0, 0, dVar3);
            xVarB.b();
            o0Var.J1(i10, 3, o0Var.f359s0);
            o0Var.J1(2, 4, Integer.valueOf(o0Var.f357q0));
            o0Var.J1(2, 5, 0);
            o0Var.J1(i10, 9, Boolean.valueOf(o0Var.f361u0));
            o0Var.J1(6, 8, o0Var.U);
            o0Var.J1(-1, 16, Integer.valueOf(o0Var.f368y0));
            o0Var.f367y.e();
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static long A1(u1 u1Var) {
        p1.e1 e1Var = new p1.e1();
        p1.c1 c1Var = new p1.c1();
        u1Var.f448a.g(u1Var.f449b.f9090a, c1Var);
        long j5 = u1Var.f450c;
        return j5 == -9223372036854775807L ? u1Var.f448a.m(c1Var.f9678c, e1Var, 0L).f9722l : c1Var.f9680e + j5;
    }

    public static u1 B1(u1 u1Var, int i) {
        u1 u1VarH = u1Var.h(i);
        return (i == 1 || i == 4) ? u1VarH.b(false) : u1VarH;
    }

    @Override // p1.w0
    public final long A() {
        S1();
        if (!o()) {
            return G0();
        }
        u1 u1Var = this.D0;
        return u1Var.f456k.equals(u1Var.f449b) ? s1.b0.b0(this.D0.f462q) : getDuration();
    }

    @Override // p1.w0
    public final void B0() {
        S1();
    }

    @Override // p1.w0
    public final boolean C() {
        S1();
        return this.D0.f457l;
    }

    @Override // p1.w0
    public final boolean C0() {
        S1();
        return this.f343b0;
    }

    public final u1 C1(u1 u1Var, p1.f1 f1Var, Pair pair) {
        List list;
        s1.d.b(f1Var.p() || pair != null);
        p1.f1 f1Var2 = u1Var.f448a;
        long jW1 = w1(u1Var);
        u1 u1VarJ = u1Var.j(f1Var);
        if (f1Var.p()) {
            o2.d0 d0Var = u1.f447u;
            long jO = s1.b0.O(this.F0);
            u1 u1VarC = u1VarJ.d(d0Var, jO, jO, jO, 0L, o2.n1.f9176d, this.f363w, aa.c1.f650y).c(d0Var);
            u1VarC.f462q = u1VarC.f464s;
            return u1VarC;
        }
        Object obj = u1VarJ.f449b.f9090a;
        int i = s1.b0.f11647a;
        boolean zEquals = obj.equals(pair.first);
        o2.d0 d0Var2 = !zEquals ? new o2.d0(pair.first) : u1VarJ.f449b;
        long jLongValue = ((Long) pair.second).longValue();
        long jO2 = s1.b0.O(jW1);
        if (!f1Var2.p()) {
            jO2 -= f1Var2.g(obj, this.J).f9680e;
        }
        if (!zEquals || jLongValue < jO2) {
            o2.d0 d0Var3 = d0Var2;
            s1.d.g(!d0Var3.b());
            o2.n1 n1Var = !zEquals ? o2.n1.f9176d : u1VarJ.f454h;
            r2.v vVar = !zEquals ? this.f363w : u1VarJ.i;
            if (zEquals) {
                list = u1VarJ.f455j;
            } else {
                aa.h0 h0Var = aa.j0.f690v;
                list = aa.c1.f650y;
            }
            u1 u1VarC2 = u1VarJ.d(d0Var3, jLongValue, jLongValue, jLongValue, 0L, n1Var, vVar, list).c(d0Var3);
            u1VarC2.f462q = jLongValue;
            return u1VarC2;
        }
        if (jLongValue != jO2) {
            o2.d0 d0Var4 = d0Var2;
            s1.d.g(!d0Var4.b());
            long jMax = Math.max(0L, u1VarJ.f463r - (jLongValue - jO2));
            long j5 = u1VarJ.f462q;
            if (u1VarJ.f456k.equals(u1VarJ.f449b)) {
                j5 = jLongValue + jMax;
            }
            u1 u1VarD = u1VarJ.d(d0Var4, jLongValue, jLongValue, jLongValue, jMax, u1VarJ.f454h, u1VarJ.i, u1VarJ.f455j);
            u1VarD.f462q = j5;
            return u1VarD;
        }
        int iB = f1Var.b(u1VarJ.f456k.f9090a);
        if (iB != -1 && f1Var.f(iB, this.J, false).f9678c == f1Var.g(d0Var2.f9090a, this.J).f9678c) {
            return u1VarJ;
        }
        f1Var.g(d0Var2.f9090a, this.J);
        long jA = d0Var2.b() ? this.J.a(d0Var2.f9091b, d0Var2.f9092c) : this.J.f9679d;
        o2.d0 d0Var5 = d0Var2;
        u1 u1VarC3 = u1VarJ.d(d0Var5, u1VarJ.f464s, u1VarJ.f464s, u1VarJ.f451d, jA - u1VarJ.f464s, u1VarJ.f454h, u1VarJ.i, u1VarJ.f455j).c(d0Var5);
        u1VarC3.f462q = jA;
        return u1VarC3;
    }

    public final Pair D1(p1.f1 f1Var, int i, long j5) {
        if (f1Var.p()) {
            this.E0 = i;
            if (j5 == -9223372036854775807L) {
                j5 = 0;
            }
            this.F0 = j5;
            return null;
        }
        if (i == -1 || i >= f1Var.o()) {
            i = f1Var.a(this.f343b0);
            j5 = s1.b0.b0(f1Var.m(i, (p1.e1) this.f2454v, 0L).f9722l);
        }
        return f1Var.i((p1.e1) this.f2454v, this.J, i, s1.b0.O(j5));
    }

    @Override // p1.w0
    public final p1.l1 E0() {
        S1();
        return ((r2.p) this.D).e();
    }

    public final void E1(int i, int i10) {
        s1.v vVar = this.f358r0;
        if (i == vVar.f11713a && i10 == vVar.f11714b) {
            return;
        }
        this.f358r0 = new s1.v(i, i10);
        this.H.e(24, new b0(i, i10, 0));
        J1(2, 14, new s1.v(i, i10));
    }

    public final void F1() {
        boolean zC;
        s1.b.k("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.8.0] [" + s1.b0.f11648b + "] [" + p1.h0.b() + "]");
        S1();
        this.V.k();
        this.W.a(false);
        this.X.a(false);
        x0 x0Var = this.G;
        if (x0Var.f481c0 || !x0Var.D.getThread().isAlive()) {
            zC = true;
        } else {
            x0Var.f481c0 = true;
            s1.g gVar = new s1.g(x0Var.K);
            x0Var.B.a(7, gVar).b();
            zC = gVar.c(x0Var.P);
        }
        if (!zC) {
            this.H.e(10, new s(1));
        }
        this.H.d();
        this.E.f11718a.removeCallbacksAndMessages(null);
        s2.d dVar = this.P;
        b2.h hVar = this.N;
        CopyOnWriteArrayList<s2.c> copyOnWriteArrayList = (CopyOnWriteArrayList) ((s2.g) dVar).f11747c.f9349u;
        for (s2.c cVar : copyOnWriteArrayList) {
            if (cVar.f11730b == hVar) {
                cVar.f11731c = true;
                copyOnWriteArrayList.remove(cVar);
            }
        }
        u1 u1Var = this.D0;
        if (u1Var.f461p) {
            this.D0 = u1Var.a();
        }
        u1 u1VarB1 = B1(this.D0, 1);
        this.D0 = u1VarB1;
        u1 u1VarC = u1VarB1.c(u1VarB1.f449b);
        this.D0 = u1VarC;
        u1VarC.f462q = u1VarC.f464s;
        this.D0.f463r = 0L;
        b2.h hVar2 = this.N;
        s1.y yVar = hVar2.B;
        s1.d.h(yVar);
        yVar.c(new a(6, hVar2));
        I1();
        Surface surface = this.l0;
        if (surface != null) {
            surface.release();
            this.l0 = null;
        }
        this.f362v0 = r1.c.f11270d;
        this.f370z0 = true;
    }

    @Override // p1.w0
    public final void G(boolean z2) {
        S1();
        if (this.f343b0 != z2) {
            this.f343b0 = z2;
            s1.y yVar = this.G.B;
            yVar.getClass();
            s1.x xVarB = s1.y.b();
            xVarB.f11716a = yVar.f11718a.obtainMessage(12, z2 ? 1 : 0, 0);
            xVarB.b();
            d0 d0Var = new d0(0, z2);
            s1.p pVar = this.H;
            pVar.c(9, d0Var);
            O1();
            pVar.b();
        }
    }

    @Override // p1.w0
    public final long G0() {
        S1();
        if (this.D0.f448a.p()) {
            return this.F0;
        }
        u1 u1Var = this.D0;
        long j5 = 0;
        if (u1Var.f456k.f9093d != u1Var.f449b.f9093d) {
            return s1.b0.b0(u1Var.f448a.m(d0(), (p1.e1) this.f2454v, 0L).f9723m);
        }
        long j8 = u1Var.f462q;
        if (this.D0.f456k.b()) {
            u1 u1Var2 = this.D0;
            u1Var2.f448a.g(u1Var2.f456k.f9090a, this.J).d(this.D0.f456k.f9091b);
        } else {
            j5 = j8;
        }
        u1 u1Var3 = this.D0;
        p1.f1 f1Var = u1Var3.f448a;
        Object obj = u1Var3.f456k.f9090a;
        p1.c1 c1Var = this.J;
        f1Var.g(obj, c1Var);
        return s1.b0.b0(j5 + c1Var.f9680e);
    }

    public final u1 G1(u1 u1Var, int i, int i10) {
        int iY1 = y1(u1Var);
        long jW1 = w1(u1Var);
        p1.f1 f1Var = u1Var.f448a;
        ArrayList arrayList = this.K;
        int size = arrayList.size();
        this.f344c0++;
        H1(i, i10);
        z1 z1Var = new z1(arrayList, this.f348g0);
        u1 u1VarC1 = C1(u1Var, z1Var, z1(f1Var, z1Var, iY1, jW1));
        int i11 = u1VarC1.f452e;
        if (i11 != 1 && i11 != 4 && i < i10 && i10 == size && iY1 >= u1VarC1.f448a.o()) {
            u1VarC1 = B1(u1VarC1, 4);
        }
        o2.f1 f1Var2 = this.f348g0;
        s1.y yVar = this.G.B;
        yVar.getClass();
        s1.x xVarB = s1.y.b();
        xVarB.f11716a = yVar.f11718a.obtainMessage(20, i, i10, f1Var2);
        xVarB.b();
        return u1VarC1;
    }

    @Override // p1.w0
    public final void H0(int i, int i10) {
        S1();
        s1.d.b(i >= 0 && i10 >= i);
        int size = this.K.size();
        int iMin = Math.min(i10, size);
        if (i >= size || i == iMin) {
            return;
        }
        u1 u1VarG1 = G1(this.D0, i, iMin);
        Q1(u1VarG1, 0, !u1VarG1.f449b.f9090a.equals(this.D0.f449b.f9090a), 4, x1(u1VarG1), -1, false);
    }

    public final void H1(int i, int i10) {
        for (int i11 = i10 - 1; i11 >= i; i11--) {
            this.K.remove(i11);
        }
        o2.f1 f1Var = this.f348g0;
        int i12 = i10 - i;
        int[] iArr = f1Var.f9109b;
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
        this.f348g0 = new o2.f1(iArr2, new Random(f1Var.f9108a.nextLong()));
    }

    @Override // p1.w0
    public final int I() {
        S1();
        return this.D0.f452e;
    }

    @Override // p1.w0
    public final void I0(int i) {
        S1();
    }

    public final void I1() {
        v2.k kVar = this.f354n0;
        l0 l0Var = this.T;
        if (kVar != null) {
            x1 x1VarV1 = v1(this.U);
            s1.d.g(!x1VarV1.f);
            x1VarV1.f511c = 10000;
            s1.d.g(!x1VarV1.f);
            x1VarV1.f512d = null;
            x1VarV1.b();
            this.f354n0.f13215u.remove(l0Var);
            this.f354n0 = null;
        }
        TextureView textureView = this.f356p0;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != l0Var) {
                s1.b.p("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f356p0.setSurfaceTextureListener(null);
            }
            this.f356p0 = null;
        }
        SurfaceHolder surfaceHolder = this.f353m0;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(l0Var);
            this.f353m0 = null;
        }
    }

    @Override // p1.w0
    public final void J(p1.u0 u0Var) {
        u0Var.getClass();
        this.H.a(u0Var);
    }

    public final void J1(int i, int i10, Object obj) {
        for (g gVar : this.B) {
            if (i == -1 || gVar.f232v == i) {
                x1 x1VarV1 = v1(gVar);
                s1.d.g(!x1VarV1.f);
                x1VarV1.f511c = i10;
                s1.d.g(!x1VarV1.f);
                x1VarV1.f512d = obj;
                x1VarV1.b();
            }
        }
        for (g gVar2 : this.C) {
            if (gVar2 != null && (i == -1 || gVar2.f232v == i)) {
                x1 x1VarV12 = v1(gVar2);
                s1.d.g(!x1VarV12.f);
                x1VarV12.f511c = i10;
                s1.d.g(!x1VarV12.f);
                x1VarV12.f512d = obj;
                x1VarV12.b();
            }
        }
    }

    @Override // p1.w0
    public final void K(int i) {
        S1();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K1(java.util.List r16, int r17, long r18, boolean r20) {
        /*
            r15 = this;
            r1 = r17
            a2.u1 r2 = r15.D0
            int r2 = r15.y1(r2)
            long r3 = r15.T0()
            int r5 = r15.f344c0
            r6 = 1
            int r5 = r5 + r6
            r15.f344c0 = r5
            java.util.ArrayList r5 = r15.K
            boolean r7 = r5.isEmpty()
            r8 = 0
            if (r7 != 0) goto L22
            int r7 = r5.size()
            r15.H1(r8, r7)
        L22:
            r7 = r16
            java.util.ArrayList r10 = r15.q1(r8, r7)
            a2.z1 r7 = new a2.z1
            o2.f1 r9 = r15.f348g0
            r7.<init>(r5, r9)
            boolean r5 = r7.p()
            int r9 = r7.f525g
            if (r5 != 0) goto L40
            if (r1 >= r9) goto L3a
            goto L40
        L3a:
            me.i r1 = new me.i
            r1.<init>()
            throw r1
        L40:
            r5 = -1
            if (r20 == 0) goto L50
            boolean r1 = r15.f343b0
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
            a2.u1 r1 = r15.D0
            android.util.Pair r4 = r15.D1(r7, r12, r2)
            a2.u1 r1 = r15.C1(r1, r7, r4)
            int r4 = r1.f452e
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
            a2.u1 r1 = B1(r1, r4)
            long r13 = s1.b0.O(r2)
            o2.f1 r11 = r15.f348g0
            a2.x0 r2 = r15.G
            s1.y r2 = r2.B
            a2.s0 r9 = new a2.s0
            r9.<init>(r10, r11, r12, r13)
            r3 = 17
            s1.x r2 = r2.a(r3, r9)
            r2.b()
            a2.u1 r2 = r15.D0
            o2.d0 r2 = r2.f449b
            java.lang.Object r2 = r2.f9090a
            o2.d0 r3 = r1.f449b
            java.lang.Object r3 = r3.f9090a
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto Lac
            a2.u1 r2 = r15.D0
            p1.f1 r2 = r2.f448a
            boolean r2 = r2.p()
            if (r2 != 0) goto Lac
            r3 = r6
            goto Lad
        Lac:
            r3 = r8
        Lad:
            long r5 = r15.x1(r1)
            r7 = -1
            r8 = 0
            r2 = 0
            r4 = 4
            r0 = r15
            r0.Q1(r1, r2, r3, r4, r5, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.o0.K1(java.util.List, int, long, boolean):void");
    }

    @Override // p1.w0
    public final p1.n1 L() {
        S1();
        return this.D0.i.f11360d;
    }

    @Override // p1.w0
    public final void L0(TextureView textureView) {
        S1();
        if (textureView == null) {
            t1();
            return;
        }
        I1();
        this.f356p0 = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            s1.b.p("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.T);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            M1(null);
            E1(0, 0);
        } else {
            Surface surface = new Surface(surfaceTexture);
            M1(surface);
            this.l0 = surface;
            E1(textureView.getWidth(), textureView.getHeight());
        }
    }

    public final void L1(SurfaceHolder surfaceHolder) {
        this.f355o0 = false;
        this.f353m0 = surfaceHolder;
        surfaceHolder.addCallback(this.T);
        Surface surface = this.f353m0.getSurface();
        if (surface == null || !surface.isValid()) {
            E1(0, 0);
        } else {
            Rect surfaceFrame = this.f353m0.getSurfaceFrame();
            E1(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    public final void M1(Object obj) {
        Object obj2 = this.f352k0;
        boolean zC = true;
        boolean z2 = (obj2 == null || obj2 == obj) ? false : true;
        long j5 = z2 ? this.Y : -9223372036854775807L;
        x0 x0Var = this.G;
        if (!x0Var.f481c0 && x0Var.D.getThread().isAlive()) {
            s1.g gVar = new s1.g(x0Var.K);
            x0Var.B.a(30, new Pair(obj, gVar)).b();
            if (j5 != -9223372036854775807L) {
                zC = gVar.c(j5);
            }
        }
        if (z2) {
            Object obj3 = this.f352k0;
            Surface surface = this.l0;
            if (obj3 == surface) {
                surface.release();
                this.l0 = null;
            }
        }
        this.f352k0 = obj;
        if (zC) {
            return;
        }
        N1(new q(2, new y0("Detaching surface timed out."), 1003));
    }

    @Override // p1.w0
    public final long N() {
        S1();
        return this.S;
    }

    @Override // p1.w0
    public final void N0(p1.u0 u0Var) {
        S1();
        u0Var.getClass();
        s1.p pVar = this.H;
        pVar.f();
        CopyOnWriteArraySet<s1.o> copyOnWriteArraySet = pVar.f11689d;
        for (s1.o oVar : copyOnWriteArraySet) {
            if (oVar.f11682a.equals(u0Var)) {
                s1.n nVar = pVar.f11688c;
                oVar.f11685d = true;
                if (oVar.f11684c) {
                    oVar.f11684c = false;
                    nVar.i(oVar.f11682a, oVar.f11683b.f());
                }
                copyOnWriteArraySet.remove(oVar);
            }
        }
    }

    public final void N1(q qVar) {
        u1 u1Var = this.D0;
        u1 u1VarC = u1Var.c(u1Var.f449b);
        u1VarC.f462q = u1VarC.f464s;
        u1VarC.f463r = 0L;
        u1 u1VarB1 = B1(u1VarC, 1);
        if (qVar != null) {
            u1VarB1 = u1VarB1.f(qVar);
        }
        u1 u1Var2 = u1VarB1;
        this.f344c0++;
        s1.y yVar = this.G.B;
        yVar.getClass();
        s1.x xVarB = s1.y.b();
        xVarB.f11716a = yVar.f11718a.obtainMessage(6);
        xVarB.b();
        Q1(u1Var2, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // p1.w0
    public final p1.j0 O() {
        S1();
        return this.f351j0;
    }

    @Override // p1.w0
    public final void O0(float f) {
        S1();
        float fH = s1.b0.h(f, 0.0f, 1.0f);
        if (this.f360t0 == fH) {
            return;
        }
        this.f360t0 = fH;
        this.G.B.a(32, Float.valueOf(fH)).b();
        this.H.e(22, new a0(0, fH));
    }

    public final void O1() {
        p1.s0 s0Var = this.f349h0;
        int i = s1.b0.f11647a;
        o0 o0Var = this.A;
        boolean zO = o0Var.o();
        boolean zD = o0Var.D();
        boolean zC1 = o0Var.c1();
        boolean zB1 = o0Var.b1();
        boolean zW0 = o0Var.W0();
        boolean zR0 = o0Var.r0();
        boolean zP = o0Var.w0().p();
        p1.r0 r0Var = new p1.r0();
        r0Var.f10045a = new e6.f0(3);
        e6.f0 f0Var = (e6.f0) r0Var.f10045a;
        f0Var.e(this.f365x.f10058a);
        boolean z2 = !zO;
        r0Var.a(4, z2);
        boolean z10 = false;
        r0Var.a(5, zD && !zO);
        r0Var.a(6, zC1 && !zO);
        r0Var.a(7, !zP && (zC1 || !zW0 || zD) && !zO);
        r0Var.a(8, zB1 && !zO);
        r0Var.a(9, !zP && (zB1 || (zW0 && zR0)) && !zO);
        r0Var.a(10, z2);
        r0Var.a(11, zD && !zO);
        if (zD && !zO) {
            z10 = true;
        }
        r0Var.a(12, z10);
        p1.s0 s0Var2 = new p1.s0(f0Var.f());
        this.f349h0 = s0Var2;
        if (s0Var2.equals(s0Var)) {
            return;
        }
        this.H.c(13, new e0(this, 2));
    }

    @Override // p1.w0
    public final p1.j0 P0() {
        S1();
        return this.f350i0;
    }

    public final void P1(int i, boolean z2) {
        u1 u1VarA = this.D0;
        int i10 = u1VarA.f459n;
        int i11 = (i10 != 1 || z2) ? 0 : 1;
        if (u1VarA.f457l == z2 && i10 == i11 && u1VarA.f458m == i) {
            return;
        }
        this.f344c0++;
        if (u1VarA.f461p) {
            u1VarA = u1VarA.a();
        }
        u1 u1VarE = u1VarA.e(i, i11, z2);
        s1.y yVar = this.G.B;
        yVar.getClass();
        s1.x xVarB = s1.y.b();
        xVarB.f11716a = yVar.f11718a.obtainMessage(1, z2 ? 1 : 0, i | (i11 << 4));
        xVarB.b();
        Q1(u1VarE, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // p1.w0
    public final void Q0(List list) {
        S1();
        ArrayList arrayListU1 = u1(list);
        S1();
        K1(arrayListU1, -1, -9223372036854775807L, true);
    }

    public final void Q1(final u1 u1Var, int i, boolean z2, int i10, long j5, int i11, boolean z10) {
        Pair pair;
        int i12;
        p1.g0 g0Var;
        boolean z11;
        boolean z12;
        boolean z13;
        int i13;
        Object obj;
        p1.g0 g0Var2;
        Object obj2;
        int i14;
        long j8;
        long j10;
        long jA1;
        long jA12;
        Object obj3;
        p1.g0 g0Var3;
        Object obj4;
        int i15;
        u1 u1Var2 = this.D0;
        this.D0 = u1Var;
        boolean zEquals = u1Var2.f448a.equals(u1Var.f448a);
        p1.e1 e1Var = (p1.e1) this.f2454v;
        p1.c1 c1Var = this.J;
        p1.f1 f1Var = u1Var2.f448a;
        o2.d0 d0Var = u1Var2.f449b;
        p1.f1 f1Var2 = u1Var.f448a;
        o2.d0 d0Var2 = u1Var.f449b;
        if (f1Var2.p() && f1Var.p()) {
            pair = new Pair(Boolean.FALSE, -1);
        } else if (f1Var2.p() != f1Var.p()) {
            pair = new Pair(Boolean.TRUE, 3);
        } else if (f1Var.m(f1Var.g(d0Var.f9090a, c1Var).f9678c, e1Var, 0L).f9713a.equals(f1Var2.m(f1Var2.g(d0Var2.f9090a, c1Var).f9678c, e1Var, 0L).f9713a)) {
            pair = (z2 && i10 == 0 && d0Var.f9093d < d0Var2.f9093d) ? new Pair(Boolean.TRUE, 0) : (z2 && i10 == 1 && z10) ? new Pair(Boolean.TRUE, 2) : new Pair(Boolean.FALSE, -1);
        } else {
            if (z2 && i10 == 0) {
                i12 = 1;
            } else if (z2 && i10 == 1) {
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
            g0Var = !u1Var.f448a.p() ? u1Var.f448a.m(u1Var.f448a.g(u1Var.f449b.f9090a, this.J).f9678c, (p1.e1) this.f2454v, 0L).f9715c : null;
            this.C0 = p1.j0.K;
        } else {
            g0Var = null;
        }
        if (zBooleanValue || !u1Var2.f455j.equals(u1Var.f455j)) {
            p1.i0 i0VarA = this.C0.a();
            List list = u1Var.f455j;
            for (int i16 = 0; i16 < list.size(); i16++) {
                p1.l0 l0Var = (p1.l0) list.get(i16);
                int i17 = 0;
                while (true) {
                    p1.k0[] k0VarArr = l0Var.f9896a;
                    if (i17 < k0VarArr.length) {
                        k0VarArr[i17].a(i0VarA);
                        i17++;
                    }
                }
            }
            this.C0 = new p1.j0(i0VarA);
        }
        p1.j0 j0VarS1 = s1();
        boolean zEquals2 = j0VarS1.equals(this.f350i0);
        this.f350i0 = j0VarS1;
        boolean z14 = u1Var2.f457l != u1Var.f457l;
        boolean z15 = u1Var2.f452e != u1Var.f452e;
        if (z15 || z14) {
            R1();
        }
        boolean z16 = u1Var2.f453g != u1Var.f453g;
        if (!zEquals) {
            this.H.c(0, new x(i, 0, u1Var));
        }
        if (z2) {
            p1.c1 c1Var2 = new p1.c1();
            if (u1Var2.f448a.p()) {
                z11 = zBooleanValue;
                z12 = zEquals2;
                z13 = z15;
                i13 = i11;
                obj = null;
                g0Var2 = null;
                obj2 = null;
                i14 = -1;
            } else {
                Object obj5 = u1Var2.f449b.f9090a;
                u1Var2.f448a.g(obj5, c1Var2);
                int i18 = c1Var2.f9678c;
                int iB = u1Var2.f448a.b(obj5);
                z11 = zBooleanValue;
                z12 = zEquals2;
                z13 = z15;
                obj = u1Var2.f448a.m(i18, (p1.e1) this.f2454v, 0L).f9713a;
                g0Var2 = ((p1.e1) this.f2454v).f9715c;
                obj2 = obj5;
                i13 = i18;
                i14 = iB;
            }
            if (i10 == 0) {
                if (u1Var2.f449b.b()) {
                    o2.d0 d0Var3 = u1Var2.f449b;
                    jA1 = c1Var2.a(d0Var3.f9091b, d0Var3.f9092c);
                    jA12 = A1(u1Var2);
                } else if (u1Var2.f449b.f9094e != -1) {
                    jA1 = A1(this.D0);
                    jA12 = jA1;
                } else {
                    j8 = c1Var2.f9680e;
                    j10 = c1Var2.f9679d;
                    jA1 = j8 + j10;
                    jA12 = jA1;
                }
            } else if (u1Var2.f449b.b()) {
                jA1 = u1Var2.f464s;
                jA12 = A1(u1Var2);
            } else {
                j8 = c1Var2.f9680e;
                j10 = u1Var2.f464s;
                jA1 = j8 + j10;
                jA12 = jA1;
            }
            long jB0 = s1.b0.b0(jA1);
            long jB02 = s1.b0.b0(jA12);
            o2.d0 d0Var4 = u1Var2.f449b;
            p1.v0 v0Var = new p1.v0(obj, i13, g0Var2, obj2, i14, jB0, jB02, d0Var4.f9091b, d0Var4.f9092c);
            p1.e1 e1Var2 = (p1.e1) this.f2454v;
            int iD0 = d0();
            if (this.D0.f448a.p()) {
                obj3 = null;
                g0Var3 = null;
                obj4 = null;
                i15 = -1;
            } else {
                u1 u1Var3 = this.D0;
                Object obj6 = u1Var3.f449b.f9090a;
                u1Var3.f448a.g(obj6, this.J);
                int iB2 = this.D0.f448a.b(obj6);
                Object obj7 = this.D0.f448a.m(iD0, e1Var2, 0L).f9713a;
                g0Var3 = e1Var2.f9715c;
                i15 = iB2;
                obj4 = obj6;
                obj3 = obj7;
            }
            long jB03 = s1.b0.b0(j5);
            long jB04 = this.D0.f449b.b() ? s1.b0.b0(A1(this.D0)) : jB03;
            o2.d0 d0Var5 = this.D0.f449b;
            this.H.c(11, new h0(i10, v0Var, new p1.v0(obj3, iD0, g0Var3, obj4, i15, jB03, jB04, d0Var5.f9091b, d0Var5.f9092c)));
        } else {
            z11 = zBooleanValue;
            z12 = zEquals2;
            z13 = z15;
        }
        if (z11) {
            this.H.c(1, new x(iIntValue, 1, g0Var));
        }
        if (u1Var2.f != u1Var.f) {
            final int i19 = 7;
            this.H.c(10, new s1.m() { // from class: a2.z
                @Override // s1.m
                public final void a(Object obj8) {
                    p1.u0 u0Var = (p1.u0) obj8;
                    switch (i19) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            u1 u1Var4 = u1Var;
                            u0Var.i(u1Var4.f453g);
                            u0Var.t(u1Var4.f453g);
                            break;
                        case 1:
                            u1 u1Var5 = u1Var;
                            u0Var.z(u1Var5.f452e, u1Var5.f457l);
                            break;
                        case 2:
                            u0Var.E(u1Var.f452e);
                            break;
                        case 3:
                            u1 u1Var6 = u1Var;
                            u0Var.B(u1Var6.f458m, u1Var6.f457l);
                            break;
                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.f(u1Var.f459n);
                            break;
                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.P(u1Var.m());
                            break;
                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.O(u1Var.f460o);
                            break;
                        case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.L(u1Var.f);
                            break;
                        case 8:
                            u0Var.K(u1Var.f);
                            break;
                        default:
                            u0Var.q(u1Var.i.f11360d);
                            break;
                    }
                }
            });
            if (u1Var.f != null) {
                final int i20 = 8;
                this.H.c(10, new s1.m() { // from class: a2.z
                    @Override // s1.m
                    public final void a(Object obj8) {
                        p1.u0 u0Var = (p1.u0) obj8;
                        switch (i20) {
                            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                u1 u1Var4 = u1Var;
                                u0Var.i(u1Var4.f453g);
                                u0Var.t(u1Var4.f453g);
                                break;
                            case 1:
                                u1 u1Var5 = u1Var;
                                u0Var.z(u1Var5.f452e, u1Var5.f457l);
                                break;
                            case 2:
                                u0Var.E(u1Var.f452e);
                                break;
                            case 3:
                                u1 u1Var6 = u1Var;
                                u0Var.B(u1Var6.f458m, u1Var6.f457l);
                                break;
                            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                                u0Var.f(u1Var.f459n);
                                break;
                            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                                u0Var.P(u1Var.m());
                                break;
                            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                                u0Var.O(u1Var.f460o);
                                break;
                            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                                u0Var.L(u1Var.f);
                                break;
                            case 8:
                                u0Var.K(u1Var.f);
                                break;
                            default:
                                u0Var.q(u1Var.i.f11360d);
                                break;
                        }
                    }
                });
            }
        }
        r2.v vVar = u1Var2.i;
        r2.v vVar2 = u1Var.i;
        if (vVar != vVar2) {
            r2.u uVar = this.D;
            Object obj8 = vVar2.f11361e;
            uVar.getClass();
            final int i21 = 9;
            this.H.c(2, new s1.m() { // from class: a2.z
                @Override // s1.m
                public final void a(Object obj82) {
                    p1.u0 u0Var = (p1.u0) obj82;
                    switch (i21) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            u1 u1Var4 = u1Var;
                            u0Var.i(u1Var4.f453g);
                            u0Var.t(u1Var4.f453g);
                            break;
                        case 1:
                            u1 u1Var5 = u1Var;
                            u0Var.z(u1Var5.f452e, u1Var5.f457l);
                            break;
                        case 2:
                            u0Var.E(u1Var.f452e);
                            break;
                        case 3:
                            u1 u1Var6 = u1Var;
                            u0Var.B(u1Var6.f458m, u1Var6.f457l);
                            break;
                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.f(u1Var.f459n);
                            break;
                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.P(u1Var.m());
                            break;
                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.O(u1Var.f460o);
                            break;
                        case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.L(u1Var.f);
                            break;
                        case 8:
                            u0Var.K(u1Var.f);
                            break;
                        default:
                            u0Var.q(u1Var.i.f11360d);
                            break;
                    }
                }
            });
        }
        if (!z12) {
            this.H.c(14, new y(this.f350i0));
        }
        if (z16) {
            final int i22 = 0;
            this.H.c(3, new s1.m() { // from class: a2.z
                @Override // s1.m
                public final void a(Object obj82) {
                    p1.u0 u0Var = (p1.u0) obj82;
                    switch (i22) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            u1 u1Var4 = u1Var;
                            u0Var.i(u1Var4.f453g);
                            u0Var.t(u1Var4.f453g);
                            break;
                        case 1:
                            u1 u1Var5 = u1Var;
                            u0Var.z(u1Var5.f452e, u1Var5.f457l);
                            break;
                        case 2:
                            u0Var.E(u1Var.f452e);
                            break;
                        case 3:
                            u1 u1Var6 = u1Var;
                            u0Var.B(u1Var6.f458m, u1Var6.f457l);
                            break;
                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.f(u1Var.f459n);
                            break;
                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.P(u1Var.m());
                            break;
                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.O(u1Var.f460o);
                            break;
                        case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.L(u1Var.f);
                            break;
                        case 8:
                            u0Var.K(u1Var.f);
                            break;
                        default:
                            u0Var.q(u1Var.i.f11360d);
                            break;
                    }
                }
            });
        }
        if (z13 || z14) {
            final int i23 = 1;
            this.H.c(-1, new s1.m() { // from class: a2.z
                @Override // s1.m
                public final void a(Object obj82) {
                    p1.u0 u0Var = (p1.u0) obj82;
                    switch (i23) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            u1 u1Var4 = u1Var;
                            u0Var.i(u1Var4.f453g);
                            u0Var.t(u1Var4.f453g);
                            break;
                        case 1:
                            u1 u1Var5 = u1Var;
                            u0Var.z(u1Var5.f452e, u1Var5.f457l);
                            break;
                        case 2:
                            u0Var.E(u1Var.f452e);
                            break;
                        case 3:
                            u1 u1Var6 = u1Var;
                            u0Var.B(u1Var6.f458m, u1Var6.f457l);
                            break;
                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.f(u1Var.f459n);
                            break;
                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.P(u1Var.m());
                            break;
                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.O(u1Var.f460o);
                            break;
                        case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.L(u1Var.f);
                            break;
                        case 8:
                            u0Var.K(u1Var.f);
                            break;
                        default:
                            u0Var.q(u1Var.i.f11360d);
                            break;
                    }
                }
            });
        }
        if (z13) {
            final int i24 = 2;
            this.H.c(4, new s1.m() { // from class: a2.z
                @Override // s1.m
                public final void a(Object obj82) {
                    p1.u0 u0Var = (p1.u0) obj82;
                    switch (i24) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            u1 u1Var4 = u1Var;
                            u0Var.i(u1Var4.f453g);
                            u0Var.t(u1Var4.f453g);
                            break;
                        case 1:
                            u1 u1Var5 = u1Var;
                            u0Var.z(u1Var5.f452e, u1Var5.f457l);
                            break;
                        case 2:
                            u0Var.E(u1Var.f452e);
                            break;
                        case 3:
                            u1 u1Var6 = u1Var;
                            u0Var.B(u1Var6.f458m, u1Var6.f457l);
                            break;
                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.f(u1Var.f459n);
                            break;
                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.P(u1Var.m());
                            break;
                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.O(u1Var.f460o);
                            break;
                        case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.L(u1Var.f);
                            break;
                        case 8:
                            u0Var.K(u1Var.f);
                            break;
                        default:
                            u0Var.q(u1Var.i.f11360d);
                            break;
                    }
                }
            });
        }
        if (z14 || u1Var2.f458m != u1Var.f458m) {
            final int i25 = 3;
            this.H.c(5, new s1.m() { // from class: a2.z
                @Override // s1.m
                public final void a(Object obj82) {
                    p1.u0 u0Var = (p1.u0) obj82;
                    switch (i25) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            u1 u1Var4 = u1Var;
                            u0Var.i(u1Var4.f453g);
                            u0Var.t(u1Var4.f453g);
                            break;
                        case 1:
                            u1 u1Var5 = u1Var;
                            u0Var.z(u1Var5.f452e, u1Var5.f457l);
                            break;
                        case 2:
                            u0Var.E(u1Var.f452e);
                            break;
                        case 3:
                            u1 u1Var6 = u1Var;
                            u0Var.B(u1Var6.f458m, u1Var6.f457l);
                            break;
                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.f(u1Var.f459n);
                            break;
                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.P(u1Var.m());
                            break;
                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.O(u1Var.f460o);
                            break;
                        case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.L(u1Var.f);
                            break;
                        case 8:
                            u0Var.K(u1Var.f);
                            break;
                        default:
                            u0Var.q(u1Var.i.f11360d);
                            break;
                    }
                }
            });
        }
        if (u1Var2.f459n != u1Var.f459n) {
            final int i26 = 4;
            this.H.c(6, new s1.m() { // from class: a2.z
                @Override // s1.m
                public final void a(Object obj82) {
                    p1.u0 u0Var = (p1.u0) obj82;
                    switch (i26) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            u1 u1Var4 = u1Var;
                            u0Var.i(u1Var4.f453g);
                            u0Var.t(u1Var4.f453g);
                            break;
                        case 1:
                            u1 u1Var5 = u1Var;
                            u0Var.z(u1Var5.f452e, u1Var5.f457l);
                            break;
                        case 2:
                            u0Var.E(u1Var.f452e);
                            break;
                        case 3:
                            u1 u1Var6 = u1Var;
                            u0Var.B(u1Var6.f458m, u1Var6.f457l);
                            break;
                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.f(u1Var.f459n);
                            break;
                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.P(u1Var.m());
                            break;
                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.O(u1Var.f460o);
                            break;
                        case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.L(u1Var.f);
                            break;
                        case 8:
                            u0Var.K(u1Var.f);
                            break;
                        default:
                            u0Var.q(u1Var.i.f11360d);
                            break;
                    }
                }
            });
        }
        if (u1Var2.m() != u1Var.m()) {
            final int i27 = 5;
            this.H.c(7, new s1.m() { // from class: a2.z
                @Override // s1.m
                public final void a(Object obj82) {
                    p1.u0 u0Var = (p1.u0) obj82;
                    switch (i27) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            u1 u1Var4 = u1Var;
                            u0Var.i(u1Var4.f453g);
                            u0Var.t(u1Var4.f453g);
                            break;
                        case 1:
                            u1 u1Var5 = u1Var;
                            u0Var.z(u1Var5.f452e, u1Var5.f457l);
                            break;
                        case 2:
                            u0Var.E(u1Var.f452e);
                            break;
                        case 3:
                            u1 u1Var6 = u1Var;
                            u0Var.B(u1Var6.f458m, u1Var6.f457l);
                            break;
                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.f(u1Var.f459n);
                            break;
                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.P(u1Var.m());
                            break;
                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.O(u1Var.f460o);
                            break;
                        case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.L(u1Var.f);
                            break;
                        case 8:
                            u0Var.K(u1Var.f);
                            break;
                        default:
                            u0Var.q(u1Var.i.f11360d);
                            break;
                    }
                }
            });
        }
        if (!u1Var2.f460o.equals(u1Var.f460o)) {
            final int i28 = 6;
            this.H.c(12, new s1.m() { // from class: a2.z
                @Override // s1.m
                public final void a(Object obj82) {
                    p1.u0 u0Var = (p1.u0) obj82;
                    switch (i28) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            u1 u1Var4 = u1Var;
                            u0Var.i(u1Var4.f453g);
                            u0Var.t(u1Var4.f453g);
                            break;
                        case 1:
                            u1 u1Var5 = u1Var;
                            u0Var.z(u1Var5.f452e, u1Var5.f457l);
                            break;
                        case 2:
                            u0Var.E(u1Var.f452e);
                            break;
                        case 3:
                            u1 u1Var6 = u1Var;
                            u0Var.B(u1Var6.f458m, u1Var6.f457l);
                            break;
                        case b1.j.LONG_FIELD_NUMBER /* 4 */:
                            u0Var.f(u1Var.f459n);
                            break;
                        case b1.j.STRING_FIELD_NUMBER /* 5 */:
                            u0Var.P(u1Var.m());
                            break;
                        case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                            u0Var.O(u1Var.f460o);
                            break;
                        case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                            u0Var.L(u1Var.f);
                            break;
                        case 8:
                            u0Var.K(u1Var.f);
                            break;
                        default:
                            u0Var.q(u1Var.i.f11360d);
                            break;
                    }
                }
            });
        }
        O1();
        this.H.b();
        if (u1Var2.f461p != u1Var.f461p) {
            Iterator it = this.I.iterator();
            while (it.hasNext()) {
                ((l0) it.next()).f312u.R1();
            }
        }
    }

    @Override // p1.w0
    public final int R() {
        S1();
        if (this.D0.f448a.p()) {
            return 0;
        }
        u1 u1Var = this.D0;
        return u1Var.f448a.b(u1Var.f449b.f9090a);
    }

    public final void R1() {
        int I = I();
        f2 f2Var = this.X;
        f2 f2Var2 = this.W;
        boolean z2 = false;
        if (I != 1) {
            if (I == 2 || I == 3) {
                S1();
                boolean z10 = this.D0.f461p;
                if (C() && !z10) {
                    z2 = true;
                }
                f2Var2.a(z2);
                f2Var.a(C());
                return;
            }
            if (I != 4) {
                throw new IllegalStateException();
            }
        }
        f2Var2.a(false);
        f2Var.a(false);
    }

    @Override // p1.w0
    public final r1.c S() {
        S1();
        return this.f362v0;
    }

    public final void S1() {
        this.f367y.b();
        Thread threadCurrentThread = Thread.currentThread();
        Looper looper = this.O;
        if (threadCurrentThread != looper.getThread()) {
            String name = Thread.currentThread().getName();
            String name2 = looper.getThread().getName();
            int i = s1.b0.f11647a;
            Locale locale = Locale.US;
            String str = "Player is accessed on the wrong thread.\nCurrent thread: '" + name + "'\nExpected thread: '" + name2 + "'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread";
            if (this.f364w0) {
                throw new IllegalStateException(str);
            }
            s1.b.q("ExoPlayerImpl", str, this.f366x0 ? null : new IllegalStateException());
            this.f366x0 = true;
        }
    }

    @Override // p1.w0
    public final void T(TextureView textureView) {
        S1();
        if (textureView == null || textureView != this.f356p0) {
            return;
        }
        t1();
    }

    @Override // p1.w0
    public final long T0() {
        S1();
        return s1.b0.b0(x1(this.D0));
    }

    @Override // p1.w0
    public final p1.r1 U() {
        S1();
        return this.B0;
    }

    @Override // p1.w0
    public final long V0() {
        S1();
        return this.Q;
    }

    @Override // p1.w0
    public final void W(p1.j0 j0Var) {
        S1();
        if (j0Var.equals(this.f351j0)) {
            return;
        }
        this.f351j0 = j0Var;
        this.H.e(15, new e0(this, 3));
    }

    @Override // p1.w0
    public final void X0(p1.d dVar, boolean z2) {
        S1();
        if (this.f370z0) {
            return;
        }
        boolean zEquals = Objects.equals(this.f359s0, dVar);
        s1.p pVar = this.H;
        if (!zEquals) {
            this.f359s0 = dVar;
            J1(1, 3, dVar);
            pVar.c(20, new f0(1, dVar));
        }
        p1.d dVar2 = this.f359s0;
        s1.y yVar = this.G.B;
        yVar.getClass();
        s1.x xVarB = s1.y.b();
        xVarB.f11716a = yVar.f11718a.obtainMessage(31, z2 ? 1 : 0, 0, dVar2);
        xVarB.b();
        pVar.b();
    }

    @Override // p1.w0
    public final float Y() {
        S1();
        return this.f360t0;
    }

    @Override // p1.w0
    public final p1.d a0() {
        S1();
        return this.f359s0;
    }

    @Override // p1.w0
    public final void b0(p1.l1 l1Var) {
        S1();
        r2.u uVar = this.D;
        uVar.getClass();
        p1.l1 l1VarE0 = E0();
        if (!l1Var.equals(((r2.p) uVar).e())) {
            uVar.b(l1Var);
        }
        if (l1VarE0.equals(l1Var)) {
            return;
        }
        this.H.e(19, new f0(0, l1Var));
    }

    @Override // p1.w0
    public final boolean c() {
        S1();
        return this.D0.f453g;
    }

    @Override // p1.w0
    public final int c0() {
        S1();
        if (o()) {
            return this.D0.f449b.f9091b;
        }
        return -1;
    }

    @Override // p1.w0
    public final void d() {
        S1();
        u1 u1Var = this.D0;
        if (u1Var.f452e != 1) {
            return;
        }
        u1 u1VarF = u1Var.f(null);
        u1 u1VarB1 = B1(u1VarF, u1VarF.f448a.p() ? 4 : 2);
        this.f344c0++;
        s1.y yVar = this.G.B;
        yVar.getClass();
        s1.x xVarB = s1.y.b();
        xVarB.f11716a = yVar.f11718a.obtainMessage(29);
        xVarB.b();
        Q1(u1VarB1, 1, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // p1.w0
    public final int d0() {
        S1();
        int iY1 = y1(this.D0);
        if (iY1 == -1) {
            return 0;
        }
        return iY1;
    }

    @Override // p1.w0
    public final void e(p1.q0 q0Var) {
        S1();
        if (this.D0.f460o.equals(q0Var)) {
            return;
        }
        u1 u1VarG = this.D0.g(q0Var);
        this.f344c0++;
        this.G.B.a(4, q0Var).b();
        Q1(u1VarG, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // p1.w0
    public final void f0(int i, boolean z2) {
        S1();
    }

    @Override // p1.w0
    public final p1.j g0() {
        S1();
        return this.A0;
    }

    @Override // p1.w0
    public final long getDuration() {
        S1();
        if (!o()) {
            return Q();
        }
        u1 u1Var = this.D0;
        o2.d0 d0Var = u1Var.f449b;
        p1.f1 f1Var = u1Var.f448a;
        Object obj = d0Var.f9090a;
        p1.c1 c1Var = this.J;
        f1Var.g(obj, c1Var);
        return s1.b0.b0(c1Var.a(d0Var.f9091b, d0Var.f9092c));
    }

    @Override // p1.w0
    public final p1.q0 h() {
        S1();
        return this.D0.f460o;
    }

    @Override // p1.w0
    public final void h0() {
        S1();
    }

    @Override // p1.w0
    public final void i0(int i) {
        S1();
        if (this.f342a0 != i) {
            this.f342a0 = i;
            s1.y yVar = this.G.B;
            yVar.getClass();
            s1.x xVarB = s1.y.b();
            xVarB.f11716a = yVar.f11718a.obtainMessage(11, i, 0);
            xVarB.b();
            c0 c0Var = new c0(i, 0);
            s1.p pVar = this.H;
            pVar.c(8, c0Var);
            O1();
            pVar.b();
        }
    }

    @Override // p1.w0
    public final void j(List list, int i, long j5) {
        S1();
        ArrayList arrayListU1 = u1(list);
        S1();
        K1(arrayListU1, i, j5, false);
    }

    @Override // p1.w0
    public final void j0(int i, int i10) {
        S1();
    }

    @Override // c3.e
    public final void j1(int i, long j5, boolean z2) {
        S1();
        if (i == -1) {
            return;
        }
        s1.d.b(i >= 0);
        p1.f1 f1Var = this.D0.f448a;
        if (f1Var.p() || i < f1Var.o()) {
            b2.h hVar = this.N;
            if (!hVar.C) {
                b2.a aVarR = hVar.R();
                hVar.C = true;
                hVar.W(aVarR, -1, new s(21));
            }
            this.f344c0++;
            if (o()) {
                s1.b.p("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                u0 u0Var = new u0(this.D0);
                u0Var.f(1);
                o0 o0Var = this.F.f192v;
                o0Var.E.c(new g0(o0Var, 0, u0Var));
                return;
            }
            u1 u1VarH = this.D0;
            int i10 = u1VarH.f452e;
            if (i10 == 3 || (i10 == 4 && !f1Var.p())) {
                u1VarH = this.D0.h(2);
            }
            int iD0 = d0();
            u1 u1VarC1 = C1(u1VarH, f1Var, D1(f1Var, i, j5));
            this.G.B.a(3, new w0(f1Var, i, s1.b0.O(j5))).b();
            Q1(u1VarC1, 0, true, 1, x1(u1VarC1), iD0, z2);
        }
    }

    @Override // p1.w0
    public final p1.p0 k() {
        S1();
        return this.D0.f;
    }

    @Override // p1.w0
    public final void k0(boolean z2) {
        S1();
    }

    @Override // p1.w0
    public final int l() {
        S1();
        return 0;
    }

    @Override // p1.w0
    public final void l0(int i) {
        S1();
    }

    @Override // p1.w0
    public final void m(boolean z2) {
        S1();
        P1(1, z2);
    }

    @Override // p1.w0
    public final int m0() {
        S1();
        if (o()) {
            return this.D0.f449b.f9092c;
        }
        return -1;
    }

    @Override // p1.w0
    public final void n(Surface surface) {
        S1();
        I1();
        M1(surface);
        int i = surface == null ? 0 : -1;
        E1(i, i);
    }

    @Override // p1.w0
    public final void n0(SurfaceView surfaceView) {
        S1();
        if (surfaceView instanceof u2.t) {
            I1();
            M1(surfaceView);
            L1(surfaceView.getHolder());
            return;
        }
        boolean z2 = surfaceView instanceof v2.k;
        l0 l0Var = this.T;
        if (z2) {
            I1();
            this.f354n0 = (v2.k) surfaceView;
            x1 x1VarV1 = v1(this.U);
            s1.d.g(!x1VarV1.f);
            x1VarV1.f511c = 10000;
            v2.k kVar = this.f354n0;
            s1.d.g(true ^ x1VarV1.f);
            x1VarV1.f512d = kVar;
            x1VarV1.b();
            this.f354n0.f13215u.add(l0Var);
            M1(this.f354n0.getVideoSurface());
            L1(surfaceView.getHolder());
            return;
        }
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        S1();
        if (holder == null) {
            t1();
            return;
        }
        I1();
        this.f355o0 = true;
        this.f353m0 = holder;
        holder.addCallback(l0Var);
        Surface surface = holder.getSurface();
        if (surface == null || !surface.isValid()) {
            M1(null);
            E1(0, 0);
        } else {
            M1(surface);
            Rect surfaceFrame = holder.getSurfaceFrame();
            E1(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // p1.w0
    public final boolean o() {
        S1();
        return this.D0.f449b.b();
    }

    @Override // p1.w0
    public final void o0(SurfaceView surfaceView) {
        S1();
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        S1();
        if (holder == null || holder != this.f353m0) {
            return;
        }
        t1();
    }

    @Override // p1.w0
    public final long q() {
        S1();
        return this.R;
    }

    @Override // p1.w0
    public final void q0(int i, int i10, int i11) {
        S1();
        s1.d.b(i >= 0 && i <= i10 && i11 >= 0);
        ArrayList arrayList = this.K;
        int size = arrayList.size();
        int iMin = Math.min(i10, size);
        int iMin2 = Math.min(i11, size - (iMin - i));
        if (i >= size || i == iMin || i == iMin2) {
            return;
        }
        p1.f1 f1VarW0 = w0();
        this.f344c0++;
        s1.b0.N(arrayList, i, iMin, iMin2);
        o2.f1 f1Var = this.f348g0;
        f1Var.getClass();
        this.f348g0 = f1Var;
        z1 z1Var = new z1(arrayList, this.f348g0);
        u1 u1Var = this.D0;
        u1 u1VarC1 = C1(u1Var, z1Var, z1(f1VarW0, z1Var, y1(u1Var), w1(this.D0)));
        o2.f1 f1Var2 = this.f348g0;
        x0 x0Var = this.G;
        x0Var.getClass();
        x0Var.B.a(19, new t0(i, iMin, iMin2, f1Var2)).b();
        Q1(u1VarC1, 0, false, 5, -9223372036854775807L, -1, false);
    }

    public final ArrayList q1(int i, List list) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            s1 s1Var = new s1((o2.a) list.get(i10), this.L);
            arrayList.add(s1Var);
            n0 n0Var = new n0(s1Var.f402b, s1Var.f401a);
            this.K.add(i10 + i, n0Var);
        }
        this.f348g0 = this.f348g0.a(i, arrayList.size());
        return arrayList;
    }

    public final u1 r1(u1 u1Var, int i, ArrayList arrayList) {
        p1.f1 f1Var = u1Var.f448a;
        this.f344c0++;
        ArrayList arrayListQ1 = q1(i, arrayList);
        z1 z1Var = new z1(this.K, this.f348g0);
        u1 u1VarC1 = C1(u1Var, z1Var, z1(f1Var, z1Var, y1(u1Var), w1(u1Var)));
        o2.f1 f1Var2 = this.f348g0;
        s1.y yVar = this.G.B;
        s0 s0Var = new s0(arrayListQ1, f1Var2, -1, -9223372036854775807L);
        yVar.getClass();
        s1.x xVarB = s1.y.b();
        xVarB.f11716a = yVar.f11718a.obtainMessage(18, i, 0, s0Var);
        xVarB.b();
        return u1VarC1;
    }

    @Override // p1.w0
    public final long s() {
        S1();
        return w1(this.D0);
    }

    @Override // p1.w0
    public final int s0() {
        S1();
        return this.D0.f459n;
    }

    public final p1.j0 s1() {
        p1.f1 f1VarW0 = w0();
        if (f1VarW0.p()) {
            return this.C0;
        }
        p1.g0 g0Var = f1VarW0.m(d0(), (p1.e1) this.f2454v, 0L).f9715c;
        p1.i0 i0VarA = this.C0.a();
        p1.j0 j0Var = g0Var.f9759d;
        if (j0Var != null) {
            aa.j0 j0Var2 = j0Var.J;
            byte[] bArr = j0Var.f9844k;
            CharSequence charSequence = j0Var.f9836a;
            if (charSequence != null) {
                i0VarA.f9785a = charSequence;
            }
            CharSequence charSequence2 = j0Var.f9837b;
            if (charSequence2 != null) {
                i0VarA.f9786b = charSequence2;
            }
            CharSequence charSequence3 = j0Var.f9838c;
            if (charSequence3 != null) {
                i0VarA.f9787c = charSequence3;
            }
            CharSequence charSequence4 = j0Var.f9839d;
            if (charSequence4 != null) {
                i0VarA.f9788d = charSequence4;
            }
            CharSequence charSequence5 = j0Var.f9840e;
            if (charSequence5 != null) {
                i0VarA.f9789e = charSequence5;
            }
            CharSequence charSequence6 = j0Var.f;
            if (charSequence6 != null) {
                i0VarA.f = charSequence6;
            }
            CharSequence charSequence7 = j0Var.f9841g;
            if (charSequence7 != null) {
                i0VarA.f9790g = charSequence7;
            }
            Long l10 = j0Var.f9842h;
            if (l10 != null) {
                s1.d.b(l10.longValue() >= 0);
                i0VarA.f9791h = l10;
            }
            p1.x0 x0Var = j0Var.i;
            if (x0Var != null) {
                i0VarA.i = x0Var;
            }
            p1.x0 x0Var2 = j0Var.f9843j;
            if (x0Var2 != null) {
                i0VarA.f9792j = x0Var2;
            }
            Uri uri = j0Var.f9846m;
            if (uri != null || bArr != null) {
                i0VarA.f9795m = uri;
                Integer num = j0Var.f9845l;
                i0VarA.f9793k = bArr == null ? null : (byte[]) bArr.clone();
                i0VarA.f9794l = num;
            }
            Integer num2 = j0Var.f9847n;
            if (num2 != null) {
                i0VarA.f9796n = num2;
            }
            Integer num3 = j0Var.f9848o;
            if (num3 != null) {
                i0VarA.f9797o = num3;
            }
            Integer num4 = j0Var.f9849p;
            if (num4 != null) {
                i0VarA.f9798p = num4;
            }
            Boolean bool = j0Var.f9850q;
            if (bool != null) {
                i0VarA.f9799q = bool;
            }
            Boolean bool2 = j0Var.f9851r;
            if (bool2 != null) {
                i0VarA.f9800r = bool2;
            }
            Integer num5 = j0Var.f9852s;
            if (num5 != null) {
                i0VarA.f9801s = num5;
            }
            Integer num6 = j0Var.f9853t;
            if (num6 != null) {
                i0VarA.f9801s = num6;
            }
            Integer num7 = j0Var.f9854u;
            if (num7 != null) {
                i0VarA.f9802t = num7;
            }
            Integer num8 = j0Var.f9855v;
            if (num8 != null) {
                i0VarA.f9803u = num8;
            }
            Integer num9 = j0Var.f9856w;
            if (num9 != null) {
                i0VarA.f9804v = num9;
            }
            Integer num10 = j0Var.f9857x;
            if (num10 != null) {
                i0VarA.f9805w = num10;
            }
            Integer num11 = j0Var.f9858y;
            if (num11 != null) {
                i0VarA.f9806x = num11;
            }
            CharSequence charSequence8 = j0Var.f9859z;
            if (charSequence8 != null) {
                i0VarA.f9807y = charSequence8;
            }
            CharSequence charSequence9 = j0Var.A;
            if (charSequence9 != null) {
                i0VarA.f9808z = charSequence9;
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
            if (!j0Var2.isEmpty()) {
                i0VarA.I = aa.j0.r(j0Var2);
            }
        }
        return new p1.j0(i0VarA);
    }

    @Override // p1.w0
    public final void stop() {
        S1();
        N1(null);
        this.f362v0 = new r1.c(this.D0.f464s, aa.c1.f650y);
    }

    @Override // p1.w0
    public final long t() {
        S1();
        return s1.b0.b0(this.D0.f463r);
    }

    @Override // p1.w0
    public final void t0(int i, int i10, List list) {
        S1();
        s1.d.b(i >= 0 && i10 >= i);
        ArrayList arrayList = this.K;
        int size = arrayList.size();
        if (i > size) {
            return;
        }
        int iMin = Math.min(i10, size);
        if (iMin - i == list.size()) {
            for (int i11 = i; i11 < iMin; i11++) {
                if (((n0) arrayList.get(i11)).f336b.E.a((p1.g0) list.get(i11 - i))) {
                }
            }
            this.f344c0++;
            s1.y yVar = this.G.B;
            yVar.getClass();
            s1.x xVarB = s1.y.b();
            xVarB.f11716a = yVar.f11718a.obtainMessage(27, i, iMin, list);
            xVarB.b();
            for (int i12 = i; i12 < iMin; i12++) {
                n0 n0Var = (n0) arrayList.get(i12);
                n0Var.f337c = new y1(n0Var.f337c, (p1.g0) list.get(i12 - i));
            }
            Q1(this.D0.j(new z1(arrayList, this.f348g0)), 0, false, 4, -9223372036854775807L, -1, false);
            return;
        }
        ArrayList arrayListU1 = u1(list);
        if (!arrayList.isEmpty()) {
            u1 u1VarG1 = G1(r1(this.D0, iMin, arrayListU1), i, iMin);
            Q1(u1VarG1, 0, !u1VarG1.f449b.f9090a.equals(this.D0.f449b.f9090a), 4, x1(u1VarG1), -1, false);
        } else {
            boolean z2 = this.E0 == -1;
            S1();
            K1(arrayListU1, -1, -9223372036854775807L, z2);
        }
    }

    public final void t1() {
        S1();
        I1();
        M1(null);
        E1(0, 0);
    }

    public final ArrayList u1(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(this.M.c((p1.g0) list.get(i)));
        }
        return arrayList;
    }

    @Override // p1.w0
    public final void v(int i, List list) {
        S1();
        ArrayList arrayListU1 = u1(list);
        S1();
        s1.d.b(i >= 0);
        ArrayList arrayList = this.K;
        int iMin = Math.min(i, arrayList.size());
        if (!arrayList.isEmpty()) {
            Q1(r1(this.D0, iMin, arrayListU1), 0, false, 5, -9223372036854775807L, -1, false);
            return;
        }
        boolean z2 = this.E0 == -1;
        S1();
        K1(arrayListU1, -1, -9223372036854775807L, z2);
    }

    @Override // p1.w0
    public final int v0() {
        S1();
        return this.f342a0;
    }

    public final x1 v1(w1 w1Var) {
        int iY1 = y1(this.D0);
        p1.f1 f1Var = this.D0.f448a;
        if (iY1 == -1) {
            iY1 = 0;
        }
        x0 x0Var = this.G;
        return new x1(x0Var, w1Var, f1Var, iY1, x0Var.D);
    }

    @Override // p1.w0
    public final p1.s0 w() {
        S1();
        return this.f349h0;
    }

    @Override // p1.w0
    public final p1.f1 w0() {
        S1();
        return this.D0.f448a;
    }

    public final long w1(u1 u1Var) {
        o2.d0 d0Var = u1Var.f449b;
        long j5 = u1Var.f450c;
        p1.f1 f1Var = u1Var.f448a;
        if (!d0Var.b()) {
            return s1.b0.b0(x1(u1Var));
        }
        Object obj = u1Var.f449b.f9090a;
        p1.c1 c1Var = this.J;
        f1Var.g(obj, c1Var);
        if (j5 == -9223372036854775807L) {
            return s1.b0.b0(f1Var.m(y1(u1Var), (p1.e1) this.f2454v, 0L).f9722l);
        }
        return s1.b0.b0(j5) + s1.b0.b0(c1Var.f9680e);
    }

    @Override // p1.w0
    public final boolean x0() {
        S1();
        return false;
    }

    public final long x1(u1 u1Var) {
        if (u1Var.f448a.p()) {
            return s1.b0.O(this.F0);
        }
        long jL = u1Var.f461p ? u1Var.l() : u1Var.f464s;
        if (u1Var.f449b.b()) {
            return jL;
        }
        p1.f1 f1Var = u1Var.f448a;
        Object obj = u1Var.f449b.f9090a;
        p1.c1 c1Var = this.J;
        f1Var.g(obj, c1Var);
        return jL + c1Var.f9680e;
    }

    public final int y1(u1 u1Var) {
        return u1Var.f448a.p() ? this.E0 : u1Var.f448a.g(u1Var.f449b.f9090a, this.J).f9678c;
    }

    @Override // p1.w0
    public final Looper z0() {
        return this.O;
    }

    public final Pair z1(p1.f1 f1Var, z1 z1Var, int i, long j5) {
        if (f1Var.p() || z1Var.p()) {
            boolean z2 = !f1Var.p() && z1Var.p();
            return D1(z1Var, z2 ? -1 : i, z2 ? -9223372036854775807L : j5);
        }
        Pair pairI = f1Var.i((p1.e1) this.f2454v, this.J, i, s1.b0.O(j5));
        Object obj = pairI.first;
        if (z1Var.b(obj) != -1) {
            return pairI;
        }
        int iT = x0.T((p1.e1) this.f2454v, this.J, this.f342a0, this.f343b0, obj, f1Var, z1Var);
        if (iT == -1) {
            return D1(z1Var, -1, -9223372036854775807L);
        }
        p1.e1 e1Var = (p1.e1) this.f2454v;
        z1Var.m(iT, e1Var, 0L);
        return D1(z1Var, iT, s1.b0.b0(e1Var.f9722l));
    }
}
