package n;

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
import com.google.android.gms.internal.measurement.j4;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements n0.a {
    public n A;
    public MenuItem.OnActionExpandListener B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f8548e;
    public CharSequence f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Intent f8549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public char f8550h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public char f8551j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Drawable f8553l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final k f8555n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c0 f8556o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f8557p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f8558q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f8559r;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f8566y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f8567z;
    public int i = 4096;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8552k = 4096;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8554m = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ColorStateList f8560s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f8561t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f8562u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f8563v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f8564w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f8565x = 16;
    public boolean C = false;

    public m(k kVar, int i, int i10, int i11, int i12, CharSequence charSequence, int i13) {
        this.f8555n = kVar;
        this.f8544a = i10;
        this.f8545b = i;
        this.f8546c = i11;
        this.f8547d = i12;
        this.f8548e = charSequence;
        this.f8566y = i13;
    }

    public static void c(int i, int i10, String str, StringBuilder sb) {
        if ((i & i10) == i10) {
            sb.append(str);
        }
    }

    @Override // n0.a
    public final n a() {
        return this.A;
    }

    @Override // n0.a
    public final n0.a b(n nVar) {
        this.f8567z = null;
        this.A = nVar;
        this.f8555n.p(true);
        n nVar2 = this.A;
        if (nVar2 != null) {
            nVar2.f8568a = new kf.i(6, this);
            nVar2.f8569b.setVisibilityListener(nVar2);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.f8566y & 8) == 0) {
            return false;
        }
        if (this.f8567z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f8555n.d(this);
        }
        return false;
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.f8564w && (this.f8562u || this.f8563v)) {
            drawable = drawable.mutate();
            if (this.f8562u) {
                drawable.setTintList(this.f8560s);
            }
            if (this.f8563v) {
                drawable.setTintMode(this.f8561t);
            }
            this.f8564w = false;
        }
        return drawable;
    }

    public final boolean e() {
        n nVar;
        if ((this.f8566y & 8) != 0) {
            if (this.f8567z == null && (nVar = this.A) != null) {
                this.f8567z = nVar.f8569b.onCreateActionView(this);
            }
            if (this.f8567z != null) {
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
            return this.f8555n.f(this);
        }
        return false;
    }

    public final void f(boolean z10) {
        this.f8565x = (z10 ? 4 : 0) | (this.f8565x & (-5));
    }

    public final void g(boolean z10) {
        if (z10) {
            this.f8565x |= 32;
        } else {
            this.f8565x &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.f8567z;
        if (view != null) {
            return view;
        }
        n nVar = this.A;
        if (nVar == null) {
            return null;
        }
        View viewOnCreateActionView = nVar.f8569b.onCreateActionView(this);
        this.f8567z = viewOnCreateActionView;
        return viewOnCreateActionView;
    }

    @Override // n0.a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f8552k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f8551j;
    }

    @Override // n0.a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f8558q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f8545b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f8553l;
        if (drawable != null) {
            return d(drawable);
        }
        int i = this.f8554m;
        if (i == 0) {
            return null;
        }
        Drawable drawableI = j4.i(this.f8555n.f8519a, i);
        this.f8554m = 0;
        this.f8553l = drawableI;
        return d(drawableI);
    }

    @Override // n0.a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f8560s;
    }

    @Override // n0.a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f8561t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f8549g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f8544a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // n0.a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f8550h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f8546c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f8556o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f8548e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f;
        return charSequence != null ? charSequence : this.f8548e;
    }

    @Override // n0.a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f8559r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f8556o != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f8565x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f8565x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f8565x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        n nVar = this.A;
        return (nVar == null || !nVar.f8569b.overridesItemVisibility()) ? (this.f8565x & 8) == 0 : (this.f8565x & 8) == 0 && this.A.f8569b.isVisible();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i;
        this.f8567z = view;
        this.A = null;
        if (view != null && view.getId() == -1 && (i = this.f8544a) > 0) {
            view.setId(i);
        }
        k kVar = this.f8555n;
        kVar.f8527k = true;
        kVar.p(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9) {
        if (this.f8551j == c9) {
            return this;
        }
        this.f8551j = Character.toLowerCase(c9);
        this.f8555n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z10) {
        int i = this.f8565x;
        int i10 = (z10 ? 1 : 0) | (i & (-2));
        this.f8565x = i10;
        if (i != i10) {
            this.f8555n.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z10) {
        int i = this.f8565x;
        int i10 = i & 4;
        k kVar = this.f8555n;
        if (i10 == 0) {
            int i11 = (i & (-3)) | (z10 ? 2 : 0);
            this.f8565x = i11;
            if (i != i11) {
                kVar.p(false);
            }
            return this;
        }
        ArrayList arrayList = kVar.f;
        int size = arrayList.size();
        kVar.w();
        for (int i12 = 0; i12 < size; i12++) {
            m mVar = (m) arrayList.get(i12);
            if (mVar.f8545b == this.f8545b && (mVar.f8565x & 4) != 0 && mVar.isCheckable()) {
                boolean z11 = mVar == this;
                int i13 = mVar.f8565x;
                int i14 = (z11 ? 2 : 0) | (i13 & (-3));
                mVar.f8565x = i14;
                if (i13 != i14) {
                    mVar.f8555n.p(false);
                }
            }
        }
        kVar.v();
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z10) {
        if (z10) {
            this.f8565x |= 16;
        } else {
            this.f8565x &= -17;
        }
        this.f8555n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f8554m = 0;
        this.f8553l = drawable;
        this.f8564w = true;
        this.f8555n.p(false);
        return this;
    }

    @Override // n0.a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f8560s = colorStateList;
        this.f8562u = true;
        this.f8564w = true;
        this.f8555n.p(false);
        return this;
    }

    @Override // n0.a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f8561t = mode;
        this.f8563v = true;
        this.f8564w = true;
        this.f8555n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f8549g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        if (this.f8550h == c9) {
            return this;
        }
        this.f8550h = c9;
        this.f8555n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f8557p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        this.f8550h = c9;
        this.f8551j = Character.toLowerCase(c10);
        this.f8555n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i) {
        int i10 = i & 3;
        if (i10 != 0 && i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f8566y = i;
        k kVar = this.f8555n;
        kVar.f8527k = true;
        kVar.p(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f8548e = charSequence;
        this.f8555n.p(false);
        c0 c0Var = this.f8556o;
        if (c0Var != null) {
            c0Var.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        this.f8555n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z10) {
        int i = this.f8565x;
        int i10 = (z10 ? 0 : 8) | (i & (-9));
        this.f8565x = i10;
        if (i != i10) {
            k kVar = this.f8555n;
            kVar.f8525h = true;
            kVar.p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f8548e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // n0.a, android.view.MenuItem
    public final n0.a setContentDescription(CharSequence charSequence) {
        this.f8558q = charSequence;
        this.f8555n.p(false);
        return this;
    }

    @Override // n0.a, android.view.MenuItem
    public final n0.a setTooltipText(CharSequence charSequence) {
        this.f8559r = charSequence;
        this.f8555n.p(false);
        return this;
    }

    @Override // n0.a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9, int i) {
        if (this.f8551j == c9 && this.f8552k == i) {
            return this;
        }
        this.f8551j = Character.toLowerCase(c9);
        this.f8552k = KeyEvent.normalizeMetaState(i);
        this.f8555n.p(false);
        return this;
    }

    @Override // n0.a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9, int i) {
        if (this.f8550h == c9 && this.i == i) {
            return this;
        }
        this.f8550h = c9;
        this.i = KeyEvent.normalizeMetaState(i);
        this.f8555n.p(false);
        return this;
    }

    @Override // n0.a, android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10, int i, int i10) {
        this.f8550h = c9;
        this.i = KeyEvent.normalizeMetaState(i);
        this.f8551j = Character.toLowerCase(c10);
        this.f8552k = KeyEvent.normalizeMetaState(i10);
        this.f8555n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.f8553l = null;
        this.f8554m = i;
        this.f8564w = true;
        this.f8555n.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        setTitle(this.f8555n.f8519a.getString(i));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        int i10;
        k kVar = this.f8555n;
        Context context = kVar.f8519a;
        View viewInflate = LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false);
        this.f8567z = viewInflate;
        this.A = null;
        if (viewInflate != null && viewInflate.getId() == -1 && (i10 = this.f8544a) > 0) {
            viewInflate.setId(i10);
        }
        kVar.f8527k = true;
        kVar.p(true);
        return this;
    }
}
