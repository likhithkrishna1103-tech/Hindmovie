package com.bumptech.glide.manager;

import androidx.media3.ui.AspectRatioFrameLayout;
import f9.x2;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f2274v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2275w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f2276x;

    public /* synthetic */ p(Object obj, boolean z10, int i) {
        this.f2274v = i;
        this.f2276x = obj;
        this.f2275w = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r9 = this;
            int r0 = r9.f2274v
            r1 = 0
            switch(r0) {
                case 0: goto L85;
                case 1: goto L79;
                case 2: goto L12;
                default: goto L6;
            }
        L6:
            r9.f2275w = r1
            java.lang.Object r0 = r9.f2276x
            androidx.media3.ui.AspectRatioFrameLayout r0 = (androidx.media3.ui.AspectRatioFrameLayout) r0
            int r1 = androidx.media3.ui.AspectRatioFrameLayout.f1282y
            r0.getClass()
            return
        L12:
            java.lang.Object r0 = r9.f2276x
            f9.x2 r0 = (f9.x2) r0
            java.lang.Object r2 = r0.f307w
            f9.r1 r2 = (f9.r1) r2
            boolean r3 = r2.a()
            java.lang.Boolean r4 = r2.T
            r5 = 1
            if (r4 == 0) goto L2d
            java.lang.Boolean r4 = r2.T
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L2d
            r4 = r5
            goto L2e
        L2d:
            r4 = r1
        L2e:
            boolean r6 = r9.f2275w
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
            r2.T = r7
            if (r4 != r6) goto L48
            f9.w0 r4 = r2.A
            f9.r1.g(r4)
            f9.u0 r4 = r4.J
            java.lang.String r7 = "Default data collection state already set to"
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r6)
            r4.b(r8, r7)
        L48:
            boolean r4 = r2.a()
            if (r4 == r3) goto L61
            boolean r4 = r2.a()
            java.lang.Boolean r7 = r2.T
            if (r7 == 0) goto L5f
            java.lang.Boolean r7 = r2.T
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L5f
            r1 = r5
        L5f:
            if (r4 == r1) goto L75
        L61:
            f9.w0 r1 = r2.A
            f9.r1.g(r1)
            f9.u0 r1 = r1.G
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r6)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            java.lang.String r4 = "Default data collection is different than actual status"
            r1.c(r2, r3, r4)
        L75:
            r0.E1()
            return
        L79:
            java.lang.Object r0 = r9.f2276x
            com.bumptech.glide.manager.t r0 = (com.bumptech.glide.manager.t) r0
            com.bumptech.glide.manager.n r0 = r0.f2284w
            boolean r1 = r9.f2275w
            r0.a(r1)
            return
        L85:
            java.lang.Object r0 = r9.f2276x
            com.bumptech.glide.manager.q r0 = (com.bumptech.glide.manager.q) r0
            boolean r1 = r9.f2275w
            s7.m.a()
            java.lang.Object r0 = r0.f2278b
            com.bumptech.glide.l r0 = (com.bumptech.glide.l) r0
            boolean r2 = r0.f2222v
            r0.f2222v = r1
            if (r2 == r1) goto L9f
            java.lang.Object r0 = r0.f2223w
            com.bumptech.glide.manager.n r0 = (com.bumptech.glide.manager.n) r0
            r0.a(r1)
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.manager.p.run():void");
    }

    public p(x2 x2Var, boolean z10) {
        this.f2274v = 2;
        this.f2275w = z10;
        Objects.requireNonNull(x2Var);
        this.f2276x = x2Var;
    }

    public p(AspectRatioFrameLayout aspectRatioFrameLayout) {
        this.f2274v = 3;
        this.f2276x = aspectRatioFrameLayout;
    }
}
