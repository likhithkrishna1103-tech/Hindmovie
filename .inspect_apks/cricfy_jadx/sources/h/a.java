package h;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import app.cricfy.tv.activities.MainActivity;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements j1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l4.c0 f5257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DrawerLayout f5258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j.g f5259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5261e;
    public boolean f = false;

    public a(MainActivity mainActivity, DrawerLayout drawerLayout, Toolbar toolbar, int i, int i10) {
        l4.c0 c0Var = new l4.c0(toolbar);
        this.f5257a = c0Var;
        toolbar.setNavigationOnClickListener(new com.google.android.material.datepicker.l(2, this));
        this.f5258b = drawerLayout;
        this.f5260d = i;
        this.f5261e = i10;
        this.f5259c = new j.g(((Toolbar) c0Var.f7705w).getContext());
    }

    @Override // j1.c
    public final void a(float f) {
        d(Math.min(1.0f, Math.max(0.0f, f)));
    }

    @Override // j1.c
    public final void b(View view) {
        d(1.0f);
        this.f5257a.W(this.f5261e);
    }

    @Override // j1.c
    public final void c(View view) {
        d(0.0f);
        this.f5257a.W(this.f5260d);
    }

    public final void d(float f) {
        j.g gVar = this.f5259c;
        if (f == 1.0f) {
            if (!gVar.i) {
                gVar.i = true;
                gVar.invalidateSelf();
            }
        } else if (f == 0.0f && gVar.i) {
            gVar.i = false;
            gVar.invalidateSelf();
        }
        gVar.setProgress(f);
    }

    public final void e() {
        DrawerLayout drawerLayout = this.f5258b;
        View viewF = drawerLayout.f(8388611);
        if (viewF != null ? DrawerLayout.n(viewF) : false) {
            d(1.0f);
        } else {
            d(0.0f);
        }
        View viewF2 = drawerLayout.f(8388611);
        int i = viewF2 != null ? DrawerLayout.n(viewF2) : false ? this.f5261e : this.f5260d;
        boolean z10 = this.f;
        l4.c0 c0Var = this.f5257a;
        if (!z10) {
            c0Var.getClass();
        }
        ((Toolbar) c0Var.f7705w).setNavigationIcon(this.f5259c);
        c0Var.W(i);
    }
}
