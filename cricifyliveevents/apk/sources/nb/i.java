package nb;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n8.k f8944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f8945b;

    public i(n8.k kVar, tb.c cVar) {
        this.f8944a = kVar;
        this.f8945b = new h(cVar);
    }

    public final void a(String str) {
        h hVar = this.f8945b;
        synchronized (hVar) {
            if (!Objects.equals(hVar.f8942b, str)) {
                h.a(hVar.f8941a, str, hVar.f8943c);
                hVar.f8942b = str;
            }
        }
    }
}
