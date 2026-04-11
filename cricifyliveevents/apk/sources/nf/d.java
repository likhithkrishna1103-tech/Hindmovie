package nf;

import androidx.fragment.app.m;
import ge.i;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import lf.f;
import m2.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Logger f9158k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d f9159l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f9160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Logger f9161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f9164e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f9166h;
    public final ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m f9167j;

    static {
        Logger logger = Logger.getLogger(d.class.getName());
        i.d(logger, "getLogger(...)");
        f9158k = logger;
        String str = f.f7965b + " TaskRunner";
        i.e(str, "name");
        lf.e eVar = new lf.e(str, true);
        e eVar2 = new e();
        eVar2.f8050v = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), eVar);
        f9159l = new d(eVar2);
    }

    public d(e eVar) {
        Logger logger = f9158k;
        i.e(logger, "logger");
        this.f9160a = eVar;
        this.f9161b = logger;
        this.f9162c = 10000;
        this.f9166h = new ArrayList();
        this.i = new ArrayList();
        this.f9167j = new m(21, this);
    }

    public static final void a(d dVar, a aVar, long j4, boolean z10) {
        TimeZone timeZone = f.f7964a;
        c cVar = aVar.f9150c;
        i.b(cVar);
        if (cVar.f9156d != aVar) {
            throw new IllegalStateException("Check failed.");
        }
        boolean z11 = cVar.f;
        cVar.f = false;
        cVar.f9156d = null;
        dVar.f9166h.remove(cVar);
        if (j4 != -1 && !z11 && !cVar.f9155c) {
            cVar.e(aVar, j4, true);
        }
        if (cVar.f9157e.isEmpty()) {
            return;
        }
        dVar.i.add(cVar);
        if (z10) {
            return;
        }
        dVar.e();
    }

    public final a b() {
        long j4;
        a aVar;
        boolean z10;
        TimeZone timeZone = f.f7964a;
        while (true) {
            ArrayList arrayList = this.i;
            if (arrayList.isEmpty()) {
                return null;
            }
            long jNanoTime = System.nanoTime();
            int size = arrayList.size();
            long jMin = Long.MAX_VALUE;
            int i = 0;
            a aVar2 = null;
            while (true) {
                if (i >= size) {
                    j4 = jNanoTime;
                    aVar = null;
                    z10 = false;
                    break;
                }
                Object obj = arrayList.get(i);
                i++;
                a aVar3 = (a) ((c) obj).f9157e.get(0);
                j4 = jNanoTime;
                aVar = null;
                long jMax = Math.max(0L, aVar3.f9151d - j4);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (aVar2 != null) {
                        z10 = true;
                        break;
                    }
                    aVar2 = aVar3;
                }
                jNanoTime = j4;
            }
            ArrayList arrayList2 = this.f9166h;
            if (aVar2 != null) {
                TimeZone timeZone2 = f.f7964a;
                aVar2.f9151d = -1L;
                c cVar = aVar2.f9150c;
                i.b(cVar);
                cVar.f9157e.remove(aVar2);
                arrayList.remove(cVar);
                cVar.f9156d = aVar2;
                arrayList2.add(cVar);
                if (z10 || (!this.f9163d && !arrayList.isEmpty())) {
                    e();
                }
                return aVar2;
            }
            if (this.f9163d) {
                if (jMin >= this.f9164e - j4) {
                    return aVar;
                }
                notify();
                return aVar;
            }
            this.f9163d = true;
            this.f9164e = j4 + jMin;
            try {
                try {
                    TimeZone timeZone3 = f.f7964a;
                    if (jMin > 0) {
                        long j7 = jMin / 1000000;
                        Long.signum(j7);
                        long j10 = jMin - (1000000 * j7);
                        if (j7 > 0 || jMin > 0) {
                            wait(j7, (int) j10);
                        }
                    }
                } catch (InterruptedException unused) {
                    TimeZone timeZone4 = f.f7964a;
                    for (int size2 = arrayList2.size() - 1; -1 < size2; size2--) {
                        ((c) arrayList2.get(size2)).b();
                    }
                    for (int size3 = arrayList.size() - 1; -1 < size3; size3--) {
                        c cVar2 = (c) arrayList.get(size3);
                        cVar2.b();
                        if (cVar2.f9157e.isEmpty()) {
                            arrayList.remove(size3);
                        }
                    }
                }
            } finally {
                this.f9163d = false;
            }
        }
    }

    public final void c(c cVar) {
        i.e(cVar, "taskQueue");
        TimeZone timeZone = f.f7964a;
        if (cVar.f9156d == null) {
            boolean zIsEmpty = cVar.f9157e.isEmpty();
            ArrayList arrayList = this.i;
            if (zIsEmpty) {
                arrayList.remove(cVar);
            } else {
                byte[] bArr = lf.d.f7960a;
                i.e(arrayList, "<this>");
                if (!arrayList.contains(cVar)) {
                    arrayList.add(cVar);
                }
            }
        }
        if (this.f9163d) {
            notify();
        } else {
            e();
        }
    }

    public final c d() {
        int i;
        synchronized (this) {
            i = this.f9162c;
            this.f9162c = i + 1;
        }
        return new c(this, l0.e.g(i, "Q"));
    }

    public final void e() {
        TimeZone timeZone = f.f7964a;
        int i = this.f;
        if (i > this.f9165g) {
            return;
        }
        this.f = i + 1;
        m mVar = this.f9167j;
        i.e(mVar, "runnable");
        ((ThreadPoolExecutor) this.f9160a.f8050v).execute(mVar);
    }
}
