package l;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import h4.z;
import java.lang.ref.WeakReference;
import ub.o;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends a implements m.i {
    public boolean A;
    public m.k B;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Context f7758w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ActionBarContextView f7759x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public z f7760y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public WeakReference f7761z;

    @Override // l.a
    public final void a() {
        if (this.A) {
            return;
        }
        this.A = true;
        this.f7760y.d0(this);
    }

    @Override // l.a
    public final View b() {
        WeakReference weakReference = this.f7761z;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // l.a
    public final m.k c() {
        return this.B;
    }

    @Override // l.a
    public final MenuInflater d() {
        return new h(this.f7759x.getContext());
    }

    @Override // l.a
    public final CharSequence e() {
        return this.f7759x.getSubtitle();
    }

    @Override // l.a
    public final CharSequence f() {
        return this.f7759x.getTitle();
    }

    @Override // m.i
    public final boolean g(m.k kVar, MenuItem menuItem) {
        return ((o) this.f7760y.f5867v).L(this, menuItem);
    }

    @Override // l.a
    public final void h() {
        this.f7760y.e0(this, this.B);
    }

    @Override // l.a
    public final boolean i() {
        return this.f7759x.M;
    }

    @Override // l.a
    public final void j(View view) {
        this.f7759x.setCustomView(view);
        this.f7761z = view != null ? new WeakReference(view) : null;
    }

    @Override // l.a
    public final void k(int i) {
        l(this.f7758w.getString(i));
    }

    @Override // l.a
    public final void l(CharSequence charSequence) {
        this.f7759x.setSubtitle(charSequence);
    }

    @Override // l.a
    public final void m(int i) {
        n(this.f7758w.getString(i));
    }

    @Override // l.a
    public final void n(CharSequence charSequence) {
        this.f7759x.setTitle(charSequence);
    }

    @Override // l.a
    public final void o(boolean z2) {
        this.f7752v = z2;
        this.f7759x.setTitleOptional(z2);
    }

    @Override // m.i
    public final void s(m.k kVar) {
        h();
        n.k kVar2 = this.f7759x.f875x;
        if (kVar2 != null) {
            kVar2.n();
        }
    }
}
