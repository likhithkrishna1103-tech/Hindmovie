package j9;

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
import java.util.WeakHashMap;
import q0.o0;
import q4.x0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends q4.z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f6894d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m.m f6895e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ t f6896g;

    public l(t tVar) {
        this.f6896g = tVar;
        g();
    }

    @Override // q4.z
    public final int a() {
        return this.f6894d.size();
    }

    @Override // q4.z
    public final long b(int i) {
        return i;
    }

    @Override // q4.z
    public final int c(int i) {
        n nVar = (n) this.f6894d.get(i);
        if (nVar instanceof o) {
            return 2;
        }
        if (nVar instanceof m) {
            return 3;
        }
        if (nVar instanceof p) {
            return ((p) nVar).f6899a.hasSubMenu() ? 1 : 0;
        }
        throw new RuntimeException("Unknown item type.");
    }

    @Override // q4.z
    public final void d(x0 x0Var, int i) {
        View view = ((s) x0Var).f10962a;
        int iC = c(i);
        ArrayList arrayList = this.f6894d;
        t tVar = this.f6896g;
        if (iC != 0) {
            if (iC != 1) {
                if (iC != 2) {
                    return;
                }
                o oVar = (o) arrayList.get(i);
                view.setPadding(tVar.M, oVar.f6897a, tVar.N, oVar.f6898b);
                return;
            }
            TextView textView = (TextView) view;
            textView.setText(((p) arrayList.get(i)).f6899a.f8234e);
            textView.setTextAppearance(tVar.A);
            textView.setPadding(tVar.O, textView.getPaddingTop(), tVar.P, textView.getPaddingBottom());
            ColorStateList colorStateList = tVar.B;
            if (colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
            o0.n(textView, new k(this, i, true));
            return;
        }
        NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
        navigationMenuItemView.setIconTintList(tVar.F);
        navigationMenuItemView.setTextAppearance(tVar.C);
        ColorStateList colorStateList2 = tVar.E;
        if (colorStateList2 != null) {
            navigationMenuItemView.setTextColor(colorStateList2);
        }
        Drawable drawable = tVar.G;
        Drawable drawableNewDrawable = drawable != null ? drawable.getConstantState().newDrawable() : null;
        WeakHashMap weakHashMap = o0.f10475a;
        navigationMenuItemView.setBackground(drawableNewDrawable);
        RippleDrawable rippleDrawable = tVar.H;
        if (rippleDrawable != null) {
            navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
        }
        p pVar = (p) arrayList.get(i);
        navigationMenuItemView.setNeedsEmptyIcon(pVar.f6900b);
        int i10 = tVar.I;
        int i11 = tVar.J;
        navigationMenuItemView.setPadding(i10, i11, i10, i11);
        navigationMenuItemView.setIconPadding(tVar.K);
        if (tVar.Q) {
            navigationMenuItemView.setIconSize(tVar.L);
        }
        navigationMenuItemView.setMaxLines(tVar.S);
        m.m mVar = pVar.f6899a;
        navigationMenuItemView.S = tVar.D;
        navigationMenuItemView.a(mVar);
        o0.n(navigationMenuItemView, new k(this, i, false));
    }

    @Override // q4.z
    public final x0 e(ViewGroup viewGroup, int i) {
        t tVar = this.f6896g;
        if (i == 0) {
            LayoutInflater layoutInflater = tVar.f6906z;
            com.google.android.material.datepicker.l lVar = tVar.W;
            View viewInflate = layoutInflater.inflate(p8.h.design_navigation_item, viewGroup, false);
            r rVar = new r(viewInflate);
            viewInflate.setOnClickListener(lVar);
            return rVar;
        }
        if (i == 1) {
            return new j(tVar.f6906z.inflate(p8.h.design_navigation_item_subheader, viewGroup, false));
        }
        if (i == 2) {
            return new j(tVar.f6906z.inflate(p8.h.design_navigation_item_separator, viewGroup, false));
        }
        if (i != 3) {
            return null;
        }
        return new j(tVar.f6902v);
    }

    @Override // q4.z
    public final void f(x0 x0Var) {
        s sVar = (s) x0Var;
        if (sVar instanceof r) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) sVar.f10962a;
            FrameLayout frameLayout = navigationMenuItemView.U;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            navigationMenuItemView.T.setCompoundDrawables(null, null, null, null);
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
    public final void g() {
        boolean z2;
        if (this.f) {
            return;
        }
        this.f = true;
        ArrayList arrayList = this.f6894d;
        arrayList.clear();
        arrayList.add(new m());
        t tVar = this.f6896g;
        int size = tVar.f6903w.l().size();
        boolean z10 = false;
        int i = -1;
        int i10 = 0;
        boolean z11 = false;
        int size2 = 0;
        while (i10 < size) {
            m.m mVar = (m.m) tVar.f6903w.l().get(i10);
            if (mVar.isChecked()) {
                h(mVar);
            }
            if (mVar.isCheckable()) {
                mVar.f(z10);
            }
            if (mVar.hasSubMenu()) {
                m.c0 c0Var = mVar.f8242o;
                if (c0Var.hasVisibleItems()) {
                    if (i10 != 0) {
                        arrayList.add(new o(tVar.U, z10 ? 1 : 0));
                    }
                    arrayList.add(new p(mVar));
                    int size3 = c0Var.f.size();
                    int i11 = z10 ? 1 : 0;
                    int i12 = i11;
                    while (i11 < size3) {
                        m.m mVar2 = (m.m) c0Var.getItem(i11);
                        if (mVar2.isVisible()) {
                            if (i12 == 0 && mVar2.getIcon() != null) {
                                i12 = 1;
                            }
                            if (mVar2.isCheckable()) {
                                mVar2.f(z10);
                            }
                            if (mVar.isChecked()) {
                                h(mVar);
                            }
                            arrayList.add(new p(mVar2));
                        }
                        i11++;
                        z10 = false;
                    }
                    if (i12 != 0) {
                        int size4 = arrayList.size();
                        for (int size5 = arrayList.size(); size5 < size4; size5++) {
                            ((p) arrayList.get(size5)).f6900b = true;
                        }
                    }
                }
                z2 = true;
            } else {
                int i13 = mVar.f8231b;
                if (i13 != i) {
                    size2 = arrayList.size();
                    z11 = mVar.getIcon() != null;
                    if (i10 != 0) {
                        size2++;
                        int i14 = tVar.U;
                        arrayList.add(new o(i14, i14));
                    }
                } else {
                    if (!z11 && mVar.getIcon() != null) {
                        int size6 = arrayList.size();
                        for (int i15 = size2; i15 < size6; i15++) {
                            ((p) arrayList.get(i15)).f6900b = true;
                        }
                        z2 = true;
                        z11 = true;
                    }
                    p pVar = new p(mVar);
                    pVar.f6900b = z11;
                    arrayList.add(pVar);
                    i = i13;
                }
                z2 = true;
                p pVar2 = new p(mVar);
                pVar2.f6900b = z11;
                arrayList.add(pVar2);
                i = i13;
            }
            i10++;
            z10 = false;
        }
        this.f = z10 ? 1 : 0;
    }

    public final void h(m.m mVar) {
        if (this.f6895e == mVar || !mVar.isCheckable()) {
            return;
        }
        m.m mVar2 = this.f6895e;
        if (mVar2 != null) {
            mVar2.setChecked(false);
        }
        this.f6895e = mVar;
        mVar.setChecked(true);
    }
}
