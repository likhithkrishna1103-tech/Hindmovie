package r4;

import android.net.Uri;
import android.view.InputEvent;
import d1.u;
import ge.i;
import pe.f0;
import pe.x;
import s4.d;
import s4.f;
import s4.g;
import w8.e;
import ya.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f10852a;

    public b(d dVar) {
        this.f10852a = dVar;
    }

    public w a(s4.a aVar) {
        i.e(aVar, "deletionRequest");
        throw null;
    }

    public w b() {
        return e.c(x.c(x.b(f0.f10232a), new a(this, null, 0)));
    }

    public w c(Uri uri, InputEvent inputEvent) {
        i.e(uri, "attributionSource");
        return e.c(x.c(x.b(f0.f10232a), new u(this, uri, inputEvent, null, 3)));
    }

    public w d(s4.e eVar) {
        i.e(eVar, "request");
        throw null;
    }

    public w e(Uri uri) {
        i.e(uri, "trigger");
        return e.c(x.c(x.b(f0.f10232a), new d1.e(this, uri, null, 4)));
    }

    public w f(f fVar) {
        i.e(fVar, "request");
        throw null;
    }

    public w g(g gVar) {
        i.e(gVar, "request");
        throw null;
    }
}
