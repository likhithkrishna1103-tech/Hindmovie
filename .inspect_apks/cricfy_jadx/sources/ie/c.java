package ie;

import ge.i;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b f6450w = new b(0);

    @Override // ie.a
    public final Random a() {
        Object obj = this.f6450w.get();
        i.d(obj, "get(...)");
        return (Random) obj;
    }
}
