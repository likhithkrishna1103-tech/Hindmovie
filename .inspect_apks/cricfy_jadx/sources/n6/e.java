package n6;

import g6.w;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m6.a f8790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m6.a f8791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m6.a f8792e;
    public final m6.a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m6.b f8793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f8794h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f8795j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f8796k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final m6.b f8797l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f8798m;

    public e(String str, int i, m6.a aVar, m6.a aVar2, m6.a aVar3, m6.a aVar4, m6.b bVar, int i10, int i11, float f, ArrayList arrayList, m6.b bVar2, boolean z10) {
        this.f8788a = str;
        this.f8789b = i;
        this.f8790c = aVar;
        this.f8791d = aVar2;
        this.f8792e = aVar3;
        this.f = aVar4;
        this.f8793g = bVar;
        this.f8794h = i10;
        this.i = i11;
        this.f8795j = f;
        this.f8796k = arrayList;
        this.f8797l = bVar2;
        this.f8798m = z10;
    }

    @Override // n6.b
    public final i6.d a(w wVar, g6.i iVar, o6.a aVar) {
        return new i6.j(wVar, aVar, this);
    }
}
