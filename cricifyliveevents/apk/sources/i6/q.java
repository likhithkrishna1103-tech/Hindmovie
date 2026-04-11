package i6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import g6.a0;
import g6.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements f, n, k, j6.a, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f6317a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f6318b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f6319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o6.a f6320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f6321e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j6.i f6322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j6.i f6323h;
    public final j6.r i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f6324j;

    public q(w wVar, o6.a aVar, n6.i iVar) {
        this.f6319c = wVar;
        this.f6320d = aVar;
        this.f6321e = iVar.f8815b;
        this.f = iVar.f8817d;
        j6.i iVarD0 = iVar.f8816c.D0();
        this.f6322g = iVarD0;
        aVar.d(iVarD0);
        iVarD0.a(this);
        j6.i iVarD02 = ((m6.b) iVar.f8818e).D0();
        this.f6323h = iVarD02;
        aVar.d(iVarD02);
        iVarD02.a(this);
        m6.e eVar = (m6.e) iVar.f;
        eVar.getClass();
        j6.r rVar = new j6.r(eVar);
        this.i = rVar;
        rVar.a(aVar);
        rVar.b(this);
    }

    @Override // i6.f
    public final void a(RectF rectF, Matrix matrix, boolean z10) {
        this.f6324j.a(rectF, matrix, z10);
    }

    @Override // j6.a
    public final void b() {
        this.f6319c.invalidateSelf();
    }

    @Override // i6.d
    public final void c(List list, List list2) {
        this.f6324j.c(list, list2);
    }

    @Override // i6.k
    public final void d(ListIterator listIterator) {
        if (this.f6324j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add((d) listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f6324j = new e(this.f6319c, this.f6320d, "Repeater", this.f, arrayList, null);
    }

    @Override // i6.f
    public final void e(Canvas canvas, Matrix matrix, int i, s6.a aVar) {
        float fFloatValue = ((Float) this.f6322g.e()).floatValue();
        float fFloatValue2 = ((Float) this.f6323h.e()).floatValue();
        j6.r rVar = this.i;
        float fFloatValue3 = ((Float) rVar.f6684v.e()).floatValue() / 100.0f;
        float fFloatValue4 = ((Float) rVar.f6685w.e()).floatValue() / 100.0f;
        for (int i10 = ((int) fFloatValue) - 1; i10 >= 0; i10--) {
            Matrix matrix2 = this.f6317a;
            matrix2.set(matrix);
            float f = i10;
            matrix2.preConcat(rVar.f(f + fFloatValue2));
            this.f6324j.e(canvas, matrix2, (int) (s6.g.f(fFloatValue3, fFloatValue4, f / fFloatValue) * i), aVar);
        }
    }

    @Override // i6.n
    public final Path f() {
        Path pathF = this.f6324j.f();
        Path path = this.f6318b;
        path.reset();
        float fFloatValue = ((Float) this.f6322g.e()).floatValue();
        float fFloatValue2 = ((Float) this.f6323h.e()).floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            Matrix matrixF = this.i.f(i + fFloatValue2);
            Matrix matrix = this.f6317a;
            matrix.set(matrixF);
            path.addPath(pathF, matrix);
        }
        return path;
    }

    @Override // l6.f
    public final void g(l6.e eVar, int i, ArrayList arrayList, l6.e eVar2) {
        s6.g.g(eVar, i, arrayList, eVar2, this);
        for (int i10 = 0; i10 < this.f6324j.i.size(); i10++) {
            d dVar = (d) this.f6324j.i.get(i10);
            if (dVar instanceof l) {
                s6.g.g(eVar, i, arrayList, eVar2, (l) dVar);
            }
        }
    }

    @Override // i6.d
    public final String getName() {
        return this.f6321e;
    }

    @Override // l6.f
    public final void h(Object obj, nb.w wVar) {
        if (this.i.c(obj, wVar)) {
            return;
        }
        if (obj == a0.f5049s) {
            this.f6322g.j(wVar);
        } else if (obj == a0.f5050t) {
            this.f6323h.j(wVar);
        }
    }
}
