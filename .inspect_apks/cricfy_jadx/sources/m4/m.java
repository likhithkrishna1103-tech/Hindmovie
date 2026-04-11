package m4;

import android.view.View;
import android.widget.TextView;
import v4.x0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends x0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextView f8187u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final View f8188v;

    public m(View view) {
        super(view);
        if (y1.a0.f14551a < 26) {
            view.setFocusable(true);
        }
        this.f8187u = (TextView) view.findViewById(f0.exo_text);
        this.f8188v = view.findViewById(f0.exo_check);
    }
}
