package p1;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Uri f10066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f10068c = new w();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public z f10069d = new z();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f10070e = Collections.EMPTY_LIST;
    public final aa.j0 f = aa.c1.f650y;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e2.t f10072h = new e2.t();
    public final d0 i = d0.f9694d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f10071g = -9223372036854775807L;

    public final g0 a() {
        c0 c0Var;
        z zVar = this.f10069d;
        s1.d.g(zVar.f10114b == null || zVar.f10113a != null);
        Uri uri = this.f10066a;
        if (uri != null) {
            String str = this.f10067b;
            z zVar2 = this.f10069d;
            c0Var = new c0(uri, str, zVar2.f10113a != null ? new a0(zVar2) : null, null, this.f10070e, null, this.f, this.f10071g);
        } else {
            c0Var = null;
        }
        w wVar = this.f10068c;
        wVar.getClass();
        y yVar = new y(wVar);
        e2.t tVar = this.f10072h;
        tVar.getClass();
        return new g0("", yVar, c0Var, new b0(tVar), j0.K, this.i);
    }

    public final void b(a0 a0Var) {
        this.f10069d = a0Var.a();
    }
}
