package o6;

import ag.o;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.RectF;
import g6.a0;
import g6.w;
import j6.s;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a {
    public j6.e D;
    public final ArrayList E;
    public final RectF F;
    public final RectF G;
    public final RectF H;
    public final s6.h I;
    public final o J;
    public float K;
    public boolean L;
    public final j6.h M;

    public b(w wVar, d dVar, List list, g6.i iVar) {
        a aVar;
        a bVar;
        String str;
        super(wVar, dVar);
        this.E = new ArrayList();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new RectF();
        this.I = new s6.h();
        this.J = new o(8, (byte) 0);
        this.L = true;
        m6.b bVar2 = dVar.f9548s;
        if (bVar2 != null) {
            j6.i iVarD0 = bVar2.D0();
            this.D = iVarD0;
            d(iVarD0);
            this.D.a(this);
        } else {
            this.D = null;
        }
        v.h hVar = new v.h(iVar.f5093j.size());
        int size = list.size() - 1;
        a aVar2 = null;
        while (true) {
            if (size < 0) {
                for (int i = 0; i < hVar.i(); i++) {
                    a aVar3 = (a) hVar.d(hVar.g(i));
                    if (aVar3 != null && (aVar = (a) hVar.d(aVar3.f9521p.f)) != null) {
                        aVar3.f9525t = aVar;
                    }
                }
                dd.c cVar = this.f9521p.f9553x;
                if (cVar != null) {
                    this.M = new j6.h(this, this, cVar);
                    return;
                }
                return;
            }
            d dVar2 = (d) list.get(size);
            int iC = y.e.c(dVar2.f9536e);
            if (iC == 0) {
                bVar = new b(wVar, dVar2, (List) iVar.f5088c.get(dVar2.f9537g), iVar);
            } else if (iC == 1) {
                bVar = new g(wVar, dVar2);
            } else if (iC == 2) {
                bVar = new c(wVar, dVar2);
            } else if (iC == 3) {
                bVar = new e(wVar, dVar2);
            } else if (iC == 4) {
                bVar = new f(wVar, dVar2, this, iVar);
            } else if (iC != 5) {
                switch (dVar2.f9536e) {
                    case 1:
                        str = "PRE_COMP";
                        break;
                    case 2:
                        str = "SOLID";
                        break;
                    case 3:
                        str = "IMAGE";
                        break;
                    case g1.h.LONG_FIELD_NUMBER /* 4 */:
                        str = "NULL";
                        break;
                    case g1.h.STRING_FIELD_NUMBER /* 5 */:
                        str = "SHAPE";
                        break;
                    case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                        str = "TEXT";
                        break;
                    case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                        str = "UNKNOWN";
                        break;
                    default:
                        str = "null";
                        break;
                }
                s6.c.b("Unknown layer type ".concat(str));
                bVar = null;
            } else {
                bVar = new i(wVar, dVar2);
            }
            if (bVar != null) {
                hVar.h(bVar.f9521p.f9535d, bVar);
                if (aVar2 != null) {
                    aVar2.f9524s = bVar;
                    aVar2 = null;
                } else {
                    this.E.add(0, bVar);
                    int iC2 = y.e.c(dVar2.f9550u);
                    if (iC2 == 1 || iC2 == 2) {
                        aVar2 = bVar;
                    }
                }
            }
            size--;
        }
    }

    @Override // o6.a, i6.f
    public final void a(RectF rectF, Matrix matrix, boolean z10) {
        super.a(rectF, matrix, z10);
        ArrayList arrayList = this.E;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            RectF rectF2 = this.F;
            rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
            ((a) arrayList.get(size)).a(rectF2, this.f9519n, true);
            rectF.union(rectF2);
        }
    }

    @Override // o6.a, l6.f
    public final void h(Object obj, nb.w wVar) {
        super.h(obj, wVar);
        if (obj == a0.C) {
            s sVar = new s(null, wVar);
            this.D = sVar;
            sVar.a(this);
            d(this.D);
            return;
        }
        j6.h hVar = this.M;
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
        Canvas canvasE;
        j6.h hVar = this.M;
        int i10 = 0;
        boolean z10 = (aVar == null && hVar == null) ? false : true;
        w wVar = this.f9520o;
        boolean z11 = wVar.N;
        ArrayList arrayList = this.E;
        boolean z12 = (z11 && arrayList.size() > 1 && i != 255) || (z10 && wVar.O);
        int i11 = z12 ? 255 : i;
        if (hVar != null) {
            aVar = hVar.a(matrix, i11);
        }
        boolean z13 = this.L;
        d dVar = this.f9521p;
        RectF rectF = this.G;
        if (z13 || !"__container".equals(dVar.f9534c)) {
            rectF.set(0.0f, 0.0f, dVar.f9544o, dVar.f9545p);
            matrix.mapRect(rectF);
        } else {
            rectF.setEmpty();
            int size = arrayList.size();
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                RectF rectF2 = this.H;
                ((a) obj).a(rectF2, matrix, true);
                rectF.union(rectF2);
            }
        }
        s6.h hVar2 = this.I;
        if (z12) {
            o oVar = this.J;
            oVar.f455x = null;
            oVar.f454w = i;
            if (aVar != null) {
                if (Color.alpha(aVar.f11544d) > 0) {
                    oVar.f455x = aVar;
                } else {
                    oVar.f455x = null;
                }
                aVar = null;
            }
            canvasE = hVar2.e(canvas, rectF, oVar);
        } else {
            canvasE = canvas;
        }
        canvas.save();
        if (canvas.clipRect(rectF)) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                ((a) arrayList.get(size2)).e(canvasE, matrix, i11, aVar);
            }
        }
        if (z12) {
            hVar2.c();
        }
        canvas.restore();
    }

    @Override // o6.a
    public final void p(l6.e eVar, int i, ArrayList arrayList, l6.e eVar2) {
        int i10 = 0;
        while (true) {
            ArrayList arrayList2 = this.E;
            if (i10 >= arrayList2.size()) {
                return;
            }
            ((a) arrayList2.get(i10)).g(eVar, i, arrayList, eVar2);
            i10++;
        }
    }

    @Override // o6.a
    public final void q(boolean z10) {
        super.q(z10);
        ArrayList arrayList = this.E;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((a) obj).q(z10);
        }
    }

    @Override // o6.a
    public final void r(float f) {
        this.K = f;
        super.r(f);
        j6.e eVar = this.D;
        d dVar = this.f9521p;
        if (eVar != null) {
            g6.i iVar = this.f9520o.f5152v;
            f = ((((Float) eVar.e()).floatValue() * dVar.f9533b.f5097n) - dVar.f9533b.f5095l) / ((iVar.f5096m - iVar.f5095l) + 0.01f);
        }
        if (this.D == null) {
            float f10 = dVar.f9543n;
            g6.i iVar2 = dVar.f9533b;
            f -= f10 / (iVar2.f5096m - iVar2.f5095l);
        }
        if (dVar.f9542m != 0.0f && !"__container".equals(dVar.f9534c)) {
            f /= dVar.f9542m;
        }
        ArrayList arrayList = this.E;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((a) arrayList.get(size)).r(f);
        }
    }
}
