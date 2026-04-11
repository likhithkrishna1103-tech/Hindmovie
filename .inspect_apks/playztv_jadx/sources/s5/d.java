package s5;

import android.graphics.Path;
import l5.w;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path.FillType f11798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r5.a f11799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r5.a f11800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r5.a f11801e;
    public final r5.a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f11802g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f11803h;

    public d(String str, int i, Path.FillType fillType, r5.a aVar, r5.a aVar2, r5.a aVar3, r5.a aVar4, boolean z2) {
        this.f11797a = i;
        this.f11798b = fillType;
        this.f11799c = aVar;
        this.f11800d = aVar2;
        this.f11801e = aVar3;
        this.f = aVar4;
        this.f11802g = str;
        this.f11803h = z2;
    }

    @Override // s5.b
    public final n5.c a(w wVar, l5.j jVar, t5.b bVar) {
        return new n5.h(wVar, jVar, bVar, this);
    }
}
