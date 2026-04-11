package i6;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import g6.w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements f, n, j6.a, l6.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ag.o f6232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f6233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s6.h f6234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f6235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f6236e;
    public final RectF f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f6237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f6238h;
    public final ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final w f6239j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f6240k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j6.r f6241l;

    public e(w wVar, o6.a aVar, n6.m mVar, g6.i iVar) {
        m6.e eVar;
        String str = mVar.f8828a;
        boolean z10 = mVar.f8830c;
        List list = mVar.f8829b;
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            d dVarA = ((n6.b) list.get(i10)).a(wVar, iVar, aVar);
            if (dVarA != null) {
                arrayList.add(dVarA);
            }
        }
        while (true) {
            if (i >= list.size()) {
                eVar = null;
                break;
            }
            n6.b bVar = (n6.b) list.get(i);
            if (bVar instanceof m6.e) {
                eVar = (m6.e) bVar;
                break;
            }
            i++;
        }
        this(wVar, aVar, str, z10, arrayList, eVar);
    }

    @Override // i6.f
    public final void a(RectF rectF, Matrix matrix, boolean z10) {
        Matrix matrix2 = this.f6235d;
        matrix2.set(matrix);
        j6.r rVar = this.f6241l;
        if (rVar != null) {
            matrix2.preConcat(rVar.e());
        }
        RectF rectF2 = this.f;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        ArrayList arrayList = this.i;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            d dVar = (d) arrayList.get(size);
            if (dVar instanceof f) {
                ((f) dVar).a(rectF2, matrix2, z10);
                rectF.union(rectF2);
            }
        }
    }

    @Override // j6.a
    public final void b() {
        this.f6239j.invalidateSelf();
    }

    @Override // i6.d
    public final void c(List list, List list2) {
        int size = list.size();
        ArrayList arrayList = this.i;
        ArrayList arrayList2 = new ArrayList(arrayList.size() + size);
        arrayList2.addAll(list);
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            d dVar = (d) arrayList.get(size2);
            dVar.c(arrayList2, arrayList.subList(0, size2));
            arrayList2.add(dVar);
        }
    }

    public final List d() {
        if (this.f6240k == null) {
            this.f6240k = new ArrayList();
            int i = 0;
            while (true) {
                ArrayList arrayList = this.i;
                if (i >= arrayList.size()) {
                    break;
                }
                d dVar = (d) arrayList.get(i);
                if (dVar instanceof n) {
                    this.f6240k.add((n) dVar);
                }
                i++;
            }
        }
        return this.f6240k;
    }

    @Override // i6.f
    public final void e(Canvas canvas, Matrix matrix, int i, s6.a aVar) {
        if (this.f6238h) {
            return;
        }
        Matrix matrix2 = this.f6235d;
        matrix2.set(matrix);
        j6.r rVar = this.f6241l;
        if (rVar != null) {
            matrix2.preConcat(rVar.e());
            i = (int) (((((rVar.f6678p == null ? 100 : ((Integer) r1.e()).intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        w wVar = this.f6239j;
        boolean z10 = (wVar.N && i() && i != 255) || (aVar != null && wVar.O && i());
        int i10 = z10 ? 255 : i;
        s6.h hVar = this.f6234c;
        if (z10) {
            RectF rectF = this.f6233b;
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            a(rectF, matrix, true);
            ag.o oVar = this.f6232a;
            oVar.f454w = i;
            if (aVar != null) {
                if (Color.alpha(aVar.f11544d) > 0) {
                    oVar.f455x = aVar;
                } else {
                    oVar.f455x = null;
                }
                aVar = null;
            } else {
                oVar.f455x = null;
            }
            canvas = hVar.e(canvas, rectF, oVar);
        } else if (aVar != null) {
            s6.a aVar2 = new s6.a(aVar);
            aVar2.b(i10);
            aVar = aVar2;
        }
        ArrayList arrayList = this.i;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Object obj = arrayList.get(size);
            if (obj instanceof f) {
                ((f) obj).e(canvas, matrix2, i10, aVar);
            }
        }
        if (z10) {
            hVar.c();
        }
    }

    @Override // i6.n
    public final Path f() {
        Matrix matrix = this.f6235d;
        matrix.reset();
        j6.r rVar = this.f6241l;
        if (rVar != null) {
            matrix.set(rVar.e());
        }
        Path path = this.f6236e;
        path.reset();
        if (!this.f6238h) {
            ArrayList arrayList = this.i;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                d dVar = (d) arrayList.get(size);
                if (dVar instanceof n) {
                    path.addPath(((n) dVar).f(), matrix);
                }
            }
        }
        return path;
    }

    @Override // l6.f
    public final void g(l6.e eVar, int i, ArrayList arrayList, l6.e eVar2) {
        String str = this.f6237g;
        if (!eVar.c(i, str) && !"__container".equals(str)) {
            return;
        }
        if (!"__container".equals(str)) {
            l6.e eVar3 = new l6.e(eVar2);
            eVar3.f7858a.add(str);
            if (eVar.a(i, str)) {
                l6.e eVar4 = new l6.e(eVar3);
                eVar4.f7859b = this;
                arrayList.add(eVar4);
            }
            eVar2 = eVar3;
        }
        if (!eVar.d(i, str)) {
            return;
        }
        int iB = eVar.b(i, str) + i;
        int i10 = 0;
        while (true) {
            ArrayList arrayList2 = this.i;
            if (i10 >= arrayList2.size()) {
                return;
            }
            d dVar = (d) arrayList2.get(i10);
            if (dVar instanceof l6.f) {
                ((l6.f) dVar).g(eVar, iB, arrayList, eVar2);
            }
            i10++;
        }
    }

    @Override // i6.d
    public final String getName() {
        throw null;
    }

    @Override // l6.f
    public final void h(Object obj, nb.w wVar) {
        j6.r rVar = this.f6241l;
        if (rVar != null) {
            rVar.c(obj, wVar);
        }
    }

    public final boolean i() {
        int i = 0;
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.i;
            if (i >= arrayList.size()) {
                return false;
            }
            if ((arrayList.get(i) instanceof f) && (i10 = i10 + 1) >= 2) {
                return true;
            }
            i++;
        }
    }

    public e(w wVar, o6.a aVar, String str, boolean z10, ArrayList arrayList, m6.e eVar) {
        this.f6232a = new ag.o(8, (byte) 0);
        this.f6233b = new RectF();
        this.f6234c = new s6.h();
        this.f6235d = new Matrix();
        this.f6236e = new Path();
        this.f = new RectF();
        this.f6237g = str;
        this.f6239j = wVar;
        this.f6238h = z10;
        this.i = arrayList;
        if (eVar != null) {
            j6.r rVar = new j6.r(eVar);
            this.f6241l = rVar;
            rVar.a(aVar);
            rVar.b(this);
        }
        ArrayList arrayList2 = new ArrayList();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            d dVar = (d) arrayList.get(size);
            if (dVar instanceof k) {
                arrayList2.add((k) dVar);
            }
        }
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ((k) arrayList2.get(size2)).d(arrayList.listIterator(arrayList.size()));
        }
    }
}
