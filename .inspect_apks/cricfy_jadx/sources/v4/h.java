package v4;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends e0 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f13235s;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f13237h;
    public ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f13238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f13239k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f13240l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f13241m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f13242n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f13243o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f13244p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f13245q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList f13246r;

    public static void h(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((x0) arrayList.get(size)).f13387a.animate().cancel();
        }
    }

    @Override // v4.e0
    public final boolean a(x0 x0Var, x0 x0Var2, d4.e eVar, d4.e eVar2) {
        int i;
        int i10;
        int i11 = eVar.f3356a;
        int i12 = eVar.f3357b;
        if (x0Var2.o()) {
            int i13 = eVar.f3356a;
            i10 = eVar.f3357b;
            i = i13;
        } else {
            i = eVar2.f3356a;
            i10 = eVar2.f3357b;
        }
        if (x0Var == x0Var2) {
            return g(x0Var, i11, i12, i, i10);
        }
        View view = x0Var.f13387a;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        float alpha = view.getAlpha();
        l(x0Var);
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
        view.setAlpha(alpha);
        View view2 = x0Var2.f13387a;
        l(x0Var2);
        view2.setTranslationX(-((int) ((i - i11) - translationX)));
        view2.setTranslationY(-((int) ((i10 - i12) - translationY)));
        view2.setAlpha(0.0f);
        ArrayList arrayList = this.f13239k;
        f fVar = new f();
        fVar.f13217a = x0Var;
        fVar.f13218b = x0Var2;
        fVar.f13219c = i11;
        fVar.f13220d = i12;
        fVar.f13221e = i;
        fVar.f = i10;
        arrayList.add(fVar);
        return true;
    }

    @Override // v4.e0
    public final void d(x0 x0Var) {
        ArrayList arrayList = this.f13240l;
        ArrayList arrayList2 = this.f13241m;
        ArrayList arrayList3 = this.f13242n;
        View view = x0Var.f13387a;
        view.animate().cancel();
        ArrayList arrayList4 = this.f13238j;
        int size = arrayList4.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((g) arrayList4.get(size)).f13226a == x0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                c(x0Var);
                arrayList4.remove(size);
            }
        }
        j(this.f13239k, x0Var);
        if (this.f13237h.remove(x0Var)) {
            view.setAlpha(1.0f);
            c(x0Var);
        }
        if (this.i.remove(x0Var)) {
            view.setAlpha(1.0f);
            c(x0Var);
        }
        for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList5 = (ArrayList) arrayList3.get(size2);
            j(arrayList5, x0Var);
            if (arrayList5.isEmpty()) {
                arrayList3.remove(size2);
            }
        }
        for (int size3 = arrayList2.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList6 = (ArrayList) arrayList2.get(size3);
            int size4 = arrayList6.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((g) arrayList6.get(size4)).f13226a == x0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    c(x0Var);
                    arrayList6.remove(size4);
                    if (arrayList6.isEmpty()) {
                        arrayList2.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = arrayList.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList.get(size5);
            if (arrayList7.remove(x0Var)) {
                view.setAlpha(1.0f);
                c(x0Var);
                if (arrayList7.isEmpty()) {
                    arrayList.remove(size5);
                }
            }
        }
        this.f13245q.remove(x0Var);
        this.f13243o.remove(x0Var);
        this.f13246r.remove(x0Var);
        this.f13244p.remove(x0Var);
        i();
    }

    @Override // v4.e0
    public final void e() {
        ArrayList arrayList = this.f13242n;
        ArrayList arrayList2 = this.f13240l;
        ArrayList arrayList3 = this.f13241m;
        ArrayList arrayList4 = this.f13239k;
        ArrayList arrayList5 = this.i;
        ArrayList arrayList6 = this.f13237h;
        ArrayList arrayList7 = this.f13238j;
        int size = arrayList7.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            g gVar = (g) arrayList7.get(size);
            View view = gVar.f13226a.f13387a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            c(gVar.f13226a);
            arrayList7.remove(size);
        }
        for (int size2 = arrayList6.size() - 1; size2 >= 0; size2--) {
            c((x0) arrayList6.get(size2));
            arrayList6.remove(size2);
        }
        int size3 = arrayList5.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            x0 x0Var = (x0) arrayList5.get(size3);
            x0Var.f13387a.setAlpha(1.0f);
            c(x0Var);
            arrayList5.remove(size3);
        }
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            f fVar = (f) arrayList4.get(size4);
            x0 x0Var2 = fVar.f13217a;
            if (x0Var2 != null) {
                k(fVar, x0Var2);
            }
            x0 x0Var3 = fVar.f13218b;
            if (x0Var3 != null) {
                k(fVar, x0Var3);
            }
        }
        arrayList4.clear();
        if (f()) {
            for (int size5 = arrayList3.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList8 = (ArrayList) arrayList3.get(size5);
                for (int size6 = arrayList8.size() - 1; size6 >= 0; size6--) {
                    g gVar2 = (g) arrayList8.get(size6);
                    View view2 = gVar2.f13226a.f13387a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    c(gVar2.f13226a);
                    arrayList8.remove(size6);
                    if (arrayList8.isEmpty()) {
                        arrayList3.remove(arrayList8);
                    }
                }
            }
            for (int size7 = arrayList2.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList9 = (ArrayList) arrayList2.get(size7);
                for (int size8 = arrayList9.size() - 1; size8 >= 0; size8--) {
                    x0 x0Var4 = (x0) arrayList9.get(size8);
                    x0Var4.f13387a.setAlpha(1.0f);
                    c(x0Var4);
                    arrayList9.remove(size8);
                    if (arrayList9.isEmpty()) {
                        arrayList2.remove(arrayList9);
                    }
                }
            }
            for (int size9 = arrayList.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    f fVar2 = (f) arrayList10.get(size10);
                    x0 x0Var5 = fVar2.f13217a;
                    if (x0Var5 != null) {
                        k(fVar2, x0Var5);
                    }
                    x0 x0Var6 = fVar2.f13218b;
                    if (x0Var6 != null) {
                        k(fVar2, x0Var6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList.remove(arrayList10);
                    }
                }
            }
            h(this.f13245q);
            h(this.f13244p);
            h(this.f13243o);
            h(this.f13246r);
            ArrayList arrayList11 = this.f13213b;
            if (arrayList11.size() > 0) {
                throw q4.a.k(0, arrayList11);
            }
            arrayList11.clear();
        }
    }

    @Override // v4.e0
    public final boolean f() {
        return (this.i.isEmpty() && this.f13239k.isEmpty() && this.f13238j.isEmpty() && this.f13237h.isEmpty() && this.f13244p.isEmpty() && this.f13245q.isEmpty() && this.f13243o.isEmpty() && this.f13246r.isEmpty() && this.f13241m.isEmpty() && this.f13240l.isEmpty() && this.f13242n.isEmpty()) ? false : true;
    }

    public final boolean g(x0 x0Var, int i, int i10, int i11, int i12) {
        View view = x0Var.f13387a;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i10 + ((int) x0Var.f13387a.getTranslationY());
        l(x0Var);
        int i13 = i11 - translationX;
        int i14 = i12 - translationY;
        if (i13 == 0 && i14 == 0) {
            c(x0Var);
            return false;
        }
        if (i13 != 0) {
            view.setTranslationX(-i13);
        }
        if (i14 != 0) {
            view.setTranslationY(-i14);
        }
        ArrayList arrayList = this.f13238j;
        g gVar = new g();
        gVar.f13226a = x0Var;
        gVar.f13227b = translationX;
        gVar.f13228c = translationY;
        gVar.f13229d = i11;
        gVar.f13230e = i12;
        arrayList.add(gVar);
        return true;
    }

    public final void i() {
        if (f()) {
            return;
        }
        ArrayList arrayList = this.f13213b;
        if (arrayList.size() > 0) {
            throw q4.a.k(0, arrayList);
        }
        arrayList.clear();
    }

    public final void j(ArrayList arrayList, x0 x0Var) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            f fVar = (f) arrayList.get(size);
            if (k(fVar, x0Var) && fVar.f13217a == null && fVar.f13218b == null) {
                arrayList.remove(fVar);
            }
        }
    }

    public final boolean k(f fVar, x0 x0Var) {
        if (fVar.f13218b == x0Var) {
            fVar.f13218b = null;
        } else {
            if (fVar.f13217a != x0Var) {
                return false;
            }
            fVar.f13217a = null;
        }
        View view = x0Var.f13387a;
        View view2 = x0Var.f13387a;
        view.setAlpha(1.0f);
        view2.setTranslationX(0.0f);
        view2.setTranslationY(0.0f);
        c(x0Var);
        return true;
    }

    public final void l(x0 x0Var) {
        if (f13235s == null) {
            f13235s = new ValueAnimator().getInterpolator();
        }
        x0Var.f13387a.animate().setInterpolator(f13235s);
        d(x0Var);
    }
}
