package dd;

import a2.y0;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.DocumentsContract;
import b7.s;
import h4.z;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import n.q3;
import od.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Closeable {
    public final yc.h A;
    public final int B;
    public final LinkedHashSet C;
    public volatile boolean D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final zc.g f4129u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final bd.a f4130v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ed.d f4131w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final id.h f4132x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final s f4133y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final z f4134z;

    public a(zc.g gVar, bd.a aVar, ed.d dVar, id.h hVar, id.e eVar, yc.d dVar2, s sVar, Handler handler, z zVar, a7.b bVar, yc.h hVar2) {
        be.h.e(hVar, "logger");
        be.h.e(eVar, "httpDownloader");
        be.h.e(dVar2, "fileServerDownloader");
        be.h.e(handler, "uiHandler");
        be.h.e(hVar2, "prioritySort");
        this.f4129u = gVar;
        this.f4130v = aVar;
        this.f4131w = dVar;
        this.f4132x = hVar;
        this.f4133y = sVar;
        this.f4134z = zVar;
        this.A = hVar2;
        this.B = UUID.randomUUID().hashCode();
        this.C = new LinkedHashSet();
    }

    public final boolean F(zc.e eVar) throws IOException {
        yc.k kVar = yc.k.A;
        yc.a aVar = yc.a.f14642x;
        yc.k kVar2 = yc.k.f14689x;
        id.h hVar = this.f4132x;
        z zVar = this.f4134z;
        a(android.support.v4.media.session.b.G(eVar));
        zc.g gVar = this.f4129u;
        zc.e eVarA = gVar.a(eVar.f14953x);
        if (eVarA != null) {
            a(android.support.v4.media.session.b.G(eVarA));
            eVarA = gVar.a(eVar.f14953x);
            if (eVarA == null || eVarA.D != yc.k.f14690y) {
                if ((eVarA != null ? eVarA.D : null) == kVar && eVar.I == yc.a.f14644z && !zVar.a0(eVarA.f14953x)) {
                    try {
                        synchronized (gVar.f14963v) {
                            gVar.f14962u.d(eVarA);
                        }
                    } catch (Exception e10) {
                        e10.getMessage();
                        hVar.getClass();
                    }
                    if (eVar.I != aVar) {
                        zVar.I(eVar.f14953x, false);
                    }
                    eVarA = null;
                }
            } else {
                eVarA.D = kVar2;
                try {
                    gVar.G(eVarA);
                } catch (Exception e11) {
                    e11.getMessage();
                    hVar.getClass();
                }
            }
        } else if (eVar.I != aVar) {
            zVar.I(eVar.f14953x, false);
        }
        int iOrdinal = eVar.I.ordinal();
        if (iOrdinal == 0) {
            if (eVarA != null) {
                d(android.support.v4.media.session.b.G(eVarA));
            }
            d(android.support.v4.media.session.b.G(eVar));
            return false;
        }
        if (iOrdinal == 1) {
            zVar.I(eVar.f14953x, true);
            eVar.g(eVar.f14953x);
            String str = eVar.f14952w;
            String str2 = eVar.f14953x;
            be.h.e(str, "url");
            be.h.e(str2, "file");
            eVar.f14950u = str2.hashCode() + (str.hashCode() * 31);
            return false;
        }
        if (iOrdinal == 2) {
            if (eVarA == null) {
                return false;
            }
            throw new y0("request_with_file_path_already_exist");
        }
        if (iOrdinal != 3) {
            throw new y0();
        }
        if (eVarA == null) {
            return false;
        }
        eVar.B = eVarA.B;
        eVar.C = eVarA.C;
        eVar.e(eVarA.E);
        yc.k kVar3 = eVarA.D;
        be.h.e(kVar3, "<set-?>");
        eVar.D = kVar3;
        if (kVar3 != kVar) {
            eVar.D = kVar2;
            eVar.e(hd.a.f6071d);
        }
        if (eVar.D == kVar && !zVar.a0(eVar.f14953x)) {
            zVar.I(eVar.f14953x, false);
            eVar.B = 0L;
            eVar.C = -1L;
            eVar.D = kVar2;
            eVar.e(hd.a.f6071d);
        }
        return true;
    }

    public final void G() {
        ed.d dVar = this.f4131w;
        synchronized (dVar.B) {
            dVar.f4681u.d(new b(dVar, 1, "LibGlobalFetchLib"));
        }
        if (this.f4131w.E && !this.D) {
            this.f4131w.F();
        }
        if (!this.f4131w.D || this.D) {
            return;
        }
        this.f4131w.x();
    }

    public final void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zc.e eVar = (zc.e) it.next();
            bd.a aVar = this.f4130v;
            int i = eVar.f14950u;
            synchronized (aVar.D) {
                aVar.x(i);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.D) {
            return;
        }
        this.D = true;
        synchronized (this.C) {
            try {
                Iterator it = this.C.iterator();
                while (it.hasNext()) {
                    this.f4133y.g(this.B, (p) it.next());
                }
                this.C.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f4131w.G();
        this.f4131w.close();
        this.f4130v.close();
        j.a();
    }

    public final void d(List list) throws FileNotFoundException {
        a(list);
        zc.g gVar = this.f4129u;
        synchronized (gVar.f14963v) {
            gVar.f14962u.a(list);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zc.e eVar = (zc.e) it.next();
            yc.k kVar = yc.k.E;
            eVar.getClass();
            eVar.D = kVar;
            z zVar = this.f4134z;
            String str = eVar.f14953x;
            be.h.e(str, "file");
            Context context = (Context) zVar.f5867v;
            be.h.e(context, "context");
            if (android.support.v4.media.session.b.F(str)) {
                Uri uri = Uri.parse(str);
                String scheme = uri.getScheme();
                if (scheme != null) {
                    int iHashCode = scheme.hashCode();
                    if (iHashCode != 3143036) {
                        if (iHashCode == 951530617 && scheme.equals("content")) {
                            if (DocumentsContract.isDocumentUri(context, uri)) {
                                DocumentsContract.deleteDocument(context.getContentResolver(), uri);
                            } else {
                                context.getContentResolver().delete(uri, null, null);
                            }
                        }
                    } else if (scheme.equals("file")) {
                        File file = new File(String.valueOf(uri.getPath()));
                        if (file.canWrite() && file.exists() && file.exists() && file.canWrite()) {
                            file.delete();
                        }
                    }
                }
            } else {
                File file2 = new File(str);
                if (file2.exists() && file2.canWrite()) {
                    file2.delete();
                }
            }
            rc.b bVarV = gVar.v();
            if (bVarV != null) {
                z zVar2 = ((yc.c) ((q3) bVarV.f11562v).f8507u).f;
                a.a.p(eVar, "GET");
                a.a.d((String) zVar2.f5868w, eVar.f14950u);
            }
        }
    }

    public final ArrayList v(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            yc.j jVar = (yc.j) it.next();
            zc.e eVar = new zc.e();
            be.h.e(jVar, "<this>");
            eVar.f14950u = jVar.G;
            eVar.j(jVar.E);
            eVar.g(jVar.F);
            yc.g gVar = jVar.f14684x;
            be.h.e(gVar, "<set-?>");
            eVar.f14955z = gVar;
            eVar.A = t.J(jVar.f14683w);
            eVar.f14954y = jVar.f14682v;
            yc.f fVar = jVar.f14685y;
            be.h.e(fVar, "<set-?>");
            eVar.F = fVar;
            yc.k kVar = hd.a.f6072e;
            be.h.e(kVar, "<set-?>");
            eVar.D = kVar;
            eVar.e(hd.a.f6071d);
            eVar.B = 0L;
            eVar.H = jVar.f14686z;
            yc.a aVar = jVar.A;
            be.h.e(aVar, "<set-?>");
            eVar.I = aVar;
            eVar.J = jVar.f14681u;
            eVar.K = jVar.B;
            id.g gVar2 = jVar.D;
            be.h.e(gVar2, "<set-?>");
            eVar.L = gVar2;
            eVar.M = jVar.C;
            eVar.N = 0;
            eVar.f14951v = "LibGlobalFetchLib";
            try {
                boolean zF = F(eVar);
                if (eVar.D != yc.k.A) {
                    eVar.D = jVar.B ? yc.k.f14689x : yc.k.F;
                    if (zF) {
                        this.f4129u.G(eVar);
                        this.f4132x.b("Updated download " + eVar);
                        arrayList.add(new nd.f(eVar, yc.b.f14650x));
                    } else {
                        nd.f fVarF = this.f4129u.F(eVar);
                        this.f4132x.b("Enqueued download " + fVarF.f8983u);
                        arrayList.add(new nd.f(fVarF.f8983u, yc.b.f14650x));
                        G();
                    }
                } else {
                    arrayList.add(new nd.f(eVar, yc.b.f14650x));
                }
                if (this.A == yc.h.f14679v && !this.f4130v.a()) {
                    ed.d dVar = this.f4131w;
                    synchronized (dVar.B) {
                        dVar.H();
                        dVar.D = true;
                        dVar.E = false;
                        dVar.f4683w.d();
                        dVar.f4685y.getClass();
                    }
                }
            } catch (Exception e10) {
                arrayList.add(new nd.f(eVar, b8.h.l(e10)));
            }
        }
        G();
        return arrayList;
    }

    public final boolean x(boolean z2) {
        long count;
        if (be.h.a(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            throw new y0("blocking_call_on_ui_thread");
        }
        zc.g gVar = this.f4129u;
        synchronized (gVar.f14963v) {
            zc.f fVar = gVar.f14962u;
            try {
                Cursor cursorA0 = fVar.A.a0(z2 ? fVar.C : fVar.B);
                count = cursorA0.getCount();
                cursorA0.close();
            } catch (Exception unused) {
                count = -1;
            }
        }
        return count > 0;
    }
}
