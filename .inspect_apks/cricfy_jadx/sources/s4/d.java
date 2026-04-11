package s4;

import android.adservices.measurement.MeasurementManager;
import android.net.Uri;
import android.view.InputEvent;
import d1.q;
import ge.i;
import pe.h;
import rd.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MeasurementManager f11469a;

    public d(MeasurementManager measurementManager) {
        i.e(measurementManager, "mMeasurementManager");
        this.f11469a = measurementManager;
    }

    public static Object b(d dVar, a aVar, vd.c cVar) {
        new h(1, u8.a.t(cVar)).w();
        MeasurementManager measurementManager = dVar.f11469a;
        throw null;
    }

    public static Object d(d dVar, vd.c cVar) {
        h hVar = new h(1, u8.a.t(cVar));
        hVar.w();
        dVar.f11469a.getMeasurementApiStatus(new p.a(1), new p0.e(hVar));
        return hVar.v();
    }

    public static Object g(d dVar, Uri uri, InputEvent inputEvent, vd.c cVar) throws Throwable {
        h hVar = new h(1, u8.a.t(cVar));
        hVar.w();
        dVar.f11469a.registerSource(uri, inputEvent, new p.a(1), new p0.e(hVar));
        Object objV = hVar.v();
        return objV == wd.a.f14143v ? objV : l.f11003a;
    }

    public static Object h(d dVar, e eVar, vd.c cVar) throws Throwable {
        q qVar = new q(dVar, null, 2);
        ue.q qVar2 = new ue.q(cVar, cVar.h());
        Object objR = a.a.r(qVar2, qVar2, qVar);
        return objR == wd.a.f14143v ? objR : l.f11003a;
    }

    public static Object j(d dVar, Uri uri, vd.c cVar) throws Throwable {
        h hVar = new h(1, u8.a.t(cVar));
        hVar.w();
        dVar.f11469a.registerTrigger(uri, new p.a(1), new p0.e(hVar));
        Object objV = hVar.v();
        return objV == wd.a.f14143v ? objV : l.f11003a;
    }

    public static Object l(d dVar, f fVar, vd.c cVar) {
        new h(1, u8.a.t(cVar)).w();
        MeasurementManager measurementManager = dVar.f11469a;
        throw null;
    }

    public static Object n(d dVar, g gVar, vd.c cVar) {
        new h(1, u8.a.t(cVar)).w();
        MeasurementManager measurementManager = dVar.f11469a;
        throw null;
    }

    public Object a(a aVar, vd.c cVar) {
        return b(this, aVar, cVar);
    }

    public Object c(vd.c cVar) {
        return d(this, cVar);
    }

    public Object e(Uri uri, InputEvent inputEvent, vd.c cVar) {
        return g(this, uri, inputEvent, cVar);
    }

    public Object f(e eVar, vd.c cVar) {
        return h(this, eVar, cVar);
    }

    public Object i(Uri uri, vd.c cVar) {
        return j(this, uri, cVar);
    }

    public Object k(f fVar, vd.c cVar) {
        return l(this, fVar, cVar);
    }

    public Object m(g gVar, vd.c cVar) {
        return n(this, gVar, cVar);
    }
}
