package k9;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.animation.PathInterpolator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimeInterpolator f7579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f7580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f7582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7583e;
    public c.c f;

    public a(View view) {
        this.f7580b = view;
        Context context = view.getContext();
        this.f7579a = b8.h.y(context, p8.b.motionEasingStandardDecelerateInterpolator, new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f));
        this.f7581c = b8.h.x(context, p8.b.motionDurationMedium2, 300);
        this.f7582d = b8.h.x(context, p8.b.motionDurationShort3, 150);
        this.f7583e = b8.h.x(context, p8.b.motionDurationShort2, 100);
    }
}
