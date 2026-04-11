package s5;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import v4.x0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends x0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final LinearLayout f11486u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ImageView f11487v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final WebView f11488w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ i f11489x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(i iVar, View view) {
        super(view);
        this.f11489x = iVar;
        this.f11486u = (LinearLayout) view.findViewById(q5.k.banner_layout);
        this.f11487v = (ImageView) view.findViewById(q5.k.banner_img);
        this.f11488w = (WebView) view.findViewById(q5.k.banner_web);
    }
}
