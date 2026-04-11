package h;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f5364v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Context f5365w;

    public /* synthetic */ l(Context context, int i) {
        this.f5364v = i;
        this.f5365w = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r11 = this;
            int r0 = r11.f5364v
            switch(r0) {
                case 0: goto L30;
                case 1: goto L14;
                default: goto L5;
            }
        L5:
            p.a r0 = new p.a
            r1 = 1
            r0.<init>(r1)
            f9.z r1 = t4.c.f11913a
            r2 = 0
            android.content.Context r3 = r11.f5365w
            t4.c.t(r3, r0, r1, r2)
            return
        L14:
            java.util.concurrent.ThreadPoolExecutor r4 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.LinkedBlockingQueue r10 = new java.util.concurrent.LinkedBlockingQueue
            r10.<init>()
            r5 = 0
            r6 = 1
            r7 = 0
            r4.<init>(r5, r6, r7, r9, r10)
            h.l r0 = new h.l
            r1 = 2
            android.content.Context r2 = r11.f5365w
            r0.<init>(r2, r1)
            r4.execute(r0)
            return
        L30:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 33
            if (r0 < r2) goto Lb0
            android.content.ComponentName r3 = new android.content.ComponentName
            java.lang.String r4 = "androidx.appcompat.app.AppLocalesMetadataHolderService"
            android.content.Context r5 = r11.f5365w
            r3.<init>(r5, r4)
            android.content.pm.PackageManager r4 = r5.getPackageManager()
            int r4 = r4.getComponentEnabledSetting(r3)
            if (r4 == r1) goto Lb0
            java.lang.String r4 = "locale"
            if (r0 < r2) goto L89
            v.f r0 = h.p.B
            r0.getClass()
            v.a r2 = new v.a
            r2.<init>(r0)
        L58:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L77
            java.lang.Object r0 = r2.next()
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
            java.lang.Object r0 = r0.get()
            h.p r0 = (h.p) r0
            if (r0 == 0) goto L58
            h.a0 r0 = (h.a0) r0
            android.content.Context r0 = r0.F
            if (r0 == 0) goto L58
            java.lang.Object r0 = r0.getSystemService(r4)
            goto L78
        L77:
            r0 = 0
        L78:
            if (r0 == 0) goto L8e
            android.os.LocaleList r0 = h.n.a(r0)
            p0.g r2 = new p0.g
            p0.j r6 = new p0.j
            r6.<init>(r0)
            r2.<init>(r6)
            goto L90
        L89:
            p0.g r2 = h.p.f5396x
            if (r2 == 0) goto L8e
            goto L90
        L8e:
            p0.g r2 = p0.g.f9873b
        L90:
            p0.i r0 = r2.f9874a
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto La9
            java.lang.String r0 = h0.c.e(r5)
            java.lang.Object r2 = r5.getSystemService(r4)
            if (r2 == 0) goto La9
            android.os.LocaleList r0 = h.m.a(r0)
            h.n.b(r2, r0)
        La9:
            android.content.pm.PackageManager r0 = r5.getPackageManager()
            r0.setComponentEnabledSetting(r3, r1, r1)
        Lb0:
            h.p.A = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.l.run():void");
    }
}
