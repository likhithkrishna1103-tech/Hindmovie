package m;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import n.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f7977b;

    public e(Context context, a aVar) {
        this.f7976a = context;
        this.f7977b = aVar;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f7977b.a();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f7977b.b();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new z(this.f7976a, this.f7977b.c());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f7977b.d();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f7977b.e();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f7977b.f7966v;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f7977b.f();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f7977b.f7967w;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f7977b.g();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f7977b.h();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f7977b.i(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f7977b.k(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f7977b.f7966v = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f7977b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z10) {
        this.f7977b.n(z10);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i) {
        this.f7977b.j(i);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i) {
        this.f7977b.l(i);
    }
}
