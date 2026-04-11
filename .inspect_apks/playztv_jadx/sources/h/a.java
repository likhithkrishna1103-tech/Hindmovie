package h;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.gms.internal.measurement.k4;
import com.playz.tv.activities.MainActivity;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements e1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k4 f5394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DrawerLayout f5395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j.f f5396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5398e;
    public boolean f = false;

    public a(MainActivity mainActivity, DrawerLayout drawerLayout, Toolbar toolbar, int i, int i10) {
        k4 k4Var = new k4();
        k4Var.f3070u = toolbar;
        toolbar.getNavigationIcon();
        k4Var.f3071v = toolbar.getNavigationContentDescription();
        this.f5394a = k4Var;
        toolbar.setNavigationOnClickListener(new com.google.android.material.datepicker.l(1, this));
        this.f5395b = drawerLayout;
        this.f5397d = i;
        this.f5398e = i10;
        this.f5396c = new j.f(((Toolbar) k4Var.f3070u).getContext());
    }

    @Override // e1.c
    public final void a(float f) {
        d(Math.min(1.0f, Math.max(0.0f, f)));
    }

    @Override // e1.c
    public final void b(View view) {
        d(1.0f);
        this.f5394a.B(this.f5398e);
    }

    @Override // e1.c
    public final void c(View view) {
        d(0.0f);
        this.f5394a.B(this.f5397d);
    }

    public final void d(float f) {
        j.f fVar = this.f5396c;
        if (f == 1.0f) {
            if (!fVar.i) {
                fVar.i = true;
                fVar.invalidateSelf();
            }
        } else if (f == 0.0f && fVar.i) {
            fVar.i = false;
            fVar.invalidateSelf();
        }
        if (fVar.f6662j != f) {
            fVar.f6662j = f;
            fVar.invalidateSelf();
        }
    }

    public final void e() {
        DrawerLayout drawerLayout = this.f5395b;
        View viewF = drawerLayout.f(8388611);
        if (viewF != null ? DrawerLayout.n(viewF) : false) {
            d(1.0f);
        } else {
            d(0.0f);
        }
        View viewF2 = drawerLayout.f(8388611);
        int i = viewF2 != null ? DrawerLayout.n(viewF2) : false ? this.f5398e : this.f5397d;
        boolean z2 = this.f;
        k4 k4Var = this.f5394a;
        if (!z2) {
            k4Var.getClass();
        }
        ((Toolbar) k4Var.f3070u).setNavigationIcon(this.f5396c);
        k4Var.B(i);
    }
}
