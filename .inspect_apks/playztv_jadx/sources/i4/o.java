package i4;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o extends q4.x0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TextView f6240u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final View f6241v;

    public o(View view) {
        super(view);
        if (s1.b0.f11647a < 26) {
            view.setFocusable(true);
        }
        this.f6240u = (TextView) view.findViewById(h0.exo_text);
        this.f6241v = view.findViewById(h0.exo_check);
    }
}
