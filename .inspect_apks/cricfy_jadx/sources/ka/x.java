package ka;

import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.navigation.NavigationView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f7386c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7384a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7385b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f7387d = new RectF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f7388e = new Path();

    public abstract void a(NavigationView navigationView);

    public abstract boolean b();

    public final void c() {
        m mVar;
        RectF rectF = this.f7387d;
        if (rectF.left > rectF.right || rectF.top > rectF.bottom || (mVar = this.f7386c) == null) {
            return;
        }
        n.f7360a.b(mVar, null, 1.0f, rectF, null, this.f7388e);
    }
}
