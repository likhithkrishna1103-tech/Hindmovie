package dd;

import android.os.Handler;
import b7.s;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f4154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f4155e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f4156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f4157h;

    public /* synthetic */ h(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        this.f4151a = obj;
        this.f4152b = obj2;
        this.f4153c = obj3;
        this.f4154d = obj4;
        this.f4155e = obj5;
        this.f = obj6;
        this.f4156g = obj7;
        this.f4157h = obj8;
    }

    public void a() {
        synchronized (this.f) {
        }
    }

    public void b() {
        id.k kVar = (id.k) this.f4151a;
        d dVar = (d) this.f4157h;
        be.h.e(dVar, "runnable");
        synchronized (kVar.f6586a) {
            if (!kVar.f6587b) {
                kVar.f6589d.postDelayed(dVar, 300000L);
            }
        }
    }

    public h(yc.c cVar, id.k kVar, Handler handler, a aVar, id.h hVar, s sVar, zc.g gVar) {
        be.h.e(handler, "uiHandler");
        be.h.e(aVar, "fetchHandler");
        be.h.e(hVar, "logger");
        this.f4151a = kVar;
        this.f4152b = handler;
        this.f4153c = aVar;
        this.f4154d = hVar;
        this.f4155e = sVar;
        this.f = new Object();
        this.f4156g = new LinkedHashSet();
        d dVar = new d(this);
        this.f4157h = dVar;
        kVar.d(new a5.e(3, this));
        synchronized (kVar.f6586a) {
            if (!kVar.f6587b) {
                kVar.f6589d.postDelayed(dVar, 300000L);
            }
        }
    }
}
