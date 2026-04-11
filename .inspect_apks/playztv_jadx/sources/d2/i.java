package d2;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
import k8.h4;
import k8.k1;
import k8.p0;
import k8.u;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3728a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f3731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f3732e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f3733g;

    public i(k1 k1Var, String str, String str2, String str3, long j5, long j8, Bundle bundle) {
        u uVar;
        v.d(str2);
        v.d(str3);
        this.f3731d = str2;
        this.f3732e = str3;
        this.f = TextUtils.isEmpty(str) ? null : str;
        this.f3729b = j5;
        this.f3730c = j8;
        if (j8 != 0 && j8 > j5) {
            p0 p0Var = k1Var.C;
            k1.f(p0Var);
            p0Var.D.c(p0.v1(str2), "Event created with reverse previous/current timestamps. appId");
        }
        if (bundle == null || bundle.isEmpty()) {
            uVar = new u(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    p0 p0Var2 = k1Var.C;
                    k1.f(p0Var2);
                    p0Var2.A.d("Param name can't be null");
                    it.remove();
                } else {
                    h4 h4Var = k1Var.F;
                    k1.d(h4Var);
                    Object objJ2 = h4Var.j2(bundle2.get(next), next);
                    if (objJ2 == null) {
                        p0 p0Var3 = k1Var.C;
                        k1.f(p0Var3);
                        p0Var3.D.c(k1Var.G.f(next), "Param value can't be null");
                        it.remove();
                    } else {
                        h4 h4Var2 = k1Var.F;
                        k1.d(h4Var2);
                        h4Var2.I1(bundle2, next, objJ2);
                    }
                }
            }
            uVar = new u(bundle2);
        }
        this.f3733g = uVar;
    }

    public i a(long j5, e2.m mVar) throws o2.b {
        long jC;
        long jC2;
        h hVarE = ((e2.m) this.f3732e).e();
        h hVarE2 = mVar.e();
        if (hVarE == null) {
            return new i(j5, mVar, (e2.b) this.f, (p2.e) this.f3731d, this.f3730c, hVarE);
        }
        if (!hVarE.x()) {
            return new i(j5, mVar, (e2.b) this.f, (p2.e) this.f3731d, this.f3730c, hVarE2);
        }
        long jZ = hVarE.z(j5);
        if (jZ == 0) {
            return new i(j5, mVar, (e2.b) this.f, (p2.e) this.f3731d, this.f3730c, hVarE2);
        }
        s1.d.h(hVarE2);
        long jY = hVarE.y();
        long jB = hVarE.b(jY);
        long j8 = jZ + jY;
        long j10 = j8 - 1;
        long jD = hVarE.d(j10, j5) + hVarE.b(j10);
        long jY2 = hVarE2.y();
        long jB2 = hVarE2.b(jY2);
        long j11 = this.f3730c;
        if (jD == jB2) {
            jC = j8 - jY2;
        } else {
            if (jD < jB2) {
                throw new o2.b();
            }
            if (jB2 < jB) {
                jC2 = j11 - (hVarE2.c(jB, j5) - jY);
                return new i(j5, mVar, (e2.b) this.f, (p2.e) this.f3731d, jC2, hVarE2);
            }
            jC = hVarE.c(jB2, j5) - jY2;
        }
        jC2 = jC + j11;
        return new i(j5, mVar, (e2.b) this.f, (p2.e) this.f3731d, jC2, hVarE2);
    }

    public long b(long j5) {
        h hVar = (h) this.f3733g;
        s1.d.h(hVar);
        return hVar.p(this.f3729b, j5) + this.f3730c;
    }

    public long c(long j5) {
        long jB = b(j5);
        h hVar = (h) this.f3733g;
        s1.d.h(hVar);
        return (hVar.A(this.f3729b, j5) + jB) - 1;
    }

    public long d() {
        h hVar = (h) this.f3733g;
        s1.d.h(hVar);
        return hVar.z(this.f3729b);
    }

    public long e(long j5) {
        long jF = f(j5);
        h hVar = (h) this.f3733g;
        s1.d.h(hVar);
        return hVar.d(j5 - this.f3730c, this.f3729b) + jF;
    }

    public long f(long j5) {
        h hVar = (h) this.f3733g;
        s1.d.h(hVar);
        return hVar.b(j5 - this.f3730c);
    }

    public boolean g(long j5, long j8) {
        h hVar = (h) this.f3733g;
        s1.d.h(hVar);
        return hVar.x() || j8 == -9223372036854775807L || e(j5) <= j8;
    }

    public i h(k1 k1Var, long j5) {
        return new i(k1Var, (String) this.f, (String) this.f3731d, (String) this.f3732e, this.f3729b, j5, (u) this.f3733g);
    }

    public String toString() {
        switch (this.f3728a) {
            case 1:
                String str = (String) this.f3731d;
                String str2 = (String) this.f3732e;
                String strValueOf = String.valueOf((u) this.f3733g);
                StringBuilder sb2 = new StringBuilder("Event{appId='");
                sb2.append(str);
                sb2.append("', name='");
                sb2.append(str2);
                sb2.append("', params=");
                return l4.a.o(sb2, strValueOf, "}");
            default:
                return super.toString();
        }
    }

    public i(k1 k1Var, String str, String str2, String str3, long j5, long j8, u uVar) {
        v.d(str2);
        v.d(str3);
        v.h(uVar);
        this.f3731d = str2;
        this.f3732e = str3;
        this.f = TextUtils.isEmpty(str) ? null : str;
        this.f3729b = j5;
        this.f3730c = j8;
        if (j8 != 0 && j8 > j5) {
            p0 p0Var = k1Var.C;
            k1.f(p0Var);
            p0Var.D.b(p0.v1(str2), p0.v1(str3), "Event created with reverse previous/current timestamps. appId, name");
        }
        this.f3733g = uVar;
    }

    public i(long j5, e2.m mVar, e2.b bVar, p2.e eVar, long j8, h hVar) {
        this.f3729b = j5;
        this.f3732e = mVar;
        this.f = bVar;
        this.f3730c = j8;
        this.f3731d = eVar;
        this.f3733g = hVar;
    }
}
