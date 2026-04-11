package k8;

import android.os.Bundle;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q extends d0 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final s.e f7376w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final s.e f7377x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f7378y;

    public q(k1 k1Var) {
        super(k1Var);
        this.f7377x = new s.e(0);
        this.f7376w = new s.e(0);
    }

    public final void t1(long j5) {
        w2 w2VarX1 = r1().x1(false);
        s.e eVar = this.f7376w;
        for (String str : (s.b) eVar.keySet()) {
            w1(str, j5 - ((Long) eVar.get(str)).longValue(), w2VarX1);
        }
        if (!eVar.isEmpty()) {
            u1(j5 - this.f7378y, w2VarX1);
        }
        x1(j5);
    }

    public final void u1(long j5, w2 w2Var) {
        if (w2Var == null) {
            g().I.d("Not logging ad exposure. No active activity");
            return;
        }
        if (j5 < 1000) {
            g().I.c(Long.valueOf(j5), "Not logging ad exposure. Less than 1000 ms. exposure");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j5);
        h4.S1(w2Var, bundle, true);
        q1().T1("am", "_xa", bundle);
    }

    public final void v1(String str, long j5) {
        if (str == null || str.length() == 0) {
            g().A.d("Ad unit id must be a non-empty string");
        } else {
            x().y1(new b(this, str, j5, 0));
        }
    }

    public final void w1(String str, long j5, w2 w2Var) {
        if (w2Var == null) {
            g().I.d("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j5 < 1000) {
            g().I.c(Long.valueOf(j5), "Not logging ad unit exposure. Less than 1000 ms. exposure");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j5);
        h4.S1(w2Var, bundle, true);
        q1().T1("am", "_xu", bundle);
    }

    public final void x1(long j5) {
        s.e eVar = this.f7376w;
        Iterator it = ((s.b) eVar.keySet()).iterator();
        while (it.hasNext()) {
            eVar.put((String) it.next(), Long.valueOf(j5));
        }
        if (eVar.isEmpty()) {
            return;
        }
        this.f7378y = j5;
    }

    public final void y1(String str, long j5) {
        if (str == null || str.length() == 0) {
            g().A.d("Ad unit id must be a non-empty string");
        } else {
            x().y1(new b(this, str, j5, 1));
        }
    }
}
