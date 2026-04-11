package q9;

import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.navigation.NavigationView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f11159c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11157a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11158b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f11160d = new RectF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f11161e = new Path();

    public abstract void a(NavigationView navigationView);

    public abstract boolean b();

    public final void c() {
        k kVar;
        RectF rectF = this.f11160d;
        if (rectF.left > rectF.right || rectF.top > rectF.bottom || (kVar = this.f11159c) == null) {
            return;
        }
        l.f11133a.b(kVar, 1.0f, rectF, null, this.f11161e);
    }
}
