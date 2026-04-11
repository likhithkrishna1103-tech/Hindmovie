package n;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends FrameLayout implements m.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CollapsibleActionView f8570v;

    /* JADX WARN: Multi-variable type inference failed */
    public o(View view) {
        super(view.getContext());
        this.f8570v = (CollapsibleActionView) view;
        addView(view);
    }

    @Override // m.b
    public final void onActionViewCollapsed() {
        this.f8570v.onActionViewCollapsed();
    }

    @Override // m.b
    public final void onActionViewExpanded() {
        this.f8570v.onActionViewExpanded();
    }
}
