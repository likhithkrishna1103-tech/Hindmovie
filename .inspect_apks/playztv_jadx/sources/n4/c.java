package n4;

import android.adservices.measurement.MeasurementManager;
import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import be.h;
import ke.g;
import nd.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MeasurementManager f8687a;

    public c(Context context) {
        h.e(context, "context");
        Object systemService = context.getSystemService((Class<Object>) c.a.g());
        h.d(systemService, "context.getSystemService…:class.java\n            )");
        this.f8687a = c.a.e(systemService);
    }

    public Object a(a aVar, rd.c cVar) {
        new g(1, a.a.w(cVar)).v();
        c.a.h();
        throw null;
    }

    public Object b(rd.c cVar) {
        g gVar = new g(1, a.a.w(cVar));
        gVar.v();
        this.f8687a.getMeasurementApiStatus(new b(0), new m0.e(gVar));
        return gVar.u();
    }

    public Object c(Uri uri, InputEvent inputEvent, rd.c cVar) {
        g gVar = new g(1, a.a.w(cVar));
        gVar.v();
        this.f8687a.registerSource(uri, inputEvent, new b(0), new m0.e(gVar));
        Object objU = gVar.u();
        return objU == sd.a.f11942u ? objU : k.f8990a;
    }

    public Object d(Uri uri, rd.c cVar) throws Throwable {
        g gVar = new g(1, a.a.w(cVar));
        gVar.v();
        this.f8687a.registerTrigger(uri, new b(0), new m0.e(gVar));
        Object objU = gVar.u();
        return objU == sd.a.f11942u ? objU : k.f8990a;
    }

    public Object e(d dVar, rd.c cVar) {
        new g(1, a.a.w(cVar)).v();
        c.a.o();
        throw null;
    }

    public Object f(e eVar, rd.c cVar) {
        new g(1, a.a.w(cVar)).v();
        c.a.q();
        throw null;
    }
}
