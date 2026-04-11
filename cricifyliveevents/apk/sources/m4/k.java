package m4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import v4.x0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends x0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextView f8179u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final TextView f8180v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ImageView f8181w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ q f8182x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(q qVar, View view) {
        super(view);
        this.f8182x = qVar;
        if (y1.a0.f14551a < 26) {
            view.setFocusable(true);
        }
        this.f8179u = (TextView) view.findViewById(f0.exo_main_text);
        this.f8180v = (TextView) view.findViewById(f0.exo_sub_text);
        this.f8181w = (ImageView) view.findViewById(f0.exo_icon);
        view.setOnClickListener(new com.google.android.material.datepicker.n(3, this));
    }
}
