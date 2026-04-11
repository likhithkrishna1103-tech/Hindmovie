package h;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m0 extends l.a implements m.i {
    public final /* synthetic */ n0 A;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Context f5518w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final m.k f5519x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public h4.z f5520y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public WeakReference f5521z;

    public m0(n0 n0Var, Context context, h4.z zVar) {
        this.A = n0Var;
        this.f5518w = context;
        this.f5520y = zVar;
        m.k kVar = new m.k(context);
        kVar.f8214l = 1;
        this.f5519x = kVar;
        kVar.f8209e = this;
    }

    @Override // l.a
    public final void a() {
        n0 n0Var = this.A;
        if (n0Var.f5528k != this) {
            return;
        }
        if (n0Var.f5535r) {
            n0Var.f5529l = this;
            n0Var.f5530m = this.f5520y;
        } else {
            this.f5520y.d0(this);
        }
        this.f5520y = null;
        n0Var.b0(false);
        ActionBarContextView actionBarContextView = n0Var.f5526h;
        if (actionBarContextView.E == null) {
            actionBarContextView.e();
        }
        n0Var.f5524e.setHideOnContentScrollEnabled(n0Var.f5540w);
        n0Var.f5528k = null;
    }

    @Override // l.a
    public final View b() {
        WeakReference weakReference = this.f5521z;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // l.a
    public final m.k c() {
        return this.f5519x;
    }

    @Override // l.a
    public final MenuInflater d() {
        return new l.h(this.f5518w);
    }

    @Override // l.a
    public final CharSequence e() {
        return this.A.f5526h.getSubtitle();
    }

    @Override // l.a
    public final CharSequence f() {
        return this.A.f5526h.getTitle();
    }

    @Override // m.i
    public final boolean g(m.k kVar, MenuItem menuItem) {
        h4.z zVar = this.f5520y;
        if (zVar != null) {
            return ((ub.o) zVar.f5867v).L(this, menuItem);
        }
        return false;
    }

    @Override // l.a
    public final void h() {
        if (this.A.f5528k != this) {
            return;
        }
        m.k kVar = this.f5519x;
        kVar.y();
        try {
            this.f5520y.e0(this, kVar);
        } finally {
            kVar.x();
        }
    }

    @Override // l.a
    public final boolean i() {
        return this.A.f5526h.M;
    }

    @Override // l.a
    public final void j(View view) {
        this.A.f5526h.setCustomView(view);
        this.f5521z = new WeakReference(view);
    }

    @Override // l.a
    public final void k(int i) {
        l(this.A.f5522c.getResources().getString(i));
    }

    @Override // l.a
    public final void l(CharSequence charSequence) {
        this.A.f5526h.setSubtitle(charSequence);
    }

    @Override // l.a
    public final void m(int i) {
        n(this.A.f5522c.getResources().getString(i));
    }

    @Override // l.a
    public final void n(CharSequence charSequence) {
        this.A.f5526h.setTitle(charSequence);
    }

    @Override // l.a
    public final void o(boolean z2) {
        this.f7752v = z2;
        this.A.f5526h.setTitleOptional(z2);
    }

    @Override // m.i
    public final void s(m.k kVar) {
        if (this.f5520y == null) {
            return;
        }
        h();
        n.k kVar2 = this.A.f5526h.f875x;
        if (kVar2 != null) {
            kVar2.n();
        }
    }
}
