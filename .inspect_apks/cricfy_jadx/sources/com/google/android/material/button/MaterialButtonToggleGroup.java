package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import com.google.android.material.datepicker.j;
import com.google.android.material.timepicker.i;
import da.d0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import k9.b;
import k9.k;
import k9.l;
import ka.b0;
import t0.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialButtonToggleGroup extends a {
    public static final int M = k.Widget_MaterialComponents_MaterialButtonToggleGroup;
    public final LinkedHashSet G;
    public boolean H;
    public boolean I;
    public boolean J;
    public final int K;
    public HashSet L;

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        int i = b.materialButtonToggleGroupStyle;
        int i10 = M;
        super(ra.a.a(context, attributeSet, i, i10), attributeSet, i);
        this.G = new LinkedHashSet();
        this.H = false;
        this.L = new HashSet();
        TypedArray typedArrayD = d0.d(getContext(), attributeSet, l.MaterialButtonToggleGroup, i, i10, new int[0]);
        setSingleSelection(typedArrayD.getBoolean(l.MaterialButtonToggleGroup_singleSelection, false));
        this.K = typedArrayD.getResourceId(l.MaterialButtonToggleGroup_checkedButton, -1);
        this.J = typedArrayD.getBoolean(l.MaterialButtonToggleGroup_selectionRequired, false);
        if (this.A == null) {
            this.A = b0.b(new ka.a(0.0f));
        }
        setEnabled(typedArrayD.getBoolean(l.MaterialButtonToggleGroup_android_enabled, true));
        typedArrayD.recycle();
        setImportantForAccessibility(1);
    }

    private String getChildrenA11yClassName() {
        return (this.I ? RadioButton.class : ToggleButton.class).getName();
    }

    private int getVisibleButtonCount() {
        int i = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if ((getChildAt(i10) instanceof MaterialButton) && getChildAt(i10).getVisibility() != 8) {
                i++;
            }
        }
        return i;
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setA11yClassName(getChildrenA11yClassName());
    }

    @Override // com.google.android.material.button.a, android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setupButtonChild(materialButton);
        f(materialButton.getId(), materialButton.J);
        m0.n(materialButton, new j(4, this));
    }

    public final void f(int i, boolean z10) {
        if (i == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i);
            return;
        }
        HashSet hashSet = new HashSet(this.L);
        if (z10 && !hashSet.contains(Integer.valueOf(i))) {
            if (this.I && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i));
        } else {
            if (z10 || !hashSet.contains(Integer.valueOf(i))) {
                return;
            }
            if (!this.J || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i));
            }
        }
        g(hashSet);
    }

    public final void g(Set set) {
        HashSet hashSet = this.L;
        this.L = new HashSet(set);
        for (int i = 0; i < getChildCount(); i++) {
            int id2 = ((MaterialButton) getChildAt(i)).getId();
            boolean zContains = set.contains(Integer.valueOf(id2));
            View viewFindViewById = findViewById(id2);
            if (viewFindViewById instanceof MaterialButton) {
                this.H = true;
                ((MaterialButton) viewFindViewById).setChecked(zContains);
                this.H = false;
            }
            if (hashSet.contains(Integer.valueOf(id2)) != set.contains(Integer.valueOf(id2))) {
                set.contains(Integer.valueOf(id2));
                Iterator it = this.G.iterator();
                while (it.hasNext()) {
                    ((i) it.next()).a();
                }
            }
        }
        invalidate();
    }

    public int getCheckedButtonId() {
        if (!this.I || this.L.isEmpty()) {
            return -1;
        }
        return ((Integer) this.L.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            int id2 = ((MaterialButton) getChildAt(i)).getId();
            if (this.L.contains(Integer.valueOf(id2))) {
                arrayList.add(Integer.valueOf(id2));
            }
        }
        return arrayList;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i = this.K;
        if (i != -1) {
            g(Collections.singleton(Integer.valueOf(i)));
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getVisibleButtonCount(), false, this.I ? 1 : 2));
    }

    public void setSelectionRequired(boolean z10) {
        this.J = z10;
    }

    public void setSingleSelection(boolean z10) {
        if (this.I != z10) {
            this.I = z10;
            g(new HashSet());
        }
        String childrenA11yClassName = getChildrenA11yClassName();
        for (int i = 0; i < getChildCount(); i++) {
            ((MaterialButton) getChildAt(i)).setA11yClassName(childrenA11yClassName);
        }
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }
}
