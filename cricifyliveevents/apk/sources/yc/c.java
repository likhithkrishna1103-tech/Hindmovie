package yc;

import vc.e1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements o {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f15024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ne.g f15025h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e1 f15026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.d f15027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vc.b f15028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f15029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f15030e;
    public final xe.c f;

    static {
        int i = oe.a.f9767y;
        f15024g = (int) oe.a.e(com.bumptech.glide.d.D(24, oe.c.HOURS), oe.c.SECONDS);
        f15025h = new ne.g("/");
    }

    public c(e1 e1Var, ic.d dVar, vc.b bVar, d dVar2, n nVar) {
        ge.i.e(e1Var, "timeProvider");
        ge.i.e(dVar, "firebaseInstallationsApi");
        ge.i.e(bVar, "appInfo");
        ge.i.e(dVar2, "configsFetcher");
        ge.i.e(nVar, "settingsCache");
        this.f15026a = e1Var;
        this.f15027b = dVar;
        this.f15028c = bVar;
        this.f15029d = dVar2;
        this.f15030e = nVar;
        this.f = xe.d.a();
    }

    @Override // yc.o
    public final Boolean a() {
        return this.f15030e.a().f15034a;
    }

    @Override // yc.o
    public final Double b() {
        return this.f15030e.a().f15035b;
    }

    @Override // yc.o
    public final oe.a c() {
        Integer num = this.f15030e.a().f15036c;
        if (num == null) {
            return null;
        }
        int i = oe.a.f9767y;
        return new oe.a(com.bumptech.glide.d.D(num.intValue(), oe.c.SECONDS));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b3 A[Catch: all -> 0x0054, TRY_LEAVE, TryCatch #0 {all -> 0x0054, blocks: (B:21:0x0050, B:43:0x00a9, B:45:0x00b3, B:48:0x00bc, B:50:0x0139, B:51:0x0145, B:35:0x0086, B:37:0x008e, B:40:0x0097), top: B:62:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bc A[Catch: all -> 0x0054, TRY_ENTER, TryCatch #0 {all -> 0x0054, blocks: (B:21:0x0050, B:43:0x00a9, B:45:0x00b3, B:48:0x00bc, B:50:0x0139, B:51:0x0145, B:35:0x0086, B:37:0x008e, B:40:0x0097), top: B:62:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    @Override // yc.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(vd.c r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: yc.c.d(vd.c):java.lang.Object");
    }
}
