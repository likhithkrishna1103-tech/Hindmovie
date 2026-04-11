package b2;

import a2.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import o2.d0;
import p1.c1;
import p1.e1;
import p1.f1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final t f1754h = new t(1);
    public static final Random i = new Random();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n f1758d;
    public String f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e1 f1755a = new e1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c1 f1756b = new c1();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f1757c = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f1 f1759e = f1.f9741a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f1760g = -1;

    public final void a(i iVar) {
        long j5 = iVar.f1750c;
        if (j5 != -1) {
            this.f1760g = j5;
        }
        this.f = null;
    }

    public final synchronized void b(a aVar) {
        n nVar;
        try {
            String str = this.f;
            if (str != null) {
                i iVar = (i) this.f1757c.get(str);
                iVar.getClass();
                a(iVar);
            }
            Iterator it = this.f1757c.values().iterator();
            while (it.hasNext()) {
                i iVar2 = (i) it.next();
                it.remove();
                if (iVar2.f1752e && (nVar = this.f1758d) != null) {
                    nVar.d(aVar, iVar2.f1748a);
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
    public final b2.i c(int r19, o2.d0 r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            java.util.HashMap r3 = r0.f1757c
            java.util.Collection r4 = r3.values()
            java.util.Iterator r4 = r4.iterator()
            r5 = 0
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L16:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L9f
            java.lang.Object r8 = r4.next()
            b2.i r8 = (b2.i) r8
            long r9 = r8.f1750c
            o2.d0 r11 = r8.f1751d
            r12 = -1
            int r9 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r9 != 0) goto L57
            int r9 = r8.f1749b
            if (r1 != r9) goto L57
            if (r2 == 0) goto L57
            long r9 = r2.f9093d
            b2.j r14 = r8.f1753g
            java.util.HashMap r15 = r14.f1757c
            r16 = r12
            java.lang.String r12 = r14.f
            java.lang.Object r12 = r15.get(r12)
            b2.i r12 = (b2.i) r12
            if (r12 == 0) goto L4b
            long r12 = r12.f1750c
            int r15 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r15 == 0) goto L4b
            goto L50
        L4b:
            long r12 = r14.f1760g
            r14 = 1
            long r12 = r12 + r14
        L50:
            int r12 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r12 < 0) goto L59
            r8.f1750c = r9
            goto L59
        L57:
            r16 = r12
        L59:
            if (r2 != 0) goto L60
            int r9 = r8.f1749b
            if (r1 != r9) goto L16
            goto L83
        L60:
            long r9 = r2.f9093d
            if (r11 != 0) goto L71
            boolean r12 = r2.b()
            if (r12 != 0) goto L16
            long r12 = r8.f1750c
            int r9 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r9 != 0) goto L16
            goto L83
        L71:
            long r12 = r11.f9093d
            int r9 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r9 != 0) goto L16
            int r9 = r2.f9091b
            int r10 = r11.f9091b
            if (r9 != r10) goto L16
            int r9 = r2.f9092c
            int r10 = r11.f9092c
            if (r9 != r10) goto L16
        L83:
            long r9 = r8.f1750c
            int r12 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r12 == 0) goto L9b
            int r12 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r12 >= 0) goto L8e
            goto L9b
        L8e:
            if (r12 != 0) goto L16
            int r9 = s1.b0.f11647a
            o2.d0 r9 = r5.f1751d
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
            a2.t r4 = b2.j.f1754h
            java.lang.Object r4 = r4.get()
            java.lang.String r4 = (java.lang.String) r4
            b2.i r5 = new b2.i
            r5.<init>(r0, r4, r1, r2)
            r3.put(r4, r5)
        Lb1:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.j.c(int, o2.d0):b2.i");
    }

    public final synchronized String d(f1 f1Var, d0 d0Var) {
        return c(f1Var.g(d0Var.f9090a, this.f1756b).f9678c, d0Var).f1748a;
    }

    public final void e(a aVar) {
        d0 d0Var;
        f1 f1Var = aVar.f1720b;
        int i10 = aVar.f1721c;
        d0 d0Var2 = aVar.f1722d;
        boolean zP = f1Var.p();
        HashMap map = this.f1757c;
        if (zP) {
            String str = this.f;
            if (str != null) {
                i iVar = (i) map.get(str);
                iVar.getClass();
                a(iVar);
                return;
            }
            return;
        }
        i iVar2 = (i) map.get(this.f);
        this.f = c(i10, d0Var2).f1748a;
        f(aVar);
        if (d0Var2 != null) {
            long j5 = d0Var2.f9093d;
            if (d0Var2.b()) {
                if (iVar2 != null && iVar2.f1750c == j5 && (d0Var = iVar2.f1751d) != null && d0Var.f9091b == d0Var2.f9091b && d0Var.f9092c == d0Var2.f9092c) {
                    return;
                }
                c(i10, new d0(j5, d0Var2.f9090a));
                this.f1758d.getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002b A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0010, B:9:0x0014, B:11:0x0024, B:20:0x0036, B:22:0x0042, B:24:0x0048, B:14:0x002b, B:30:0x0053, B:32:0x005f, B:33:0x0063, B:35:0x0068, B:37:0x006e, B:39:0x0085, B:40:0x00b2, B:42:0x00b6, B:43:0x00bd, B:45:0x00c7, B:47:0x00cb, B:49:0x00d8, B:52:0x00df), top: B:57:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void f(b2.a r10) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.j.f(b2.a):void");
    }

    public final synchronized void g(a aVar, int i10) {
        try {
            this.f1758d.getClass();
            boolean z2 = i10 == 0;
            Iterator it = this.f1757c.values().iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (iVar.a(aVar)) {
                    it.remove();
                    if (iVar.f1752e) {
                        boolean zEquals = iVar.f1748a.equals(this.f);
                        if (z2 && zEquals) {
                            boolean z10 = iVar.f;
                        }
                        if (zEquals) {
                            a(iVar);
                        }
                        this.f1758d.d(aVar, iVar.f1748a);
                    }
                }
            }
            e(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }
}
