package v1;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Uri f12994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f12996c = new v();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y f12997d = new y();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f12998e = Collections.EMPTY_LIST;
    public final ua.i0 f = ua.z0.f12413z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k2.t f13000h = new k2.t();
    public final d0 i = d0.f12622d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f12999g = -9223372036854775807L;

    public final g0 a() {
        c0 c0Var;
        y yVar = this.f12997d;
        y1.d.g(yVar.f13038b == null || yVar.f13037a != null);
        Uri uri = this.f12994a;
        if (uri != null) {
            String str = this.f12995b;
            y yVar2 = this.f12997d;
            c0Var = new c0(uri, str, yVar2.f13037a != null ? new z(yVar2) : null, null, this.f12998e, null, this.f, this.f12999g);
        } else {
            c0Var = null;
        }
        v vVar = this.f12996c;
        vVar.getClass();
        x xVar = new x(vVar);
        k2.t tVar = this.f13000h;
        tVar.getClass();
        return new g0("", xVar, c0Var, new a0(tVar), j0.K, this.i);
    }

    public final void b(z zVar) {
        this.f12997d = zVar.a();
    }
}
