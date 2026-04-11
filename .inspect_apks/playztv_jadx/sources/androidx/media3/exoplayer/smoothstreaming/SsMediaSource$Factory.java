package androidx.media3.exoplayer.smoothstreaming;

import a7.b;
import com.bumptech.glide.manager.s;
import com.google.android.gms.internal.measurement.k4;
import java.util.List;
import k8.a0;
import k8.b0;
import o2.a;
import o2.c0;
import p1.g0;
import v1.g;
import wb.c;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class SsMediaSource$Factory implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f1584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f1585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k8.c0 f1586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f1587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a0 f1588e;
    public final long f;

    public SsMediaSource$Factory(g gVar) {
        s sVar = new s(gVar);
        this.f1584a = sVar;
        this.f1585b = gVar;
        this.f1587d = new b(18);
        this.f1588e = new a0(25);
        this.f = 30000L;
        this.f1586c = new k8.c0(19);
        sVar.f2862w = true;
    }

    @Override // o2.c0
    public final c0 a(boolean z2) {
        this.f1584a.f2862w = z2;
        return this;
    }

    @Override // o2.c0
    public final a c(g0 g0Var) {
        g0Var.f9757b.getClass();
        c cVar = new c(28);
        List list = g0Var.f9757b.f9669e;
        return new m2.c(g0Var, this.f1585b, !list.isEmpty() ? new k4(cVar, list) : cVar, this.f1584a, this.f1586c, this.f1587d.b(g0Var), this.f1588e, this.f);
    }

    @Override // o2.c0
    public final c0 d(b0 b0Var) {
        this.f1584a.f2861v = b0Var;
        return this;
    }

    @Override // o2.c0
    public final c0 b() {
        return this;
    }
}
