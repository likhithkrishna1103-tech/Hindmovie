package ja;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.i1;
import com.google.android.gms.internal.measurement.j1;
import com.google.android.gms.internal.measurement.m1;
import com.google.android.gms.internal.measurement.o1;
import com.google.android.gms.internal.measurement.p1;
import com.google.android.gms.internal.measurement.t0;
import java.util.List;
import java.util.Map;
import java.util.Random;
import k8.s2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i1 f6922a;

    public a(i1 i1Var) {
        this.f6922a = i1Var;
    }

    @Override // k8.s2
    public final void b(String str, String str2, Bundle bundle) {
        i1 i1Var = this.f6922a;
        i1Var.e(new m1(i1Var, str, str2, bundle, 0));
    }

    @Override // k8.s2
    public final List c(String str, String str2) {
        return this.f6922a.c(str, str2);
    }

    @Override // k8.s2
    public final int d(String str) {
        return this.f6922a.a(str);
    }

    @Override // k8.s2
    public final void e(String str) {
        i1 i1Var = this.f6922a;
        i1Var.e(new o1(i1Var, str, 0));
    }

    @Override // k8.s2
    public final String f() {
        t0 t0Var = new t0();
        i1 i1Var = this.f6922a;
        i1Var.e(new p1(i1Var, t0Var, 4));
        return (String) t0.f(t0Var.e(500L), String.class);
    }

    @Override // k8.s2
    public final String g() {
        t0 t0Var = new t0();
        i1 i1Var = this.f6922a;
        i1Var.e(new p1(i1Var, t0Var, 1));
        return (String) t0.f(t0Var.e(500L), String.class);
    }

    @Override // k8.s2
    public final void h(Bundle bundle) {
        i1 i1Var = this.f6922a;
        i1Var.e(new j1(i1Var, bundle, 0));
    }

    @Override // k8.s2
    public final long i() {
        t0 t0Var = new t0();
        i1 i1Var = this.f6922a;
        i1Var.e(new p1(i1Var, t0Var, 3));
        Long l10 = (Long) t0.f(t0Var.e(500L), Long.class);
        if (l10 != null) {
            return l10.longValue();
        }
        long jNanoTime = System.nanoTime();
        i1Var.f3044b.getClass();
        long jNextLong = new Random(jNanoTime ^ System.currentTimeMillis()).nextLong();
        int i = i1Var.f + 1;
        i1Var.f = i;
        return jNextLong + ((long) i);
    }

    @Override // k8.s2
    public final void j(String str) {
        i1 i1Var = this.f6922a;
        i1Var.e(new o1(i1Var, str, 1));
    }

    @Override // k8.s2
    public final Map k(String str, String str2, boolean z2) {
        return this.f6922a.d(str, str2, z2);
    }

    @Override // k8.s2
    public final String l() {
        t0 t0Var = new t0();
        i1 i1Var = this.f6922a;
        i1Var.e(new p1(i1Var, t0Var, 2));
        return (String) t0.f(t0Var.e(500L), String.class);
    }

    @Override // k8.s2
    public final void m(String str, String str2, Bundle bundle) {
        i1 i1Var = this.f6922a;
        i1Var.e(new m1(i1Var, str, str2, bundle, 1));
    }

    @Override // k8.s2
    public final String n() {
        t0 t0Var = new t0();
        i1 i1Var = this.f6922a;
        i1Var.e(new p1(i1Var, t0Var, 0));
        return (String) t0.f(t0Var.e(50L), String.class);
    }
}
