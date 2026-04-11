package m;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o extends FrameLayout implements l.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CollapsibleActionView f8256u;

    /* JADX WARN: Multi-variable type inference failed */
    public o(View view) {
        super(view.getContext());
        this.f8256u = (CollapsibleActionView) view;
        addView(view);
    }

    @Override // l.b
    public final void onActionViewCollapsed() {
        this.f8256u.onActionViewCollapsed();
    }

    @Override // l.b
    public final void onActionViewExpanded() {
        this.f8256u.onActionViewExpanded();
    }
}
