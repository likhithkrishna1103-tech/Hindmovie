package kc;

import f9.c0;
import ic.j;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f7413d = TimeUnit.HOURS.toMillis(24);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f7414e = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f7415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7417c;

    public d() {
        if (c0.H == null) {
            Pattern pattern = j.f6436c;
            c0.H = new c0(16);
        }
        c0 c0Var = c0.H;
        if (j.f6437d == null) {
            j.f6437d = new j(c0Var);
        }
        this.f7415a = j.f6437d;
    }

    public final synchronized long a(int i) {
        if (!(i == 429 || (i >= 500 && i < 600))) {
            return f7413d;
        }
        double dPow = Math.pow(2.0d, this.f7417c);
        this.f7415a.getClass();
        return (long) Math.min(dPow + ((long) (Math.random() * 1000.0d)), f7414e);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean b() {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.f7417c     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L1b
            ic.j r0 = r4.f7415a     // Catch: java.lang.Throwable -> L19
            f9.c0 r0 = r0.f6438a     // Catch: java.lang.Throwable -> L19
            r0.getClass()     // Catch: java.lang.Throwable -> L19
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L19
            long r2 = r4.f7416b     // Catch: java.lang.Throwable -> L19
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L17
            goto L1b
        L17:
            r0 = 0
            goto L1c
        L19:
            r0 = move-exception
            goto L1e
        L1b:
            r0 = 1
        L1c:
            monitor-exit(r4)
            return r0
        L1e:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L19
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kc.d.b():boolean");
    }

    public final synchronized void c() {
        this.f7417c = 0;
    }

    public final synchronized void d(int i) {
        if ((i >= 200 && i < 300) || i == 401 || i == 404) {
            c();
            return;
        }
        this.f7417c++;
        long jA = a(i);
        this.f7415a.f6438a.getClass();
        this.f7416b = System.currentTimeMillis() + jA;
    }
}
