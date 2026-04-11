package v7;

import android.content.Context;
import android.net.ConnectivityManager;
import cc.d;
import java.net.MalformedURLException;
import java.net.URL;
import p6.c;
import w7.a0;
import w7.b0;
import w7.c0;
import w7.d0;
import w7.e0;
import w7.f;
import w7.f0;
import w7.g;
import w7.h;
import w7.i;
import w7.i0;
import w7.j;
import w7.k;
import w7.l;
import w7.m;
import w7.n;
import w7.o;
import w7.p;
import w7.q;
import w7.r;
import w7.s;
import w7.t;
import w7.v;
import w7.w;
import w7.y;
import y7.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f13501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f13502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f13503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final URL f13504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g8.a f13505e;
    public final g8.a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f13506g;

    public b(Context context, g8.a aVar, g8.a aVar2) {
        d dVar = new d();
        w7.c cVar = w7.c.f14037a;
        dVar.a(w.class, cVar);
        dVar.a(m.class, cVar);
        j jVar = j.f14064a;
        dVar.a(f0.class, jVar);
        dVar.a(t.class, jVar);
        w7.d dVar2 = w7.d.f14039a;
        dVar.a(y.class, dVar2);
        dVar.a(n.class, dVar2);
        w7.b bVar = w7.b.f14026a;
        dVar.a(w7.a.class, bVar);
        dVar.a(l.class, bVar);
        i iVar = i.f14056a;
        dVar.a(e0.class, iVar);
        dVar.a(s.class, iVar);
        w7.e eVar = w7.e.f14042a;
        dVar.a(a0.class, eVar);
        dVar.a(o.class, eVar);
        h hVar = h.f14052a;
        dVar.a(d0.class, hVar);
        dVar.a(r.class, hVar);
        g gVar = g.f14048a;
        dVar.a(c0.class, gVar);
        dVar.a(q.class, gVar);
        k kVar = k.f14073a;
        dVar.a(i0.class, kVar);
        dVar.a(v.class, kVar);
        f fVar = f.f14045a;
        dVar.a(b0.class, fVar);
        dVar.a(p.class, fVar);
        dVar.f2136d = true;
        this.f13501a = new c(6, dVar);
        this.f13503c = context;
        this.f13502b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f13504d = b(a.f13496c);
        this.f13505e = aVar2;
        this.f = aVar;
        this.f13506g = 130000;
    }

    public static URL b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e9) {
            throw new IllegalArgumentException(q4.a.n("Invalid url: ", str), e9);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final x7.h a(x7.h r7) {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v7.b.a(x7.h):x7.h");
    }
}
