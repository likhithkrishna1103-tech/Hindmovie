package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import kc.b;
import m.j;
import m.k;
import m.m;
import m.y;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements j, y, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int[] f858v = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public k f859u;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        b bVarD = b.D(context, attributeSet, f858v, R.attr.listViewStyle);
        TypedArray typedArray = (TypedArray) bVarD.f7621w;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(bVarD.s(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(bVarD.s(1));
        }
        bVarD.E();
    }

    @Override // m.y
    public final void b(k kVar) {
        this.f859u = kVar;
    }

    @Override // m.j
    public final boolean c(m mVar) {
        return this.f859u.q(mVar, null, 0);
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
    public final void onItemClick(AdapterView adapterView, View view, int i, long j5) {
        c((m) getAdapter().getItem(i));
    }
}
