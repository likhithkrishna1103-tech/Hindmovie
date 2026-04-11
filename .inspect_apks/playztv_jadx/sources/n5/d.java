package n5;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
import l5.w;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements e, m, o5.a, q5.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m5.a f8705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f8706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f8707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Path f8708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f8709e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f8710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f8711h;
    public final w i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f8712j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final o5.q f8713k;

    public d(w wVar, t5.b bVar, s5.m mVar, l5.j jVar) {
        r5.d dVar;
        String str = mVar.f11844a;
        boolean z2 = mVar.f11846c;
        List list = mVar.f11845b;
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVarA = ((s5.b) list.get(i10)).a(wVar, jVar, bVar);
            if (cVarA != null) {
                arrayList.add(cVarA);
            }
        }
        while (true) {
            if (i >= list.size()) {
                dVar = null;
                break;
            }
            s5.b bVar2 = (s5.b) list.get(i);
            if (bVar2 instanceof r5.d) {
                dVar = (r5.d) bVar2;
                break;
            }
            i++;
        }
        this(wVar, bVar, str, z2, arrayList, dVar);
    }

    @Override // n5.e
    public final void a(RectF rectF, Matrix matrix, boolean z2) {
        Matrix matrix2 = this.f8707c;
        matrix2.set(matrix);
        o5.q qVar = this.f8713k;
        if (qVar != null) {
            matrix2.preConcat(qVar.e());
        }
        RectF rectF2 = this.f8709e;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        ArrayList arrayList = this.f8711h;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            c cVar = (c) arrayList.get(size);
            if (cVar instanceof e) {
                ((e) cVar).a(rectF2, matrix2, z2);
                rectF.union(rectF2);
            }
        }
    }

    @Override // o5.a
    public final void b() {
        this.i.invalidateSelf();
    }

    @Override // n5.c
    public final void c(List list, List list2) {
        int size = list.size();
        ArrayList arrayList = this.f8711h;
        ArrayList arrayList2 = new ArrayList(arrayList.size() + size);
        arrayList2.addAll(list);
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            c cVar = (c) arrayList.get(size2);
            cVar.c(arrayList2, arrayList.subList(0, size2));
            arrayList2.add(cVar);
        }
    }

    public final List d() {
        if (this.f8712j == null) {
            this.f8712j = new ArrayList();
            int i = 0;
            while (true) {
                ArrayList arrayList = this.f8711h;
                if (i >= arrayList.size()) {
                    break;
                }
                c cVar = (c) arrayList.get(i);
                if (cVar instanceof m) {
                    this.f8712j.add((m) cVar);
                }
                i++;
            }
        }
        return this.f8712j;
    }

    @Override // n5.e
    public final void e(Canvas canvas, Matrix matrix, int i) {
        if (this.f8710g) {
            return;
        }
        Matrix matrix2 = this.f8707c;
        matrix2.set(matrix);
        o5.q qVar = this.f8713k;
        if (qVar != null) {
            matrix2.preConcat(qVar.e());
            i = (int) (((((qVar.f9415j == null ? 100 : ((Integer) r9.e()).intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z2 = this.i.M;
        boolean z10 = false;
        ArrayList arrayList = this.f8711h;
        if (z2) {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (i10 >= arrayList.size()) {
                    break;
                }
                if (!(arrayList.get(i10) instanceof e) || (i11 = i11 + 1) < 2) {
                    i10++;
                } else if (i != 255) {
                    z10 = true;
                }
            }
        }
        if (z10) {
            RectF rectF = this.f8706b;
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            a(rectF, matrix2, true);
            m5.a aVar = this.f8705a;
            aVar.setAlpha(i);
            b8.j jVar = x5.g.f14267a;
            canvas.saveLayer(rectF, aVar);
        }
        if (z10) {
            i = 255;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Object obj = arrayList.get(size);
            if (obj instanceof e) {
                ((e) obj).e(canvas, matrix2, i);
            }
        }
        if (z10) {
            canvas.restore();
        }
    }

    @Override // n5.m
    public final Path f() {
        Matrix matrix = this.f8707c;
        matrix.reset();
        o5.q qVar = this.f8713k;
        if (qVar != null) {
            matrix.set(qVar.e());
        }
        Path path = this.f8708d;
        path.reset();
        if (!this.f8710g) {
            ArrayList arrayList = this.f8711h;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                c cVar = (c) arrayList.get(size);
                if (cVar instanceof m) {
                    path.addPath(((m) cVar).f(), matrix);
                }
            }
        }
        return path;
    }

    @Override // q5.f
    public final void g(q5.e eVar, int i, ArrayList arrayList, q5.e eVar2) {
        String str = this.f;
        if (!eVar.c(str, i) && !"__container".equals(str)) {
            return;
        }
        if (!"__container".equals(str)) {
            q5.e eVar3 = new q5.e(eVar2);
            eVar3.f11011a.add(str);
            if (eVar.a(str, i)) {
                q5.e eVar4 = new q5.e(eVar3);
                eVar4.f11012b = this;
                arrayList.add(eVar4);
            }
            eVar2 = eVar3;
        }
        if (!eVar.d(str, i)) {
            return;
        }
        int iB = eVar.b(str, i) + i;
        int i10 = 0;
        while (true) {
            ArrayList arrayList2 = this.f8711h;
            if (i10 >= arrayList2.size()) {
                return;
            }
            c cVar = (c) arrayList2.get(i10);
            if (cVar instanceof q5.f) {
                ((q5.f) cVar).g(eVar, iB, arrayList, eVar2);
            }
            i10++;
        }
    }

    @Override // n5.c
    public final String getName() {
        throw null;
    }

    @Override // q5.f
    public final void h(Object obj, p2.c cVar) {
        o5.q qVar = this.f8713k;
        if (qVar != null) {
            qVar.c(obj, cVar);
        }
    }

    public d(w wVar, t5.b bVar, String str, boolean z2, ArrayList arrayList, r5.d dVar) {
        this.f8705a = new m5.a();
        this.f8706b = new RectF();
        this.f8707c = new Matrix();
        this.f8708d = new Path();
        this.f8709e = new RectF();
        this.f = str;
        this.i = wVar;
        this.f8710g = z2;
        this.f8711h = arrayList;
        if (dVar != null) {
            o5.q qVar = new o5.q(dVar);
            this.f8713k = qVar;
            qVar.a(bVar);
            qVar.b(this);
        }
        ArrayList arrayList2 = new ArrayList();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            c cVar = (c) arrayList.get(size);
            if (cVar instanceof j) {
                arrayList2.add((j) cVar);
            }
        }
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList2.get(size2)).d(arrayList.listIterator(arrayList.size()));
        }
    }
}
