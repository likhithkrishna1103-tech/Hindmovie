package m4;

import android.net.Uri;
import android.view.InputEvent;
import be.h;
import cc.e0;
import cc.w;
import cf.l;
import ea.y;
import ke.f0;
import ke.x;
import n4.c;
import n4.d;
import n4.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f8307a;

    public a(c cVar) {
        this.f8307a = cVar;
    }

    public y a(n4.a aVar) {
        h.e(aVar, "deletionRequest");
        throw null;
    }

    public y b() {
        return l.c(x.b(x.a(f0.f7690a), new w(this, null, 2)));
    }

    public y c(Uri uri, InputEvent inputEvent) {
        h.e(uri, "attributionSource");
        return l.c(x.b(x.a(f0.f7690a), new cc.l(this, uri, inputEvent, null, 1)));
    }

    public y d(Uri uri) {
        h.e(uri, "trigger");
        return l.c(x.b(x.a(f0.f7690a), new e0(this, uri, null, 3)));
    }

    public y e(d dVar) {
        h.e(dVar, "request");
        throw null;
    }

    public y f(e eVar) {
        h.e(eVar, "request");
        throw null;
    }
}
