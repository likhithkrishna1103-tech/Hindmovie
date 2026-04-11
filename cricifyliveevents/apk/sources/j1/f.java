package j1;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends n5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b1.e f6511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f6512c = new m(15, this);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DrawerLayout f6513d;

    public f(DrawerLayout drawerLayout, int i) {
        this.f6513d = drawerLayout;
        this.f6510a = i;
    }

    @Override // n5.a
    public final void A(View view, int i) {
        ((d) view.getLayoutParams()).f6505c = false;
        int i10 = this.f6510a == 3 ? 5 : 3;
        DrawerLayout drawerLayout = this.f6513d;
        View viewF = drawerLayout.f(i10);
        if (viewF != null) {
            drawerLayout.c(viewF, true);
        }
    }

    @Override // n5.a
    public final void B(int i) {
        this.f6513d.w(this.f6511b.f1667t, i);
    }

    @Override // n5.a
    public final void C(View view, int i, int i10) {
        int width = view.getWidth();
        DrawerLayout drawerLayout = this.f6513d;
        float width2 = (drawerLayout.b(view, 3) ? i + width : drawerLayout.getWidth() - i) / width;
        drawerLayout.t(view, width2);
        view.setVisibility(width2 == 0.0f ? 4 : 0);
        drawerLayout.invalidate();
    }

    @Override // n5.a
    public final void D(View view, float f, float f10) {
        int i;
        int[] iArr = DrawerLayout.f821b0;
        float f11 = ((d) view.getLayoutParams()).f6504b;
        int width = view.getWidth();
        DrawerLayout drawerLayout = this.f6513d;
        if (drawerLayout.b(view, 3)) {
            i = (f > 0.0f || (f == 0.0f && f11 > 0.5f)) ? 0 : -width;
        } else {
            int width2 = drawerLayout.getWidth();
            if (f < 0.0f || (f == 0.0f && f11 > 0.5f)) {
                width2 -= width;
            }
            i = width2;
        }
        this.f6511b.q(i, view.getTop());
        drawerLayout.invalidate();
    }

    @Override // n5.a
    public final boolean N(View view, int i) {
        if (!DrawerLayout.o(view)) {
            return false;
        }
        int i10 = this.f6510a;
        DrawerLayout drawerLayout = this.f6513d;
        return drawerLayout.b(view, i10) && drawerLayout.i(view) == 0;
    }

    @Override // n5.a
    public final int d(View view, int i) {
        DrawerLayout drawerLayout = this.f6513d;
        if (drawerLayout.b(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = drawerLayout.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    @Override // n5.a
    public final int e(View view, int i) {
        return view.getTop();
    }

    @Override // n5.a
    public final int r(View view) {
        if (DrawerLayout.o(view)) {
            return view.getWidth();
        }
        return 0;
    }

    @Override // n5.a
    public final void y(int i, int i10) {
        int i11 = i & 1;
        DrawerLayout drawerLayout = this.f6513d;
        View viewF = i11 == 1 ? drawerLayout.f(3) : drawerLayout.f(5);
        if (viewF == null || drawerLayout.i(viewF) != 0) {
            return;
        }
        this.f6511b.b(viewF, i10);
    }

    @Override // n5.a
    public final void z() {
        this.f6513d.postDelayed(this.f6512c, 160L);
    }
}
