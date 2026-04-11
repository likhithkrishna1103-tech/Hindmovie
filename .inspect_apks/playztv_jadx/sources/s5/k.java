package s5;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f11836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PointF f11837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11838c;

    public k(PointF pointF, boolean z2, List list) {
        this.f11837b = pointF;
        this.f11838c = z2;
        this.f11836a = new ArrayList(list);
    }

    public final void a(float f, float f4) {
        if (this.f11837b == null) {
            this.f11837b = new PointF();
        }
        this.f11837b.set(f, f4);
    }

    public final String toString() {
        return "ShapeData{numCurves=" + this.f11836a.size() + "closed=" + this.f11838c + '}';
    }

    public k() {
        this.f11836a = new ArrayList();
    }
}
