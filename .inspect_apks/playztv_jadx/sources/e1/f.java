package e1;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y0.d f4287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.fragment.app.e f4288c = new androidx.fragment.app.e(4, this);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DrawerLayout f4289d;

    public f(DrawerLayout drawerLayout, int i) {
        this.f4289d = drawerLayout;
        this.f4286a = i;
    }

    @Override // a.a
    public final void D(int i, int i10) {
        int i11 = i & 1;
        DrawerLayout drawerLayout = this.f4289d;
        View viewF = i11 == 1 ? drawerLayout.f(3) : drawerLayout.f(5);
        if (viewF == null || drawerLayout.i(viewF) != 0) {
            return;
        }
        this.f4287b.b(viewF, i10);
    }

    @Override // a.a
    public final void E() {
        this.f4289d.postDelayed(this.f4288c, 160L);
    }

    @Override // a.a
    public final void F(View view, int i) {
        ((d) view.getLayoutParams()).f4280c = false;
        int i10 = this.f4286a == 3 ? 5 : 3;
        DrawerLayout drawerLayout = this.f4289d;
        View viewF = drawerLayout.f(i10);
        if (viewF != null) {
            drawerLayout.c(viewF, true);
        }
    }

    @Override // a.a
    public final void G(int i) {
        this.f4289d.w(this.f4287b.f14454t, i);
    }

    @Override // a.a
    public final void H(View view, int i, int i10) {
        int width = view.getWidth();
        DrawerLayout drawerLayout = this.f4289d;
        float width2 = (drawerLayout.b(view, 3) ? i + width : drawerLayout.getWidth() - i) / width;
        drawerLayout.t(view, width2);
        view.setVisibility(width2 == 0.0f ? 4 : 0);
        drawerLayout.invalidate();
    }

    @Override // a.a
    public final void I(View view, float f, float f4) {
        int i;
        int[] iArr = DrawerLayout.f1152a0;
        float f10 = ((d) view.getLayoutParams()).f4279b;
        int width = view.getWidth();
        DrawerLayout drawerLayout = this.f4289d;
        if (drawerLayout.b(view, 3)) {
            i = (f > 0.0f || (f == 0.0f && f10 > 0.5f)) ? 0 : -width;
        } else {
            int width2 = drawerLayout.getWidth();
            if (f < 0.0f || (f == 0.0f && f10 > 0.5f)) {
                width2 -= width;
            }
            i = width2;
        }
        this.f4287b.q(i, view.getTop());
        drawerLayout.invalidate();
    }

    @Override // a.a
    public final boolean P(View view, int i) {
        if (!DrawerLayout.o(view)) {
            return false;
        }
        int i10 = this.f4286a;
        DrawerLayout drawerLayout = this.f4289d;
        return drawerLayout.b(view, i10) && drawerLayout.i(view) == 0;
    }

    @Override // a.a
    public final int a(View view, int i) {
        DrawerLayout drawerLayout = this.f4289d;
        if (drawerLayout.b(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = drawerLayout.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    @Override // a.a
    public final int b(View view, int i) {
        return view.getTop();
    }

    @Override // a.a
    public final int t(View view) {
        if (DrawerLayout.o(view)) {
            return view.getWidth();
        }
        return 0;
    }
}
