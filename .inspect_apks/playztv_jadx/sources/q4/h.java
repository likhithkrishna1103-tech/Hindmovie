package q4;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends e0 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f10805s;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f10807h;
    public ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f10808j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f10809k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f10810l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f10811m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f10812n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f10813o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f10814p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f10815q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList f10816r;

    public static void h(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((x0) arrayList.get(size)).f10962a.animate().cancel();
        }
    }

    @Override // q4.e0
    public final boolean a(x0 x0Var, x0 x0Var2, b2.m mVar, b2.m mVar2) {
        int i;
        int i10;
        int i11 = mVar.f1761a;
        int i12 = mVar.f1762b;
        if (x0Var2.o()) {
            int i13 = mVar.f1761a;
            i10 = mVar.f1762b;
            i = i13;
        } else {
            i = mVar2.f1761a;
            i10 = mVar2.f1762b;
        }
        if (x0Var == x0Var2) {
            return g(x0Var, i11, i12, i, i10);
        }
        View view = x0Var.f10962a;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        float alpha = view.getAlpha();
        l(x0Var);
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
        view.setAlpha(alpha);
        View view2 = x0Var2.f10962a;
        l(x0Var2);
        view2.setTranslationX(-((int) ((i - i11) - translationX)));
        view2.setTranslationY(-((int) ((i10 - i12) - translationY)));
        view2.setAlpha(0.0f);
        ArrayList arrayList = this.f10809k;
        f fVar = new f();
        fVar.f10787a = x0Var;
        fVar.f10788b = x0Var2;
        fVar.f10789c = i11;
        fVar.f10790d = i12;
        fVar.f10791e = i;
        fVar.f = i10;
        arrayList.add(fVar);
        return true;
    }

    @Override // q4.e0
    public final void d(x0 x0Var) {
        ArrayList arrayList = this.f10810l;
        ArrayList arrayList2 = this.f10811m;
        ArrayList arrayList3 = this.f10812n;
        View view = x0Var.f10962a;
        view.animate().cancel();
        ArrayList arrayList4 = this.f10808j;
        int size = arrayList4.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((g) arrayList4.get(size)).f10792a == x0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                c(x0Var);
                arrayList4.remove(size);
            }
        }
        j(this.f10809k, x0Var);
        if (this.f10807h.remove(x0Var)) {
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
                if (((g) arrayList6.get(size4)).f10792a == x0Var) {
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
        this.f10815q.remove(x0Var);
        this.f10813o.remove(x0Var);
        this.f10816r.remove(x0Var);
        this.f10814p.remove(x0Var);
        i();
    }

    @Override // q4.e0
    public final void e() {
        ArrayList arrayList = this.f10812n;
        ArrayList arrayList2 = this.f10810l;
        ArrayList arrayList3 = this.f10811m;
        ArrayList arrayList4 = this.f10809k;
        ArrayList arrayList5 = this.i;
        ArrayList arrayList6 = this.f10807h;
        ArrayList arrayList7 = this.f10808j;
        int size = arrayList7.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            g gVar = (g) arrayList7.get(size);
            View view = gVar.f10792a.f10962a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            c(gVar.f10792a);
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
            x0Var.f10962a.setAlpha(1.0f);
            c(x0Var);
            arrayList5.remove(size3);
        }
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            f fVar = (f) arrayList4.get(size4);
            x0 x0Var2 = fVar.f10787a;
            if (x0Var2 != null) {
                k(fVar, x0Var2);
            }
            x0 x0Var3 = fVar.f10788b;
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
                    View view2 = gVar2.f10792a.f10962a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    c(gVar2.f10792a);
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
                    x0Var4.f10962a.setAlpha(1.0f);
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
                    x0 x0Var5 = fVar2.f10787a;
                    if (x0Var5 != null) {
                        k(fVar2, x0Var5);
                    }
                    x0 x0Var6 = fVar2.f10788b;
                    if (x0Var6 != null) {
                        k(fVar2, x0Var6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList.remove(arrayList10);
                    }
                }
            }
            h(this.f10815q);
            h(this.f10814p);
            h(this.f10813o);
            h(this.f10816r);
            ArrayList arrayList11 = this.f10777b;
            if (arrayList11.size() > 0) {
                arrayList11.get(0).getClass();
                throw new ClassCastException();
            }
            arrayList11.clear();
        }
    }

    @Override // q4.e0
    public final boolean f() {
        return (this.i.isEmpty() && this.f10809k.isEmpty() && this.f10808j.isEmpty() && this.f10807h.isEmpty() && this.f10814p.isEmpty() && this.f10815q.isEmpty() && this.f10813o.isEmpty() && this.f10816r.isEmpty() && this.f10811m.isEmpty() && this.f10810l.isEmpty() && this.f10812n.isEmpty()) ? false : true;
    }

    public final boolean g(x0 x0Var, int i, int i10, int i11, int i12) {
        View view = x0Var.f10962a;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i10 + ((int) x0Var.f10962a.getTranslationY());
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
        ArrayList arrayList = this.f10808j;
        g gVar = new g();
        gVar.f10792a = x0Var;
        gVar.f10793b = translationX;
        gVar.f10794c = translationY;
        gVar.f10795d = i11;
        gVar.f10796e = i12;
        arrayList.add(gVar);
        return true;
    }

    public final void i() {
        if (f()) {
            return;
        }
        ArrayList arrayList = this.f10777b;
        if (arrayList.size() <= 0) {
            arrayList.clear();
        } else {
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final void j(ArrayList arrayList, x0 x0Var) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            f fVar = (f) arrayList.get(size);
            if (k(fVar, x0Var) && fVar.f10787a == null && fVar.f10788b == null) {
                arrayList.remove(fVar);
            }
        }
    }

    public final boolean k(f fVar, x0 x0Var) {
        if (fVar.f10788b == x0Var) {
            fVar.f10788b = null;
        } else {
            if (fVar.f10787a != x0Var) {
                return false;
            }
            fVar.f10787a = null;
        }
        View view = x0Var.f10962a;
        View view2 = x0Var.f10962a;
        view.setAlpha(1.0f);
        view2.setTranslationX(0.0f);
        view2.setTranslationY(0.0f);
        c(x0Var);
        return true;
    }

    public final void l(x0 x0Var) {
        if (f10805s == null) {
            f10805s = new ValueAnimator().getInterpolator();
        }
        x0Var.f10962a.animate().setInterpolator(f10805s);
        d(x0Var);
    }
}
