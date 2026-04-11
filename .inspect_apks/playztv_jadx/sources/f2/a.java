package f2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f4696b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, Looper looper) {
        super(looper);
        this.f4696b = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(android.os.Message r8, f2.a0 r9) {
        /*
            r7 = this;
            java.lang.Object r0 = r8.obj
            f2.b r0 = (f2.b) r0
            boolean r1 = r0.f4698b
            r2 = 0
            if (r1 != 0) goto Lb
            goto L82
        Lb:
            int r1 = r0.f4700d
            r3 = 1
            int r1 = r1 + r3
            r0.f4700d = r1
            f2.c r4 = r7.f4696b
            k8.a0 r4 = r4.i
            r4.getClass()
            r4 = 3
            if (r1 <= r4) goto L1c
            goto L82
        L1c:
            o2.u r1 = new o2.u
            android.os.SystemClock.elapsedRealtime()
            android.os.SystemClock.elapsedRealtime()
            java.lang.Throwable r1 = r9.getCause()
            boolean r1 = r1 instanceof java.io.IOException
            if (r1 == 0) goto L33
            java.lang.Throwable r9 = r9.getCause()
            java.io.IOException r9 = (java.io.IOException) r9
            goto L3d
        L33:
            c6.c r1 = new c6.c
            java.lang.Throwable r9 = r9.getCause()
            r1.<init>(r9)
            r9 = r1
        L3d:
            f2.c r1 = r7.f4696b
            k8.a0 r1 = r1.i
            int r0 = r0.f4700d
            r1.getClass()
            boolean r1 = r9 instanceof p1.n0
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L7d
            boolean r1 = r9 instanceof java.io.FileNotFoundException
            if (r1 != 0) goto L7d
            boolean r1 = r9 instanceof v1.u
            if (r1 != 0) goto L7d
            boolean r1 = r9 instanceof s2.l
            if (r1 != 0) goto L7d
            int r1 = v1.j.f13143v
        L5d:
            if (r9 == 0) goto L72
            boolean r1 = r9 instanceof v1.j
            if (r1 == 0) goto L6d
            r1 = r9
            v1.j r1 = (v1.j) r1
            int r1 = r1.f13144u
            r6 = 2008(0x7d8, float:2.814E-42)
            if (r1 != r6) goto L6d
            goto L7d
        L6d:
            java.lang.Throwable r9 = r9.getCause()
            goto L5d
        L72:
            int r0 = r0 - r3
            int r0 = r0 * 1000
            r9 = 5000(0x1388, float:7.006E-42)
            int r9 = java.lang.Math.min(r0, r9)
            long r0 = (long) r9
            goto L7e
        L7d:
            r0 = r4
        L7e:
            int r9 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r9 != 0) goto L83
        L82:
            return r2
        L83:
            monitor-enter(r7)
            boolean r9 = r7.f4695a     // Catch: java.lang.Throwable -> L91
            if (r9 != 0) goto L93
            android.os.Message r8 = android.os.Message.obtain(r8)     // Catch: java.lang.Throwable -> L91
            r7.sendMessageDelayed(r8, r0)     // Catch: java.lang.Throwable -> L91
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L91
            return r3
        L91:
            r8 = move-exception
            goto L95
        L93:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L91
            return r2
        L95:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L91
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.a.a(android.os.Message, f2.a0):boolean");
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object objY;
        b bVar = (b) message.obj;
        try {
            int i = message.what;
            if (i == 1) {
                objY = this.f4696b.f4709k.y((t) bVar.f4699c);
            } else {
                if (i != 2) {
                    throw new RuntimeException();
                }
                c cVar = this.f4696b;
                objY = cVar.f4709k.p(cVar.f4710l, (r) bVar.f4699c);
            }
        } catch (a0 e10) {
            boolean zA = a(message, e10);
            objY = e10;
            if (zA) {
                return;
            }
        } catch (Exception e11) {
            s1.b.q("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e11);
            objY = e11;
        }
        k8.a0 a0Var = this.f4696b.i;
        long j5 = bVar.f4697a;
        a0Var.getClass();
        synchronized (this) {
            try {
                if (!this.f4695a) {
                    this.f4696b.f4712n.obtainMessage(message.what, Pair.create(bVar.f4699c, objY)).sendToTarget();
                }
            } finally {
            }
        }
    }
}
