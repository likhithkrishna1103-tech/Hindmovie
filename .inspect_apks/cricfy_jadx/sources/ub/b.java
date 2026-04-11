package ub;

import j9.i;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import nb.x;
import u7.g;
import ua.f0;
import ua.i0;
import ua.z0;
import v1.g1;
import v2.d;
import v2.e;
import v2.l;
import v2.o;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements g, l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ boolean f12421v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f12422w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f12423x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f12424y;

    public /* synthetic */ b(boolean z10, Object obj, Object obj2, Object obj3) {
        this.f12422w = obj;
        this.f12423x = obj2;
        this.f12421v = z10;
        this.f12424y = obj3;
    }

    @Override // u7.g
    public void a(Exception exc) throws Throwable {
        c cVar = (c) this.f12422w;
        i iVar = (i) this.f12423x;
        nb.a aVar = (nb.a) this.f12424y;
        if (exc != null) {
            iVar.b(exc);
            return;
        }
        if (this.f12421v) {
            boolean z10 = true;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new nc.i(7, cVar, countDownLatch)).start();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            ExecutorService executorService = x.f9018a;
            boolean z11 = false;
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
                            if (z10) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    } catch (InterruptedException unused) {
                        nanos = jNanoTime - System.nanoTime();
                        z11 = true;
                    }
                }
                if (z11) {
                    Thread.currentThread().interrupt();
                }
            } catch (Throwable th2) {
                th = th2;
                z10 = z11;
            }
        }
        iVar.c(aVar);
    }

    @Override // v2.l
    public z0 b(int i, g1 g1Var, int[] iArr) {
        o oVar = (o) this.f12422w;
        v2.i iVar = (v2.i) this.f12423x;
        int[] iArr2 = (int[]) this.f12424y;
        oVar.getClass();
        d dVar = new d(oVar, iVar);
        int i10 = iArr2[i];
        f0 f0VarJ = i0.j();
        for (int i11 = 0; i11 < g1Var.f12702a; i11++) {
            f0VarJ.a(new e(i, g1Var, i11, iVar, iArr[i11], this.f12421v, dVar, i10));
        }
        return f0VarJ.g();
    }
}
