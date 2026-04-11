package l;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import m.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f7763b;

    public e(Context context, a aVar) {
        this.f7762a = context;
        this.f7763b = aVar;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f7763b.a();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f7763b.b();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new z(this.f7762a, this.f7763b.c());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f7763b.d();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f7763b.e();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f7763b.f7751u;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f7763b.f();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f7763b.f7752v;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f7763b.h();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f7763b.i();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f7763b.j(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f7763b.l(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f7763b.f7751u = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f7763b.n(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z2) {
        this.f7763b.o(z2);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i) {
        this.f7763b.k(i);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i) {
        this.f7763b.m(i);
    }
}
