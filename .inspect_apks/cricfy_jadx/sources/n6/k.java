package n6;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f8820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PointF f8821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8822c;

    public k(PointF pointF, boolean z10, List list) {
        this.f8821b = pointF;
        this.f8822c = z10;
        this.f8820a = new ArrayList(list);
    }

    public final void a(float f, float f10) {
        if (this.f8821b == null) {
            this.f8821b = new PointF();
        }
        this.f8821b.set(f, f10);
    }

    public final String toString() {
        return "ShapeData{numCurves=" + this.f8820a.size() + "closed=" + this.f8822c + '}';
    }

    public k() {
        this.f8820a = new ArrayList();
    }
}
