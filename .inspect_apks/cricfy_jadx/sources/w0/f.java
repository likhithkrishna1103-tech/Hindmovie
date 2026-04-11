package w0;

import android.graphics.RectF;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import nb.w;
import t0.p1;
import t0.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends a7.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final HashMap f13771x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ g f13772y;

    public f(g gVar) {
        super(5, false);
        this.f13772y = gVar;
        this.f13771x = new HashMap();
    }

    @Override // a7.a
    public final void f1(z0 z0Var) {
        ArrayList arrayList = this.f13772y.f13774b;
        if ((z0Var.f11831a.d() & 519) != 0) {
            this.f13771x.remove(z0Var);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                c cVar = (c) arrayList.get(size);
                int i = cVar.f13765e;
                boolean z10 = i > 0;
                int i10 = i - 1;
                cVar.f13765e = i10;
                if (z10 && i10 == 0) {
                    cVar.c();
                }
            }
        }
    }

    @Override // a7.a
    public final void g1(z0 z0Var) {
        ArrayList arrayList = this.f13772y.f13774b;
        if ((z0Var.f11831a.d() & 519) != 0) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((c) arrayList.get(size)).f13765e++;
            }
        }
    }

    @Override // a7.a
    public final p1 h1(p1 p1Var, List list) {
        ArrayList arrayList = this.f13772y.f13774b;
        RectF rectF = new RectF(1.0f, 1.0f, 1.0f, 1.0f);
        int i = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            z0 z0Var = (z0) list.get(size);
            Integer num = (Integer) this.f13771x.get(z0Var);
            if (num != null) {
                int iIntValue = num.intValue();
                float fA = z0Var.f11831a.a();
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
        l0.c cVarB = l0.c.b(p1Var.f11791a.f(519), p1Var.f11791a.f(64));
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            c cVar = (c) arrayList.get(size2);
            l0.c cVar2 = cVar.f13764d;
            ArrayList arrayList2 = cVar.f13761a;
            for (int size3 = arrayList2.size() - 1; size3 >= 0; size3--) {
                a aVar = (a) arrayList2.get(size3);
                int i10 = aVar.f13747a;
                if ((i10 & i) != 0) {
                    b bVar = aVar.f13748b;
                    if (!bVar.f13757d) {
                        bVar.f13757d = true;
                        vb.b bVar2 = bVar.i;
                        if (bVar2 != null) {
                            ((View) bVar2.f13552x).setVisibility(0);
                        }
                    }
                    if (i10 == 1) {
                        int i11 = cVar2.f7602a;
                        if (i11 > 0) {
                            aVar.b(cVarB.f7602a / i11);
                        }
                        aVar.a(rectF.left);
                    } else if (i10 == 2) {
                        int i12 = cVar2.f7603b;
                        if (i12 > 0) {
                            aVar.b(cVarB.f7603b / i12);
                        }
                        aVar.a(rectF.top);
                    } else if (i10 == 4) {
                        int i13 = cVar2.f7604c;
                        if (i13 > 0) {
                            aVar.b(cVarB.f7604c / i13);
                        }
                        aVar.a(rectF.right);
                    } else if (i10 == 8) {
                        int i14 = cVar2.f7605d;
                        if (i14 > 0) {
                            aVar.b(cVarB.f7605d / i14);
                        }
                        aVar.a(rectF.bottom);
                    }
                }
            }
        }
        return p1Var;
    }

    @Override // a7.a
    public final w i1(z0 z0Var, w wVar) {
        if ((z0Var.f11831a.d() & 519) != 0) {
            l0.c cVar = (l0.c) wVar.f9017x;
            l0.c cVar2 = (l0.c) wVar.f9016w;
            int i = cVar.f7602a != cVar2.f7602a ? 1 : 0;
            if (cVar.f7603b != cVar2.f7603b) {
                i |= 2;
            }
            if (cVar.f7604c != cVar2.f7604c) {
                i |= 4;
            }
            if (cVar.f7605d != cVar2.f7605d) {
                i |= 8;
            }
            this.f13771x.put(z0Var, Integer.valueOf(i));
        }
        return wVar;
    }
}
