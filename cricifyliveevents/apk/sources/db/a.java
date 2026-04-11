package db;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.a1;
import com.google.android.gms.internal.measurement.c1;
import com.google.android.gms.internal.measurement.g0;
import com.google.android.gms.internal.measurement.k1;
import com.google.android.gms.internal.measurement.w0;
import com.google.android.gms.internal.measurement.x0;
import f9.y2;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements y2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k1 f3652a;

    public a(k1 k1Var) {
        this.f3652a = k1Var;
    }

    @Override // f9.y2
    public final long a() {
        g0 g0Var = new g0();
        k1 k1Var = this.f3652a;
        k1Var.c(new c1(k1Var, g0Var, 2));
        Long l10 = (Long) g0.f(g0Var.e(500L), Long.class);
        if (l10 != null) {
            return l10.longValue();
        }
        long jNextLong = new Random(System.nanoTime() ^ System.currentTimeMillis()).nextLong();
        int i = k1Var.f2506d + 1;
        k1Var.f2506d = i;
        return jNextLong + ((long) i);
    }

    @Override // f9.y2
    public final void b(String str, String str2, Bundle bundle) {
        k1 k1Var = this.f3652a;
        k1Var.c(new x0(k1Var, str, str2, bundle, 0));
    }

    @Override // f9.y2
    public final String c() {
        g0 g0Var = new g0();
        k1 k1Var = this.f3652a;
        k1Var.c(new c1(k1Var, g0Var, 3));
        return (String) g0.f(g0Var.e(500L), String.class);
    }

    @Override // f9.y2
    public final String d() {
        g0 g0Var = new g0();
        k1 k1Var = this.f3652a;
        k1Var.c(new c1(k1Var, g0Var, 4));
        return (String) g0.f(g0Var.e(500L), String.class);
    }

    @Override // f9.y2
    public final List e(String str, String str2) {
        return this.f3652a.f(str, str2);
    }

    @Override // f9.y2
    public final void f(Bundle bundle) {
        k1 k1Var = this.f3652a;
        k1Var.c(new w0(k1Var, bundle));
    }

    @Override // f9.y2
    public final int g(String str) {
        return this.f3652a.b(str);
    }

    @Override // f9.y2
    public final String h() {
        g0 g0Var = new g0();
        k1 k1Var = this.f3652a;
        k1Var.c(new c1(k1Var, g0Var, 1));
        return (String) g0.f(g0Var.e(50L), String.class);
    }

    @Override // f9.y2
    public final void i(String str) {
        k1 k1Var = this.f3652a;
        k1Var.c(new a1(k1Var, str, 1));
    }

    @Override // f9.y2
    public final String j() {
        g0 g0Var = new g0();
        k1 k1Var = this.f3652a;
        k1Var.c(new c1(k1Var, g0Var, 0));
        return (String) g0.f(g0Var.e(500L), String.class);
    }

    @Override // f9.y2
    public final void k(String str, String str2, Bundle bundle) {
        k1 k1Var = this.f3652a;
        k1Var.c(new x0(k1Var, str, str2, bundle, 1));
    }

    @Override // f9.y2
    public final Map l(String str, String str2, boolean z10) {
        return this.f3652a.a(str, str2, z10);
    }

    @Override // f9.y2
    public final void m(String str) {
        k1 k1Var = this.f3652a;
        k1Var.c(new a1(k1Var, str, 0));
    }
}
