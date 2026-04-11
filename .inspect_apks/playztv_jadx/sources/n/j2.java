package n;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j2 extends t1 {
    public final int G;
    public final int H;
    public g2 I;
    public m.m J;

    public j2(Context context, boolean z2) {
        super(context, z2);
        if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
            this.G = 21;
            this.H = 22;
        } else {
            this.G = 22;
            this.H = 21;
        }
    }

    @Override // n.t1, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        m.h hVar;
        int headersCount;
        int iPointToPosition;
        int i;
        if (this.I != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                hVar = (m.h) headerViewListAdapter.getWrappedAdapter();
            } else {
                hVar = (m.h) adapter;
                headersCount = 0;
            }
            m.m mVarB = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i = iPointToPosition - headersCount) < 0 || i >= hVar.getCount()) ? null : hVar.getItem(i);
            m.m mVar = this.J;
            if (mVar != mVarB) {
                m.k kVar = hVar.f8198u;
                if (mVar != null) {
                    this.I.B(kVar, mVar);
                }
                this.J = mVarB;
                if (mVarB != null) {
                    this.I.h(kVar, mVarB);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i == this.G) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i != this.H) {
            return super.onKeyDown(i, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (m.h) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (m.h) adapter).f8198u.c(false);
        return true;
    }

    public void setHoverListener(g2 g2Var) {
        this.I = g2Var;
    }

    @Override // n.t1, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
