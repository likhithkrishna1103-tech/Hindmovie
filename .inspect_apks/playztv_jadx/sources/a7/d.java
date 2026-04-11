package a7;

import android.content.Context;
import android.net.ConnectivityManager;
import b7.b0;
import b7.c0;
import b7.d0;
import b7.e0;
import b7.f;
import b7.f0;
import b7.g;
import b7.g0;
import b7.h;
import b7.i;
import b7.j;
import b7.j0;
import b7.k;
import b7.l;
import b7.m;
import b7.n;
import b7.o;
import b7.p;
import b7.q;
import b7.r;
import b7.t;
import b7.u;
import b7.w;
import b7.x;
import b7.z;
import d7.e;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u5.d f624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final URL f627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l7.a f628e;
    public final l7.a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f629g;

    public d(Context context, l7.a aVar, l7.a aVar2) {
        ib.d dVar = new ib.d();
        b7.c cVar = b7.c.f1842a;
        dVar.a(x.class, cVar);
        dVar.a(m.class, cVar);
        j jVar = j.f1869a;
        dVar.a(g0.class, jVar);
        dVar.a(u.class, jVar);
        b7.d dVar2 = b7.d.f1844a;
        dVar.a(z.class, dVar2);
        dVar.a(n.class, dVar2);
        b7.b bVar = b7.b.f1831a;
        dVar.a(b7.a.class, bVar);
        dVar.a(l.class, bVar);
        i iVar = i.f1859a;
        dVar.a(f0.class, iVar);
        dVar.a(t.class, iVar);
        b7.e eVar = b7.e.f1847a;
        dVar.a(b0.class, eVar);
        dVar.a(o.class, eVar);
        h hVar = h.f1855a;
        dVar.a(e0.class, hVar);
        dVar.a(r.class, hVar);
        g gVar = g.f1853a;
        dVar.a(d0.class, gVar);
        dVar.a(q.class, gVar);
        k kVar = k.f1876a;
        dVar.a(j0.class, kVar);
        dVar.a(w.class, kVar);
        f fVar = f.f1850a;
        dVar.a(c0.class, fVar);
        dVar.a(p.class, fVar);
        dVar.f6481d = true;
        this.f624a = new u5.d(17, dVar);
        this.f626c = context;
        this.f625b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f627d = b(a.f611c);
        this.f628e = aVar2;
        this.f = aVar;
        this.f629g = 130000;
    }

    public static URL b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException(l4.a.m("Invalid url: ", str), e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c7.i a(c7.i r7) {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a7.d.a(c7.i):c7.i");
    }
}
