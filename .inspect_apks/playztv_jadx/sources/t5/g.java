package t5;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l5.w;
import s5.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends b {
    public final n5.d C;
    public final c D;

    public g(w wVar, e eVar, c cVar, l5.j jVar) {
        super(wVar, eVar);
        this.D = cVar;
        n5.d dVar = new n5.d(wVar, this, new m("__container", eVar.f12177a, false), jVar);
        this.C = dVar;
        List list = Collections.EMPTY_LIST;
        dVar.c(list, list);
    }

    @Override // t5.b, n5.e
    public final void a(RectF rectF, Matrix matrix, boolean z2) {
        super.a(rectF, matrix, z2);
        this.C.a(rectF, this.f12164n, z2);
    }

    @Override // t5.b
    public final void k(Canvas canvas, Matrix matrix, int i) {
        this.C.e(canvas, matrix, i);
    }

    @Override // t5.b
    public final q0.e l() {
        q0.e eVar = this.f12166p.f12197w;
        return eVar != null ? eVar : this.D.f12166p.f12197w;
    }

    @Override // t5.b
    public final zc.c m() {
        zc.c cVar = this.f12166p.f12198x;
        return cVar != null ? cVar : this.D.f12166p.f12198x;
    }

    @Override // t5.b
    public final void q(q5.e eVar, int i, ArrayList arrayList, q5.e eVar2) {
        this.C.g(eVar, i, arrayList, eVar2);
    }
}
