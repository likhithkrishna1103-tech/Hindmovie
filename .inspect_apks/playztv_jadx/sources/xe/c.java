package xe;

import be.h;
import e6.j;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import n.a1;
import va.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f14365h = new e();
    public static final c i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Logger f14366j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a1 f14367a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f14370d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14368b = 10000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f14371e = new ArrayList();
    public final ArrayList f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final androidx.fragment.app.e f14372g = new androidx.fragment.app.e(28, this);

    static {
        String str = ve.b.f13502g + " TaskRunner";
        h.e(str, "name");
        ve.a aVar = new ve.a(str, true);
        a1 a1Var = new a1();
        a1Var.f8343u = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), aVar);
        i = new c(a1Var);
        Logger logger = Logger.getLogger(c.class.getName());
        h.d(logger, "getLogger(TaskRunner::class.java.name)");
        f14366j = logger;
    }

    public c(a1 a1Var) {
        this.f14367a = a1Var;
    }

    public static final void a(c cVar, a aVar) {
        byte[] bArr = ve.b.f13497a;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(aVar.f14356a);
        try {
            long jA = aVar.a();
            synchronized (cVar) {
                cVar.b(aVar, jA);
            }
            threadCurrentThread.setName(name);
        } catch (Throwable th) {
            synchronized (cVar) {
                cVar.b(aVar, -1L);
                threadCurrentThread.setName(name);
                throw th;
            }
        }
    }

    public final void b(a aVar, long j5) {
        byte[] bArr = ve.b.f13497a;
        b bVar = aVar.f14358c;
        h.b(bVar);
        if (bVar.f14363d != aVar) {
            throw new IllegalStateException("Check failed.");
        }
        boolean z2 = bVar.f;
        bVar.f = false;
        bVar.f14363d = null;
        this.f14371e.remove(bVar);
        if (j5 != -1 && !z2 && !bVar.f14362c) {
            bVar.d(aVar, j5, true);
        }
        if (bVar.f14364e.isEmpty()) {
            return;
        }
        this.f.add(bVar);
    }

    public final a c() {
        long j5;
        a aVar;
        boolean z2;
        byte[] bArr = ve.b.f13497a;
        while (true) {
            ArrayList arrayList = this.f;
            if (arrayList.isEmpty()) {
                return null;
            }
            long jNanoTime = System.nanoTime();
            int size = arrayList.size();
            long jMin = Long.MAX_VALUE;
            int i10 = 0;
            a aVar2 = null;
            while (true) {
                if (i10 >= size) {
                    j5 = jNanoTime;
                    aVar = null;
                    z2 = false;
                    break;
                }
                Object obj = arrayList.get(i10);
                i10++;
                a aVar3 = (a) ((b) obj).f14364e.get(0);
                j5 = jNanoTime;
                aVar = null;
                long jMax = Math.max(0L, aVar3.f14359d - j5);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (aVar2 != null) {
                        z2 = true;
                        break;
                    }
                    aVar2 = aVar3;
                }
                jNanoTime = j5;
            }
            ArrayList arrayList2 = this.f14371e;
            if (aVar2 != null) {
                byte[] bArr2 = ve.b.f13497a;
                aVar2.f14359d = -1L;
                b bVar = aVar2.f14358c;
                h.b(bVar);
                bVar.f14364e.remove(aVar2);
                arrayList.remove(bVar);
                bVar.f14363d = aVar2;
                arrayList2.add(bVar);
                if (z2 || (!this.f14369c && !arrayList.isEmpty())) {
                    androidx.fragment.app.e eVar = this.f14372g;
                    h.e(eVar, "runnable");
                    ((ThreadPoolExecutor) this.f14367a.f8343u).execute(eVar);
                }
                return aVar2;
            }
            if (this.f14369c) {
                if (jMin >= this.f14370d - j5) {
                    return aVar;
                }
                notify();
                return aVar;
            }
            this.f14369c = true;
            this.f14370d = j5 + jMin;
            try {
                try {
                    long j8 = jMin / 1000000;
                    Long.signum(j8);
                    long j10 = jMin - (1000000 * j8);
                    if (j8 > 0 || jMin > 0) {
                        wait(j8, (int) j10);
                    }
                } catch (InterruptedException unused) {
                    for (int size2 = arrayList2.size() - 1; -1 < size2; size2--) {
                        ((b) arrayList2.get(size2)).b();
                    }
                    for (int size3 = arrayList.size() - 1; -1 < size3; size3--) {
                        b bVar2 = (b) arrayList.get(size3);
                        bVar2.b();
                        if (bVar2.f14364e.isEmpty()) {
                            arrayList.remove(size3);
                        }
                    }
                }
            } finally {
                this.f14369c = false;
            }
        }
    }

    public final void d(b bVar) {
        h.e(bVar, "taskQueue");
        byte[] bArr = ve.b.f13497a;
        if (bVar.f14363d == null) {
            boolean zIsEmpty = bVar.f14364e.isEmpty();
            ArrayList arrayList = this.f;
            if (zIsEmpty) {
                arrayList.remove(bVar);
            } else {
                h.e(arrayList, "<this>");
                if (!arrayList.contains(bVar)) {
                    arrayList.add(bVar);
                }
            }
        }
        if (this.f14369c) {
            notify();
            return;
        }
        androidx.fragment.app.e eVar = this.f14372g;
        h.e(eVar, "runnable");
        ((ThreadPoolExecutor) this.f14367a.f8343u).execute(eVar);
    }

    public final b e() {
        int i10;
        synchronized (this) {
            i10 = this.f14368b;
            this.f14368b = i10 + 1;
        }
        return new b(this, j.l("Q", i10));
    }
}
