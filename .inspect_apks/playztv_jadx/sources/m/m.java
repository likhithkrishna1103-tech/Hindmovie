package m;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements k0.a {
    public n A;
    public MenuItem.OnActionExpandListener B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f8234e;
    public CharSequence f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Intent f8235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public char f8236h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public char f8237j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f8239l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final k f8241n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c0 f8242o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f8243p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f8244q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f8245r;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f8252y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f8253z;
    public int i = 4096;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8238k = 4096;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8240m = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ColorStateList f8246s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f8247t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f8248u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f8249v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f8250w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f8251x = 16;
    public boolean C = false;

    public m(k kVar, int i, int i10, int i11, int i12, CharSequence charSequence, int i13) {
        this.f8241n = kVar;
        this.f8230a = i10;
        this.f8231b = i;
        this.f8232c = i11;
        this.f8233d = i12;
        this.f8234e = charSequence;
        this.f8252y = i13;
    }

    public static void c(int i, int i10, String str, StringBuilder sb2) {
        if ((i & i10) == i10) {
            sb2.append(str);
        }
    }

    @Override // k0.a
    public final n a() {
        return this.A;
    }

    @Override // k0.a
    public final k0.a b(n nVar) {
        this.f8253z = null;
        this.A = nVar;
        this.f8241n.p(true);
        n nVar2 = this.A;
        if (nVar2 != null) {
            nVar2.f8254a = new u5.c(29, this);
            nVar2.f8255b.setVisibilityListener(nVar2);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f8252y & 8) == 0) {
            return false;
        }
        if (this.f8253z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f8241n.d(this);
        }
        return false;
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.f8250w && (this.f8248u || this.f8249v)) {
            drawable = drawable.mutate();
            if (this.f8248u) {
                drawable.setTintList(this.f8246s);
            }
            if (this.f8249v) {
                drawable.setTintMode(this.f8247t);
            }
            this.f8250w = false;
        }
        return drawable;
    }

    public final boolean e() {
        n nVar;
        if ((this.f8252y & 8) != 0) {
            if (this.f8253z == null && (nVar = this.A) != null) {
                this.f8253z = nVar.f8255b.onCreateActionView(this);
            }
            if (this.f8253z != null) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!e()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f8241n.f(this);
        }
        return false;
    }

    public final void f(boolean z2) {
        this.f8251x = (z2 ? 4 : 0) | (this.f8251x & (-5));
    }

    public final void g(boolean z2) {
        if (z2) {
            this.f8251x |= 32;
        } else {
            this.f8251x &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.f8253z;
        if (view != null) {
            return view;
        }
        n nVar = this.A;
        if (nVar == null) {
            return null;
        }
        View viewOnCreateActionView = nVar.f8255b.onCreateActionView(this);
        this.f8253z = viewOnCreateActionView;
        return viewOnCreateActionView;
    }

    @Override // k0.a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f8238k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f8237j;
    }

    @Override // k0.a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f8244q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f8231b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f8239l;
        if (drawable != null) {
            return d(drawable);
        }
        int i = this.f8240m;
        if (i == 0) {
            return null;
        }
        Drawable drawableP = com.bumptech.glide.d.p(this.f8241n.f8205a, i);
        this.f8240m = 0;
        this.f8239l = drawableP;
        return d(drawableP);
    }

    @Override // k0.a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f8246s;
    }

    @Override // k0.a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f8247t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f8235g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f8230a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // k0.a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f8236h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f8232c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f8242o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f8234e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f;
        return charSequence != null ? charSequence : this.f8234e;
    }

    @Override // k0.a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f8245r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f8242o != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f8251x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f8251x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f8251x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        n nVar = this.A;
        return (nVar == null || !nVar.f8255b.overridesItemVisibility()) ? (this.f8251x & 8) == 0 : (this.f8251x & 8) == 0 && this.A.f8255b.isVisible();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i;
        this.f8253z = view;
        this.A = null;
        if (view != null && view.getId() == -1 && (i = this.f8230a) > 0) {
            view.setId(i);
        }
        k kVar = this.f8241n;
        kVar.f8213k = true;
        kVar.p(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9) {
        if (this.f8237j == c9) {
            return this;
        }
        this.f8237j = Character.toLowerCase(c9);
        this.f8241n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z2) {
        int i = this.f8251x;
        int i10 = (z2 ? 1 : 0) | (i & (-2));
        this.f8251x = i10;
        if (i != i10) {
            this.f8241n.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z2) {
        int i = this.f8251x;
        int i10 = i & 4;
        k kVar = this.f8241n;
        if (i10 == 0) {
            int i11 = (i & (-3)) | (z2 ? 2 : 0);
            this.f8251x = i11;
            if (i != i11) {
                kVar.p(false);
            }
            return this;
        }
        ArrayList arrayList = kVar.f;
        int size = arrayList.size();
        kVar.y();
        for (int i12 = 0; i12 < size; i12++) {
            m mVar = (m) arrayList.get(i12);
            if (mVar.f8231b == this.f8231b && (mVar.f8251x & 4) != 0 && mVar.isCheckable()) {
                boolean z10 = mVar == this;
                int i13 = mVar.f8251x;
                int i14 = (z10 ? 2 : 0) | (i13 & (-3));
                mVar.f8251x = i14;
                if (i13 != i14) {
                    mVar.f8241n.p(false);
                }
            }
        }
        kVar.x();
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z2) {
        if (z2) {
            this.f8251x |= 16;
        } else {
            this.f8251x &= -17;
        }
        this.f8241n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f8240m = 0;
        this.f8239l = drawable;
        this.f8250w = true;
        this.f8241n.p(false);
        return this;
    }

    @Override // k0.a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f8246s = colorStateList;
        this.f8248u = true;
        this.f8250w = true;
        this.f8241n.p(false);
        return this;
    }

    @Override // k0.a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f8247t = mode;
        this.f8249v = true;
        this.f8250w = true;
        this.f8241n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f8235g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        if (this.f8236h == c9) {
            return this;
        }
        this.f8236h = c9;
        this.f8241n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f8243p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        this.f8236h = c9;
        this.f8237j = Character.toLowerCase(c10);
        this.f8241n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i) {
        int i10 = i & 3;
        if (i10 != 0 && i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f8252y = i;
        k kVar = this.f8241n;
        kVar.f8213k = true;
        kVar.p(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f8234e = charSequence;
        this.f8241n.p(false);
        c0 c0Var = this.f8242o;
        if (c0Var != null) {
            c0Var.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        this.f8241n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z2) {
        int i = this.f8251x;
        int i10 = (z2 ? 0 : 8) | (i & (-9));
        this.f8251x = i10;
        if (i != i10) {
            k kVar = this.f8241n;
            kVar.f8211h = true;
            kVar.p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f8234e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // k0.a, android.view.MenuItem
    public final k0.a setContentDescription(CharSequence charSequence) {
        this.f8244q = charSequence;
        this.f8241n.p(false);
        return this;
    }

    @Override // k0.a, android.view.MenuItem
    public final k0.a setTooltipText(CharSequence charSequence) {
        this.f8245r = charSequence;
        this.f8241n.p(false);
        return this;
    }

    @Override // k0.a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9, int i) {
        if (this.f8237j == c9 && this.f8238k == i) {
            return this;
        }
        this.f8237j = Character.toLowerCase(c9);
        this.f8238k = KeyEvent.normalizeMetaState(i);
        this.f8241n.p(false);
        return this;
    }

    @Override // k0.a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9, int i) {
        if (this.f8236h == c9 && this.i == i) {
            return this;
        }
        this.f8236h = c9;
        this.i = KeyEvent.normalizeMetaState(i);
        this.f8241n.p(false);
        return this;
    }

    @Override // k0.a, android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10, int i, int i10) {
        this.f8236h = c9;
        this.i = KeyEvent.normalizeMetaState(i);
        this.f8237j = Character.toLowerCase(c10);
        this.f8238k = KeyEvent.normalizeMetaState(i10);
        this.f8241n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.f8239l = null;
        this.f8240m = i;
        this.f8250w = true;
        this.f8241n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        setTitle(this.f8241n.f8205a.getString(i));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        int i10;
        k kVar = this.f8241n;
        Context context = kVar.f8205a;
        View viewInflate = LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false);
        this.f8253z = viewInflate;
        this.A = null;
        if (viewInflate != null && viewInflate.getId() == -1 && (i10 = this.f8230a) > 0) {
            viewInflate.setId(i10);
        }
        kVar.f8213k = true;
        kVar.p(true);
        return this;
    }
}
