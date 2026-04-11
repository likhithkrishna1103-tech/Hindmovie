package o;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k2 extends t1 {
    public final int H;
    public final int I;
    public h2 J;
    public n.m K;

    public k2(Context context, boolean z10) {
        super(context, z10);
        if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
            this.H = 21;
            this.I = 22;
        } else {
            this.H = 22;
            this.I = 21;
        }
    }

    @Override // o.t1, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        n.h hVar;
        int headersCount;
        int iPointToPosition;
        int i;
        if (this.J != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                hVar = (n.h) headerViewListAdapter.getWrappedAdapter();
            } else {
                hVar = (n.h) adapter;
                headersCount = 0;
            }
            n.m mVarB = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i = iPointToPosition - headersCount) < 0 || i >= hVar.getCount()) ? null : hVar.getItem(i);
            n.m mVar = this.K;
            if (mVar != mVarB) {
                n.k kVar = hVar.f8513v;
                if (mVar != null) {
                    this.J.g(kVar, mVar);
                }
                this.K = mVarB;
                if (mVarB != null) {
                    this.J.n(kVar, mVarB);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i == this.H) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i != this.I) {
            return super.onKeyDown(i, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (n.h) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (n.h) adapter).f8513v.c(false);
        return true;
    }

    public void setHoverListener(h2 h2Var) {
        this.J = h2Var;
    }

    @Override // o.t1, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
