package h;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f5514u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Context f5515v;

    public /* synthetic */ l(Context context, int i) {
        this.f5514u = i;
        this.f5515v = context;
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
            int r0 = r11.f5514u
            switch(r0) {
                case 0: goto L30;
                case 1: goto L14;
                default: goto L5;
            }
        L5:
            n4.b r0 = new n4.b
            r1 = 0
            r0.<init>(r1)
            k8.z r1 = o4.e.f9350a
            r2 = 0
            android.content.Context r3 = r11.f5515v
            o4.e.t(r3, r0, r1, r2)
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
            android.content.Context r2 = r11.f5515v
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
            android.content.Context r5 = r11.f5515v
            r3.<init>(r5, r4)
            android.content.pm.PackageManager r4 = r5.getPackageManager()
            int r4 = r4.getComponentEnabledSetting(r3)
            if (r4 == r1) goto Lb0
            java.lang.String r4 = "locale"
            if (r0 < r2) goto L89
            s.f r0 = h.q.A
            r0.getClass()
            s.a r2 = new s.a
            r2.<init>(r0)
        L58:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L77
            java.lang.Object r0 = r2.next()
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
            java.lang.Object r0 = r0.get()
            h.q r0 = (h.q) r0
            if (r0 == 0) goto L58
            h.b0 r0 = (h.b0) r0
            android.content.Context r0 = r0.E
            if (r0 == 0) goto L58
            java.lang.Object r0 = r0.getSystemService(r4)
            goto L78
        L77:
            r0 = 0
        L78:
            if (r0 == 0) goto L8e
            android.os.LocaleList r0 = h.n.a(r0)
            m0.g r2 = new m0.g
            m0.j r6 = new m0.j
            r6.<init>(r0)
            r2.<init>(r6)
            goto L90
        L89:
            m0.g r2 = h.q.f5552w
            if (r2 == 0) goto L8e
            goto L90
        L8e:
            m0.g r2 = m0.g.f8281b
        L90:
            m0.i r0 = r2.f8282a
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto La9
            java.lang.String r0 = e0.c.e(r5)
            java.lang.Object r2 = r5.getSystemService(r4)
            if (r2 == 0) goto La9
            android.os.LocaleList r0 = h.m.a(r0)
            h.n.b(r2, r0)
        La9:
            android.content.pm.PackageManager r0 = r5.getPackageManager()
            r0.setComponentEnabledSetting(r3, r1, r1)
        Lb0:
            h.q.f5555z = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h.l.run():void");
    }
}
