package i4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m extends q4.x0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextView f6232u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final TextView f6233v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ImageView f6234w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ s f6235x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(s sVar, View view) {
        super(view);
        this.f6235x = sVar;
        if (s1.b0.f11647a < 26) {
            view.setFocusable(true);
        }
        this.f6232u = (TextView) view.findViewById(h0.exo_main_text);
        this.f6233v = (TextView) view.findViewById(h0.exo_sub_text);
        this.f6234w = (ImageView) view.findViewById(h0.exo_icon);
        view.setOnClickListener(new com.google.android.material.datepicker.n(4, this));
    }
}
