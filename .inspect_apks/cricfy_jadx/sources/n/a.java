package n;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f8480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f8481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Intent f8482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public char f8483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8484e;
    public char f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f8486h;
    public Context i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f8487j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f8488k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f8489l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f8490m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f8491n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f8492o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f8493p;

    @Override // n0.a
    public final n a() {
        return null;
    }

    @Override // n0.a
    public final n0.a b(n nVar) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable = this.f8486h;
        if (drawable != null) {
            if (this.f8491n || this.f8492o) {
                this.f8486h = drawable;
                Drawable drawableMutate = drawable.mutate();
                this.f8486h = drawableMutate;
                if (this.f8491n) {
                    drawableMutate.setTintList(this.f8489l);
                }
                if (this.f8492o) {
                    this.f8486h.setTintMode(this.f8490m);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // n0.a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f8485g;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f;
    }

    @Override // n0.a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f8487j;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f8486h;
    }

    @Override // n0.a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f8489l;
    }

    @Override // n0.a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f8490m;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f8482c;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return R.id.home;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // n0.a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f8484e;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f8483d;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f8480a;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f8481b;
        return charSequence != null ? charSequence : this.f8480a;
    }

    @Override // n0.a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f8488k;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f8493p & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f8493p & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f8493p & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f8493p & 8) == 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9) {
        this.f = Character.toLowerCase(c9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z10) {
        this.f8493p = (z10 ? 1 : 0) | (this.f8493p & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z10) {
        this.f8493p = (z10 ? 2 : 0) | (this.f8493p & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f8487j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z10) {
        this.f8493p = (z10 ? 16 : 0) | (this.f8493p & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f8486h = drawable;
        c();
        return this;
    }

    @Override // n0.a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f8489l = colorStateList;
        this.f8491n = true;
        c();
        return this;
    }

    @Override // n0.a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f8490m = mode;
        this.f8492o = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f8482c = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        this.f8483d = c9;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        this.f8483d = c9;
        this.f = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f8480a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f8481b = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f8488k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z10) {
        this.f8493p = (this.f8493p & 8) | (z10 ? 0 : 8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // n0.a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9, int i) {
        this.f = Character.toLowerCase(c9);
        this.f8485g = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // n0.a, android.view.MenuItem
    public final n0.a setContentDescription(CharSequence charSequence) {
        this.f8487j = charSequence;
        return this;
    }

    @Override // n0.a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9, int i) {
        this.f8483d = c9;
        this.f8484e = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        this.f8480a = this.i.getResources().getString(i);
        return this;
    }

    @Override // n0.a, android.view.MenuItem
    public final n0.a setTooltipText(CharSequence charSequence) {
        this.f8488k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.f8486h = this.i.getDrawable(i);
        c();
        return this;
    }

    @Override // n0.a, android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10, int i, int i10) {
        this.f8483d = c9;
        this.f8484e = KeyEvent.normalizeMetaState(i);
        this.f = Character.toLowerCase(c10);
        this.f8485g = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i) {
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        return this;
    }
}
