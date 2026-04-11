package k8;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h2 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7227u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public /* synthetic */ AtomicReference f7228v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public /* synthetic */ g2 f7229w;

    public /* synthetic */ h2() {
        this.f7227u = 0;
    }

    private final void a() {
        synchronized (this.f7228v) {
            try {
                try {
                    AtomicReference atomicReference = this.f7228v;
                    k1 k1Var = (k1) this.f7229w.f2454v;
                    e eVar = k1Var.A;
                    String strW1 = k1Var.m().w1();
                    eVar.getClass();
                    atomicReference.set(Boolean.valueOf(eVar.A1(strW1, w.N)));
                } finally {
                    this.f7228v.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void b() {
        synchronized (this.f7228v) {
            try {
                try {
                    AtomicReference atomicReference = this.f7228v;
                    k1 k1Var = (k1) this.f7229w.f2454v;
                    e eVar = k1Var.A;
                    String strW1 = k1Var.m().w1();
                    eVar.getClass();
                    atomicReference.set(eVar.x1(strW1, w.O));
                } finally {
                    this.f7228v.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void c() {
        synchronized (this.f7228v) {
            try {
                try {
                    AtomicReference atomicReference = this.f7228v;
                    k1 k1Var = (k1) this.f7229w.f2454v;
                    atomicReference.set(Integer.valueOf(k1Var.A.u1(k1Var.m().w1(), w.Q)));
                } finally {
                    this.f7228v.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void d() {
        synchronized (this.f7228v) {
            try {
                try {
                    AtomicReference atomicReference = this.f7228v;
                    k1 k1Var = (k1) this.f7229w.f2454v;
                    atomicReference.set(Long.valueOf(k1Var.A.v1(k1Var.m().w1(), w.P)));
                } finally {
                    this.f7228v.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7227u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g2 g2Var = this.f7229w;
                AtomicReference atomicReference = this.f7228v;
                Bundle bundleW = g2Var.n1().J.W();
                z2 z2VarP = ((k1) g2Var.f2454v).p();
                z2VarP.p1();
                z2VarP.t1();
                z2VarP.w1(new l2(z2VarP, atomicReference, z2VarP.I1(false), bundleW, 3));
                return;
            case 1:
                a();
                return;
            case 2:
                b();
                return;
            case 3:
                c();
                return;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                d();
                return;
            default:
                synchronized (this.f7228v) {
                    try {
                        try {
                            AtomicReference atomicReference2 = this.f7228v;
                            k1 k1Var = (k1) this.f7229w.f2454v;
                            atomicReference2.set(Double.valueOf(k1Var.A.q1(k1Var.m().w1(), w.R)));
                        } finally {
                            this.f7228v.notify();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }

    public /* synthetic */ h2(g2 g2Var, AtomicReference atomicReference, int i) {
        this.f7227u = i;
        this.f7228v = atomicReference;
        this.f7229w = g2Var;
    }
}
