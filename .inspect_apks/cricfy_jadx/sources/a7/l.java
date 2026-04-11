package a7;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap.Config f330c;

    public l(f fVar) {
        this.f328a = fVar;
    }

    @Override // a7.j
    public final void a() {
        this.f328a.e1(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.f329b == lVar.f329b && s7.m.b(this.f330c, lVar.f330c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f329b * 31;
        Bitmap.Config config = this.f330c;
        return i + (config != null ? config.hashCode() : 0);
    }

    public final String toString() {
        return m.c(this.f329b, this.f330c);
    }
}
