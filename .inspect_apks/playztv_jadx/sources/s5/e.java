package s5;

import java.util.ArrayList;
import l5.w;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r5.a f11806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r5.a f11807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r5.a f11808e;
    public final r5.a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r5.b f11809g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f11810h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f11811j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f11812k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final r5.b f11813l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f11814m;

    public e(String str, int i, r5.a aVar, r5.a aVar2, r5.a aVar3, r5.a aVar4, r5.b bVar, int i10, int i11, float f, ArrayList arrayList, r5.b bVar2, boolean z2) {
        this.f11804a = str;
        this.f11805b = i;
        this.f11806c = aVar;
        this.f11807d = aVar2;
        this.f11808e = aVar3;
        this.f = aVar4;
        this.f11809g = bVar;
        this.f11810h = i10;
        this.i = i11;
        this.f11811j = f;
        this.f11812k = arrayList;
        this.f11813l = bVar2;
        this.f11814m = z2;
    }

    @Override // s5.b
    public final n5.c a(w wVar, l5.j jVar, t5.b bVar) {
        return new n5.i(wVar, bVar, this);
    }
}
