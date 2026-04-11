package n6;

import android.graphics.Path;
import g6.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path.FillType f8782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m6.a f8783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m6.a f8784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m6.a f8785e;
    public final m6.a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f8786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f8787h;

    public d(String str, int i, Path.FillType fillType, m6.a aVar, m6.a aVar2, m6.a aVar3, m6.a aVar4, boolean z10) {
        this.f8781a = i;
        this.f8782b = fillType;
        this.f8783c = aVar;
        this.f8784d = aVar2;
        this.f8785e = aVar3;
        this.f = aVar4;
        this.f8786g = str;
        this.f8787h = z10;
    }

    @Override // n6.b
    public final i6.d a(w wVar, g6.i iVar, o6.a aVar) {
        return new i6.i(wVar, iVar, aVar, this);
    }
}
