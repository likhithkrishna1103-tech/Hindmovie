package w6;

import c6.f;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import x6.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f13745c;

    public a(int i, f fVar) {
        this.f13744b = i;
        this.f13745c = fVar;
    }

    @Override // c6.f
    public final void b(MessageDigest messageDigest) {
        this.f13745c.b(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f13744b).array());
    }

    @Override // c6.f
    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f13744b == aVar.f13744b && this.f13745c.equals(aVar.f13745c)) {
                return true;
            }
        }
        return false;
    }

    @Override // c6.f
    public final int hashCode() {
        return m.h(this.f13744b, this.f13745c);
    }
}
