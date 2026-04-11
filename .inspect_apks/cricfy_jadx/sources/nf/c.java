package nf;

import ge.i;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lf.f;
import vf.g;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f9153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f9156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f9157e;
    public boolean f;

    public c(d dVar, String str) {
        i.e(str, "name");
        this.f9153a = dVar;
        this.f9154b = str;
        this.f9157e = new ArrayList();
    }

    public static void c(c cVar, String str, fe.a aVar) {
        cVar.getClass();
        i.e(str, "name");
        i.e(aVar, "block");
        cVar.d(new b(str, aVar), 0L);
    }

    public final void a() {
        d dVar = this.f9153a;
        TimeZone timeZone = f.f7964a;
        synchronized (dVar) {
            if (b()) {
                this.f9153a.c(this);
            }
        }
    }

    public final boolean b() {
        a aVar = this.f9156d;
        if (aVar != null && aVar.f9149b) {
            this.f = true;
        }
        ArrayList arrayList = this.f9157e;
        boolean z10 = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((a) arrayList.get(size)).f9149b) {
                Logger logger = this.f9153a.f9161b;
                a aVar2 = (a) arrayList.get(size);
                if (logger.isLoggable(Level.FINE)) {
                    g.a(logger, aVar2, this, "canceled");
                }
                arrayList.remove(size);
                z10 = true;
            }
        }
        return z10;
    }

    public final void d(a aVar, long j4) {
        i.e(aVar, "task");
        synchronized (this.f9153a) {
            if (!this.f9155c) {
                if (e(aVar, j4, false)) {
                    this.f9153a.c(this);
                }
            } else if (aVar.f9149b) {
                Logger logger = this.f9153a.f9161b;
                if (logger.isLoggable(Level.FINE)) {
                    g.a(logger, aVar, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                Logger logger2 = this.f9153a.f9161b;
                if (logger2.isLoggable(Level.FINE)) {
                    g.a(logger2, aVar, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(nf.a r12, long r13, boolean r15) {
        /*
            r11 = this;
            nf.d r0 = r11.f9153a
            java.util.logging.Logger r0 = r0.f9161b
            java.lang.String r1 = "task"
            ge.i.e(r12, r1)
            nf.c r1 = r12.f9150c
            if (r1 != r11) goto Le
            goto L12
        Le:
            if (r1 != 0) goto L89
            r12.f9150c = r11
        L12:
            long r1 = java.lang.System.nanoTime()
            long r3 = r1 + r13
            java.util.ArrayList r5 = r11.f9157e
            int r6 = r5.indexOf(r12)
            r7 = -1
            r8 = 0
            if (r6 == r7) goto L39
            long r9 = r12.f9151d
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 > 0) goto L36
            java.util.logging.Level r13 = java.util.logging.Level.FINE
            boolean r13 = r0.isLoggable(r13)
            if (r13 == 0) goto L88
            java.lang.String r13 = "already scheduled"
            vf.g.a(r0, r12, r11, r13)
            return r8
        L36:
            r5.remove(r6)
        L39:
            r12.f9151d = r3
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            boolean r6 = r0.isLoggable(r6)
            if (r6 == 0) goto L5f
            if (r15 == 0) goto L51
            long r3 = r3 - r1
            java.lang.String r15 = vf.g.B(r3)
            java.lang.String r3 = "run again after "
            java.lang.String r15 = r3.concat(r15)
            goto L5c
        L51:
            long r3 = r3 - r1
            java.lang.String r15 = vf.g.B(r3)
            java.lang.String r3 = "scheduled after "
            java.lang.String r15 = r3.concat(r15)
        L5c:
            vf.g.a(r0, r12, r11, r15)
        L5f:
            int r15 = r5.size()
            r0 = r8
            r3 = r0
        L65:
            if (r3 >= r15) goto L7a
            java.lang.Object r4 = r5.get(r3)
            int r3 = r3 + 1
            nf.a r4 = (nf.a) r4
            long r9 = r4.f9151d
            long r9 = r9 - r1
            int r4 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r4 <= 0) goto L77
            goto L7b
        L77:
            int r0 = r0 + 1
            goto L65
        L7a:
            r0 = r7
        L7b:
            if (r0 != r7) goto L81
            int r0 = r5.size()
        L81:
            r5.add(r0, r12)
            if (r0 != 0) goto L88
            r12 = 1
            return r12
        L88:
            return r8
        L89:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "task is in multiple queues"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: nf.c.e(nf.a, long, boolean):boolean");
    }

    public final void f() {
        d dVar = this.f9153a;
        TimeZone timeZone = f.f7964a;
        synchronized (dVar) {
            this.f9155c = true;
            if (b()) {
                this.f9153a.c(this);
            }
        }
    }

    public final String toString() {
        return this.f9154b;
    }
}
