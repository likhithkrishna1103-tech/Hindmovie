package e6;

import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t implements c6.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Class f4561e;
    public final Class f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c6.f f4562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f4563h;
    public final c6.i i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4564j;

    public t(Object obj, c6.f fVar, int i, int i10, Map map, Class cls, Class cls2, c6.i iVar) {
        x6.f.c(obj, "Argument must not be null");
        this.f4558b = obj;
        this.f4562g = fVar;
        this.f4559c = i;
        this.f4560d = i10;
        x6.f.c(map, "Argument must not be null");
        this.f4563h = map;
        x6.f.c(cls, "Resource class must not be null");
        this.f4561e = cls;
        x6.f.c(cls2, "Transcode class must not be null");
        this.f = cls2;
        x6.f.c(iVar, "Argument must not be null");
        this.i = iVar;
    }

    @Override // c6.f
    public final void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // c6.f
    public final boolean equals(Object obj) {
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (this.f4558b.equals(tVar.f4558b) && this.f4562g.equals(tVar.f4562g) && this.f4560d == tVar.f4560d && this.f4559c == tVar.f4559c && this.f4563h.equals(tVar.f4563h) && this.f4561e.equals(tVar.f4561e) && this.f.equals(tVar.f) && this.i.equals(tVar.i)) {
                return true;
            }
        }
        return false;
    }

    @Override // c6.f
    public final int hashCode() {
        if (this.f4564j == 0) {
            int iHashCode = this.f4558b.hashCode();
            this.f4564j = iHashCode;
            int iHashCode2 = ((((this.f4562g.hashCode() + (iHashCode * 31)) * 31) + this.f4559c) * 31) + this.f4560d;
            this.f4564j = iHashCode2;
            int iHashCode3 = this.f4563h.hashCode() + (iHashCode2 * 31);
            this.f4564j = iHashCode3;
            int iHashCode4 = this.f4561e.hashCode() + (iHashCode3 * 31);
            this.f4564j = iHashCode4;
            int iHashCode5 = this.f.hashCode() + (iHashCode4 * 31);
            this.f4564j = iHashCode5;
            this.f4564j = this.i.f2521b.hashCode() + (iHashCode5 * 31);
        }
        return this.f4564j;
    }

    public final String toString() {
        return "EngineKey{model=" + this.f4558b + ", width=" + this.f4559c + ", height=" + this.f4560d + ", resourceClass=" + this.f4561e + ", transcodeClass=" + this.f + ", signature=" + this.f4562g + ", hashCode=" + this.f4564j + ", transformations=" + this.f4563h + ", options=" + this.i + '}';
    }
}
