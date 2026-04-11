package androidx.media3.exoplayer.dash;

import a7.b;
import aa.l0;
import com.google.android.gms.internal.measurement.k4;
import e2.e;
import e6.f0;
import f2.o;
import gc.a;
import java.util.List;
import k8.a0;
import k8.b0;
import o2.c0;
import p1.g0;
import v1.g;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class DashMediaSource$Factory implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f1567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f1568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f1569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k8.c0 f1570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a0 f1571e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f1572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f1573h;

    public DashMediaSource$Factory(g gVar) {
        l0 l0Var = new l0(gVar);
        this.f1567a = l0Var;
        this.f1568b = gVar;
        this.f1569c = new b(18);
        this.f1571e = new a0(25);
        this.f = 30000L;
        this.f1572g = 5000000L;
        this.f1570d = new k8.c0(19);
        ((f0) l0Var.f707x).f4498u = true;
    }

    @Override // o2.c0
    public final c0 a(boolean z2) {
        ((f0) this.f1567a.f707x).f4498u = z2;
        return this;
    }

    @Override // o2.c0
    public final c0 b() {
        ((f0) this.f1567a.f707x).getClass();
        return this;
    }

    @Override // o2.c0
    public final c0 d(b0 b0Var) {
        f0 f0Var = (f0) this.f1567a.f707x;
        f0Var.getClass();
        f0Var.f4499v = b0Var;
        return this;
    }

    @Override // o2.c0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final d2.g c(g0 g0Var) {
        g0Var.f9757b.getClass();
        s2.o eVar = this.f1573h;
        if (eVar == null) {
            eVar = new e();
        }
        List list = g0Var.f9757b.f9669e;
        return new d2.g(g0Var, this.f1568b, !list.isEmpty() ? new k4(eVar, list) : eVar, this.f1567a, this.f1570d, this.f1569c.b(g0Var), this.f1571e, this.f, this.f1572g);
    }
}
