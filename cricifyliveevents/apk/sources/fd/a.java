package fd;

import a9.l;
import androidx.emoji2.text.v;
import com.google.android.gms.internal.measurement.j4;
import d8.j;
import ge.i;
import i2.k;
import i2.x;
import java.io.Closeable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import l4.c0;
import md.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Closeable {
    public final j A;
    public final cd.d B;
    public final k C;
    public final v D;
    public final Object E;
    public final ExecutorService F;
    public id.d G;
    public volatile int H;
    public final HashMap I;
    public volatile int J;
    public volatile boolean K;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final e f4560v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final d5.a f4561w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final x f4562x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final id.a f4563y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c0 f4564z;

    public a(e eVar, d5.a aVar, x xVar, id.a aVar2, c0 c0Var, j jVar, cd.d dVar, k kVar, v vVar) {
        i.e(eVar, "httpDownloader");
        i.e(aVar, "logger");
        i.e(dVar, "fileServerDownloader");
        this.f4560v = eVar;
        this.f4561w = aVar;
        this.f4562x = xVar;
        this.f4563y = aVar2;
        this.f4564z = c0Var;
        this.A = jVar;
        this.B = dVar;
        this.C = kVar;
        this.D = vVar;
        this.E = new Object();
        this.F = Executors.newFixedThreadPool(1);
        this.H = 1;
        this.I = new HashMap();
    }

    public final b A(dd.e eVar, e eVar2) {
        dd.c cVarN = j4.n(eVar, "GET");
        eVar2.B(cVarN);
        md.c cVarX = eVar2.X(cVarN, eVar2.x(cVarN));
        md.c cVar = md.c.f8424v;
        k kVar = this.C;
        x xVar = this.f4562x;
        if (cVarX == cVar) {
            return new d(eVar, eVar2, this.f4561w, xVar, kVar);
        }
        return new c(eVar, eVar2, this.f4561w, xVar, (String) kVar.f6086w, kVar);
    }

    public final b C(dd.e eVar) {
        i.e(eVar, "download");
        return !android.support.v4.media.session.b.C(eVar.f3678x) ? A(eVar, this.f4560v) : A(eVar, this.B);
    }

    public final void J(dd.e eVar) {
        synchronized (this.E) {
            try {
                if (this.I.containsKey(Integer.valueOf(eVar.f3676v))) {
                    this.I.remove(Integer.valueOf(eVar.f3676v));
                    this.J--;
                }
                this.f4564z.U(eVar.f3676v);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void O(dd.e eVar) {
        i.e(eVar, "download");
        synchronized (this.E) {
            if (this.K) {
                throw new l("DownloadManager is already shutdown.");
            }
            if (this.I.containsKey(Integer.valueOf(eVar.f3676v))) {
                this.f4561w.b("DownloadManager already running download " + eVar);
                return;
            }
            if (this.J >= this.H) {
                this.f4561w.b("DownloadManager cannot init download " + eVar + " because the download queue is full");
                return;
            }
            this.J++;
            this.I.put(Integer.valueOf(eVar.f3676v), null);
            this.f4564z.n(eVar.f3676v, null);
            ExecutorService executorService = this.F;
            if (executorService == null || executorService.isShutdown()) {
                return;
            }
            executorService.execute(new androidx.fragment.app.d(3, eVar, this));
        }
    }

    public final void Q() {
        for (Map.Entry entry : this.I.entrySet()) {
            b bVar = (b) entry.getValue();
            if (bVar != null) {
                bVar.z();
                this.f4561w.b("DownloadManager terminated download " + bVar.A());
                this.f4564z.U(((Number) entry.getKey()).intValue());
            }
        }
        this.I.clear();
        this.J = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.E
            monitor-enter(r0)
            boolean r1 = r3.K     // Catch: java.lang.Throwable -> Lf
            if (r1 != 0) goto L11
            int r1 = r3.J     // Catch: java.lang.Throwable -> Lf
            int r2 = r3.H     // Catch: java.lang.Throwable -> Lf
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
        throw new UnsupportedOperationException("Method not decompiled: fd.a.a():boolean");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.E) {
            try {
                if (this.K) {
                    return;
                }
                this.K = true;
                if (this.H > 0) {
                    Q();
                }
                this.f4561w.getClass();
                try {
                    ExecutorService executorService = this.F;
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

    public final void g() {
        synchronized (this.E) {
            if (this.K) {
                throw new l("DownloadManager is already shutdown.");
            }
            q();
        }
    }

    public final void q() {
        List<b> listR0;
        if (this.H > 0) {
            c0 c0Var = this.f4564z;
            synchronized (c0Var.f7705w) {
                listR0 = sd.j.r0(((LinkedHashMap) c0Var.f7706x).values());
            }
            for (b bVar : listR0) {
                if (bVar != null) {
                    bVar.s();
                    this.f4564z.U(bVar.A().f3676v);
                    this.f4561w.b("DownloadManager cancelled download " + bVar.A());
                }
            }
        }
        this.I.clear();
        this.J = 0;
    }

    public final boolean s(int i) {
        if (this.K) {
            throw new l("DownloadManager is already shutdown.");
        }
        b bVar = (b) this.I.get(Integer.valueOf(i));
        if (bVar == null) {
            c0 c0Var = this.f4564z;
            synchronized (c0Var.f7705w) {
                b bVar2 = (b) ((LinkedHashMap) c0Var.f7706x).get(Integer.valueOf(i));
                if (bVar2 != null) {
                    bVar2.s();
                    ((LinkedHashMap) c0Var.f7706x).remove(Integer.valueOf(i));
                }
            }
            return false;
        }
        bVar.s();
        this.I.remove(Integer.valueOf(i));
        this.J--;
        this.f4564z.U(i);
        this.f4561w.b("DownloadManager cancelled download " + bVar.A());
        return bVar.e0();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean z(int r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.E
            monitor-enter(r0)
            boolean r1 = r2.K     // Catch: java.lang.Throwable -> L11
            if (r1 != 0) goto L13
            l4.c0 r1 = r2.f4564z     // Catch: java.lang.Throwable -> L11
            boolean r3 = r1.t(r3)     // Catch: java.lang.Throwable -> L11
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
        throw new UnsupportedOperationException("Method not decompiled: fd.a.z(int):boolean");
    }
}
