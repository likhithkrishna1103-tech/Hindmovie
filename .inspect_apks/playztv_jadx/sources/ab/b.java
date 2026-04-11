package ab;

import a2.g0;
import aa.c1;
import aa.j0;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import o8.h;
import p1.g1;
import r2.e;
import r2.j;
import r2.m;
import r2.p;
import ta.x;
import z6.g;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements g, m {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ boolean f775u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f776v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f777w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f778x;

    public /* synthetic */ b(Object obj, Object obj2, boolean z2, Object obj3) {
        this.f776v = obj;
        this.f777w = obj2;
        this.f775u = z2;
        this.f778x = obj3;
    }

    @Override // z6.g
    public void c(Exception exc) throws Throwable {
        d dVar = (d) this.f776v;
        h hVar = (h) this.f777w;
        ta.a aVar = (ta.a) this.f778x;
        if (exc != null) {
            hVar.b(exc);
            return;
        }
        if (this.f775u) {
            int i = 1;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new g0(dVar, i, countDownLatch)).start();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            ExecutorService executorService = x.f12439a;
            int i10 = 0;
            try {
                long nanos = timeUnit.toNanos(2L);
                long jNanoTime = System.nanoTime() + nanos;
                while (true) {
                    try {
                        try {
                            countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                            break;
                        } catch (Throwable th) {
                            th = th;
                            if (i != 0) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    } catch (InterruptedException unused) {
                        nanos = jNanoTime - System.nanoTime();
                        i10 = 1;
                    }
                }
                if (i10 != 0) {
                    Thread.currentThread().interrupt();
                }
            } catch (Throwable th2) {
                th = th2;
                i = i10;
            }
        }
        hVar.c(aVar);
    }

    @Override // r2.m
    public c1 g(int i, g1 g1Var, int[] iArr) {
        p pVar = (p) this.f776v;
        j jVar = (j) this.f777w;
        int[] iArr2 = (int[]) this.f778x;
        pVar.getClass();
        r2.d dVar = new r2.d(pVar, jVar);
        int i10 = iArr2[i];
        aa.g0 g0VarN = j0.n();
        for (int i11 = 0; i11 < g1Var.f9762a; i11++) {
            g0VarN.a(new e(i, g1Var, i11, jVar, iArr[i11], this.f775u, dVar, i10));
        }
        return g0VarN.g();
    }
}
