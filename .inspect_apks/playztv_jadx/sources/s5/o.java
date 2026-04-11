package s5;

import java.util.ArrayList;
import l5.w;
import n5.s;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r5.b f11852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f11853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r5.a f11854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r5.a f11855e;
    public final r5.b f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f11856g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f11857h;
    public final float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f11858j;

    public o(String str, r5.b bVar, ArrayList arrayList, r5.a aVar, r5.a aVar2, r5.b bVar2, int i, int i10, float f, boolean z2) {
        this.f11851a = str;
        this.f11852b = bVar;
        this.f11853c = arrayList;
        this.f11854d = aVar;
        this.f11855e = aVar2;
        this.f = bVar2;
        this.f11856g = i;
        this.f11857h = i10;
        this.i = f;
        this.f11858j = z2;
    }

    @Override // s5.b
    public final n5.c a(w wVar, l5.j jVar, t5.b bVar) {
        return new s(wVar, bVar, this);
    }
}
