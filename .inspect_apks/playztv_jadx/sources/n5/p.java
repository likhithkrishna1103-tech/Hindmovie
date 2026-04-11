package n5;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import l5.w;
import l5.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p implements e, m, j, o5.a, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f8790a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f8791b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f8792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t5.b f8793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f8794e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o5.i f8795g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o5.i f8796h;
    public final o5.q i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f8797j;

    public p(w wVar, t5.b bVar, s5.i iVar) {
        this.f8792c = wVar;
        this.f8793d = bVar;
        this.f8794e = iVar.f11831b;
        this.f = iVar.f11833d;
        o5.e eVarD0 = iVar.f11832c.D0();
        this.f8795g = (o5.i) eVarD0;
        bVar.d(eVarD0);
        eVarD0.a(this);
        o5.e eVarD02 = ((r5.b) iVar.f11834e).D0();
        this.f8796h = (o5.i) eVarD02;
        bVar.d(eVarD02);
        eVarD02.a(this);
        r5.d dVar = (r5.d) iVar.f;
        dVar.getClass();
        o5.q qVar = new o5.q(dVar);
        this.i = qVar;
        qVar.a(bVar);
        qVar.b(this);
    }

    @Override // n5.e
    public final void a(RectF rectF, Matrix matrix, boolean z2) {
        this.f8797j.a(rectF, matrix, z2);
    }

    @Override // o5.a
    public final void b() {
        this.f8792c.invalidateSelf();
    }

    @Override // n5.c
    public final void c(List list, List list2) {
        this.f8797j.c(list, list2);
    }

    @Override // n5.j
    public final void d(ListIterator listIterator) {
        if (this.f8797j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add((c) listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f8797j = new d(this.f8792c, this.f8793d, "Repeater", this.f, arrayList, null);
    }

    @Override // n5.e
    public final void e(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = ((Float) this.f8795g.e()).floatValue();
        float fFloatValue2 = ((Float) this.f8796h.e()).floatValue();
        o5.q qVar = this.i;
        float fFloatValue3 = ((Float) qVar.f9418m.e()).floatValue() / 100.0f;
        float fFloatValue4 = ((Float) qVar.f9419n.e()).floatValue() / 100.0f;
        for (int i10 = ((int) fFloatValue) - 1; i10 >= 0; i10--) {
            Matrix matrix2 = this.f8790a;
            matrix2.set(matrix);
            float f = i10;
            matrix2.preConcat(qVar.f(f + fFloatValue2));
            this.f8797j.e(canvas, matrix2, (int) (x5.f.e(fFloatValue3, fFloatValue4, f / fFloatValue) * i));
        }
    }

    @Override // n5.m
    public final Path f() {
        Path pathF = this.f8797j.f();
        Path path = this.f8791b;
        path.reset();
        float fFloatValue = ((Float) this.f8795g.e()).floatValue();
        float fFloatValue2 = ((Float) this.f8796h.e()).floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            Matrix matrixF = this.i.f(i + fFloatValue2);
            Matrix matrix = this.f8790a;
            matrix.set(matrixF);
            path.addPath(pathF, matrix);
        }
        return path;
    }

    @Override // q5.f
    public final void g(q5.e eVar, int i, ArrayList arrayList, q5.e eVar2) {
        x5.f.f(eVar, i, arrayList, eVar2, this);
        for (int i10 = 0; i10 < this.f8797j.f8711h.size(); i10++) {
            c cVar = (c) this.f8797j.f8711h.get(i10);
            if (cVar instanceof k) {
                x5.f.f(eVar, i, arrayList, eVar2, (k) cVar);
            }
        }
    }

    @Override // n5.c
    public final String getName() {
        return this.f8794e;
    }

    @Override // q5.f
    public final void h(Object obj, p2.c cVar) {
        if (this.i.c(obj, cVar)) {
            return;
        }
        if (obj == z.f7942p) {
            this.f8795g.j(cVar);
        } else if (obj == z.f7943q) {
            this.f8796h.j(cVar);
        }
    }
}
