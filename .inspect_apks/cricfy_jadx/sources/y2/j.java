package y2;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.util.SparseArray;
import android.view.Surface;
import androidx.media3.decoder.DecoderInputBuffer;
import g2.o1;
import g2.q1;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import s2.a1;
import ua.g0;
import ua.i0;
import ua.z0;
import v1.c1;
import v1.f1;
import v1.m0;
import v1.r1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends p2.r {
    public static final int[] S1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    public static boolean T1;
    public static boolean U1;
    public int A1;
    public int B1;
    public q1 C1;
    public boolean D1;
    public long E1;
    public int F1;
    public long G1;
    public r1 H1;
    public r1 I1;
    public int J1;
    public boolean K1;
    public int L1;
    public i M1;
    public u N1;
    public long O1;
    public long P1;
    public boolean Q1;
    public int R1;
    public final Context c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public final boolean f14669d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public final vb.b f14670e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public final int f14671f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public final boolean f14672g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public final v f14673h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public final u3.a f14674i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public final long f14675j1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public final PriorityQueue f14676k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public a3.d f14677l1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public boolean f14678m1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public boolean f14679n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public f0 f14680o1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public boolean f14681p1;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public int f14682q1;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public List f14683r1;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public Surface f14684s1;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public l f14685t1;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public y1.u f14686u1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public boolean f14687v1;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public int f14688w1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public int f14689x1;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public long f14690y1;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public int f14691z1;

    public j(h hVar) {
        super(2, hVar.f14662c, hVar.f14664e, 30.0f);
        Context applicationContext = hVar.f14660a.getApplicationContext();
        this.c1 = applicationContext;
        this.f14671f1 = hVar.f14666h;
        this.f14680o1 = null;
        this.f14670e1 = new vb.b(hVar.f, hVar.f14665g);
        this.f14669d1 = this.f14680o1 == null;
        this.f14673h1 = new v(applicationContext, this, hVar.f14663d);
        this.f14674i1 = new u3.a();
        this.f14672g1 = "NVIDIA".equals(Build.MANUFACTURER);
        this.f14686u1 = y1.u.f14612c;
        this.f14688w1 = 1;
        this.f14689x1 = 0;
        this.H1 = r1.f12978d;
        this.L1 = 0;
        this.I1 = null;
        this.J1 = -1000;
        this.O1 = -9223372036854775807L;
        this.P1 = -9223372036854775807L;
        this.f14676k1 = new PriorityQueue();
        this.f14675j1 = -9223372036854775807L;
        this.C1 = null;
    }

    public static List A0(Context context, p2.j jVar, v1.p pVar, boolean z10, boolean z11) {
        String str = pVar.f12946n;
        if (str == null) {
            return z0.f12413z;
        }
        if (Build.VERSION.SDK_INT >= 26 && "video/dolby-vision".equals(str) && !sd.i.o(context)) {
            String strB = p2.x.b(pVar);
            List listA = strB == null ? z0.f12413z : jVar.a(strB, z10, z11);
            if (!listA.isEmpty()) {
                return listA;
            }
        }
        return p2.x.f(jVar, pVar, z10, z11);
    }

    public static int B0(p2.o oVar, v1.p pVar) {
        int i = pVar.f12947o;
        List list = pVar.f12949q;
        if (i == -1) {
            return z0(oVar, pVar);
        }
        int size = list.size();
        int length = 0;
        for (int i10 = 0; i10 < size; i10++) {
            length += ((byte[]) list.get(i10)).length;
        }
        return pVar.f12947o + length;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean y0(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 3206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.j.y0(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int z0(p2.o r11, v1.p r12) {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.j.z0(p2.o, v1.p):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.Surface C0(p2.o r6) {
        /*
            r5 = this;
            y2.f0 r0 = r5.f14680o1
            if (r0 == 0) goto L9
            android.view.Surface r6 = r0.c()
            return r6
        L9:
            android.view.Surface r0 = r5.f14684s1
            if (r0 == 0) goto Le
            return r0
        Le:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 35
            r2 = 0
            if (r0 < r1) goto L1a
            boolean r0 = r6.f9931h
            if (r0 == 0) goto L1a
            return r2
        L1a:
            boolean r0 = r5.L0(r6)
            y1.d.g(r0)
            y2.l r0 = r5.f14685t1
            if (r0 == 0) goto L32
            boolean r1 = r0.f14699v
            boolean r3 = r6.f
            if (r1 == r3) goto L32
            if (r0 == 0) goto L32
            r0.release()
            r5.f14685t1 = r2
        L32:
            y2.l r0 = r5.f14685t1
            if (r0 != 0) goto Lab
            android.content.Context r0 = r5.c1
            boolean r6 = r6.f
            r1 = 1
            r2 = 0
            if (r6 == 0) goto L47
            boolean r0 = y2.l.b(r0)
            if (r0 == 0) goto L45
            goto L49
        L45:
            r0 = r2
            goto L4a
        L47:
            int r0 = y2.l.f14697y
        L49:
            r0 = r1
        L4a:
            y1.d.g(r0)
            y2.k r0 = new y2.k
            java.lang.String r3 = "ExoPlayer:PlaceholderSurface"
            r0.<init>(r3)
            if (r6 == 0) goto L59
            int r6 = y2.l.f14697y
            goto L5a
        L59:
            r6 = r2
        L5a:
            r0.start()
            android.os.Handler r3 = new android.os.Handler
            android.os.Looper r4 = r0.getLooper()
            r3.<init>(r4, r0)
            r0.f14693w = r3
            y1.j r4 = new y1.j
            r4.<init>(r3)
            r0.f14692v = r4
            monitor-enter(r0)
            android.os.Handler r3 = r0.f14693w     // Catch: java.lang.Throwable -> L89
            android.os.Message r6 = r3.obtainMessage(r1, r6, r2)     // Catch: java.lang.Throwable -> L89
            r6.sendToTarget()     // Catch: java.lang.Throwable -> L89
        L79:
            y2.l r6 = r0.f14696z     // Catch: java.lang.Throwable -> L89
            if (r6 != 0) goto L8d
            java.lang.RuntimeException r6 = r0.f14695y     // Catch: java.lang.Throwable -> L89
            if (r6 != 0) goto L8d
            java.lang.Error r6 = r0.f14694x     // Catch: java.lang.Throwable -> L89
            if (r6 != 0) goto L8d
            r0.wait()     // Catch: java.lang.Throwable -> L89 java.lang.InterruptedException -> L8b
            goto L79
        L89:
            r6 = move-exception
            goto La9
        L8b:
            r2 = r1
            goto L79
        L8d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L89
            if (r2 == 0) goto L97
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            r6.interrupt()
        L97:
            java.lang.RuntimeException r6 = r0.f14695y
            if (r6 != 0) goto La8
            java.lang.Error r6 = r0.f14694x
            if (r6 != 0) goto La7
            y2.l r6 = r0.f14696z
            r6.getClass()
            r5.f14685t1 = r6
            goto Lab
        La7:
            throw r6
        La8:
            throw r6
        La9:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L89
            throw r6
        Lab:
            y2.l r6 = r5.f14685t1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.j.C0(p2.o):android.view.Surface");
    }

    @Override // p2.r
    public final g2.g D(p2.o oVar, v1.p pVar, v1.p pVar2) {
        g2.g gVarB = oVar.b(pVar, pVar2);
        int i = gVarB.f4688e;
        a3.d dVar = this.f14677l1;
        dVar.getClass();
        if (pVar2.f12953u > dVar.f154a || pVar2.f12954v > dVar.f155b) {
            i |= 256;
        }
        if (B0(oVar, pVar2) > dVar.f156c) {
            i |= 64;
        }
        int i10 = i;
        return new g2.g(oVar.f9925a, pVar, pVar2, i10 != 0 ? 0 : gVarB.f4687d, i10);
    }

    public final boolean D0(p2.o oVar) {
        if (this.f14680o1 != null) {
            return true;
        }
        Surface surface = this.f14684s1;
        if (surface == null || !surface.isValid()) {
            return (Build.VERSION.SDK_INT >= 35 && oVar.f9931h) || L0(oVar);
        }
        return true;
    }

    @Override // p2.r
    public final p2.n E(IllegalStateException illegalStateException, p2.o oVar) {
        Surface surface = this.f14684s1;
        f fVar = new f(illegalStateException, oVar);
        System.identityHashCode(surface);
        if (surface != null) {
            surface.isValid();
        }
        return fVar;
    }

    public final boolean E0(DecoderInputBuffer decoderInputBuffer) {
        if (k() || decoderInputBuffer.isLastSample()) {
            return true;
        }
        long j4 = this.P1;
        return j4 == -9223372036854775807L || j4 - (decoderInputBuffer.timeUs - this.U0.f9942c) <= 100000;
    }

    public final void F0() {
        if (this.f14691z1 > 0) {
            this.B.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j4 = jElapsedRealtime - this.f14690y1;
            int i = this.f14691z1;
            vb.b bVar = this.f14670e1;
            Handler handler = (Handler) bVar.f13551w;
            if (handler != null) {
                handler.post(new b0(bVar, i, j4));
            }
            this.f14691z1 = 0;
            this.f14690y1 = jElapsedRealtime;
        }
    }

    public final void G0() {
        if (this.K1) {
            int i = Build.VERSION.SDK_INT;
            p2.l lVar = this.f9953h0;
            if (lVar == null) {
                return;
            }
            this.M1 = new i(this, lVar);
            if (i >= 33) {
                Bundle bundle = new Bundle();
                bundle.putInt("tunnel-peek", 1);
                lVar.a(bundle);
            }
        }
    }

    public final void H0(long j4) {
        Surface surface;
        x0(j4);
        r1 r1Var = this.H1;
        boolean zEquals = r1Var.equals(r1.f12978d);
        vb.b bVar = this.f14670e1;
        if (!zEquals && !r1Var.equals(this.I1)) {
            this.I1 = r1Var;
            bVar.l(r1Var);
        }
        this.T0.f4672e++;
        v vVar = this.f14673h1;
        boolean z10 = vVar.f14732e != 3;
        vVar.f14732e = 3;
        vVar.f14737l.getClass();
        vVar.f14733g = y1.a0.O(SystemClock.elapsedRealtime());
        if (z10 && (surface = this.f14684s1) != null) {
            bVar.i(surface);
            this.f14687v1 = true;
        }
        c0(j4);
    }

    public final void I0(p2.l lVar, int i, long j4) {
        Surface surface;
        Trace.beginSection("releaseOutputBuffer");
        lVar.r(i, j4);
        Trace.endSection();
        this.T0.f4672e++;
        this.A1 = 0;
        if (this.f14680o1 == null) {
            r1 r1Var = this.H1;
            boolean zEquals = r1Var.equals(r1.f12978d);
            vb.b bVar = this.f14670e1;
            if (!zEquals && !r1Var.equals(this.I1)) {
                this.I1 = r1Var;
                bVar.l(r1Var);
            }
            v vVar = this.f14673h1;
            boolean z10 = vVar.f14732e != 3;
            vVar.f14732e = 3;
            vVar.f14737l.getClass();
            vVar.f14733g = y1.a0.O(SystemClock.elapsedRealtime());
            if (!z10 || (surface = this.f14684s1) == null) {
                return;
            }
            bVar.i(surface);
            this.f14687v1 = true;
        }
    }

    public final void J0(Object obj) throws g2.n {
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        Surface surface2 = this.f14684s1;
        vb.b bVar = this.f14670e1;
        if (surface2 == surface) {
            if (surface != null) {
                r1 r1Var = this.I1;
                if (r1Var != null) {
                    bVar.l(r1Var);
                }
                Surface surface3 = this.f14684s1;
                if (surface3 == null || !this.f14687v1) {
                    return;
                }
                bVar.i(surface3);
                return;
            }
            return;
        }
        this.f14684s1 = surface;
        f0 f0Var = this.f14680o1;
        v vVar = this.f14673h1;
        if (f0Var == null) {
            vVar.h(surface);
        }
        this.f14687v1 = false;
        int i = this.C;
        p2.l lVar = this.f9953h0;
        if (lVar != null && this.f14680o1 == null) {
            p2.o oVar = this.o0;
            oVar.getClass();
            boolean zD0 = D0(oVar);
            int i10 = Build.VERSION.SDK_INT;
            if (!zD0 || this.f14678m1) {
                i0();
                T();
            } else {
                Surface surfaceC0 = C0(oVar);
                if (surfaceC0 != null) {
                    lVar.p(surfaceC0);
                } else {
                    if (i10 < 35) {
                        throw new IllegalStateException();
                    }
                    lVar.n();
                }
            }
        }
        if (surface != null) {
            r1 r1Var2 = this.I1;
            if (r1Var2 != null) {
                bVar.l(r1Var2);
            }
        } else {
            this.I1 = null;
            f0 f0Var2 = this.f14680o1;
            if (f0Var2 != null) {
                f0Var2.a();
            }
        }
        if (i == 2) {
            f0 f0Var3 = this.f14680o1;
            if (f0Var3 != null) {
                f0Var3.k(true);
            } else {
                vVar.c(true);
            }
        }
        G0();
    }

    public final boolean K0(long j4, long j7, boolean z10, boolean z11) throws g2.n {
        if (this.f14680o1 != null && this.f14669d1) {
            j7 -= -this.O1;
        }
        if (j4 < -500000 && !z10) {
            a1 a1Var = this.D;
            a1Var.getClass();
            int iE = a1Var.e(j7 - this.F);
            if (iE != 0) {
                PriorityQueue priorityQueue = this.f14676k1;
                if (z11) {
                    g2.f fVar = this.T0;
                    int i = fVar.f4671d + iE;
                    fVar.f4671d = i;
                    fVar.f += this.B1;
                    fVar.f4671d = priorityQueue.size() + i;
                } else {
                    this.T0.f4675j++;
                    N0(priorityQueue.size() + iE, this.B1);
                }
                if (J()) {
                    T();
                }
                f0 f0Var = this.f14680o1;
                if (f0Var != null) {
                    f0Var.f(false);
                }
                return true;
            }
        }
        return false;
    }

    @Override // p2.r
    public final int L(DecoderInputBuffer decoderInputBuffer) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ((this.C1 == null && !this.K1) || decoderInputBuffer.timeUs >= this.G || E0(decoderInputBuffer)) ? 0 : 32;
        }
        return 0;
    }

    public final boolean L0(p2.o oVar) {
        if (this.K1 || y0(oVar.f9925a)) {
            return false;
        }
        return !oVar.f || l.b(this.c1);
    }

    @Override // p2.r
    public final float M(float f, v1.p pVar, v1.p[] pVarArr) {
        p2.o oVar;
        float fMax = -1.0f;
        for (v1.p pVar2 : pVarArr) {
            float f10 = pVar2.f12957y;
            if (f10 != -1.0f) {
                fMax = Math.max(fMax, f10);
            }
        }
        float f11 = fMax == -1.0f ? -1.0f : fMax * f;
        if (this.C1 == null || (oVar = this.o0) == null) {
            return f11;
        }
        int i = pVar.f12953u;
        int i10 = pVar.f12954v;
        float f12 = -3.4028235E38f;
        if (oVar.i) {
            float f13 = oVar.f9934l;
            if (f13 != -3.4028235E38f && oVar.f9932j == i && oVar.f9933k == i10) {
                f12 = f13;
            } else {
                float f14 = 1024.0f;
                if (!oVar.g(i, i10, 1024.0f)) {
                    f12 = 0.0f;
                    while (true) {
                        float f15 = f14 - f12;
                        if (Math.abs(f15) <= 5.0f) {
                            break;
                        }
                        float f16 = (f15 / 2.0f) + f12;
                        if (oVar.g(i, i10, f16)) {
                            f12 = f16;
                        } else {
                            f14 = f16;
                        }
                    }
                } else {
                    f12 = 1024.0f;
                }
                oVar.f9934l = f12;
                oVar.f9932j = i;
                oVar.f9933k = i10;
            }
        }
        return f11 != -1.0f ? Math.max(f11, f12) : f12;
    }

    public final void M0(p2.l lVar, int i) {
        Trace.beginSection("skipVideoBuffer");
        lVar.f(i);
        Trace.endSection();
        this.T0.f++;
    }

    @Override // p2.r
    public final ArrayList N(p2.j jVar, v1.p pVar, boolean z10) {
        List listA0 = A0(this.c1, jVar, pVar, z10, this.K1);
        HashMap map = p2.x.f9976a;
        ArrayList arrayList = new ArrayList(listA0);
        Collections.sort(arrayList, new p2.s(0, new kb.d(7, pVar)));
        return arrayList;
    }

    public final void N0(int i, int i10) {
        g2.f fVar = this.T0;
        fVar.f4674h += i;
        int i11 = i + i10;
        fVar.f4673g += i11;
        this.f14691z1 += i11;
        int i12 = this.A1 + i11;
        this.A1 = i12;
        fVar.i = Math.max(i12, fVar.i);
        int i13 = this.f14671f1;
        if (i13 <= 0 || this.f14691z1 < i13) {
            return;
        }
        F0();
    }

    public final void O0(long j4) {
        g2.f fVar = this.T0;
        fVar.f4676k += j4;
        fVar.f4677l++;
        this.E1 += j4;
        this.F1++;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0135, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0138, code lost:
    
        r15 = r9;
     */
    @Override // p2.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c2.o P(p2.o r25, v1.p r26, android.media.MediaCrypto r27, float r28) {
        /*
            Method dump skipped, instruction units count: 627
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.j.P(p2.o, v1.p, android.media.MediaCrypto, float):c2.o");
    }

    @Override // p2.r
    public final void Q(DecoderInputBuffer decoderInputBuffer) {
        if (this.f14679n1) {
            ByteBuffer byteBuffer = decoderInputBuffer.supplementalData;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b8 = byteBuffer.get();
                short s10 = byteBuffer.getShort();
                short s11 = byteBuffer.getShort();
                byte b10 = byteBuffer.get();
                byte b11 = byteBuffer.get();
                byteBuffer.position(0);
                if (b8 == -75 && s10 == 60 && s11 == 1 && b10 == 4) {
                    if (b11 == 0 || b11 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        p2.l lVar = this.f9953h0;
                        lVar.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        lVar.a(bundle);
                    }
                }
            }
        }
    }

    @Override // p2.r
    public final boolean V(v1.p pVar) throws g2.n {
        f0 f0Var = this.f14680o1;
        if (f0Var == null || f0Var.u()) {
            return true;
        }
        try {
            return this.f14680o1.t(pVar);
        } catch (e0 e9) {
            throw a(e9, pVar, false, 7000);
        }
    }

    @Override // p2.r
    public final void W(Exception exc) {
        y1.b.h("MediaCodecVideoRenderer", "Video codec error", exc);
        vb.b bVar = this.f14670e1;
        Handler handler = (Handler) bVar.f13551w;
        if (handler != null) {
            handler.post(new b0(bVar, exc, 1));
        }
    }

    @Override // p2.r
    public final void X(long j4, long j7, String str) {
        String str2;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        vb.b bVar = this.f14670e1;
        Handler handler = (Handler) bVar.f13551w;
        if (handler != null) {
            str2 = str;
            handler.post(new b0(bVar, str2, j4, j7));
        } else {
            str2 = str;
        }
        this.f14678m1 = y0(str2);
        p2.o oVar = this.o0;
        oVar.getClass();
        boolean z10 = false;
        if (Build.VERSION.SDK_INT >= 29 && "video/x-vnd.on2.vp9".equals(oVar.f9926b)) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = oVar.f9928d;
            if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
            }
            int length = codecProfileLevelArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (codecProfileLevelArr[i].profile == 16384) {
                    z10 = true;
                    break;
                }
                i++;
            }
        }
        this.f14679n1 = z10;
        G0();
    }

    @Override // p2.r
    public final void Y(String str) {
        vb.b bVar = this.f14670e1;
        Handler handler = (Handler) bVar.f13551w;
        if (handler != null) {
            handler.post(new b0(bVar, str, 2));
        }
    }

    @Override // p2.r
    public final g2.g Z(l4.c0 c0Var) throws g2.n {
        g2.g gVarZ = super.Z(c0Var);
        v1.p pVar = (v1.p) c0Var.f7706x;
        pVar.getClass();
        vb.b bVar = this.f14670e1;
        Handler handler = (Handler) bVar.f13551w;
        if (handler != null) {
            handler.post(new b0(bVar, pVar, gVarZ));
        }
        return gVarZ;
    }

    @Override // p2.r
    public final void a0(v1.p pVar, MediaFormat mediaFormat) {
        int integer;
        int i;
        p2.l lVar = this.f9953h0;
        if (lVar != null) {
            lVar.h(this.f14688w1);
        }
        if (this.K1) {
            i = pVar.f12953u;
            integer = pVar.f12954v;
        } else {
            mediaFormat.getClass();
            boolean z10 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            int integer2 = z10 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            integer = z10 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
            i = integer2;
        }
        float f = pVar.A;
        int i10 = pVar.f12958z;
        if (i10 == 90 || i10 == 270) {
            f = 1.0f / f;
            int i11 = integer;
            integer = i;
            i = i11;
        }
        this.H1 = new r1(f, i, integer);
        f0 f0Var = this.f14680o1;
        if (f0Var == null || !this.Q1) {
            this.f14673h1.g(pVar.f12957y);
        } else {
            v1.o oVarA = pVar.a();
            oVarA.f12900t = i;
            oVarA.f12901u = integer;
            oVarA.f12906z = f;
            v1.p pVar2 = new v1.p(oVarA);
            int i12 = this.f14682q1;
            List list = this.f14683r1;
            if (list == null) {
                g0 g0Var = i0.f12341w;
                list = z0.f12413z;
            }
            f0Var.d(pVar2, this.U0.f9941b, i12, list);
            this.f14682q1 = 2;
        }
        this.Q1 = false;
    }

    @Override // g2.e, g2.k1
    public final void b(int i, Object obj) throws g2.n {
        if (i == 1) {
            J0(obj);
            return;
        }
        if (i == 7) {
            obj.getClass();
            u uVar = (u) obj;
            this.N1 = uVar;
            f0 f0Var = this.f14680o1;
            if (f0Var != null) {
                f0Var.n(uVar);
                return;
            }
            return;
        }
        if (i == 10) {
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            if (this.L1 != iIntValue) {
                this.L1 = iIntValue;
                if (this.K1) {
                    i0();
                    return;
                }
                return;
            }
            return;
        }
        if (i == 4) {
            obj.getClass();
            int iIntValue2 = ((Integer) obj).intValue();
            this.f14688w1 = iIntValue2;
            p2.l lVar = this.f9953h0;
            if (lVar != null) {
                lVar.h(iIntValue2);
                return;
            }
            return;
        }
        if (i == 5) {
            obj.getClass();
            int iIntValue3 = ((Integer) obj).intValue();
            this.f14689x1 = iIntValue3;
            f0 f0Var2 = this.f14680o1;
            if (f0Var2 != null) {
                f0Var2.w(iIntValue3);
                return;
            }
            z zVar = this.f14673h1.f14729b;
            if (zVar.f14758j == iIntValue3) {
                return;
            }
            zVar.f14758j = iIntValue3;
            zVar.d(true);
            return;
        }
        if (i == 13) {
            obj.getClass();
            List list = (List) obj;
            if (list.equals(v1.q1.f12971a)) {
                f0 f0Var3 = this.f14680o1;
                if (f0Var3 == null || !f0Var3.u()) {
                    return;
                }
                this.f14680o1.o();
                return;
            }
            this.f14683r1 = list;
            f0 f0Var4 = this.f14680o1;
            if (f0Var4 != null) {
                f0Var4.g(list);
                return;
            }
            return;
        }
        if (i == 14) {
            obj.getClass();
            y1.u uVar2 = (y1.u) obj;
            if (uVar2.f14613a == 0 || uVar2.f14614b == 0) {
                return;
            }
            this.f14686u1 = uVar2;
            f0 f0Var5 = this.f14680o1;
            if (f0Var5 != null) {
                Surface surface = this.f14684s1;
                y1.d.h(surface);
                f0Var5.p(surface, uVar2);
                return;
            }
            return;
        }
        switch (i) {
            case 16:
                obj.getClass();
                this.J1 = ((Integer) obj).intValue();
                p2.l lVar2 = this.f9953h0;
                if (lVar2 != null && Build.VERSION.SDK_INT >= 35) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("importance", Math.max(0, -this.J1));
                    lVar2.a(bundle);
                }
                break;
            case 17:
                Surface surface2 = this.f14684s1;
                J0(null);
                obj.getClass();
                ((j) obj).b(1, surface2);
                break;
            case 18:
                boolean z10 = this.C1 != null;
                q1 q1Var = (q1) obj;
                this.C1 = q1Var;
                if (z10 != (q1Var != null)) {
                    v0(this.f9954i0);
                }
                break;
            default:
                if (i == 11) {
                    g2.i0 i0Var = (g2.i0) obj;
                    i0Var.getClass();
                    this.f9948c0 = i0Var;
                }
                break;
        }
    }

    @Override // g2.e
    public final void c() {
        f0 f0Var = this.f14680o1;
        if (f0Var == null) {
            v vVar = this.f14673h1;
            if (vVar.f14732e == 0) {
                vVar.f14732e = 1;
                return;
            }
            return;
        }
        int i = this.f14682q1;
        if (i == 0 || i == 1) {
            this.f14682q1 = 0;
        } else {
            f0Var.v();
        }
    }

    @Override // p2.r
    public final void c0(long j4) {
        super.c0(j4);
        if (this.K1) {
            return;
        }
        this.B1--;
    }

    @Override // p2.r
    public final void d0() {
        f0 f0Var = this.f14680o1;
        if (f0Var != null) {
            f0Var.s();
            if (this.O1 == -9223372036854775807L) {
                this.O1 = this.U0.f9941b;
            }
            this.f14680o1.q(-this.O1);
        } else {
            this.f14673h1.f(2);
        }
        this.Q1 = true;
        G0();
    }

    @Override // p2.r
    public final void e0(DecoderInputBuffer decoderInputBuffer) {
        this.R1 = 0;
        int iL = L(decoderInputBuffer);
        if ((Build.VERSION.SDK_INT < 34 || (iL & 32) == 0) && !this.K1) {
            this.B1++;
        }
    }

    @Override // p2.r
    public final boolean g0(long j4, long j7, p2.l lVar, ByteBuffer byteBuffer, int i, int i10, int i11, long j10, boolean z10, boolean z11, v1.p pVar) {
        int i12;
        lVar.getClass();
        long j11 = j10 - this.U0.f9942c;
        int i13 = 0;
        while (true) {
            PriorityQueue priorityQueue = this.f14676k1;
            Long l10 = (Long) priorityQueue.peek();
            if (l10 == null || l10.longValue() >= j10) {
                break;
            }
            i13++;
            priorityQueue.poll();
        }
        N0(i13, 0);
        f0 f0Var = this.f14680o1;
        if (f0Var != null) {
            if (!z10 || z11) {
                return f0Var.r(j10, new g(this, lVar, i, j11));
            }
            M0(lVar, i);
            return true;
        }
        int iA = this.f14673h1.a(j10, j4, j7, this.U0.f9941b, z10, z11, this.f14674i1);
        u3.a aVar = this.f14674i1;
        if (iA == 0) {
            this.B.getClass();
            long jNanoTime = System.nanoTime();
            u uVar = this.N1;
            if (uVar != null) {
                uVar.d(j11, jNanoTime, pVar, this.f9955j0);
            }
            I0(lVar, i, jNanoTime);
            O0(aVar.f12077a);
            return true;
        }
        if (iA == 1) {
            long j12 = aVar.f12078b;
            long j13 = aVar.f12077a;
            if (j12 == this.G1) {
                M0(lVar, i);
            } else {
                u uVar2 = this.N1;
                if (uVar2 != null) {
                    i12 = i;
                    uVar2.d(j11, j12, pVar, this.f9955j0);
                } else {
                    i12 = i;
                }
                I0(lVar, i12, j12);
            }
            O0(j13);
            this.G1 = j12;
            return true;
        }
        if (iA == 2) {
            Trace.beginSection("dropVideoBuffer");
            lVar.f(i);
            Trace.endSection();
            N0(0, 1);
            O0(aVar.f12077a);
            return true;
        }
        if (iA == 3) {
            M0(lVar, i);
            O0(aVar.f12077a);
            return true;
        }
        if (iA == 4 || iA == 5) {
            return false;
        }
        throw new IllegalStateException(String.valueOf(iA));
    }

    @Override // g2.e
    public final String j() {
        return "MediaCodecVideoRenderer";
    }

    @Override // p2.r
    public final void j0() {
        f0 f0Var = this.f14680o1;
        if (f0Var != null) {
            f0Var.s();
        }
    }

    @Override // g2.e
    public final boolean l() {
        if (!this.P0) {
            return false;
        }
        f0 f0Var = this.f14680o1;
        return f0Var == null || f0Var.b();
    }

    @Override // p2.r
    public final void l0() {
        super.l0();
        this.f14676k1.clear();
        this.B1 = 0;
        this.R1 = 0;
        this.D1 = false;
    }

    @Override // p2.r, g2.e
    public final boolean m() {
        boolean zM = super.m();
        f0 f0Var = this.f14680o1;
        if (f0Var != null) {
            return f0Var.l(zM);
        }
        if (zM && (this.f9953h0 == null || this.K1)) {
            return true;
        }
        return this.f14673h1.b(zM);
    }

    @Override // p2.r, g2.e
    public final void o() {
        vb.b bVar = this.f14670e1;
        this.I1 = null;
        this.P1 = -9223372036854775807L;
        G0();
        this.f14687v1 = false;
        this.M1 = null;
        this.D1 = true;
        try {
            super.o();
        } finally {
            bVar.b(this.T0);
            bVar.l(r1.f12978d);
        }
    }

    @Override // g2.e
    public final void p(boolean z10, boolean z11) {
        f0 f0Var;
        this.T0 = new g2.f();
        o1 o1Var = this.f4660y;
        o1Var.getClass();
        boolean z12 = o1Var.f4853b;
        y1.d.g((z12 && this.L1 == 0) ? false : true);
        if (this.K1 != z12) {
            this.K1 = z12;
            i0();
        }
        g2.f fVar = this.T0;
        vb.b bVar = this.f14670e1;
        Handler handler = (Handler) bVar.f13551w;
        if (handler != null) {
            handler.post(new b0(bVar, fVar, 5));
        }
        boolean z13 = this.f14681p1;
        v vVar = this.f14673h1;
        if (!z13) {
            if (this.f14683r1 != null && this.f14680o1 == null) {
                g2.k kVar = new g2.k(this.c1, vVar);
                kVar.f4779v = true;
                y1.v vVar2 = this.B;
                vVar2.getClass();
                kVar.A = vVar2;
                y1.d.g(!kVar.f4780w);
                if (((o) kVar.f4783z) == null) {
                    kVar.f4783z = new o();
                }
                q qVar = new q(kVar);
                kVar.f4780w = true;
                qVar.f14720o = 1;
                SparseArray sparseArray = qVar.f14710c;
                if (y1.a0.k(sparseArray, 0)) {
                    f0Var = (f0) sparseArray.get(0);
                } else {
                    m mVar = new m(qVar, qVar.f14708a);
                    qVar.f14713g.add(mVar);
                    sparseArray.put(0, mVar);
                    f0Var = mVar;
                }
                this.f14680o1 = f0Var;
            }
            this.f14681p1 = true;
        }
        f0 f0Var2 = this.f14680o1;
        if (f0Var2 == null) {
            y1.v vVar3 = this.B;
            vVar3.getClass();
            vVar.f14737l = vVar3;
            vVar.f(!z11 ? 1 : 0);
            return;
        }
        f0Var2.i(new l4.a(this));
        u uVar = this.N1;
        if (uVar != null) {
            this.f14680o1.n(uVar);
        }
        if (this.f14684s1 != null && !this.f14686u1.equals(y1.u.f14612c)) {
            this.f14680o1.p(this.f14684s1, this.f14686u1);
        }
        this.f14680o1.w(this.f14689x1);
        this.f14680o1.e(this.f9951f0);
        List list = this.f14683r1;
        if (list != null) {
            this.f14680o1.g(list);
        }
        this.f14682q1 = !z11 ? 1 : 0;
        this.X0 = true;
    }

    @Override // p2.r
    public final boolean p0(DecoderInputBuffer decoderInputBuffer) {
        boolean z10 = false;
        if (!E0(decoderInputBuffer)) {
            boolean z11 = decoderInputBuffer.timeUs < this.G;
            if (z11 && !decoderInputBuffer.hasSupplementalData()) {
                if (decoderInputBuffer.notDependedOn()) {
                    decoderInputBuffer.clear();
                    z10 = true;
                }
                if (z10) {
                    if (z11) {
                        this.T0.f4671d++;
                    } else {
                        this.f14676k1.add(Long.valueOf(decoderInputBuffer.timeUs));
                        this.R1++;
                    }
                }
                return z10;
            }
        }
        return false;
    }

    @Override // p2.r, g2.e
    public final void q(boolean z10, long j4) throws g2.n {
        f0 f0Var = this.f14680o1;
        if (f0Var != null && !z10) {
            f0Var.f(true);
        }
        super.q(z10, j4);
        f0 f0Var2 = this.f14680o1;
        v vVar = this.f14673h1;
        if (f0Var2 == null) {
            z zVar = vVar.f14729b;
            zVar.f14761m = 0L;
            zVar.f14764p = -1L;
            zVar.f14762n = -1L;
            vVar.f14734h = -9223372036854775807L;
            vVar.f = -9223372036854775807L;
            vVar.f14732e = Math.min(vVar.f14732e, 1);
            vVar.i = -9223372036854775807L;
        }
        if (z10) {
            f0 f0Var3 = this.f14680o1;
            if (f0Var3 != null) {
                f0Var3.k(false);
            } else {
                vVar.c(false);
            }
        }
        G0();
        this.A1 = 0;
    }

    @Override // p2.r
    public final boolean q0() {
        v1.p pVar = this.f9954i0;
        if (this.C1 == null || this.D1 || this.K1) {
            return true;
        }
        return (pVar != null && pVar.f12948p > 0) || this.Y0 || this.N0 != -9223372036854775807L;
    }

    @Override // g2.e
    public final void r() {
        f0 f0Var = this.f14680o1;
        if (f0Var == null || !this.f14669d1) {
            return;
        }
        f0Var.release();
    }

    @Override // p2.r
    public final boolean r0(p2.o oVar) {
        return D0(oVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g2.e
    public final void s() {
        try {
            try {
                this.C0 = false;
                k0();
                i0();
            } finally {
                l0.e.t(this.f9947b0, null);
                this.f9947b0 = null;
            }
        } finally {
            this.f14681p1 = false;
            this.O1 = -9223372036854775807L;
            l lVar = this.f14685t1;
            if (lVar != null) {
                lVar.release();
                this.f14685t1 = null;
            }
        }
    }

    @Override // p2.r
    public final boolean s0() {
        p2.o oVar = this.o0;
        if (this.f14680o1 != null && oVar != null) {
            String str = oVar.f9925a;
            if (str.equals("c2.mtk.avc.decoder") || str.equals("c2.mtk.hevc.decoder")) {
                return true;
            }
        }
        return super.s0();
    }

    @Override // g2.e
    public final void t() {
        this.f14691z1 = 0;
        this.B.getClass();
        this.f14690y1 = SystemClock.elapsedRealtime();
        this.E1 = 0L;
        this.F1 = 0;
        f0 f0Var = this.f14680o1;
        if (f0Var != null) {
            f0Var.m();
        } else {
            this.f14673h1.d();
        }
    }

    @Override // g2.e
    public final void u() {
        F0();
        int i = this.F1;
        if (i != 0) {
            long j4 = this.E1;
            vb.b bVar = this.f14670e1;
            Handler handler = (Handler) bVar.f13551w;
            if (handler != null) {
                handler.post(new b0(bVar, j4, i));
            }
            this.E1 = 0L;
            this.F1 = 0;
        }
        f0 f0Var = this.f14680o1;
        if (f0Var != null) {
            f0Var.h();
        } else {
            this.f14673h1.e();
        }
    }

    @Override // p2.r
    public final int u0(p2.j jVar, v1.p pVar) {
        boolean z10;
        int i = 0;
        if (!m0.o(pVar.f12946n)) {
            return q4.a.d(0, 0, 0, 0);
        }
        boolean z11 = pVar.f12950r != null;
        Context context = this.c1;
        List listA0 = A0(context, jVar, pVar, z11, false);
        if (z11 && listA0.isEmpty()) {
            listA0 = A0(context, jVar, pVar, false, false);
        }
        if (listA0.isEmpty()) {
            return q4.a.d(1, 0, 0, 0);
        }
        int i10 = pVar.O;
        if (i10 != 0 && i10 != 2) {
            return q4.a.d(2, 0, 0, 0);
        }
        p2.o oVar = (p2.o) listA0.get(0);
        boolean zE = oVar.e(pVar);
        if (zE) {
            z10 = true;
        } else {
            for (int i11 = 1; i11 < listA0.size(); i11++) {
                p2.o oVar2 = (p2.o) listA0.get(i11);
                if (oVar2.e(pVar)) {
                    z10 = false;
                    zE = true;
                    oVar = oVar2;
                    break;
                }
            }
            z10 = true;
        }
        int i12 = zE ? 4 : 3;
        int i13 = oVar.f(pVar) ? 16 : 8;
        int i14 = oVar.f9930g ? 64 : 0;
        int i15 = z10 ? 128 : 0;
        if (Build.VERSION.SDK_INT >= 26 && "video/dolby-vision".equals(pVar.f12946n) && !sd.i.o(context)) {
            i15 = 256;
        }
        if (zE) {
            List listA02 = A0(context, jVar, pVar, z11, true);
            if (!listA02.isEmpty()) {
                HashMap map = p2.x.f9976a;
                ArrayList arrayList = new ArrayList(listA02);
                Collections.sort(arrayList, new p2.s(i, new kb.d(7, pVar)));
                p2.o oVar3 = (p2.o) arrayList.get(0);
                if (oVar3.e(pVar) && oVar3.f(pVar)) {
                    i = 32;
                }
            }
        }
        return i12 | i13 | i | i14 | i15;
    }

    @Override // p2.r, g2.e
    public final void v(v1.p[] pVarArr, long j4, long j7, s2.c0 c0Var) {
        super.v(pVarArr, j4, j7, c0Var);
        f1 f1Var = this.K;
        if (f1Var.p()) {
            this.P1 = -9223372036854775807L;
        } else {
            c0Var.getClass();
            this.P1 = f1Var.g(c0Var.f11156a, new c1()).f12619d;
        }
    }

    @Override // p2.r, g2.e
    public final void x(long j4, long j7) throws g2.n {
        f0 f0Var = this.f14680o1;
        if (f0Var != null) {
            try {
                f0Var.j(j4, j7);
            } catch (e0 e9) {
                throw a(e9, e9.f14656v, false, 7001);
            }
        }
        super.x(j4, j7);
    }

    @Override // p2.r, g2.e
    public final void z(float f, float f10) throws g2.n {
        super.z(f, f10);
        f0 f0Var = this.f14680o1;
        if (f0Var != null) {
            f0Var.e(f);
        } else {
            this.f14673h1.i(f);
        }
    }
}
