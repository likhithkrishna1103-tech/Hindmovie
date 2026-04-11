package s5;

import android.graphics.Path;
import l5.w;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path.FillType f11840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r5.a f11842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r5.a f11843e;
    public final boolean f;

    public l(String str, boolean z2, Path.FillType fillType, r5.a aVar, r5.a aVar2, boolean z10) {
        this.f11841c = str;
        this.f11839a = z2;
        this.f11840b = fillType;
        this.f11842d = aVar;
        this.f11843e = aVar2;
        this.f = z10;
    }

    @Override // s5.b
    public final n5.c a(w wVar, l5.j jVar, t5.b bVar) {
        return new n5.g(wVar, bVar, this);
    }

    public final String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f11839a + '}';
    }
}
