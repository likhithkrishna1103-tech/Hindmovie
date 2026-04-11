package ic;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import q4.x0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends x0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final LinearLayout f6511u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ImageView f6512v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final WebView f6513w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ k f6514x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(k kVar, View view) {
        super(view);
        this.f6514x = kVar;
        this.f6511u = (LinearLayout) view.findViewById(gc.j.banner_layout);
        this.f6512v = (ImageView) view.findViewById(gc.j.banner_img);
        this.f6513w = (WebView) view.findViewById(gc.j.banner_web);
    }
}
