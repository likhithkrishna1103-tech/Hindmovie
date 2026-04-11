package q0;

import android.os.Build;
import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class o1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r1 f10480b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r1 f10481a;

    static {
        int i = Build.VERSION.SDK_INT;
        f10480b = (i >= 34 ? new g1() : i >= 30 ? new f1() : i >= 29 ? new d1() : new c1()).b().f10492a.a().f10492a.b().f10492a.c();
    }

    public o1(r1 r1Var) {
        this.f10481a = r1Var;
    }

    public r1 a() {
        return this.f10481a;
    }

    public r1 b() {
        return this.f10481a;
    }

    public r1 c() {
        return this.f10481a;
    }

    public j e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o1)) {
            return false;
        }
        o1 o1Var = (o1) obj;
        return o() == o1Var.o() && n() == o1Var.n() && Objects.equals(k(), o1Var.k()) && Objects.equals(i(), o1Var.i()) && Objects.equals(e(), o1Var.e());
    }

    public i0.d f(int i) {
        return i0.d.f6160e;
    }

    public i0.d g(int i) {
        if ((i & 8) == 0) {
            return i0.d.f6160e;
        }
        throw new IllegalArgumentException("Unable to query the maximum insets for IME");
    }

    public i0.d h() {
        return k();
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), e());
    }

    public i0.d i() {
        return i0.d.f6160e;
    }

    public i0.d j() {
        return k();
    }

    public i0.d k() {
        return i0.d.f6160e;
    }

    public i0.d l() {
        return k();
    }

    public r1 m(int i, int i10, int i11, int i12) {
        return f10480b;
    }

    public boolean n() {
        return false;
    }

    public boolean o() {
        return false;
    }

    public void d(View view) {
    }

    public void p(i0.d[] dVarArr) {
    }

    public void q(r1 r1Var) {
    }

    public void r(i0.d dVar) {
    }

    public void s(int i) {
    }
}
