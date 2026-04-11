package yc;

import java.util.concurrent.atomic.AtomicReference;
import pe.x;
import vc.e1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e1 f15049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d1.i f15050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f15051c;

    public n(vd.h hVar, e1 e1Var, d1.i iVar) {
        ge.i.e(hVar, "backgroundDispatcher");
        ge.i.e(e1Var, "timeProvider");
        ge.i.e(iVar, "sessionConfigsDataStore");
        this.f15049a = e1Var;
        this.f15050b = iVar;
        this.f15051c = new AtomicReference();
        x.k(x.b(hVar), null, new l(this, null, 0), 3);
    }

    public final g a() throws Throwable {
        AtomicReference atomicReference = this.f15051c;
        if (atomicReference.get() == null) {
            Object objO = x.o(vd.i.f13722v, new l(this, null, 1));
            while (!atomicReference.compareAndSet(null, objO) && atomicReference.get() == null) {
            }
        }
        Object obj = atomicReference.get();
        ge.i.d(obj, "get(...)");
        return (g) obj;
    }

    public final boolean b() {
        Long l10 = a().f15038e;
        Integer num = a().f15037d;
        return l10 == null || num == null || this.f15049a.a().f13604c - l10.longValue() >= ((long) num.intValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(yc.g r5, xd.c r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof yc.m
            if (r0 == 0) goto L13
            r0 = r6
            yc.m r0 = (yc.m) r0
            int r1 = r0.A
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.A = r1
            goto L18
        L13:
            yc.m r0 = new yc.m
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f15047y
            int r1 = r0.A
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            com.bumptech.glide.c.C(r6)     // Catch: java.io.IOException -> L25
            goto L58
        L25:
            r5 = move-exception
            goto L45
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            com.bumptech.glide.c.C(r6)
            d1.i r6 = r4.f15050b     // Catch: java.io.IOException -> L25
            d1.p r1 = new d1.p     // Catch: java.io.IOException -> L25
            r3 = 0
            r1.<init>(r5, r3)     // Catch: java.io.IOException -> L25
            r0.A = r2     // Catch: java.io.IOException -> L25
            java.lang.Object r5 = r6.a(r1, r0)     // Catch: java.io.IOException -> L25
            wd.a r6 = wd.a.f14143v
            if (r5 != r6) goto L58
            return r6
        L45:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "Failed to update config values: "
            r6.<init>(r0)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "FirebaseSessions"
            android.util.Log.w(r6, r5)
        L58:
            rd.l r5 = rd.l.f11003a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: yc.n.c(yc.g, xd.c):java.lang.Object");
    }
}
