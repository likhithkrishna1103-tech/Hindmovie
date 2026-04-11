package qb;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import k8.a0;
import ob.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f11182d = TimeUnit.HOURS.toMillis(24);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f11183e = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f11184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f11185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11186c;

    public d() {
        if (a0.f7067v == null) {
            Pattern pattern = j.f9502c;
            a0.f7067v = new a0(24);
        }
        a0 a0Var = a0.f7067v;
        if (j.f9503d == null) {
            j.f9503d = new j(a0Var);
        }
        this.f11184a = j.f9503d;
    }

    public final synchronized long a(int i) {
        if (!(i == 429 || (i >= 500 && i < 600))) {
            return f11182d;
        }
        double dPow = Math.pow(2.0d, this.f11186c);
        this.f11184a.getClass();
        return (long) Math.min(dPow + ((long) (Math.random() * 1000.0d)), f11183e);
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
            int r0 = r4.f11186c     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L1b
            ob.j r0 = r4.f11184a     // Catch: java.lang.Throwable -> L19
            k8.a0 r0 = r0.f9504a     // Catch: java.lang.Throwable -> L19
            r0.getClass()     // Catch: java.lang.Throwable -> L19
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L19
            long r2 = r4.f11185b     // Catch: java.lang.Throwable -> L19
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
        throw new UnsupportedOperationException("Method not decompiled: qb.d.b():boolean");
    }

    public final synchronized void c() {
        this.f11186c = 0;
    }

    public final synchronized void d(int i) {
        if ((i >= 200 && i < 300) || i == 401 || i == 404) {
            c();
            return;
        }
        this.f11186c++;
        long jA = a(i);
        this.f11184a.f9504a.getClass();
        this.f11185b = System.currentTimeMillis() + jA;
    }
}
