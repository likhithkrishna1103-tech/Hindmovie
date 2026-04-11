package z6;

import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements x6.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f15310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f15312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Class f15313e;
    public final Class f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x6.e f15314g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f15315h;
    public final x6.h i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f15316j;

    public t(Object obj, x6.e eVar, int i, int i10, Map map, Class cls, Class cls2, x6.h hVar) {
        s7.f.c(obj, "Argument must not be null");
        this.f15310b = obj;
        this.f15314g = eVar;
        this.f15311c = i;
        this.f15312d = i10;
        s7.f.c(map, "Argument must not be null");
        this.f15315h = map;
        s7.f.c(cls, "Resource class must not be null");
        this.f15313e = cls;
        s7.f.c(cls2, "Transcode class must not be null");
        this.f = cls2;
        s7.f.c(hVar, "Argument must not be null");
        this.i = hVar;
    }

    @Override // x6.e
    public final void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // x6.e
    public final boolean equals(Object obj) {
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (this.f15310b.equals(tVar.f15310b) && this.f15314g.equals(tVar.f15314g) && this.f15312d == tVar.f15312d && this.f15311c == tVar.f15311c && this.f15315h.equals(tVar.f15315h) && this.f15313e.equals(tVar.f15313e) && this.f.equals(tVar.f) && this.i.equals(tVar.i)) {
                return true;
            }
        }
        return false;
    }

    @Override // x6.e
    public final int hashCode() {
        if (this.f15316j == 0) {
            int iHashCode = this.f15310b.hashCode();
            this.f15316j = iHashCode;
            int iHashCode2 = ((((this.f15314g.hashCode() + (iHashCode * 31)) * 31) + this.f15311c) * 31) + this.f15312d;
            this.f15316j = iHashCode2;
            int iHashCode3 = this.f15315h.hashCode() + (iHashCode2 * 31);
            this.f15316j = iHashCode3;
            int iHashCode4 = this.f15313e.hashCode() + (iHashCode3 * 31);
            this.f15316j = iHashCode4;
            int iHashCode5 = this.f.hashCode() + (iHashCode4 * 31);
            this.f15316j = iHashCode5;
            this.f15316j = this.i.f14403b.hashCode() + (iHashCode5 * 31);
        }
        return this.f15316j;
    }

    public final String toString() {
        return "EngineKey{model=" + this.f15310b + ", width=" + this.f15311c + ", height=" + this.f15312d + ", resourceClass=" + this.f15313e + ", transcodeClass=" + this.f + ", signature=" + this.f15314g + ", hashCode=" + this.f15316j + ", transformations=" + this.f15315h + ", options=" + this.i + '}';
    }
}
