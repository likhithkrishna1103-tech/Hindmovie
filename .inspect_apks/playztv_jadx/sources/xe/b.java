package xe;

import be.h;
import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import va.e;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f14360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f14363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f14364e;
    public boolean f;

    public b(c cVar, String str) {
        h.e(str, "name");
        this.f14360a = cVar;
        this.f14361b = str;
        this.f14364e = new ArrayList();
    }

    public final void a() {
        byte[] bArr = ve.b.f13497a;
        synchronized (this.f14360a) {
            if (b()) {
                this.f14360a.d(this);
            }
        }
    }

    public final boolean b() {
        a aVar = this.f14363d;
        if (aVar != null && aVar.f14357b) {
            this.f = true;
        }
        ArrayList arrayList = this.f14364e;
        boolean z2 = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((a) arrayList.get(size)).f14357b) {
                a aVar2 = (a) arrayList.get(size);
                e eVar = c.f14365h;
                if (c.f14366j.isLoggable(Level.FINE)) {
                    t1.c(aVar2, this, "canceled");
                }
                arrayList.remove(size);
                z2 = true;
            }
        }
        return z2;
    }

    public final void c(a aVar, long j5) {
        h.e(aVar, "task");
        synchronized (this.f14360a) {
            if (!this.f14362c) {
                if (d(aVar, j5, false)) {
                    this.f14360a.d(this);
                }
            } else if (aVar.f14357b) {
                e eVar = c.f14365h;
                if (c.f14366j.isLoggable(Level.FINE)) {
                    t1.c(aVar, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                e eVar2 = c.f14365h;
                if (c.f14366j.isLoggable(Level.FINE)) {
                    t1.c(aVar, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(xe.a r11, long r12, boolean r14) {
        /*
            r10 = this;
            java.lang.String r0 = "task"
            be.h.e(r11, r0)
            xe.b r0 = r11.f14358c
            if (r0 != r10) goto La
            goto Le
        La:
            if (r0 != 0) goto L8d
            r11.f14358c = r10
        Le:
            long r0 = java.lang.System.nanoTime()
            long r2 = r0 + r12
            java.util.ArrayList r4 = r10.f14364e
            int r5 = r4.indexOf(r11)
            r6 = -1
            r7 = 0
            if (r5 == r6) goto L39
            long r8 = r11.f14359d
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 > 0) goto L36
            va.e r12 = xe.c.f14365h
            java.util.logging.Logger r12 = xe.c.f14366j
            java.util.logging.Level r13 = java.util.logging.Level.FINE
            boolean r12 = r12.isLoggable(r13)
            if (r12 == 0) goto L8c
            java.lang.String r12 = "already scheduled"
            wa.t1.c(r11, r10, r12)
            return r7
        L36:
            r4.remove(r5)
        L39:
            r11.f14359d = r2
            va.e r5 = xe.c.f14365h
            java.util.logging.Logger r5 = xe.c.f14366j
            java.util.logging.Level r8 = java.util.logging.Level.FINE
            boolean r5 = r5.isLoggable(r8)
            if (r5 == 0) goto L63
            if (r14 == 0) goto L55
            long r2 = r2 - r0
            java.lang.String r14 = wa.t1.l(r2)
            java.lang.String r2 = "run again after "
            java.lang.String r14 = r2.concat(r14)
            goto L60
        L55:
            long r2 = r2 - r0
            java.lang.String r14 = wa.t1.l(r2)
            java.lang.String r2 = "scheduled after "
            java.lang.String r14 = r2.concat(r14)
        L60:
            wa.t1.c(r11, r10, r14)
        L63:
            int r14 = r4.size()
            r2 = r7
            r3 = r2
        L69:
            if (r3 >= r14) goto L7e
            java.lang.Object r5 = r4.get(r3)
            int r3 = r3 + 1
            xe.a r5 = (xe.a) r5
            long r8 = r5.f14359d
            long r8 = r8 - r0
            int r5 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r5 <= 0) goto L7b
            goto L7f
        L7b:
            int r2 = r2 + 1
            goto L69
        L7e:
            r2 = r6
        L7f:
            if (r2 != r6) goto L85
            int r2 = r4.size()
        L85:
            r4.add(r2, r11)
            if (r2 != 0) goto L8c
            r11 = 1
            return r11
        L8c:
            return r7
        L8d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "task is in multiple queues"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: xe.b.d(xe.a, long, boolean):boolean");
    }

    public final void e() {
        byte[] bArr = ve.b.f13497a;
        synchronized (this.f14360a) {
            this.f14362c = true;
            if (b()) {
                this.f14360a.d(this);
            }
        }
    }

    public final String toString() {
        return this.f14361b;
    }
}
