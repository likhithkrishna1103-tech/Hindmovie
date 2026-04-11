package z6;

import android.os.SystemClock;
import android.util.Log;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements g, f {
    public volatile d7.s A;
    public volatile d B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h f15254v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final k f15255w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile int f15256x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile c f15257y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile Object f15258z;

    public e0(h hVar, k kVar) {
        this.f15254v = hVar;
        this.f15255w = kVar;
    }

    @Override // z6.f
    public final void a(x6.e eVar, Exception exc, com.bumptech.glide.load.data.d dVar, int i) {
        this.f15255w.a(eVar, exc, dVar, this.A.f3509c.e());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    @Override // z6.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f15258z
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L20
            java.lang.Object r0 = r6.f15258z
            r6.f15258z = r1
            boolean r0 = r6.d(r0)     // Catch: java.io.IOException -> L11
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
            z6.c r0 = r6.f15257y
            if (r0 == 0) goto L2d
            z6.c r0 = r6.f15257y
            boolean r0 = r0.b()
            if (r0 == 0) goto L2d
        L2c:
            return r2
        L2d:
            r6.f15257y = r1
            r6.A = r1
            r0 = 0
        L32:
            if (r0 != 0) goto L92
            int r1 = r6.f15256x
            z6.h r3 = r6.f15254v
            java.util.ArrayList r3 = r3.b()
            int r3 = r3.size()
            if (r1 >= r3) goto L92
            z6.h r1 = r6.f15254v
            java.util.ArrayList r1 = r1.b()
            int r3 = r6.f15256x
            int r4 = r3 + 1
            r6.f15256x = r4
            java.lang.Object r1 = r1.get(r3)
            d7.s r1 = (d7.s) r1
            r6.A = r1
            d7.s r1 = r6.A
            if (r1 == 0) goto L32
            z6.h r1 = r6.f15254v
            z6.m r1 = r1.f15272p
            d7.s r3 = r6.A
            com.bumptech.glide.load.data.d r3 = r3.f3509c
            int r3 = r3.e()
            boolean r1 = r1.a(r3)
            if (r1 != 0) goto L7c
            z6.h r1 = r6.f15254v
            d7.s r3 = r6.A
            com.bumptech.glide.load.data.d r3 = r3.f3509c
            java.lang.Class r3 = r3.a()
            z6.z r1 = r1.c(r3)
            if (r1 == 0) goto L32
        L7c:
            d7.s r0 = r6.A
            d7.s r1 = r6.A
            com.bumptech.glide.load.data.d r1 = r1.f3509c
            z6.h r3 = r6.f15254v
            com.bumptech.glide.h r3 = r3.f15271o
            vb.b r4 = new vb.b
            r5 = 13
            r4.<init>(r5, r6, r0)
            r1.f(r3, r4)
            r0 = r2
            goto L32
        L92:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z6.e0.b():boolean");
    }

    @Override // z6.f
    public final void c(x6.e eVar, Object obj, com.bumptech.glide.load.data.d dVar, int i, x6.e eVar2) {
        this.f15255w.c(eVar, obj, dVar, this.A.f3509c.e(), eVar);
    }

    @Override // z6.g
    public final void cancel() {
        d7.s sVar = this.A;
        if (sVar != null) {
            sVar.f3509c.cancel();
        }
    }

    public final boolean d(Object obj) throws Throwable {
        Throwable th;
        int i = s7.h.f11599b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        boolean z10 = false;
        try {
            com.bumptech.glide.load.data.f fVarH = this.f15254v.f15261c.b().h(obj);
            Object objC = fVarH.c();
            x6.b bVarD = this.f15254v.d(objC);
            e eVar = new e(bVarD, objC, this.f15254v.i);
            x6.e eVar2 = this.A.f3507a;
            h hVar = this.f15254v;
            d dVar = new d(eVar2, hVar.f15270n);
            b7.a aVarA = hVar.f15265h.a();
            aVarA.h(dVar, eVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + dVar + ", data: " + obj + ", encoder: " + bVarD + ", duration: " + s7.h.a(jElapsedRealtimeNanos));
            }
            if (aVarA.f(dVar) != null) {
                this.B = dVar;
                this.f15257y = new c(Collections.singletonList(this.A.f3507a), this.f15254v, this);
                this.A.f3509c.b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.B + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.f15255w.c(this.A.f3507a, fVarH.c(), this.A.f3509c, this.A.f3509c.e(), this.A.f3507a);
                return false;
            } catch (Throwable th2) {
                th = th2;
                z10 = true;
                if (z10) {
                    throw th;
                }
                this.A.f3509c.b();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
