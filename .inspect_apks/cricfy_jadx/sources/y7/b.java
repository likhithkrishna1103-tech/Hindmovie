package y7;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g8.a f14967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g8.a f14968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f14969d;

    public b(Context context, g8.a aVar, g8.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f14966a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f14967b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f14968c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f14969d = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            b bVar = (b) ((c) obj);
            if (this.f14966a.equals(bVar.f14966a) && this.f14967b.equals(bVar.f14967b) && this.f14968c.equals(bVar.f14968c) && this.f14969d.equals(bVar.f14969d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f14966a.hashCode() ^ 1000003) * 1000003) ^ this.f14967b.hashCode()) * 1000003) ^ this.f14968c.hashCode()) * 1000003) ^ this.f14969d.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CreationContext{applicationContext=");
        sb.append(this.f14966a);
        sb.append(", wallClock=");
        sb.append(this.f14967b);
        sb.append(", monotonicClock=");
        sb.append(this.f14968c);
        sb.append(", backendName=");
        return q4.a.q(sb, this.f14969d, "}");
    }
}
