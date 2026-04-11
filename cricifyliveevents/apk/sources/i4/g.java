package i4;

import a3.b0;
import a3.c0;
import a3.d0;
import com.google.android.material.datepicker.o;
import java.math.RoundingMode;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f6210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f6213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f6214e;

    public g(o oVar, int i, long j4, long j7) {
        this.f6210a = oVar;
        this.f6211b = i;
        this.f6212c = j4;
        long j10 = (j7 - j4) / ((long) oVar.f2877x);
        this.f6213d = j10;
        this.f6214e = a(j10);
    }

    public final long a(long j4) {
        long j7 = j4 * ((long) this.f6211b);
        long j10 = this.f6210a.f2876w;
        int i = a0.f14551a;
        return a0.W(j7, 1000000L, j10, RoundingMode.DOWN);
    }

    @Override // a3.c0
    public final boolean g() {
        return true;
    }

    @Override // a3.c0
    public final b0 j(long j4) {
        o oVar = this.f6210a;
        long j7 = (((long) oVar.f2876w) * j4) / (((long) this.f6211b) * 1000000);
        long j10 = this.f6213d;
        long j11 = a0.j(j7, 0L, j10 - 1);
        long j12 = ((long) oVar.f2877x) * j11;
        long j13 = this.f6212c;
        long jA = a(j11);
        d0 d0Var = new d0(jA, j12 + j13);
        if (jA >= j4 || j11 == j10 - 1) {
            return new b0(d0Var, d0Var);
        }
        long j14 = j11 + 1;
        return new b0(d0Var, new d0(a(j14), (((long) oVar.f2877x) * j14) + j13));
    }

    @Override // a3.c0
    public final long l() {
        return this.f6214e;
    }
}
