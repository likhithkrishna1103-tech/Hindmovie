package q8;

import android.content.Context;
import android.os.Build;
import f9.c0;
import i2.k;
import j9.i;
import j9.p;
import m2.e;
import n8.r;
import o8.l;
import o8.m;
import o8.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final k i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f10450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f10451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n8.a f10452e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c0 f10453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n8.d f10454h;

    static {
        new c0(17);
        b bVar = new b();
        k kVar = new k();
        kVar.f6086w = "ClientTelemetry.API";
        kVar.f6085v = bVar;
        i = kVar;
    }

    public c(Context context, k kVar, m mVar, m8.b bVar) {
        u.h(context, "Null context is not permitted.");
        u.h(kVar, "Api must not be null.");
        u.h(bVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        u.h(applicationContext, "The provided context did not have an application context.");
        this.f10448a = applicationContext;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : null;
        this.f10449b = attributionTag;
        this.f10450c = kVar;
        this.f10451d = mVar;
        this.f10452e = new n8.a(kVar, mVar, attributionTag);
        n8.d dVarE = n8.d.e(applicationContext);
        this.f10454h = dVarE;
        this.f = dVarE.C.getAndIncrement();
        this.f10453g = bVar.f8388a;
        a9.k kVar2 = dVarE.H;
        kVar2.sendMessage(kVar2.obtainMessage(7, this));
    }

    public final p a(l lVar) {
        e eVar = new e();
        l8.d[] dVarArr = {y8.b.f14974a};
        eVar.f8050v = new l4.a(lVar);
        com.bumptech.glide.manager.u uVar = new com.bumptech.glide.manager.u(eVar, dVarArr, false);
        i iVar = new i();
        n8.d dVar = this.f10454h;
        dVar.getClass();
        n8.p pVar = new n8.p(new r(uVar, iVar, this.f10453g), dVar.D.get(), this);
        a9.k kVar = dVar.H;
        kVar.sendMessage(kVar.obtainMessage(4, pVar));
        return iVar.f6688a;
    }
}
