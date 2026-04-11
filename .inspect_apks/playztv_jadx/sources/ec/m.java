package ec;

import cc.e0;
import ke.x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c1.d f4670c = new c1.d("firebase_sessions_enabled");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c1.d f4671d = new c1.d("firebase_sessions_sampling_rate");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c1.d f4672e = new c1.d("firebase_sessions_restart_timeout");
    public static final c1.d f = new c1.d("firebase_sessions_cache_duration");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c1.d f4673g = new c1.d("firebase_sessions_cache_updated_time");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z0.f f4674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f4675b;

    public m(z0.f fVar) throws Throwable {
        this.f4674a = fVar;
        x.m(rd.i.f11572u, new e0(this, null, 2));
    }

    public static final void a(m mVar, c1.b bVar) {
        mVar.getClass();
        mVar.f4675b = new f((Boolean) bVar.a(f4670c), (Double) bVar.a(f4671d), (Integer) bVar.a(f4672e), (Integer) bVar.a(f), (Long) bVar.a(f4673g));
    }

    public final boolean b() {
        f fVar = this.f4675b;
        if (fVar == null) {
            be.h.i("sessionConfigs");
            throw null;
        }
        Long l10 = fVar.f4655e;
        if (fVar != null) {
            Integer num = fVar.f4654d;
            return l10 == null || num == null || (System.currentTimeMillis() - l10.longValue()) / ((long) 1000) >= ((long) num.intValue());
        }
        be.h.i("sessionConfigs");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(c1.d r5, java.lang.Object r6, td.c r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ec.k
            if (r0 == 0) goto L13
            r0 = r7
            ec.k r0 = (ec.k) r0
            int r1 = r0.f4667z
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f4667z = r1
            goto L18
        L13:
            ec.k r0 = new ec.k
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f4665x
            int r1 = r0.f4667z
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            i5.a.Q(r7)     // Catch: java.io.IOException -> L25
            goto L5e
        L25:
            r5 = move-exception
            goto L4b
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            i5.a.Q(r7)
            z0.f r7 = r4.f4674a     // Catch: java.io.IOException -> L25
            ec.l r1 = new ec.l     // Catch: java.io.IOException -> L25
            r3 = 0
            r1.<init>(r6, r5, r4, r3)     // Catch: java.io.IOException -> L25
            r0.f4667z = r2     // Catch: java.io.IOException -> L25
            c1.c r5 = new c1.c     // Catch: java.io.IOException -> L25
            r6 = 1
            r5.<init>(r1, r3, r6)     // Catch: java.io.IOException -> L25
            java.lang.Object r5 = r7.r(r5, r0)     // Catch: java.io.IOException -> L25
            sd.a r6 = sd.a.f11942u
            if (r5 != r6) goto L5e
            return r6
        L4b:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Failed to update cache config value: "
            r6.<init>(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "SettingsCache"
            android.util.Log.w(r6, r5)
        L5e:
            nd.k r5 = nd.k.f8990a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ec.m.c(c1.d, java.lang.Object, td.c):java.lang.Object");
    }
}
