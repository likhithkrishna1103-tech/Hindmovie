package f9;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j3 extends h0 {
    public f3 A;
    public final ConcurrentHashMap B;
    public com.google.android.gms.internal.measurement.v0 C;
    public volatile boolean D;
    public volatile f3 E;
    public f3 F;
    public boolean G;
    public final Object H;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile f3 f4242y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile f3 f4243z;

    public j3(r1 r1Var) {
        super(r1Var);
        this.H = new Object();
        this.B = new ConcurrentHashMap();
    }

    @Override // f9.h0
    public final boolean p1() {
        return false;
    }

    public final void q1(f3 f3Var, boolean z10, long j4) {
        r1 r1Var = (r1) this.f307w;
        y yVar = r1Var.I;
        r1.d(yVar);
        r1Var.F.getClass();
        yVar.p1(SystemClock.elapsedRealtime());
        boolean z11 = f3Var != null && f3Var.f4178d;
        b4 b4Var = r1Var.C;
        r1.f(b4Var);
        if (!b4Var.B.a(j4, z11, z10) || f3Var == null) {
            return;
        }
        f3Var.f4178d = false;
    }

    public final f3 r1(com.google.android.gms.internal.measurement.v0 v0Var) {
        o8.u.g(v0Var);
        Integer numValueOf = Integer.valueOf(v0Var.f2658v);
        ConcurrentHashMap concurrentHashMap = this.B;
        f3 f3Var = (f3) concurrentHashMap.get(numValueOf);
        if (f3Var == null) {
            String strT1 = t1(v0Var.f2659w);
            u4 u4Var = ((r1) this.f307w).D;
            r1.e(u4Var);
            f3 f3Var2 = new f3(u4Var.j2(), null, strT1);
            concurrentHashMap.put(numValueOf, f3Var2);
            f3Var = f3Var2;
        }
        return this.E != null ? this.E : f3Var;
    }

    public final f3 s1(boolean z10) {
        n1();
        m1();
        if (!z10) {
            return this.A;
        }
        f3 f3Var = this.A;
        return f3Var != null ? f3Var : this.F;
    }

    public final String t1(String str) {
        if (str == null) {
            return "Activity";
        }
        String[] strArrSplit = str.split("\\.");
        int length = strArrSplit.length;
        String str2 = length > 0 ? strArrSplit[length - 1] : "";
        r1 r1Var = (r1) this.f307w;
        int length2 = str2.length();
        r1Var.f4366y.getClass();
        if (length2 <= 500) {
            return str2;
        }
        r1Var.f4366y.getClass();
        return str2.substring(0, 500);
    }

    public final void u1(com.google.android.gms.internal.measurement.v0 v0Var, Bundle bundle) {
        Bundle bundle2;
        if (!((r1) this.f307w).f4366y.A1() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.B.put(Integer.valueOf(v0Var.f2658v), new f3(bundle2.getLong("id"), bundle2.getString("name"), bundle2.getString("referrer_name")));
    }

    public final void v1(String str, f3 f3Var, boolean z10) {
        f3 f3Var2;
        f3 f3Var3 = this.f4242y == null ? this.f4243z : this.f4242y;
        if (f3Var.f4176b == null) {
            f3Var2 = new f3(f3Var.f4175a, str != null ? t1(str) : null, f3Var.f4177c, f3Var.f4179e, f3Var.f);
        } else {
            f3Var2 = f3Var;
        }
        this.f4243z = this.f4242y;
        this.f4242y = f3Var2;
        r1 r1Var = (r1) this.f307w;
        r1Var.F.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        p1 p1Var = r1Var.B;
        r1.g(p1Var);
        p1Var.v1(new g3(this, f3Var2, f3Var3, jElapsedRealtime, z10));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w1(f9.f3 r18, f9.f3 r19, long r20, boolean r22, android.os.Bundle r23) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.j3.w1(f9.f3, f9.f3, long, boolean, android.os.Bundle):void");
    }
}
