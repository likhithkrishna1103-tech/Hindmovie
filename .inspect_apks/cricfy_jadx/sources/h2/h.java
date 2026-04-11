package h2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import s2.c0;
import v1.c1;
import v1.e1;
import v1.f1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b2.i f5505h = new b2.i(2);
    public static final Random i = new Random();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f5509d;
    public String f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e1 f5506a = new e1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c1 f5507b = new c1();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f5508c = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f1 f5510e = f1.f12674a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5511g = -1;

    public final void a(g gVar) {
        long j4 = gVar.f5501c;
        if (j4 != -1) {
            this.f5511g = j4;
        }
        this.f = null;
    }

    public final synchronized void b(a aVar) {
        k kVar;
        try {
            String str = this.f;
            if (str != null) {
                g gVar = (g) this.f5508c.get(str);
                gVar.getClass();
                a(gVar);
            }
            Iterator it = this.f5508c.values().iterator();
            while (it.hasNext()) {
                g gVar2 = (g) it.next();
                it.remove();
                if (gVar2.f5503e && (kVar = this.f5509d) != null) {
                    kVar.d(aVar, gVar2.f5499a);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009b A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final h2.g c(int r19, s2.c0 r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            java.util.HashMap r3 = r0.f5508c
            java.util.Collection r4 = r3.values()
            java.util.Iterator r4 = r4.iterator()
            r5 = 0
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L16:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L9f
            java.lang.Object r8 = r4.next()
            h2.g r8 = (h2.g) r8
            long r9 = r8.f5501c
            s2.c0 r11 = r8.f5502d
            r12 = -1
            int r9 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r9 != 0) goto L57
            int r9 = r8.f5500b
            if (r1 != r9) goto L57
            if (r2 == 0) goto L57
            long r9 = r2.f11159d
            h2.h r14 = r8.f5504g
            java.util.HashMap r15 = r14.f5508c
            r16 = r12
            java.lang.String r12 = r14.f
            java.lang.Object r12 = r15.get(r12)
            h2.g r12 = (h2.g) r12
            if (r12 == 0) goto L4b
            long r12 = r12.f5501c
            int r15 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r15 == 0) goto L4b
            goto L50
        L4b:
            long r12 = r14.f5511g
            r14 = 1
            long r12 = r12 + r14
        L50:
            int r12 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r12 < 0) goto L59
            r8.f5501c = r9
            goto L59
        L57:
            r16 = r12
        L59:
            if (r2 != 0) goto L60
            int r9 = r8.f5500b
            if (r1 != r9) goto L16
            goto L83
        L60:
            long r9 = r2.f11159d
            if (r11 != 0) goto L71
            boolean r12 = r2.b()
            if (r12 != 0) goto L16
            long r12 = r8.f5501c
            int r9 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r9 != 0) goto L16
            goto L83
        L71:
            long r12 = r11.f11159d
            int r9 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r9 != 0) goto L16
            int r9 = r2.f11157b
            int r10 = r11.f11157b
            if (r9 != r10) goto L16
            int r9 = r2.f11158c
            int r10 = r11.f11158c
            if (r9 != r10) goto L16
        L83:
            long r9 = r8.f5501c
            int r12 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r12 == 0) goto L9b
            int r12 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r12 >= 0) goto L8e
            goto L9b
        L8e:
            if (r12 != 0) goto L16
            int r9 = y1.a0.f14551a
            s2.c0 r9 = r5.f5502d
            if (r9 == 0) goto L16
            if (r11 == 0) goto L16
            r5 = r8
            goto L16
        L9b:
            r5 = r8
            r6 = r9
            goto L16
        L9f:
            if (r5 != 0) goto Lb1
            b2.i r4 = h2.h.f5505h
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            h2.g r5 = new h2.g
            r5.<init>(r0, r4, r1, r2)
            r3.put(r4, r5)
        Lb1:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.h.c(int, s2.c0):h2.g");
    }

    public final synchronized String d(f1 f1Var, c0 c0Var) {
        return c(f1Var.g(c0Var.f11156a, this.f5507b).f12618c, c0Var).f5499a;
    }

    public final void e(a aVar) {
        c0 c0Var;
        f1 f1Var = aVar.f5481b;
        int i10 = aVar.f5482c;
        c0 c0Var2 = aVar.f5483d;
        boolean zP = f1Var.p();
        HashMap map = this.f5508c;
        if (zP) {
            String str = this.f;
            if (str != null) {
                g gVar = (g) map.get(str);
                gVar.getClass();
                a(gVar);
                return;
            }
            return;
        }
        g gVar2 = (g) map.get(this.f);
        this.f = c(i10, c0Var2).f5499a;
        f(aVar);
        if (c0Var2 != null) {
            long j4 = c0Var2.f11159d;
            if (c0Var2.b()) {
                if (gVar2 != null && gVar2.f5501c == j4 && (c0Var = gVar2.f5502d) != null && c0Var.f11157b == c0Var2.f11157b && c0Var.f11158c == c0Var2.f11158c) {
                    return;
                }
                c(i10, new c0(j4, c0Var2.f11156a));
                this.f5509d.getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002b A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0010, B:9:0x0014, B:11:0x0024, B:20:0x0036, B:22:0x0042, B:24:0x0048, B:14:0x002b, B:30:0x0053, B:32:0x005f, B:33:0x0063, B:35:0x0068, B:37:0x006e, B:39:0x0085, B:40:0x00b2, B:42:0x00b6, B:43:0x00bd, B:45:0x00c7, B:47:0x00cb, B:49:0x00d8, B:52:0x00df), top: B:57:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void f(h2.a r10) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.h.f(h2.a):void");
    }

    public final synchronized void g(a aVar, int i10) {
        try {
            this.f5509d.getClass();
            boolean z10 = i10 == 0;
            Iterator it = this.f5508c.values().iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                if (gVar.a(aVar)) {
                    it.remove();
                    if (gVar.f5503e) {
                        boolean zEquals = gVar.f5499a.equals(this.f);
                        if (z10 && zEquals) {
                            boolean z11 = gVar.f;
                        }
                        if (zEquals) {
                            a(gVar);
                        }
                        this.f5509d.d(aVar, gVar.f5499a);
                    }
                }
            }
            e(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }
}
