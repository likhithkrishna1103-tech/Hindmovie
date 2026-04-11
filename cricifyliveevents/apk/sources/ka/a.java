package ka;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f7283a;

    public a(float f) {
        this.f7283a = f;
    }

    @Override // ka.d
    public final float a(RectF rectF) {
        return this.f7283a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f7283a == ((a) obj).f7283a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f7283a)});
    }

    public final String toString() {
        return this.f7283a + "px";
    }
}
