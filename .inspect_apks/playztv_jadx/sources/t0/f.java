package t0;

import android.graphics.RectF;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import q0.b1;
import q0.r1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends c3.e {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final HashMap f11987w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ g f11988x;

    public f(g gVar) {
        super(6, false);
        this.f11988x = gVar;
        this.f11987w = new HashMap();
    }

    @Override // c3.e
    public final void f1(b1 b1Var) {
        ArrayList arrayList = this.f11988x.f11990b;
        if ((b1Var.f10421a.d() & 519) != 0) {
            this.f11987w.remove(b1Var);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                c cVar = (c) arrayList.get(size);
                int i = cVar.f11981e;
                boolean z2 = i > 0;
                int i10 = i - 1;
                cVar.f11981e = i10;
                if (z2 && i10 == 0) {
                    cVar.c();
                }
            }
        }
    }

    @Override // c3.e
    public final void g1(b1 b1Var) {
        ArrayList arrayList = this.f11988x.f11990b;
        if ((b1Var.f10421a.d() & 519) != 0) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((c) arrayList.get(size)).f11981e++;
            }
        }
    }

    @Override // c3.e
    public final r1 h1(r1 r1Var, List list) {
        ArrayList arrayList = this.f11988x.f11990b;
        RectF rectF = new RectF(1.0f, 1.0f, 1.0f, 1.0f);
        int i = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            b1 b1Var = (b1) list.get(size);
            Integer num = (Integer) this.f11987w.get(b1Var);
            if (num != null) {
                int iIntValue = num.intValue();
                float fA = b1Var.f10421a.a();
                if ((iIntValue & 1) != 0) {
                    rectF.left = fA;
                }
                if ((iIntValue & 2) != 0) {
                    rectF.top = fA;
                }
                if ((iIntValue & 4) != 0) {
                    rectF.right = fA;
                }
                if ((iIntValue & 8) != 0) {
                    rectF.bottom = fA;
                }
                i |= iIntValue;
            }
        }
        i0.d dVarB = i0.d.b(r1Var.f10492a.f(519), r1Var.f10492a.f(64));
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            c cVar = (c) arrayList.get(size2);
            i0.d dVar = cVar.f11980d;
            ArrayList arrayList2 = cVar.f11977a;
            for (int size3 = arrayList2.size() - 1; size3 >= 0; size3--) {
                a aVar = (a) arrayList2.get(size3);
                int i10 = aVar.f11963a;
                if ((i10 & i) != 0) {
                    b bVar = aVar.f11964b;
                    if (!bVar.f11973d) {
                        bVar.f11973d = true;
                        p2.c cVar2 = bVar.i;
                        if (cVar2 != null) {
                            ((View) cVar2.f10131w).setVisibility(0);
                        }
                    }
                    if (i10 == 1) {
                        int i11 = dVar.f6161a;
                        if (i11 > 0) {
                            aVar.b(dVarB.f6161a / i11);
                        }
                        aVar.a(rectF.left);
                    } else if (i10 == 2) {
                        int i12 = dVar.f6162b;
                        if (i12 > 0) {
                            aVar.b(dVarB.f6162b / i12);
                        }
                        aVar.a(rectF.top);
                    } else if (i10 == 4) {
                        int i13 = dVar.f6163c;
                        if (i13 > 0) {
                            aVar.b(dVarB.f6163c / i13);
                        }
                        aVar.a(rectF.right);
                    } else if (i10 == 8) {
                        int i14 = dVar.f6164d;
                        if (i14 > 0) {
                            aVar.b(dVarB.f6164d / i14);
                        }
                        aVar.a(rectF.bottom);
                    }
                }
            }
        }
        return r1Var;
    }

    @Override // c3.e
    public final pb.c i1(b1 b1Var, pb.c cVar) {
        if ((b1Var.f10421a.d() & 519) != 0) {
            i0.d dVar = (i0.d) cVar.f10311w;
            i0.d dVar2 = (i0.d) cVar.f10310v;
            int i = dVar.f6161a != dVar2.f6161a ? 1 : 0;
            if (dVar.f6162b != dVar2.f6162b) {
                i |= 2;
            }
            if (dVar.f6163c != dVar2.f6163c) {
                i |= 4;
            }
            if (dVar.f6164d != dVar2.f6164d) {
                i |= 8;
            }
            this.f11987w.put(b1Var, Integer.valueOf(i));
        }
        return cVar;
    }
}
