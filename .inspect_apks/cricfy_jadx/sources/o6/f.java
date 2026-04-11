package o6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import g6.a0;
import g6.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import n6.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends a {
    public final i6.e D;
    public final b E;
    public final j6.h F;

    public f(w wVar, d dVar, b bVar, g6.i iVar) {
        super(wVar, dVar);
        this.E = bVar;
        i6.e eVar = new i6.e(wVar, this, new m("__container", dVar.f9532a, false), iVar);
        this.D = eVar;
        List list = Collections.EMPTY_LIST;
        eVar.c(list, list);
        dd.c cVar = this.f9521p.f9553x;
        if (cVar != null) {
            this.F = new j6.h(this, this, cVar);
        }
    }

    @Override // o6.a, i6.f
    public final void a(RectF rectF, Matrix matrix, boolean z10) {
        super.a(rectF, matrix, z10);
        this.D.a(rectF, this.f9519n, z10);
    }

    @Override // o6.a, l6.f
    public final void h(Object obj, nb.w wVar) {
        super.h(obj, wVar);
        PointF pointF = a0.f5033a;
        j6.h hVar = this.F;
        if (obj == 5 && hVar != null) {
            hVar.f6640c.j(wVar);
            return;
        }
        if (obj == a0.E && hVar != null) {
            hVar.c(wVar);
            return;
        }
        if (obj == a0.F && hVar != null) {
            hVar.f6642e.j(wVar);
            return;
        }
        if (obj == a0.G && hVar != null) {
            hVar.f.j(wVar);
        } else {
            if (obj != a0.H || hVar == null) {
                return;
            }
            hVar.f6643g.j(wVar);
        }
    }

    @Override // o6.a
    public final void k(Canvas canvas, Matrix matrix, int i, s6.a aVar) {
        j6.h hVar = this.F;
        if (hVar != null) {
            aVar = hVar.a(matrix, i);
        }
        this.D.e(canvas, matrix, i, aVar);
    }

    @Override // o6.a
    public final l4.a l() {
        l4.a aVar = this.f9521p.f9552w;
        return aVar != null ? aVar : this.E.f9521p.f9552w;
    }

    @Override // o6.a
    public final void p(l6.e eVar, int i, ArrayList arrayList, l6.e eVar2) {
        this.D.g(eVar, i, arrayList, eVar2);
    }
}
