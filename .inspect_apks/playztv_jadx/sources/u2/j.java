package u2;

import a2.a2;
import a2.c2;
import a2.r0;
import aa.c1;
import aa.h0;
import aa.j0;
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
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import n.a1;
import p1.f1;
import p1.m0;
import p1.q1;
import p1.r1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends j2.s {
    public static final int[] R1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    public static boolean S1;
    public static boolean T1;
    public int A1;
    public c2 B1;
    public boolean C1;
    public long D1;
    public int E1;
    public long F1;
    public r1 G1;
    public r1 H1;
    public int I1;
    public boolean J1;
    public int K1;
    public i L1;
    public u M1;
    public long N1;
    public long O1;
    public boolean P1;
    public int Q1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final Context f12590b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public final boolean f12591c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public final pb.c f12592d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public final int f12593e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public final boolean f12594f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public final v f12595g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public final q3.a f12596h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public final long f12597i1;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public final PriorityQueue f12598j1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public b8.d f12599k1;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public boolean f12600l1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public boolean f12601m1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public f0 f12602n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public boolean f12603o1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public int f12604p1;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public List f12605q1;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public Surface f12606r1;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public l f12607s1;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public s1.v f12608t1;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public boolean f12609u1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public int f12610v1;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public int f12611w1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public long f12612x1;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public int f12613y1;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public int f12614z1;

    public j(h hVar) {
        super(2, hVar.f12583c, hVar.f12585e, 30.0f);
        Context applicationContext = hVar.f12581a.getApplicationContext();
        this.f12590b1 = applicationContext;
        this.f12593e1 = hVar.f12587h;
        this.f12602n1 = null;
        this.f12592d1 = new pb.c(hVar.f, hVar.f12586g);
        this.f12591c1 = this.f12602n1 == null;
        this.f12595g1 = new v(applicationContext, this, hVar.f12584d);
        this.f12596h1 = new q3.a();
        this.f12594f1 = "NVIDIA".equals(Build.MANUFACTURER);
        this.f12608t1 = s1.v.f11712c;
        this.f12610v1 = 1;
        this.f12611w1 = 0;
        this.G1 = r1.f10046d;
        this.K1 = 0;
        this.H1 = null;
        this.I1 = -1000;
        this.N1 = -9223372036854775807L;
        this.O1 = -9223372036854775807L;
        this.f12598j1 = new PriorityQueue();
        this.f12597i1 = -9223372036854775807L;
        this.B1 = null;
    }

    public static List A0(Context context, j2.k kVar, p1.q qVar, boolean z2, boolean z10) {
        String str = qVar.f10023n;
        if (str == null) {
            return c1.f650y;
        }
        if (Build.VERSION.SDK_INT >= 26 && "video/dolby-vision".equals(str) && !i5.a.n(context)) {
            String strB = j2.y.b(qVar);
            List listA = strB == null ? c1.f650y : kVar.a(strB, z2, z10);
            if (!listA.isEmpty()) {
                return listA;
            }
        }
        return j2.y.f(kVar, qVar, z2, z10);
    }

    public static int B0(j2.p pVar, p1.q qVar) {
        int i = qVar.f10024o;
        List list = qVar.f10026q;
        if (i == -1) {
            return z0(pVar, qVar);
        }
        int size = list.size();
        int length = 0;
        for (int i10 = 0; i10 < size; i10++) {
            length += ((byte[]) list.get(i10)).length;
        }
        return qVar.f10024o + length;
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
        throw new UnsupportedOperationException("Method not decompiled: u2.j.y0(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int z0(j2.p r11, p1.q r12) {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.j.z0(j2.p, p1.q):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.Surface C0(j2.p r6) {
        /*
            r5 = this;
            u2.f0 r0 = r5.f12602n1
            if (r0 == 0) goto L9
            android.view.Surface r6 = r0.c()
            return r6
        L9:
            android.view.Surface r0 = r5.f12606r1
            if (r0 == 0) goto Le
            return r0
        Le:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 35
            r2 = 0
            if (r0 < r1) goto L1a
            boolean r0 = r6.f6716h
            if (r0 == 0) goto L1a
            return r2
        L1a:
            boolean r0 = r5.L0(r6)
            s1.d.g(r0)
            u2.l r0 = r5.f12607s1
            if (r0 == 0) goto L32
            boolean r1 = r0.f12622u
            boolean r3 = r6.f
            if (r1 == r3) goto L32
            if (r0 == 0) goto L32
            r0.release()
            r5.f12607s1 = r2
        L32:
            u2.l r0 = r5.f12607s1
            if (r0 != 0) goto Lab
            android.content.Context r0 = r5.f12590b1
            boolean r6 = r6.f
            r1 = 1
            r2 = 0
            if (r6 == 0) goto L47
            boolean r0 = u2.l.b(r0)
            if (r0 == 0) goto L45
            goto L49
        L45:
            r0 = r2
            goto L4a
        L47:
            int r0 = u2.l.f12620x
        L49:
            r0 = r1
        L4a:
            s1.d.g(r0)
            u2.k r0 = new u2.k
            java.lang.String r3 = "ExoPlayer:PlaceholderSurface"
            r0.<init>(r3)
            if (r6 == 0) goto L59
            int r6 = u2.l.f12620x
            goto L5a
        L59:
            r6 = r2
        L5a:
            r0.start()
            android.os.Handler r3 = new android.os.Handler
            android.os.Looper r4 = r0.getLooper()
            r3.<init>(r4, r0)
            r0.f12616v = r3
            s1.j r4 = new s1.j
            r4.<init>(r3)
            r0.f12615u = r4
            monitor-enter(r0)
            android.os.Handler r3 = r0.f12616v     // Catch: java.lang.Throwable -> L89
            android.os.Message r6 = r3.obtainMessage(r1, r6, r2)     // Catch: java.lang.Throwable -> L89
            r6.sendToTarget()     // Catch: java.lang.Throwable -> L89
        L79:
            u2.l r6 = r0.f12619y     // Catch: java.lang.Throwable -> L89
            if (r6 != 0) goto L8d
            java.lang.RuntimeException r6 = r0.f12618x     // Catch: java.lang.Throwable -> L89
            if (r6 != 0) goto L8d
            java.lang.Error r6 = r0.f12617w     // Catch: java.lang.Throwable -> L89
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
            java.lang.RuntimeException r6 = r0.f12618x
            if (r6 != 0) goto La8
            java.lang.Error r6 = r0.f12617w
            if (r6 != 0) goto La7
            u2.l r6 = r0.f12619y
            r6.getClass()
            r5.f12607s1 = r6
            goto Lab
        La7:
            throw r6
        La8:
            throw r6
        La9:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L89
            throw r6
        Lab:
            u2.l r6 = r5.f12607s1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.j.C0(j2.p):android.view.Surface");
    }

    @Override // j2.s
    public final a2.i D(j2.p pVar, p1.q qVar, p1.q qVar2) {
        a2.i iVarB = pVar.b(qVar, qVar2);
        int i = iVarB.f276e;
        b8.d dVar = this.f12599k1;
        dVar.getClass();
        if (qVar2.f10030u > dVar.f1922a || qVar2.f10031v > dVar.f1923b) {
            i |= 256;
        }
        if (B0(pVar, qVar2) > dVar.f1924c) {
            i |= 64;
        }
        int i10 = i;
        return new a2.i(pVar.f6710a, qVar, qVar2, i10 != 0 ? 0 : iVarB.f275d, i10);
    }

    public final boolean D0(j2.p pVar) {
        if (this.f12602n1 != null) {
            return true;
        }
        Surface surface = this.f12606r1;
        if (surface == null || !surface.isValid()) {
            return (Build.VERSION.SDK_INT >= 35 && pVar.f6716h) || L0(pVar);
        }
        return true;
    }

    @Override // j2.s
    public final j2.o E(IllegalStateException illegalStateException, j2.p pVar) {
        Surface surface = this.f12606r1;
        f fVar = new f(illegalStateException, pVar);
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
        long j5 = this.O1;
        return j5 == -9223372036854775807L || j5 - (decoderInputBuffer.timeUs - this.T0.f6727c) <= 100000;
    }

    public final void F0() {
        if (this.f12613y1 > 0) {
            this.A.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j5 = jElapsedRealtime - this.f12612x1;
            int i = this.f12613y1;
            pb.c cVar = this.f12592d1;
            Handler handler = (Handler) cVar.f10310v;
            if (handler != null) {
                handler.post(new b0(cVar, i, j5));
            }
            this.f12613y1 = 0;
            this.f12612x1 = jElapsedRealtime;
        }
    }

    public final void G0() {
        if (this.J1) {
            int i = Build.VERSION.SDK_INT;
            j2.m mVar = this.f6735g0;
            if (mVar == null) {
                return;
            }
            this.L1 = new i(this, mVar);
            if (i >= 33) {
                Bundle bundle = new Bundle();
                bundle.putInt("tunnel-peek", 1);
                mVar.b(bundle);
            }
        }
    }

    public final void H0(long j5) {
        Surface surface;
        x0(j5);
        r1 r1Var = this.G1;
        boolean zEquals = r1Var.equals(r1.f10046d);
        pb.c cVar = this.f12592d1;
        if (!zEquals && !r1Var.equals(this.H1)) {
            this.H1 = r1Var;
            cVar.p(r1Var);
        }
        this.S0.f248e++;
        v vVar = this.f12595g1;
        boolean z2 = vVar.f12656e != 3;
        vVar.f12656e = 3;
        vVar.f12661l.getClass();
        vVar.f12657g = s1.b0.O(SystemClock.elapsedRealtime());
        if (z2 && (surface = this.f12606r1) != null) {
            cVar.n(surface);
            this.f12609u1 = true;
        }
        c0(j5);
    }

    public final void I0(j2.m mVar, int i, long j5) {
        Surface surface;
        Trace.beginSection("releaseOutputBuffer");
        mVar.z(i, j5);
        Trace.endSection();
        this.S0.f248e++;
        this.f12614z1 = 0;
        if (this.f12602n1 == null) {
            r1 r1Var = this.G1;
            boolean zEquals = r1Var.equals(r1.f10046d);
            pb.c cVar = this.f12592d1;
            if (!zEquals && !r1Var.equals(this.H1)) {
                this.H1 = r1Var;
                cVar.p(r1Var);
            }
            v vVar = this.f12595g1;
            boolean z2 = vVar.f12656e != 3;
            vVar.f12656e = 3;
            vVar.f12661l.getClass();
            vVar.f12657g = s1.b0.O(SystemClock.elapsedRealtime());
            if (!z2 || (surface = this.f12606r1) == null) {
                return;
            }
            cVar.n(surface);
            this.f12609u1 = true;
        }
    }

    public final void J0(Object obj) throws a2.q {
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        Surface surface2 = this.f12606r1;
        pb.c cVar = this.f12592d1;
        if (surface2 == surface) {
            if (surface != null) {
                r1 r1Var = this.H1;
                if (r1Var != null) {
                    cVar.p(r1Var);
                }
                Surface surface3 = this.f12606r1;
                if (surface3 == null || !this.f12609u1) {
                    return;
                }
                cVar.n(surface3);
                return;
            }
            return;
        }
        this.f12606r1 = surface;
        f0 f0Var = this.f12602n1;
        v vVar = this.f12595g1;
        if (f0Var == null) {
            vVar.h(surface);
        }
        this.f12609u1 = false;
        int i = this.B;
        j2.m mVar = this.f6735g0;
        if (mVar != null && this.f12602n1 == null) {
            j2.p pVar = this.f6741n0;
            pVar.getClass();
            boolean zD0 = D0(pVar);
            int i10 = Build.VERSION.SDK_INT;
            if (!zD0 || this.f12600l1) {
                i0();
                T();
            } else {
                Surface surfaceC0 = C0(pVar);
                if (surfaceC0 != null) {
                    mVar.u(surfaceC0);
                } else {
                    if (i10 < 35) {
                        throw new IllegalStateException();
                    }
                    mVar.s();
                }
            }
        }
        if (surface != null) {
            r1 r1Var2 = this.H1;
            if (r1Var2 != null) {
                cVar.p(r1Var2);
            }
        } else {
            this.H1 = null;
            f0 f0Var2 = this.f12602n1;
            if (f0Var2 != null) {
                f0Var2.a();
            }
        }
        if (i == 2) {
            f0 f0Var3 = this.f12602n1;
            if (f0Var3 != null) {
                f0Var3.l(true);
            } else {
                vVar.c(true);
            }
        }
        G0();
    }

    public final boolean K0(long j5, long j8, boolean z2, boolean z10) throws a2.q {
        if (this.f12602n1 != null && this.f12591c1) {
            j8 -= -this.N1;
        }
        if (j5 < -500000 && !z2) {
            o2.c1 c1Var = this.C;
            c1Var.getClass();
            int iQ = c1Var.q(j8 - this.E);
            if (iQ != 0) {
                PriorityQueue priorityQueue = this.f12598j1;
                if (z10) {
                    a2.h hVar = this.S0;
                    int i = hVar.f247d + iQ;
                    hVar.f247d = i;
                    hVar.f += this.A1;
                    hVar.f247d = priorityQueue.size() + i;
                } else {
                    this.S0.f251j++;
                    N0(priorityQueue.size() + iQ, this.A1);
                }
                if (J()) {
                    T();
                }
                f0 f0Var = this.f12602n1;
                if (f0Var != null) {
                    f0Var.e(false);
                }
                return true;
            }
        }
        return false;
    }

    @Override // j2.s
    public final int L(DecoderInputBuffer decoderInputBuffer) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ((this.B1 == null && !this.J1) || decoderInputBuffer.timeUs >= this.F || E0(decoderInputBuffer)) ? 0 : 32;
        }
        return 0;
    }

    public final boolean L0(j2.p pVar) {
        if (this.J1 || y0(pVar.f6710a)) {
            return false;
        }
        return !pVar.f || l.b(this.f12590b1);
    }

    @Override // j2.s
    public final float M(float f, p1.q qVar, p1.q[] qVarArr) {
        j2.p pVar;
        float fMax = -1.0f;
        for (p1.q qVar2 : qVarArr) {
            float f4 = qVar2.f10034y;
            if (f4 != -1.0f) {
                fMax = Math.max(fMax, f4);
            }
        }
        float f10 = fMax == -1.0f ? -1.0f : fMax * f;
        if (this.B1 == null || (pVar = this.f6741n0) == null) {
            return f10;
        }
        int i = qVar.f10030u;
        int i10 = qVar.f10031v;
        float f11 = -3.4028235E38f;
        if (pVar.i) {
            float f12 = pVar.f6719l;
            if (f12 != -3.4028235E38f && pVar.f6717j == i && pVar.f6718k == i10) {
                f11 = f12;
            } else {
                float f13 = 1024.0f;
                if (!pVar.g(i, i10, 1024.0f)) {
                    f11 = 0.0f;
                    while (true) {
                        float f14 = f13 - f11;
                        if (Math.abs(f14) <= 5.0f) {
                            break;
                        }
                        float f15 = (f14 / 2.0f) + f11;
                        if (pVar.g(i, i10, f15)) {
                            f11 = f15;
                        } else {
                            f13 = f15;
                        }
                    }
                } else {
                    f11 = 1024.0f;
                }
                pVar.f6719l = f11;
                pVar.f6717j = i;
                pVar.f6718k = i10;
            }
        }
        return f10 != -1.0f ? Math.max(f10, f11) : f11;
    }

    public final void M0(j2.m mVar, int i) {
        Trace.beginSection("skipVideoBuffer");
        mVar.i(i);
        Trace.endSection();
        this.S0.f++;
    }

    @Override // j2.s
    public final ArrayList N(j2.k kVar, p1.q qVar, boolean z2) {
        List listA0 = A0(this.f12590b1, kVar, qVar, z2, this.J1);
        HashMap map = j2.y.f6759a;
        ArrayList arrayList = new ArrayList(listA0);
        Collections.sort(arrayList, new j2.t(0, new a2.f0(27, qVar)));
        return arrayList;
    }

    public final void N0(int i, int i10) {
        a2.h hVar = this.S0;
        hVar.f250h += i;
        int i11 = i + i10;
        hVar.f249g += i11;
        this.f12613y1 += i11;
        int i12 = this.f12614z1 + i11;
        this.f12614z1 = i12;
        hVar.i = Math.max(i12, hVar.i);
        int i13 = this.f12593e1;
        if (i13 <= 0 || this.f12613y1 < i13) {
            return;
        }
        F0();
    }

    public final void O0(long j5) {
        a2.h hVar = this.S0;
        hVar.f252k += j5;
        hVar.f253l++;
        this.D1 += j5;
        this.E1++;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0135, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0138, code lost:
    
        r15 = r9;
     */
    @Override // j2.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b2.g P(j2.p r25, p1.q r26, android.media.MediaCrypto r27, float r28) {
        /*
            Method dump skipped, instruction units count: 627
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.j.P(j2.p, p1.q, android.media.MediaCrypto, float):b2.g");
    }

    @Override // j2.s
    public final void Q(DecoderInputBuffer decoderInputBuffer) {
        if (this.f12601m1) {
            ByteBuffer byteBuffer = decoderInputBuffer.supplementalData;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b10 = byteBuffer.get();
                short s3 = byteBuffer.getShort();
                short s10 = byteBuffer.getShort();
                byte b11 = byteBuffer.get();
                byte b12 = byteBuffer.get();
                byteBuffer.position(0);
                if (b10 == -75 && s3 == 60 && s10 == 1 && b11 == 4) {
                    if (b12 == 0 || b12 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        j2.m mVar = this.f6735g0;
                        mVar.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        mVar.b(bundle);
                    }
                }
            }
        }
    }

    @Override // j2.s
    public final boolean V(p1.q qVar) throws a2.q {
        f0 f0Var = this.f12602n1;
        if (f0Var == null || f0Var.t()) {
            return true;
        }
        try {
            return this.f12602n1.v(qVar);
        } catch (e0 e10) {
            throw a(e10, qVar, false, 7000);
        }
    }

    @Override // j2.s
    public final void W(Exception exc) {
        s1.b.h("MediaCodecVideoRenderer", "Video codec error", exc);
        pb.c cVar = this.f12592d1;
        Handler handler = (Handler) cVar.f10310v;
        if (handler != null) {
            handler.post(new b0(1, exc, cVar));
        }
    }

    @Override // j2.s
    public final void X(long j5, long j8, String str) {
        String str2;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        pb.c cVar = this.f12592d1;
        Handler handler = (Handler) cVar.f10310v;
        if (handler != null) {
            str2 = str;
            handler.post(new b0(cVar, str2, j5, j8));
        } else {
            str2 = str;
        }
        this.f12600l1 = y0(str2);
        j2.p pVar = this.f6741n0;
        pVar.getClass();
        boolean z2 = false;
        if (Build.VERSION.SDK_INT >= 29 && "video/x-vnd.on2.vp9".equals(pVar.f6711b)) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = pVar.f6713d;
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
                    z2 = true;
                    break;
                }
                i++;
            }
        }
        this.f12601m1 = z2;
        G0();
    }

    @Override // j2.s
    public final void Y(String str) {
        pb.c cVar = this.f12592d1;
        Handler handler = (Handler) cVar.f10310v;
        if (handler != null) {
            handler.post(new b0(2, str, cVar));
        }
    }

    @Override // j2.s
    public final a2.i Z(h4.z zVar) throws a2.q {
        a2.i iVarZ = super.Z(zVar);
        p1.q qVar = (p1.q) zVar.f5868w;
        qVar.getClass();
        pb.c cVar = this.f12592d1;
        Handler handler = (Handler) cVar.f10310v;
        if (handler != null) {
            handler.post(new b0(cVar, qVar, iVarZ));
        }
        return iVarZ;
    }

    @Override // j2.s
    public final void a0(p1.q qVar, MediaFormat mediaFormat) {
        int integer;
        int i;
        j2.m mVar = this.f6735g0;
        if (mVar != null) {
            mVar.m(this.f12610v1);
        }
        if (this.J1) {
            i = qVar.f10030u;
            integer = qVar.f10031v;
        } else {
            mediaFormat.getClass();
            boolean z2 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            int integer2 = z2 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            integer = z2 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
            i = integer2;
        }
        float f = qVar.A;
        int i10 = qVar.f10035z;
        if (i10 == 90 || i10 == 270) {
            f = 1.0f / f;
            int i11 = integer;
            integer = i;
            i = i11;
        }
        this.G1 = new r1(f, i, integer);
        f0 f0Var = this.f12602n1;
        if (f0Var == null || !this.P1) {
            this.f12595g1.g(qVar.f10034y);
        } else {
            p1.p pVarA = qVar.a();
            pVarA.f9974t = i;
            pVarA.f9975u = integer;
            pVarA.f9980z = f;
            p1.q qVar2 = new p1.q(pVarA);
            int i12 = this.f12604p1;
            List list = this.f12605q1;
            if (list == null) {
                h0 h0Var = j0.f690v;
                list = c1.f650y;
            }
            f0Var.q(qVar2, this.T0.f6726b, i12, list);
            this.f12604p1 = 2;
        }
        this.P1 = false;
    }

    @Override // a2.g, a2.w1
    public final void b(int i, Object obj) throws a2.q {
        if (i == 1) {
            J0(obj);
            return;
        }
        if (i == 7) {
            obj.getClass();
            u uVar = (u) obj;
            this.M1 = uVar;
            f0 f0Var = this.f12602n1;
            if (f0Var != null) {
                f0Var.h(uVar);
                return;
            }
            return;
        }
        if (i == 10) {
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            if (this.K1 != iIntValue) {
                this.K1 = iIntValue;
                if (this.J1) {
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
            this.f12610v1 = iIntValue2;
            j2.m mVar = this.f6735g0;
            if (mVar != null) {
                mVar.m(iIntValue2);
                return;
            }
            return;
        }
        if (i == 5) {
            obj.getClass();
            int iIntValue3 = ((Integer) obj).intValue();
            this.f12611w1 = iIntValue3;
            f0 f0Var2 = this.f12602n1;
            if (f0Var2 != null) {
                f0Var2.w(iIntValue3);
                return;
            }
            z zVar = this.f12595g1.f12653b;
            if (zVar.f12682j == iIntValue3) {
                return;
            }
            zVar.f12682j = iIntValue3;
            zVar.d(true);
            return;
        }
        if (i == 13) {
            obj.getClass();
            List list = (List) obj;
            if (list.equals(q1.f10041a)) {
                f0 f0Var3 = this.f12602n1;
                if (f0Var3 == null || !f0Var3.t()) {
                    return;
                }
                this.f12602n1.o();
                return;
            }
            this.f12605q1 = list;
            f0 f0Var4 = this.f12602n1;
            if (f0Var4 != null) {
                f0Var4.f(list);
                return;
            }
            return;
        }
        if (i == 14) {
            obj.getClass();
            s1.v vVar = (s1.v) obj;
            if (vVar.f11713a == 0 || vVar.f11714b == 0) {
                return;
            }
            this.f12608t1 = vVar;
            f0 f0Var5 = this.f12602n1;
            if (f0Var5 != null) {
                Surface surface = this.f12606r1;
                s1.d.h(surface);
                f0Var5.k(surface, vVar);
                return;
            }
            return;
        }
        switch (i) {
            case 16:
                obj.getClass();
                this.I1 = ((Integer) obj).intValue();
                j2.m mVar2 = this.f6735g0;
                if (mVar2 != null && Build.VERSION.SDK_INT >= 35) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("importance", Math.max(0, -this.I1));
                    mVar2.b(bundle);
                }
                break;
            case 17:
                Surface surface2 = this.f12606r1;
                J0(null);
                obj.getClass();
                ((j) obj).b(1, surface2);
                break;
            case 18:
                boolean z2 = this.B1 != null;
                c2 c2Var = (c2) obj;
                this.B1 = c2Var;
                if (z2 != (c2Var != null)) {
                    v0(this.f6736h0);
                }
                break;
            default:
                if (i == 11) {
                    r0 r0Var = (r0) obj;
                    r0Var.getClass();
                    this.f6730b0 = r0Var;
                }
                break;
        }
    }

    @Override // a2.g
    public final void c() {
        f0 f0Var = this.f12602n1;
        if (f0Var == null) {
            v vVar = this.f12595g1;
            if (vVar.f12656e == 0) {
                vVar.f12656e = 1;
                return;
            }
            return;
        }
        int i = this.f12604p1;
        if (i == 0 || i == 1) {
            this.f12604p1 = 0;
        } else {
            f0Var.u();
        }
    }

    @Override // j2.s
    public final void c0(long j5) {
        super.c0(j5);
        if (this.J1) {
            return;
        }
        this.A1--;
    }

    @Override // j2.s
    public final void d0() {
        f0 f0Var = this.f12602n1;
        if (f0Var != null) {
            f0Var.s();
            if (this.N1 == -9223372036854775807L) {
                this.N1 = this.T0.f6726b;
            }
            this.f12602n1.r(-this.N1);
        } else {
            this.f12595g1.f(2);
        }
        this.P1 = true;
        G0();
    }

    @Override // j2.s
    public final void e0(DecoderInputBuffer decoderInputBuffer) {
        this.Q1 = 0;
        int iL = L(decoderInputBuffer);
        if ((Build.VERSION.SDK_INT < 34 || (iL & 32) == 0) && !this.J1) {
            this.A1++;
        }
    }

    @Override // a2.g
    public final String g() {
        return "MediaCodecVideoRenderer";
    }

    @Override // j2.s
    public final boolean g0(long j5, long j8, j2.m mVar, ByteBuffer byteBuffer, int i, int i10, int i11, long j10, boolean z2, boolean z10, p1.q qVar) {
        int i12;
        mVar.getClass();
        long j11 = j10 - this.T0.f6727c;
        int i13 = 0;
        while (true) {
            PriorityQueue priorityQueue = this.f12598j1;
            Long l10 = (Long) priorityQueue.peek();
            if (l10 == null || l10.longValue() >= j10) {
                break;
            }
            i13++;
            priorityQueue.poll();
        }
        N0(i13, 0);
        f0 f0Var = this.f12602n1;
        if (f0Var != null) {
            if (!z2 || z10) {
                return f0Var.d(j10, new g(this, mVar, i, j11));
            }
            M0(mVar, i);
            return true;
        }
        int iA = this.f12595g1.a(j10, j5, j8, this.T0.f6726b, z2, z10, this.f12596h1);
        q3.a aVar = this.f12596h1;
        if (iA == 0) {
            this.A.getClass();
            long jNanoTime = System.nanoTime();
            u uVar = this.M1;
            if (uVar != null) {
                uVar.c(j11, jNanoTime, qVar, this.f6737i0);
            }
            I0(mVar, i, jNanoTime);
            O0(aVar.f10598a);
            return true;
        }
        if (iA == 1) {
            long j12 = aVar.f10599b;
            long j13 = aVar.f10598a;
            if (j12 == this.F1) {
                M0(mVar, i);
            } else {
                u uVar2 = this.M1;
                if (uVar2 != null) {
                    i12 = i;
                    uVar2.c(j11, j12, qVar, this.f6737i0);
                } else {
                    i12 = i;
                }
                I0(mVar, i12, j12);
            }
            O0(j13);
            this.F1 = j12;
            return true;
        }
        if (iA == 2) {
            Trace.beginSection("dropVideoBuffer");
            mVar.i(i);
            Trace.endSection();
            N0(0, 1);
            O0(aVar.f10598a);
            return true;
        }
        if (iA == 3) {
            M0(mVar, i);
            O0(aVar.f10598a);
            return true;
        }
        if (iA == 4 || iA == 5) {
            return false;
        }
        throw new IllegalStateException(String.valueOf(iA));
    }

    @Override // j2.s
    public final void j0() {
        f0 f0Var = this.f12602n1;
        if (f0Var != null) {
            f0Var.s();
        }
    }

    @Override // a2.g
    public final boolean l() {
        if (!this.O0) {
            return false;
        }
        f0 f0Var = this.f12602n1;
        return f0Var == null || f0Var.b();
    }

    @Override // j2.s
    public final void l0() {
        super.l0();
        this.f12598j1.clear();
        this.A1 = 0;
        this.Q1 = 0;
        this.C1 = false;
    }

    @Override // j2.s, a2.g
    public final boolean m() {
        boolean zM = super.m();
        f0 f0Var = this.f12602n1;
        if (f0Var != null) {
            return f0Var.m(zM);
        }
        if (zM && (this.f6735g0 == null || this.J1)) {
            return true;
        }
        return this.f12595g1.b(zM);
    }

    @Override // j2.s, a2.g
    public final void o() {
        pb.c cVar = this.f12592d1;
        this.H1 = null;
        this.O1 = -9223372036854775807L;
        G0();
        this.f12609u1 = false;
        this.L1 = null;
        this.C1 = true;
        try {
            super.o();
        } finally {
            cVar.b(this.S0);
            cVar.p(r1.f10046d);
        }
    }

    @Override // a2.g
    public final void p(boolean z2, boolean z10) {
        f0 f0Var;
        this.S0 = new a2.h();
        a2 a2Var = this.f234x;
        a2Var.getClass();
        boolean z11 = a2Var.f157b;
        s1.d.g((z11 && this.K1 == 0) ? false : true);
        if (this.J1 != z11) {
            this.J1 = z11;
            i0();
        }
        a2.h hVar = this.S0;
        pb.c cVar = this.f12592d1;
        Handler handler = (Handler) cVar.f10310v;
        if (handler != null) {
            handler.post(new b0(5, hVar, cVar));
        }
        boolean z12 = this.f12603o1;
        v vVar = this.f12595g1;
        if (!z12) {
            if (this.f12605q1 != null && this.f12602n1 == null) {
                a2.m mVar = new a2.m(this.f12590b1, vVar);
                mVar.f316u = true;
                s1.w wVar = this.A;
                wVar.getClass();
                mVar.f321z = wVar;
                s1.d.g(!mVar.f317v);
                if (((o) mVar.f320y) == null) {
                    mVar.f320y = new o();
                }
                q qVar = new q(mVar);
                mVar.f317v = true;
                qVar.f12643o = 1;
                SparseArray sparseArray = qVar.f12633c;
                if (s1.b0.k(sparseArray, 0)) {
                    f0Var = (f0) sparseArray.get(0);
                } else {
                    m mVar2 = new m(qVar, qVar.f12631a);
                    qVar.f12636g.add(mVar2);
                    sparseArray.put(0, mVar2);
                    f0Var = mVar2;
                }
                this.f12602n1 = f0Var;
            }
            this.f12603o1 = true;
        }
        f0 f0Var2 = this.f12602n1;
        if (f0Var2 == null) {
            s1.w wVar2 = this.A;
            wVar2.getClass();
            vVar.f12661l = wVar2;
            vVar.f(!z10 ? 1 : 0);
            return;
        }
        f0Var2.p(new a1(this));
        u uVar = this.M1;
        if (uVar != null) {
            this.f12602n1.h(uVar);
        }
        if (this.f12606r1 != null && !this.f12608t1.equals(s1.v.f11712c)) {
            this.f12602n1.k(this.f12606r1, this.f12608t1);
        }
        this.f12602n1.w(this.f12611w1);
        this.f12602n1.i(this.f6733e0);
        List list = this.f12605q1;
        if (list != null) {
            this.f12602n1.f(list);
        }
        this.f12604p1 = !z10 ? 1 : 0;
        this.W0 = true;
    }

    @Override // j2.s
    public final boolean p0(DecoderInputBuffer decoderInputBuffer) {
        boolean z2 = false;
        if (!E0(decoderInputBuffer)) {
            boolean z10 = decoderInputBuffer.timeUs < this.F;
            if (z10 && !decoderInputBuffer.hasSupplementalData()) {
                if (decoderInputBuffer.notDependedOn()) {
                    decoderInputBuffer.clear();
                    z2 = true;
                }
                if (z2) {
                    if (z10) {
                        this.S0.f247d++;
                    } else {
                        this.f12598j1.add(Long.valueOf(decoderInputBuffer.timeUs));
                        this.Q1++;
                    }
                }
                return z2;
            }
        }
        return false;
    }

    @Override // j2.s, a2.g
    public final void q(boolean z2, long j5) throws a2.q {
        f0 f0Var = this.f12602n1;
        if (f0Var != null && !z2) {
            f0Var.e(true);
        }
        super.q(z2, j5);
        f0 f0Var2 = this.f12602n1;
        v vVar = this.f12595g1;
        if (f0Var2 == null) {
            z zVar = vVar.f12653b;
            zVar.f12685m = 0L;
            zVar.f12688p = -1L;
            zVar.f12686n = -1L;
            vVar.f12658h = -9223372036854775807L;
            vVar.f = -9223372036854775807L;
            vVar.f12656e = Math.min(vVar.f12656e, 1);
            vVar.i = -9223372036854775807L;
        }
        if (z2) {
            f0 f0Var3 = this.f12602n1;
            if (f0Var3 != null) {
                f0Var3.l(false);
            } else {
                vVar.c(false);
            }
        }
        G0();
        this.f12614z1 = 0;
    }

    @Override // j2.s
    public final boolean q0() {
        p1.q qVar = this.f6736h0;
        if (this.B1 == null || this.C1 || this.J1) {
            return true;
        }
        return (qVar != null && qVar.f10025p > 0) || this.X0 || this.M0 != -9223372036854775807L;
    }

    @Override // a2.g
    public final void r() {
        f0 f0Var = this.f12602n1;
        if (f0Var == null || !this.f12591c1) {
            return;
        }
        f0Var.release();
    }

    @Override // j2.s
    public final boolean r0(j2.p pVar) {
        return D0(pVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.g
    public final void s() {
        try {
            try {
                this.B0 = false;
                k0();
                i0();
            } finally {
                e6.j.t(this.f6729a0, null);
                this.f6729a0 = null;
            }
        } finally {
            this.f12603o1 = false;
            this.N1 = -9223372036854775807L;
            l lVar = this.f12607s1;
            if (lVar != null) {
                lVar.release();
                this.f12607s1 = null;
            }
        }
    }

    @Override // j2.s
    public final boolean s0() {
        j2.p pVar = this.f6741n0;
        if (this.f12602n1 != null && pVar != null) {
            String str = pVar.f6710a;
            if (str.equals("c2.mtk.avc.decoder") || str.equals("c2.mtk.hevc.decoder")) {
                return true;
            }
        }
        return super.s0();
    }

    @Override // a2.g
    public final void t() {
        this.f12613y1 = 0;
        this.A.getClass();
        this.f12612x1 = SystemClock.elapsedRealtime();
        this.D1 = 0L;
        this.E1 = 0;
        f0 f0Var = this.f12602n1;
        if (f0Var != null) {
            f0Var.n();
        } else {
            this.f12595g1.d();
        }
    }

    @Override // a2.g
    public final void u() {
        F0();
        int i = this.E1;
        if (i != 0) {
            long j5 = this.D1;
            pb.c cVar = this.f12592d1;
            Handler handler = (Handler) cVar.f10310v;
            if (handler != null) {
                handler.post(new b0(cVar, j5, i));
            }
            this.D1 = 0L;
            this.E1 = 0;
        }
        f0 f0Var = this.f12602n1;
        if (f0Var != null) {
            f0Var.g();
        } else {
            this.f12595g1.e();
        }
    }

    @Override // j2.s
    public final int u0(j2.k kVar, p1.q qVar) {
        boolean z2;
        int i = 0;
        if (!m0.o(qVar.f10023n)) {
            return l4.a.g(0, 0, 0, 0);
        }
        boolean z10 = qVar.f10027r != null;
        Context context = this.f12590b1;
        List listA0 = A0(context, kVar, qVar, z10, false);
        if (z10 && listA0.isEmpty()) {
            listA0 = A0(context, kVar, qVar, false, false);
        }
        if (listA0.isEmpty()) {
            return l4.a.g(1, 0, 0, 0);
        }
        int i10 = qVar.O;
        if (i10 != 0 && i10 != 2) {
            return l4.a.g(2, 0, 0, 0);
        }
        j2.p pVar = (j2.p) listA0.get(0);
        boolean zE = pVar.e(qVar);
        if (zE) {
            z2 = true;
        } else {
            for (int i11 = 1; i11 < listA0.size(); i11++) {
                j2.p pVar2 = (j2.p) listA0.get(i11);
                if (pVar2.e(qVar)) {
                    z2 = false;
                    zE = true;
                    pVar = pVar2;
                    break;
                }
            }
            z2 = true;
        }
        int i12 = zE ? 4 : 3;
        int i13 = pVar.f(qVar) ? 16 : 8;
        int i14 = pVar.f6715g ? 64 : 0;
        int i15 = z2 ? 128 : 0;
        if (Build.VERSION.SDK_INT >= 26 && "video/dolby-vision".equals(qVar.f10023n) && !i5.a.n(context)) {
            i15 = 256;
        }
        if (zE) {
            List listA02 = A0(context, kVar, qVar, z10, true);
            if (!listA02.isEmpty()) {
                HashMap map = j2.y.f6759a;
                ArrayList arrayList = new ArrayList(listA02);
                Collections.sort(arrayList, new j2.t(0, new a2.f0(27, qVar)));
                j2.p pVar3 = (j2.p) arrayList.get(0);
                if (pVar3.e(qVar) && pVar3.f(qVar)) {
                    i = 32;
                }
            }
        }
        return i12 | i13 | i | i14 | i15;
    }

    @Override // j2.s, a2.g
    public final void v(p1.q[] qVarArr, long j5, long j8, o2.d0 d0Var) {
        super.v(qVarArr, j5, j8, d0Var);
        f1 f1Var = this.J;
        if (f1Var.p()) {
            this.O1 = -9223372036854775807L;
        } else {
            d0Var.getClass();
            this.O1 = f1Var.g(d0Var.f9090a, new p1.c1()).f9679d;
        }
    }

    @Override // j2.s, a2.g
    public final void x(long j5, long j8) throws a2.q {
        f0 f0Var = this.f12602n1;
        if (f0Var != null) {
            try {
                f0Var.j(j5, j8);
            } catch (e0 e10) {
                throw a(e10, e10.f12577u, false, 7001);
            }
        }
        super.x(j5, j8);
    }

    @Override // j2.s, a2.g
    public final void z(float f, float f4) throws a2.q {
        super.z(f, f4);
        f0 f0Var = this.f12602n1;
        if (f0Var != null) {
            f0Var.i(f);
        } else {
            this.f12595g1.i(f);
        }
    }
}
