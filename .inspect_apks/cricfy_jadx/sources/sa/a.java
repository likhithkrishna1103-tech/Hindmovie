package sa;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.transformation.ExpandableBehavior;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ View f11646v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f11647w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ aa.a f11648x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ ExpandableBehavior f11649y;

    public a(ExpandableBehavior expandableBehavior, View view, int i, aa.a aVar) {
        this.f11649y = expandableBehavior;
        this.f11646v = view;
        this.f11647w = i;
        this.f11648x = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View view = this.f11646v;
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        ExpandableBehavior expandableBehavior = this.f11649y;
        if (expandableBehavior.f3015v == this.f11647w) {
            Object obj = this.f11648x;
            expandableBehavior.w((View) obj, view, ((FloatingActionButton) obj).J.f374a, false);
        }
        return false;
    }
}
