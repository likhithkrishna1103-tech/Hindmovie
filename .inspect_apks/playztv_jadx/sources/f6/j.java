package f6;

import android.graphics.Bitmap;
import x6.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f4779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bitmap.Config f4781c;

    public j(e eVar) {
        this.f4779a = eVar;
    }

    @Override // f6.h
    public final void a() {
        this.f4779a.e1(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (this.f4780b == jVar.f4780b && m.b(this.f4781c, jVar.f4781c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f4780b * 31;
        Bitmap.Config config = this.f4781c;
        return i + (config != null ? config.hashCode() : 0);
    }

    public final String toString() {
        return k.c(this.f4780b, this.f4781c);
    }
}
