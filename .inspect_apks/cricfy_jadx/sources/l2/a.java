package l2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f7629b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, Looper looper) {
        super(looper);
        this.f7629b = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(android.os.Message r8, l2.a0 r9) {
        /*
            r7 = this;
            java.lang.Object r0 = r8.obj
            l2.b r0 = (l2.b) r0
            boolean r1 = r0.f7631b
            r2 = 0
            if (r1 != 0) goto Lb
            goto L82
        Lb:
            int r1 = r0.f7633d
            r3 = 1
            int r1 = r1 + r3
            r0.f7633d = r1
            l2.c r4 = r7.f7629b
            f9.a0 r4 = r4.i
            r4.getClass()
            r4 = 3
            if (r1 <= r4) goto L1c
            goto L82
        L1c:
            s2.t r1 = new s2.t
            android.os.SystemClock.elapsedRealtime()
            android.os.SystemClock.elapsedRealtime()
            java.lang.Throwable r1 = r9.getCause()
            boolean r1 = r1 instanceof java.io.IOException
            if (r1 == 0) goto L33
            java.lang.Throwable r9 = r9.getCause()
            java.io.IOException r9 = (java.io.IOException) r9
            goto L3d
        L33:
            a2.a r1 = new a2.a
            java.lang.Throwable r9 = r9.getCause()
            r1.<init>(r9)
            r9 = r1
        L3d:
            l2.c r1 = r7.f7629b
            f9.a0 r1 = r1.i
            int r0 = r0.f7633d
            r1.getClass()
            boolean r1 = r9 instanceof v1.n0
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L7d
            boolean r1 = r9 instanceof java.io.FileNotFoundException
            if (r1 != 0) goto L7d
            boolean r1 = r9 instanceof b2.x
            if (r1 != 0) goto L7d
            boolean r1 = r9 instanceof w2.n
            if (r1 != 0) goto L7d
            int r1 = b2.l.f1700w
        L5d:
            if (r9 == 0) goto L72
            boolean r1 = r9 instanceof b2.l
            if (r1 == 0) goto L6d
            r1 = r9
            b2.l r1 = (b2.l) r1
            int r1 = r1.f1701v
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
            boolean r9 = r7.f7628a     // Catch: java.lang.Throwable -> L91
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
        throw new UnsupportedOperationException("Method not decompiled: l2.a.a(android.os.Message, l2.a0):boolean");
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object objW;
        b bVar = (b) message.obj;
        try {
            int i = message.what;
            if (i == 1) {
                objW = this.f7629b.f7642k.w((t) bVar.f7632c);
            } else {
                if (i != 2) {
                    throw new RuntimeException();
                }
                c cVar = this.f7629b;
                objW = cVar.f7642k.g(cVar.f7643l, (r) bVar.f7632c);
            }
        } catch (a0 e9) {
            boolean zA = a(message, e9);
            objW = e9;
            if (zA) {
                return;
            }
        } catch (Exception e10) {
            y1.b.q("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e10);
            objW = e10;
        }
        f9.a0 a0Var = this.f7629b.i;
        long j4 = bVar.f7630a;
        a0Var.getClass();
        synchronized (this) {
            try {
                if (!this.f7628a) {
                    this.f7629b.f7645n.obtainMessage(message.what, Pair.create(bVar.f7632c, objW)).sendToTarget();
                }
            } finally {
            }
        }
    }
}
