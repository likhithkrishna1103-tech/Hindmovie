package n6;

import g6.w;
import i6.t;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m6.b f8836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f8837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m6.a f8838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m6.a f8839e;
    public final m6.b f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f8841h;
    public final float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f8842j;

    public o(String str, m6.b bVar, ArrayList arrayList, m6.a aVar, m6.a aVar2, m6.b bVar2, int i, int i10, float f, boolean z10) {
        this.f8835a = str;
        this.f8836b = bVar;
        this.f8837c = arrayList;
        this.f8838d = aVar;
        this.f8839e = aVar2;
        this.f = bVar2;
        this.f8840g = i;
        this.f8841h = i10;
        this.i = f;
        this.f8842j = z10;
    }

    @Override // n6.b
    public final i6.d a(w wVar, g6.i iVar, o6.a aVar) {
        return new t(wVar, aVar, this);
    }
}
