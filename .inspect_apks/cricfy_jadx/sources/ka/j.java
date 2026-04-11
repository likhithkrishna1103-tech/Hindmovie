package ka;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f7338a;

    public j(float f) {
        this.f7338a = f;
    }

    @Override // ka.d
    public final float a(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f7338a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && this.f7338a == ((j) obj).f7338a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f7338a)});
    }

    public final String toString() {
        return q4.a.o(new StringBuilder(), (int) (this.f7338a * 100.0f), "%");
    }
}
