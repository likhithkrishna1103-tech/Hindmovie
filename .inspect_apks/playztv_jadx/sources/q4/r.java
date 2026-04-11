package q4;

import android.view.View;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10906e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10908h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10909j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f10910k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f10911l;

    public final void a(View view) {
        int iB;
        int size = this.f10910k.size();
        View view2 = null;
        int i = Integer.MAX_VALUE;
        for (int i10 = 0; i10 < size; i10++) {
            View view3 = ((x0) this.f10910k.get(i10)).f10962a;
            i0 i0Var = (i0) view3.getLayoutParams();
            if (view3 != view && !i0Var.f10831a.h() && (iB = (i0Var.f10831a.b() - this.f10905d) * this.f10906e) >= 0 && iB < i) {
                view2 = view3;
                if (iB == 0) {
                    break;
                } else {
                    i = iB;
                }
            }
        }
        if (view2 == null) {
            this.f10905d = -1;
        } else {
            this.f10905d = ((i0) view2.getLayoutParams()).f10831a.b();
        }
    }

    public final View b(n0 n0Var) {
        List list = this.f10910k;
        if (list == null) {
            View view = n0Var.k(this.f10905d, Long.MAX_VALUE).f10962a;
            this.f10905d += this.f10906e;
            return view;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            View view2 = ((x0) this.f10910k.get(i)).f10962a;
            i0 i0Var = (i0) view2.getLayoutParams();
            if (!i0Var.f10831a.h() && this.f10905d == i0Var.f10831a.b()) {
                a(view2);
                return view2;
            }
        }
        return null;
    }
}
