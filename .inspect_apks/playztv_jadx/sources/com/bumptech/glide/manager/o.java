package com.bumptech.glide.manager;

import androidx.media3.ui.AspectRatioFrameLayout;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2846u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2847v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f2848w;

    public /* synthetic */ o(Object obj, boolean z2, int i) {
        this.f2846u = i;
        this.f2848w = obj;
        this.f2847v = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r8 = this;
            int r0 = r8.f2846u
            r1 = 0
            switch(r0) {
                case 0: goto La1;
                case 1: goto L95;
                case 2: goto L89;
                default: goto L6;
            }
        L6:
            java.lang.Object r0 = r8.f2848w
            k8.g2 r0 = (k8.g2) r0
            java.lang.Object r2 = r0.f2454v
            k8.k1 r2 = (k8.k1) r2
            boolean r2 = r2.h()
            java.lang.Object r3 = r0.f2454v
            k8.k1 r3 = (k8.k1) r3
            java.lang.Boolean r4 = r3.U
            r5 = 1
            if (r4 == 0) goto L25
            java.lang.Boolean r3 = r3.U
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L25
            r3 = r5
            goto L26
        L25:
            r3 = r1
        L26:
            java.lang.Object r4 = r0.f2454v
            k8.k1 r4 = (k8.k1) r4
            boolean r6 = r8.f2847v
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
            r4.U = r7
            if (r3 != r6) goto L48
            java.lang.Object r3 = r0.f2454v
            k8.k1 r3 = (k8.k1) r3
            k8.p0 r3 = r3.C
            k8.k1.f(r3)
            k8.r0 r3 = r3.I
            java.lang.String r4 = "Default data collection state already set to"
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
            r3.c(r7, r4)
        L48:
            java.lang.Object r3 = r0.f2454v
            k8.k1 r3 = (k8.k1) r3
            boolean r3 = r3.h()
            if (r3 == r2) goto L6d
            java.lang.Object r3 = r0.f2454v
            k8.k1 r3 = (k8.k1) r3
            boolean r3 = r3.h()
            java.lang.Object r4 = r0.f2454v
            k8.k1 r4 = (k8.k1) r4
            java.lang.Boolean r7 = r4.U
            if (r7 == 0) goto L6b
            java.lang.Boolean r4 = r4.U
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L6b
            r1 = r5
        L6b:
            if (r3 == r1) goto L85
        L6d:
            java.lang.Object r1 = r0.f2454v
            k8.k1 r1 = (k8.k1) r1
            k8.p0 r1 = r1.C
            k8.k1.f(r1)
            k8.r0 r1 = r1.F
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r6)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r4 = "Default data collection is different than actual status"
            r1.b(r3, r2, r4)
        L85:
            r0.Q1()
            return
        L89:
            r8.f2847v = r1
            java.lang.Object r0 = r8.f2848w
            androidx.media3.ui.AspectRatioFrameLayout r0 = (androidx.media3.ui.AspectRatioFrameLayout) r0
            int r1 = androidx.media3.ui.AspectRatioFrameLayout.f1589x
            r0.getClass()
            return
        L95:
            java.lang.Object r0 = r8.f2848w
            com.bumptech.glide.manager.r r0 = (com.bumptech.glide.manager.r) r0
            com.bumptech.glide.manager.m r0 = r0.f2854v
            boolean r1 = r8.f2847v
            r0.a(r1)
            return
        La1:
            java.lang.Object r0 = r8.f2848w
            com.bumptech.glide.manager.p r0 = (com.bumptech.glide.manager.p) r0
            boolean r1 = r8.f2847v
            x6.m.a()
            java.lang.Object r0 = r0.f2850b
            a2.c r0 = (a2.c) r0
            boolean r2 = r0.f172u
            r0.f172u = r1
            if (r2 == r1) goto Lbb
            java.lang.Object r0 = r0.f173v
            com.bumptech.glide.manager.m r0 = (com.bumptech.glide.manager.m) r0
            r0.a(r1)
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.manager.o.run():void");
    }

    public o(AspectRatioFrameLayout aspectRatioFrameLayout) {
        this.f2846u = 2;
        this.f2848w = aspectRatioFrameLayout;
    }
}
