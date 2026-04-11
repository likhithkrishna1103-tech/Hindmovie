package q9;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f11087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f11088b;

    public b(float f, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f11087a;
            f += ((b) cVar).f11088b;
        }
        this.f11087a = cVar;
        this.f11088b = f;
    }

    @Override // q9.c
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.f11087a.a(rectF) + this.f11088b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f11087a.equals(bVar.f11087a) && this.f11088b == bVar.f11088b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11087a, Float.valueOf(this.f11088b)});
    }
}
