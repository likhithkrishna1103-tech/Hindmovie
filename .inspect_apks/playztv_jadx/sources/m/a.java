package m;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f8162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f8163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Intent f8164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public char f8165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8166e;
    public char f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f8168h;
    public Context i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f8169j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f8170k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ColorStateList f8171l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f8172m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f8173n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f8174o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f8175p;

    @Override // k0.a
    public final n a() {
        return null;
    }

    @Override // k0.a
    public final k0.a b(n nVar) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable = this.f8168h;
        if (drawable != null) {
            if (this.f8173n || this.f8174o) {
                this.f8168h = drawable;
                Drawable drawableMutate = drawable.mutate();
                this.f8168h = drawableMutate;
                if (this.f8173n) {
                    drawableMutate.setTintList(this.f8171l);
                }
                if (this.f8174o) {
                    this.f8168h.setTintMode(this.f8172m);
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

    @Override // k0.a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f8167g;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f;
    }

    @Override // k0.a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f8169j;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f8168h;
    }

    @Override // k0.a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f8171l;
    }

    @Override // k0.a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f8172m;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f8164c;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return R.id.home;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // k0.a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f8166e;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f8165d;
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
        return this.f8162a;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f8163b;
        return charSequence != null ? charSequence : this.f8162a;
    }

    @Override // k0.a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f8170k;
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
        return (this.f8175p & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f8175p & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f8175p & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f8175p & 8) == 0;
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
    public final MenuItem setCheckable(boolean z2) {
        this.f8175p = (z2 ? 1 : 0) | (this.f8175p & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z2) {
        this.f8175p = (z2 ? 2 : 0) | (this.f8175p & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f8169j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z2) {
        this.f8175p = (z2 ? 16 : 0) | (this.f8175p & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f8168h = drawable;
        c();
        return this;
    }

    @Override // k0.a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f8171l = colorStateList;
        this.f8173n = true;
        c();
        return this;
    }

    @Override // k0.a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f8172m = mode;
        this.f8174o = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f8164c = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        this.f8165d = c9;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        this.f8165d = c9;
        this.f = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f8162a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f8163b = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f8170k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z2) {
        this.f8175p = (this.f8175p & 8) | (z2 ? 0 : 8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // k0.a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9, int i) {
        this.f = Character.toLowerCase(c9);
        this.f8167g = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // k0.a, android.view.MenuItem
    public final k0.a setContentDescription(CharSequence charSequence) {
        this.f8169j = charSequence;
        return this;
    }

    @Override // k0.a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9, int i) {
        this.f8165d = c9;
        this.f8166e = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        this.f8162a = this.i.getResources().getString(i);
        return this;
    }

    @Override // k0.a, android.view.MenuItem
    public final k0.a setTooltipText(CharSequence charSequence) {
        this.f8170k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.f8168h = this.i.getDrawable(i);
        c();
        return this;
    }

    @Override // k0.a, android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10, int i, int i10) {
        this.f8165d = c9;
        this.f8166e = KeyEvent.normalizeMetaState(i);
        this.f = Character.toLowerCase(c10);
        this.f8167g = KeyEvent.normalizeMetaState(i10);
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
