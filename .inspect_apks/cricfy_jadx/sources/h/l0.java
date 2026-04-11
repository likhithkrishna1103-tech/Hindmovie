package h;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 extends m.a implements n.i {
    public WeakReference A;
    public final /* synthetic */ m0 B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Context f5366x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final n.k f5367y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public l4.c0 f5368z;

    public l0(m0 m0Var, Context context, l4.c0 c0Var) {
        this.B = m0Var;
        this.f5366x = context;
        this.f5368z = c0Var;
        n.k kVar = new n.k(context);
        kVar.f8528l = 1;
        this.f5367y = kVar;
        kVar.f8523e = this;
    }

    @Override // m.a
    public final void a() {
        m0 m0Var = this.B;
        if (m0Var.f5375m != this) {
            return;
        }
        if (m0Var.f5382t) {
            m0Var.f5376n = this;
            m0Var.f5377o = this.f5368z;
        } else {
            this.f5368z.P(this);
        }
        this.f5368z = null;
        m0Var.e0(false);
        ActionBarContextView actionBarContextView = m0Var.f5372j;
        if (actionBarContextView.F == null) {
            actionBarContextView.e();
        }
        m0Var.f5370g.setHideOnContentScrollEnabled(m0Var.f5387y);
        m0Var.f5375m = null;
    }

    @Override // m.a
    public final View b() {
        WeakReference weakReference = this.A;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // m.a
    public final n.k c() {
        return this.f5367y;
    }

    @Override // m.a
    public final MenuInflater d() {
        return new m.h(this.f5366x);
    }

    @Override // m.a
    public final CharSequence e() {
        return this.B.f5372j.getSubtitle();
    }

    @Override // m.a
    public final CharSequence f() {
        return this.B.f5372j.getTitle();
    }

    @Override // m.a
    public final void g() {
        if (this.B.f5375m != this) {
            return;
        }
        n.k kVar = this.f5367y;
        kVar.w();
        try {
            this.f5368z.Q(this, kVar);
        } finally {
            kVar.v();
        }
    }

    @Override // m.a
    public final boolean h() {
        return this.B.f5372j.N;
    }

    @Override // m.a
    public final void i(View view) {
        this.B.f5372j.setCustomView(view);
        this.A = new WeakReference(view);
    }

    @Override // m.a
    public final void j(int i) {
        k(this.B.f5369e.getResources().getString(i));
    }

    @Override // m.a
    public final void k(CharSequence charSequence) {
        this.B.f5372j.setSubtitle(charSequence);
    }

    @Override // m.a
    public final void l(int i) {
        m(this.B.f5369e.getResources().getString(i));
    }

    @Override // m.a
    public final void m(CharSequence charSequence) {
        this.B.f5372j.setTitle(charSequence);
    }

    @Override // m.a
    public final void n(boolean z10) {
        this.f7967w = z10;
        this.B.f5372j.setTitleOptional(z10);
    }

    @Override // n.i
    public final boolean x(n.k kVar, MenuItem menuItem) {
        l4.c0 c0Var = this.f5368z;
        if (c0Var != null) {
            return ((nc.p) c0Var.f7705w).v(this, menuItem);
        }
        return false;
    }

    @Override // n.i
    public final void y(n.k kVar) {
        if (this.f5368z == null) {
            return;
        }
        g();
        o.k kVar2 = this.B.f5372j.f533y;
        if (kVar2 != null) {
            kVar2.n();
        }
    }
}
