package da;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.internal.NavigationMenuItemView;
import java.util.ArrayList;
import t0.m0;
import v4.x0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends v4.z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f3622d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n.m f3623e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t f3624g;

    public l(t tVar) {
        this.f3624g = tVar;
        h();
    }

    @Override // v4.z
    public final int a() {
        return this.f3622d.size();
    }

    @Override // v4.z
    public final long b(int i) {
        return i;
    }

    @Override // v4.z
    public final int c(int i) {
        n nVar = (n) this.f3622d.get(i);
        if (nVar instanceof o) {
            return 2;
        }
        if (nVar instanceof m) {
            return 3;
        }
        if (nVar instanceof p) {
            return ((p) nVar).f3627a.hasSubMenu() ? 1 : 0;
        }
        throw new RuntimeException("Unknown item type.");
    }

    @Override // v4.z
    public final void e(x0 x0Var, int i) {
        View view = ((s) x0Var).f13387a;
        int iC = c(i);
        ArrayList arrayList = this.f3622d;
        t tVar = this.f3624g;
        if (iC != 0) {
            if (iC != 1) {
                if (iC != 2) {
                    return;
                }
                o oVar = (o) arrayList.get(i);
                view.setPaddingRelative(tVar.N, oVar.f3625a, tVar.O, oVar.f3626b);
                return;
            }
            TextView textView = (TextView) view;
            textView.setText(((p) arrayList.get(i)).f3627a.f8548e);
            textView.setTextAppearance(tVar.B);
            textView.setPaddingRelative(tVar.P, textView.getPaddingTop(), tVar.Q, textView.getPaddingBottom());
            ColorStateList colorStateList = tVar.C;
            if (colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
            m0.n(textView, new k(this, i, true));
            return;
        }
        NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
        navigationMenuItemView.setIconTintList(tVar.G);
        navigationMenuItemView.setTextAppearance(tVar.D);
        ColorStateList colorStateList2 = tVar.F;
        if (colorStateList2 != null) {
            navigationMenuItemView.setTextColor(colorStateList2);
        }
        Drawable drawable = tVar.H;
        navigationMenuItemView.setBackground(drawable != null ? drawable.getConstantState().newDrawable() : null);
        RippleDrawable rippleDrawable = tVar.I;
        if (rippleDrawable != null) {
            navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
        }
        p pVar = (p) arrayList.get(i);
        navigationMenuItemView.setNeedsEmptyIcon(pVar.f3628b);
        int i10 = tVar.J;
        int i11 = tVar.K;
        navigationMenuItemView.setPadding(i10, i11, i10, i11);
        navigationMenuItemView.setIconPadding(tVar.L);
        if (tVar.R) {
            navigationMenuItemView.setIconSize(tVar.M);
        }
        navigationMenuItemView.setMaxLines(tVar.T);
        n.m mVar = pVar.f3627a;
        navigationMenuItemView.T = tVar.E;
        navigationMenuItemView.a(mVar);
        m0.n(navigationMenuItemView, new k(this, i, false));
    }

    @Override // v4.z
    public final x0 f(ViewGroup viewGroup, int i) {
        t tVar = this.f3624g;
        if (i == 0) {
            LayoutInflater layoutInflater = tVar.A;
            com.google.android.material.datepicker.l lVar = tVar.X;
            View viewInflate = layoutInflater.inflate(k9.h.design_navigation_item, viewGroup, false);
            r rVar = new r(viewInflate);
            viewInflate.setOnClickListener(lVar);
            return rVar;
        }
        if (i == 1) {
            return new j(tVar.A.inflate(k9.h.design_navigation_item_subheader, viewGroup, false));
        }
        if (i == 2) {
            return new j(tVar.A.inflate(k9.h.design_navigation_item_separator, viewGroup, false));
        }
        if (i != 3) {
            return null;
        }
        return new j(tVar.f3630w);
    }

    @Override // v4.z
    public final void g(x0 x0Var) {
        s sVar = (s) x0Var;
        if (sVar instanceof r) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) sVar.f13387a;
            FrameLayout frameLayout = navigationMenuItemView.V;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            navigationMenuItemView.U.setCompoundDrawables(null, null, null, null);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void h() {
        if (this.f) {
            return;
        }
        this.f = true;
        ArrayList arrayList = this.f3622d;
        arrayList.clear();
        arrayList.add(new m());
        t tVar = this.f3624g;
        int size = tVar.f3631x.l().size();
        boolean z10 = false;
        int i = -1;
        int i10 = 0;
        boolean z11 = false;
        int size2 = 0;
        while (i10 < size) {
            n.m mVar = (n.m) tVar.f3631x.l().get(i10);
            if (mVar.isChecked()) {
                i(mVar);
            }
            if (mVar.isCheckable()) {
                mVar.f(z10);
            }
            if (mVar.hasSubMenu()) {
                n.c0 c0Var = mVar.f8556o;
                if (c0Var.hasVisibleItems()) {
                    if (i10 != 0) {
                        arrayList.add(new o(tVar.V, z10 ? 1 : 0));
                    }
                    arrayList.add(new p(mVar));
                    int size3 = c0Var.f.size();
                    int i11 = z10 ? 1 : 0;
                    int i12 = i11;
                    while (i11 < size3) {
                        n.m mVar2 = (n.m) c0Var.getItem(i11);
                        if (mVar2.isVisible()) {
                            if (i12 == 0 && mVar2.getIcon() != null) {
                                i12 = 1;
                            }
                            if (mVar2.isCheckable()) {
                                mVar2.f(z10);
                            }
                            if (mVar2.isChecked()) {
                                i(mVar2);
                            }
                            arrayList.add(new p(mVar2));
                        }
                        i11++;
                        z10 = false;
                    }
                    if (i12 != 0) {
                        int size4 = arrayList.size();
                        for (int size5 = arrayList.size(); size5 < size4; size5++) {
                            ((p) arrayList.get(size5)).f3628b = true;
                        }
                    }
                }
            } else {
                int i13 = mVar.f8545b;
                if (i13 != i) {
                    size2 = arrayList.size();
                    z11 = mVar.getIcon() != null;
                    if (i10 != 0) {
                        size2++;
                        int i14 = tVar.V;
                        arrayList.add(new o(i14, i14));
                    }
                } else if (!z11 && mVar.getIcon() != null) {
                    int size6 = arrayList.size();
                    for (int i15 = size2; i15 < size6; i15++) {
                        ((p) arrayList.get(i15)).f3628b = true;
                    }
                    z11 = true;
                }
                p pVar = new p(mVar);
                pVar.f3628b = z11;
                arrayList.add(pVar);
                i = i13;
            }
            i10++;
            z10 = false;
        }
        this.f = z10;
    }

    public final void i(n.m mVar) {
        if (this.f3623e == mVar || !mVar.isCheckable()) {
            return;
        }
        n.m mVar2 = this.f3623e;
        if (mVar2 != null) {
            mVar2.setChecked(false);
        }
        this.f3623e = mVar;
        mVar.setChecked(true);
    }
}
