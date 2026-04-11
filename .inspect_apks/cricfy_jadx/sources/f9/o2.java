package f9;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o2 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4306v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ long f4307w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ x2 f4308x;

    public o2(x2 x2Var, long j4, int i) {
        this.f4306v = i;
        switch (i) {
            case 1:
                this.f4307w = j4;
                Objects.requireNonNull(x2Var);
                this.f4308x = x2Var;
                break;
            default:
                this.f4307w = j4;
                Objects.requireNonNull(x2Var);
                this.f4308x = x2Var;
                break;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4306v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                r1 r1Var = (r1) this.f4308x.f307w;
                f1 f1Var = r1Var.f4367z;
                r1.e(f1Var);
                e1 e1Var = f1Var.G;
                long j4 = this.f4307w;
                e1Var.e(j4);
                w0 w0Var = r1Var.A;
                r1.g(w0Var);
                w0Var.I.b(Long.valueOf(j4), "Session timeout duration set");
                break;
            default:
                x2 x2Var = this.f4308x;
                x2Var.m1();
                x2Var.n1();
                r1 r1Var2 = (r1) x2Var.f307w;
                w0 w0Var2 = r1Var2.A;
                r1.g(w0Var2);
                w0Var2.I.a("Resetting analytics data (FE)");
                b4 b4Var = r1Var2.C;
                r1.f(b4Var);
                b4Var.m1();
                a4 a4Var = b4Var.B;
                ((z3) a4Var.f4010x).c();
                ((r1) ((b4) a4Var.f4011y).f307w).F.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                a4Var.f4008v = jElapsedRealtime;
                a4Var.f4009w = jElapsedRealtime;
                r1Var2.l().r1();
                boolean z10 = !r1Var2.a();
                f1 f1Var2 = r1Var2.f4367z;
                r1.e(f1Var2);
                f1Var2.B.e(this.f4307w);
                r1 r1Var3 = (r1) f1Var2.f307w;
                f1 f1Var3 = r1Var3.f4367z;
                r1.e(f1Var3);
                if (!TextUtils.isEmpty(f1Var3.R.r())) {
                    f1Var2.R.t(null);
                }
                f1Var2.L.e(0L);
                f1Var2.M.e(0L);
                if (!r1Var3.f4366y.z1()) {
                    f1Var2.v1(z10);
                }
                f1Var2.S.t(null);
                f1Var2.T.e(0L);
                f1Var2.U.E(null);
                t3 t3VarJ = r1Var2.j();
                t3VarJ.m1();
                t3VarJ.n1();
                w4 w4VarC1 = t3VarJ.C1(false);
                t3VarJ.y1();
                ((r1) t3VarJ.f307w).i().q1();
                t3VarJ.A1(new o3(t3VarJ, w4VarC1, 0));
                r1.f(b4Var);
                b4Var.A.t();
                x2Var.O = z10;
                r1Var2.j().q1(new AtomicReference());
                break;
        }
    }
}
