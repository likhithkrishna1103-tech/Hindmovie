package ka;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f7285b;

    public b(float f, d dVar) {
        while (dVar instanceof b) {
            dVar = ((b) dVar).f7284a;
            f += ((b) dVar).f7285b;
        }
        this.f7284a = dVar;
        this.f7285b = f;
    }

    @Override // ka.d
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.f7284a.a(rectF) + this.f7285b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f7284a.equals(bVar.f7284a) && this.f7285b == bVar.f7285b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7284a, Float.valueOf(this.f7285b)});
    }
}
