package f9;

import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b4 extends h0 {
    public final p6.c A;
    public final a4 B;
    public final l4.c0 C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public a9.k f4049y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f4050z;

    public b4(r1 r1Var) {
        super(r1Var);
        this.f4050z = true;
        this.A = new p6.c(14, this);
        a4 a4Var = new a4();
        a4Var.f4011y = this;
        r1 r1Var2 = (r1) this.f307w;
        a4Var.f4010x = new z3(a4Var, r1Var2, 0);
        r1Var2.F.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        a4Var.f4008v = jElapsedRealtime;
        a4Var.f4009w = jElapsedRealtime;
        this.B = a4Var;
        this.C = new l4.c0(this);
    }

    @Override // f9.h0
    public final boolean p1() {
        return false;
    }

    public final void q1() {
        m1();
        if (this.f4049y == null) {
            this.f4049y = new a9.k(Looper.getMainLooper(), 2);
        }
    }
}
