package v4;

import android.view.View;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13330e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13332h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13333j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f13334k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f13335l;

    public final void a(View view) {
        int iB;
        int size = this.f13334k.size();
        View view2 = null;
        int i = Integer.MAX_VALUE;
        for (int i10 = 0; i10 < size; i10++) {
            View view3 = ((x0) this.f13334k.get(i10)).f13387a;
            i0 i0Var = (i0) view3.getLayoutParams();
            if (view3 != view && !i0Var.f13261a.h() && (iB = (i0Var.f13261a.b() - this.f13329d) * this.f13330e) >= 0 && iB < i) {
                view2 = view3;
                if (iB == 0) {
                    break;
                } else {
                    i = iB;
                }
            }
        }
        if (view2 == null) {
            this.f13329d = -1;
        } else {
            this.f13329d = ((i0) view2.getLayoutParams()).f13261a.b();
        }
    }

    public final View b(n0 n0Var) {
        List list = this.f13334k;
        if (list == null) {
            View viewD = n0Var.d(this.f13329d);
            this.f13329d += this.f13330e;
            return viewD;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            View view = ((x0) this.f13334k.get(i)).f13387a;
            i0 i0Var = (i0) view.getLayoutParams();
            if (!i0Var.f13261a.h() && this.f13329d == i0Var.f13261a.b()) {
                a(view);
                return view;
            }
        }
        return null;
    }
}
