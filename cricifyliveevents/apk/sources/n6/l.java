package n6;

import android.graphics.Path;
import g6.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f8823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path.FillType f8824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m6.a f8826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m6.a f8827e;
    public final boolean f;

    public l(String str, boolean z10, Path.FillType fillType, m6.a aVar, m6.a aVar2, boolean z11) {
        this.f8825c = str;
        this.f8823a = z10;
        this.f8824b = fillType;
        this.f8826d = aVar;
        this.f8827e = aVar2;
        this.f = z11;
    }

    @Override // n6.b
    public final i6.d a(w wVar, g6.i iVar, o6.a aVar) {
        return new i6.h(wVar, aVar, this);
    }

    public final String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f8823a + '}';
    }
}
