package vc;

import android.util.Log;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yc.j f13567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0 f13568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n0 f13569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e1 f13570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d1.i f13571e;
    public final c0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vd.h f13572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g0 f13573h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13574j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f13575k;

    public a1(yc.j jVar, r0 r0Var, n0 n0Var, e1 e1Var, d1.i iVar, c0 c0Var, vd.h hVar) {
        ge.i.e(jVar, "sessionsSettings");
        ge.i.e(r0Var, "sessionGenerator");
        ge.i.e(n0Var, "sessionFirelogPublisher");
        ge.i.e(e1Var, "timeProvider");
        ge.i.e(iVar, "sessionDataStore");
        ge.i.e(c0Var, "processDataManager");
        ge.i.e(hVar, "backgroundDispatcher");
        this.f13567a = jVar;
        this.f13568b = r0Var;
        this.f13569c = n0Var;
        this.f13570d = e1Var;
        this.f13571e = iVar;
        this.f = c0Var;
        this.f13572g = hVar;
        this.f13575k = "";
        pe.x.k(pe.x.b(hVar), null, new w0(this, null, 0), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(vc.a1 r4, java.lang.String r5, vc.x0 r6, vd.c r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: vc.a1.a(vc.a1, java.lang.String, vc.x0, vd.c):java.lang.Object");
    }

    public final void b() {
        this.i = false;
        if (this.f13573h == null) {
            Log.d("FirebaseSessions", "App backgrounded, but local SessionData not initialized");
            return;
        }
        Log.d("FirebaseSessions", "App backgrounded on " + this.f.a());
        pe.x.k(pe.x.b(this.f13572g), null, new w0(this, null, 1), 3);
    }

    public final void c() {
        this.i = true;
        g0 g0Var = this.f13573h;
        if (g0Var == null) {
            this.f13574j = true;
            Log.d("FirebaseSessions", "App foregrounded, but local SessionData not initialized");
            return;
        }
        vd.c cVar = null;
        if (g0Var == null) {
            ge.i.i("localSessionData");
            throw null;
        }
        Log.d("FirebaseSessions", "App foregrounded on " + this.f.a());
        if (e(g0Var) || d(g0Var)) {
            pe.x.k(pe.x.b(this.f13572g), null, new d1.e(this, g0Var, cVar, 10), 3);
        }
    }

    public final boolean d(g0 g0Var) {
        Map map = g0Var.f13624c;
        boolean z10 = true;
        c0 c0Var = this.f;
        if (map == null) {
            Log.d("FirebaseSessions", "No process data for " + c0Var.a());
            return true;
        }
        c0Var.getClass();
        a0 a0Var = (a0) map.get(c0Var.a());
        if (a0Var != null && a0Var.f13565a == c0Var.f13589c && ge.i.a(a0Var.f13566b, (String) c0Var.f13590d.getValue())) {
            z10 = false;
        }
        if (z10) {
            Log.d("FirebaseSessions", "Process " + c0Var.a() + " is stale");
        }
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(vc.g0 r12) {
        /*
            r11 = this;
            vc.d1 r0 = r12.f13623b
            vc.k0 r12 = r12.f13622a
            java.lang.String r1 = "Session "
            java.lang.String r2 = "FirebaseSessions"
            r3 = 0
            if (r0 == 0) goto L74
            vc.e1 r4 = r11.f13570d
            vc.d1 r4 = r4.a()
            int r5 = oe.a.f9767y
            long r4 = r4.f13602a
            long r6 = r0.f13602a
            long r4 = r4 - r6
            oe.c r0 = oe.c.MILLISECONDS
            long r4 = com.bumptech.glide.d.E(r4, r0)
            yc.j r0 = r11.f13567a
            yc.o r6 = r0.f15043a
            oe.a r6 = r6.c()
            r7 = 0
            if (r6 == 0) goto L37
            long r9 = r6.f9768v
            int r6 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r6 <= 0) goto L37
            boolean r6 = oe.a.d(r9)
            if (r6 != 0) goto L37
            goto L54
        L37:
            yc.o r0 = r0.f15044b
            oe.a r0 = r0.c()
            if (r0 == 0) goto L4c
            long r9 = r0.f9768v
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 <= 0) goto L4c
            boolean r0 = oe.a.d(r9)
            if (r0 != 0) goto L4c
            goto L54
        L4c:
            r0 = 30
            oe.c r6 = oe.c.MINUTES
            long r9 = com.bumptech.glide.d.D(r0, r6)
        L54:
            int r0 = oe.a.c(r4, r9)
            if (r0 <= 0) goto L5b
            r3 = 1
        L5b:
            if (r3 == 0) goto L73
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r1)
            java.lang.String r12 = r12.f13656a
            r0.append(r12)
            java.lang.String r12 = " is expired"
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            android.util.Log.d(r2, r12)
        L73:
            return r3
        L74:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r1)
            java.lang.String r12 = r12.f13656a
            r0.append(r12)
            java.lang.String r12 = " has not backgrounded yet"
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            android.util.Log.d(r2, r12)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: vc.a1.e(vc.g0):boolean");
    }
}
