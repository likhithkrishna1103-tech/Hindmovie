package e6;

import android.os.SystemClock;
import android.util.Log;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g0 implements g, f {
    public volatile e A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final h f4500u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final k f4501v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile int f4502w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile d f4503x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile Object f4504y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile i6.q f4505z;

    public g0(h hVar, k kVar) {
        this.f4500u = hVar;
        this.f4501v = kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    @Override // e6.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f4504y
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L20
            java.lang.Object r0 = r7.f4504y
            r7.f4504y = r1
            boolean r0 = r7.d(r0)     // Catch: java.io.IOException -> L11
            if (r0 != 0) goto L20
            goto L2c
        L11:
            r0 = move-exception
            r3 = 3
            java.lang.String r4 = "SourceGenerator"
            boolean r3 = android.util.Log.isLoggable(r4, r3)
            if (r3 == 0) goto L20
            java.lang.String r3 = "Failed to properly rewind or write data to cache"
            android.util.Log.d(r4, r3, r0)
        L20:
            e6.d r0 = r7.f4503x
            if (r0 == 0) goto L2d
            e6.d r0 = r7.f4503x
            boolean r0 = r0.a()
            if (r0 == 0) goto L2d
        L2c:
            return r2
        L2d:
            r7.f4503x = r1
            r7.f4505z = r1
            r0 = 0
        L32:
            if (r0 != 0) goto L93
            int r1 = r7.f4502w
            e6.h r3 = r7.f4500u
            java.util.ArrayList r3 = r3.b()
            int r3 = r3.size()
            if (r1 >= r3) goto L93
            e6.h r1 = r7.f4500u
            java.util.ArrayList r1 = r1.b()
            int r3 = r7.f4502w
            int r4 = r3 + 1
            r7.f4502w = r4
            java.lang.Object r1 = r1.get(r3)
            i6.q r1 = (i6.q) r1
            r7.f4505z = r1
            i6.q r1 = r7.f4505z
            if (r1 == 0) goto L32
            e6.h r1 = r7.f4500u
            e6.m r1 = r1.f4519p
            i6.q r3 = r7.f4505z
            com.bumptech.glide.load.data.e r3 = r3.f6422c
            int r3 = r3.c()
            boolean r1 = r1.a(r3)
            if (r1 != 0) goto L7c
            e6.h r1 = r7.f4500u
            i6.q r3 = r7.f4505z
            com.bumptech.glide.load.data.e r3 = r3.f6422c
            java.lang.Class r3 = r3.a()
            e6.z r1 = r1.c(r3)
            if (r1 == 0) goto L32
        L7c:
            i6.q r0 = r7.f4505z
            i6.q r1 = r7.f4505z
            com.bumptech.glide.load.data.e r1 = r1.f6422c
            e6.h r3 = r7.f4500u
            com.bumptech.glide.f r3 = r3.f4518o
            h4.z r4 = new h4.z
            r5 = 13
            r6 = 0
            r4.<init>(r5, r7, r0, r6)
            r1.e(r3, r4)
            r0 = r2
            goto L32
        L93:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.g0.a():boolean");
    }

    @Override // e6.f
    public final void b(c6.f fVar, Object obj, com.bumptech.glide.load.data.e eVar, int i, c6.f fVar2) {
        this.f4501v.b(fVar, obj, eVar, this.f4505z.f6422c.c(), fVar);
    }

    @Override // e6.f
    public final void c(c6.f fVar, Exception exc, com.bumptech.glide.load.data.e eVar, int i) {
        this.f4501v.c(fVar, exc, eVar, this.f4505z.f6422c.c());
    }

    @Override // e6.g
    public final void cancel() {
        i6.q qVar = this.f4505z;
        if (qVar != null) {
            qVar.f6422c.cancel();
        }
    }

    public final boolean d(Object obj) throws Throwable {
        Throwable th;
        int i = x6.h.f14283b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        boolean z2 = false;
        try {
            com.bumptech.glide.load.data.g gVarH = this.f4500u.f4508c.b().h(obj);
            Object objA = gVarH.a();
            c6.b bVarD = this.f4500u.d(objA);
            a7.b bVar = new a7.b(bVarD, objA, this.f4500u.i, 14);
            c6.f fVar = this.f4505z.f6420a;
            h hVar = this.f4500u;
            e eVar = new e(fVar, hVar.f4517n);
            g6.a aVarA = hVar.f4512h.a();
            aVarA.b(eVar, bVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + eVar + ", data: " + obj + ", encoder: " + bVarD + ", duration: " + x6.h.a(jElapsedRealtimeNanos));
            }
            if (aVarA.f(eVar) != null) {
                this.A = eVar;
                this.f4503x = new d(Collections.singletonList(this.f4505z.f6420a), this.f4500u, this);
                this.f4505z.f6422c.b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.A + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.f4501v.b(this.f4505z.f6420a, gVarH.a(), this.f4505z.f6422c, this.f4505z.f6422c.c(), this.f4505z.f6420a);
                return false;
            } catch (Throwable th2) {
                th = th2;
                z2 = true;
                if (z2) {
                    throw th;
                }
                this.f4505z.f6422c.b();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
