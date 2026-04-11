package bd;

import a2.g0;
import a2.y0;
import b7.s;
import c2.x;
import h4.z;
import id.e;
import id.h;
import java.io.Closeable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import od.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Closeable {
    public final yc.d A;
    public final z B;
    public final a7.b C;
    public final Object D;
    public final ExecutorService E;
    public ed.d F;
    public volatile int G;
    public final HashMap H;
    public volatile int I;
    public volatile boolean J;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final e f2010u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h f2011v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final x f2012w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ed.a f2013x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final z f2014y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final s f2015z;

    public a(e eVar, h hVar, x xVar, ed.a aVar, z zVar, s sVar, yc.d dVar, z zVar2, a7.b bVar) {
        be.h.e(eVar, "httpDownloader");
        be.h.e(hVar, "logger");
        be.h.e(dVar, "fileServerDownloader");
        this.f2010u = eVar;
        this.f2011v = hVar;
        this.f2012w = xVar;
        this.f2013x = aVar;
        this.f2014y = zVar;
        this.f2015z = sVar;
        this.A = dVar;
        this.B = zVar2;
        this.C = bVar;
        this.D = new Object();
        this.E = Executors.newFixedThreadPool(1);
        this.G = 1;
        this.H = new HashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean F(int r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.D
            monitor-enter(r0)
            boolean r1 = r2.J     // Catch: java.lang.Throwable -> L11
            if (r1 != 0) goto L13
            h4.z r1 = r2.f2014y     // Catch: java.lang.Throwable -> L11
            boolean r3 = r1.H(r3)     // Catch: java.lang.Throwable -> L11
            if (r3 == 0) goto L13
            r3 = 1
            goto L14
        L11:
            r3 = move-exception
            goto L16
        L13:
            r3 = 0
        L14:
            monitor-exit(r0)
            return r3
        L16:
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: bd.a.F(int):boolean");
    }

    public final b G(zc.e eVar, e eVar2) {
        zc.c cVarP = a.a.p(eVar, "GET");
        eVar2.T(cVarP);
        id.c cVarW = eVar2.w(cVarP, eVar2.s(cVarP));
        id.c cVar = id.c.f6568u;
        z zVar = this.B;
        x xVar = this.f2012w;
        if (cVarW == cVar) {
            return new d(eVar, eVar2, this.f2011v, xVar, zVar);
        }
        return new c(eVar, eVar2, this.f2011v, xVar, (String) zVar.f5868w, zVar);
    }

    public final b H(zc.e eVar) {
        be.h.e(eVar, "download");
        return !android.support.v4.media.session.b.E(eVar.f14952w) ? G(eVar, this.f2010u) : G(eVar, this.A);
    }

    public final void J(zc.e eVar) {
        synchronized (this.D) {
            try {
                if (this.H.containsKey(Integer.valueOf(eVar.f14950u))) {
                    this.H.remove(Integer.valueOf(eVar.f14950u));
                    this.I--;
                }
                this.f2014y.h0(eVar.f14950u);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void K(zc.e eVar) {
        be.h.e(eVar, "download");
        synchronized (this.D) {
            if (this.J) {
                throw new y0("DownloadManager is already shutdown.");
            }
            if (this.H.containsKey(Integer.valueOf(eVar.f14950u))) {
                this.f2011v.b("DownloadManager already running download " + eVar);
                return;
            }
            if (this.I >= this.G) {
                this.f2011v.b("DownloadManager cannot init download " + eVar + " because the download queue is full");
                return;
            }
            this.I++;
            this.H.put(Integer.valueOf(eVar.f14950u), null);
            this.f2014y.D(eVar.f14950u, null);
            ExecutorService executorService = this.E;
            if (executorService == null || executorService.isShutdown()) {
                return;
            }
            executorService.execute(new g0(eVar, 7, this));
        }
    }

    public final void S() {
        for (Map.Entry entry : this.H.entrySet()) {
            b bVar = (b) entry.getValue();
            if (bVar != null) {
                bVar.F();
                this.f2011v.b("DownloadManager terminated download " + bVar.H());
                this.f2014y.h0(((Number) entry.getKey()).intValue());
            }
        }
        this.H.clear();
        this.I = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.D
            monitor-enter(r0)
            boolean r1 = r3.J     // Catch: java.lang.Throwable -> Lf
            if (r1 != 0) goto L11
            int r1 = r3.I     // Catch: java.lang.Throwable -> Lf
            int r2 = r3.G     // Catch: java.lang.Throwable -> Lf
            if (r1 >= r2) goto L11
            r1 = 1
            goto L12
        Lf:
            r1 = move-exception
            goto L14
        L11:
            r1 = 0
        L12:
            monitor-exit(r0)
            return r1
        L14:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bd.a.a():boolean");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.D) {
            try {
                if (this.J) {
                    return;
                }
                this.J = true;
                if (this.G > 0) {
                    S();
                }
                this.f2011v.getClass();
                try {
                    ExecutorService executorService = this.E;
                    if (executorService != null) {
                        executorService.shutdown();
                    }
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        synchronized (this.D) {
            if (this.J) {
                throw new y0("DownloadManager is already shutdown.");
            }
            v();
        }
    }

    public final void v() {
        List<b> listH0;
        if (this.G > 0) {
            z zVar = this.f2014y;
            synchronized (zVar.f5867v) {
                listH0 = i.h0(((LinkedHashMap) zVar.f5868w).values());
            }
            for (b bVar : listH0) {
                if (bVar != null) {
                    bVar.x();
                    this.f2014y.h0(bVar.H().f14950u);
                    this.f2011v.b("DownloadManager cancelled download " + bVar.H());
                }
            }
        }
        this.H.clear();
        this.I = 0;
    }

    public final boolean x(int i) {
        if (this.J) {
            throw new y0("DownloadManager is already shutdown.");
        }
        b bVar = (b) this.H.get(Integer.valueOf(i));
        if (bVar == null) {
            z zVar = this.f2014y;
            synchronized (zVar.f5867v) {
                b bVar2 = (b) ((LinkedHashMap) zVar.f5868w).get(Integer.valueOf(i));
                if (bVar2 != null) {
                    bVar2.x();
                    ((LinkedHashMap) zVar.f5868w).remove(Integer.valueOf(i));
                }
            }
            return false;
        }
        bVar.x();
        this.H.remove(Integer.valueOf(i));
        this.I--;
        this.f2014y.h0(i);
        this.f2011v.b("DownloadManager cancelled download " + bVar.H());
        return bVar.g0();
    }
}
