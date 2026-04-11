package hd;

import android.os.Handler;
import androidx.emoji2.text.v;
import i2.x;
import l4.c0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final md.j f5932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dd.g f5933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final id.a f5934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v f5935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f5936e;
    public final c0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d8.j f5937g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x f5938h;

    public f(md.j jVar, dd.g gVar, id.a aVar, v vVar, Handler handler, c0 c0Var, d8.j jVar2, x xVar) {
        ge.i.e(handler, "uiHandler");
        ge.i.e(xVar, "networkInfoProvider");
        this.f5932a = jVar;
        this.f5933b = gVar;
        this.f5934c = aVar;
        this.f5935d = vVar;
        this.f5936e = handler;
        this.f = c0Var;
        this.f5937g = jVar2;
        this.f5938h = xVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return ge.i.a(this.f5932a, fVar.f5932a) && ge.i.a(this.f5933b, fVar.f5933b) && ge.i.a(this.f5934c, fVar.f5934c) && ge.i.a(this.f5935d, fVar.f5935d) && ge.i.a(this.f5936e, fVar.f5936e) && ge.i.a(this.f, fVar.f) && ge.i.a(this.f5937g, fVar.f5937g) && ge.i.a(this.f5938h, fVar.f5938h);
    }

    public final int hashCode() {
        return this.f5938h.hashCode() + ((this.f5937g.hashCode() + ((this.f.hashCode() + ((this.f5936e.hashCode() + ((this.f5935d.hashCode() + ((this.f5934c.hashCode() + ((this.f5933b.hashCode() + 73373293) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Holder(handlerWrapper=" + this.f5932a + ", fetchDatabaseManagerWrapper=" + this.f5933b + ", downloadProvider=" + this.f5934c + ", groupInfoProvider=" + this.f5935d + ", uiHandler=" + this.f5936e + ", downloadManagerCoordinator=" + this.f + ", listenerCoordinator=" + this.f5937g + ", networkInfoProvider=" + this.f5938h + ")";
    }
}
