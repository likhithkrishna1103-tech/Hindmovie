package r2;

import a2.a2;
import java.util.Objects;
import p1.n1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a2[] f11358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r[] f11359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n1 f11360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f11361e;

    public v(a2[] a2VarArr, r[] rVarArr, n1 n1Var, Object obj) {
        s1.d.b(a2VarArr.length == rVarArr.length);
        this.f11358b = a2VarArr;
        this.f11359c = (r[]) rVarArr.clone();
        this.f11360d = n1Var;
        this.f11361e = obj;
        this.f11357a = a2VarArr.length;
    }

    public final boolean a(v vVar, int i) {
        return vVar != null && Objects.equals(this.f11358b[i], vVar.f11358b[i]) && Objects.equals(this.f11359c[i], vVar.f11359c[i]);
    }

    public final boolean b(int i) {
        return this.f11358b[i] != null;
    }
}
