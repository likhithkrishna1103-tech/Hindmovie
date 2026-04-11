package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import l7.a;
import n.j;
import n.k;
import n.m;
import n.y;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements j, y, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int[] f518w = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public k f519v;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        a aVarF = a.F(context, attributeSet, f518w, R.attr.listViewStyle);
        TypedArray typedArray = (TypedArray) aVarF.f7867x;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(aVarF.u(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(aVarF.u(1));
        }
        aVarF.G();
    }

    @Override // n.y
    public final void b(k kVar) {
        this.f519v = kVar;
    }

    @Override // n.j
    public final boolean c(m mVar) {
        return this.f519v.q(mVar, null, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j4) {
        c((m) getAdapter().getItem(i));
    }
}
