package ea;

import android.content.Context;
import android.view.View;
import android.view.animation.PathInterpolator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PathInterpolator f3852a = new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f3853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3856e;
    public c.c f;

    public a(View view) {
        this.f3853b = view;
        Context context = view.getContext();
        this.f3854c = sd.i.C(context, k9.b.motionDurationMedium2, 300);
        this.f3855d = sd.i.C(context, k9.b.motionDurationShort3, 150);
        this.f3856e = sd.i.C(context, k9.b.motionDurationShort2, 100);
    }
}
