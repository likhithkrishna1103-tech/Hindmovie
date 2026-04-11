package androidx.media3.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import com.google.android.material.datepicker.l;
import i4.e;
import i4.j0;
import i4.l0;
import i4.v0;
import i4.w0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lc.n;
import p1.g1;
import p1.h1;
import p1.m1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class TrackSelectionView extends LinearLayout {
    public final HashMap A;
    public boolean B;
    public boolean C;
    public v0 D;
    public CheckedTextView[][] E;
    public boolean F;
    public n.a G;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f1623u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final LayoutInflater f1624v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CheckedTextView f1625w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CheckedTextView f1626x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final l f1627y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ArrayList f1628z;

    public TrackSelectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setOrientation(1);
        setSaveFromParentEnabled(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.selectableItemBackground});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        this.f1623u = resourceId;
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.f1624v = layoutInflaterFrom;
        l lVar = new l(3, this);
        this.f1627y = lVar;
        this.D = new e(getResources(), 0);
        this.f1628z = new ArrayList();
        this.A = new HashMap();
        CheckedTextView checkedTextView = (CheckedTextView) layoutInflaterFrom.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f1625w = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(l0.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(lVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(layoutInflaterFrom.inflate(j0.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) layoutInflaterFrom.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f1626x = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(l0.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(lVar);
        addView(checkedTextView2);
    }

    public static HashMap a(Map map, ArrayList arrayList, boolean z2) {
        HashMap map2 = new HashMap();
        for (int i = 0; i < arrayList.size(); i++) {
            h1 h1Var = (h1) map.get(((m1) arrayList.get(i)).f9944b);
            if (h1Var != null && (z2 || map2.isEmpty())) {
                map2.put(h1Var.f9783a, h1Var);
            }
        }
        return map2;
    }

    public final void b() {
        this.f1625w.setChecked(this.F);
        boolean z2 = this.F;
        HashMap map = this.A;
        this.f1626x.setChecked(!z2 && map.size() == 0);
        for (int i = 0; i < this.E.length; i++) {
            h1 h1Var = (h1) map.get(((m1) this.f1628z.get(i)).f9944b);
            int i10 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.E[i];
                if (i10 < checkedTextViewArr.length) {
                    if (h1Var != null) {
                        Object tag = checkedTextViewArr[i10].getTag();
                        tag.getClass();
                        this.E[i][i10].setChecked(h1Var.f9784b.contains(Integer.valueOf(((w0) tag).f6324b)));
                    } else {
                        checkedTextViewArr[i10].setChecked(false);
                    }
                    i10++;
                }
            }
        }
    }

    public final void c() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        ArrayList arrayList = this.f1628z;
        boolean zIsEmpty = arrayList.isEmpty();
        CheckedTextView checkedTextView = this.f1626x;
        CheckedTextView checkedTextView2 = this.f1625w;
        if (zIsEmpty) {
            checkedTextView2.setEnabled(false);
            checkedTextView.setEnabled(false);
            return;
        }
        checkedTextView2.setEnabled(true);
        checkedTextView.setEnabled(true);
        this.E = new CheckedTextView[arrayList.size()][];
        boolean z2 = this.C && arrayList.size() > 1;
        for (int i = 0; i < arrayList.size(); i++) {
            m1 m1Var = (m1) arrayList.get(i);
            boolean z10 = this.B && m1Var.f9945c;
            CheckedTextView[][] checkedTextViewArr = this.E;
            int i10 = m1Var.f9943a;
            checkedTextViewArr[i] = new CheckedTextView[i10];
            w0[] w0VarArr = new w0[i10];
            for (int i11 = 0; i11 < m1Var.f9943a; i11++) {
                w0VarArr[i11] = new w0(m1Var, i11);
            }
            for (int i12 = 0; i12 < i10; i12++) {
                LayoutInflater layoutInflater = this.f1624v;
                if (i12 == 0) {
                    addView(layoutInflater.inflate(j0.exo_list_divider, (ViewGroup) this, false));
                }
                CheckedTextView checkedTextView3 = (CheckedTextView) layoutInflater.inflate((z10 || z2) ? R.layout.simple_list_item_multiple_choice : R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
                checkedTextView3.setBackgroundResource(this.f1623u);
                v0 v0Var = this.D;
                w0 w0Var = w0VarArr[i12];
                checkedTextView3.setText(((e) v0Var).c(w0Var.f6323a.f9944b.f9765d[w0Var.f6324b]));
                checkedTextView3.setTag(w0VarArr[i12]);
                checkedTextView3.setFocusable(true);
                checkedTextView3.setOnClickListener(this.f1627y);
                this.E[i][i12] = checkedTextView3;
                addView(checkedTextView3);
            }
        }
        b();
    }

    public boolean getIsDisabled() {
        return this.F;
    }

    public Map<g1, h1> getOverrides() {
        return this.A;
    }

    public void setAllowAdaptiveSelections(boolean z2) {
        if (this.B != z2) {
            this.B = z2;
            c();
        }
    }

    public void setAllowMultipleOverrides(boolean z2) {
        if (this.C != z2) {
            this.C = z2;
            if (!z2) {
                HashMap map = this.A;
                if (map.size() > 1) {
                    HashMap mapA = a(map, this.f1628z, false);
                    map.clear();
                    map.putAll(mapA);
                }
            }
            c();
        }
    }

    public void setShowDisableOption(boolean z2) {
        this.f1625w.setVisibility(z2 ? 0 : 8);
    }

    public void setTrackNameProvider(v0 v0Var) {
        v0Var.getClass();
        this.D = v0Var;
        c();
    }
}
