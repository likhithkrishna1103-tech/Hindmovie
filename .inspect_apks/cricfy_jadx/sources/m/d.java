package m;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
import l4.c0;
import nc.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends a implements n.i {
    public WeakReference A;
    public boolean B;
    public n.k C;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Context f7973x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ActionBarContextView f7974y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public c0 f7975z;

    @Override // m.a
    public final void a() {
        if (this.B) {
            return;
        }
        this.B = true;
        this.f7975z.P(this);
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
        return this.C;
    }

    @Override // m.a
    public final MenuInflater d() {
        return new h(this.f7974y.getContext());
    }

    @Override // m.a
    public final CharSequence e() {
        return this.f7974y.getSubtitle();
    }

    @Override // m.a
    public final CharSequence f() {
        return this.f7974y.getTitle();
    }

    @Override // m.a
    public final void g() {
        this.f7975z.Q(this, this.C);
    }

    @Override // m.a
    public final boolean h() {
        return this.f7974y.N;
    }

    @Override // m.a
    public final void i(View view) {
        this.f7974y.setCustomView(view);
        this.A = view != null ? new WeakReference(view) : null;
    }

    @Override // m.a
    public final void j(int i) {
        k(this.f7973x.getString(i));
    }

    @Override // m.a
    public final void k(CharSequence charSequence) {
        this.f7974y.setSubtitle(charSequence);
    }

    @Override // m.a
    public final void l(int i) {
        m(this.f7973x.getString(i));
    }

    @Override // m.a
    public final void m(CharSequence charSequence) {
        this.f7974y.setTitle(charSequence);
    }

    @Override // m.a
    public final void n(boolean z10) {
        this.f7967w = z10;
        this.f7974y.setTitleOptional(z10);
    }

    @Override // n.i
    public final boolean x(n.k kVar, MenuItem menuItem) {
        return ((p) this.f7975z.f7705w).v(this, menuItem);
    }

    @Override // n.i
    public final void y(n.k kVar) {
        g();
        o.k kVar2 = this.f7974y.f533y;
        if (kVar2 != null) {
            kVar2.n();
        }
    }
}
