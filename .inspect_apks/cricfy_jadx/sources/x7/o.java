package x7;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements u7.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f14446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f14447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f14448c;

    public o(Set set, i iVar, p pVar) {
        this.f14446a = set;
        this.f14447b = iVar;
        this.f14448c = pVar;
    }

    public final dd.c a(String str, u7.c cVar, u7.e eVar) {
        Set set = this.f14446a;
        if (set.contains(cVar)) {
            return new dd.c(this.f14447b, str, cVar, eVar, this.f14448c, 16);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", cVar, set));
    }
}
