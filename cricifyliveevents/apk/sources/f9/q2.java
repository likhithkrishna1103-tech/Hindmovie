package f9;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q2 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4341v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4342w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ x2 f4343x;

    public /* synthetic */ q2(x2 x2Var, AtomicReference atomicReference, int i, boolean z10) {
        this.f4341v = i;
        this.f4343x = x2Var;
        this.f4342w = atomicReference;
    }

    private final void a() {
        AtomicReference atomicReference = this.f4342w;
        synchronized (atomicReference) {
            try {
                try {
                    r1 r1Var = (r1) this.f4343x.f307w;
                    atomicReference.set(r1Var.f4366y.s1(r1Var.l().s1(), f0.f4115c0));
                } finally {
                    this.f4342w.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void b() {
        AtomicReference atomicReference = this.f4342w;
        synchronized (atomicReference) {
            try {
                try {
                    r1 r1Var = (r1) this.f4343x.f307w;
                    atomicReference.set(Long.valueOf(r1Var.f4366y.t1(r1Var.l().s1(), f0.f4117d0)));
                } finally {
                    this.f4342w.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void c() {
        AtomicReference atomicReference = this.f4342w;
        synchronized (atomicReference) {
            try {
                try {
                    r1 r1Var = (r1) this.f4343x.f307w;
                    atomicReference.set(Integer.valueOf(r1Var.f4366y.u1(r1Var.l().s1(), f0.f4120e0)));
                } finally {
                    this.f4342w.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void d() {
        AtomicReference atomicReference = this.f4342w;
        synchronized (atomicReference) {
            try {
                try {
                    r1 r1Var = (r1) this.f4343x.f307w;
                    atomicReference.set(Double.valueOf(r1Var.f4366y.v1(r1Var.l().s1(), f0.f4122f0)));
                } finally {
                    this.f4342w.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4341v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                AtomicReference atomicReference = this.f4342w;
                synchronized (atomicReference) {
                    try {
                        try {
                            r1 r1Var = (r1) this.f4343x.f307w;
                            atomicReference.set(Boolean.valueOf(r1Var.f4366y.w1(r1Var.l().s1(), f0.f4112b0)));
                        } finally {
                            this.f4342w.notify();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
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
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                d();
                return;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                x2 x2Var = this.f4343x;
                f1 f1Var = ((r1) x2Var.f307w).f4367z;
                r1.e(f1Var);
                Bundle bundleC = f1Var.J.C();
                t3 t3VarJ = ((r1) x2Var.f307w).j();
                AtomicReference atomicReference2 = this.f4342w;
                t3VarJ.m1();
                t3VarJ.n1();
                t3VarJ.A1(new z1(t3VarJ, atomicReference2, t3VarJ.C1(false), bundleC, 6));
                return;
            default:
                t3 t3VarJ2 = ((r1) this.f4343x.f307w).j();
                j4 j4VarA = j4.a(e3.f4105z);
                AtomicReference atomicReference3 = this.f4342w;
                t3VarJ2.m1();
                t3VarJ2.n1();
                t3VarJ2.A1(new z1(t3VarJ2, atomicReference3, t3VarJ2.C1(false), j4VarA));
                return;
        }
    }

    public q2(x2 x2Var, AtomicReference atomicReference, int i) {
        this.f4341v = i;
        switch (i) {
            case 1:
                this.f4342w = atomicReference;
                Objects.requireNonNull(x2Var);
                this.f4343x = x2Var;
                break;
            case 2:
                this.f4342w = atomicReference;
                Objects.requireNonNull(x2Var);
                this.f4343x = x2Var;
                break;
            case 3:
                this.f4342w = atomicReference;
                Objects.requireNonNull(x2Var);
                this.f4343x = x2Var;
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                this.f4342w = atomicReference;
                Objects.requireNonNull(x2Var);
                this.f4343x = x2Var;
                break;
            default:
                this.f4342w = atomicReference;
                Objects.requireNonNull(x2Var);
                this.f4343x = x2Var;
                break;
        }
    }
}
