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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import m2.e;
import m4.h0;
import m4.j0;
import m4.s0;
import m4.t0;
import v1.g1;
import v1.h1;
import v1.m1;
import v5.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class TrackSelectionView extends LinearLayout {
    public final ArrayList A;
    public final HashMap B;
    public boolean C;
    public boolean D;
    public s0 E;
    public CheckedTextView[][] F;
    public boolean G;
    public s.a H;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f1315v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final LayoutInflater f1316w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CheckedTextView f1317x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final CheckedTextView f1318y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final l f1319z;

    public TrackSelectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setOrientation(1);
        setSaveFromParentEnabled(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.selectableItemBackground});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        this.f1315v = resourceId;
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.f1316w = layoutInflaterFrom;
        l lVar = new l(4, this);
        this.f1319z = lVar;
        this.E = new e(getResources());
        this.A = new ArrayList();
        this.B = new HashMap();
        CheckedTextView checkedTextView = (CheckedTextView) layoutInflaterFrom.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f1317x = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(j0.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(lVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(layoutInflaterFrom.inflate(h0.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) layoutInflaterFrom.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f1318y = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(j0.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(lVar);
        addView(checkedTextView2);
    }

    public static HashMap a(Map map, ArrayList arrayList, boolean z10) {
        HashMap map2 = new HashMap();
        for (int i = 0; i < arrayList.size(); i++) {
            h1 h1Var = (h1) map.get(((m1) arrayList.get(i)).f12873b);
            if (h1Var != null && (z10 || map2.isEmpty())) {
                map2.put(h1Var.f12711a, h1Var);
            }
        }
        return map2;
    }

    public final void b() {
        this.f1317x.setChecked(this.G);
        boolean z10 = this.G;
        HashMap map = this.B;
        this.f1318y.setChecked(!z10 && map.size() == 0);
        for (int i = 0; i < this.F.length; i++) {
            h1 h1Var = (h1) map.get(((m1) this.A.get(i)).f12873b);
            int i10 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.F[i];
                if (i10 < checkedTextViewArr.length) {
                    if (h1Var != null) {
                        Object tag = checkedTextViewArr[i10].getTag();
                        tag.getClass();
                        this.F[i][i10].setChecked(h1Var.f12712b.contains(Integer.valueOf(((t0) tag).f8265b)));
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
        ArrayList arrayList = this.A;
        boolean zIsEmpty = arrayList.isEmpty();
        CheckedTextView checkedTextView = this.f1318y;
        CheckedTextView checkedTextView2 = this.f1317x;
        if (zIsEmpty) {
            checkedTextView2.setEnabled(false);
            checkedTextView.setEnabled(false);
            return;
        }
        checkedTextView2.setEnabled(true);
        checkedTextView.setEnabled(true);
        this.F = new CheckedTextView[arrayList.size()][];
        boolean z10 = this.D && arrayList.size() > 1;
        for (int i = 0; i < arrayList.size(); i++) {
            m1 m1Var = (m1) arrayList.get(i);
            boolean z11 = this.C && m1Var.f12874c;
            CheckedTextView[][] checkedTextViewArr = this.F;
            int i10 = m1Var.f12872a;
            checkedTextViewArr[i] = new CheckedTextView[i10];
            t0[] t0VarArr = new t0[i10];
            for (int i11 = 0; i11 < m1Var.f12872a; i11++) {
                t0VarArr[i11] = new t0(m1Var, i11);
            }
            for (int i12 = 0; i12 < i10; i12++) {
                LayoutInflater layoutInflater = this.f1316w;
                if (i12 == 0) {
                    addView(layoutInflater.inflate(h0.exo_list_divider, (ViewGroup) this, false));
                }
                CheckedTextView checkedTextView3 = (CheckedTextView) layoutInflater.inflate((z11 || z10) ? R.layout.simple_list_item_multiple_choice : R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
                checkedTextView3.setBackgroundResource(this.f1315v);
                s0 s0Var = this.E;
                t0 t0Var = t0VarArr[i12];
                checkedTextView3.setText(((e) s0Var).t(t0Var.f8264a.f12873b.f12705d[t0Var.f8265b]));
                checkedTextView3.setTag(t0VarArr[i12]);
                checkedTextView3.setFocusable(true);
                checkedTextView3.setOnClickListener(this.f1319z);
                this.F[i][i12] = checkedTextView3;
                addView(checkedTextView3);
            }
        }
        b();
    }

    public boolean getIsDisabled() {
        return this.G;
    }

    public Map<g1, h1> getOverrides() {
        return this.B;
    }

    public void setAllowAdaptiveSelections(boolean z10) {
        if (this.C != z10) {
            this.C = z10;
            c();
        }
    }

    public void setAllowMultipleOverrides(boolean z10) {
        if (this.D != z10) {
            this.D = z10;
            if (!z10) {
                HashMap map = this.B;
                if (map.size() > 1) {
                    HashMap mapA = a(map, this.A, false);
                    map.clear();
                    map.putAll(mapA);
                }
            }
            c();
        }
    }

    public void setShowDisableOption(boolean z10) {
        this.f1317x.setVisibility(z10 ? 0 : 8);
    }

    public void setTrackNameProvider(s0 s0Var) {
        s0Var.getClass();
        this.E = s0Var;
        c();
    }
}
