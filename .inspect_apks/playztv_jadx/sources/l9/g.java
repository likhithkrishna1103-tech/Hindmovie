package l9;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import j9.c0;
import java.util.HashSet;
import java.util.WeakHashMap;
import m.y;
import n.a1;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class g extends ViewGroup implements y {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int[] f8038c0 = {R.attr.state_checked};

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int[] f8039d0 = {-16842910};
    public int A;
    public int B;
    public ColorStateList C;
    public int D;
    public ColorStateList E;
    public final ColorStateList F;
    public int G;
    public int H;
    public boolean I;
    public Drawable J;
    public ColorStateList K;
    public int L;
    public final SparseArray M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public int R;
    public int S;
    public int T;
    public q9.k U;
    public boolean V;
    public ColorStateList W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public i f8040a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public m.k f8041b0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final g5.a f8042u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.google.android.material.datepicker.l f8043v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final p0.e f8044w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final SparseArray f8045x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f8046y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public e[] f8047z;

    public g(Context context) {
        super(context);
        int i = 5;
        this.f8044w = new p0.e(5);
        this.f8045x = new SparseArray(5);
        this.A = 0;
        this.B = 0;
        this.M = new SparseArray(5);
        this.N = -1;
        this.O = -1;
        this.P = -1;
        this.V = false;
        this.F = c();
        if (isInEditMode()) {
            this.f8042u = null;
        } else {
            g5.a aVar = new g5.a();
            this.f8042u = aVar;
            aVar.L(0);
            aVar.A(b8.h.x(getContext(), p8.b.motionDurationMedium4, getResources().getInteger(p8.g.material_motion_duration_long_1)));
            aVar.C(b8.h.y(getContext(), p8.b.motionEasingStandard, q8.a.f11073b));
            aVar.I(new c0());
        }
        this.f8043v = new com.google.android.material.datepicker.l(i, (v8.b) this);
        WeakHashMap weakHashMap = o0.f10475a;
        setImportantForAccessibility(1);
    }

    private e getNewItem() {
        e eVar = (e) this.f8044w.i();
        return eVar == null ? new v8.a(getContext()) : eVar;
    }

    private void setBadgeIfNeeded(e eVar) {
        s8.a aVar;
        int id2 = eVar.getId();
        if (id2 == -1 || (aVar = (s8.a) this.M.get(id2)) == null) {
            return;
        }
        eVar.setBadge(aVar);
    }

    public final void a() {
        removeAllViews();
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                if (eVar != null) {
                    this.f8044w.b(eVar);
                    ImageView imageView = eVar.H;
                    if (eVar.f8030c0 != null) {
                        if (imageView != null) {
                            eVar.setClipChildren(true);
                            eVar.setClipToPadding(true);
                            s8.a aVar = eVar.f8030c0;
                            if (aVar != null) {
                                if (aVar.d() != null) {
                                    aVar.d().setForeground(null);
                                } else {
                                    imageView.getOverlay().remove(aVar);
                                }
                            }
                        }
                        eVar.f8030c0 = null;
                    }
                    eVar.N = null;
                    eVar.T = 0.0f;
                    eVar.f8031u = false;
                }
            }
        }
        if (this.f8041b0.f.size() == 0) {
            this.A = 0;
            this.B = 0;
            this.f8047z = null;
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < this.f8041b0.f.size(); i++) {
            hashSet.add(Integer.valueOf(this.f8041b0.getItem(i).getItemId()));
        }
        int i10 = 0;
        while (true) {
            SparseArray sparseArray = this.M;
            if (i10 >= sparseArray.size()) {
                break;
            }
            int iKeyAt = sparseArray.keyAt(i10);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                sparseArray.delete(iKeyAt);
            }
            i10++;
        }
        this.f8047z = new e[this.f8041b0.f.size()];
        int i11 = this.f8046y;
        boolean z2 = i11 != -1 ? i11 == 0 : this.f8041b0.l().size() > 3;
        for (int i12 = 0; i12 < this.f8041b0.f.size(); i12++) {
            this.f8040a0.f8051v = true;
            this.f8041b0.getItem(i12).setCheckable(true);
            this.f8040a0.f8051v = false;
            e newItem = getNewItem();
            this.f8047z[i12] = newItem;
            newItem.setIconTintList(this.C);
            newItem.setIconSize(this.D);
            newItem.setTextColor(this.F);
            newItem.setTextAppearanceInactive(this.G);
            newItem.setTextAppearanceActive(this.H);
            newItem.setTextAppearanceActiveBoldEnabled(this.I);
            newItem.setTextColor(this.E);
            int i13 = this.N;
            if (i13 != -1) {
                newItem.setItemPaddingTop(i13);
            }
            int i14 = this.O;
            if (i14 != -1) {
                newItem.setItemPaddingBottom(i14);
            }
            int i15 = this.P;
            if (i15 != -1) {
                newItem.setActiveIndicatorLabelPadding(i15);
            }
            newItem.setActiveIndicatorWidth(this.R);
            newItem.setActiveIndicatorHeight(this.S);
            newItem.setActiveIndicatorMarginHorizontal(this.T);
            newItem.setActiveIndicatorDrawable(d());
            newItem.setActiveIndicatorResizeable(this.V);
            newItem.setActiveIndicatorEnabled(this.Q);
            Drawable drawable = this.J;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.L);
            }
            newItem.setItemRippleColor(this.K);
            newItem.setShifting(z2);
            newItem.setLabelVisibilityMode(this.f8046y);
            m.m mVar = (m.m) this.f8041b0.getItem(i12);
            newItem.a(mVar);
            newItem.setItemPosition(i12);
            int i16 = mVar.f8230a;
            newItem.setOnTouchListener((View.OnTouchListener) this.f8045x.get(i16));
            newItem.setOnClickListener(this.f8043v);
            int i17 = this.A;
            if (i17 != 0 && i16 == i17) {
                this.B = i12;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int iMin = Math.min(this.f8041b0.f.size() - 1, this.B);
        this.B = iMin;
        this.f8041b0.getItem(iMin).setChecked(true);
    }

    @Override // m.y
    public final void b(m.k kVar) {
        this.f8041b0 = kVar;
    }

    public final ColorStateList c() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.textColorSecondary, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListC = f0.c.c(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(g.a.colorPrimary, typedValue, true)) {
            return null;
        }
        int i = typedValue.data;
        int defaultColor = colorStateListC.getDefaultColor();
        int[] iArr = f8039d0;
        return new ColorStateList(new int[][]{iArr, f8038c0, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateListC.getColorForState(iArr, defaultColor), i, defaultColor});
    }

    public final q9.g d() {
        if (this.U == null || this.W == null) {
            return null;
        }
        q9.g gVar = new q9.g(this.U);
        gVar.l(this.W);
        return gVar;
    }

    public int getActiveIndicatorLabelPadding() {
        return this.P;
    }

    public SparseArray<s8.a> getBadgeDrawables() {
        return this.M;
    }

    public ColorStateList getIconTintList() {
        return this.C;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.W;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.Q;
    }

    public int getItemActiveIndicatorHeight() {
        return this.S;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.T;
    }

    public q9.k getItemActiveIndicatorShapeAppearance() {
        return this.U;
    }

    public int getItemActiveIndicatorWidth() {
        return this.R;
    }

    public Drawable getItemBackground() {
        e[] eVarArr = this.f8047z;
        return (eVarArr == null || eVarArr.length <= 0) ? this.J : eVarArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.L;
    }

    public int getItemIconSize() {
        return this.D;
    }

    public int getItemPaddingBottom() {
        return this.O;
    }

    public int getItemPaddingTop() {
        return this.N;
    }

    public ColorStateList getItemRippleColor() {
        return this.K;
    }

    public int getItemTextAppearanceActive() {
        return this.H;
    }

    public int getItemTextAppearanceInactive() {
        return this.G;
    }

    public ColorStateList getItemTextColor() {
        return this.E;
    }

    public int getLabelVisibilityMode() {
        return this.f8046y;
    }

    public m.k getMenu() {
        return this.f8041b0;
    }

    public int getSelectedItemId() {
        return this.A;
    }

    public int getSelectedItemPosition() {
        return this.B;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) a1.x(1, this.f8041b0.l().size(), 1).f8343u);
    }

    public void setActiveIndicatorLabelPadding(int i) {
        this.P = i;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setActiveIndicatorLabelPadding(i);
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.C = colorStateList;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.W = colorStateList;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setActiveIndicatorDrawable(d());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z2) {
        this.Q = z2;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setActiveIndicatorEnabled(z2);
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i) {
        this.S = i;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setActiveIndicatorHeight(i);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i) {
        this.T = i;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setActiveIndicatorMarginHorizontal(i);
            }
        }
    }

    public void setItemActiveIndicatorResizeable(boolean z2) {
        this.V = z2;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setActiveIndicatorResizeable(z2);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(q9.k kVar) {
        this.U = kVar;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setActiveIndicatorDrawable(d());
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i) {
        this.R = i;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setActiveIndicatorWidth(i);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.J = drawable;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i) {
        this.L = i;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setItemBackground(i);
            }
        }
    }

    public void setItemIconSize(int i) {
        this.D = i;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setIconSize(i);
            }
        }
    }

    public void setItemPaddingBottom(int i) {
        this.O = i;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setItemPaddingBottom(i);
            }
        }
    }

    public void setItemPaddingTop(int i) {
        this.N = i;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setItemPaddingTop(i);
            }
        }
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.K = colorStateList;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setItemRippleColor(colorStateList);
            }
        }
    }

    public void setItemTextAppearanceActive(int i) {
        this.H = i;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setTextAppearanceActive(i);
                ColorStateList colorStateList = this.E;
                if (colorStateList != null) {
                    eVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z2) {
        this.I = z2;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setTextAppearanceActiveBoldEnabled(z2);
            }
        }
    }

    public void setItemTextAppearanceInactive(int i) {
        this.G = i;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setTextAppearanceInactive(i);
                ColorStateList colorStateList = this.E;
                if (colorStateList != null) {
                    eVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.E = colorStateList;
        e[] eVarArr = this.f8047z;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i) {
        this.f8046y = i;
    }

    public void setPresenter(i iVar) {
        this.f8040a0 = iVar;
    }
}
