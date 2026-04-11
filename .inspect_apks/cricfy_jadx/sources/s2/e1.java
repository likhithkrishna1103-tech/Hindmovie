package s2;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e1 extends v1.f1 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Object f11180q = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f11181e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f11182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f11183h;
    public final long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f11184j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f11185k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f11186l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f11187m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Object f11188n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final v1.g0 f11189o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final v1.a0 f11190p;

    static {
        v1.v vVar = new v1.v();
        v1.y yVar = new v1.y();
        List list = Collections.EMPTY_LIST;
        ua.z0 z0Var = ua.z0.f12413z;
        k2.t tVar = new k2.t();
        v1.d0 d0Var = v1.d0.f12622d;
        Uri uri = Uri.EMPTY;
        y1.d.g(yVar.f13038b == null || yVar.f13037a != null);
        if (uri != null) {
            new v1.c0(uri, null, yVar.f13037a != null ? new v1.z(yVar) : null, null, list, null, z0Var, -9223372036854775807L);
        }
        new v1.x(vVar);
        new v1.a0(tVar);
        v1.j0 j0Var = v1.j0.K;
    }

    public e1(long j4, long j7, long j10, long j11, long j12, long j13, boolean z10, boolean z11, boolean z12, f9.b0 b0Var, v1.g0 g0Var, v1.a0 a0Var) {
        this.f11181e = j4;
        this.f = j7;
        this.f11182g = j10;
        this.f11183h = j11;
        this.i = j12;
        this.f11184j = j13;
        this.f11185k = z10;
        this.f11186l = z11;
        this.f11187m = z12;
        this.f11188n = b0Var;
        g0Var.getClass();
        this.f11189o = g0Var;
        this.f11190p = a0Var;
    }

    @Override // v1.f1
    public final int b(Object obj) {
        return f11180q.equals(obj) ? 0 : -1;
    }

    @Override // v1.f1
    public final v1.c1 f(int i, v1.c1 c1Var, boolean z10) {
        y1.d.c(i, 1);
        Object obj = z10 ? f11180q : null;
        long j4 = -this.i;
        c1Var.getClass();
        c1Var.h(null, obj, 0, this.f11182g, j4, v1.b.f12580c, false);
        return c1Var;
    }

    @Override // v1.f1
    public final int h() {
        return 1;
    }

    @Override // v1.f1
    public final Object l(int i) {
        y1.d.c(i, 1);
        return f11180q;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[PHI: r1
      0x002d: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v1 long), (r1v4 long) binds: [B:3:0x000c, B:5:0x0010, B:7:0x0016, B:12:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // v1.f1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final v1.e1 m(int r25, v1.e1 r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 1
            r2 = r25
            y1.d.c(r2, r1)
            long r1 = r0.f11184j
            boolean r14 = r0.f11186l
            if (r14 == 0) goto L2d
            boolean r3 = r0.f11187m
            if (r3 != 0) goto L2d
            r3 = 0
            int r3 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r3 == 0) goto L2d
            long r3 = r0.f11183h
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
            java.lang.Object r4 = v1.e1.f12633q
            r21 = 0
            long r1 = r0.i
            v1.g0 r5 = r0.f11189o
            java.lang.Object r6 = r0.f11188n
            long r7 = r0.f11181e
            long r9 = r0.f
            boolean r13 = r0.f11185k
            v1.a0 r15 = r0.f11190p
            long r11 = r0.f11183h
            r20 = 0
            r3 = r26
            r22 = r1
            r18 = r11
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r3.b(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r26
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.e1.m(int, v1.e1, long):v1.e1");
    }

    @Override // v1.f1
    public final int o() {
        return 1;
    }
}
