package f9;

import android.content.SharedPreferences;
import android.os.SystemClock;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e1 implements g2.t0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f4093v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f4094w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f4095x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f4096y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f4097z;

    public e1(f1 f1Var, String str, long j4) {
        Objects.requireNonNull(f1Var);
        this.f4097z = f1Var;
        o8.u.d(str);
        this.f4096y = str;
        this.f4094w = j4;
    }

    public void a(long j4) {
        this.f4094w = j4;
        if (this.f4093v) {
            ((y1.v) this.f4096y).getClass();
            this.f4095x = SystemClock.elapsedRealtime();
        }
    }

    public void b() {
        if (this.f4093v) {
            return;
        }
        ((y1.v) this.f4096y).getClass();
        this.f4095x = SystemClock.elapsedRealtime();
        this.f4093v = true;
    }

    public long c() {
        if (!this.f4093v) {
            this.f4093v = true;
            f1 f1Var = (f1) this.f4097z;
            this.f4095x = f1Var.q1().getLong((String) this.f4096y, this.f4094w);
        }
        return this.f4095x;
    }

    @Override // g2.t0
    public v1.q0 d() {
        return (v1.q0) this.f4097z;
    }

    public void e(long j4) {
        SharedPreferences.Editor editorEdit = ((f1) this.f4097z).q1().edit();
        editorEdit.putLong((String) this.f4096y, j4);
        editorEdit.apply();
        this.f4095x = j4;
    }

    @Override // g2.t0
    public void f(v1.q0 q0Var) {
        if (this.f4093v) {
            a(h());
        }
        this.f4097z = q0Var;
    }

    @Override // g2.t0
    public /* synthetic */ boolean g() {
        return false;
    }

    @Override // g2.t0
    public long h() {
        long j4 = this.f4094w;
        if (!this.f4093v) {
            return j4;
        }
        ((y1.v) this.f4096y).getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f4095x;
        v1.q0 q0Var = (v1.q0) this.f4097z;
        return (q0Var.f12968a == 1.0f ? y1.a0.O(jElapsedRealtime) : jElapsedRealtime * ((long) q0Var.f12970c)) + j4;
    }

    public e1(y1.v vVar) {
        this.f4096y = vVar;
        this.f4097z = v1.q0.f12966d;
    }
}
