package o2;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g1 extends p1.f1 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Object f9115q = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f9116e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f9117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f9118h;
    public final long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f9119j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f9120k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f9121l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f9122m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f9123n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final p1.g0 f9124o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final p1.b0 f9125p;

    static {
        p1.w wVar = new p1.w();
        p1.z zVar = new p1.z();
        List list = Collections.EMPTY_LIST;
        aa.c1 c1Var = aa.c1.f650y;
        e2.t tVar = new e2.t();
        p1.d0 d0Var = p1.d0.f9694d;
        Uri uri = Uri.EMPTY;
        s1.d.g(zVar.f10114b == null || zVar.f10113a != null);
        if (uri != null) {
            new p1.c0(uri, null, zVar.f10113a != null ? new p1.a0(zVar) : null, null, list, null, c1Var, -9223372036854775807L);
        }
        new p1.y(wVar);
        new p1.b0(tVar);
        p1.j0 j0Var = p1.j0.K;
    }

    public g1(long j5, boolean z2, boolean z10, p1.g0 g0Var) {
        this(j5, j5, 0L, 0L, z2, false, z10, null, g0Var);
    }

    @Override // p1.f1
    public final int b(Object obj) {
        return f9115q.equals(obj) ? 0 : -1;
    }

    @Override // p1.f1
    public final p1.c1 f(int i, p1.c1 c1Var, boolean z2) {
        s1.d.c(i, 1);
        Object obj = z2 ? f9115q : null;
        long j5 = -this.i;
        c1Var.getClass();
        c1Var.h(null, obj, 0, this.f9117g, j5, p1.b.f9644c, false);
        return c1Var;
    }

    @Override // p1.f1
    public final int h() {
        return 1;
    }

    @Override // p1.f1
    public final Object l(int i) {
        s1.d.c(i, 1);
        return f9115q;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[PHI: r1
      0x002d: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v1 long), (r1v4 long) binds: [B:3:0x000c, B:5:0x0010, B:7:0x0016, B:12:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p1.f1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final p1.e1 m(int r25, p1.e1 r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 1
            r2 = r25
            s1.d.c(r2, r1)
            long r1 = r0.f9119j
            boolean r14 = r0.f9121l
            if (r14 == 0) goto L2d
            boolean r3 = r0.f9122m
            if (r3 != 0) goto L2d
            r3 = 0
            int r3 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r3 == 0) goto L2d
            long r3 = r0.f9118h
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L26
        L23:
            r16 = r5
            goto L2f
        L26:
            long r1 = r1 + r27
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L2d
            goto L23
        L2d:
            r16 = r1
        L2f:
            java.lang.Object r4 = p1.e1.f9703q
            r21 = 0
            long r1 = r0.i
            p1.g0 r5 = r0.f9124o
            java.lang.Object r6 = r0.f9123n
            long r7 = r0.f9116e
            long r9 = r0.f
            boolean r13 = r0.f9120k
            p1.b0 r15 = r0.f9125p
            long r11 = r0.f9118h
            r20 = 0
            r3 = r26
            r22 = r1
            r18 = r11
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r3.b(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r26
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.g1.m(int, p1.e1, long):p1.e1");
    }

    @Override // p1.f1
    public final int o() {
        return 1;
    }

    public g1(long j5, long j8, long j10, long j11, boolean z2, boolean z10, boolean z11, Object obj, p1.g0 g0Var) {
        this(-9223372036854775807L, -9223372036854775807L, j5, j8, j10, j11, z2, z10, false, obj, g0Var, z11 ? g0Var.f9758c : null);
    }

    public g1(long j5, long j8, long j10, long j11, long j12, long j13, boolean z2, boolean z10, boolean z11, Object obj, p1.g0 g0Var, p1.b0 b0Var) {
        this.f9116e = j5;
        this.f = j8;
        this.f9117g = j10;
        this.f9118h = j11;
        this.i = j12;
        this.f9119j = j13;
        this.f9120k = z2;
        this.f9121l = z10;
        this.f9122m = z11;
        this.f9123n = obj;
        g0Var.getClass();
        this.f9124o = g0Var;
        this.f9125p = b0Var;
    }
}
